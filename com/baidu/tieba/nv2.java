package com.baidu.tieba;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
/* loaded from: classes7.dex */
public interface nv2 {

    /* loaded from: classes7.dex */
    public interface a {
        void b(nv2 nv2Var);
    }

    /* loaded from: classes7.dex */
    public interface b {
        boolean f(nv2 nv2Var, int i, int i2);
    }

    /* loaded from: classes7.dex */
    public interface c {
        void c(nv2 nv2Var);
    }

    /* loaded from: classes7.dex */
    public interface d {
        void e(nv2 nv2Var);
    }

    /* loaded from: classes7.dex */
    public interface e {
        void a(nv2 nv2Var);
    }

    /* loaded from: classes7.dex */
    public interface f {
        void d(nv2 nv2Var);
    }

    void a(FrameLayout frameLayout);

    void b();

    void c();

    void d(boolean z);

    nv2 e(Context context, @NonNull b03 b03Var);

    void f();

    void g(a aVar);

    int getCurrentPosition();

    int getDuration();

    void h(b03 b03Var, boolean z);

    void i(String str);

    boolean isEnd();

    boolean isPlaying();

    void j(e eVar);

    void k(f fVar);

    void l(boolean z, int i);

    void m(d dVar);

    void mute(boolean z);

    void n(b03 b03Var);

    void o(b03 b03Var);

    boolean onBackPressed();

    void p(b bVar);

    void pause();

    int q(String str);

    void r(c cVar);

    void resume();

    void seekTo(int i);

    void stop();
}
