package com.baidu.wallet.home.ui;

import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes5.dex */
public class a {
    public static void a(View view) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        view.measure(makeMeasureSpec, makeMeasureSpec2);
    }
}
