package com.baidu.tieba.mention;

import android.view.View;
import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.data.an;
import com.baidu.tieba.data.ar;
import com.baidu.tieba.model.bv;
import com.baidu.tieba.write.WriteActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements View.OnClickListener {
    final /* synthetic */ PostActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(PostActivity postActivity) {
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
                an a = bvVar3.a();
                ar arVar = a.e().get(0);
                if (arVar != null) {
                    PostActivity postActivity = this.a;
                    String id = a.c().getId();
                    String name = a.c().getName();
                    String a2 = a.d().a();
                    String d = arVar.d();
                    int e = arVar.e();
                    AntiData g = a.g();
                    bvVar4 = this.a.l;
                    WriteActivity.a(postActivity, id, name, a2, d, e, null, g, bvVar4.a().k());
                }
            }
        }
    }
}
