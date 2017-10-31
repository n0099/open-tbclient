package com.baidu.tieba.video.cloudmusic;

import android.media.MediaPlayer;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import java.io.IOException;
/* loaded from: classes2.dex */
public class MusicPlayer {
    private static MusicPlayer gCZ = null;
    private MediaPlayer gCY;
    private MusicPlayerState gDa = MusicPlayerState.WAIT;

    /* loaded from: classes2.dex */
    public enum MusicPlayerState {
        WAIT,
        PAUSE,
        PREPARED,
        REPLAY,
        RESUME,
        ERROR
    }

    /* loaded from: classes2.dex */
    public interface a {
        void byr();
    }

    private MusicPlayer() {
    }

    public static synchronized MusicPlayer byt() {
        MusicPlayer musicPlayer;
        synchronized (MusicPlayer.class) {
            if (gCZ == null) {
                gCZ = new MusicPlayer();
            }
            musicPlayer = gCZ;
        }
        return musicPlayer;
    }

    public void a(String str, final CloudMusicData.MusicTagList.MusicList musicList, a aVar) {
        if (this.gDa != MusicPlayerState.PAUSE) {
            if (this.gCY == null) {
                this.gCY = new MediaPlayer();
                this.gCY.setAudioStreamType(3);
            }
            try {
                this.gCY.reset();
                this.gCY.setDataSource(str);
                this.gCY.prepare();
                this.gDa = MusicPlayerState.WAIT;
                this.gCY.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.cloudmusic.MusicPlayer.1
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        com.baidu.tieba.video.cloudmusic.data.a.byw().a(musicList);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_CLOUD_MUSIC_PLAY));
                        MusicPlayer.this.gCY.setLooping(true);
                        MusicPlayer.this.gCY.start();
                        MusicPlayer.this.gDa = MusicPlayerState.PREPARED;
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
                this.gDa = MusicPlayerState.ERROR;
                if (aVar != null) {
                    aVar.byr();
                }
            }
        }
    }

    public void byu() {
        if (this.gCY != null && this.gCY.isPlaying()) {
            this.gCY.pause();
        }
        this.gDa = MusicPlayerState.PAUSE;
    }

    public void byv() {
        if (this.gCY != null) {
            this.gCY.start();
            this.gCY.seekTo(0);
        }
        this.gDa = MusicPlayerState.RESUME;
    }

    public void bhq() {
        if (this.gCY != null) {
            if (this.gCY.isPlaying()) {
                this.gCY.stop();
            }
            this.gCY.release();
            this.gCY = null;
        }
    }
}
