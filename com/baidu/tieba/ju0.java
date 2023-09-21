package com.baidu.tieba;

import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.nadcore.player.strategy.IVideoUpdateStrategy;
/* loaded from: classes6.dex */
public interface ju0 extends fu0, hu0 {
    public static final a a = cc1.a;

    /* loaded from: classes6.dex */
    public interface a {
        ju0 a(Context context, int i);

        ju0 b(Context context, int i, @Nullable ku0 ku0Var);
    }

    void a(gu0 gu0Var);

    void attachToContainer(@NonNull ViewGroup viewGroup);

    void c(@NonNull vr0 vr0Var);

    void d(@NonNull IVideoUpdateStrategy iVideoUpdateStrategy);

    void release();
}
