package com.baidu.tieba.video.cloudmusic;

import android.media.MediaPlayer;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import java.io.IOException;
/* loaded from: classes8.dex */
public class MusicPlayer {
    private static MusicPlayer nGf = null;
    private MediaPlayer nGe;
    private MusicPlayerState nGg = MusicPlayerState.WAIT;

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
        void dTN();
    }

    private MusicPlayer() {
    }

    public static synchronized MusicPlayer dTP() {
        MusicPlayer musicPlayer;
        synchronized (MusicPlayer.class) {
            if (nGf == null) {
                nGf = new MusicPlayer();
            }
            musicPlayer = nGf;
        }
        return musicPlayer;
    }

    public void a(String str, final CloudMusicData.MusicTagList.MusicList musicList, a aVar) {
        if (this.nGg != MusicPlayerState.PAUSE) {
            if (this.nGe == null) {
                this.nGe = new MediaPlayer();
                this.nGe.setAudioStreamType(3);
            }
            try {
                this.nGe.reset();
                this.nGe.setDataSource(str);
                this.nGe.prepare();
                this.nGg = MusicPlayerState.WAIT;
                this.nGe.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.cloudmusic.MusicPlayer.1
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        com.baidu.tieba.video.cloudmusic.data.a.dTS().a(musicList);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_CLOUD_MUSIC_PLAY));
                        MusicPlayer.this.nGe.setLooping(true);
                        MusicPlayer.this.nGe.start();
                        MusicPlayer.this.nGg = MusicPlayerState.PREPARED;
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
                this.nGg = MusicPlayerState.ERROR;
                if (aVar != null) {
                    aVar.dTN();
                }
            }
        }
    }

    public void dTQ() {
        if (this.nGe != null && this.nGe.isPlaying()) {
            this.nGe.pause();
        }
        this.nGg = MusicPlayerState.PAUSE;
    }

    public void dTR() {
        if (this.nGe != null) {
            this.nGe.start();
            this.nGe.seekTo(0);
        }
        this.nGg = MusicPlayerState.RESUME;
    }

    public void bjz() {
        if (this.nGe != null) {
            if (this.nGe.isPlaying()) {
                this.nGe.stop();
            }
            this.nGe.release();
            this.nGe = null;
        }
    }
}
