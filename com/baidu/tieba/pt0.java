package com.baidu.tieba;

import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.nadcore.player.strategy.IVideoUpdateStrategy;
/* loaded from: classes5.dex */
public interface pt0 extends lt0, nt0 {
    public static final a a = cc1.a;

    /* loaded from: classes5.dex */
    public interface a {
        pt0 a(Context context, int i);

        pt0 b(Context context, int i, @Nullable qt0 qt0Var);
    }

    void a(mt0 mt0Var);

    void attachToContainer(@NonNull ViewGroup viewGroup);

    void c(@NonNull er0 er0Var);

    void d(@NonNull IVideoUpdateStrategy iVideoUpdateStrategy);

    void release();
}
