package com.baidu.tieba;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
/* loaded from: classes7.dex */
public interface nq2 {

    /* loaded from: classes7.dex */
    public interface a {
        void b(nq2 nq2Var);
    }

    /* loaded from: classes7.dex */
    public interface b {
        boolean f(nq2 nq2Var, int i, int i2);
    }

    /* loaded from: classes7.dex */
    public interface c {
        void c(nq2 nq2Var);
    }

    /* loaded from: classes7.dex */
    public interface d {
        void e(nq2 nq2Var);
    }

    /* loaded from: classes7.dex */
    public interface e {
        void a(nq2 nq2Var);
    }

    /* loaded from: classes7.dex */
    public interface f {
        void d(nq2 nq2Var);
    }

    void a(FrameLayout frameLayout);

    void b();

    void c();

    void d(boolean z);

    nq2 e(Context context, @NonNull bv2 bv2Var);

    void f();

    void g(a aVar);

    int getCurrentPosition();

    int getDuration();

    void h(bv2 bv2Var, boolean z);

    void i(String str);

    boolean isEnd();

    boolean isPlaying();

    void j(e eVar);

    void k(f fVar);

    void l(boolean z, int i);

    void m(d dVar);

    void mute(boolean z);

    void n(bv2 bv2Var);

    void o(bv2 bv2Var);

    boolean onBackPressed();

    void p(b bVar);

    void pause();

    int q(String str);

    void r(c cVar);

    void resume();

    void seekTo(int i);

    void stop();
}
