package com.baidu.tieba.person.view;

import android.view.View;
import com.baidu.tieba.person.data.e;
import com.baidu.tieba.personInfo.b;
/* loaded from: classes.dex */
class a implements View.OnClickListener {
    final /* synthetic */ PersonInfoEnterItemView eoo;
    private final /* synthetic */ b eop;
    private final /* synthetic */ e eoq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(PersonInfoEnterItemView personInfoEnterItemView, b bVar, e eVar) {
        this.eoo = personInfoEnterItemView;
        this.eop = bVar;
        this.eoq = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.eop != null) {
            this.eop.a(this.eoq);
        }
    }
}
