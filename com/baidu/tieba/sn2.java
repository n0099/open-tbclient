package com.baidu.tieba;

import android.content.Context;
import android.widget.FrameLayout;
/* loaded from: classes5.dex */
public interface sn2 {

    /* loaded from: classes5.dex */
    public interface a {
        void b(sn2 sn2Var);
    }

    /* loaded from: classes5.dex */
    public interface b {
        boolean f(sn2 sn2Var, int i, int i2);
    }

    /* loaded from: classes5.dex */
    public interface c {
        void c(sn2 sn2Var);
    }

    /* loaded from: classes5.dex */
    public interface d {
        void e(sn2 sn2Var);
    }

    /* loaded from: classes5.dex */
    public interface e {
        void a(sn2 sn2Var);
    }

    /* loaded from: classes5.dex */
    public interface f {
        void d(sn2 sn2Var);
    }

    void a(FrameLayout frameLayout);

    void b();

    void c();

    void d(boolean z);

    sn2 e(Context context, gs2 gs2Var);

    void f();

    void g(a aVar);

    int getCurrentPosition();

    int getDuration();

    void h(gs2 gs2Var, boolean z);

    void i(String str);

    boolean isEnd();

    boolean isPlaying();

    void j(e eVar);

    void k(f fVar);

    void l(boolean z, int i);

    void m(d dVar);

    void mute(boolean z);

    void n(gs2 gs2Var);

    void o(gs2 gs2Var);

    boolean onBackPressed();

    void p(b bVar);

    void pause();

    int q(String str);

    void r(c cVar);

    void resume();

    void seekTo(int i);

    void stop();
}
