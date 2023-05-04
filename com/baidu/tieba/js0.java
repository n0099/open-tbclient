package com.baidu.tieba;

import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.nadcore.player.strategy.IVideoUpdateStrategy;
/* loaded from: classes5.dex */
public interface js0 extends fs0, hs0 {
    public static final a a = wa1.a;

    /* loaded from: classes5.dex */
    public interface a {
        js0 a(Context context, int i);

        js0 b(Context context, int i, @Nullable ks0 ks0Var);
    }

    void a(gs0 gs0Var);

    void attachToContainer(@NonNull ViewGroup viewGroup);

    void c(@NonNull yp0 yp0Var);

    void d(@NonNull IVideoUpdateStrategy iVideoUpdateStrategy);

    void release();
}
