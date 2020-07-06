package com.baidu.tieba.video.cloudmusic;

import android.media.MediaPlayer;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import java.io.IOException;
/* loaded from: classes10.dex */
public class MusicPlayer {
    private static MusicPlayer lVw = null;
    private MediaPlayer lVv;
    private MusicPlayerState lVx = MusicPlayerState.WAIT;

    /* loaded from: classes10.dex */
    public enum MusicPlayerState {
        WAIT,
        PAUSE,
        PREPARED,
        REPLAY,
        RESUME,
        ERROR
    }

    /* loaded from: classes10.dex */
    public interface a {
        void dmy();
    }

    private MusicPlayer() {
    }

    public static synchronized MusicPlayer dmA() {
        MusicPlayer musicPlayer;
        synchronized (MusicPlayer.class) {
            if (lVw == null) {
                lVw = new MusicPlayer();
            }
            musicPlayer = lVw;
        }
        return musicPlayer;
    }

    public void a(String str, final CloudMusicData.MusicTagList.MusicList musicList, a aVar) {
        if (this.lVx != MusicPlayerState.PAUSE) {
            if (this.lVv == null) {
                this.lVv = new MediaPlayer();
                this.lVv.setAudioStreamType(3);
            }
            try {
                this.lVv.reset();
                this.lVv.setDataSource(str);
                this.lVv.prepare();
                this.lVx = MusicPlayerState.WAIT;
                this.lVv.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.cloudmusic.MusicPlayer.1
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        com.baidu.tieba.video.cloudmusic.data.a.dmD().a(musicList);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_CLOUD_MUSIC_PLAY));
                        MusicPlayer.this.lVv.setLooping(true);
                        MusicPlayer.this.lVv.start();
                        MusicPlayer.this.lVx = MusicPlayerState.PREPARED;
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
                this.lVx = MusicPlayerState.ERROR;
                if (aVar != null) {
                    aVar.dmy();
                }
            }
        }
    }

    public void dmB() {
        if (this.lVv != null && this.lVv.isPlaying()) {
            this.lVv.pause();
        }
        this.lVx = MusicPlayerState.PAUSE;
    }

    public void dmC() {
        if (this.lVv != null) {
            this.lVv.start();
            this.lVv.seekTo(0);
        }
        this.lVx = MusicPlayerState.RESUME;
    }

    public void aKF() {
        if (this.lVv != null) {
            if (this.lVv.isPlaying()) {
                this.lVv.stop();
            }
            this.lVv.release();
            this.lVv = null;
        }
    }
}
