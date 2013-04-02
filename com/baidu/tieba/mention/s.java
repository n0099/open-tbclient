package com.baidu.tieba.mention;

import android.view.View;
import com.baidu.tieba.a.ak;
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
        com.baidu.tieba.b.r rVar;
        com.baidu.tieba.b.r rVar2;
        com.baidu.tieba.b.r rVar3;
        com.baidu.tieba.b.r rVar4;
        rVar = this.a.n;
        if (rVar != null) {
            rVar2 = this.a.n;
            if (rVar2.a() != null) {
                rVar3 = this.a.n;
                ak a = rVar3.a();
                an anVar = (an) a.d().get(0);
                if (anVar != null) {
                    PostActivity postActivity = this.a;
                    String b = a.a().b();
                    String c = a.a().c();
                    String a2 = a.b().a();
                    String a3 = anVar.a();
                    int c2 = anVar.c();
                    com.baidu.tieba.a.b f = a.f();
                    rVar4 = this.a.n;
                    WriteActivity.a(postActivity, b, c, a2, a3, c2, null, f, rVar4.a().k());
                }
            }
        }
    }
}
