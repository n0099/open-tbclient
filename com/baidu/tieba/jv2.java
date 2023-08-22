package com.baidu.tieba;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
/* loaded from: classes6.dex */
public interface jv2 {

    /* loaded from: classes6.dex */
    public interface a {
        void b(jv2 jv2Var);
    }

    /* loaded from: classes6.dex */
    public interface b {
        boolean f(jv2 jv2Var, int i, int i2);
    }

    /* loaded from: classes6.dex */
    public interface c {
        void c(jv2 jv2Var);
    }

    /* loaded from: classes6.dex */
    public interface d {
        void e(jv2 jv2Var);
    }

    /* loaded from: classes6.dex */
    public interface e {
        void a(jv2 jv2Var);
    }

    /* loaded from: classes6.dex */
    public interface f {
        void d(jv2 jv2Var);
    }

    void a(FrameLayout frameLayout);

    void b();

    void c();

    void d(boolean z);

    jv2 e(Context context, @NonNull xz2 xz2Var);

    void f();

    void g(a aVar);

    int getCurrentPosition();

    int getDuration();

    void h(xz2 xz2Var, boolean z);

    void i(String str);

    boolean isEnd();

    boolean isPlaying();

    void j(e eVar);

    void k(f fVar);

    void l(boolean z, int i);

    void m(d dVar);

    void mute(boolean z);

    void n(xz2 xz2Var);

    void o(xz2 xz2Var);

    boolean onBackPressed();

    void p(b bVar);

    void pause();

    int q(String str);

    void r(c cVar);

    void resume();

    void seekTo(int i);

    void stop();
}
