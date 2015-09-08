package com.baidu.tieba;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.j;
/* loaded from: classes.dex */
class l implements View.OnClickListener {
    final /* synthetic */ j aEP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar) {
        this.aEP = jVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        TextView textView;
        j.a aVar;
        boolean z2;
        z = this.aEP.aEO;
        if (z) {
            TiebaStatic.log("c10001");
        } else {
            TiebaStatic.log("c10009");
        }
        textView = this.aEP.aEB;
        textView.setEnabled(false);
        aVar = this.aEP.aEK;
        z2 = this.aEP.aEp;
        aVar.bA(z2);
    }
}
