package com.baidu.tieba;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
/* loaded from: classes6.dex */
public interface ku3 {
    void a(FrameLayout frameLayout);

    void d(boolean z);

    ku3 e(Context context, @NonNull gt3 gt3Var);

    void g(eu3 eu3Var);

    int getCurrentPosition();

    int getDuration();

    void h(gt3 gt3Var);

    boolean isEnd();

    boolean isPlaying();

    void mute(boolean z);

    void pause();

    void resume();

    void stop();
}
