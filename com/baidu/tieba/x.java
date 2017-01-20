package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class x implements View.OnClickListener {
    final /* synthetic */ t aNZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(t tVar) {
        this.aNZ = tVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        boolean z2;
        TextView textView;
        TextView textView2;
        z = this.aNZ.aNA;
        if (!z) {
            z2 = this.aNZ.aNz;
            if (z2) {
                Drawable drawable = ap.getDrawable(r.g.btn_dailog_choose_n);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                textView2 = this.aNZ.aNH;
                textView2.setCompoundDrawables(drawable, null, null, null);
                this.aNZ.aNy = false;
                this.aNZ.aNz = false;
                return;
            }
            Drawable drawable2 = ap.getDrawable(r.g.btn_dailog_choose_s);
            drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
            textView = this.aNZ.aNH;
            textView.setCompoundDrawables(drawable2, null, null, null);
            this.aNZ.aNy = true;
            this.aNZ.aNz = true;
        }
    }
}
