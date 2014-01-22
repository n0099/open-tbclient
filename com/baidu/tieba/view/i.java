package com.baidu.tieba.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ h a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.a = hVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        l lVar;
        String str;
        l lVar2;
        String str2;
        l lVar3;
        lVar = this.a.e;
        str = this.a.g;
        lVar.a(str);
        lVar2 = this.a.e;
        str2 = this.a.h;
        lVar2.b(str2);
        lVar3 = this.a.e;
        lVar3.show();
        this.a.cancel();
    }
}
