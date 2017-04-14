package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.FloatingLayout;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class cj implements com.baidu.tbadk.ala.f {
    @Override // com.baidu.tbadk.ala.f
    public View aq(Context context) {
        TextView ap = com.baidu.tbadk.ala.d.ap(context);
        if (ap != null) {
            FloatingLayout.a aVar = new FloatingLayout.a(-2, -2);
            aVar.gravity = 16;
            aVar.setMargins(com.baidu.adp.lib.util.k.g(context, w.f.ds6), -com.baidu.adp.lib.util.k.g(context, w.f.ds8), -com.baidu.adp.lib.util.k.g(context, w.f.ds4), 0);
            ap.setLayoutParams(aVar);
        }
        return ap;
    }
}
