package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
class z implements View.OnClickListener {
    final /* synthetic */ y aTM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(y yVar) {
        this.aTM = yVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        boolean z;
        y.a aVar;
        boolean z2;
        TextView textView2;
        com.baidu.tbadk.core.util.TiebaStatic.log("c10003");
        textView = this.aTM.aTw;
        textView.setEnabled(false);
        this.aTM.aTn = true;
        z = this.aTM.aTm;
        if (z) {
            Drawable drawable = aq.getDrawable(w.g.btn_dailog_choose_d);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            textView2 = this.aTM.aTu;
            textView2.setCompoundDrawables(drawable, null, null, null);
        }
        aVar = this.aTM.aTH;
        z2 = this.aTM.aTm;
        aVar.ci(z2);
    }
}
