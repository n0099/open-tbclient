package com.baidu.tieba.pb;

import android.view.View;
import com.baidu.tieba.person.PersonInfoActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cs implements View.OnClickListener {
    final /* synthetic */ SubPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cs(SubPbActivity subPbActivity) {
        this.a = subPbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.b.v vVar;
        com.baidu.tieba.b.v vVar2;
        vVar = this.a.g;
        String a = vVar.a().a().e().a();
        vVar2 = this.a.g;
        PersonInfoActivity.a(this.a, a, vVar2.a().a().e().b());
    }
}
