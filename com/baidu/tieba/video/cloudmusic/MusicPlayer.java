package com.baidu.tieba.video.cloudmusic;

import android.media.MediaPlayer;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import java.io.IOException;
/* loaded from: classes2.dex */
public class MusicPlayer {
    private static MusicPlayer guw = null;
    private MediaPlayer guv;
    private MusicPlayerState gux = MusicPlayerState.WAIT;

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
        void bvx();
    }

    private MusicPlayer() {
    }

    public static synchronized MusicPlayer bvz() {
        MusicPlayer musicPlayer;
        synchronized (MusicPlayer.class) {
            if (guw == null) {
                guw = new MusicPlayer();
            }
            musicPlayer = guw;
        }
        return musicPlayer;
    }

    public void a(String str, final CloudMusicData.MusicTagList.MusicList musicList, a aVar) {
        if (this.gux != MusicPlayerState.PAUSE) {
            if (this.guv == null) {
                this.guv = new MediaPlayer();
                this.guv.setAudioStreamType(3);
            }
            try {
                this.guv.reset();
                this.guv.setDataSource(str);
                this.guv.prepare();
                this.gux = MusicPlayerState.WAIT;
                this.guv.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.cloudmusic.MusicPlayer.1
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        com.baidu.tieba.video.cloudmusic.data.a.bvC().a(musicList);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_CLOUD_MUSIC_PLAY));
                        MusicPlayer.this.guv.setLooping(true);
                        MusicPlayer.this.guv.start();
                        MusicPlayer.this.gux = MusicPlayerState.PREPARED;
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
                this.gux = MusicPlayerState.ERROR;
                if (aVar != null) {
                    aVar.bvx();
                }
            }
        }
    }

    public void bvA() {
        if (this.guv != null && this.guv.isPlaying()) {
            this.guv.pause();
        }
        this.gux = MusicPlayerState.PAUSE;
    }

    public void bvB() {
        if (this.guv != null) {
            this.guv.start();
            this.guv.seekTo(0);
        }
        this.gux = MusicPlayerState.RESUME;
    }

    public void ben() {
        if (this.guv != null) {
            if (this.guv.isPlaying()) {
                this.guv.stop();
            }
            this.guv.release();
            this.guv = null;
        }
    }
}
