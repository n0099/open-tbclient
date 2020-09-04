package com.baidu.tieba.video.cloudmusic;

import android.media.MediaPlayer;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import java.io.IOException;
/* loaded from: classes17.dex */
public class MusicPlayer {
    private static MusicPlayer muR = null;
    private MediaPlayer muQ;
    private MusicPlayerState muS = MusicPlayerState.WAIT;

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
        void dBo();
    }

    private MusicPlayer() {
    }

    public static synchronized MusicPlayer dBq() {
        MusicPlayer musicPlayer;
        synchronized (MusicPlayer.class) {
            if (muR == null) {
                muR = new MusicPlayer();
            }
            musicPlayer = muR;
        }
        return musicPlayer;
    }

    public void a(String str, final CloudMusicData.MusicTagList.MusicList musicList, a aVar) {
        if (this.muS != MusicPlayerState.PAUSE) {
            if (this.muQ == null) {
                this.muQ = new MediaPlayer();
                this.muQ.setAudioStreamType(3);
            }
            try {
                this.muQ.reset();
                this.muQ.setDataSource(str);
                this.muQ.prepare();
                this.muS = MusicPlayerState.WAIT;
                this.muQ.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.cloudmusic.MusicPlayer.1
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        com.baidu.tieba.video.cloudmusic.data.a.dBt().a(musicList);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_CLOUD_MUSIC_PLAY));
                        MusicPlayer.this.muQ.setLooping(true);
                        MusicPlayer.this.muQ.start();
                        MusicPlayer.this.muS = MusicPlayerState.PREPARED;
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
                this.muS = MusicPlayerState.ERROR;
                if (aVar != null) {
                    aVar.dBo();
                }
            }
        }
    }

    public void dBr() {
        if (this.muQ != null && this.muQ.isPlaying()) {
            this.muQ.pause();
        }
        this.muS = MusicPlayerState.PAUSE;
    }

    public void dBs() {
        if (this.muQ != null) {
            this.muQ.start();
            this.muQ.seekTo(0);
        }
        this.muS = MusicPlayerState.RESUME;
    }

    public void aWR() {
        if (this.muQ != null) {
            if (this.muQ.isPlaying()) {
                this.muQ.stop();
            }
            this.muQ.release();
            this.muQ = null;
        }
    }
}
