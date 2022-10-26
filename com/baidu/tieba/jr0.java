package com.baidu.tieba;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.nadcore.player.strategy.IVideoUpdateStrategy;
/* loaded from: classes4.dex */
public interface jr0 extends fr0, hr0 {
    public static final a a = k61.a;

    /* loaded from: classes4.dex */
    public interface a {
        jr0 a(Context context, int i);

        jr0 b(Context context, int i, kr0 kr0Var);
    }

    void a(gr0 gr0Var);

    void attachToContainer(ViewGroup viewGroup);

    void c(kp0 kp0Var);

    void d(IVideoUpdateStrategy iVideoUpdateStrategy);

    void release();
}
