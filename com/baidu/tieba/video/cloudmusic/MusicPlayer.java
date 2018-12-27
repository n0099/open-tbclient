package com.baidu.tieba.video.cloudmusic;

import android.media.MediaPlayer;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import java.io.IOException;
/* loaded from: classes5.dex */
public class MusicPlayer {
    private static MusicPlayer hDW = null;
    private MediaPlayer hDV;
    private MusicPlayerState hDX = MusicPlayerState.WAIT;

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
        void bIQ();
    }

    private MusicPlayer() {
    }

    public static synchronized MusicPlayer bIS() {
        MusicPlayer musicPlayer;
        synchronized (MusicPlayer.class) {
            if (hDW == null) {
                hDW = new MusicPlayer();
            }
            musicPlayer = hDW;
        }
        return musicPlayer;
    }

    public void a(String str, final CloudMusicData.MusicTagList.MusicList musicList, a aVar) {
        if (this.hDX != MusicPlayerState.PAUSE) {
            if (this.hDV == null) {
                this.hDV = new MediaPlayer();
                this.hDV.setAudioStreamType(3);
            }
            try {
                this.hDV.reset();
                this.hDV.setDataSource(str);
                this.hDV.prepare();
                this.hDX = MusicPlayerState.WAIT;
                this.hDV.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.cloudmusic.MusicPlayer.1
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        com.baidu.tieba.video.cloudmusic.data.a.bIV().a(musicList);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921307));
                        MusicPlayer.this.hDV.setLooping(true);
                        MusicPlayer.this.hDV.start();
                        MusicPlayer.this.hDX = MusicPlayerState.PREPARED;
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
                this.hDX = MusicPlayerState.ERROR;
                if (aVar != null) {
                    aVar.bIQ();
                }
            }
        }
    }

    public void bIT() {
        if (this.hDV != null && this.hDV.isPlaying()) {
            this.hDV.pause();
        }
        this.hDX = MusicPlayerState.PAUSE;
    }

    public void bIU() {
        if (this.hDV != null) {
            this.hDV.start();
            this.hDV.seekTo(0);
        }
        this.hDX = MusicPlayerState.RESUME;
    }

    public void UL() {
        if (this.hDV != null) {
            if (this.hDV.isPlaying()) {
                this.hDV.stop();
            }
            this.hDV.release();
            this.hDV = null;
        }
    }
}
