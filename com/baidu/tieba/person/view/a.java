package com.baidu.tieba.person.view;

import android.view.View;
import com.baidu.tieba.person.data.d;
/* loaded from: classes.dex */
class a implements View.OnClickListener {
    final /* synthetic */ PersonInfoEnterItemView cWc;
    private final /* synthetic */ com.baidu.tieba.personInfo.a cWd;
    private final /* synthetic */ d cWe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(PersonInfoEnterItemView personInfoEnterItemView, com.baidu.tieba.personInfo.a aVar, d dVar) {
        this.cWc = personInfoEnterItemView;
        this.cWd = aVar;
        this.cWe = dVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cWd != null) {
            this.cWd.a(this.cWe);
        }
    }
}
