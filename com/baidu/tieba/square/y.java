package com.baidu.tieba.square;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.util.bq;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements View.OnClickListener {
    final /* synthetic */ x a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar) {
        this.a = xVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        aa aaVar;
        Context context;
        Object tag = view.getTag();
        if (!(view.getTag() instanceof aa)) {
            aaVar = null;
        } else {
            aaVar = (aa) tag;
        }
        String a = af.a("forum_list_recommend", aaVar.c());
        if (aaVar != null) {
            bq a2 = bq.a();
            context = this.a.b;
            String[] strArr = new String[3];
            strArr[0] = aaVar.b();
            strArr[2] = a;
            a2.a(context, strArr);
        }
    }
}
