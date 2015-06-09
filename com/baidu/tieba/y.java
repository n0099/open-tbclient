package com.baidu.tieba;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class y implements View.OnClickListener {
    final /* synthetic */ w avP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(w wVar) {
        this.avP = wVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        TextView textView;
        ab abVar;
        boolean z2;
        z = this.avP.avO;
        if (z) {
            TiebaStatic.eventStat(this.avP.getContext(), "c10001", "click", 1, new Object[0]);
        } else {
            TiebaStatic.eventStat(this.avP.getContext(), "c10009", "click", 1, new Object[0]);
        }
        textView = this.avP.avB;
        textView.setEnabled(false);
        abVar = this.avP.avK;
        z2 = this.avP.avp;
        abVar.bs(z2);
    }
}
