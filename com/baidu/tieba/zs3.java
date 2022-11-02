package com.baidu.tieba;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
/* loaded from: classes6.dex */
public interface zs3 {
    void a(FrameLayout frameLayout);

    void d(boolean z);

    zs3 e(Context context, @NonNull vr3 vr3Var);

    void g(ts3 ts3Var);

    int getCurrentPosition();

    int getDuration();

    void h(vr3 vr3Var);

    boolean isEnd();

    boolean isPlaying();

    void mute(boolean z);

    void pause();

    void resume();

    void stop();
}
