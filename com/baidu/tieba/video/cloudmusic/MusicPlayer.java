package com.baidu.tieba.video.cloudmusic;

import android.media.MediaPlayer;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import java.io.IOException;
/* loaded from: classes23.dex */
public class MusicPlayer {
    private static MusicPlayer nmM = null;
    private MediaPlayer nmL;
    private MusicPlayerState nmN = MusicPlayerState.WAIT;

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
        void dOE();
    }

    private MusicPlayer() {
    }

    public static synchronized MusicPlayer dOG() {
        MusicPlayer musicPlayer;
        synchronized (MusicPlayer.class) {
            if (nmM == null) {
                nmM = new MusicPlayer();
            }
            musicPlayer = nmM;
        }
        return musicPlayer;
    }

    public void a(String str, final CloudMusicData.MusicTagList.MusicList musicList, a aVar) {
        if (this.nmN != MusicPlayerState.PAUSE) {
            if (this.nmL == null) {
                this.nmL = new MediaPlayer();
                this.nmL.setAudioStreamType(3);
            }
            try {
                this.nmL.reset();
                this.nmL.setDataSource(str);
                this.nmL.prepare();
                this.nmN = MusicPlayerState.WAIT;
                this.nmL.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.cloudmusic.MusicPlayer.1
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        com.baidu.tieba.video.cloudmusic.data.a.dOJ().a(musicList);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_CLOUD_MUSIC_PLAY));
                        MusicPlayer.this.nmL.setLooping(true);
                        MusicPlayer.this.nmL.start();
                        MusicPlayer.this.nmN = MusicPlayerState.PREPARED;
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
                this.nmN = MusicPlayerState.ERROR;
                if (aVar != null) {
                    aVar.dOE();
                }
            }
        }
    }

    public void dOH() {
        if (this.nmL != null && this.nmL.isPlaying()) {
            this.nmL.pause();
        }
        this.nmN = MusicPlayerState.PAUSE;
    }

    public void dOI() {
        if (this.nmL != null) {
            this.nmL.start();
            this.nmL.seekTo(0);
        }
        this.nmN = MusicPlayerState.RESUME;
    }

    public void beE() {
        if (this.nmL != null) {
            if (this.nmL.isPlaying()) {
                this.nmL.stop();
            }
            this.nmL.release();
            this.nmL = null;
        }
    }
}
