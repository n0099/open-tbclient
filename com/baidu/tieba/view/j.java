package com.baidu.tieba.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {
    final /* synthetic */ i a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.a = iVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        m mVar;
        String str;
        m mVar2;
        String str2;
        m mVar3;
        mVar = this.a.e;
        str = this.a.g;
        mVar.a(str);
        mVar2 = this.a.e;
        str2 = this.a.h;
        mVar2.b(str2);
        mVar3 = this.a.e;
        mVar3.show();
        this.a.cancel();
    }
}
