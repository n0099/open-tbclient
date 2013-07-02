package com.baidu.tieba.mention;

import android.view.View;
import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.data.aj;
import com.baidu.tieba.data.an;
import com.baidu.tieba.model.bg;
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
        bg bgVar;
        bg bgVar2;
        bg bgVar3;
        bg bgVar4;
        bgVar = this.a.n;
        if (bgVar != null) {
            bgVar2 = this.a.n;
            if (bgVar2.a() != null) {
                bgVar3 = this.a.n;
                aj a = bgVar3.a();
                an anVar = (an) a.d().get(0);
                if (anVar != null) {
                    PostActivity postActivity = this.a;
                    String a2 = a.a().a();
                    String b = a.a().b();
                    String a3 = a.b().a();
                    String d = anVar.d();
                    int f = anVar.f();
                    AntiData f2 = a.f();
                    bgVar4 = this.a.n;
                    WriteActivity.a(postActivity, a2, b, a3, d, f, null, f2, bgVar4.a().k());
                }
            }
        }
    }
}
