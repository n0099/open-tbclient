package com.baidu.tieba.video.cloudmusic;

import android.media.MediaPlayer;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import java.io.IOException;
/* loaded from: classes5.dex */
public class MusicPlayer {
    private static MusicPlayer hrQ = null;
    private MediaPlayer hrP;
    private MusicPlayerState hrR = MusicPlayerState.WAIT;

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
            if (hrQ == null) {
                hrQ = new MusicPlayer();
            }
            musicPlayer = hrQ;
        }
        return musicPlayer;
    }

    public void a(String str, final CloudMusicData.MusicTagList.MusicList musicList, a aVar) {
        if (this.hrR != MusicPlayerState.PAUSE) {
            if (this.hrP == null) {
                this.hrP = new MediaPlayer();
                this.hrP.setAudioStreamType(3);
            }
            try {
                this.hrP.reset();
                this.hrP.setDataSource(str);
                this.hrP.prepare();
                this.hrR = MusicPlayerState.WAIT;
                this.hrP.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.cloudmusic.MusicPlayer.1
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        com.baidu.tieba.video.cloudmusic.data.a.bGC().a(musicList);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921307));
                        MusicPlayer.this.hrP.setLooping(true);
                        MusicPlayer.this.hrP.start();
                        MusicPlayer.this.hrR = MusicPlayerState.PREPARED;
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
                this.hrR = MusicPlayerState.ERROR;
                if (aVar != null) {
                    aVar.bGx();
                }
            }
        }
    }

    public void bGA() {
        if (this.hrP != null && this.hrP.isPlaying()) {
            this.hrP.pause();
        }
        this.hrR = MusicPlayerState.PAUSE;
    }

    public void bGB() {
        if (this.hrP != null) {
            this.hrP.start();
            this.hrP.seekTo(0);
        }
        this.hrR = MusicPlayerState.RESUME;
    }

    public void Tu() {
        if (this.hrP != null) {
            if (this.hrP.isPlaying()) {
                this.hrP.stop();
            }
            this.hrP.release();
            this.hrP = null;
        }
    }
}
