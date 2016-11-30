package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class x implements View.OnClickListener {
    final /* synthetic */ t aPF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(t tVar) {
        this.aPF = tVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        boolean z2;
        TextView textView;
        TextView textView2;
        z = this.aPF.aPg;
        if (!z) {
            z2 = this.aPF.aPf;
            if (z2) {
                Drawable drawable = at.getDrawable(r.f.btn_dailog_choose_n);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                textView2 = this.aPF.aPn;
                textView2.setCompoundDrawables(drawable, null, null, null);
                this.aPF.aPe = false;
                this.aPF.aPf = false;
                return;
            }
            Drawable drawable2 = at.getDrawable(r.f.btn_dailog_choose_s);
            drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
            textView = this.aPF.aPn;
            textView.setCompoundDrawables(drawable2, null, null, null);
            this.aPF.aPe = true;
            this.aPF.aPf = true;
        }
    }
}
