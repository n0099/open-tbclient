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
    final /* synthetic */ o aHw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.aHw = oVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        boolean z;
        o.a aVar;
        boolean z2;
        TextView textView2;
        TiebaStatic.log("c10003");
        textView = this.aHw.aHg;
        textView.setEnabled(false);
        this.aHw.aGX = true;
        z = this.aHw.aGW;
        if (z) {
            Drawable drawable = as.getDrawable(n.f.btn_dailog_choose_d);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            textView2 = this.aHw.aHe;
            textView2.setCompoundDrawables(drawable, null, null, null);
        }
        aVar = this.aHw.aHr;
        z2 = this.aHw.aGW;
        aVar.bH(z2);
    }
}
