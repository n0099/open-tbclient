package com.baidu.tieba;

import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.nadcore.player.strategy.IVideoUpdateStrategy;
/* loaded from: classes6.dex */
public interface iu0 extends eu0, gu0 {
    public static final a a = vc1.a;

    /* loaded from: classes6.dex */
    public interface a {
        iu0 a(Context context, int i);

        iu0 b(Context context, int i, @Nullable ju0 ju0Var);
    }

    void a(fu0 fu0Var);

    void attachToContainer(@NonNull ViewGroup viewGroup);

    void c(@NonNull xr0 xr0Var);

    void d(@NonNull IVideoUpdateStrategy iVideoUpdateStrategy);

    void release();
}
