package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.view.NavigationBarCoverTip;
/* loaded from: classes4.dex */
public interface kz4 {
    boolean a();

    int b();

    void c(int i, TbPageContext tbPageContext, ViewGroup viewGroup);

    void d();

    NavigationBarCoverTip e(Activity activity, ViewGroup viewGroup);

    int f();

    void g(boolean z, long j);

    void h(boolean z, int i, int i2);

    Dialog i(int i, TbPageContext tbPageContext, ej5 ej5Var);
}
