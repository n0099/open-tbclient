package com.baidu.tieba.mention;

import android.view.View;
import com.baidu.tieba.data.as;
import com.baidu.tieba.model.bk;
import com.baidu.tieba.person.PersonInfoActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PostActivity f1343a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(PostActivity postActivity) {
        this.f1343a = postActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bk bkVar;
        bk bkVar2;
        bk bkVar3;
        bkVar = this.f1343a.n;
        if (bkVar != null) {
            bkVar2 = this.f1343a.n;
            if (bkVar2.a() != null) {
                bkVar3 = this.f1343a.n;
                as asVar = (as) bkVar3.a().d().get(0);
                if (asVar != null) {
                    PersonInfoActivity.a(this.f1343a, asVar.g().getId(), asVar.g().getName());
                }
            }
        }
    }
}
