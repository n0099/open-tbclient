package com.baidu.tieba.mention;

import android.view.View;
import com.baidu.tieba.a.am;
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
        com.baidu.tieba.b.n nVar;
        com.baidu.tieba.b.n nVar2;
        com.baidu.tieba.b.n nVar3;
        nVar = this.a.k;
        if (nVar != null) {
            nVar2 = this.a.k;
            if (nVar2.a() == null) {
                return;
            }
            nVar3 = this.a.k;
            am amVar = (am) nVar3.a().c().get(0);
            if (amVar != null) {
                PersonInfoActivity.a(this.a, amVar.d().a(), amVar.d().b());
            }
        }
    }
}
