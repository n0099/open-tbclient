package com.baidu.tieba.video.cloudmusic;

import android.media.MediaPlayer;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import java.io.IOException;
/* loaded from: classes8.dex */
public class MusicPlayer {
    private static MusicPlayer kuL = null;
    private MediaPlayer kuK;
    private MusicPlayerState kuM = MusicPlayerState.WAIT;

    /* loaded from: classes8.dex */
    public enum MusicPlayerState {
        WAIT,
        PAUSE,
        PREPARED,
        REPLAY,
        RESUME,
        ERROR
    }

    /* loaded from: classes8.dex */
    public interface a {
        void cNU();
    }

    private MusicPlayer() {
    }

    public static synchronized MusicPlayer cNW() {
        MusicPlayer musicPlayer;
        synchronized (MusicPlayer.class) {
            if (kuL == null) {
                kuL = new MusicPlayer();
            }
            musicPlayer = kuL;
        }
        return musicPlayer;
    }

    public void a(String str, final CloudMusicData.MusicTagList.MusicList musicList, a aVar) {
        if (this.kuM != MusicPlayerState.PAUSE) {
            if (this.kuK == null) {
                this.kuK = new MediaPlayer();
                this.kuK.setAudioStreamType(3);
            }
            try {
                this.kuK.reset();
                this.kuK.setDataSource(str);
                this.kuK.prepare();
                this.kuM = MusicPlayerState.WAIT;
                this.kuK.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.cloudmusic.MusicPlayer.1
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        com.baidu.tieba.video.cloudmusic.data.a.cNZ().a(musicList);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_CLOUD_MUSIC_PLAY));
                        MusicPlayer.this.kuK.setLooping(true);
                        MusicPlayer.this.kuK.start();
                        MusicPlayer.this.kuM = MusicPlayerState.PREPARED;
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
                this.kuM = MusicPlayerState.ERROR;
                if (aVar != null) {
                    aVar.cNU();
                }
            }
        }
    }

    public void cNX() {
        if (this.kuK != null && this.kuK.isPlaying()) {
            this.kuK.pause();
        }
        this.kuM = MusicPlayerState.PAUSE;
    }

    public void cNY() {
        if (this.kuK != null) {
            this.kuK.start();
            this.kuK.seekTo(0);
        }
        this.kuM = MusicPlayerState.RESUME;
    }

    public void aUk() {
        if (this.kuK != null) {
            if (this.kuK.isPlaying()) {
                this.kuK.stop();
            }
            this.kuK.release();
            this.kuK = null;
        }
    }
}
