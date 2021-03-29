package com.baidu.tieba.video.cloudmusic;

import android.media.MediaPlayer;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import java.io.IOException;
/* loaded from: classes5.dex */
public class MusicPlayer {

    /* renamed from: c  reason: collision with root package name */
    public static MusicPlayer f21716c;

    /* renamed from: a  reason: collision with root package name */
    public MediaPlayer f21717a;

    /* renamed from: b  reason: collision with root package name */
    public MusicPlayerState f21718b = MusicPlayerState.WAIT;

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
        public final /* synthetic */ CloudMusicData.MusicTagList.MusicList f21719e;

        public a(CloudMusicData.MusicTagList.MusicList musicList) {
            this.f21719e = musicList;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            d.b.i0.p3.i.h.a.b().d(this.f21719e);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921307));
            MusicPlayer.this.f21717a.setLooping(true);
            MusicPlayer.this.f21717a.start();
            MusicPlayer.this.f21718b = MusicPlayerState.PREPARED;
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a();
    }

    public static synchronized MusicPlayer c() {
        MusicPlayer musicPlayer;
        synchronized (MusicPlayer.class) {
            if (f21716c == null) {
                f21716c = new MusicPlayer();
            }
            musicPlayer = f21716c;
        }
        return musicPlayer;
    }

    public void d() {
        MediaPlayer mediaPlayer = this.f21717a;
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            this.f21717a.pause();
        }
        this.f21718b = MusicPlayerState.PAUSE;
    }

    public void e(String str, CloudMusicData.MusicTagList.MusicList musicList, b bVar) {
        if (this.f21718b == MusicPlayerState.PAUSE) {
            return;
        }
        if (this.f21717a == null) {
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.f21717a = mediaPlayer;
            mediaPlayer.setAudioStreamType(3);
        }
        try {
            this.f21717a.reset();
            this.f21717a.setDataSource(str);
            this.f21717a.prepare();
            this.f21718b = MusicPlayerState.WAIT;
            this.f21717a.setOnPreparedListener(new a(musicList));
        } catch (IOException e2) {
            e2.printStackTrace();
            this.f21718b = MusicPlayerState.ERROR;
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    public void f() {
        MediaPlayer mediaPlayer = this.f21717a;
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                this.f21717a.stop();
            }
            this.f21717a.release();
            this.f21717a = null;
        }
    }

    public void g() {
        MediaPlayer mediaPlayer = this.f21717a;
        if (mediaPlayer != null) {
            mediaPlayer.start();
            this.f21717a.seekTo(0);
        }
        this.f21718b = MusicPlayerState.RESUME;
    }
}
