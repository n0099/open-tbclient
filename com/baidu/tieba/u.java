package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.r;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class u implements View.OnClickListener {
    final /* synthetic */ t aNZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar) {
        this.aNZ = tVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        boolean z;
        t.a aVar;
        boolean z2;
        TextView textView2;
        com.baidu.tbadk.core.util.TiebaStatic.log("c10003");
        textView = this.aNZ.aNJ;
        textView.setEnabled(false);
        this.aNZ.aNA = true;
        z = this.aNZ.aNz;
        if (z) {
            Drawable drawable = ap.getDrawable(r.g.btn_dailog_choose_d);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            textView2 = this.aNZ.aNH;
            textView2.setCompoundDrawables(drawable, null, null, null);
        }
        aVar = this.aNZ.aNU;
        z2 = this.aNZ.aNz;
        aVar.cj(z2);
    }
}
