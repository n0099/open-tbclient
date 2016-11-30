package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.r;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class u implements View.OnClickListener {
    final /* synthetic */ t aPF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar) {
        this.aPF = tVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        boolean z;
        t.a aVar;
        boolean z2;
        TextView textView2;
        com.baidu.tbadk.core.util.TiebaStatic.log("c10003");
        textView = this.aPF.aPp;
        textView.setEnabled(false);
        this.aPF.aPg = true;
        z = this.aPF.aPf;
        if (z) {
            Drawable drawable = at.getDrawable(r.f.btn_dailog_choose_d);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            textView2 = this.aPF.aPn;
            textView2.setCompoundDrawables(drawable, null, null, null);
        }
        aVar = this.aPF.aPA;
        z2 = this.aPF.aPf;
        aVar.cg(z2);
    }
}
