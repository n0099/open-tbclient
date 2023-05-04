package com.baidu.tieba;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
/* loaded from: classes6.dex */
public interface sw3 {
    void a(FrameLayout frameLayout);

    void d(boolean z);

    sw3 e(Context context, @NonNull ov3 ov3Var);

    void g(mw3 mw3Var);

    int getCurrentPosition();

    int getDuration();

    void h(ov3 ov3Var);

    boolean isEnd();

    boolean isPlaying();

    void mute(boolean z);

    void pause();

    void resume();

    void stop();
}
