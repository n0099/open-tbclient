package com.baidu.tieba.video.cloudmusic;

import android.media.MediaPlayer;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import java.io.IOException;
/* loaded from: classes22.dex */
public class MusicPlayer {
    private static MusicPlayer mEC = null;
    private MediaPlayer mEB;
    private MusicPlayerState mED = MusicPlayerState.WAIT;

    /* loaded from: classes22.dex */
    public enum MusicPlayerState {
        WAIT,
        PAUSE,
        PREPARED,
        REPLAY,
        RESUME,
        ERROR
    }

    /* loaded from: classes22.dex */
    public interface a {
        void dFi();
    }

    private MusicPlayer() {
    }

    public static synchronized MusicPlayer dFk() {
        MusicPlayer musicPlayer;
        synchronized (MusicPlayer.class) {
            if (mEC == null) {
                mEC = new MusicPlayer();
            }
            musicPlayer = mEC;
        }
        return musicPlayer;
    }

    public void a(String str, final CloudMusicData.MusicTagList.MusicList musicList, a aVar) {
        if (this.mED != MusicPlayerState.PAUSE) {
            if (this.mEB == null) {
                this.mEB = new MediaPlayer();
                this.mEB.setAudioStreamType(3);
            }
            try {
                this.mEB.reset();
                this.mEB.setDataSource(str);
                this.mEB.prepare();
                this.mED = MusicPlayerState.WAIT;
                this.mEB.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.cloudmusic.MusicPlayer.1
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        com.baidu.tieba.video.cloudmusic.data.a.dFn().a(musicList);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_CLOUD_MUSIC_PLAY));
                        MusicPlayer.this.mEB.setLooping(true);
                        MusicPlayer.this.mEB.start();
                        MusicPlayer.this.mED = MusicPlayerState.PREPARED;
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
                this.mED = MusicPlayerState.ERROR;
                if (aVar != null) {
                    aVar.dFi();
                }
            }
        }
    }

    public void dFl() {
        if (this.mEB != null && this.mEB.isPlaying()) {
            this.mEB.pause();
        }
        this.mED = MusicPlayerState.PAUSE;
    }

    public void dFm() {
        if (this.mEB != null) {
            this.mEB.start();
            this.mEB.seekTo(0);
        }
        this.mED = MusicPlayerState.RESUME;
    }

    public void aXD() {
        if (this.mEB != null) {
            if (this.mEB.isPlaying()) {
                this.mEB.stop();
            }
            this.mEB.release();
            this.mEB = null;
        }
    }
}
