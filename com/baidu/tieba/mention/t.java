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
        com.baidu.tieba.b.r rVar;
        com.baidu.tieba.b.r rVar2;
        com.baidu.tieba.b.r rVar3;
        rVar = this.a.n;
        if (rVar != null) {
            rVar2 = this.a.n;
            if (rVar2.a() != null) {
                rVar3 = this.a.n;
                an anVar = (an) rVar3.a().d().get(0);
                if (anVar != null) {
                    PersonInfoActivity.a(this.a, anVar.e().a(), anVar.e().b());
                }
            }
        }
    }
}
