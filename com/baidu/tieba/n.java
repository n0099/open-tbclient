package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class n implements View.OnClickListener {
    final /* synthetic */ j aEf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(j jVar) {
        this.aEf = jVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        boolean z2;
        TextView textView;
        TextView textView2;
        z = this.aEf.aDG;
        if (!z) {
            z2 = this.aEf.aDF;
            if (z2) {
                Drawable drawable = an.getDrawable(i.e.btn_dailog_choose_n);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                textView2 = this.aEf.aDN;
                textView2.setCompoundDrawables(drawable, null, null, null);
                this.aEf.aDE = false;
                this.aEf.aDF = false;
                return;
            }
            Drawable drawable2 = an.getDrawable(i.e.btn_dailog_choose_s);
            drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
            textView = this.aEf.aDN;
            textView.setCompoundDrawables(drawable2, null, null, null);
            this.aEf.aDE = true;
            this.aEf.aDF = true;
        }
    }
}
