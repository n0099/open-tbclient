package com.baidu.tieba.video.cloudmusic;

import android.media.MediaPlayer;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import java.io.IOException;
/* loaded from: classes17.dex */
public class MusicPlayer {
    private static MusicPlayer mcM = null;
    private MediaPlayer mcL;
    private MusicPlayerState mcN = MusicPlayerState.WAIT;

    /* loaded from: classes17.dex */
    public enum MusicPlayerState {
        WAIT,
        PAUSE,
        PREPARED,
        REPLAY,
        RESUME,
        ERROR
    }

    /* loaded from: classes17.dex */
    public interface a {
        void dpJ();
    }

    private MusicPlayer() {
    }

    public static synchronized MusicPlayer dpL() {
        MusicPlayer musicPlayer;
        synchronized (MusicPlayer.class) {
            if (mcM == null) {
                mcM = new MusicPlayer();
            }
            musicPlayer = mcM;
        }
        return musicPlayer;
    }

    public void a(String str, final CloudMusicData.MusicTagList.MusicList musicList, a aVar) {
        if (this.mcN != MusicPlayerState.PAUSE) {
            if (this.mcL == null) {
                this.mcL = new MediaPlayer();
                this.mcL.setAudioStreamType(3);
            }
            try {
                this.mcL.reset();
                this.mcL.setDataSource(str);
                this.mcL.prepare();
                this.mcN = MusicPlayerState.WAIT;
                this.mcL.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.cloudmusic.MusicPlayer.1
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        com.baidu.tieba.video.cloudmusic.data.a.dpO().a(musicList);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_CLOUD_MUSIC_PLAY));
                        MusicPlayer.this.mcL.setLooping(true);
                        MusicPlayer.this.mcL.start();
                        MusicPlayer.this.mcN = MusicPlayerState.PREPARED;
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
                this.mcN = MusicPlayerState.ERROR;
                if (aVar != null) {
                    aVar.dpJ();
                }
            }
        }
    }

    public void dpM() {
        if (this.mcL != null && this.mcL.isPlaying()) {
            this.mcL.pause();
        }
        this.mcN = MusicPlayerState.PAUSE;
    }

    public void dpN() {
        if (this.mcL != null) {
            this.mcL.start();
            this.mcL.seekTo(0);
        }
        this.mcN = MusicPlayerState.RESUME;
    }

    public void aOt() {
        if (this.mcL != null) {
            if (this.mcL.isPlaying()) {
                this.mcL.stop();
            }
            this.mcL.release();
            this.mcL = null;
        }
    }
}
