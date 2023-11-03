package com.baidu.tieba;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
/* loaded from: classes7.dex */
public interface mq2 {

    /* loaded from: classes7.dex */
    public interface a {
        void b(mq2 mq2Var);
    }

    /* loaded from: classes7.dex */
    public interface b {
        boolean f(mq2 mq2Var, int i, int i2);
    }

    /* loaded from: classes7.dex */
    public interface c {
        void c(mq2 mq2Var);
    }

    /* loaded from: classes7.dex */
    public interface d {
        void e(mq2 mq2Var);
    }

    /* loaded from: classes7.dex */
    public interface e {
        void a(mq2 mq2Var);
    }

    /* loaded from: classes7.dex */
    public interface f {
        void d(mq2 mq2Var);
    }

    void a(FrameLayout frameLayout);

    void b();

    void c();

    void d(boolean z);

    mq2 e(Context context, @NonNull av2 av2Var);

    void f();

    void g(a aVar);

    int getCurrentPosition();

    int getDuration();

    void h(av2 av2Var, boolean z);

    void i(String str);

    boolean isEnd();

    boolean isPlaying();

    void j(e eVar);

    void k(f fVar);

    void l(boolean z, int i);

    void m(d dVar);

    void mute(boolean z);

    void n(av2 av2Var);

    void o(av2 av2Var);

    boolean onBackPressed();

    void p(b bVar);

    void pause();

    int q(String str);

    void r(c cVar);

    void resume();

    void seekTo(int i);

    void stop();
}
