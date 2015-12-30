package com.baidu.tieba;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.o;
/* loaded from: classes.dex */
class q implements View.OnClickListener {
    final /* synthetic */ o aHw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(o oVar) {
        this.aHw = oVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        TextView textView;
        o.a aVar;
        boolean z2;
        z = this.aHw.aHv;
        if (z) {
            TiebaStatic.log("c10001");
        } else {
            TiebaStatic.log("c10009");
        }
        textView = this.aHw.aHi;
        textView.setEnabled(false);
        aVar = this.aHw.aHr;
        z2 = this.aHw.aGW;
        aVar.bI(z2);
    }
}
