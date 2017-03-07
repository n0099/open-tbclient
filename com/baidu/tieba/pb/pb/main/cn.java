package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class cn implements com.baidu.tbadk.ala.f {
    @Override // com.baidu.tbadk.ala.f
    public View ao(Context context) {
        TextView an = com.baidu.tbadk.ala.d.an(context);
        if (an != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(com.baidu.adp.lib.util.k.g(context, w.f.ds4), -com.baidu.adp.lib.util.k.g(context, w.f.ds1), -com.baidu.adp.lib.util.k.g(context, w.f.ds6), 0);
            layoutParams.gravity = 16;
            an.setLayoutParams(layoutParams);
        }
        return an;
    }
}
