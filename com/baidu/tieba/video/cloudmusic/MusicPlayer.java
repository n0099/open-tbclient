package com.baidu.tieba.video.cloudmusic;

import android.media.MediaPlayer;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import java.io.IOException;
/* loaded from: classes5.dex */
public class MusicPlayer {
    private static MusicPlayer jov = null;
    private MediaPlayer jou;
    private MusicPlayerState jow = MusicPlayerState.WAIT;

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
        void crd();
    }

    private MusicPlayer() {
    }

    public static synchronized MusicPlayer crf() {
        MusicPlayer musicPlayer;
        synchronized (MusicPlayer.class) {
            if (jov == null) {
                jov = new MusicPlayer();
            }
            musicPlayer = jov;
        }
        return musicPlayer;
    }

    public void a(String str, final CloudMusicData.MusicTagList.MusicList musicList, a aVar) {
        if (this.jow != MusicPlayerState.PAUSE) {
            if (this.jou == null) {
                this.jou = new MediaPlayer();
                this.jou.setAudioStreamType(3);
            }
            try {
                this.jou.reset();
                this.jou.setDataSource(str);
                this.jou.prepare();
                this.jow = MusicPlayerState.WAIT;
                this.jou.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.cloudmusic.MusicPlayer.1
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        com.baidu.tieba.video.cloudmusic.data.a.cri().a(musicList);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921307));
                        MusicPlayer.this.jou.setLooping(true);
                        MusicPlayer.this.jou.start();
                        MusicPlayer.this.jow = MusicPlayerState.PREPARED;
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
                this.jow = MusicPlayerState.ERROR;
                if (aVar != null) {
                    aVar.crd();
                }
            }
        }
    }

    public void crg() {
        if (this.jou != null && this.jou.isPlaying()) {
            this.jou.pause();
        }
        this.jow = MusicPlayerState.PAUSE;
    }

    public void crh() {
        if (this.jou != null) {
            this.jou.start();
            this.jou.seekTo(0);
        }
        this.jow = MusicPlayerState.RESUME;
    }

    public void aAl() {
        if (this.jou != null) {
            if (this.jou.isPlaying()) {
                this.jou.stop();
            }
            this.jou.release();
            this.jou = null;
        }
    }
}
