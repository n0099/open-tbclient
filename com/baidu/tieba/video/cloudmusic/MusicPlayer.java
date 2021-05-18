package com.baidu.tieba.video.cloudmusic;

import android.media.MediaPlayer;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import java.io.IOException;
/* loaded from: classes5.dex */
public class MusicPlayer {

    /* renamed from: c  reason: collision with root package name */
    public static MusicPlayer f21273c;

    /* renamed from: a  reason: collision with root package name */
    public MediaPlayer f21274a;

    /* renamed from: b  reason: collision with root package name */
    public MusicPlayerState f21275b = MusicPlayerState.WAIT;

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
        public final /* synthetic */ CloudMusicData.MusicTagList.MusicList f21276e;

        public a(CloudMusicData.MusicTagList.MusicList musicList) {
            this.f21276e = musicList;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            d.a.k0.q3.i.h.a.b().d(this.f21276e);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921307));
            MusicPlayer.this.f21274a.setLooping(true);
            MusicPlayer.this.f21274a.start();
            MusicPlayer.this.f21275b = MusicPlayerState.PREPARED;
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a();
    }

    public static synchronized MusicPlayer c() {
        MusicPlayer musicPlayer;
        synchronized (MusicPlayer.class) {
            if (f21273c == null) {
                f21273c = new MusicPlayer();
            }
            musicPlayer = f21273c;
        }
        return musicPlayer;
    }

    public void d() {
        MediaPlayer mediaPlayer = this.f21274a;
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            this.f21274a.pause();
        }
        this.f21275b = MusicPlayerState.PAUSE;
    }

    public void e(String str, CloudMusicData.MusicTagList.MusicList musicList, b bVar) {
        if (this.f21275b == MusicPlayerState.PAUSE) {
            return;
        }
        if (this.f21274a == null) {
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.f21274a = mediaPlayer;
            mediaPlayer.setAudioStreamType(3);
        }
        try {
            this.f21274a.reset();
            this.f21274a.setDataSource(str);
            this.f21274a.prepare();
            this.f21275b = MusicPlayerState.WAIT;
            this.f21274a.setOnPreparedListener(new a(musicList));
        } catch (IOException e2) {
            e2.printStackTrace();
            this.f21275b = MusicPlayerState.ERROR;
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    public void f() {
        MediaPlayer mediaPlayer = this.f21274a;
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                this.f21274a.stop();
            }
            this.f21274a.release();
            this.f21274a = null;
        }
    }

    public void g() {
        MediaPlayer mediaPlayer = this.f21274a;
        if (mediaPlayer != null) {
            mediaPlayer.start();
            this.f21274a.seekTo(0);
        }
        this.f21275b = MusicPlayerState.RESUME;
    }
}
