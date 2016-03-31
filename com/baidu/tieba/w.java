package com.baidu.tieba;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class w implements View.OnClickListener {
    final /* synthetic */ u aLu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(u uVar) {
        this.aLu = uVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        TextView textView;
        u.a aVar;
        boolean z2;
        z = this.aLu.aLt;
        if (z) {
            com.baidu.tbadk.core.util.TiebaStatic.log("c10001");
        } else {
            com.baidu.tbadk.core.util.TiebaStatic.log("c10009");
        }
        textView = this.aLu.aLg;
        textView.setEnabled(false);
        aVar = this.aLu.aLp;
        z2 = this.aLu.aKU;
        aVar.bS(z2);
    }
}
