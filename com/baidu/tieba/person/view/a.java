package com.baidu.tieba.person.view;

import android.view.View;
import com.baidu.tieba.person.data.d;
import com.baidu.tieba.personInfo.b;
/* loaded from: classes.dex */
class a implements View.OnClickListener {
    final /* synthetic */ PersonInfoEnterItemView dhB;
    private final /* synthetic */ b dhC;
    private final /* synthetic */ d dhD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(PersonInfoEnterItemView personInfoEnterItemView, b bVar, d dVar) {
        this.dhB = personInfoEnterItemView;
        this.dhC = bVar;
        this.dhD = dVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dhC != null) {
            this.dhC.a(this.dhD);
        }
    }
}
