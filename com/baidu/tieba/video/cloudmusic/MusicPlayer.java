package com.baidu.tieba.video.cloudmusic;

import android.media.MediaPlayer;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import java.io.IOException;
/* loaded from: classes8.dex */
public class MusicPlayer {
    private static MusicPlayer nLk = null;
    private MediaPlayer nLj;
    private MusicPlayerState nLl = MusicPlayerState.WAIT;

    /* loaded from: classes8.dex */
    public enum MusicPlayerState {
        WAIT,
        PAUSE,
        PREPARED,
        REPLAY,
        RESUME,
        ERROR
    }

    /* loaded from: classes8.dex */
    public interface a {
        void dSh();
    }

    private MusicPlayer() {
    }

    public static synchronized MusicPlayer dSj() {
        MusicPlayer musicPlayer;
        synchronized (MusicPlayer.class) {
            if (nLk == null) {
                nLk = new MusicPlayer();
            }
            musicPlayer = nLk;
        }
        return musicPlayer;
    }

    public void a(String str, final CloudMusicData.MusicTagList.MusicList musicList, a aVar) {
        if (this.nLl != MusicPlayerState.PAUSE) {
            if (this.nLj == null) {
                this.nLj = new MediaPlayer();
                this.nLj.setAudioStreamType(3);
            }
            try {
                this.nLj.reset();
                this.nLj.setDataSource(str);
                this.nLj.prepare();
                this.nLl = MusicPlayerState.WAIT;
                this.nLj.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.cloudmusic.MusicPlayer.1
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        com.baidu.tieba.video.cloudmusic.data.a.dSm().a(musicList);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_CLOUD_MUSIC_PLAY));
                        MusicPlayer.this.nLj.setLooping(true);
                        MusicPlayer.this.nLj.start();
                        MusicPlayer.this.nLl = MusicPlayerState.PREPARED;
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
                this.nLl = MusicPlayerState.ERROR;
                if (aVar != null) {
                    aVar.dSh();
                }
            }
        }
    }

    public void dSk() {
        if (this.nLj != null && this.nLj.isPlaying()) {
            this.nLj.pause();
        }
        this.nLl = MusicPlayerState.PAUSE;
    }

    public void dSl() {
        if (this.nLj != null) {
            this.nLj.start();
            this.nLj.seekTo(0);
        }
        this.nLl = MusicPlayerState.RESUME;
    }

    public void bfT() {
        if (this.nLj != null) {
            if (this.nLj.isPlaying()) {
                this.nLj.stop();
            }
            this.nLj.release();
            this.nLj = null;
        }
    }
}
