package com.baidu.tieba.mention;

import android.view.View;
import com.baidu.tieba.a.al;
import com.baidu.tieba.a.an;
import com.baidu.tieba.write.WriteActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    final /* synthetic */ PostActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(PostActivity postActivity) {
        this.a = postActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.b.p pVar;
        com.baidu.tieba.b.p pVar2;
        com.baidu.tieba.b.p pVar3;
        com.baidu.tieba.b.p pVar4;
        pVar = this.a.n;
        if (pVar != null) {
            pVar2 = this.a.n;
            if (pVar2.a() != null) {
                pVar3 = this.a.n;
                al a = pVar3.a();
                an anVar = (an) a.c().get(0);
                if (anVar != null) {
                    PostActivity postActivity = this.a;
                    String b = a.a().b();
                    String c = a.a().c();
                    String a2 = a.b().a();
                    String a3 = anVar.a();
                    int b2 = anVar.b();
                    com.baidu.tieba.a.b e = a.e();
                    pVar4 = this.a.n;
                    WriteActivity.a(postActivity, b, c, a2, a3, b2, null, e, pVar4.a().f());
                }
            }
        }
    }
}
