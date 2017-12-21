package com.baidu.tieba.video.cloudmusic;

import android.media.MediaPlayer;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import java.io.IOException;
/* loaded from: classes2.dex */
public class MusicPlayer {
    private static MusicPlayer gQC = null;
    private MediaPlayer gQB;
    private MusicPlayerState gQD = MusicPlayerState.WAIT;

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
        void bBn();
    }

    private MusicPlayer() {
    }

    public static synchronized MusicPlayer bBp() {
        MusicPlayer musicPlayer;
        synchronized (MusicPlayer.class) {
            if (gQC == null) {
                gQC = new MusicPlayer();
            }
            musicPlayer = gQC;
        }
        return musicPlayer;
    }

    public void a(String str, final CloudMusicData.MusicTagList.MusicList musicList, a aVar) {
        if (this.gQD != MusicPlayerState.PAUSE) {
            if (this.gQB == null) {
                this.gQB = new MediaPlayer();
                this.gQB.setAudioStreamType(3);
            }
            try {
                this.gQB.reset();
                this.gQB.setDataSource(str);
                this.gQB.prepare();
                this.gQD = MusicPlayerState.WAIT;
                this.gQB.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.cloudmusic.MusicPlayer.1
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        com.baidu.tieba.video.cloudmusic.data.a.bBs().a(musicList);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_CLOUD_MUSIC_PLAY));
                        MusicPlayer.this.gQB.setLooping(true);
                        MusicPlayer.this.gQB.start();
                        MusicPlayer.this.gQD = MusicPlayerState.PREPARED;
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
                this.gQD = MusicPlayerState.ERROR;
                if (aVar != null) {
                    aVar.bBn();
                }
            }
        }
    }

    public void bBq() {
        if (this.gQB != null && this.gQB.isPlaying()) {
            this.gQB.pause();
        }
        this.gQD = MusicPlayerState.PAUSE;
    }

    public void bBr() {
        if (this.gQB != null) {
            this.gQB.start();
            this.gQB.seekTo(0);
        }
        this.gQD = MusicPlayerState.RESUME;
    }

    public void bjo() {
        if (this.gQB != null) {
            if (this.gQB.isPlaying()) {
                this.gQB.stop();
            }
            this.gQB.release();
            this.gQB = null;
        }
    }
}
