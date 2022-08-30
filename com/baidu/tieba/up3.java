package com.baidu.tieba;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
/* loaded from: classes6.dex */
public interface up3 {
    void a(FrameLayout frameLayout);

    void d(boolean z);

    up3 e(Context context, @NonNull qo3 qo3Var);

    void g(op3 op3Var);

    int getCurrentPosition();

    int getDuration();

    void h(qo3 qo3Var);

    boolean isEnd();

    boolean isPlaying();

    void mute(boolean z);

    void pause();

    void resume();

    void stop();
}
