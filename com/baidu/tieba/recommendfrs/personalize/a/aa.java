package com.baidu.tieba.recommendfrs.personalize.a;

import android.view.View;
import com.baidu.tieba.recommendfrs.personalize.a.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements View.OnClickListener {
    final /* synthetic */ y.a ebR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(y.a aVar) {
        this.ebR = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.recommendfrs.data.k kVar;
        com.baidu.tieba.recommendfrs.data.k kVar2;
        kVar = this.ebR.ebM;
        if (kVar != null) {
            y.a aVar = this.ebR;
            kVar2 = this.ebR.ebM;
            aVar.a(kVar2.eaa, view, 1);
        }
    }
}
