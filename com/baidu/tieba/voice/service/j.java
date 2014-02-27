package com.baidu.tieba.voice.service;

import android.media.MediaPlayer;
import com.baidu.tieba.voice.VoiceManager;
import java.io.IOException;
/* loaded from: classes.dex */
public final class j extends MediaPlayer implements g {
    private static Object a = new Object();
    private static j b = null;
    private boolean c = false;
    private boolean d = true;
    private int e = -1;

    private j() {
    }

    public static j h() {
        if (b == null) {
            synchronized (a) {
                if (b == null) {
                    b = new j();
                }
            }
        }
        return b;
    }

    @Override // com.baidu.tieba.voice.service.g
    public final boolean a(String str) {
        this.e = -1;
        if (!this.c) {
            this.d = true;
            reset();
            try {
                setDataSource(str);
                setAudioStreamType(VoiceManager.i);
                try {
                    prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                    this.e = 2;
                    return false;
                } catch (IllegalStateException e2) {
                    this.e = 1;
                    return false;
                }
            } catch (IOException e3) {
                this.e = 2;
                return false;
            } catch (IllegalArgumentException e4) {
                this.e = 0;
                return false;
            } catch (IllegalStateException e5) {
                this.e = 1;
                return false;
            }
        }
        this.c = true;
        return true;
    }

    @Override // com.baidu.tieba.voice.service.g
    public final void a() {
        start();
        this.d = false;
    }

    @Override // com.baidu.tieba.voice.service.g
    public final void b() {
        if (!this.d) {
            stop();
            this.d = true;
            this.c = false;
        }
    }

    @Override // com.baidu.tieba.voice.service.g
    public final void c() {
        pause();
    }

    @Override // com.baidu.tieba.voice.service.g
    public final void d() {
        reset();
        this.c = false;
        this.d = true;
        this.e = -1;
    }

    @Override // com.baidu.tieba.voice.service.g
    public final int e() {
        return getCurrentPosition();
    }

    @Override // com.baidu.tieba.voice.service.g
    public final boolean f() {
        return this.c;
    }

    @Override // com.baidu.tieba.voice.service.g
    public final void a(int i) {
        try {
            seekTo(i);
        } catch (Exception e) {
        }
    }

    @Override // com.baidu.tieba.voice.service.g
    public final int g() {
        return this.e;
    }
}
