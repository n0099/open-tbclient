package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.i;
import com.baidu.tieba.j;
/* loaded from: classes.dex */
class k implements View.OnClickListener {
    final /* synthetic */ j aDU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.aDU = jVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        boolean z;
        j.a aVar;
        boolean z2;
        TextView textView2;
        TiebaStatic.log("c10003");
        textView = this.aDU.aDE;
        textView.setEnabled(false);
        this.aDU.aDv = true;
        z = this.aDU.aDu;
        if (z) {
            Drawable drawable = am.getDrawable(i.e.btn_dailog_choose_d);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            textView2 = this.aDU.aDC;
            textView2.setCompoundDrawables(drawable, null, null, null);
        }
        aVar = this.aDU.aDP;
        z2 = this.aDU.aDu;
        aVar.bw(z2);
    }
}
