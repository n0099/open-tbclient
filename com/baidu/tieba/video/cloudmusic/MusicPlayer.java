package com.baidu.tieba.video.cloudmusic;

import android.media.MediaPlayer;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import java.io.IOException;
/* loaded from: classes17.dex */
public class MusicPlayer {
    private static MusicPlayer mcO = null;
    private MediaPlayer mcN;
    private MusicPlayerState mcP = MusicPlayerState.WAIT;

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
        void dpK();
    }

    private MusicPlayer() {
    }

    public static synchronized MusicPlayer dpM() {
        MusicPlayer musicPlayer;
        synchronized (MusicPlayer.class) {
            if (mcO == null) {
                mcO = new MusicPlayer();
            }
            musicPlayer = mcO;
        }
        return musicPlayer;
    }

    public void a(String str, final CloudMusicData.MusicTagList.MusicList musicList, a aVar) {
        if (this.mcP != MusicPlayerState.PAUSE) {
            if (this.mcN == null) {
                this.mcN = new MediaPlayer();
                this.mcN.setAudioStreamType(3);
            }
            try {
                this.mcN.reset();
                this.mcN.setDataSource(str);
                this.mcN.prepare();
                this.mcP = MusicPlayerState.WAIT;
                this.mcN.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.cloudmusic.MusicPlayer.1
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        com.baidu.tieba.video.cloudmusic.data.a.dpP().a(musicList);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_CLOUD_MUSIC_PLAY));
                        MusicPlayer.this.mcN.setLooping(true);
                        MusicPlayer.this.mcN.start();
                        MusicPlayer.this.mcP = MusicPlayerState.PREPARED;
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
                this.mcP = MusicPlayerState.ERROR;
                if (aVar != null) {
                    aVar.dpK();
                }
            }
        }
    }

    public void dpN() {
        if (this.mcN != null && this.mcN.isPlaying()) {
            this.mcN.pause();
        }
        this.mcP = MusicPlayerState.PAUSE;
    }

    public void dpO() {
        if (this.mcN != null) {
            this.mcN.start();
            this.mcN.seekTo(0);
        }
        this.mcP = MusicPlayerState.RESUME;
    }

    public void aOt() {
        if (this.mcN != null) {
            if (this.mcN.isPlaying()) {
                this.mcN.stop();
            }
            this.mcN.release();
            this.mcN = null;
        }
    }
}
