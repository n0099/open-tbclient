package com.baidu.tieba.person;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.BaseFragmentActivity;
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
        BaseFragmentActivity baseFragmentActivity;
        BaseFragmentActivity baseFragmentActivity2;
        BaseFragmentActivity baseFragmentActivity3;
        BaseFragmentActivity baseFragmentActivity4;
        if (view.getId() == com.baidu.tieba.v.textHomeListFrsName) {
            String obj = view.getTag().toString();
            baseFragmentActivity3 = this.a.b;
            baseFragmentActivity4 = this.a.b;
            baseFragmentActivity3.a(new CustomMessage(2005000, new com.baidu.tbadk.core.atomData.m(baseFragmentActivity4).a(obj, "")));
            return;
        }
        aa aaVar = (aa) view.getTag();
        if (aaVar != null) {
            baseFragmentActivity = this.a.b;
            baseFragmentActivity2 = this.a.b;
            baseFragmentActivity.a(new CustomMessage(2006001, new com.baidu.tbadk.core.atomData.as(baseFragmentActivity2).a(aaVar.l, (String) null, (String) null, 18003)));
        }
    }
}
