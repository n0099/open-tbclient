package com.baidu.tieba.video.cloudmusic;

import android.media.MediaPlayer;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import java.io.IOException;
/* loaded from: classes5.dex */
public class MusicPlayer {
    private static MusicPlayer hrP = null;
    private MediaPlayer hrO;
    private MusicPlayerState hrQ = MusicPlayerState.WAIT;

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
        void bGx();
    }

    private MusicPlayer() {
    }

    public static synchronized MusicPlayer bGz() {
        MusicPlayer musicPlayer;
        synchronized (MusicPlayer.class) {
            if (hrP == null) {
                hrP = new MusicPlayer();
            }
            musicPlayer = hrP;
        }
        return musicPlayer;
    }

    public void a(String str, final CloudMusicData.MusicTagList.MusicList musicList, a aVar) {
        if (this.hrQ != MusicPlayerState.PAUSE) {
            if (this.hrO == null) {
                this.hrO = new MediaPlayer();
                this.hrO.setAudioStreamType(3);
            }
            try {
                this.hrO.reset();
                this.hrO.setDataSource(str);
                this.hrO.prepare();
                this.hrQ = MusicPlayerState.WAIT;
                this.hrO.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.cloudmusic.MusicPlayer.1
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        com.baidu.tieba.video.cloudmusic.data.a.bGC().a(musicList);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921307));
                        MusicPlayer.this.hrO.setLooping(true);
                        MusicPlayer.this.hrO.start();
                        MusicPlayer.this.hrQ = MusicPlayerState.PREPARED;
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
                this.hrQ = MusicPlayerState.ERROR;
                if (aVar != null) {
                    aVar.bGx();
                }
            }
        }
    }

    public void bGA() {
        if (this.hrO != null && this.hrO.isPlaying()) {
            this.hrO.pause();
        }
        this.hrQ = MusicPlayerState.PAUSE;
    }

    public void bGB() {
        if (this.hrO != null) {
            this.hrO.start();
            this.hrO.seekTo(0);
        }
        this.hrQ = MusicPlayerState.RESUME;
    }

    public void Tu() {
        if (this.hrO != null) {
            if (this.hrO.isPlaying()) {
                this.hrO.stop();
            }
            this.hrO.release();
            this.hrO = null;
        }
    }
}
