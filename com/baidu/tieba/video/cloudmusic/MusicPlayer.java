package com.baidu.tieba.video.cloudmusic;

import android.media.MediaPlayer;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import java.io.IOException;
/* loaded from: classes8.dex */
public class MusicPlayer {
    private static MusicPlayer kuG = null;
    private MediaPlayer kuF;
    private MusicPlayerState kuH = MusicPlayerState.WAIT;

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
        void cNS();
    }

    private MusicPlayer() {
    }

    public static synchronized MusicPlayer cNU() {
        MusicPlayer musicPlayer;
        synchronized (MusicPlayer.class) {
            if (kuG == null) {
                kuG = new MusicPlayer();
            }
            musicPlayer = kuG;
        }
        return musicPlayer;
    }

    public void a(String str, final CloudMusicData.MusicTagList.MusicList musicList, a aVar) {
        if (this.kuH != MusicPlayerState.PAUSE) {
            if (this.kuF == null) {
                this.kuF = new MediaPlayer();
                this.kuF.setAudioStreamType(3);
            }
            try {
                this.kuF.reset();
                this.kuF.setDataSource(str);
                this.kuF.prepare();
                this.kuH = MusicPlayerState.WAIT;
                this.kuF.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.cloudmusic.MusicPlayer.1
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        com.baidu.tieba.video.cloudmusic.data.a.cNX().a(musicList);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_CLOUD_MUSIC_PLAY));
                        MusicPlayer.this.kuF.setLooping(true);
                        MusicPlayer.this.kuF.start();
                        MusicPlayer.this.kuH = MusicPlayerState.PREPARED;
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
                this.kuH = MusicPlayerState.ERROR;
                if (aVar != null) {
                    aVar.cNS();
                }
            }
        }
    }

    public void cNV() {
        if (this.kuF != null && this.kuF.isPlaying()) {
            this.kuF.pause();
        }
        this.kuH = MusicPlayerState.PAUSE;
    }

    public void cNW() {
        if (this.kuF != null) {
            this.kuF.start();
            this.kuF.seekTo(0);
        }
        this.kuH = MusicPlayerState.RESUME;
    }

    public void aUk() {
        if (this.kuF != null) {
            if (this.kuF.isPlaying()) {
                this.kuF.stop();
            }
            this.kuF.release();
            this.kuF = null;
        }
    }
}
