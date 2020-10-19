package com.baidu.tieba.video.cloudmusic;

import android.media.MediaPlayer;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import java.io.IOException;
/* loaded from: classes23.dex */
public class MusicPlayer {
    private static MusicPlayer mUq = null;
    private MediaPlayer mUp;
    private MusicPlayerState mUr = MusicPlayerState.WAIT;

    /* loaded from: classes23.dex */
    public enum MusicPlayerState {
        WAIT,
        PAUSE,
        PREPARED,
        REPLAY,
        RESUME,
        ERROR
    }

    /* loaded from: classes23.dex */
    public interface a {
        void dIU();
    }

    private MusicPlayer() {
    }

    public static synchronized MusicPlayer dIW() {
        MusicPlayer musicPlayer;
        synchronized (MusicPlayer.class) {
            if (mUq == null) {
                mUq = new MusicPlayer();
            }
            musicPlayer = mUq;
        }
        return musicPlayer;
    }

    public void a(String str, final CloudMusicData.MusicTagList.MusicList musicList, a aVar) {
        if (this.mUr != MusicPlayerState.PAUSE) {
            if (this.mUp == null) {
                this.mUp = new MediaPlayer();
                this.mUp.setAudioStreamType(3);
            }
            try {
                this.mUp.reset();
                this.mUp.setDataSource(str);
                this.mUp.prepare();
                this.mUr = MusicPlayerState.WAIT;
                this.mUp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.cloudmusic.MusicPlayer.1
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        com.baidu.tieba.video.cloudmusic.data.a.dIZ().a(musicList);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_CLOUD_MUSIC_PLAY));
                        MusicPlayer.this.mUp.setLooping(true);
                        MusicPlayer.this.mUp.start();
                        MusicPlayer.this.mUr = MusicPlayerState.PREPARED;
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
                this.mUr = MusicPlayerState.ERROR;
                if (aVar != null) {
                    aVar.dIU();
                }
            }
        }
    }

    public void dIX() {
        if (this.mUp != null && this.mUp.isPlaying()) {
            this.mUp.pause();
        }
        this.mUr = MusicPlayerState.PAUSE;
    }

    public void dIY() {
        if (this.mUp != null) {
            this.mUp.start();
            this.mUp.seekTo(0);
        }
        this.mUr = MusicPlayerState.RESUME;
    }

    public void bal() {
        if (this.mUp != null) {
            if (this.mUp.isPlaying()) {
                this.mUp.stop();
            }
            this.mUp.release();
            this.mUp = null;
        }
    }
}
