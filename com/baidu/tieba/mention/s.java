package com.baidu.tieba.mention;

import android.view.View;
import com.baidu.tieba.a.al;
import com.baidu.tieba.a.aq;
import com.baidu.tieba.c.bd;
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
        bd bdVar;
        bd bdVar2;
        bd bdVar3;
        bd bdVar4;
        bdVar = this.a.n;
        if (bdVar != null) {
            bdVar2 = this.a.n;
            if (bdVar2.a() != null) {
                bdVar3 = this.a.n;
                al a = bdVar3.a();
                aq aqVar = (aq) a.d().get(0);
                if (aqVar != null) {
                    PostActivity postActivity = this.a;
                    String a2 = a.a().a();
                    String b = a.a().b();
                    String a3 = a.b().a();
                    String d = aqVar.d();
                    int f = aqVar.f();
                    com.baidu.tieba.a.b f2 = a.f();
                    bdVar4 = this.a.n;
                    WriteActivity.a(postActivity, a2, b, a3, d, f, null, f2, bdVar4.a().k());
                }
            }
        }
    }
}
