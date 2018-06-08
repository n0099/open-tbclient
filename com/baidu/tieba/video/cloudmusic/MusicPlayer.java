package com.baidu.tieba.video.cloudmusic;

import android.media.MediaPlayer;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import java.io.IOException;
/* loaded from: classes2.dex */
public class MusicPlayer {
    private static MusicPlayer gXo = null;
    private MediaPlayer gXn;
    private MusicPlayerState gXp = MusicPlayerState.WAIT;

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
        void bBh();
    }

    private MusicPlayer() {
    }

    public static synchronized MusicPlayer bBj() {
        MusicPlayer musicPlayer;
        synchronized (MusicPlayer.class) {
            if (gXo == null) {
                gXo = new MusicPlayer();
            }
            musicPlayer = gXo;
        }
        return musicPlayer;
    }

    public void a(String str, final CloudMusicData.MusicTagList.MusicList musicList, a aVar) {
        if (this.gXp != MusicPlayerState.PAUSE) {
            if (this.gXn == null) {
                this.gXn = new MediaPlayer();
                this.gXn.setAudioStreamType(3);
            }
            try {
                this.gXn.reset();
                this.gXn.setDataSource(str);
                this.gXn.prepare();
                this.gXp = MusicPlayerState.WAIT;
                this.gXn.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.cloudmusic.MusicPlayer.1
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        com.baidu.tieba.video.cloudmusic.data.a.bBm().a(musicList);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921307));
                        MusicPlayer.this.gXn.setLooping(true);
                        MusicPlayer.this.gXn.start();
                        MusicPlayer.this.gXp = MusicPlayerState.PREPARED;
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
                this.gXp = MusicPlayerState.ERROR;
                if (aVar != null) {
                    aVar.bBh();
                }
            }
        }
    }

    public void bBk() {
        if (this.gXn != null && this.gXn.isPlaying()) {
            this.gXn.pause();
        }
        this.gXp = MusicPlayerState.PAUSE;
    }

    public void bBl() {
        if (this.gXn != null) {
            this.gXn.start();
            this.gXn.seekTo(0);
        }
        this.gXp = MusicPlayerState.RESUME;
    }

    public void blv() {
        if (this.gXn != null) {
            if (this.gXn.isPlaying()) {
                this.gXn.stop();
            }
            this.gXn.release();
            this.gXn = null;
        }
    }
}
