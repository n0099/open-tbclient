package com.baidu.tieba;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class w implements View.OnClickListener {
    final /* synthetic */ u aHF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(u uVar) {
        this.aHF = uVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        TextView textView;
        u.a aVar;
        boolean z2;
        z = this.aHF.aHE;
        if (z) {
            com.baidu.tbadk.core.util.TiebaStatic.log("c10001");
        } else {
            com.baidu.tbadk.core.util.TiebaStatic.log("c10009");
        }
        textView = this.aHF.aHr;
        textView.setEnabled(false);
        aVar = this.aHF.aHA;
        z2 = this.aHF.aHf;
        aVar.bY(z2);
    }
}
