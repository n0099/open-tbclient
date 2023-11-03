package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import com.baidu.pyramid.runtime.service.ServiceReference;
/* loaded from: classes8.dex */
public interface uk0 {
    public static final ServiceReference a = new ServiceReference("nad.core", "rewardCriusPop");

    void a(sk0 sk0Var);

    void b(gn0 gn0Var, Context context);

    View getView();

    void release();

    void show();
}
