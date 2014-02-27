package com.baidu.tieba.mention;

import android.view.View;
import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.data.am;
import com.baidu.tieba.data.aq;
import com.baidu.tieba.model.bn;
import com.baidu.tieba.write.WriteActivity;
/* loaded from: classes.dex */
final class x implements View.OnClickListener {
    final /* synthetic */ PostActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(PostActivity postActivity) {
        this.a = postActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        bn bnVar;
        bn bnVar2;
        bn bnVar3;
        bn bnVar4;
        bnVar = this.a.l;
        if (bnVar != null) {
            bnVar2 = this.a.l;
            if (bnVar2.a() != null) {
                bnVar3 = this.a.l;
                am a = bnVar3.a();
                aq aqVar = a.e().get(0);
                if (aqVar != null) {
                    PostActivity postActivity = this.a;
                    String id = a.c().getId();
                    String name = a.c().getName();
                    String a2 = a.d().a();
                    String d = aqVar.d();
                    int e = aqVar.e();
                    AntiData g = a.g();
                    bnVar4 = this.a.l;
                    WriteActivity.a(postActivity, id, name, a2, d, e, null, g, bnVar4.a().k());
                }
            }
        }
    }
}
