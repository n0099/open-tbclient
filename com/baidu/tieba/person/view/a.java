package com.baidu.tieba.person.view;

import android.view.View;
import com.baidu.tieba.person.data.d;
import com.baidu.tieba.personInfo.b;
/* loaded from: classes.dex */
class a implements View.OnClickListener {
    final /* synthetic */ PersonInfoEnterItemView dCc;
    private final /* synthetic */ b dCd;
    private final /* synthetic */ d dCe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(PersonInfoEnterItemView personInfoEnterItemView, b bVar, d dVar) {
        this.dCc = personInfoEnterItemView;
        this.dCd = bVar;
        this.dCe = dVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dCd != null) {
            this.dCd.a(this.dCe);
        }
    }
}
