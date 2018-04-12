package com.baidu.tieba.video.cloudmusic;

import android.media.MediaPlayer;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import java.io.IOException;
/* loaded from: classes2.dex */
public class MusicPlayer {
    private static MusicPlayer gKM = null;
    private MediaPlayer gKL;
    private MusicPlayerState gKN = MusicPlayerState.WAIT;

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
        void bwc();
    }

    private MusicPlayer() {
    }

    public static synchronized MusicPlayer bwe() {
        MusicPlayer musicPlayer;
        synchronized (MusicPlayer.class) {
            if (gKM == null) {
                gKM = new MusicPlayer();
            }
            musicPlayer = gKM;
        }
        return musicPlayer;
    }

    public void a(String str, final CloudMusicData.MusicTagList.MusicList musicList, a aVar) {
        if (this.gKN != MusicPlayerState.PAUSE) {
            if (this.gKL == null) {
                this.gKL = new MediaPlayer();
                this.gKL.setAudioStreamType(3);
            }
            try {
                this.gKL.reset();
                this.gKL.setDataSource(str);
                this.gKL.prepare();
                this.gKN = MusicPlayerState.WAIT;
                this.gKL.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.cloudmusic.MusicPlayer.1
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        com.baidu.tieba.video.cloudmusic.data.a.bwh().a(musicList);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921307));
                        MusicPlayer.this.gKL.setLooping(true);
                        MusicPlayer.this.gKL.start();
                        MusicPlayer.this.gKN = MusicPlayerState.PREPARED;
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
                this.gKN = MusicPlayerState.ERROR;
                if (aVar != null) {
                    aVar.bwc();
                }
            }
        }
    }

    public void bwf() {
        if (this.gKL != null && this.gKL.isPlaying()) {
            this.gKL.pause();
        }
        this.gKN = MusicPlayerState.PAUSE;
    }

    public void bwg() {
        if (this.gKL != null) {
            this.gKL.start();
            this.gKL.seekTo(0);
        }
        this.gKN = MusicPlayerState.RESUME;
    }

    public void bgx() {
        if (this.gKL != null) {
            if (this.gKL.isPlaying()) {
                this.gKL.stop();
            }
            this.gKL.release();
            this.gKL = null;
        }
    }
}
