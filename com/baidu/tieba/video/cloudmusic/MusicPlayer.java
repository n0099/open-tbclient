package com.baidu.tieba.video.cloudmusic;

import android.media.MediaPlayer;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import java.io.IOException;
/* loaded from: classes5.dex */
public class MusicPlayer {
    private static MusicPlayer iVt = null;
    private MediaPlayer iVs;
    private MusicPlayerState iVu = MusicPlayerState.WAIT;

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
        void ciX();
    }

    private MusicPlayer() {
    }

    public static synchronized MusicPlayer ciZ() {
        MusicPlayer musicPlayer;
        synchronized (MusicPlayer.class) {
            if (iVt == null) {
                iVt = new MusicPlayer();
            }
            musicPlayer = iVt;
        }
        return musicPlayer;
    }

    public void a(String str, final CloudMusicData.MusicTagList.MusicList musicList, a aVar) {
        if (this.iVu != MusicPlayerState.PAUSE) {
            if (this.iVs == null) {
                this.iVs = new MediaPlayer();
                this.iVs.setAudioStreamType(3);
            }
            try {
                this.iVs.reset();
                this.iVs.setDataSource(str);
                this.iVs.prepare();
                this.iVu = MusicPlayerState.WAIT;
                this.iVs.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.cloudmusic.MusicPlayer.1
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        com.baidu.tieba.video.cloudmusic.data.a.cjc().a(musicList);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921307));
                        MusicPlayer.this.iVs.setLooping(true);
                        MusicPlayer.this.iVs.start();
                        MusicPlayer.this.iVu = MusicPlayerState.PREPARED;
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
                this.iVu = MusicPlayerState.ERROR;
                if (aVar != null) {
                    aVar.ciX();
                }
            }
        }
    }

    public void cja() {
        if (this.iVs != null && this.iVs.isPlaying()) {
            this.iVs.pause();
        }
        this.iVu = MusicPlayerState.PAUSE;
    }

    public void cjb() {
        if (this.iVs != null) {
            this.iVs.start();
            this.iVs.seekTo(0);
        }
        this.iVu = MusicPlayerState.RESUME;
    }

    public void avd() {
        if (this.iVs != null) {
            if (this.iVs.isPlaying()) {
                this.iVs.stop();
            }
            this.iVs.release();
            this.iVs = null;
        }
    }
}
