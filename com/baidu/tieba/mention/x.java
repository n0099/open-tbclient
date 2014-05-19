package com.baidu.tieba.mention;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.bh;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tieba.model.am;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements View.OnClickListener {
    final /* synthetic */ PostActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(PostActivity postActivity) {
        this.a = postActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
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
                com.baidu.tieba.data.ah ahVar = a.e().get(0);
                if (ahVar != null) {
                    if (ahVar.d() != null) {
                        if (a.g() != null && a.g().getIfpost() == 0) {
                            com.baidu.adp.lib.util.h.a((Context) this.a, a.g().getForbid_info());
                            return;
                        }
                        PostActivity postActivity = this.a;
                        String name = a.c().getName();
                        String k = a.d().k();
                        String d = ahVar.d();
                        String d2 = ahVar.d();
                        int e = ahVar.e();
                        AntiData g = a.g();
                        amVar5 = this.a.l;
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003001, new bh(postActivity, 2, name, k, d, d2, e, g, 13001, false, amVar5.a().k(), null, false, false, null, null, null)));
                    } else if (a.g() == null || a.g().getIfpost() != 0) {
                        PostActivity postActivity2 = this.a;
                        String name2 = a.c().getName();
                        String k2 = a.d().k();
                        String d3 = ahVar.d();
                        int e2 = ahVar.e();
                        AntiData g2 = a.g();
                        amVar4 = this.a.l;
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003001, new bh(postActivity2, 1, name2, k2, d3, null, e2, g2, 13002, false, amVar4.a().k(), null, false, false, null, null, null)));
                    } else {
                        com.baidu.adp.lib.util.h.a((Context) this.a, a.g().getForbid_info());
                    }
                }
            }
        }
    }
}
