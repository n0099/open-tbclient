package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import com.baidu.pyramid.runtime.service.ServiceReference;
/* loaded from: classes8.dex */
public interface vk0 {
    public static final ServiceReference a = new ServiceReference("nad.core", "rewardCriusPop");

    void a(tk0 tk0Var);

    void b(in0 in0Var, Context context);

    View getView();

    void release();

    void show();
}
