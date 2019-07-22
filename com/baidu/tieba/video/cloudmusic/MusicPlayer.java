package com.baidu.tieba.video.cloudmusic;

import android.media.MediaPlayer;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import java.io.IOException;
/* loaded from: classes5.dex */
public class MusicPlayer {
    private static MusicPlayer juC = null;
    private MediaPlayer juB;
    private MusicPlayerState juD = MusicPlayerState.WAIT;

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
        void ctO();
    }

    private MusicPlayer() {
    }

    public static synchronized MusicPlayer ctQ() {
        MusicPlayer musicPlayer;
        synchronized (MusicPlayer.class) {
            if (juC == null) {
                juC = new MusicPlayer();
            }
            musicPlayer = juC;
        }
        return musicPlayer;
    }

    public void a(String str, final CloudMusicData.MusicTagList.MusicList musicList, a aVar) {
        if (this.juD != MusicPlayerState.PAUSE) {
            if (this.juB == null) {
                this.juB = new MediaPlayer();
                this.juB.setAudioStreamType(3);
            }
            try {
                this.juB.reset();
                this.juB.setDataSource(str);
                this.juB.prepare();
                this.juD = MusicPlayerState.WAIT;
                this.juB.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.cloudmusic.MusicPlayer.1
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        com.baidu.tieba.video.cloudmusic.data.a.ctT().a(musicList);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921307));
                        MusicPlayer.this.juB.setLooping(true);
                        MusicPlayer.this.juB.start();
                        MusicPlayer.this.juD = MusicPlayerState.PREPARED;
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
                this.juD = MusicPlayerState.ERROR;
                if (aVar != null) {
                    aVar.ctO();
                }
            }
        }
    }

    public void ctR() {
        if (this.juB != null && this.juB.isPlaying()) {
            this.juB.pause();
        }
        this.juD = MusicPlayerState.PAUSE;
    }

    public void ctS() {
        if (this.juB != null) {
            this.juB.start();
            this.juB.seekTo(0);
        }
        this.juD = MusicPlayerState.RESUME;
    }

    public void aBA() {
        if (this.juB != null) {
            if (this.juB.isPlaying()) {
                this.juB.stop();
            }
            this.juB.release();
            this.juB = null;
        }
    }
}
