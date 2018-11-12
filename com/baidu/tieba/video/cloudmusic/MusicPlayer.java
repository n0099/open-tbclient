package com.baidu.tieba.video.cloudmusic;

import android.media.MediaPlayer;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import java.io.IOException;
/* loaded from: classes5.dex */
public class MusicPlayer {
    private static MusicPlayer htz = null;
    private MusicPlayerState htA = MusicPlayerState.WAIT;
    private MediaPlayer hty;

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
        void bFW();
    }

    private MusicPlayer() {
    }

    public static synchronized MusicPlayer bFY() {
        MusicPlayer musicPlayer;
        synchronized (MusicPlayer.class) {
            if (htz == null) {
                htz = new MusicPlayer();
            }
            musicPlayer = htz;
        }
        return musicPlayer;
    }

    public void a(String str, final CloudMusicData.MusicTagList.MusicList musicList, a aVar) {
        if (this.htA != MusicPlayerState.PAUSE) {
            if (this.hty == null) {
                this.hty = new MediaPlayer();
                this.hty.setAudioStreamType(3);
            }
            try {
                this.hty.reset();
                this.hty.setDataSource(str);
                this.hty.prepare();
                this.htA = MusicPlayerState.WAIT;
                this.hty.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.cloudmusic.MusicPlayer.1
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        com.baidu.tieba.video.cloudmusic.data.a.bGb().a(musicList);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921307));
                        MusicPlayer.this.hty.setLooping(true);
                        MusicPlayer.this.hty.start();
                        MusicPlayer.this.htA = MusicPlayerState.PREPARED;
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
                this.htA = MusicPlayerState.ERROR;
                if (aVar != null) {
                    aVar.bFW();
                }
            }
        }
    }

    public void bFZ() {
        if (this.hty != null && this.hty.isPlaying()) {
            this.hty.pause();
        }
        this.htA = MusicPlayerState.PAUSE;
    }

    public void bGa() {
        if (this.hty != null) {
            this.hty.start();
            this.hty.seekTo(0);
        }
        this.htA = MusicPlayerState.RESUME;
    }

    public void TD() {
        if (this.hty != null) {
            if (this.hty.isPlaying()) {
                this.hty.stop();
            }
            this.hty.release();
            this.hty = null;
        }
    }
}
