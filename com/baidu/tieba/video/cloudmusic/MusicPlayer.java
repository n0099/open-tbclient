package com.baidu.tieba.video.cloudmusic;

import android.media.MediaPlayer;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import java.io.IOException;
/* loaded from: classes2.dex */
public class MusicPlayer {
    private static MusicPlayer gKJ = null;
    private MediaPlayer gKI;
    private MusicPlayerState gKK = MusicPlayerState.WAIT;

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
        void bwc();
    }

    private MusicPlayer() {
    }

    public static synchronized MusicPlayer bwe() {
        MusicPlayer musicPlayer;
        synchronized (MusicPlayer.class) {
            if (gKJ == null) {
                gKJ = new MusicPlayer();
            }
            musicPlayer = gKJ;
        }
        return musicPlayer;
    }

    public void a(String str, final CloudMusicData.MusicTagList.MusicList musicList, a aVar) {
        if (this.gKK != MusicPlayerState.PAUSE) {
            if (this.gKI == null) {
                this.gKI = new MediaPlayer();
                this.gKI.setAudioStreamType(3);
            }
            try {
                this.gKI.reset();
                this.gKI.setDataSource(str);
                this.gKI.prepare();
                this.gKK = MusicPlayerState.WAIT;
                this.gKI.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.cloudmusic.MusicPlayer.1
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        com.baidu.tieba.video.cloudmusic.data.a.bwh().a(musicList);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921307));
                        MusicPlayer.this.gKI.setLooping(true);
                        MusicPlayer.this.gKI.start();
                        MusicPlayer.this.gKK = MusicPlayerState.PREPARED;
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
                this.gKK = MusicPlayerState.ERROR;
                if (aVar != null) {
                    aVar.bwc();
                }
            }
        }
    }

    public void bwf() {
        if (this.gKI != null && this.gKI.isPlaying()) {
            this.gKI.pause();
        }
        this.gKK = MusicPlayerState.PAUSE;
    }

    public void bwg() {
        if (this.gKI != null) {
            this.gKI.start();
            this.gKI.seekTo(0);
        }
        this.gKK = MusicPlayerState.RESUME;
    }

    public void bgx() {
        if (this.gKI != null) {
            if (this.gKI.isPlaying()) {
                this.gKI.stop();
            }
            this.gKI.release();
            this.gKI = null;
        }
    }
}
