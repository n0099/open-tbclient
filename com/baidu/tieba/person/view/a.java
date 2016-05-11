package com.baidu.tieba.person.view;

import android.view.View;
import com.baidu.tieba.person.data.e;
import com.baidu.tieba.personInfo.b;
/* loaded from: classes.dex */
class a implements View.OnClickListener {
    final /* synthetic */ PersonInfoEnterItemView dFk;
    private final /* synthetic */ b dFl;
    private final /* synthetic */ e dFm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(PersonInfoEnterItemView personInfoEnterItemView, b bVar, e eVar) {
        this.dFk = personInfoEnterItemView;
        this.dFl = bVar;
        this.dFm = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dFl != null) {
            this.dFl.a(this.dFm);
        }
    }
}
