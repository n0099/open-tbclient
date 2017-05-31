package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.FloatingLayout;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class cq implements com.baidu.tbadk.ala.e {
    @Override // com.baidu.tbadk.ala.e
    public View aq(Context context) {
        TextView ap = com.baidu.tbadk.ala.c.ap(context);
        if (ap != null) {
            FloatingLayout.a aVar = new FloatingLayout.a(-2, -2);
            aVar.gravity = 16;
            com.baidu.tbadk.core.util.aq.i(ap, w.e.cp_cont_f);
            aVar.setMargins(com.baidu.adp.lib.util.k.g(context, w.f.ds16), 0, 0, 0);
            ap.setLayoutParams(aVar);
        }
        return ap;
    }
}
