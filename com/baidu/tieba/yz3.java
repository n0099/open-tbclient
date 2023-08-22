package com.baidu.tieba;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
/* loaded from: classes8.dex */
public interface yz3 {
    void a(FrameLayout frameLayout);

    void d(boolean z);

    yz3 e(Context context, @NonNull uy3 uy3Var);

    void g(sz3 sz3Var);

    int getCurrentPosition();

    int getDuration();

    void h(uy3 uy3Var);

    boolean isEnd();

    boolean isPlaying();

    void mute(boolean z);

    void pause();

    void resume();

    void stop();
}
