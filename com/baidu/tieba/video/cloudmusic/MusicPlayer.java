package com.baidu.tieba.video.cloudmusic;

import android.media.MediaPlayer;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import java.io.IOException;
/* loaded from: classes10.dex */
public class MusicPlayer {
    private static MusicPlayer lBN = null;
    private MediaPlayer lBM;
    private MusicPlayerState lBO = MusicPlayerState.WAIT;

    /* loaded from: classes10.dex */
    public enum MusicPlayerState {
        WAIT,
        PAUSE,
        PREPARED,
        REPLAY,
        RESUME,
        ERROR
    }

    /* loaded from: classes10.dex */
    public interface a {
        void dij();
    }

    private MusicPlayer() {
    }

    public static synchronized MusicPlayer dil() {
        MusicPlayer musicPlayer;
        synchronized (MusicPlayer.class) {
            if (lBN == null) {
                lBN = new MusicPlayer();
            }
            musicPlayer = lBN;
        }
        return musicPlayer;
    }

    public void a(String str, final CloudMusicData.MusicTagList.MusicList musicList, a aVar) {
        if (this.lBO != MusicPlayerState.PAUSE) {
            if (this.lBM == null) {
                this.lBM = new MediaPlayer();
                this.lBM.setAudioStreamType(3);
            }
            try {
                this.lBM.reset();
                this.lBM.setDataSource(str);
                this.lBM.prepare();
                this.lBO = MusicPlayerState.WAIT;
                this.lBM.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.cloudmusic.MusicPlayer.1
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        com.baidu.tieba.video.cloudmusic.data.a.dio().a(musicList);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_CLOUD_MUSIC_PLAY));
                        MusicPlayer.this.lBM.setLooping(true);
                        MusicPlayer.this.lBM.start();
                        MusicPlayer.this.lBO = MusicPlayerState.PREPARED;
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
                this.lBO = MusicPlayerState.ERROR;
                if (aVar != null) {
                    aVar.dij();
                }
            }
        }
    }

    public void dim() {
        if (this.lBM != null && this.lBM.isPlaying()) {
            this.lBM.pause();
        }
        this.lBO = MusicPlayerState.PAUSE;
    }

    public void din() {
        if (this.lBM != null) {
            this.lBM.start();
            this.lBM.seekTo(0);
        }
        this.lBO = MusicPlayerState.RESUME;
    }

    public void aJz() {
        if (this.lBM != null) {
            if (this.lBM.isPlaying()) {
                this.lBM.stop();
            }
            this.lBM.release();
            this.lBM = null;
        }
    }
}
