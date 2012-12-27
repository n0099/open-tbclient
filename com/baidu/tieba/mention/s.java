package com.baidu.tieba.mention;

import android.view.View;
import com.baidu.tieba.a.ak;
import com.baidu.tieba.a.am;
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
        com.baidu.tieba.b.n nVar;
        com.baidu.tieba.b.n nVar2;
        com.baidu.tieba.b.n nVar3;
        com.baidu.tieba.b.n nVar4;
        nVar = this.a.k;
        if (nVar != null) {
            nVar2 = this.a.k;
            if (nVar2.a() == null) {
                return;
            }
            nVar3 = this.a.k;
            ak a = nVar3.a();
            am amVar = (am) a.c().get(0);
            if (amVar != null) {
                PostActivity postActivity = this.a;
                String b = a.a().b();
                String c = a.a().c();
                String a2 = a.b().a();
                String a3 = amVar.a();
                int b2 = amVar.b();
                com.baidu.tieba.a.b e = a.e();
                nVar4 = this.a.k;
                WriteActivity.a(postActivity, b, c, a2, a3, b2, null, e, nVar4.a().f());
            }
        }
    }
}
