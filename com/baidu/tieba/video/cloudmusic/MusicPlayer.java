package com.baidu.tieba.video.cloudmusic;

import android.media.MediaPlayer;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import java.io.IOException;
/* loaded from: classes2.dex */
public class MusicPlayer {
    private static MusicPlayer hbt = null;
    private MediaPlayer hbs;
    private MusicPlayerState hbu = MusicPlayerState.WAIT;

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
        void bBH();
    }

    private MusicPlayer() {
    }

    public static synchronized MusicPlayer bBJ() {
        MusicPlayer musicPlayer;
        synchronized (MusicPlayer.class) {
            if (hbt == null) {
                hbt = new MusicPlayer();
            }
            musicPlayer = hbt;
        }
        return musicPlayer;
    }

    public void a(String str, final CloudMusicData.MusicTagList.MusicList musicList, a aVar) {
        if (this.hbu != MusicPlayerState.PAUSE) {
            if (this.hbs == null) {
                this.hbs = new MediaPlayer();
                this.hbs.setAudioStreamType(3);
            }
            try {
                this.hbs.reset();
                this.hbs.setDataSource(str);
                this.hbs.prepare();
                this.hbu = MusicPlayerState.WAIT;
                this.hbs.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.cloudmusic.MusicPlayer.1
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        com.baidu.tieba.video.cloudmusic.data.a.bBM().a(musicList);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921307));
                        MusicPlayer.this.hbs.setLooping(true);
                        MusicPlayer.this.hbs.start();
                        MusicPlayer.this.hbu = MusicPlayerState.PREPARED;
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
                this.hbu = MusicPlayerState.ERROR;
                if (aVar != null) {
                    aVar.bBH();
                }
            }
        }
    }

    public void bBK() {
        if (this.hbs != null && this.hbs.isPlaying()) {
            this.hbs.pause();
        }
        this.hbu = MusicPlayerState.PAUSE;
    }

    public void bBL() {
        if (this.hbs != null) {
            this.hbs.start();
            this.hbs.seekTo(0);
        }
        this.hbu = MusicPlayerState.RESUME;
    }

    public void blZ() {
        if (this.hbs != null) {
            if (this.hbs.isPlaying()) {
                this.hbs.stop();
            }
            this.hbs.release();
            this.hbs = null;
        }
    }
}
