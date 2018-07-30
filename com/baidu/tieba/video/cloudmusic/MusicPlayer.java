package com.baidu.tieba.video.cloudmusic;

import android.media.MediaPlayer;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import java.io.IOException;
/* loaded from: classes2.dex */
public class MusicPlayer {
    private static MusicPlayer hcG = null;
    private MediaPlayer hcF;
    private MusicPlayerState hcH = MusicPlayerState.WAIT;

    /* loaded from: classes2.dex */
    public enum MusicPlayerState {
        WAIT,
        PAUSE,
        PREPARED,
        REPLAY,
        RESUME,
        ERROR
    }

    /* loaded from: classes2.dex */
    public interface a {
        void bAs();
    }

    private MusicPlayer() {
    }

    public static synchronized MusicPlayer bAu() {
        MusicPlayer musicPlayer;
        synchronized (MusicPlayer.class) {
            if (hcG == null) {
                hcG = new MusicPlayer();
            }
            musicPlayer = hcG;
        }
        return musicPlayer;
    }

    public void a(String str, final CloudMusicData.MusicTagList.MusicList musicList, a aVar) {
        if (this.hcH != MusicPlayerState.PAUSE) {
            if (this.hcF == null) {
                this.hcF = new MediaPlayer();
                this.hcF.setAudioStreamType(3);
            }
            try {
                this.hcF.reset();
                this.hcF.setDataSource(str);
                this.hcF.prepare();
                this.hcH = MusicPlayerState.WAIT;
                this.hcF.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.cloudmusic.MusicPlayer.1
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        com.baidu.tieba.video.cloudmusic.data.a.bAx().a(musicList);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921307));
                        MusicPlayer.this.hcF.setLooping(true);
                        MusicPlayer.this.hcF.start();
                        MusicPlayer.this.hcH = MusicPlayerState.PREPARED;
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
                this.hcH = MusicPlayerState.ERROR;
                if (aVar != null) {
                    aVar.bAs();
                }
            }
        }
    }

    public void bAv() {
        if (this.hcF != null && this.hcF.isPlaying()) {
            this.hcF.pause();
        }
        this.hcH = MusicPlayerState.PAUSE;
    }

    public void bAw() {
        if (this.hcF != null) {
            this.hcF.start();
            this.hcF.seekTo(0);
        }
        this.hcH = MusicPlayerState.RESUME;
    }

    public void bkr() {
        if (this.hcF != null) {
            if (this.hcF.isPlaying()) {
                this.hcF.stop();
            }
            this.hcF.release();
            this.hcF = null;
        }
    }
}
