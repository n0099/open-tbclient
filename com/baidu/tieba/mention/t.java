package com.baidu.tieba.mention;

import android.view.View;
import com.baidu.tieba.a.aq;
import com.baidu.tieba.c.bd;
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
        bd bdVar;
        bd bdVar2;
        bd bdVar3;
        bdVar = this.a.n;
        if (bdVar != null) {
            bdVar2 = this.a.n;
            if (bdVar2.a() != null) {
                bdVar3 = this.a.n;
                aq aqVar = (aq) bdVar3.a().d().get(0);
                if (aqVar != null) {
                    PersonInfoActivity.a(this.a, aqVar.h().a(), aqVar.h().c());
                }
            }
        }
    }
}
