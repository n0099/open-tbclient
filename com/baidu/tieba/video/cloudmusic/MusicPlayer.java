package com.baidu.tieba.video.cloudmusic;

import android.media.MediaPlayer;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import java.io.IOException;
/* loaded from: classes23.dex */
public class MusicPlayer {
    private static MusicPlayer nBW = null;
    private MediaPlayer nBV;
    private MusicPlayerState nBX = MusicPlayerState.WAIT;

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
        void dTV();
    }

    private MusicPlayer() {
    }

    public static synchronized MusicPlayer dTX() {
        MusicPlayer musicPlayer;
        synchronized (MusicPlayer.class) {
            if (nBW == null) {
                nBW = new MusicPlayer();
            }
            musicPlayer = nBW;
        }
        return musicPlayer;
    }

    public void a(String str, final CloudMusicData.MusicTagList.MusicList musicList, a aVar) {
        if (this.nBX != MusicPlayerState.PAUSE) {
            if (this.nBV == null) {
                this.nBV = new MediaPlayer();
                this.nBV.setAudioStreamType(3);
            }
            try {
                this.nBV.reset();
                this.nBV.setDataSource(str);
                this.nBV.prepare();
                this.nBX = MusicPlayerState.WAIT;
                this.nBV.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.cloudmusic.MusicPlayer.1
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        com.baidu.tieba.video.cloudmusic.data.a.dUa().a(musicList);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_CLOUD_MUSIC_PLAY));
                        MusicPlayer.this.nBV.setLooping(true);
                        MusicPlayer.this.nBV.start();
                        MusicPlayer.this.nBX = MusicPlayerState.PREPARED;
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
                this.nBX = MusicPlayerState.ERROR;
                if (aVar != null) {
                    aVar.dTV();
                }
            }
        }
    }

    public void dTY() {
        if (this.nBV != null && this.nBV.isPlaying()) {
            this.nBV.pause();
        }
        this.nBX = MusicPlayerState.PAUSE;
    }

    public void dTZ() {
        if (this.nBV != null) {
            this.nBV.start();
            this.nBV.seekTo(0);
        }
        this.nBX = MusicPlayerState.RESUME;
    }

    public void bhc() {
        if (this.nBV != null) {
            if (this.nBV.isPlaying()) {
                this.nBV.stop();
            }
            this.nBV.release();
            this.nBV = null;
        }
    }
}
