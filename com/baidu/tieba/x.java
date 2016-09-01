package com.baidu.tieba;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.v;
/* loaded from: classes.dex */
class x implements View.OnClickListener {
    final /* synthetic */ v aMp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(v vVar) {
        this.aMp = vVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        TextView textView;
        v.a aVar;
        boolean z2;
        z = this.aMp.aMo;
        if (z) {
            com.baidu.tbadk.core.util.TiebaStatic.log("c10001");
        } else {
            com.baidu.tbadk.core.util.TiebaStatic.log("c10009");
        }
        textView = this.aMp.aMb;
        textView.setEnabled(false);
        aVar = this.aMp.aMk;
        z2 = this.aMp.aLP;
        aVar.cc(z2);
    }
}
