package com.baidu.tieba.video.cloudmusic;

import android.media.MediaPlayer;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import java.io.IOException;
/* loaded from: classes2.dex */
public class MusicPlayer {
    private static MusicPlayer guv = null;
    private MediaPlayer guu;
    private MusicPlayerState guw = MusicPlayerState.WAIT;

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
        void bvw();
    }

    private MusicPlayer() {
    }

    public static synchronized MusicPlayer bvy() {
        MusicPlayer musicPlayer;
        synchronized (MusicPlayer.class) {
            if (guv == null) {
                guv = new MusicPlayer();
            }
            musicPlayer = guv;
        }
        return musicPlayer;
    }

    public void a(String str, final CloudMusicData.MusicTagList.MusicList musicList, a aVar) {
        if (this.guw != MusicPlayerState.PAUSE) {
            if (this.guu == null) {
                this.guu = new MediaPlayer();
                this.guu.setAudioStreamType(3);
            }
            try {
                this.guu.reset();
                this.guu.setDataSource(str);
                this.guu.prepare();
                this.guw = MusicPlayerState.WAIT;
                this.guu.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.cloudmusic.MusicPlayer.1
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        com.baidu.tieba.video.cloudmusic.data.a.bvB().a(musicList);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_CLOUD_MUSIC_PLAY));
                        MusicPlayer.this.guu.setLooping(true);
                        MusicPlayer.this.guu.start();
                        MusicPlayer.this.guw = MusicPlayerState.PREPARED;
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
                this.guw = MusicPlayerState.ERROR;
                if (aVar != null) {
                    aVar.bvw();
                }
            }
        }
    }

    public void bvz() {
        if (this.guu != null && this.guu.isPlaying()) {
            this.guu.pause();
        }
        this.guw = MusicPlayerState.PAUSE;
    }

    public void bvA() {
        if (this.guu != null) {
            this.guu.start();
            this.guu.seekTo(0);
        }
        this.guw = MusicPlayerState.RESUME;
    }

    public void bem() {
        if (this.guu != null) {
            if (this.guu.isPlaying()) {
                this.guu.stop();
            }
            this.guu.release();
            this.guu = null;
        }
    }
}
