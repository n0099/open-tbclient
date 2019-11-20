package com.baidu.tieba.video.cloudmusic;

import android.media.MediaPlayer;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import java.io.IOException;
/* loaded from: classes5.dex */
public class MusicPlayer {
    private static MusicPlayer jxg = null;
    private MediaPlayer jxf;
    private MusicPlayerState jxh = MusicPlayerState.WAIT;

    /* loaded from: classes5.dex */
    public enum MusicPlayerState {
        WAIT,
        PAUSE,
        PREPARED,
        REPLAY,
        RESUME,
        ERROR
    }

    /* loaded from: classes5.dex */
    public interface a {
        void csL();
    }

    private MusicPlayer() {
    }

    public static synchronized MusicPlayer csN() {
        MusicPlayer musicPlayer;
        synchronized (MusicPlayer.class) {
            if (jxg == null) {
                jxg = new MusicPlayer();
            }
            musicPlayer = jxg;
        }
        return musicPlayer;
    }

    public void a(String str, final CloudMusicData.MusicTagList.MusicList musicList, a aVar) {
        if (this.jxh != MusicPlayerState.PAUSE) {
            if (this.jxf == null) {
                this.jxf = new MediaPlayer();
                this.jxf.setAudioStreamType(3);
            }
            try {
                this.jxf.reset();
                this.jxf.setDataSource(str);
                this.jxf.prepare();
                this.jxh = MusicPlayerState.WAIT;
                this.jxf.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.cloudmusic.MusicPlayer.1
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        com.baidu.tieba.video.cloudmusic.data.a.csQ().a(musicList);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_CLOUD_MUSIC_PLAY));
                        MusicPlayer.this.jxf.setLooping(true);
                        MusicPlayer.this.jxf.start();
                        MusicPlayer.this.jxh = MusicPlayerState.PREPARED;
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
                this.jxh = MusicPlayerState.ERROR;
                if (aVar != null) {
                    aVar.csL();
                }
            }
        }
    }

    public void csO() {
        if (this.jxf != null && this.jxf.isPlaying()) {
            this.jxf.pause();
        }
        this.jxh = MusicPlayerState.PAUSE;
    }

    public void csP() {
        if (this.jxf != null) {
            this.jxf.start();
            this.jxf.seekTo(0);
        }
        this.jxh = MusicPlayerState.RESUME;
    }

    public void aBY() {
        if (this.jxf != null) {
            if (this.jxf.isPlaying()) {
                this.jxf.stop();
            }
            this.jxf.release();
            this.jxf = null;
        }
    }
}
