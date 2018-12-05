package com.baidu.tieba.video.cloudmusic;

import android.media.MediaPlayer;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import java.io.IOException;
/* loaded from: classes5.dex */
public class MusicPlayer {
    private static MusicPlayer hAL = null;
    private MediaPlayer hAK;
    private MusicPlayerState hAM = MusicPlayerState.WAIT;

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
        void bIb();
    }

    private MusicPlayer() {
    }

    public static synchronized MusicPlayer bId() {
        MusicPlayer musicPlayer;
        synchronized (MusicPlayer.class) {
            if (hAL == null) {
                hAL = new MusicPlayer();
            }
            musicPlayer = hAL;
        }
        return musicPlayer;
    }

    public void a(String str, final CloudMusicData.MusicTagList.MusicList musicList, a aVar) {
        if (this.hAM != MusicPlayerState.PAUSE) {
            if (this.hAK == null) {
                this.hAK = new MediaPlayer();
                this.hAK.setAudioStreamType(3);
            }
            try {
                this.hAK.reset();
                this.hAK.setDataSource(str);
                this.hAK.prepare();
                this.hAM = MusicPlayerState.WAIT;
                this.hAK.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.cloudmusic.MusicPlayer.1
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        com.baidu.tieba.video.cloudmusic.data.a.bIg().a(musicList);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921307));
                        MusicPlayer.this.hAK.setLooping(true);
                        MusicPlayer.this.hAK.start();
                        MusicPlayer.this.hAM = MusicPlayerState.PREPARED;
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
                this.hAM = MusicPlayerState.ERROR;
                if (aVar != null) {
                    aVar.bIb();
                }
            }
        }
    }

    public void bIe() {
        if (this.hAK != null && this.hAK.isPlaying()) {
            this.hAK.pause();
        }
        this.hAM = MusicPlayerState.PAUSE;
    }

    public void bIf() {
        if (this.hAK != null) {
            this.hAK.start();
            this.hAK.seekTo(0);
        }
        this.hAM = MusicPlayerState.RESUME;
    }

    public void UJ() {
        if (this.hAK != null) {
            if (this.hAK.isPlaying()) {
                this.hAK.stop();
            }
            this.hAK.release();
            this.hAK = null;
        }
    }
}
