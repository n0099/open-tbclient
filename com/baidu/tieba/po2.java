package com.baidu.tieba;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
/* loaded from: classes5.dex */
public interface po2 {

    /* loaded from: classes5.dex */
    public interface a {
        void b(po2 po2Var);
    }

    /* loaded from: classes5.dex */
    public interface b {
        boolean f(po2 po2Var, int i, int i2);
    }

    /* loaded from: classes5.dex */
    public interface c {
        void c(po2 po2Var);
    }

    /* loaded from: classes5.dex */
    public interface d {
        void e(po2 po2Var);
    }

    /* loaded from: classes5.dex */
    public interface e {
        void a(po2 po2Var);
    }

    /* loaded from: classes5.dex */
    public interface f {
        void d(po2 po2Var);
    }

    void a(FrameLayout frameLayout);

    void b();

    void c();

    void d(boolean z);

    po2 e(Context context, @NonNull dt2 dt2Var);

    void f();

    void g(a aVar);

    int getCurrentPosition();

    int getDuration();

    void h(dt2 dt2Var, boolean z);

    void i(String str);

    boolean isEnd();

    boolean isPlaying();

    void j(e eVar);

    void k(f fVar);

    void l(boolean z, int i);

    void m(d dVar);

    void mute(boolean z);

    void n(dt2 dt2Var);

    void o(dt2 dt2Var);

    boolean onBackPressed();

    void p(b bVar);

    void pause();

    int q(String str);

    void r(c cVar);

    void resume();

    void seekTo(int i);

    void stop();
}
