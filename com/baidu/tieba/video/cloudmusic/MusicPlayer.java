package com.baidu.tieba.video.cloudmusic;

import android.media.MediaPlayer;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import java.io.IOException;
/* loaded from: classes2.dex */
public class MusicPlayer {
    private static MusicPlayer guh = null;
    private MediaPlayer gug;
    private MusicPlayerState gui = MusicPlayerState.WAIT;

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
        void bvo();
    }

    private MusicPlayer() {
    }

    public static synchronized MusicPlayer bvq() {
        MusicPlayer musicPlayer;
        synchronized (MusicPlayer.class) {
            if (guh == null) {
                guh = new MusicPlayer();
            }
            musicPlayer = guh;
        }
        return musicPlayer;
    }

    public void a(String str, final CloudMusicData.MusicTagList.MusicList musicList, a aVar) {
        if (this.gui != MusicPlayerState.PAUSE) {
            if (this.gug == null) {
                this.gug = new MediaPlayer();
                this.gug.setAudioStreamType(3);
            }
            try {
                this.gug.reset();
                this.gug.setDataSource(str);
                this.gug.prepare();
                this.gui = MusicPlayerState.WAIT;
                this.gug.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.cloudmusic.MusicPlayer.1
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        com.baidu.tieba.video.cloudmusic.data.a.bvt().a(musicList);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_CLOUD_MUSIC_PLAY));
                        MusicPlayer.this.gug.setLooping(true);
                        MusicPlayer.this.gug.start();
                        MusicPlayer.this.gui = MusicPlayerState.PREPARED;
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
                this.gui = MusicPlayerState.ERROR;
                if (aVar != null) {
                    aVar.bvo();
                }
            }
        }
    }

    public void bvr() {
        if (this.gug != null && this.gug.isPlaying()) {
            this.gug.pause();
        }
        this.gui = MusicPlayerState.PAUSE;
    }

    public void bvs() {
        if (this.gug != null) {
            this.gug.start();
            this.gug.seekTo(0);
        }
        this.gui = MusicPlayerState.RESUME;
    }

    public void beh() {
        if (this.gug != null) {
            if (this.gug.isPlaying()) {
                this.gug.stop();
            }
            this.gug.release();
            this.gug = null;
        }
    }
}
