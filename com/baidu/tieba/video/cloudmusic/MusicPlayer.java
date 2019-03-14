package com.baidu.tieba.video.cloudmusic;

import android.media.MediaPlayer;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import java.io.IOException;
/* loaded from: classes5.dex */
public class MusicPlayer {
    private static MusicPlayer iVE = null;
    private MediaPlayer iVD;
    private MusicPlayerState iVF = MusicPlayerState.WAIT;

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
        void ciZ();
    }

    private MusicPlayer() {
    }

    public static synchronized MusicPlayer cjb() {
        MusicPlayer musicPlayer;
        synchronized (MusicPlayer.class) {
            if (iVE == null) {
                iVE = new MusicPlayer();
            }
            musicPlayer = iVE;
        }
        return musicPlayer;
    }

    public void a(String str, final CloudMusicData.MusicTagList.MusicList musicList, a aVar) {
        if (this.iVF != MusicPlayerState.PAUSE) {
            if (this.iVD == null) {
                this.iVD = new MediaPlayer();
                this.iVD.setAudioStreamType(3);
            }
            try {
                this.iVD.reset();
                this.iVD.setDataSource(str);
                this.iVD.prepare();
                this.iVF = MusicPlayerState.WAIT;
                this.iVD.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.cloudmusic.MusicPlayer.1
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        com.baidu.tieba.video.cloudmusic.data.a.cje().a(musicList);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921307));
                        MusicPlayer.this.iVD.setLooping(true);
                        MusicPlayer.this.iVD.start();
                        MusicPlayer.this.iVF = MusicPlayerState.PREPARED;
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
                this.iVF = MusicPlayerState.ERROR;
                if (aVar != null) {
                    aVar.ciZ();
                }
            }
        }
    }

    public void cjc() {
        if (this.iVD != null && this.iVD.isPlaying()) {
            this.iVD.pause();
        }
        this.iVF = MusicPlayerState.PAUSE;
    }

    public void cjd() {
        if (this.iVD != null) {
            this.iVD.start();
            this.iVD.seekTo(0);
        }
        this.iVF = MusicPlayerState.RESUME;
    }

    public void avg() {
        if (this.iVD != null) {
            if (this.iVD.isPlaying()) {
                this.iVD.stop();
            }
            this.iVD.release();
            this.iVD = null;
        }
    }
}
