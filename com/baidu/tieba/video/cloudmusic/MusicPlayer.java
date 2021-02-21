package com.baidu.tieba.video.cloudmusic;

import android.media.MediaPlayer;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import java.io.IOException;
/* loaded from: classes8.dex */
public class MusicPlayer {
    private static MusicPlayer nLK = null;
    private MediaPlayer nLJ;
    private MusicPlayerState nLL = MusicPlayerState.WAIT;

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
        void dSp();
    }

    private MusicPlayer() {
    }

    public static synchronized MusicPlayer dSr() {
        MusicPlayer musicPlayer;
        synchronized (MusicPlayer.class) {
            if (nLK == null) {
                nLK = new MusicPlayer();
            }
            musicPlayer = nLK;
        }
        return musicPlayer;
    }

    public void a(String str, final CloudMusicData.MusicTagList.MusicList musicList, a aVar) {
        if (this.nLL != MusicPlayerState.PAUSE) {
            if (this.nLJ == null) {
                this.nLJ = new MediaPlayer();
                this.nLJ.setAudioStreamType(3);
            }
            try {
                this.nLJ.reset();
                this.nLJ.setDataSource(str);
                this.nLJ.prepare();
                this.nLL = MusicPlayerState.WAIT;
                this.nLJ.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.cloudmusic.MusicPlayer.1
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        com.baidu.tieba.video.cloudmusic.data.a.dSu().a(musicList);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_CLOUD_MUSIC_PLAY));
                        MusicPlayer.this.nLJ.setLooping(true);
                        MusicPlayer.this.nLJ.start();
                        MusicPlayer.this.nLL = MusicPlayerState.PREPARED;
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
                this.nLL = MusicPlayerState.ERROR;
                if (aVar != null) {
                    aVar.dSp();
                }
            }
        }
    }

    public void dSs() {
        if (this.nLJ != null && this.nLJ.isPlaying()) {
            this.nLJ.pause();
        }
        this.nLL = MusicPlayerState.PAUSE;
    }

    public void dSt() {
        if (this.nLJ != null) {
            this.nLJ.start();
            this.nLJ.seekTo(0);
        }
        this.nLL = MusicPlayerState.RESUME;
    }

    public void bfT() {
        if (this.nLJ != null) {
            if (this.nLJ.isPlaying()) {
                this.nLJ.stop();
            }
            this.nLJ.release();
            this.nLJ = null;
        }
    }
}
