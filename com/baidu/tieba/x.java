package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.u;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class x implements View.OnClickListener {
    final /* synthetic */ w aIh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(w wVar) {
        this.aIh = wVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        boolean z;
        w.a aVar;
        boolean z2;
        TextView textView2;
        com.baidu.tbadk.core.util.TiebaStatic.log("c10003");
        textView = this.aIh.aHR;
        textView.setEnabled(false);
        this.aIh.aHI = true;
        z = this.aIh.aHH;
        if (z) {
            Drawable drawable = av.getDrawable(u.f.btn_dailog_choose_d);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            textView2 = this.aIh.aHP;
            textView2.setCompoundDrawables(drawable, null, null, null);
        }
        aVar = this.aIh.aIc;
        z2 = this.aIh.aHH;
        aVar.bW(z2);
    }
}
