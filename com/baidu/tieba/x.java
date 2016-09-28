package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class x implements View.OnClickListener {
    final /* synthetic */ t aNz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(t tVar) {
        this.aNz = tVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        boolean z2;
        TextView textView;
        TextView textView2;
        z = this.aNz.aNa;
        if (!z) {
            z2 = this.aNz.aMZ;
            if (z2) {
                Drawable drawable = av.getDrawable(r.f.btn_dailog_choose_n);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                textView2 = this.aNz.aNh;
                textView2.setCompoundDrawables(drawable, null, null, null);
                this.aNz.aMY = false;
                this.aNz.aMZ = false;
                return;
            }
            Drawable drawable2 = av.getDrawable(r.f.btn_dailog_choose_s);
            drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
            textView = this.aNz.aNh;
            textView.setCompoundDrawables(drawable2, null, null, null);
            this.aNz.aMY = true;
            this.aNz.aMZ = true;
        }
    }
}
