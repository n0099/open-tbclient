package com.baidu.tieba.video.cloudmusic;

import android.media.MediaPlayer;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import java.io.IOException;
/* loaded from: classes2.dex */
public class MusicPlayer {
    private static MusicPlayer hnB = null;
    private MediaPlayer hnA;
    private MusicPlayerState hnC = MusicPlayerState.WAIT;

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
        void bAj();
    }

    private MusicPlayer() {
    }

    public static synchronized MusicPlayer bAl() {
        MusicPlayer musicPlayer;
        synchronized (MusicPlayer.class) {
            if (hnB == null) {
                hnB = new MusicPlayer();
            }
            musicPlayer = hnB;
        }
        return musicPlayer;
    }

    public void a(String str, final CloudMusicData.MusicTagList.MusicList musicList, a aVar) {
        if (this.hnC != MusicPlayerState.PAUSE) {
            if (this.hnA == null) {
                this.hnA = new MediaPlayer();
                this.hnA.setAudioStreamType(3);
            }
            try {
                this.hnA.reset();
                this.hnA.setDataSource(str);
                this.hnA.prepare();
                this.hnC = MusicPlayerState.WAIT;
                this.hnA.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.cloudmusic.MusicPlayer.1
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        com.baidu.tieba.video.cloudmusic.data.a.bAo().a(musicList);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_CLOUD_MUSIC_PLAY));
                        MusicPlayer.this.hnA.setLooping(true);
                        MusicPlayer.this.hnA.start();
                        MusicPlayer.this.hnC = MusicPlayerState.PREPARED;
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
                this.hnC = MusicPlayerState.ERROR;
                if (aVar != null) {
                    aVar.bAj();
                }
            }
        }
    }

    public void bAm() {
        if (this.hnA != null && this.hnA.isPlaying()) {
            this.hnA.pause();
        }
        this.hnC = MusicPlayerState.PAUSE;
    }

    public void bAn() {
        if (this.hnA != null) {
            this.hnA.start();
            this.hnA.seekTo(0);
        }
        this.hnC = MusicPlayerState.RESUME;
    }

    public void bke() {
        if (this.hnA != null) {
            if (this.hnA.isPlaying()) {
                this.hnA.stop();
            }
            this.hnA.release();
            this.hnA = null;
        }
    }
}
