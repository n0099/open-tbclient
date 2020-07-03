package com.baidu.tieba.video.cloudmusic;

import android.media.MediaPlayer;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import java.io.IOException;
/* loaded from: classes10.dex */
public class MusicPlayer {
    private static MusicPlayer lVt = null;
    private MediaPlayer lVs;
    private MusicPlayerState lVu = MusicPlayerState.WAIT;

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
        void dmu();
    }

    private MusicPlayer() {
    }

    public static synchronized MusicPlayer dmw() {
        MusicPlayer musicPlayer;
        synchronized (MusicPlayer.class) {
            if (lVt == null) {
                lVt = new MusicPlayer();
            }
            musicPlayer = lVt;
        }
        return musicPlayer;
    }

    public void a(String str, final CloudMusicData.MusicTagList.MusicList musicList, a aVar) {
        if (this.lVu != MusicPlayerState.PAUSE) {
            if (this.lVs == null) {
                this.lVs = new MediaPlayer();
                this.lVs.setAudioStreamType(3);
            }
            try {
                this.lVs.reset();
                this.lVs.setDataSource(str);
                this.lVs.prepare();
                this.lVu = MusicPlayerState.WAIT;
                this.lVs.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.cloudmusic.MusicPlayer.1
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        com.baidu.tieba.video.cloudmusic.data.a.dmz().a(musicList);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_CLOUD_MUSIC_PLAY));
                        MusicPlayer.this.lVs.setLooping(true);
                        MusicPlayer.this.lVs.start();
                        MusicPlayer.this.lVu = MusicPlayerState.PREPARED;
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
                this.lVu = MusicPlayerState.ERROR;
                if (aVar != null) {
                    aVar.dmu();
                }
            }
        }
    }

    public void dmx() {
        if (this.lVs != null && this.lVs.isPlaying()) {
            this.lVs.pause();
        }
        this.lVu = MusicPlayerState.PAUSE;
    }

    public void dmy() {
        if (this.lVs != null) {
            this.lVs.start();
            this.lVs.seekTo(0);
        }
        this.lVu = MusicPlayerState.RESUME;
    }

    public void aKF() {
        if (this.lVs != null) {
            if (this.lVs.isPlaying()) {
                this.lVs.stop();
            }
            this.lVs.release();
            this.lVs = null;
        }
    }
}
