package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class n implements View.OnClickListener {
    final /* synthetic */ j aDh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(j jVar) {
        this.aDh = jVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        boolean z2;
        TextView textView;
        TextView textView2;
        z = this.aDh.aCI;
        if (!z) {
            z2 = this.aDh.aCH;
            if (z2) {
                Drawable drawable = al.getDrawable(i.e.btn_dailog_choose_n);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                textView2 = this.aDh.aCP;
                textView2.setCompoundDrawables(drawable, null, null, null);
                this.aDh.aCG = false;
                this.aDh.aCH = false;
                return;
            }
            Drawable drawable2 = al.getDrawable(i.e.btn_dailog_choose_s);
            drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
            textView = this.aDh.aCP;
            textView.setCompoundDrawables(drawable2, null, null, null);
            this.aDh.aCG = true;
            this.aDh.aCH = true;
        }
    }
}
