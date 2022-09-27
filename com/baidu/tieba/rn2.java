package com.baidu.tieba;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
/* loaded from: classes5.dex */
public interface rn2 {

    /* loaded from: classes5.dex */
    public interface a {
        void b(rn2 rn2Var);
    }

    /* loaded from: classes5.dex */
    public interface b {
        boolean f(rn2 rn2Var, int i, int i2);
    }

    /* loaded from: classes5.dex */
    public interface c {
        void c(rn2 rn2Var);
    }

    /* loaded from: classes5.dex */
    public interface d {
        void e(rn2 rn2Var);
    }

    /* loaded from: classes5.dex */
    public interface e {
        void a(rn2 rn2Var);
    }

    /* loaded from: classes5.dex */
    public interface f {
        void d(rn2 rn2Var);
    }

    void a(FrameLayout frameLayout);

    void b();

    void c();

    void d(boolean z);

    rn2 e(Context context, @NonNull fs2 fs2Var);

    void f();

    void g(a aVar);

    int getCurrentPosition();

    int getDuration();

    void h(fs2 fs2Var, boolean z);

    void i(String str);

    boolean isEnd();

    boolean isPlaying();

    void j(e eVar);

    void k(f fVar);

    void l(boolean z, int i);

    void m(d dVar);

    void mute(boolean z);

    void n(fs2 fs2Var);

    void o(fs2 fs2Var);

    boolean onBackPressed();

    void p(b bVar);

    void pause();

    int q(String str);

    void r(c cVar);

    void resume();

    void seekTo(int i);

    void stop();
}
