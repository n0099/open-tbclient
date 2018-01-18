package com.baidu.tieba.video.cloudmusic;

import android.media.MediaPlayer;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import java.io.IOException;
/* loaded from: classes2.dex */
public class MusicPlayer {
    private static MusicPlayer hnh = null;
    private MediaPlayer hng;
    private MusicPlayerState hni = MusicPlayerState.WAIT;

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
        void bAh();
    }

    private MusicPlayer() {
    }

    public static synchronized MusicPlayer bAj() {
        MusicPlayer musicPlayer;
        synchronized (MusicPlayer.class) {
            if (hnh == null) {
                hnh = new MusicPlayer();
            }
            musicPlayer = hnh;
        }
        return musicPlayer;
    }

    public void a(String str, final CloudMusicData.MusicTagList.MusicList musicList, a aVar) {
        if (this.hni != MusicPlayerState.PAUSE) {
            if (this.hng == null) {
                this.hng = new MediaPlayer();
                this.hng.setAudioStreamType(3);
            }
            try {
                this.hng.reset();
                this.hng.setDataSource(str);
                this.hng.prepare();
                this.hni = MusicPlayerState.WAIT;
                this.hng.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.cloudmusic.MusicPlayer.1
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        com.baidu.tieba.video.cloudmusic.data.a.bAm().a(musicList);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_CLOUD_MUSIC_PLAY));
                        MusicPlayer.this.hng.setLooping(true);
                        MusicPlayer.this.hng.start();
                        MusicPlayer.this.hni = MusicPlayerState.PREPARED;
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
                this.hni = MusicPlayerState.ERROR;
                if (aVar != null) {
                    aVar.bAh();
                }
            }
        }
    }

    public void bAk() {
        if (this.hng != null && this.hng.isPlaying()) {
            this.hng.pause();
        }
        this.hni = MusicPlayerState.PAUSE;
    }

    public void bAl() {
        if (this.hng != null) {
            this.hng.start();
            this.hng.seekTo(0);
        }
        this.hni = MusicPlayerState.RESUME;
    }

    public void bkd() {
        if (this.hng != null) {
            if (this.hng.isPlaying()) {
                this.hng.stop();
            }
            this.hng.release();
            this.hng = null;
        }
    }
}
