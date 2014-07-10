package com.baidu.tieba.mention;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.bv;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tieba.data.ai;
import com.baidu.tieba.data.am;
import com.baidu.tieba.model.al;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements View.OnClickListener {
    final /* synthetic */ PostActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(PostActivity postActivity) {
        this.a = postActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        al alVar;
        al alVar2;
        al alVar3;
        al alVar4;
        al alVar5;
        alVar = this.a.l;
        if (alVar != null) {
            alVar2 = this.a.l;
            if (alVar2.a() != null) {
                alVar3 = this.a.l;
                ai a = alVar3.a();
                am amVar = a.d().get(0);
                if (amVar != null) {
                    int i = 0;
                    if (a.g() != null) {
                        i = a.g().getIsMem();
                    }
                    if (amVar.l() != null) {
                        if (a.f() != null && a.f().getIfpost() == 0) {
                            com.baidu.adp.lib.util.j.a((Context) this.a, a.f().getForbid_info());
                            return;
                        }
                        PostActivity postActivity = this.a;
                        String name = a.b().getName();
                        String p = a.c().p();
                        String l = amVar.l();
                        String l2 = amVar.l();
                        int m = amVar.m();
                        AntiData f = a.f();
                        alVar5 = this.a.l;
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new bv(postActivity, 2, name, p, l, l2, m, f, 13001, false, alVar5.a().j(), null, false, false, null, null, null, i)));
                    } else if (a.f() == null || a.f().getIfpost() != 0) {
                        PostActivity postActivity2 = this.a;
                        String name2 = a.b().getName();
                        String p2 = a.c().p();
                        String l3 = amVar.l();
                        int m2 = amVar.m();
                        AntiData f2 = a.f();
                        alVar4 = this.a.l;
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new bv(postActivity2, 1, name2, p2, l3, null, m2, f2, 13002, false, alVar4.a().j(), null, false, false, null, null, null, i)));
                    } else {
                        com.baidu.adp.lib.util.j.a((Context) this.a, a.f().getForbid_info());
                    }
                }
            }
        }
    }
}
