package com.baidu.tieba;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class v implements View.OnClickListener {
    final /* synthetic */ t aNz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(t tVar) {
        this.aNz = tVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        TextView textView;
        t.a aVar;
        boolean z2;
        z = this.aNz.aNy;
        if (z) {
            com.baidu.tbadk.core.util.TiebaStatic.log("c10001");
        } else {
            com.baidu.tbadk.core.util.TiebaStatic.log("c10009");
        }
        textView = this.aNz.aNl;
        textView.setEnabled(false);
        aVar = this.aNz.aNu;
        z2 = this.aNz.aMZ;
        aVar.cc(z2);
    }
}
