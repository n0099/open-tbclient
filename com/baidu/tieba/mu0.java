package com.baidu.tieba;

import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.nadcore.player.strategy.IVideoUpdateStrategy;
/* loaded from: classes6.dex */
public interface mu0 extends iu0, ku0 {
    public static final a a = zc1.a;

    /* loaded from: classes6.dex */
    public interface a {
        mu0 a(Context context, int i);

        mu0 b(Context context, int i, @Nullable nu0 nu0Var);
    }

    void a(ju0 ju0Var);

    void attachToContainer(@NonNull ViewGroup viewGroup);

    void c(@NonNull bs0 bs0Var);

    void d(@NonNull IVideoUpdateStrategy iVideoUpdateStrategy);

    void release();
}
