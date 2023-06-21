package com.baidu.tieba;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
/* loaded from: classes7.dex */
public interface u04 {
    void a(FrameLayout frameLayout);

    void d(boolean z);

    u04 e(Context context, @NonNull qz3 qz3Var);

    void g(o04 o04Var);

    int getCurrentPosition();

    int getDuration();

    void h(qz3 qz3Var);

    boolean isEnd();

    boolean isPlaying();

    void mute(boolean z);

    void pause();

    void resume();

    void stop();
}
