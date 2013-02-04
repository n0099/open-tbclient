package com.baidu.tieba.pb;

import android.view.View;
import com.baidu.tieba.person.PersonInfoActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cl implements View.OnClickListener {
    final /* synthetic */ SubPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cl(SubPbActivity subPbActivity) {
        this.a = subPbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.b.r rVar;
        com.baidu.tieba.b.r rVar2;
        rVar = this.a.f;
        String a = rVar.a().a().d().a();
        rVar2 = this.a.f;
        PersonInfoActivity.a(this.a, a, rVar2.a().a().d().b());
    }
}
