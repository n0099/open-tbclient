package com.baidu.tieba;

import android.view.View;
import android.widget.TextView;
/* loaded from: classes.dex */
class y implements View.OnClickListener {
    final /* synthetic */ w avO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(w wVar) {
        this.avO = wVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        ab abVar;
        boolean z;
        textView = this.avO.avB;
        textView.setEnabled(false);
        abVar = this.avO.avK;
        z = this.avO.avp;
        abVar.bs(z);
    }
}
