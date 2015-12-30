package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class s implements View.OnClickListener {
    final /* synthetic */ o aHw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(o oVar) {
        this.aHw = oVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        boolean z2;
        TextView textView;
        TextView textView2;
        z = this.aHw.aGX;
        if (!z) {
            z2 = this.aHw.aGW;
            if (z2) {
                Drawable drawable = as.getDrawable(n.f.btn_dailog_choose_n);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                textView2 = this.aHw.aHe;
                textView2.setCompoundDrawables(drawable, null, null, null);
                this.aHw.aGV = false;
                this.aHw.aGW = false;
                return;
            }
            Drawable drawable2 = as.getDrawable(n.f.btn_dailog_choose_s);
            drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
            textView = this.aHw.aHe;
            textView.setCompoundDrawables(drawable2, null, null, null);
            this.aHw.aGV = true;
            this.aHw.aGW = true;
        }
    }
}
