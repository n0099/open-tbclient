package com.baidu.tieba.mention;

import android.view.View;
import com.baidu.tieba.data.as;
import com.baidu.tieba.model.bu;
import com.baidu.tieba.person.PersonInfoActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PostActivity f1877a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(PostActivity postActivity) {
        this.f1877a = postActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bu buVar;
        bu buVar2;
        bu buVar3;
        buVar = this.f1877a.n;
        if (buVar != null) {
            buVar2 = this.f1877a.n;
            if (buVar2.a() != null) {
                buVar3 = this.f1877a.n;
                as asVar = buVar3.a().d().get(0);
                if (asVar != null) {
                    PersonInfoActivity.a(this.f1877a, asVar.g().getId(), asVar.g().getName());
                }
            }
        }
    }
}
