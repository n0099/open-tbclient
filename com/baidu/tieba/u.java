package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.r;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class u implements View.OnClickListener {
    final /* synthetic */ t aOW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar) {
        this.aOW = tVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        boolean z;
        t.a aVar;
        boolean z2;
        TextView textView2;
        com.baidu.tbadk.core.util.TiebaStatic.log("c10003");
        textView = this.aOW.aOG;
        textView.setEnabled(false);
        this.aOW.aOx = true;
        z = this.aOW.aOw;
        if (z) {
            Drawable drawable = ar.getDrawable(r.f.btn_dailog_choose_d);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            textView2 = this.aOW.aOE;
            textView2.setCompoundDrawables(drawable, null, null, null);
        }
        aVar = this.aOW.aOR;
        z2 = this.aOW.aOw;
        aVar.cf(z2);
    }
}
