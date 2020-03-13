package com.baidu.tieba.video.cloudmusic;

import android.media.MediaPlayer;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import java.io.IOException;
/* loaded from: classes10.dex */
public class MusicPlayer {
    private static MusicPlayer kvW = null;
    private MediaPlayer kvV;
    private MusicPlayerState kvX = MusicPlayerState.WAIT;

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
        void cPs();
    }

    private MusicPlayer() {
    }

    public static synchronized MusicPlayer cPu() {
        MusicPlayer musicPlayer;
        synchronized (MusicPlayer.class) {
            if (kvW == null) {
                kvW = new MusicPlayer();
            }
            musicPlayer = kvW;
        }
        return musicPlayer;
    }

    public void a(String str, final CloudMusicData.MusicTagList.MusicList musicList, a aVar) {
        if (this.kvX != MusicPlayerState.PAUSE) {
            if (this.kvV == null) {
                this.kvV = new MediaPlayer();
                this.kvV.setAudioStreamType(3);
            }
            try {
                this.kvV.reset();
                this.kvV.setDataSource(str);
                this.kvV.prepare();
                this.kvX = MusicPlayerState.WAIT;
                this.kvV.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.cloudmusic.MusicPlayer.1
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        com.baidu.tieba.video.cloudmusic.data.a.cPx().a(musicList);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_CLOUD_MUSIC_PLAY));
                        MusicPlayer.this.kvV.setLooping(true);
                        MusicPlayer.this.kvV.start();
                        MusicPlayer.this.kvX = MusicPlayerState.PREPARED;
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
                this.kvX = MusicPlayerState.ERROR;
                if (aVar != null) {
                    aVar.cPs();
                }
            }
        }
    }

    public void cPv() {
        if (this.kvV != null && this.kvV.isPlaying()) {
            this.kvV.pause();
        }
        this.kvX = MusicPlayerState.PAUSE;
    }

    public void cPw() {
        if (this.kvV != null) {
            this.kvV.start();
            this.kvV.seekTo(0);
        }
        this.kvX = MusicPlayerState.RESUME;
    }

    public void aWD() {
        if (this.kvV != null) {
            if (this.kvV.isPlaying()) {
                this.kvV.stop();
            }
            this.kvV.release();
            this.kvV = null;
        }
    }
}
