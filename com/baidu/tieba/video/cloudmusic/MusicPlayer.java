package com.baidu.tieba.video.cloudmusic;

import android.media.MediaPlayer;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import java.io.IOException;
/* loaded from: classes5.dex */
public class MusicPlayer {
    private static MusicPlayer jor = null;
    private MediaPlayer joq;
    private MusicPlayerState jos = MusicPlayerState.WAIT;

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
        void crc();
    }

    private MusicPlayer() {
    }

    public static synchronized MusicPlayer cre() {
        MusicPlayer musicPlayer;
        synchronized (MusicPlayer.class) {
            if (jor == null) {
                jor = new MusicPlayer();
            }
            musicPlayer = jor;
        }
        return musicPlayer;
    }

    public void a(String str, final CloudMusicData.MusicTagList.MusicList musicList, a aVar) {
        if (this.jos != MusicPlayerState.PAUSE) {
            if (this.joq == null) {
                this.joq = new MediaPlayer();
                this.joq.setAudioStreamType(3);
            }
            try {
                this.joq.reset();
                this.joq.setDataSource(str);
                this.joq.prepare();
                this.jos = MusicPlayerState.WAIT;
                this.joq.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.cloudmusic.MusicPlayer.1
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        com.baidu.tieba.video.cloudmusic.data.a.crh().a(musicList);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921307));
                        MusicPlayer.this.joq.setLooping(true);
                        MusicPlayer.this.joq.start();
                        MusicPlayer.this.jos = MusicPlayerState.PREPARED;
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
                this.jos = MusicPlayerState.ERROR;
                if (aVar != null) {
                    aVar.crc();
                }
            }
        }
    }

    public void crf() {
        if (this.joq != null && this.joq.isPlaying()) {
            this.joq.pause();
        }
        this.jos = MusicPlayerState.PAUSE;
    }

    public void crg() {
        if (this.joq != null) {
            this.joq.start();
            this.joq.seekTo(0);
        }
        this.jos = MusicPlayerState.RESUME;
    }

    public void aAl() {
        if (this.joq != null) {
            if (this.joq.isPlaying()) {
                this.joq.stop();
            }
            this.joq.release();
            this.joq = null;
        }
    }
}
