package com.baidu.tieba.video.cloudmusic;

import android.media.MediaPlayer;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import java.io.IOException;
/* loaded from: classes2.dex */
public class MusicPlayer {
    private static MusicPlayer hoQ = null;
    private MediaPlayer hoP;
    private MusicPlayerState hoR = MusicPlayerState.WAIT;

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
        void bAT();
    }

    private MusicPlayer() {
    }

    public static synchronized MusicPlayer bAV() {
        MusicPlayer musicPlayer;
        synchronized (MusicPlayer.class) {
            if (hoQ == null) {
                hoQ = new MusicPlayer();
            }
            musicPlayer = hoQ;
        }
        return musicPlayer;
    }

    public void a(String str, final CloudMusicData.MusicTagList.MusicList musicList, a aVar) {
        if (this.hoR != MusicPlayerState.PAUSE) {
            if (this.hoP == null) {
                this.hoP = new MediaPlayer();
                this.hoP.setAudioStreamType(3);
            }
            try {
                this.hoP.reset();
                this.hoP.setDataSource(str);
                this.hoP.prepare();
                this.hoR = MusicPlayerState.WAIT;
                this.hoP.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.cloudmusic.MusicPlayer.1
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        com.baidu.tieba.video.cloudmusic.data.a.bAY().a(musicList);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921307));
                        MusicPlayer.this.hoP.setLooping(true);
                        MusicPlayer.this.hoP.start();
                        MusicPlayer.this.hoR = MusicPlayerState.PREPARED;
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
                this.hoR = MusicPlayerState.ERROR;
                if (aVar != null) {
                    aVar.bAT();
                }
            }
        }
    }

    public void bAW() {
        if (this.hoP != null && this.hoP.isPlaying()) {
            this.hoP.pause();
        }
        this.hoR = MusicPlayerState.PAUSE;
    }

    public void bAX() {
        if (this.hoP != null) {
            this.hoP.start();
            this.hoP.seekTo(0);
        }
        this.hoR = MusicPlayerState.RESUME;
    }

    public void blr() {
        if (this.hoP != null) {
            if (this.hoP.isPlaying()) {
                this.hoP.stop();
            }
            this.hoP.release();
            this.hoP = null;
        }
    }
}
