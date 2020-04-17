package com.baidu.tieba.video.cloudmusic;

import android.media.MediaPlayer;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import java.io.IOException;
/* loaded from: classes10.dex */
public class MusicPlayer {
    private static MusicPlayer lhP = null;
    private MediaPlayer lhO;
    private MusicPlayerState lhQ = MusicPlayerState.WAIT;

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
        void daI();
    }

    private MusicPlayer() {
    }

    public static synchronized MusicPlayer daK() {
        MusicPlayer musicPlayer;
        synchronized (MusicPlayer.class) {
            if (lhP == null) {
                lhP = new MusicPlayer();
            }
            musicPlayer = lhP;
        }
        return musicPlayer;
    }

    public void a(String str, final CloudMusicData.MusicTagList.MusicList musicList, a aVar) {
        if (this.lhQ != MusicPlayerState.PAUSE) {
            if (this.lhO == null) {
                this.lhO = new MediaPlayer();
                this.lhO.setAudioStreamType(3);
            }
            try {
                this.lhO.reset();
                this.lhO.setDataSource(str);
                this.lhO.prepare();
                this.lhQ = MusicPlayerState.WAIT;
                this.lhO.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.cloudmusic.MusicPlayer.1
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        com.baidu.tieba.video.cloudmusic.data.a.daN().a(musicList);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_CLOUD_MUSIC_PLAY));
                        MusicPlayer.this.lhO.setLooping(true);
                        MusicPlayer.this.lhO.start();
                        MusicPlayer.this.lhQ = MusicPlayerState.PREPARED;
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
                this.lhQ = MusicPlayerState.ERROR;
                if (aVar != null) {
                    aVar.daI();
                }
            }
        }
    }

    public void daL() {
        if (this.lhO != null && this.lhO.isPlaying()) {
            this.lhO.pause();
        }
        this.lhQ = MusicPlayerState.PAUSE;
    }

    public void daM() {
        if (this.lhO != null) {
            this.lhO.start();
            this.lhO.seekTo(0);
        }
        this.lhQ = MusicPlayerState.RESUME;
    }

    public void beN() {
        if (this.lhO != null) {
            if (this.lhO.isPlaying()) {
                this.lhO.stop();
            }
            this.lhO.release();
            this.lhO = null;
        }
    }
}
