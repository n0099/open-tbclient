package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.FloatingLayout;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class cl implements com.baidu.tbadk.ala.f {
    @Override // com.baidu.tbadk.ala.f
    public View ao(Context context) {
        TextView an = com.baidu.tbadk.ala.d.an(context);
        if (an != null) {
            FloatingLayout.a aVar = new FloatingLayout.a(-2, -2);
            aVar.gravity = 16;
            aVar.setMargins(com.baidu.adp.lib.util.k.g(context, w.f.ds6), -com.baidu.adp.lib.util.k.g(context, w.f.ds8), -com.baidu.adp.lib.util.k.g(context, w.f.ds4), 0);
            an.setLayoutParams(aVar);
        }
        return an;
    }
}
