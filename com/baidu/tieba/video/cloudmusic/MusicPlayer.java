package com.baidu.tieba.video.cloudmusic;

import android.media.MediaPlayer;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import java.io.IOException;
/* loaded from: classes2.dex */
public class MusicPlayer {
    private static MusicPlayer gNP = null;
    private MediaPlayer gNO;
    private MusicPlayerState gNQ = MusicPlayerState.WAIT;

    /* loaded from: classes2.dex */
    public enum MusicPlayerState {
        WAIT,
        PAUSE,
        PREPARED,
        REPLAY,
        RESUME,
        ERROR
    }

    /* loaded from: classes2.dex */
    public interface a {
        void bAG();
    }

    private MusicPlayer() {
    }

    public static synchronized MusicPlayer bAI() {
        MusicPlayer musicPlayer;
        synchronized (MusicPlayer.class) {
            if (gNP == null) {
                gNP = new MusicPlayer();
            }
            musicPlayer = gNP;
        }
        return musicPlayer;
    }

    public void a(String str, final CloudMusicData.MusicTagList.MusicList musicList, a aVar) {
        if (this.gNQ != MusicPlayerState.PAUSE) {
            if (this.gNO == null) {
                this.gNO = new MediaPlayer();
                this.gNO.setAudioStreamType(3);
            }
            try {
                this.gNO.reset();
                this.gNO.setDataSource(str);
                this.gNO.prepare();
                this.gNQ = MusicPlayerState.WAIT;
                this.gNO.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.cloudmusic.MusicPlayer.1
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        com.baidu.tieba.video.cloudmusic.data.a.bAL().a(musicList);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_CLOUD_MUSIC_PLAY));
                        MusicPlayer.this.gNO.setLooping(true);
                        MusicPlayer.this.gNO.start();
                        MusicPlayer.this.gNQ = MusicPlayerState.PREPARED;
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
                this.gNQ = MusicPlayerState.ERROR;
                if (aVar != null) {
                    aVar.bAG();
                }
            }
        }
    }

    public void bAJ() {
        if (this.gNO != null && this.gNO.isPlaying()) {
            this.gNO.pause();
        }
        this.gNQ = MusicPlayerState.PAUSE;
    }

    public void bAK() {
        if (this.gNO != null) {
            this.gNO.start();
            this.gNO.seekTo(0);
        }
        this.gNQ = MusicPlayerState.RESUME;
    }

    public void bjf() {
        if (this.gNO != null) {
            if (this.gNO.isPlaying()) {
                this.gNO.stop();
            }
            this.gNO.release();
            this.gNO = null;
        }
    }
}
