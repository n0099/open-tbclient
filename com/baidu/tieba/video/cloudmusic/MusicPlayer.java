package com.baidu.tieba.video.cloudmusic;

import android.media.MediaPlayer;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import java.io.IOException;
/* loaded from: classes5.dex */
public class MusicPlayer {
    private static MusicPlayer hFd = null;
    private MediaPlayer hFc;
    private MusicPlayerState hFe = MusicPlayerState.WAIT;

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
            if (hFd == null) {
                hFd = new MusicPlayer();
            }
            musicPlayer = hFd;
        }
        return musicPlayer;
    }

    public void a(String str, final CloudMusicData.MusicTagList.MusicList musicList, a aVar) {
        if (this.hFe != MusicPlayerState.PAUSE) {
            if (this.hFc == null) {
                this.hFc = new MediaPlayer();
                this.hFc.setAudioStreamType(3);
            }
            try {
                this.hFc.reset();
                this.hFc.setDataSource(str);
                this.hFc.prepare();
                this.hFe = MusicPlayerState.WAIT;
                this.hFc.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.cloudmusic.MusicPlayer.1
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        com.baidu.tieba.video.cloudmusic.data.a.bJE().a(musicList);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921307));
                        MusicPlayer.this.hFc.setLooping(true);
                        MusicPlayer.this.hFc.start();
                        MusicPlayer.this.hFe = MusicPlayerState.PREPARED;
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
                this.hFe = MusicPlayerState.ERROR;
                if (aVar != null) {
                    aVar.bJz();
                }
            }
        }
    }

    public void bJC() {
        if (this.hFc != null && this.hFc.isPlaying()) {
            this.hFc.pause();
        }
        this.hFe = MusicPlayerState.PAUSE;
    }

    public void bJD() {
        if (this.hFc != null) {
            this.hFc.start();
            this.hFc.seekTo(0);
        }
        this.hFe = MusicPlayerState.RESUME;
    }

    public void Vh() {
        if (this.hFc != null) {
            if (this.hFc.isPlaying()) {
                this.hFc.stop();
            }
            this.hFc.release();
            this.hFc = null;
        }
    }
}
