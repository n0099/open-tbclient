package com.baidu.tieba;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.j;
/* loaded from: classes.dex */
class l implements View.OnClickListener {
    final /* synthetic */ j aDU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar) {
        this.aDU = jVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        TextView textView;
        j.a aVar;
        boolean z2;
        z = this.aDU.aDT;
        if (z) {
            TiebaStatic.log("c10001");
        } else {
            TiebaStatic.log("c10009");
        }
        textView = this.aDU.aDG;
        textView.setEnabled(false);
        aVar = this.aDU.aDP;
        z2 = this.aDU.aDu;
        aVar.bx(z2);
    }
}
