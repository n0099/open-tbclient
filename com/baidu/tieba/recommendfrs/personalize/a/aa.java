package com.baidu.tieba.recommendfrs.personalize.a;

import android.view.View;
import com.baidu.tieba.recommendfrs.personalize.a.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements View.OnClickListener {
    final /* synthetic */ y.a dYK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(y.a aVar) {
        this.dYK = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.recommendfrs.data.k kVar;
        com.baidu.tieba.recommendfrs.data.k kVar2;
        kVar = this.dYK.dYF;
        if (kVar != null) {
            y.a aVar = this.dYK;
            kVar2 = this.dYK.dYF;
            aVar.a(kVar2.dWQ, view, 1);
        }
    }
}
