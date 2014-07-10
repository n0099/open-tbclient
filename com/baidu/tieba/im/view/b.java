package com.baidu.tieba.im.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        e eVar;
        String str;
        e eVar2;
        String str2;
        e eVar3;
        eVar = this.a.e;
        str = this.a.g;
        eVar.a(str);
        eVar2 = this.a.e;
        str2 = this.a.h;
        eVar2.b(str2);
        eVar3 = this.a.e;
        eVar3.show();
        this.a.cancel();
    }
}
