package com.baidu.tieba.video.cloudmusic;

import android.media.MediaPlayer;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import java.io.IOException;
/* loaded from: classes10.dex */
public class MusicPlayer {
    private static MusicPlayer kvK = null;
    private MediaPlayer kvJ;
    private MusicPlayerState kvL = MusicPlayerState.WAIT;

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
        void cPr();
    }

    private MusicPlayer() {
    }

    public static synchronized MusicPlayer cPt() {
        MusicPlayer musicPlayer;
        synchronized (MusicPlayer.class) {
            if (kvK == null) {
                kvK = new MusicPlayer();
            }
            musicPlayer = kvK;
        }
        return musicPlayer;
    }

    public void a(String str, final CloudMusicData.MusicTagList.MusicList musicList, a aVar) {
        if (this.kvL != MusicPlayerState.PAUSE) {
            if (this.kvJ == null) {
                this.kvJ = new MediaPlayer();
                this.kvJ.setAudioStreamType(3);
            }
            try {
                this.kvJ.reset();
                this.kvJ.setDataSource(str);
                this.kvJ.prepare();
                this.kvL = MusicPlayerState.WAIT;
                this.kvJ.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.cloudmusic.MusicPlayer.1
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        com.baidu.tieba.video.cloudmusic.data.a.cPw().a(musicList);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_CLOUD_MUSIC_PLAY));
                        MusicPlayer.this.kvJ.setLooping(true);
                        MusicPlayer.this.kvJ.start();
                        MusicPlayer.this.kvL = MusicPlayerState.PREPARED;
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
                this.kvL = MusicPlayerState.ERROR;
                if (aVar != null) {
                    aVar.cPr();
                }
            }
        }
    }

    public void cPu() {
        if (this.kvJ != null && this.kvJ.isPlaying()) {
            this.kvJ.pause();
        }
        this.kvL = MusicPlayerState.PAUSE;
    }

    public void cPv() {
        if (this.kvJ != null) {
            this.kvJ.start();
            this.kvJ.seekTo(0);
        }
        this.kvL = MusicPlayerState.RESUME;
    }

    public void aWC() {
        if (this.kvJ != null) {
            if (this.kvJ.isPlaying()) {
                this.kvJ.stop();
            }
            this.kvJ.release();
            this.kvJ = null;
        }
    }
}
