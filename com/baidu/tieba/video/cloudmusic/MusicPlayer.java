package com.baidu.tieba.video.cloudmusic;

import android.media.MediaPlayer;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import java.io.IOException;
/* loaded from: classes5.dex */
public class MusicPlayer {
    private static MusicPlayer jvJ = null;
    private MediaPlayer jvI;
    private MusicPlayerState jvK = MusicPlayerState.WAIT;

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
        void cuk();
    }

    private MusicPlayer() {
    }

    public static synchronized MusicPlayer cum() {
        MusicPlayer musicPlayer;
        synchronized (MusicPlayer.class) {
            if (jvJ == null) {
                jvJ = new MusicPlayer();
            }
            musicPlayer = jvJ;
        }
        return musicPlayer;
    }

    public void a(String str, final CloudMusicData.MusicTagList.MusicList musicList, a aVar) {
        if (this.jvK != MusicPlayerState.PAUSE) {
            if (this.jvI == null) {
                this.jvI = new MediaPlayer();
                this.jvI.setAudioStreamType(3);
            }
            try {
                this.jvI.reset();
                this.jvI.setDataSource(str);
                this.jvI.prepare();
                this.jvK = MusicPlayerState.WAIT;
                this.jvI.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.cloudmusic.MusicPlayer.1
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        com.baidu.tieba.video.cloudmusic.data.a.cup().a(musicList);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921307));
                        MusicPlayer.this.jvI.setLooping(true);
                        MusicPlayer.this.jvI.start();
                        MusicPlayer.this.jvK = MusicPlayerState.PREPARED;
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
                this.jvK = MusicPlayerState.ERROR;
                if (aVar != null) {
                    aVar.cuk();
                }
            }
        }
    }

    public void cun() {
        if (this.jvI != null && this.jvI.isPlaying()) {
            this.jvI.pause();
        }
        this.jvK = MusicPlayerState.PAUSE;
    }

    public void cuo() {
        if (this.jvI != null) {
            this.jvI.start();
            this.jvI.seekTo(0);
        }
        this.jvK = MusicPlayerState.RESUME;
    }

    public void aBC() {
        if (this.jvI != null) {
            if (this.jvI.isPlaying()) {
                this.jvI.stop();
            }
            this.jvI.release();
            this.jvI = null;
        }
    }
}
