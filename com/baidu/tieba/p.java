package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.n;
import com.baidu.tieba.o;
/* loaded from: classes.dex */
class p implements View.OnClickListener {
    final /* synthetic */ o aFW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.aFW = oVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        boolean z;
        o.a aVar;
        boolean z2;
        TextView textView2;
        TiebaStatic.log("c10003");
        textView = this.aFW.aFG;
        textView.setEnabled(false);
        this.aFW.aFx = true;
        z = this.aFW.aFw;
        if (z) {
            Drawable drawable = as.getDrawable(n.e.btn_dailog_choose_d);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            textView2 = this.aFW.aFE;
            textView2.setCompoundDrawables(drawable, null, null, null);
        }
        aVar = this.aFW.aFR;
        z2 = this.aFW.aFw;
        aVar.bH(z2);
    }
}
