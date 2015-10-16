package com.baidu.tieba;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.j;
/* loaded from: classes.dex */
class l implements View.OnClickListener {
    final /* synthetic */ j aEf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar) {
        this.aEf = jVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        TextView textView;
        j.a aVar;
        boolean z2;
        z = this.aEf.aEe;
        if (z) {
            TiebaStatic.log("c10001");
        } else {
            TiebaStatic.log("c10009");
        }
        textView = this.aEf.aDR;
        textView.setEnabled(false);
        aVar = this.aEf.aEa;
        z2 = this.aEf.aDF;
        aVar.bx(z2);
    }
}
