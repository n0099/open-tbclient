package com.baidu.tieba.video.cloudmusic;

import android.media.MediaPlayer;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import java.io.IOException;
/* loaded from: classes2.dex */
public class MusicPlayer {
    private static MusicPlayer hcH = null;
    private MediaPlayer hcG;
    private MusicPlayerState hcI = MusicPlayerState.WAIT;

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
        void bAu();
    }

    private MusicPlayer() {
    }

    public static synchronized MusicPlayer bAw() {
        MusicPlayer musicPlayer;
        synchronized (MusicPlayer.class) {
            if (hcH == null) {
                hcH = new MusicPlayer();
            }
            musicPlayer = hcH;
        }
        return musicPlayer;
    }

    public void a(String str, final CloudMusicData.MusicTagList.MusicList musicList, a aVar) {
        if (this.hcI != MusicPlayerState.PAUSE) {
            if (this.hcG == null) {
                this.hcG = new MediaPlayer();
                this.hcG.setAudioStreamType(3);
            }
            try {
                this.hcG.reset();
                this.hcG.setDataSource(str);
                this.hcG.prepare();
                this.hcI = MusicPlayerState.WAIT;
                this.hcG.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.cloudmusic.MusicPlayer.1
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        com.baidu.tieba.video.cloudmusic.data.a.bAz().a(musicList);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921307));
                        MusicPlayer.this.hcG.setLooping(true);
                        MusicPlayer.this.hcG.start();
                        MusicPlayer.this.hcI = MusicPlayerState.PREPARED;
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
                this.hcI = MusicPlayerState.ERROR;
                if (aVar != null) {
                    aVar.bAu();
                }
            }
        }
    }

    public void bAx() {
        if (this.hcG != null && this.hcG.isPlaying()) {
            this.hcG.pause();
        }
        this.hcI = MusicPlayerState.PAUSE;
    }

    public void bAy() {
        if (this.hcG != null) {
            this.hcG.start();
            this.hcG.seekTo(0);
        }
        this.hcI = MusicPlayerState.RESUME;
    }

    public void bko() {
        if (this.hcG != null) {
            if (this.hcG.isPlaying()) {
                this.hcG.stop();
            }
            this.hcG.release();
            this.hcG = null;
        }
    }
}
