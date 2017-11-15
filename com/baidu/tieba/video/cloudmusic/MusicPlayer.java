package com.baidu.tieba.video.cloudmusic;

import android.media.MediaPlayer;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import java.io.IOException;
/* loaded from: classes2.dex */
public class MusicPlayer {
    private static MusicPlayer gEh = null;
    private MediaPlayer gEg;
    private MusicPlayerState gEi = MusicPlayerState.WAIT;

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
        void byD();
    }

    private MusicPlayer() {
    }

    public static synchronized MusicPlayer byF() {
        MusicPlayer musicPlayer;
        synchronized (MusicPlayer.class) {
            if (gEh == null) {
                gEh = new MusicPlayer();
            }
            musicPlayer = gEh;
        }
        return musicPlayer;
    }

    public void a(String str, final CloudMusicData.MusicTagList.MusicList musicList, a aVar) {
        if (this.gEi != MusicPlayerState.PAUSE) {
            if (this.gEg == null) {
                this.gEg = new MediaPlayer();
                this.gEg.setAudioStreamType(3);
            }
            try {
                this.gEg.reset();
                this.gEg.setDataSource(str);
                this.gEg.prepare();
                this.gEi = MusicPlayerState.WAIT;
                this.gEg.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.cloudmusic.MusicPlayer.1
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        com.baidu.tieba.video.cloudmusic.data.a.byI().a(musicList);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_CLOUD_MUSIC_PLAY));
                        MusicPlayer.this.gEg.setLooping(true);
                        MusicPlayer.this.gEg.start();
                        MusicPlayer.this.gEi = MusicPlayerState.PREPARED;
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
                this.gEi = MusicPlayerState.ERROR;
                if (aVar != null) {
                    aVar.byD();
                }
            }
        }
    }

    public void byG() {
        if (this.gEg != null && this.gEg.isPlaying()) {
            this.gEg.pause();
        }
        this.gEi = MusicPlayerState.PAUSE;
    }

    public void byH() {
        if (this.gEg != null) {
            this.gEg.start();
            this.gEg.seekTo(0);
        }
        this.gEi = MusicPlayerState.RESUME;
    }

    public void bhy() {
        if (this.gEg != null) {
            if (this.gEg.isPlaying()) {
                this.gEg.stop();
            }
            this.gEg.release();
            this.gEg = null;
        }
    }
}
