package com.baidu.tieba.video.cloudmusic;

import android.media.MediaPlayer;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import java.io.IOException;
/* loaded from: classes17.dex */
public class MusicPlayer {
    private static MusicPlayer muz = null;
    private MusicPlayerState muA = MusicPlayerState.WAIT;
    private MediaPlayer muy;

    /* loaded from: classes17.dex */
    public enum MusicPlayerState {
        WAIT,
        PAUSE,
        PREPARED,
        REPLAY,
        RESUME,
        ERROR
    }

    /* loaded from: classes17.dex */
    public interface a {
        void dBf();
    }

    private MusicPlayer() {
    }

    public static synchronized MusicPlayer dBh() {
        MusicPlayer musicPlayer;
        synchronized (MusicPlayer.class) {
            if (muz == null) {
                muz = new MusicPlayer();
            }
            musicPlayer = muz;
        }
        return musicPlayer;
    }

    public void a(String str, final CloudMusicData.MusicTagList.MusicList musicList, a aVar) {
        if (this.muA != MusicPlayerState.PAUSE) {
            if (this.muy == null) {
                this.muy = new MediaPlayer();
                this.muy.setAudioStreamType(3);
            }
            try {
                this.muy.reset();
                this.muy.setDataSource(str);
                this.muy.prepare();
                this.muA = MusicPlayerState.WAIT;
                this.muy.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.cloudmusic.MusicPlayer.1
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        com.baidu.tieba.video.cloudmusic.data.a.dBk().a(musicList);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_CLOUD_MUSIC_PLAY));
                        MusicPlayer.this.muy.setLooping(true);
                        MusicPlayer.this.muy.start();
                        MusicPlayer.this.muA = MusicPlayerState.PREPARED;
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
                this.muA = MusicPlayerState.ERROR;
                if (aVar != null) {
                    aVar.dBf();
                }
            }
        }
    }

    public void dBi() {
        if (this.muy != null && this.muy.isPlaying()) {
            this.muy.pause();
        }
        this.muA = MusicPlayerState.PAUSE;
    }

    public void dBj() {
        if (this.muy != null) {
            this.muy.start();
            this.muy.seekTo(0);
        }
        this.muA = MusicPlayerState.RESUME;
    }

    public void aWR() {
        if (this.muy != null) {
            if (this.muy.isPlaying()) {
                this.muy.stop();
            }
            this.muy.release();
            this.muy = null;
        }
    }
}
