package com.baidu.tieba.video.cloudmusic;

import android.media.MediaPlayer;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import java.io.IOException;
/* loaded from: classes5.dex */
public class MusicPlayer {

    /* renamed from: c  reason: collision with root package name */
    public static MusicPlayer f21279c;

    /* renamed from: a  reason: collision with root package name */
    public MediaPlayer f21280a;

    /* renamed from: b  reason: collision with root package name */
    public MusicPlayerState f21281b = MusicPlayerState.WAIT;

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
    public class a implements MediaPlayer.OnPreparedListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CloudMusicData.MusicTagList.MusicList f21282e;

        public a(CloudMusicData.MusicTagList.MusicList musicList) {
            this.f21282e = musicList;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            d.a.n0.r3.h.h.a.b().d(this.f21282e);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921307));
            MusicPlayer.this.f21280a.setLooping(true);
            MusicPlayer.this.f21280a.start();
            MusicPlayer.this.f21281b = MusicPlayerState.PREPARED;
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a();
    }

    public static synchronized MusicPlayer c() {
        MusicPlayer musicPlayer;
        synchronized (MusicPlayer.class) {
            if (f21279c == null) {
                f21279c = new MusicPlayer();
            }
            musicPlayer = f21279c;
        }
        return musicPlayer;
    }

    public void d() {
        MediaPlayer mediaPlayer = this.f21280a;
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            this.f21280a.pause();
        }
        this.f21281b = MusicPlayerState.PAUSE;
    }

    public void e(String str, CloudMusicData.MusicTagList.MusicList musicList, b bVar) {
        if (this.f21281b == MusicPlayerState.PAUSE) {
            return;
        }
        if (this.f21280a == null) {
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.f21280a = mediaPlayer;
            mediaPlayer.setAudioStreamType(3);
        }
        try {
            this.f21280a.reset();
            this.f21280a.setDataSource(str);
            this.f21280a.prepare();
            this.f21281b = MusicPlayerState.WAIT;
            this.f21280a.setOnPreparedListener(new a(musicList));
        } catch (IOException e2) {
            e2.printStackTrace();
            this.f21281b = MusicPlayerState.ERROR;
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    public void f() {
        MediaPlayer mediaPlayer = this.f21280a;
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                this.f21280a.stop();
            }
            this.f21280a.release();
            this.f21280a = null;
        }
    }

    public void g() {
        MediaPlayer mediaPlayer = this.f21280a;
        if (mediaPlayer != null) {
            mediaPlayer.start();
            this.f21280a.seekTo(0);
        }
        this.f21281b = MusicPlayerState.RESUME;
    }
}
