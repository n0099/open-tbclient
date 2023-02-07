package com.baidu.tieba;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
/* loaded from: classes6.dex */
public interface rx3 {
    void a(FrameLayout frameLayout);

    void d(boolean z);

    rx3 e(Context context, @NonNull nw3 nw3Var);

    void g(lx3 lx3Var);

    int getCurrentPosition();

    int getDuration();

    void h(nw3 nw3Var);

    boolean isEnd();

    boolean isPlaying();

    void mute(boolean z);

    void pause();

    void resume();

    void stop();
}
