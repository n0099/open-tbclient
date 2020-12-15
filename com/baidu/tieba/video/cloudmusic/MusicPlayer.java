package com.baidu.tieba.video.cloudmusic;

import android.media.MediaPlayer;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import java.io.IOException;
/* loaded from: classes23.dex */
public class MusicPlayer {
    private static MusicPlayer nBY = null;
    private MediaPlayer nBX;
    private MusicPlayerState nBZ = MusicPlayerState.WAIT;

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
        void dTW();
    }

    private MusicPlayer() {
    }

    public static synchronized MusicPlayer dTY() {
        MusicPlayer musicPlayer;
        synchronized (MusicPlayer.class) {
            if (nBY == null) {
                nBY = new MusicPlayer();
            }
            musicPlayer = nBY;
        }
        return musicPlayer;
    }

    public void a(String str, final CloudMusicData.MusicTagList.MusicList musicList, a aVar) {
        if (this.nBZ != MusicPlayerState.PAUSE) {
            if (this.nBX == null) {
                this.nBX = new MediaPlayer();
                this.nBX.setAudioStreamType(3);
            }
            try {
                this.nBX.reset();
                this.nBX.setDataSource(str);
                this.nBX.prepare();
                this.nBZ = MusicPlayerState.WAIT;
                this.nBX.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.cloudmusic.MusicPlayer.1
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        com.baidu.tieba.video.cloudmusic.data.a.dUb().a(musicList);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_CLOUD_MUSIC_PLAY));
                        MusicPlayer.this.nBX.setLooping(true);
                        MusicPlayer.this.nBX.start();
                        MusicPlayer.this.nBZ = MusicPlayerState.PREPARED;
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
                this.nBZ = MusicPlayerState.ERROR;
                if (aVar != null) {
                    aVar.dTW();
                }
            }
        }
    }

    public void dTZ() {
        if (this.nBX != null && this.nBX.isPlaying()) {
            this.nBX.pause();
        }
        this.nBZ = MusicPlayerState.PAUSE;
    }

    public void dUa() {
        if (this.nBX != null) {
            this.nBX.start();
            this.nBX.seekTo(0);
        }
        this.nBZ = MusicPlayerState.RESUME;
    }

    public void bhc() {
        if (this.nBX != null) {
            if (this.nBX.isPlaying()) {
                this.nBX.stop();
            }
            this.nBX.release();
            this.nBX = null;
        }
    }
}
