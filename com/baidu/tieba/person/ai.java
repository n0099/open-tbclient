package com.baidu.tieba.person;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements View.OnClickListener {
    final /* synthetic */ ah a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ah ahVar) {
        this.a = ahVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BaseFragmentActivity baseFragmentActivity;
        BaseFragmentActivity baseFragmentActivity2;
        BaseFragmentActivity baseFragmentActivity3;
        BaseFragmentActivity baseFragmentActivity4;
        if (view.getId() == com.baidu.tieba.v.textHomeListFrsName) {
            String obj = view.getTag().toString();
            baseFragmentActivity3 = this.a.a;
            baseFragmentActivity4 = this.a.a;
            baseFragmentActivity3.a(new CustomMessage(2003000, new com.baidu.tbadk.core.atomData.r(baseFragmentActivity4).a(obj, "")));
            return;
        }
        aj ajVar = (aj) view.getTag();
        if (ajVar != null) {
            baseFragmentActivity = this.a.a;
            baseFragmentActivity2 = this.a.a;
            baseFragmentActivity.a(new CustomMessage(2004001, new com.baidu.tbadk.core.atomData.aw(baseFragmentActivity2).a(ajVar.l, (String) null, (String) null, 18003)));
        }
    }
}
