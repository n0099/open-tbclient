package com.baidu.tieba;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
/* loaded from: classes6.dex */
public interface st2 {

    /* loaded from: classes6.dex */
    public interface a {
        void b(st2 st2Var);
    }

    /* loaded from: classes6.dex */
    public interface b {
        boolean f(st2 st2Var, int i, int i2);
    }

    /* loaded from: classes6.dex */
    public interface c {
        void c(st2 st2Var);
    }

    /* loaded from: classes6.dex */
    public interface d {
        void e(st2 st2Var);
    }

    /* loaded from: classes6.dex */
    public interface e {
        void a(st2 st2Var);
    }

    /* loaded from: classes6.dex */
    public interface f {
        void d(st2 st2Var);
    }

    void a(FrameLayout frameLayout);

    void b();

    void c();

    void d(boolean z);

    st2 e(Context context, @NonNull gy2 gy2Var);

    void f();

    void g(a aVar);

    int getCurrentPosition();

    int getDuration();

    void h(gy2 gy2Var, boolean z);

    void i(String str);

    boolean isEnd();

    boolean isPlaying();

    void j(e eVar);

    void k(f fVar);

    void l(boolean z, int i);

    void m(d dVar);

    void mute(boolean z);

    void n(gy2 gy2Var);

    void o(gy2 gy2Var);

    boolean onBackPressed();

    void p(b bVar);

    void pause();

    int q(String str);

    void r(c cVar);

    void resume();

    void seekTo(int i);

    void stop();
}
