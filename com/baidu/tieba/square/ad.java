package com.baidu.tieba.square;

import android.content.Context;
import android.view.View;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements View.OnClickListener {
    final /* synthetic */ ac a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ac acVar) {
        this.a = acVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        af afVar = view.getTag() instanceof af ? (af) view.getTag() : null;
        String a = am.a("forum_list_recommend", afVar.c());
        if (afVar != null) {
            context = this.a.b;
            UtilHelper.a(context, afVar.b(), null, a);
        }
    }
}
