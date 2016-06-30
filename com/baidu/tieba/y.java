package com.baidu.tieba;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class y implements View.OnClickListener {
    final /* synthetic */ w aIh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(w wVar) {
        this.aIh = wVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        TextView textView;
        w.a aVar;
        boolean z2;
        z = this.aIh.aIg;
        if (z) {
            com.baidu.tbadk.core.util.TiebaStatic.log("c10001");
        } else {
            com.baidu.tbadk.core.util.TiebaStatic.log("c10009");
        }
        textView = this.aIh.aHT;
        textView.setEnabled(false);
        aVar = this.aIh.aIc;
        z2 = this.aIh.aHH;
        aVar.bX(z2);
    }
}
