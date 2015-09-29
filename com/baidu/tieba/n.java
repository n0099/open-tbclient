package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class n implements View.OnClickListener {
    final /* synthetic */ j aDU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(j jVar) {
        this.aDU = jVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        boolean z2;
        TextView textView;
        TextView textView2;
        z = this.aDU.aDv;
        if (!z) {
            z2 = this.aDU.aDu;
            if (z2) {
                Drawable drawable = am.getDrawable(i.e.btn_dailog_choose_n);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                textView2 = this.aDU.aDC;
                textView2.setCompoundDrawables(drawable, null, null, null);
                this.aDU.aDt = false;
                this.aDU.aDu = false;
                return;
            }
            Drawable drawable2 = am.getDrawable(i.e.btn_dailog_choose_s);
            drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
            textView = this.aDU.aDC;
            textView.setCompoundDrawables(drawable2, null, null, null);
            this.aDU.aDt = true;
            this.aDU.aDu = true;
        }
    }
}
