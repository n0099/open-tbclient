package com.baidu.tieba.pb;

import android.view.View;
import com.baidu.tieba.person.PersonInfoActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cu implements View.OnClickListener {
    final /* synthetic */ SubPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cu(SubPbActivity subPbActivity) {
        this.a = subPbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.b.w wVar;
        com.baidu.tieba.b.w wVar2;
        wVar = this.a.g;
        String a = wVar.a().a().e().a();
        wVar2 = this.a.g;
        PersonInfoActivity.a(this.a, a, wVar2.a().a().e().b());
    }
}
