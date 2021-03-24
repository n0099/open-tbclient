package com.baidu.tieba.video.cloudmusic;

import android.media.MediaPlayer;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import java.io.IOException;
/* loaded from: classes5.dex */
public class MusicPlayer {

    /* renamed from: c  reason: collision with root package name */
    public static MusicPlayer f21715c;

    /* renamed from: a  reason: collision with root package name */
    public MediaPlayer f21716a;

    /* renamed from: b  reason: collision with root package name */
    public MusicPlayerState f21717b = MusicPlayerState.WAIT;

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
        public final /* synthetic */ CloudMusicData.MusicTagList.MusicList f21718e;

        public a(CloudMusicData.MusicTagList.MusicList musicList) {
            this.f21718e = musicList;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            d.b.i0.p3.i.h.a.b().d(this.f21718e);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921307));
            MusicPlayer.this.f21716a.setLooping(true);
            MusicPlayer.this.f21716a.start();
            MusicPlayer.this.f21717b = MusicPlayerState.PREPARED;
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a();
    }

    public static synchronized MusicPlayer c() {
        MusicPlayer musicPlayer;
        synchronized (MusicPlayer.class) {
            if (f21715c == null) {
                f21715c = new MusicPlayer();
            }
            musicPlayer = f21715c;
        }
        return musicPlayer;
    }

    public void d() {
        MediaPlayer mediaPlayer = this.f21716a;
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            this.f21716a.pause();
        }
        this.f21717b = MusicPlayerState.PAUSE;
    }

    public void e(String str, CloudMusicData.MusicTagList.MusicList musicList, b bVar) {
        if (this.f21717b == MusicPlayerState.PAUSE) {
            return;
        }
        if (this.f21716a == null) {
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.f21716a = mediaPlayer;
            mediaPlayer.setAudioStreamType(3);
        }
        try {
            this.f21716a.reset();
            this.f21716a.setDataSource(str);
            this.f21716a.prepare();
            this.f21717b = MusicPlayerState.WAIT;
            this.f21716a.setOnPreparedListener(new a(musicList));
        } catch (IOException e2) {
            e2.printStackTrace();
            this.f21717b = MusicPlayerState.ERROR;
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    public void f() {
        MediaPlayer mediaPlayer = this.f21716a;
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                this.f21716a.stop();
            }
            this.f21716a.release();
            this.f21716a = null;
        }
    }

    public void g() {
        MediaPlayer mediaPlayer = this.f21716a;
        if (mediaPlayer != null) {
            mediaPlayer.start();
            this.f21716a.seekTo(0);
        }
        this.f21717b = MusicPlayerState.RESUME;
    }
}
