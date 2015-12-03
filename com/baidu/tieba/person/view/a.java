package com.baidu.tieba.person.view;

import android.view.View;
import com.baidu.tieba.person.data.d;
/* loaded from: classes.dex */
class a implements View.OnClickListener {
    final /* synthetic */ PersonInfoEnterItemView cRB;
    private final /* synthetic */ com.baidu.tieba.personInfo.a cRC;
    private final /* synthetic */ d cRD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(PersonInfoEnterItemView personInfoEnterItemView, com.baidu.tieba.personInfo.a aVar, d dVar) {
        this.cRB = personInfoEnterItemView;
        this.cRC = aVar;
        this.cRD = dVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cRC != null) {
            this.cRC.a(this.cRD);
        }
    }
}
