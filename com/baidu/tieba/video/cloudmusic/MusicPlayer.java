package com.baidu.tieba.video.cloudmusic;

import android.media.MediaPlayer;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import java.io.IOException;
/* loaded from: classes7.dex */
public class MusicPlayer {
    private static MusicPlayer nBA = null;
    private MusicPlayerState nBB = MusicPlayerState.WAIT;
    private MediaPlayer nBz;

    /* loaded from: classes7.dex */
    public enum MusicPlayerState {
        WAIT,
        PAUSE,
        PREPARED,
        REPLAY,
        RESUME,
        ERROR
    }

    /* loaded from: classes7.dex */
    public interface a {
        void dPW();
    }

    private MusicPlayer() {
    }

    public static synchronized MusicPlayer dPY() {
        MusicPlayer musicPlayer;
        synchronized (MusicPlayer.class) {
            if (nBA == null) {
                nBA = new MusicPlayer();
            }
            musicPlayer = nBA;
        }
        return musicPlayer;
    }

    public void a(String str, final CloudMusicData.MusicTagList.MusicList musicList, a aVar) {
        if (this.nBB != MusicPlayerState.PAUSE) {
            if (this.nBz == null) {
                this.nBz = new MediaPlayer();
                this.nBz.setAudioStreamType(3);
            }
            try {
                this.nBz.reset();
                this.nBz.setDataSource(str);
                this.nBz.prepare();
                this.nBB = MusicPlayerState.WAIT;
                this.nBz.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.cloudmusic.MusicPlayer.1
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        com.baidu.tieba.video.cloudmusic.data.a.dQb().a(musicList);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_CLOUD_MUSIC_PLAY));
                        MusicPlayer.this.nBz.setLooping(true);
                        MusicPlayer.this.nBz.start();
                        MusicPlayer.this.nBB = MusicPlayerState.PREPARED;
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
                this.nBB = MusicPlayerState.ERROR;
                if (aVar != null) {
                    aVar.dPW();
                }
            }
        }
    }

    public void dPZ() {
        if (this.nBz != null && this.nBz.isPlaying()) {
            this.nBz.pause();
        }
        this.nBB = MusicPlayerState.PAUSE;
    }

    public void dQa() {
        if (this.nBz != null) {
            this.nBz.start();
            this.nBz.seekTo(0);
        }
        this.nBB = MusicPlayerState.RESUME;
    }

    public void bfG() {
        if (this.nBz != null) {
            if (this.nBz.isPlaying()) {
                this.nBz.stop();
            }
            this.nBz.release();
            this.nBz = null;
        }
    }
}
