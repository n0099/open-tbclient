package com.baidu.tieba;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class v implements View.OnClickListener {
    final /* synthetic */ t aNZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(t tVar) {
        this.aNZ = tVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        TextView textView;
        t.a aVar;
        boolean z2;
        z = this.aNZ.aNY;
        if (z) {
            com.baidu.tbadk.core.util.TiebaStatic.log("c10001");
        } else {
            com.baidu.tbadk.core.util.TiebaStatic.log("c10009");
        }
        textView = this.aNZ.aNL;
        textView.setEnabled(false);
        aVar = this.aNZ.aNU;
        z2 = this.aNZ.aNz;
        aVar.ck(z2);
    }
}
