package com.baidu.tieba.video.cloudmusic;

import android.media.MediaPlayer;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import java.io.IOException;
/* loaded from: classes10.dex */
public class MusicPlayer {
    private static MusicPlayer lhT = null;
    private MediaPlayer lhS;
    private MusicPlayerState lhU = MusicPlayerState.WAIT;

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
        void daG();
    }

    private MusicPlayer() {
    }

    public static synchronized MusicPlayer daI() {
        MusicPlayer musicPlayer;
        synchronized (MusicPlayer.class) {
            if (lhT == null) {
                lhT = new MusicPlayer();
            }
            musicPlayer = lhT;
        }
        return musicPlayer;
    }

    public void a(String str, final CloudMusicData.MusicTagList.MusicList musicList, a aVar) {
        if (this.lhU != MusicPlayerState.PAUSE) {
            if (this.lhS == null) {
                this.lhS = new MediaPlayer();
                this.lhS.setAudioStreamType(3);
            }
            try {
                this.lhS.reset();
                this.lhS.setDataSource(str);
                this.lhS.prepare();
                this.lhU = MusicPlayerState.WAIT;
                this.lhS.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.cloudmusic.MusicPlayer.1
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        com.baidu.tieba.video.cloudmusic.data.a.daL().a(musicList);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_CLOUD_MUSIC_PLAY));
                        MusicPlayer.this.lhS.setLooping(true);
                        MusicPlayer.this.lhS.start();
                        MusicPlayer.this.lhU = MusicPlayerState.PREPARED;
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
                this.lhU = MusicPlayerState.ERROR;
                if (aVar != null) {
                    aVar.daG();
                }
            }
        }
    }

    public void daJ() {
        if (this.lhS != null && this.lhS.isPlaying()) {
            this.lhS.pause();
        }
        this.lhU = MusicPlayerState.PAUSE;
    }

    public void daK() {
        if (this.lhS != null) {
            this.lhS.start();
            this.lhS.seekTo(0);
        }
        this.lhU = MusicPlayerState.RESUME;
    }

    public void beL() {
        if (this.lhS != null) {
            if (this.lhS.isPlaying()) {
                this.lhS.stop();
            }
            this.lhS.release();
            this.lhS = null;
        }
    }
}
