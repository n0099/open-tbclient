package com.baidu.tieba.mention;

import android.view.View;
import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.data.ao;
import com.baidu.tieba.data.as;
import com.baidu.tieba.model.bu;
import com.baidu.tieba.write.WriteActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PostActivity f1876a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(PostActivity postActivity) {
        this.f1876a = postActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bu buVar;
        bu buVar2;
        bu buVar3;
        bu buVar4;
        buVar = this.f1876a.n;
        if (buVar != null) {
            buVar2 = this.f1876a.n;
            if (buVar2.a() != null) {
                buVar3 = this.f1876a.n;
                ao a2 = buVar3.a();
                as asVar = a2.d().get(0);
                if (asVar != null) {
                    PostActivity postActivity = this.f1876a;
                    String id = a2.b().getId();
                    String name = a2.b().getName();
                    String a3 = a2.c().a();
                    String d = asVar.d();
                    int e = asVar.e();
                    AntiData f = a2.f();
                    buVar4 = this.f1876a.n;
                    WriteActivity.a(postActivity, id, name, a3, d, e, null, f, buVar4.a().i());
                }
            }
        }
    }
}
