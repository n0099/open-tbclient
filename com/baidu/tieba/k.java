package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.i;
import com.baidu.tieba.j;
/* loaded from: classes.dex */
class k implements View.OnClickListener {
    final /* synthetic */ j aDh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.aDh = jVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        boolean z;
        j.a aVar;
        boolean z2;
        TextView textView2;
        TiebaStatic.log("c10003");
        textView = this.aDh.aCR;
        textView.setEnabled(false);
        this.aDh.aCI = true;
        z = this.aDh.aCH;
        if (z) {
            Drawable drawable = al.getDrawable(i.e.btn_dailog_choose_d);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            textView2 = this.aDh.aCP;
            textView2.setCompoundDrawables(drawable, null, null, null);
        }
        aVar = this.aDh.aDc;
        z2 = this.aDh.aCH;
        aVar.bs(z2);
    }
}
