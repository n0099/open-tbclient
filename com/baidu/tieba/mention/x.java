package com.baidu.tieba.mention;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.bh;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tieba.data.ai;
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
                com.baidu.tieba.data.af a = amVar3.a();
                ai aiVar = a.e().get(0);
                if (aiVar != null) {
                    if (aiVar.l() != null) {
                        if (a.g() != null && a.g().getIfpost() == 0) {
                            com.baidu.adp.lib.util.k.a((Context) this.a, a.g().getForbid_info());
                            return;
                        }
                        PostActivity postActivity = this.a;
                        String name = a.c().getName();
                        String p = a.d().p();
                        String l = aiVar.l();
                        String l2 = aiVar.l();
                        int m = aiVar.m();
                        AntiData g = a.g();
                        amVar5 = this.a.l;
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003001, new bh(postActivity, 2, name, p, l, l2, m, g, 13001, false, amVar5.a().k(), null, false, false, null, null, null)));
                    } else if (a.g() == null || a.g().getIfpost() != 0) {
                        PostActivity postActivity2 = this.a;
                        String name2 = a.c().getName();
                        String p2 = a.d().p();
                        String l3 = aiVar.l();
                        int m2 = aiVar.m();
                        AntiData g2 = a.g();
                        amVar4 = this.a.l;
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003001, new bh(postActivity2, 1, name2, p2, l3, null, m2, g2, 13002, false, amVar4.a().k(), null, false, false, null, null, null)));
                    } else {
                        com.baidu.adp.lib.util.k.a((Context) this.a, a.g().getForbid_info());
                    }
                }
            }
        }
    }
}
