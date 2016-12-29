package com.baidu.tieba;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class v implements View.OnClickListener {
    final /* synthetic */ t aOW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(t tVar) {
        this.aOW = tVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        TextView textView;
        t.a aVar;
        boolean z2;
        z = this.aOW.aOV;
        if (z) {
            com.baidu.tbadk.core.util.TiebaStatic.log("c10001");
        } else {
            com.baidu.tbadk.core.util.TiebaStatic.log("c10009");
        }
        textView = this.aOW.aOI;
        textView.setEnabled(false);
        aVar = this.aOW.aOR;
        z2 = this.aOW.aOw;
        aVar.cg(z2);
    }
}
