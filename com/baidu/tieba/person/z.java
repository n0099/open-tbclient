package com.baidu.tieba.person;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements View.OnClickListener {
    final /* synthetic */ y a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(y yVar) {
        this.a = yVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.e eVar;
        com.baidu.tbadk.core.e eVar2;
        com.baidu.tbadk.core.e eVar3;
        com.baidu.tbadk.core.e eVar4;
        if (view.getId() == com.baidu.tieba.r.textHomeListFrsName) {
            String obj = view.getTag().toString();
            eVar3 = this.a.b;
            eVar4 = this.a.b;
            eVar3.a(new CustomMessage(2005000, new com.baidu.tbadk.core.atomData.m(eVar4).a(obj, "")));
            return;
        }
        aa aaVar = (aa) view.getTag();
        if (aaVar != null) {
            eVar = this.a.b;
            eVar2 = this.a.b;
            eVar.a(new CustomMessage(2006001, new com.baidu.tbadk.core.atomData.as(eVar2).a(aaVar.l, null, null)));
        }
    }
}
