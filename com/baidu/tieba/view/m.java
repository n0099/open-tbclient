package com.baidu.tieba.view;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.b.af;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class m implements View.OnClickListener {
    final /* synthetic */ l a;
    private final /* synthetic */ Context b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, Context context) {
        this.a = lVar;
        this.b = context;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Context context;
        Context context2;
        Context context3;
        Context context4;
        if (view.getId() == com.baidu.tieba.a.h.textHomeListFrsName) {
            String obj = view.getTag().toString();
            context2 = this.a.a;
            if (context2 instanceof com.baidu.tbadk.core.e) {
                context3 = this.a.a;
                context4 = this.a.a;
                ((com.baidu.tbadk.core.e) context3).a(new com.baidu.adp.framework.message.a(2003000, new com.baidu.tbadk.core.b.l(context4).a(obj, "")));
            }
            TiebaStatic.a(this.b, "forum_feed_frsclick", "frs_click", 1, new Object[0]);
            return;
        }
        o oVar = (o) view.getTag();
        if (oVar != null) {
            com.baidu.adp.framework.c a = com.baidu.adp.framework.c.a();
            context = this.a.a;
            a.a(new com.baidu.adp.framework.message.a(2004001, new af(context).a(oVar.l, null, null)));
            TiebaStatic.a(this.b, "forum_feed_pbclick", "pb_click", 1, new Object[0]);
        }
    }
}
