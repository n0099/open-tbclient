package com.baidu.tieba.mention;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.b.av;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tieba.data.ai;
import com.baidu.tieba.model.am;
/* loaded from: classes.dex */
final class x implements View.OnClickListener {
    final /* synthetic */ PostActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(PostActivity postActivity) {
        this.a = postActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        am amVar;
        am amVar2;
        am amVar3;
        am amVar4;
        am amVar5;
        amVar = this.a.l;
        if (amVar != null) {
            amVar2 = this.a.l;
            if (amVar2.a() != null) {
                amVar3 = this.a.l;
                com.baidu.tieba.data.ae a = amVar3.a();
                ai aiVar = a.e().get(0);
                if (aiVar != null) {
                    if (aiVar.d() != null) {
                        if (a.g() != null && a.g().getIfpost() == 0) {
                            com.baidu.adp.lib.util.i.a((Context) this.a, a.g().getForbid_info());
                            return;
                        }
                        PostActivity postActivity = this.a;
                        String name = a.c().getName();
                        String l = a.d().l();
                        String d = aiVar.d();
                        String d2 = aiVar.d();
                        int e = aiVar.e();
                        AntiData g = a.g();
                        amVar5 = this.a.l;
                        com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001001, new av(postActivity, 2, name, l, d, d2, e, g, 13001, false, amVar5.a().k(), null, false, false, null, null, null)));
                    } else if (a.g() == null || a.g().getIfpost() != 0) {
                        PostActivity postActivity2 = this.a;
                        String name2 = a.c().getName();
                        String l2 = a.d().l();
                        String d3 = aiVar.d();
                        int e2 = aiVar.e();
                        AntiData g2 = a.g();
                        amVar4 = this.a.l;
                        com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001001, new av(postActivity2, 1, name2, l2, d3, null, e2, g2, 13002, false, amVar4.a().k(), null, false, false, null, null, null)));
                    } else {
                        com.baidu.adp.lib.util.i.a((Context) this.a, a.g().getForbid_info());
                    }
                }
            }
        }
    }
}
