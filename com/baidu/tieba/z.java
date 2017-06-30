package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
class z implements View.OnClickListener {
    final /* synthetic */ y aTt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(y yVar) {
        this.aTt = yVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        boolean z;
        y.a aVar;
        boolean z2;
        TextView textView2;
        TiebaStatic.log("c10003");
        textView = this.aTt.aTd;
        textView.setEnabled(false);
        this.aTt.aSU = true;
        z = this.aTt.aST;
        if (z) {
            Drawable drawable = as.getDrawable(w.g.btn_dailog_choose_d);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            textView2 = this.aTt.aTb;
            textView2.setCompoundDrawables(drawable, null, null, null);
        }
        aVar = this.aTt.aTo;
        z2 = this.aTt.aST;
        aVar.cl(z2);
    }
}
