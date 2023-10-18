package com.baidu.tieba;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
/* loaded from: classes8.dex */
public interface vp2 {

    /* loaded from: classes8.dex */
    public interface a {
        void b(vp2 vp2Var);
    }

    /* loaded from: classes8.dex */
    public interface b {
        boolean f(vp2 vp2Var, int i, int i2);
    }

    /* loaded from: classes8.dex */
    public interface c {
        void c(vp2 vp2Var);
    }

    /* loaded from: classes8.dex */
    public interface d {
        void e(vp2 vp2Var);
    }

    /* loaded from: classes8.dex */
    public interface e {
        void a(vp2 vp2Var);
    }

    /* loaded from: classes8.dex */
    public interface f {
        void d(vp2 vp2Var);
    }

    void a(FrameLayout frameLayout);

    void b();

    void c();

    void d(boolean z);

    vp2 e(Context context, @NonNull ju2 ju2Var);

    void f();

    void g(a aVar);

    int getCurrentPosition();

    int getDuration();

    void h(ju2 ju2Var, boolean z);

    void i(String str);

    boolean isEnd();

    boolean isPlaying();

    void j(e eVar);

    void k(f fVar);

    void l(boolean z, int i);

    void m(d dVar);

    void mute(boolean z);

    void n(ju2 ju2Var);

    void o(ju2 ju2Var);

    boolean onBackPressed();

    void p(b bVar);

    void pause();

    int q(String str);

    void r(c cVar);

    void resume();

    void seekTo(int i);

    void stop();
}
