package com.baidu.tieba.video.cloudmusic;

import android.media.MediaPlayer;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import java.io.IOException;
/* loaded from: classes5.dex */
public class MusicPlayer {
    private static MusicPlayer hFe = null;
    private MediaPlayer hFd;
    private MusicPlayerState hFf = MusicPlayerState.WAIT;

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
        void bJz();
    }

    private MusicPlayer() {
    }

    public static synchronized MusicPlayer bJB() {
        MusicPlayer musicPlayer;
        synchronized (MusicPlayer.class) {
            if (hFe == null) {
                hFe = new MusicPlayer();
            }
            musicPlayer = hFe;
        }
        return musicPlayer;
    }

    public void a(String str, final CloudMusicData.MusicTagList.MusicList musicList, a aVar) {
        if (this.hFf != MusicPlayerState.PAUSE) {
            if (this.hFd == null) {
                this.hFd = new MediaPlayer();
                this.hFd.setAudioStreamType(3);
            }
            try {
                this.hFd.reset();
                this.hFd.setDataSource(str);
                this.hFd.prepare();
                this.hFf = MusicPlayerState.WAIT;
                this.hFd.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.cloudmusic.MusicPlayer.1
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        com.baidu.tieba.video.cloudmusic.data.a.bJE().a(musicList);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921307));
                        MusicPlayer.this.hFd.setLooping(true);
                        MusicPlayer.this.hFd.start();
                        MusicPlayer.this.hFf = MusicPlayerState.PREPARED;
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
                this.hFf = MusicPlayerState.ERROR;
                if (aVar != null) {
                    aVar.bJz();
                }
            }
        }
    }

    public void bJC() {
        if (this.hFd != null && this.hFd.isPlaying()) {
            this.hFd.pause();
        }
        this.hFf = MusicPlayerState.PAUSE;
    }

    public void bJD() {
        if (this.hFd != null) {
            this.hFd.start();
            this.hFd.seekTo(0);
        }
        this.hFf = MusicPlayerState.RESUME;
    }

    public void Vh() {
        if (this.hFd != null) {
            if (this.hFd.isPlaying()) {
                this.hFd.stop();
            }
            this.hFd.release();
            this.hFd = null;
        }
    }
}
