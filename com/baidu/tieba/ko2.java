package com.baidu.tieba;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
/* loaded from: classes4.dex */
public interface ko2 {

    /* loaded from: classes4.dex */
    public interface a {
        void b(ko2 ko2Var);
    }

    /* loaded from: classes4.dex */
    public interface b {
        boolean f(ko2 ko2Var, int i, int i2);
    }

    /* loaded from: classes4.dex */
    public interface c {
        void c(ko2 ko2Var);
    }

    /* loaded from: classes4.dex */
    public interface d {
        void e(ko2 ko2Var);
    }

    /* loaded from: classes4.dex */
    public interface e {
        void a(ko2 ko2Var);
    }

    /* loaded from: classes4.dex */
    public interface f {
        void d(ko2 ko2Var);
    }

    void a(FrameLayout frameLayout);

    void b();

    void c();

    void d(boolean z);

    ko2 e(Context context, @NonNull ys2 ys2Var);

    void f();

    void g(a aVar);

    int getCurrentPosition();

    int getDuration();

    void h(ys2 ys2Var, boolean z);

    void i(String str);

    boolean isEnd();

    boolean isPlaying();

    void j(e eVar);

    void k(f fVar);

    void l(boolean z, int i);

    void m(d dVar);

    void mute(boolean z);

    void n(ys2 ys2Var);

    void o(ys2 ys2Var);

    boolean onBackPressed();

    void p(b bVar);

    void pause();

    int q(String str);

    void r(c cVar);

    void resume();

    void seekTo(int i);

    void stop();
}
