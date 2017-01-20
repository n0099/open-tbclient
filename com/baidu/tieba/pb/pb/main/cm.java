package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.FloatingLayout;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class cm implements com.baidu.tbadk.ala.f {
    @Override // com.baidu.tbadk.ala.f
    public View Q(Context context) {
        TextView P = com.baidu.tbadk.ala.d.P(context);
        if (P != null) {
            FloatingLayout.a aVar = new FloatingLayout.a(-2, -2);
            aVar.gravity = 16;
            aVar.setMargins(com.baidu.adp.lib.util.k.e(context, r.f.ds6), -com.baidu.adp.lib.util.k.e(context, r.f.ds8), -com.baidu.adp.lib.util.k.e(context, r.f.ds4), 0);
            P.setLayoutParams(aVar);
        }
        return P;
    }
}
