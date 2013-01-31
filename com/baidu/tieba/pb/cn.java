package com.baidu.tieba.pb;

import android.view.View;
import com.baidu.tieba.person.PersonInfoActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cn implements View.OnClickListener {
    final /* synthetic */ SubPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cn(SubPbActivity subPbActivity) {
        this.a = subPbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.b.t tVar;
        com.baidu.tieba.b.t tVar2;
        tVar = this.a.g;
        String a = tVar.a().a().d().a();
        tVar2 = this.a.g;
        PersonInfoActivity.a(this.a, a, tVar2.a().a().d().b());
    }
}
