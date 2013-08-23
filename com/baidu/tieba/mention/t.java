package com.baidu.tieba.mention;

import android.view.View;
import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.data.ao;
import com.baidu.tieba.data.as;
import com.baidu.tieba.model.bk;
import com.baidu.tieba.write.WriteActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PostActivity f1342a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(PostActivity postActivity) {
        this.f1342a = postActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bk bkVar;
        bk bkVar2;
        bk bkVar3;
        bk bkVar4;
        bkVar = this.f1342a.n;
        if (bkVar != null) {
            bkVar2 = this.f1342a.n;
            if (bkVar2.a() != null) {
                bkVar3 = this.f1342a.n;
                ao a2 = bkVar3.a();
                as asVar = (as) a2.d().get(0);
                if (asVar != null) {
                    PostActivity postActivity = this.f1342a;
                    String a3 = a2.b().a();
                    String b = a2.b().b();
                    String a4 = a2.c().a();
                    String d = asVar.d();
                    int e = asVar.e();
                    AntiData f = a2.f();
                    bkVar4 = this.f1342a.n;
                    WriteActivity.a(postActivity, a3, b, a4, d, e, null, f, bkVar4.a().i());
                }
            }
        }
    }
}
