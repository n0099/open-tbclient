package com.baidu.tieba.mention;

import android.view.View;
import com.baidu.tieba.a.ai;
import com.baidu.tieba.a.al;
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
        com.baidu.tieba.b.q qVar;
        com.baidu.tieba.b.q qVar2;
        com.baidu.tieba.b.q qVar3;
        com.baidu.tieba.b.q qVar4;
        qVar = this.a.n;
        if (qVar != null) {
            qVar2 = this.a.n;
            if (qVar2.a() != null) {
                qVar3 = this.a.n;
                ai a = qVar3.a();
                al alVar = (al) a.d().get(0);
                if (alVar != null) {
                    PostActivity postActivity = this.a;
                    String b = a.a().b();
                    String c = a.a().c();
                    String a2 = a.b().a();
                    String a3 = alVar.a();
                    int c2 = alVar.c();
                    com.baidu.tieba.a.b f = a.f();
                    qVar4 = this.a.n;
                    WriteActivity.a(postActivity, b, c, a2, a3, c2, null, f, qVar4.a().i());
                }
            }
        }
    }
}
