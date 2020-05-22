package com.baidu.tieba.video.cloudmusic;

import android.media.MediaPlayer;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import java.io.IOException;
/* loaded from: classes10.dex */
public class MusicPlayer {
    private static MusicPlayer lAE = null;
    private MediaPlayer lAD;
    private MusicPlayerState lAF = MusicPlayerState.WAIT;

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
        void dhU();
    }

    private MusicPlayer() {
    }

    public static synchronized MusicPlayer dhW() {
        MusicPlayer musicPlayer;
        synchronized (MusicPlayer.class) {
            if (lAE == null) {
                lAE = new MusicPlayer();
            }
            musicPlayer = lAE;
        }
        return musicPlayer;
    }

    public void a(String str, final CloudMusicData.MusicTagList.MusicList musicList, a aVar) {
        if (this.lAF != MusicPlayerState.PAUSE) {
            if (this.lAD == null) {
                this.lAD = new MediaPlayer();
                this.lAD.setAudioStreamType(3);
            }
            try {
                this.lAD.reset();
                this.lAD.setDataSource(str);
                this.lAD.prepare();
                this.lAF = MusicPlayerState.WAIT;
                this.lAD.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.cloudmusic.MusicPlayer.1
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        com.baidu.tieba.video.cloudmusic.data.a.dhZ().a(musicList);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_CLOUD_MUSIC_PLAY));
                        MusicPlayer.this.lAD.setLooping(true);
                        MusicPlayer.this.lAD.start();
                        MusicPlayer.this.lAF = MusicPlayerState.PREPARED;
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
                this.lAF = MusicPlayerState.ERROR;
                if (aVar != null) {
                    aVar.dhU();
                }
            }
        }
    }

    public void dhX() {
        if (this.lAD != null && this.lAD.isPlaying()) {
            this.lAD.pause();
        }
        this.lAF = MusicPlayerState.PAUSE;
    }

    public void dhY() {
        if (this.lAD != null) {
            this.lAD.start();
            this.lAD.seekTo(0);
        }
        this.lAF = MusicPlayerState.RESUME;
    }

    public void aJz() {
        if (this.lAD != null) {
            if (this.lAD.isPlaying()) {
                this.lAD.stop();
            }
            this.lAD.release();
            this.lAD = null;
        }
    }
}
