package com.baidu.tieba.mention;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ce;
import com.baidu.tbadk.core.data.AntiData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements View.OnClickListener {
    final /* synthetic */ PostActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(PostActivity postActivity) {
        this.a = postActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.model.am amVar;
        com.baidu.tieba.model.am amVar2;
        com.baidu.tieba.model.am amVar3;
        com.baidu.tieba.model.am amVar4;
        com.baidu.tieba.model.am amVar5;
        amVar = this.a.l;
        if (amVar != null) {
            amVar2 = this.a.l;
            if (amVar2.a() != null) {
                amVar3 = this.a.l;
                com.baidu.tieba.data.aj a = amVar3.a();
                com.baidu.tieba.data.an anVar = a.e().get(0);
                if (anVar != null) {
                    int i = 0;
                    if (a.h() != null) {
                        i = a.h().getIsMem();
                    }
                    if (anVar.d() != null) {
                        if (a.g() != null && a.g().getIfpost() == 0) {
                            com.baidu.adp.lib.util.j.a((Context) this.a, a.g().getForbid_info());
                            return;
                        }
                        PostActivity postActivity = this.a;
                        String name = a.c().getName();
                        String h = a.d().h();
                        String d = anVar.d();
                        String d2 = anVar.d();
                        int e = anVar.e();
                        AntiData g = a.g();
                        amVar5 = this.a.l;
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ce(postActivity, 2, name, h, d, d2, e, g, 13001, false, amVar5.a().k(), null, false, false, null, null, null, i)));
                    } else if (a.g() == null || a.g().getIfpost() != 0) {
                        PostActivity postActivity2 = this.a;
                        String name2 = a.c().getName();
                        String h2 = a.d().h();
                        String d3 = anVar.d();
                        int e2 = anVar.e();
                        AntiData g2 = a.g();
                        amVar4 = this.a.l;
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ce(postActivity2, 1, name2, h2, d3, null, e2, g2, 13002, false, amVar4.a().k(), null, false, false, null, null, null, i)));
                    } else {
                        com.baidu.adp.lib.util.j.a((Context) this.a, a.g().getForbid_info());
                    }
                }
            }
        }
    }
}
