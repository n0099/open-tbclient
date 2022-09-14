package com.baidu.tieba;

import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.nadcore.player.strategy.IVideoUpdateStrategy;
/* loaded from: classes6.dex */
public interface vq0 extends rq0, tq0 {
    public static final a a = w51.a;

    /* loaded from: classes6.dex */
    public interface a {
        vq0 a(Context context, int i);

        vq0 b(Context context, int i, @Nullable wq0 wq0Var);
    }

    void a(sq0 sq0Var);

    void attachToContainer(@NonNull ViewGroup viewGroup);

    void c(@NonNull wo0 wo0Var);

    void d(@NonNull IVideoUpdateStrategy iVideoUpdateStrategy);

    void release();
}
