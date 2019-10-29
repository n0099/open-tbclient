package com.baidu.tieba.video.cloudmusic;

import android.media.MediaPlayer;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import java.io.IOException;
/* loaded from: classes5.dex */
public class MusicPlayer {
    private static MusicPlayer jxX = null;
    private MediaPlayer jxW;
    private MusicPlayerState jxY = MusicPlayerState.WAIT;

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
        void csN();
    }

    private MusicPlayer() {
    }

    public static synchronized MusicPlayer csP() {
        MusicPlayer musicPlayer;
        synchronized (MusicPlayer.class) {
            if (jxX == null) {
                jxX = new MusicPlayer();
            }
            musicPlayer = jxX;
        }
        return musicPlayer;
    }

    public void a(String str, final CloudMusicData.MusicTagList.MusicList musicList, a aVar) {
        if (this.jxY != MusicPlayerState.PAUSE) {
            if (this.jxW == null) {
                this.jxW = new MediaPlayer();
                this.jxW.setAudioStreamType(3);
            }
            try {
                this.jxW.reset();
                this.jxW.setDataSource(str);
                this.jxW.prepare();
                this.jxY = MusicPlayerState.WAIT;
                this.jxW.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.cloudmusic.MusicPlayer.1
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        com.baidu.tieba.video.cloudmusic.data.a.csS().a(musicList);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_CLOUD_MUSIC_PLAY));
                        MusicPlayer.this.jxW.setLooping(true);
                        MusicPlayer.this.jxW.start();
                        MusicPlayer.this.jxY = MusicPlayerState.PREPARED;
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
                this.jxY = MusicPlayerState.ERROR;
                if (aVar != null) {
                    aVar.csN();
                }
            }
        }
    }

    public void csQ() {
        if (this.jxW != null && this.jxW.isPlaying()) {
            this.jxW.pause();
        }
        this.jxY = MusicPlayerState.PAUSE;
    }

    public void csR() {
        if (this.jxW != null) {
            this.jxW.start();
            this.jxW.seekTo(0);
        }
        this.jxY = MusicPlayerState.RESUME;
    }

    public void aCa() {
        if (this.jxW != null) {
            if (this.jxW.isPlaying()) {
                this.jxW.stop();
            }
            this.jxW.release();
            this.jxW = null;
        }
    }
}
