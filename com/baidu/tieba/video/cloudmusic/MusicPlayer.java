package com.baidu.tieba.video.cloudmusic;

import android.media.MediaPlayer;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import java.io.IOException;
/* loaded from: classes10.dex */
public class MusicPlayer {
    private static MusicPlayer kxA = null;
    private MusicPlayerState kxB = MusicPlayerState.WAIT;
    private MediaPlayer kxz;

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
        void cPM();
    }

    private MusicPlayer() {
    }

    public static synchronized MusicPlayer cPO() {
        MusicPlayer musicPlayer;
        synchronized (MusicPlayer.class) {
            if (kxA == null) {
                kxA = new MusicPlayer();
            }
            musicPlayer = kxA;
        }
        return musicPlayer;
    }

    public void a(String str, final CloudMusicData.MusicTagList.MusicList musicList, a aVar) {
        if (this.kxB != MusicPlayerState.PAUSE) {
            if (this.kxz == null) {
                this.kxz = new MediaPlayer();
                this.kxz.setAudioStreamType(3);
            }
            try {
                this.kxz.reset();
                this.kxz.setDataSource(str);
                this.kxz.prepare();
                this.kxB = MusicPlayerState.WAIT;
                this.kxz.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.cloudmusic.MusicPlayer.1
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        com.baidu.tieba.video.cloudmusic.data.a.cPR().a(musicList);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_CLOUD_MUSIC_PLAY));
                        MusicPlayer.this.kxz.setLooping(true);
                        MusicPlayer.this.kxz.start();
                        MusicPlayer.this.kxB = MusicPlayerState.PREPARED;
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
                this.kxB = MusicPlayerState.ERROR;
                if (aVar != null) {
                    aVar.cPM();
                }
            }
        }
    }

    public void cPP() {
        if (this.kxz != null && this.kxz.isPlaying()) {
            this.kxz.pause();
        }
        this.kxB = MusicPlayerState.PAUSE;
    }

    public void cPQ() {
        if (this.kxz != null) {
            this.kxz.start();
            this.kxz.seekTo(0);
        }
        this.kxB = MusicPlayerState.RESUME;
    }

    public void aWH() {
        if (this.kxz != null) {
            if (this.kxz.isPlaying()) {
                this.kxz.stop();
            }
            this.kxz.release();
            this.kxz = null;
        }
    }
}
