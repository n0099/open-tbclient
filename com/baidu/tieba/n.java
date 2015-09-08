package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class n implements View.OnClickListener {
    final /* synthetic */ j aEP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(j jVar) {
        this.aEP = jVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        boolean z2;
        TextView textView;
        TextView textView2;
        z = this.aEP.aEq;
        if (!z) {
            z2 = this.aEP.aEp;
            if (z2) {
                Drawable drawable = al.getDrawable(i.e.btn_dailog_choose_n);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                textView2 = this.aEP.aEx;
                textView2.setCompoundDrawables(drawable, null, null, null);
                this.aEP.aEo = false;
                this.aEP.aEp = false;
                return;
            }
            Drawable drawable2 = al.getDrawable(i.e.btn_dailog_choose_s);
            drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
            textView = this.aEP.aEx;
            textView.setCompoundDrawables(drawable2, null, null, null);
            this.aEP.aEo = true;
            this.aEP.aEp = true;
        }
    }
}
