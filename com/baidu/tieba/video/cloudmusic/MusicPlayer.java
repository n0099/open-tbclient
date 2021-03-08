package com.baidu.tieba.video.cloudmusic;

import android.media.MediaPlayer;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import java.io.IOException;
/* loaded from: classes7.dex */
public class MusicPlayer {
    private static MusicPlayer nNP = null;
    private MediaPlayer nNO;
    private MusicPlayerState nNQ = MusicPlayerState.WAIT;

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
        void dSx();
    }

    private MusicPlayer() {
    }

    public static synchronized MusicPlayer dSz() {
        MusicPlayer musicPlayer;
        synchronized (MusicPlayer.class) {
            if (nNP == null) {
                nNP = new MusicPlayer();
            }
            musicPlayer = nNP;
        }
        return musicPlayer;
    }

    public void a(String str, final CloudMusicData.MusicTagList.MusicList musicList, a aVar) {
        if (this.nNQ != MusicPlayerState.PAUSE) {
            if (this.nNO == null) {
                this.nNO = new MediaPlayer();
                this.nNO.setAudioStreamType(3);
            }
            try {
                this.nNO.reset();
                this.nNO.setDataSource(str);
                this.nNO.prepare();
                this.nNQ = MusicPlayerState.WAIT;
                this.nNO.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.cloudmusic.MusicPlayer.1
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        com.baidu.tieba.video.cloudmusic.data.a.dSC().a(musicList);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_CLOUD_MUSIC_PLAY));
                        MusicPlayer.this.nNO.setLooping(true);
                        MusicPlayer.this.nNO.start();
                        MusicPlayer.this.nNQ = MusicPlayerState.PREPARED;
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
                this.nNQ = MusicPlayerState.ERROR;
                if (aVar != null) {
                    aVar.dSx();
                }
            }
        }
    }

    public void dSA() {
        if (this.nNO != null && this.nNO.isPlaying()) {
            this.nNO.pause();
        }
        this.nNQ = MusicPlayerState.PAUSE;
    }

    public void dSB() {
        if (this.nNO != null) {
            this.nNO.start();
            this.nNO.seekTo(0);
        }
        this.nNQ = MusicPlayerState.RESUME;
    }

    public void bfV() {
        if (this.nNO != null) {
            if (this.nNO.isPlaying()) {
                this.nNO.stop();
            }
            this.nNO.release();
            this.nNO = null;
        }
    }
}
