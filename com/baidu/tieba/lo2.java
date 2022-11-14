package com.baidu.tieba;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
/* loaded from: classes5.dex */
public interface lo2 {

    /* loaded from: classes5.dex */
    public interface a {
        void b(lo2 lo2Var);
    }

    /* loaded from: classes5.dex */
    public interface b {
        boolean f(lo2 lo2Var, int i, int i2);
    }

    /* loaded from: classes5.dex */
    public interface c {
        void c(lo2 lo2Var);
    }

    /* loaded from: classes5.dex */
    public interface d {
        void e(lo2 lo2Var);
    }

    /* loaded from: classes5.dex */
    public interface e {
        void a(lo2 lo2Var);
    }

    /* loaded from: classes5.dex */
    public interface f {
        void d(lo2 lo2Var);
    }

    void a(FrameLayout frameLayout);

    void b();

    void c();

    void d(boolean z);

    lo2 e(Context context, @NonNull zs2 zs2Var);

    void f();

    void g(a aVar);

    int getCurrentPosition();

    int getDuration();

    void h(zs2 zs2Var, boolean z);

    void i(String str);

    boolean isEnd();

    boolean isPlaying();

    void j(e eVar);

    void k(f fVar);

    void l(boolean z, int i);

    void m(d dVar);

    void mute(boolean z);

    void n(zs2 zs2Var);

    void o(zs2 zs2Var);

    boolean onBackPressed();

    void p(b bVar);

    void pause();

    int q(String str);

    void r(c cVar);

    void resume();

    void seekTo(int i);

    void stop();
}
