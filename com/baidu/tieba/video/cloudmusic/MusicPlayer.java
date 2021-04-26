package com.baidu.tieba.video.cloudmusic;

import android.media.MediaPlayer;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import java.io.IOException;
/* loaded from: classes5.dex */
public class MusicPlayer {

    /* renamed from: c  reason: collision with root package name */
    public static MusicPlayer f22028c;

    /* renamed from: a  reason: collision with root package name */
    public MediaPlayer f22029a;

    /* renamed from: b  reason: collision with root package name */
    public MusicPlayerState f22030b = MusicPlayerState.WAIT;

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
        public final /* synthetic */ CloudMusicData.MusicTagList.MusicList f22031e;

        public a(CloudMusicData.MusicTagList.MusicList musicList) {
            this.f22031e = musicList;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            d.a.j0.q3.i.h.a.b().d(this.f22031e);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921307));
            MusicPlayer.this.f22029a.setLooping(true);
            MusicPlayer.this.f22029a.start();
            MusicPlayer.this.f22030b = MusicPlayerState.PREPARED;
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a();
    }

    public static synchronized MusicPlayer c() {
        MusicPlayer musicPlayer;
        synchronized (MusicPlayer.class) {
            if (f22028c == null) {
                f22028c = new MusicPlayer();
            }
            musicPlayer = f22028c;
        }
        return musicPlayer;
    }

    public void d() {
        MediaPlayer mediaPlayer = this.f22029a;
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            this.f22029a.pause();
        }
        this.f22030b = MusicPlayerState.PAUSE;
    }

    public void e(String str, CloudMusicData.MusicTagList.MusicList musicList, b bVar) {
        if (this.f22030b == MusicPlayerState.PAUSE) {
            return;
        }
        if (this.f22029a == null) {
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.f22029a = mediaPlayer;
            mediaPlayer.setAudioStreamType(3);
        }
        try {
            this.f22029a.reset();
            this.f22029a.setDataSource(str);
            this.f22029a.prepare();
            this.f22030b = MusicPlayerState.WAIT;
            this.f22029a.setOnPreparedListener(new a(musicList));
        } catch (IOException e2) {
            e2.printStackTrace();
            this.f22030b = MusicPlayerState.ERROR;
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    public void f() {
        MediaPlayer mediaPlayer = this.f22029a;
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                this.f22029a.stop();
            }
            this.f22029a.release();
            this.f22029a = null;
        }
    }

    public void g() {
        MediaPlayer mediaPlayer = this.f22029a;
        if (mediaPlayer != null) {
            mediaPlayer.start();
            this.f22029a.seekTo(0);
        }
        this.f22030b = MusicPlayerState.RESUME;
    }
}
