package com.baidu.tieba.mention;

import android.view.View;
import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.data.ao;
import com.baidu.tieba.data.as;
import com.baidu.tieba.model.bm;
import com.baidu.tieba.write.WriteActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PostActivity f1378a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(PostActivity postActivity) {
        this.f1378a = postActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bm bmVar;
        bm bmVar2;
        bm bmVar3;
        bm bmVar4;
        bmVar = this.f1378a.n;
        if (bmVar != null) {
            bmVar2 = this.f1378a.n;
            if (bmVar2.a() != null) {
                bmVar3 = this.f1378a.n;
                ao a2 = bmVar3.a();
                as asVar = a2.d().get(0);
                if (asVar != null) {
                    PostActivity postActivity = this.f1378a;
                    String a3 = a2.b().a();
                    String b = a2.b().b();
                    String a4 = a2.c().a();
                    String d = asVar.d();
                    int e = asVar.e();
                    AntiData f = a2.f();
                    bmVar4 = this.f1378a.n;
                    WriteActivity.a(postActivity, a3, b, a4, d, e, null, f, bmVar4.a().i());
                }
            }
        }
    }
}
