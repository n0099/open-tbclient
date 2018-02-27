package com.baidu.tieba.video.cloudmusic;

import android.media.MediaPlayer;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import java.io.IOException;
/* loaded from: classes2.dex */
public class MusicPlayer {
    private static MusicPlayer hoD = null;
    private MediaPlayer hoC;
    private MusicPlayerState hoE = MusicPlayerState.WAIT;

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
        void bAS();
    }

    private MusicPlayer() {
    }

    public static synchronized MusicPlayer bAU() {
        MusicPlayer musicPlayer;
        synchronized (MusicPlayer.class) {
            if (hoD == null) {
                hoD = new MusicPlayer();
            }
            musicPlayer = hoD;
        }
        return musicPlayer;
    }

    public void a(String str, final CloudMusicData.MusicTagList.MusicList musicList, a aVar) {
        if (this.hoE != MusicPlayerState.PAUSE) {
            if (this.hoC == null) {
                this.hoC = new MediaPlayer();
                this.hoC.setAudioStreamType(3);
            }
            try {
                this.hoC.reset();
                this.hoC.setDataSource(str);
                this.hoC.prepare();
                this.hoE = MusicPlayerState.WAIT;
                this.hoC.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.cloudmusic.MusicPlayer.1
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        com.baidu.tieba.video.cloudmusic.data.a.bAX().a(musicList);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921307));
                        MusicPlayer.this.hoC.setLooping(true);
                        MusicPlayer.this.hoC.start();
                        MusicPlayer.this.hoE = MusicPlayerState.PREPARED;
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
                this.hoE = MusicPlayerState.ERROR;
                if (aVar != null) {
                    aVar.bAS();
                }
            }
        }
    }

    public void bAV() {
        if (this.hoC != null && this.hoC.isPlaying()) {
            this.hoC.pause();
        }
        this.hoE = MusicPlayerState.PAUSE;
    }

    public void bAW() {
        if (this.hoC != null) {
            this.hoC.start();
            this.hoC.seekTo(0);
        }
        this.hoE = MusicPlayerState.RESUME;
    }

    public void blq() {
        if (this.hoC != null) {
            if (this.hoC.isPlaying()) {
                this.hoC.stop();
            }
            this.hoC.release();
            this.hoC = null;
        }
    }
}
