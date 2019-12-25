package com.baidu.tieba.video.cloudmusic;

import android.media.MediaPlayer;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import java.io.IOException;
/* loaded from: classes7.dex */
public class MusicPlayer {
    private static MusicPlayer krd = null;
    private MediaPlayer krc;
    private MusicPlayerState kre = MusicPlayerState.WAIT;

    /* loaded from: classes7.dex */
    public enum MusicPlayerState {
        WAIT,
        PAUSE,
        PREPARED,
        REPLAY,
        RESUME,
        ERROR
    }

    /* loaded from: classes7.dex */
    public interface a {
        void cMN();
    }

    private MusicPlayer() {
    }

    public static synchronized MusicPlayer cMP() {
        MusicPlayer musicPlayer;
        synchronized (MusicPlayer.class) {
            if (krd == null) {
                krd = new MusicPlayer();
            }
            musicPlayer = krd;
        }
        return musicPlayer;
    }

    public void a(String str, final CloudMusicData.MusicTagList.MusicList musicList, a aVar) {
        if (this.kre != MusicPlayerState.PAUSE) {
            if (this.krc == null) {
                this.krc = new MediaPlayer();
                this.krc.setAudioStreamType(3);
            }
            try {
                this.krc.reset();
                this.krc.setDataSource(str);
                this.krc.prepare();
                this.kre = MusicPlayerState.WAIT;
                this.krc.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.cloudmusic.MusicPlayer.1
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        com.baidu.tieba.video.cloudmusic.data.a.cMS().a(musicList);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_CLOUD_MUSIC_PLAY));
                        MusicPlayer.this.krc.setLooping(true);
                        MusicPlayer.this.krc.start();
                        MusicPlayer.this.kre = MusicPlayerState.PREPARED;
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
                this.kre = MusicPlayerState.ERROR;
                if (aVar != null) {
                    aVar.cMN();
                }
            }
        }
    }

    public void cMQ() {
        if (this.krc != null && this.krc.isPlaying()) {
            this.krc.pause();
        }
        this.kre = MusicPlayerState.PAUSE;
    }

    public void cMR() {
        if (this.krc != null) {
            this.krc.start();
            this.krc.seekTo(0);
        }
        this.kre = MusicPlayerState.RESUME;
    }

    public void aTQ() {
        if (this.krc != null) {
            if (this.krc.isPlaying()) {
                this.krc.stop();
            }
            this.krc.release();
            this.krc = null;
        }
    }
}
