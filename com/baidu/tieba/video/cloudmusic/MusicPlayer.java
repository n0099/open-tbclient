package com.baidu.tieba.video.cloudmusic;

import android.media.MediaPlayer;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import java.io.IOException;
/* loaded from: classes2.dex */
public class MusicPlayer {
    private static MusicPlayer hkz = null;
    private MusicPlayerState hkA = MusicPlayerState.WAIT;
    private MediaPlayer hky;

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
        void bDj();
    }

    private MusicPlayer() {
    }

    public static synchronized MusicPlayer bDl() {
        MusicPlayer musicPlayer;
        synchronized (MusicPlayer.class) {
            if (hkz == null) {
                hkz = new MusicPlayer();
            }
            musicPlayer = hkz;
        }
        return musicPlayer;
    }

    public void a(String str, final CloudMusicData.MusicTagList.MusicList musicList, a aVar) {
        if (this.hkA != MusicPlayerState.PAUSE) {
            if (this.hky == null) {
                this.hky = new MediaPlayer();
                this.hky.setAudioStreamType(3);
            }
            try {
                this.hky.reset();
                this.hky.setDataSource(str);
                this.hky.prepare();
                this.hkA = MusicPlayerState.WAIT;
                this.hky.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.cloudmusic.MusicPlayer.1
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        com.baidu.tieba.video.cloudmusic.data.a.bDo().a(musicList);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921307));
                        MusicPlayer.this.hky.setLooping(true);
                        MusicPlayer.this.hky.start();
                        MusicPlayer.this.hkA = MusicPlayerState.PREPARED;
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
                this.hkA = MusicPlayerState.ERROR;
                if (aVar != null) {
                    aVar.bDj();
                }
            }
        }
    }

    public void bDm() {
        if (this.hky != null && this.hky.isPlaying()) {
            this.hky.pause();
        }
        this.hkA = MusicPlayerState.PAUSE;
    }

    public void bDn() {
        if (this.hky != null) {
            this.hky.start();
            this.hky.seekTo(0);
        }
        this.hkA = MusicPlayerState.RESUME;
    }

    public void Ry() {
        if (this.hky != null) {
            if (this.hky.isPlaying()) {
                this.hky.stop();
            }
            this.hky.release();
            this.hky = null;
        }
    }
}
