package com.baidu.tieba;

import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.nadcore.player.strategy.IVideoUpdateStrategy;
/* loaded from: classes9.dex */
public interface yp0 extends up0, wp0 {
    public static final a a = h71.a;

    /* loaded from: classes9.dex */
    public interface a {
        yp0 a(Context context, int i, @Nullable zp0 zp0Var);
    }

    void a(vp0 vp0Var);

    void attachToContainer(@NonNull ViewGroup viewGroup);

    void c(@NonNull kn0 kn0Var);

    void d(@NonNull IVideoUpdateStrategy iVideoUpdateStrategy);

    void release();
}
