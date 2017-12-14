package com.baidu.tieba.video.cloudmusic;

import android.media.MediaPlayer;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import java.io.IOException;
/* loaded from: classes2.dex */
public class MusicPlayer {
    private static MusicPlayer gQx = null;
    private MediaPlayer gQw;
    private MusicPlayerState gQy = MusicPlayerState.WAIT;

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
            if (gQx == null) {
                gQx = new MusicPlayer();
            }
            musicPlayer = gQx;
        }
        return musicPlayer;
    }

    public void a(String str, final CloudMusicData.MusicTagList.MusicList musicList, a aVar) {
        if (this.gQy != MusicPlayerState.PAUSE) {
            if (this.gQw == null) {
                this.gQw = new MediaPlayer();
                this.gQw.setAudioStreamType(3);
            }
            try {
                this.gQw.reset();
                this.gQw.setDataSource(str);
                this.gQw.prepare();
                this.gQy = MusicPlayerState.WAIT;
                this.gQw.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.cloudmusic.MusicPlayer.1
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        com.baidu.tieba.video.cloudmusic.data.a.bBs().a(musicList);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_CLOUD_MUSIC_PLAY));
                        MusicPlayer.this.gQw.setLooping(true);
                        MusicPlayer.this.gQw.start();
                        MusicPlayer.this.gQy = MusicPlayerState.PREPARED;
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
                this.gQy = MusicPlayerState.ERROR;
                if (aVar != null) {
                    aVar.bBn();
                }
            }
        }
    }

    public void bBq() {
        if (this.gQw != null && this.gQw.isPlaying()) {
            this.gQw.pause();
        }
        this.gQy = MusicPlayerState.PAUSE;
    }

    public void bBr() {
        if (this.gQw != null) {
            this.gQw.start();
            this.gQw.seekTo(0);
        }
        this.gQy = MusicPlayerState.RESUME;
    }

    public void bjo() {
        if (this.gQw != null) {
            if (this.gQw.isPlaying()) {
                this.gQw.stop();
            }
            this.gQw.release();
            this.gQw = null;
        }
    }
}
