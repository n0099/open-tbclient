package com.baidu.tieba.video.cloudmusic;

import android.media.MediaPlayer;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import java.io.IOException;
/* loaded from: classes5.dex */
public class MusicPlayer {
    private static MusicPlayer iVs = null;
    private MediaPlayer iVr;
    private MusicPlayerState iVt = MusicPlayerState.WAIT;

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
            if (iVs == null) {
                iVs = new MusicPlayer();
            }
            musicPlayer = iVs;
        }
        return musicPlayer;
    }

    public void a(String str, final CloudMusicData.MusicTagList.MusicList musicList, a aVar) {
        if (this.iVt != MusicPlayerState.PAUSE) {
            if (this.iVr == null) {
                this.iVr = new MediaPlayer();
                this.iVr.setAudioStreamType(3);
            }
            try {
                this.iVr.reset();
                this.iVr.setDataSource(str);
                this.iVr.prepare();
                this.iVt = MusicPlayerState.WAIT;
                this.iVr.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.cloudmusic.MusicPlayer.1
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        com.baidu.tieba.video.cloudmusic.data.a.cjc().a(musicList);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921307));
                        MusicPlayer.this.iVr.setLooping(true);
                        MusicPlayer.this.iVr.start();
                        MusicPlayer.this.iVt = MusicPlayerState.PREPARED;
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
                this.iVt = MusicPlayerState.ERROR;
                if (aVar != null) {
                    aVar.ciX();
                }
            }
        }
    }

    public void cja() {
        if (this.iVr != null && this.iVr.isPlaying()) {
            this.iVr.pause();
        }
        this.iVt = MusicPlayerState.PAUSE;
    }

    public void cjb() {
        if (this.iVr != null) {
            this.iVr.start();
            this.iVr.seekTo(0);
        }
        this.iVt = MusicPlayerState.RESUME;
    }

    public void avd() {
        if (this.iVr != null) {
            if (this.iVr.isPlaying()) {
                this.iVr.stop();
            }
            this.iVr.release();
            this.iVr = null;
        }
    }
}
