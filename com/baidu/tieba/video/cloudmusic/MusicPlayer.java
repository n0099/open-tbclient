package com.baidu.tieba.video.cloudmusic;

import android.media.MediaPlayer;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import java.io.IOException;
/* loaded from: classes7.dex */
public class MusicPlayer {
    private static MusicPlayer nBz = null;
    private MusicPlayerState nBA = MusicPlayerState.WAIT;
    private MediaPlayer nBy;

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
            if (nBz == null) {
                nBz = new MusicPlayer();
            }
            musicPlayer = nBz;
        }
        return musicPlayer;
    }

    public void a(String str, final CloudMusicData.MusicTagList.MusicList musicList, a aVar) {
        if (this.nBA != MusicPlayerState.PAUSE) {
            if (this.nBy == null) {
                this.nBy = new MediaPlayer();
                this.nBy.setAudioStreamType(3);
            }
            try {
                this.nBy.reset();
                this.nBy.setDataSource(str);
                this.nBy.prepare();
                this.nBA = MusicPlayerState.WAIT;
                this.nBy.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.cloudmusic.MusicPlayer.1
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        com.baidu.tieba.video.cloudmusic.data.a.dQb().a(musicList);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_CLOUD_MUSIC_PLAY));
                        MusicPlayer.this.nBy.setLooping(true);
                        MusicPlayer.this.nBy.start();
                        MusicPlayer.this.nBA = MusicPlayerState.PREPARED;
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
                this.nBA = MusicPlayerState.ERROR;
                if (aVar != null) {
                    aVar.dPW();
                }
            }
        }
    }

    public void dPZ() {
        if (this.nBy != null && this.nBy.isPlaying()) {
            this.nBy.pause();
        }
        this.nBA = MusicPlayerState.PAUSE;
    }

    public void dQa() {
        if (this.nBy != null) {
            this.nBy.start();
            this.nBy.seekTo(0);
        }
        this.nBA = MusicPlayerState.RESUME;
    }

    public void bfG() {
        if (this.nBy != null) {
            if (this.nBy.isPlaying()) {
                this.nBy.stop();
            }
            this.nBy.release();
            this.nBy = null;
        }
    }
}
