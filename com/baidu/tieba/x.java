package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class x implements View.OnClickListener {
    final /* synthetic */ t aOW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(t tVar) {
        this.aOW = tVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        boolean z2;
        TextView textView;
        TextView textView2;
        z = this.aOW.aOx;
        if (!z) {
            z2 = this.aOW.aOw;
            if (z2) {
                Drawable drawable = ar.getDrawable(r.f.btn_dailog_choose_n);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                textView2 = this.aOW.aOE;
                textView2.setCompoundDrawables(drawable, null, null, null);
                this.aOW.aOv = false;
                this.aOW.aOw = false;
                return;
            }
            Drawable drawable2 = ar.getDrawable(r.f.btn_dailog_choose_s);
            drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
            textView = this.aOW.aOE;
            textView.setCompoundDrawables(drawable2, null, null, null);
            this.aOW.aOv = true;
            this.aOW.aOw = true;
        }
    }
}
