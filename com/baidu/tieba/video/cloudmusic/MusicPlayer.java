package com.baidu.tieba.video.cloudmusic;

import android.media.MediaPlayer;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import java.io.IOException;
/* loaded from: classes2.dex */
public class MusicPlayer {
    private static MusicPlayer gLM = null;
    private MediaPlayer gLL;
    private MusicPlayerState gLN = MusicPlayerState.WAIT;

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
        void bwa();
    }

    private MusicPlayer() {
    }

    public static synchronized MusicPlayer bwc() {
        MusicPlayer musicPlayer;
        synchronized (MusicPlayer.class) {
            if (gLM == null) {
                gLM = new MusicPlayer();
            }
            musicPlayer = gLM;
        }
        return musicPlayer;
    }

    public void a(String str, final CloudMusicData.MusicTagList.MusicList musicList, a aVar) {
        if (this.gLN != MusicPlayerState.PAUSE) {
            if (this.gLL == null) {
                this.gLL = new MediaPlayer();
                this.gLL.setAudioStreamType(3);
            }
            try {
                this.gLL.reset();
                this.gLL.setDataSource(str);
                this.gLL.prepare();
                this.gLN = MusicPlayerState.WAIT;
                this.gLL.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.cloudmusic.MusicPlayer.1
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        com.baidu.tieba.video.cloudmusic.data.a.bwf().a(musicList);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921307));
                        MusicPlayer.this.gLL.setLooping(true);
                        MusicPlayer.this.gLL.start();
                        MusicPlayer.this.gLN = MusicPlayerState.PREPARED;
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
                this.gLN = MusicPlayerState.ERROR;
                if (aVar != null) {
                    aVar.bwa();
                }
            }
        }
    }

    public void bwd() {
        if (this.gLL != null && this.gLL.isPlaying()) {
            this.gLL.pause();
        }
        this.gLN = MusicPlayerState.PAUSE;
    }

    public void bwe() {
        if (this.gLL != null) {
            this.gLL.start();
            this.gLL.seekTo(0);
        }
        this.gLN = MusicPlayerState.RESUME;
    }

    public void bgx() {
        if (this.gLL != null) {
            if (this.gLL.isPlaying()) {
                this.gLL.stop();
            }
            this.gLL.release();
            this.gLL = null;
        }
    }
}
