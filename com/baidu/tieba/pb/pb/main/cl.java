package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class cl implements com.baidu.tbadk.ala.f {
    @Override // com.baidu.tbadk.ala.f
    public View aq(Context context) {
        TextView ap = com.baidu.tbadk.ala.d.ap(context);
        if (ap != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(com.baidu.adp.lib.util.k.g(context, w.f.ds4), -com.baidu.adp.lib.util.k.g(context, w.f.ds1), -com.baidu.adp.lib.util.k.g(context, w.f.ds6), 0);
            layoutParams.gravity = 16;
            ap.setLayoutParams(layoutParams);
        }
        return ap;
    }
}
