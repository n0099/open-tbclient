package com.baidu.tieba.video.cloudmusic;

import android.media.MediaPlayer;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import java.io.IOException;
/* loaded from: classes22.dex */
public class MusicPlayer {
    private static MusicPlayer nnT = null;
    private MediaPlayer nnS;
    private MusicPlayerState nnU = MusicPlayerState.WAIT;

    /* loaded from: classes22.dex */
    public enum MusicPlayerState {
        WAIT,
        PAUSE,
        PREPARED,
        REPLAY,
        RESUME,
        ERROR
    }

    /* loaded from: classes22.dex */
    public interface a {
        void dOD();
    }

    private MusicPlayer() {
    }

    public static synchronized MusicPlayer dOF() {
        MusicPlayer musicPlayer;
        synchronized (MusicPlayer.class) {
            if (nnT == null) {
                nnT = new MusicPlayer();
            }
            musicPlayer = nnT;
        }
        return musicPlayer;
    }

    public void a(String str, final CloudMusicData.MusicTagList.MusicList musicList, a aVar) {
        if (this.nnU != MusicPlayerState.PAUSE) {
            if (this.nnS == null) {
                this.nnS = new MediaPlayer();
                this.nnS.setAudioStreamType(3);
            }
            try {
                this.nnS.reset();
                this.nnS.setDataSource(str);
                this.nnS.prepare();
                this.nnU = MusicPlayerState.WAIT;
                this.nnS.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.cloudmusic.MusicPlayer.1
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        com.baidu.tieba.video.cloudmusic.data.a.dOI().a(musicList);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_CLOUD_MUSIC_PLAY));
                        MusicPlayer.this.nnS.setLooping(true);
                        MusicPlayer.this.nnS.start();
                        MusicPlayer.this.nnU = MusicPlayerState.PREPARED;
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
                this.nnU = MusicPlayerState.ERROR;
                if (aVar != null) {
                    aVar.dOD();
                }
            }
        }
    }

    public void dOG() {
        if (this.nnS != null && this.nnS.isPlaying()) {
            this.nnS.pause();
        }
        this.nnU = MusicPlayerState.PAUSE;
    }

    public void dOH() {
        if (this.nnS != null) {
            this.nnS.start();
            this.nnS.seekTo(0);
        }
        this.nnU = MusicPlayerState.RESUME;
    }

    public void bdX() {
        if (this.nnS != null) {
            if (this.nnS.isPlaying()) {
                this.nnS.stop();
            }
            this.nnS.release();
            this.nnS = null;
        }
    }
}
