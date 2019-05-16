package com.baidu.tieba.video.cloudmusic;

import android.media.MediaPlayer;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import java.io.IOException;
/* loaded from: classes5.dex */
public class MusicPlayer {
    private static MusicPlayer joq = null;
    private MediaPlayer jop;
    private MusicPlayerState jor = MusicPlayerState.WAIT;

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
        void cra();
    }

    private MusicPlayer() {
    }

    public static synchronized MusicPlayer crc() {
        MusicPlayer musicPlayer;
        synchronized (MusicPlayer.class) {
            if (joq == null) {
                joq = new MusicPlayer();
            }
            musicPlayer = joq;
        }
        return musicPlayer;
    }

    public void a(String str, final CloudMusicData.MusicTagList.MusicList musicList, a aVar) {
        if (this.jor != MusicPlayerState.PAUSE) {
            if (this.jop == null) {
                this.jop = new MediaPlayer();
                this.jop.setAudioStreamType(3);
            }
            try {
                this.jop.reset();
                this.jop.setDataSource(str);
                this.jop.prepare();
                this.jor = MusicPlayerState.WAIT;
                this.jop.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.cloudmusic.MusicPlayer.1
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        com.baidu.tieba.video.cloudmusic.data.a.crf().a(musicList);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921307));
                        MusicPlayer.this.jop.setLooping(true);
                        MusicPlayer.this.jop.start();
                        MusicPlayer.this.jor = MusicPlayerState.PREPARED;
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
                this.jor = MusicPlayerState.ERROR;
                if (aVar != null) {
                    aVar.cra();
                }
            }
        }
    }

    public void crd() {
        if (this.jop != null && this.jop.isPlaying()) {
            this.jop.pause();
        }
        this.jor = MusicPlayerState.PAUSE;
    }

    public void cre() {
        if (this.jop != null) {
            this.jop.start();
            this.jop.seekTo(0);
        }
        this.jor = MusicPlayerState.RESUME;
    }

    public void aAi() {
        if (this.jop != null) {
            if (this.jop.isPlaying()) {
                this.jop.stop();
            }
            this.jop.release();
            this.jop = null;
        }
    }
}
