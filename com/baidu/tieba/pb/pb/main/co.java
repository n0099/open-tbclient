package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class co implements com.baidu.tbadk.ala.f {
    @Override // com.baidu.tbadk.ala.f
    public View Q(Context context) {
        TextView P = com.baidu.tbadk.ala.d.P(context);
        if (P != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(com.baidu.adp.lib.util.k.e(context, r.f.ds4), -com.baidu.adp.lib.util.k.e(context, r.f.ds1), -com.baidu.adp.lib.util.k.e(context, r.f.ds6), 0);
            layoutParams.gravity = 16;
            P.setLayoutParams(layoutParams);
        }
        return P;
    }
}
