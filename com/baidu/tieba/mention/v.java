package com.baidu.tieba.mention;

import android.view.View;
import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.data.ao;
import com.baidu.tieba.data.as;
import com.baidu.tieba.model.bv;
import com.baidu.tieba.write.WriteActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PostActivity f1873a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(PostActivity postActivity) {
        this.f1873a = postActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bv bvVar;
        bv bvVar2;
        bv bvVar3;
        bv bvVar4;
        bvVar = this.f1873a.l;
        if (bvVar != null) {
            bvVar2 = this.f1873a.l;
            if (bvVar2.a() != null) {
                bvVar3 = this.f1873a.l;
                ao a2 = bvVar3.a();
                as asVar = a2.e().get(0);
                if (asVar != null) {
                    PostActivity postActivity = this.f1873a;
                    String id = a2.c().getId();
                    String name = a2.c().getName();
                    String a3 = a2.d().a();
                    String d = asVar.d();
                    int e = asVar.e();
                    AntiData g = a2.g();
                    bvVar4 = this.f1873a.l;
                    WriteActivity.a(postActivity, id, name, a3, d, e, null, g, bvVar4.a().k());
                }
            }
        }
    }
}
