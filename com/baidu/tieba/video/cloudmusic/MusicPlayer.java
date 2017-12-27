package com.baidu.tieba.video.cloudmusic;

import android.media.MediaPlayer;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import java.io.IOException;
/* loaded from: classes2.dex */
public class MusicPlayer {
    private static MusicPlayer hxE = null;
    private MediaPlayer hxD;
    private MusicPlayerState hxF = MusicPlayerState.WAIT;

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
        void bGK();
    }

    private MusicPlayer() {
    }

    public static synchronized MusicPlayer bGM() {
        MusicPlayer musicPlayer;
        synchronized (MusicPlayer.class) {
            if (hxE == null) {
                hxE = new MusicPlayer();
            }
            musicPlayer = hxE;
        }
        return musicPlayer;
    }

    public void a(String str, final CloudMusicData.MusicTagList.MusicList musicList, a aVar) {
        if (this.hxF != MusicPlayerState.PAUSE) {
            if (this.hxD == null) {
                this.hxD = new MediaPlayer();
                this.hxD.setAudioStreamType(3);
            }
            try {
                this.hxD.reset();
                this.hxD.setDataSource(str);
                this.hxD.prepare();
                this.hxF = MusicPlayerState.WAIT;
                this.hxD.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.cloudmusic.MusicPlayer.1
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        com.baidu.tieba.video.cloudmusic.data.a.bGP().a(musicList);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_CLOUD_MUSIC_PLAY));
                        MusicPlayer.this.hxD.setLooping(true);
                        MusicPlayer.this.hxD.start();
                        MusicPlayer.this.hxF = MusicPlayerState.PREPARED;
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
                this.hxF = MusicPlayerState.ERROR;
                if (aVar != null) {
                    aVar.bGK();
                }
            }
        }
    }

    public void bGN() {
        if (this.hxD != null && this.hxD.isPlaying()) {
            this.hxD.pause();
        }
        this.hxF = MusicPlayerState.PAUSE;
    }

    public void bGO() {
        if (this.hxD != null) {
            this.hxD.start();
            this.hxD.seekTo(0);
        }
        this.hxF = MusicPlayerState.RESUME;
    }

    public void bqK() {
        if (this.hxD != null) {
            if (this.hxD.isPlaying()) {
                this.hxD.stop();
            }
            this.hxD.release();
            this.hxD = null;
        }
    }
}
