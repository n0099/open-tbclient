package com.baidu.tieba.person;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class z implements View.OnClickListener {
    final /* synthetic */ y a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(y yVar) {
        this.a = yVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        com.baidu.tbadk.core.e eVar;
        com.baidu.tbadk.core.e eVar2;
        com.baidu.tbadk.core.e eVar3;
        com.baidu.tbadk.core.e eVar4;
        if (view.getId() == com.baidu.tieba.a.h.textHomeListFrsName) {
            String obj = view.getTag().toString();
            eVar3 = this.a.a;
            eVar4 = this.a.a;
            eVar3.a(new com.baidu.adp.framework.message.a(2003000, new com.baidu.tbadk.core.b.l(eVar4).a(obj, "")));
            return;
        }
        aa aaVar = (aa) view.getTag();
        if (aaVar != null) {
            eVar = this.a.a;
            eVar2 = this.a.a;
            eVar.a(new com.baidu.adp.framework.message.a(2004001, new com.baidu.tbadk.core.b.af(eVar2).a(aaVar.l, null, null)));
        }
    }
}
