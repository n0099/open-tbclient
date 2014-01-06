package com.baidu.tieba.mention;

import android.view.View;
import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.data.ao;
import com.baidu.tieba.data.as;
import com.baidu.tieba.model.bv;
import com.baidu.tieba.write.WriteActivity;
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
        bv bvVar;
        bv bvVar2;
        bv bvVar3;
        bv bvVar4;
        bvVar = this.a.l;
        if (bvVar != null) {
            bvVar2 = this.a.l;
            if (bvVar2.a() != null) {
                bvVar3 = this.a.l;
                ao a = bvVar3.a();
                as asVar = a.e().get(0);
                if (asVar != null) {
                    PostActivity postActivity = this.a;
                    String id = a.c().getId();
                    String name = a.c().getName();
                    String a2 = a.d().a();
                    String d = asVar.d();
                    int e = asVar.e();
                    AntiData g = a.g();
                    bvVar4 = this.a.l;
                    WriteActivity.a(postActivity, id, name, a2, d, e, null, g, bvVar4.a().k());
                }
            }
        }
    }
}
