package com.baidu.tieba.mention;

import android.view.View;
import com.baidu.tieba.a.an;
import com.baidu.tieba.person.PersonInfoActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {
    final /* synthetic */ PostActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(PostActivity postActivity) {
        this.a = postActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.b.p pVar;
        com.baidu.tieba.b.p pVar2;
        com.baidu.tieba.b.p pVar3;
        pVar = this.a.n;
        if (pVar != null) {
            pVar2 = this.a.n;
            if (pVar2.a() != null) {
                pVar3 = this.a.n;
                an anVar = (an) pVar3.a().c().get(0);
                if (anVar != null) {
                    PersonInfoActivity.a(this.a, anVar.d().a(), anVar.d().b());
                }
            }
        }
    }
}
