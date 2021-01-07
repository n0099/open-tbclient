package com.baidu.tieba.video.cloudmusic;

import android.media.MediaPlayer;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import java.io.IOException;
/* loaded from: classes8.dex */
public class MusicPlayer {
    private static MusicPlayer nGe = null;
    private MediaPlayer nGd;
    private MusicPlayerState nGf = MusicPlayerState.WAIT;

    /* loaded from: classes8.dex */
    public enum MusicPlayerState {
        WAIT,
        PAUSE,
        PREPARED,
        REPLAY,
        RESUME,
        ERROR
    }

    /* loaded from: classes8.dex */
    public interface a {
        void dTO();
    }

    private MusicPlayer() {
    }

    public static synchronized MusicPlayer dTQ() {
        MusicPlayer musicPlayer;
        synchronized (MusicPlayer.class) {
            if (nGe == null) {
                nGe = new MusicPlayer();
            }
            musicPlayer = nGe;
        }
        return musicPlayer;
    }

    public void a(String str, final CloudMusicData.MusicTagList.MusicList musicList, a aVar) {
        if (this.nGf != MusicPlayerState.PAUSE) {
            if (this.nGd == null) {
                this.nGd = new MediaPlayer();
                this.nGd.setAudioStreamType(3);
            }
            try {
                this.nGd.reset();
                this.nGd.setDataSource(str);
                this.nGd.prepare();
                this.nGf = MusicPlayerState.WAIT;
                this.nGd.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.cloudmusic.MusicPlayer.1
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        com.baidu.tieba.video.cloudmusic.data.a.dTT().a(musicList);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_CLOUD_MUSIC_PLAY));
                        MusicPlayer.this.nGd.setLooping(true);
                        MusicPlayer.this.nGd.start();
                        MusicPlayer.this.nGf = MusicPlayerState.PREPARED;
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
                this.nGf = MusicPlayerState.ERROR;
                if (aVar != null) {
                    aVar.dTO();
                }
            }
        }
    }

    public void dTR() {
        if (this.nGd != null && this.nGd.isPlaying()) {
            this.nGd.pause();
        }
        this.nGf = MusicPlayerState.PAUSE;
    }

    public void dTS() {
        if (this.nGd != null) {
            this.nGd.start();
            this.nGd.seekTo(0);
        }
        this.nGf = MusicPlayerState.RESUME;
    }

    public void bjA() {
        if (this.nGd != null) {
            if (this.nGd.isPlaying()) {
                this.nGd.stop();
            }
            this.nGd.release();
            this.nGd = null;
        }
    }
}
