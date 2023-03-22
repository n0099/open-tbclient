package com.baidu.tieba;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
/* loaded from: classes7.dex */
public interface zr2 {

    /* loaded from: classes7.dex */
    public interface a {
        void b(zr2 zr2Var);
    }

    /* loaded from: classes7.dex */
    public interface b {
        boolean f(zr2 zr2Var, int i, int i2);
    }

    /* loaded from: classes7.dex */
    public interface c {
        void c(zr2 zr2Var);
    }

    /* loaded from: classes7.dex */
    public interface d {
        void e(zr2 zr2Var);
    }

    /* loaded from: classes7.dex */
    public interface e {
        void a(zr2 zr2Var);
    }

    /* loaded from: classes7.dex */
    public interface f {
        void d(zr2 zr2Var);
    }

    void a(FrameLayout frameLayout);

    void b();

    void c();

    void d(boolean z);

    zr2 e(Context context, @NonNull nw2 nw2Var);

    void f();

    void g(a aVar);

    int getCurrentPosition();

    int getDuration();

    void h(nw2 nw2Var, boolean z);

    void i(String str);

    boolean isEnd();

    boolean isPlaying();

    void j(e eVar);

    void k(f fVar);

    void l(boolean z, int i);

    void m(d dVar);

    void mute(boolean z);

    void n(nw2 nw2Var);

    void o(nw2 nw2Var);

    boolean onBackPressed();

    void p(b bVar);

    void pause();

    int q(String str);

    void r(c cVar);

    void resume();

    void seekTo(int i);

    void stop();
}
