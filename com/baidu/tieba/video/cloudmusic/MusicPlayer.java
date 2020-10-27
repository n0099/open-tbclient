package com.baidu.tieba.video.cloudmusic;

import android.media.MediaPlayer;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import java.io.IOException;
/* loaded from: classes23.dex */
public class MusicPlayer {
    private static MusicPlayer ngQ = null;
    private MediaPlayer ngP;
    private MusicPlayerState ngR = MusicPlayerState.WAIT;

    /* loaded from: classes23.dex */
    public enum MusicPlayerState {
        WAIT,
        PAUSE,
        PREPARED,
        REPLAY,
        RESUME,
        ERROR
    }

    /* loaded from: classes23.dex */
    public interface a {
        void dMc();
    }

    private MusicPlayer() {
    }

    public static synchronized MusicPlayer dMe() {
        MusicPlayer musicPlayer;
        synchronized (MusicPlayer.class) {
            if (ngQ == null) {
                ngQ = new MusicPlayer();
            }
            musicPlayer = ngQ;
        }
        return musicPlayer;
    }

    public void a(String str, final CloudMusicData.MusicTagList.MusicList musicList, a aVar) {
        if (this.ngR != MusicPlayerState.PAUSE) {
            if (this.ngP == null) {
                this.ngP = new MediaPlayer();
                this.ngP.setAudioStreamType(3);
            }
            try {
                this.ngP.reset();
                this.ngP.setDataSource(str);
                this.ngP.prepare();
                this.ngR = MusicPlayerState.WAIT;
                this.ngP.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.cloudmusic.MusicPlayer.1
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        com.baidu.tieba.video.cloudmusic.data.a.dMh().a(musicList);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_CLOUD_MUSIC_PLAY));
                        MusicPlayer.this.ngP.setLooping(true);
                        MusicPlayer.this.ngP.start();
                        MusicPlayer.this.ngR = MusicPlayerState.PREPARED;
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
                this.ngR = MusicPlayerState.ERROR;
                if (aVar != null) {
                    aVar.dMc();
                }
            }
        }
    }

    public void dMf() {
        if (this.ngP != null && this.ngP.isPlaying()) {
            this.ngP.pause();
        }
        this.ngR = MusicPlayerState.PAUSE;
    }

    public void dMg() {
        if (this.ngP != null) {
            this.ngP.start();
            this.ngP.seekTo(0);
        }
        this.ngR = MusicPlayerState.RESUME;
    }

    public void bce() {
        if (this.ngP != null) {
            if (this.ngP.isPlaying()) {
                this.ngP.stop();
            }
            this.ngP.release();
            this.ngP = null;
        }
    }
}
