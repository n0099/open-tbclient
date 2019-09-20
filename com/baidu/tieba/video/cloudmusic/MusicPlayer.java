package com.baidu.tieba.video.cloudmusic;

import android.media.MediaPlayer;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import java.io.IOException;
/* loaded from: classes5.dex */
public class MusicPlayer {
    private static MusicPlayer jyf = null;
    private MediaPlayer jye;
    private MusicPlayerState jyg = MusicPlayerState.WAIT;

    /* loaded from: classes5.dex */
    public enum MusicPlayerState {
        WAIT,
        PAUSE,
        PREPARED,
        REPLAY,
        RESUME,
        ERROR
    }

    /* loaded from: classes5.dex */
    public interface a {
        void cuY();
    }

    private MusicPlayer() {
    }

    public static synchronized MusicPlayer cva() {
        MusicPlayer musicPlayer;
        synchronized (MusicPlayer.class) {
            if (jyf == null) {
                jyf = new MusicPlayer();
            }
            musicPlayer = jyf;
        }
        return musicPlayer;
    }

    public void a(String str, final CloudMusicData.MusicTagList.MusicList musicList, a aVar) {
        if (this.jyg != MusicPlayerState.PAUSE) {
            if (this.jye == null) {
                this.jye = new MediaPlayer();
                this.jye.setAudioStreamType(3);
            }
            try {
                this.jye.reset();
                this.jye.setDataSource(str);
                this.jye.prepare();
                this.jyg = MusicPlayerState.WAIT;
                this.jye.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.cloudmusic.MusicPlayer.1
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        com.baidu.tieba.video.cloudmusic.data.a.cvd().a(musicList);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921307));
                        MusicPlayer.this.jye.setLooping(true);
                        MusicPlayer.this.jye.start();
                        MusicPlayer.this.jyg = MusicPlayerState.PREPARED;
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
                this.jyg = MusicPlayerState.ERROR;
                if (aVar != null) {
                    aVar.cuY();
                }
            }
        }
    }

    public void cvb() {
        if (this.jye != null && this.jye.isPlaying()) {
            this.jye.pause();
        }
        this.jyg = MusicPlayerState.PAUSE;
    }

    public void cvc() {
        if (this.jye != null) {
            this.jye.start();
            this.jye.seekTo(0);
        }
        this.jyg = MusicPlayerState.RESUME;
    }

    public void aBQ() {
        if (this.jye != null) {
            if (this.jye.isPlaying()) {
                this.jye.stop();
            }
            this.jye.release();
            this.jye = null;
        }
    }
}
