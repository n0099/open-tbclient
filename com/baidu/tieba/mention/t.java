package com.baidu.tieba.mention;

import android.view.View;
import com.baidu.tieba.a.al;
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
        com.baidu.tieba.b.q qVar;
        com.baidu.tieba.b.q qVar2;
        com.baidu.tieba.b.q qVar3;
        qVar = this.a.n;
        if (qVar != null) {
            qVar2 = this.a.n;
            if (qVar2.a() != null) {
                qVar3 = this.a.n;
                al alVar = (al) qVar3.a().d().get(0);
                if (alVar != null) {
                    PersonInfoActivity.a(this.a, alVar.e().a(), alVar.e().b());
                }
            }
        }
    }
}
