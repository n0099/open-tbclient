package com.baidu.tieba.video.cloudmusic;

import android.media.MediaPlayer;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import java.io.IOException;
/* loaded from: classes10.dex */
public class MusicPlayer {
    private static MusicPlayer kvI = null;
    private MediaPlayer kvH;
    private MusicPlayerState kvJ = MusicPlayerState.WAIT;

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
        void cPp();
    }

    private MusicPlayer() {
    }

    public static synchronized MusicPlayer cPr() {
        MusicPlayer musicPlayer;
        synchronized (MusicPlayer.class) {
            if (kvI == null) {
                kvI = new MusicPlayer();
            }
            musicPlayer = kvI;
        }
        return musicPlayer;
    }

    public void a(String str, final CloudMusicData.MusicTagList.MusicList musicList, a aVar) {
        if (this.kvJ != MusicPlayerState.PAUSE) {
            if (this.kvH == null) {
                this.kvH = new MediaPlayer();
                this.kvH.setAudioStreamType(3);
            }
            try {
                this.kvH.reset();
                this.kvH.setDataSource(str);
                this.kvH.prepare();
                this.kvJ = MusicPlayerState.WAIT;
                this.kvH.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.cloudmusic.MusicPlayer.1
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        com.baidu.tieba.video.cloudmusic.data.a.cPu().a(musicList);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_CLOUD_MUSIC_PLAY));
                        MusicPlayer.this.kvH.setLooping(true);
                        MusicPlayer.this.kvH.start();
                        MusicPlayer.this.kvJ = MusicPlayerState.PREPARED;
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
                this.kvJ = MusicPlayerState.ERROR;
                if (aVar != null) {
                    aVar.cPp();
                }
            }
        }
    }

    public void cPs() {
        if (this.kvH != null && this.kvH.isPlaying()) {
            this.kvH.pause();
        }
        this.kvJ = MusicPlayerState.PAUSE;
    }

    public void cPt() {
        if (this.kvH != null) {
            this.kvH.start();
            this.kvH.seekTo(0);
        }
        this.kvJ = MusicPlayerState.RESUME;
    }

    public void aWA() {
        if (this.kvH != null) {
            if (this.kvH.isPlaying()) {
                this.kvH.stop();
            }
            this.kvH.release();
            this.kvH = null;
        }
    }
}
