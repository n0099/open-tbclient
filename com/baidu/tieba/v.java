package com.baidu.tieba;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class v implements View.OnClickListener {
    final /* synthetic */ t aPF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(t tVar) {
        this.aPF = tVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        TextView textView;
        t.a aVar;
        boolean z2;
        z = this.aPF.aPE;
        if (z) {
            com.baidu.tbadk.core.util.TiebaStatic.log("c10001");
        } else {
            com.baidu.tbadk.core.util.TiebaStatic.log("c10009");
        }
        textView = this.aPF.aPr;
        textView.setEnabled(false);
        aVar = this.aPF.aPA;
        z2 = this.aPF.aPf;
        aVar.ch(z2);
    }
}
