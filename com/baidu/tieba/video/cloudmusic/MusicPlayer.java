package com.baidu.tieba.video.cloudmusic;

import android.media.MediaPlayer;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import java.io.IOException;
/* loaded from: classes2.dex */
public class MusicPlayer {
    private static MusicPlayer hpb = null;
    private MediaPlayer hpa;
    private MusicPlayerState hpc = MusicPlayerState.WAIT;

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
        void bAX();
    }

    private MusicPlayer() {
    }

    public static synchronized MusicPlayer bAZ() {
        MusicPlayer musicPlayer;
        synchronized (MusicPlayer.class) {
            if (hpb == null) {
                hpb = new MusicPlayer();
            }
            musicPlayer = hpb;
        }
        return musicPlayer;
    }

    public void a(String str, final CloudMusicData.MusicTagList.MusicList musicList, a aVar) {
        if (this.hpc != MusicPlayerState.PAUSE) {
            if (this.hpa == null) {
                this.hpa = new MediaPlayer();
                this.hpa.setAudioStreamType(3);
            }
            try {
                this.hpa.reset();
                this.hpa.setDataSource(str);
                this.hpa.prepare();
                this.hpc = MusicPlayerState.WAIT;
                this.hpa.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.cloudmusic.MusicPlayer.1
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        com.baidu.tieba.video.cloudmusic.data.a.bBc().a(musicList);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921307));
                        MusicPlayer.this.hpa.setLooping(true);
                        MusicPlayer.this.hpa.start();
                        MusicPlayer.this.hpc = MusicPlayerState.PREPARED;
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
                this.hpc = MusicPlayerState.ERROR;
                if (aVar != null) {
                    aVar.bAX();
                }
            }
        }
    }

    public void bBa() {
        if (this.hpa != null && this.hpa.isPlaying()) {
            this.hpa.pause();
        }
        this.hpc = MusicPlayerState.PAUSE;
    }

    public void bBb() {
        if (this.hpa != null) {
            this.hpa.start();
            this.hpa.seekTo(0);
        }
        this.hpc = MusicPlayerState.RESUME;
    }

    public void blr() {
        if (this.hpa != null) {
            if (this.hpa.isPlaying()) {
                this.hpa.stop();
            }
            this.hpa.release();
            this.hpa = null;
        }
    }
}
