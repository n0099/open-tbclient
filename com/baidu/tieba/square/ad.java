package com.baidu.tieba.square;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.util.bg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ad implements View.OnClickListener {
    final /* synthetic */ ac a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ac acVar) {
        this.a = acVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        af afVar;
        Context context;
        Object tag = view.getTag();
        if (!(view.getTag() instanceof af)) {
            afVar = null;
        } else {
            afVar = (af) tag;
        }
        String a = ak.a("forum_list_recommend", afVar.c());
        if (afVar != null) {
            bg a2 = bg.a();
            context = this.a.b;
            String[] strArr = new String[3];
            strArr[0] = afVar.b();
            strArr[2] = a;
            a2.a(context, strArr);
        }
    }
}
