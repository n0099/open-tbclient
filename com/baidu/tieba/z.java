package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
class z implements View.OnClickListener {
    final /* synthetic */ y aUy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(y yVar) {
        this.aUy = yVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        boolean z;
        y.a aVar;
        boolean z2;
        TextView textView2;
        TiebaStatic.log("c10003");
        textView = this.aUy.aUi;
        textView.setEnabled(false);
        this.aUy.aTZ = true;
        z = this.aUy.aTY;
        if (z) {
            Drawable drawable = aq.getDrawable(w.g.btn_dailog_choose_d);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            textView2 = this.aUy.aUg;
            textView2.setCompoundDrawables(drawable, null, null, null);
        }
        aVar = this.aUy.aUt;
        z2 = this.aUy.aTY;
        aVar.cm(z2);
    }
}
