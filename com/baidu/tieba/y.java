package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class y implements View.OnClickListener {
    final /* synthetic */ u aIy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(u uVar) {
        this.aIy = uVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        boolean z2;
        TextView textView;
        TextView textView2;
        z = this.aIy.aHZ;
        if (!z) {
            z2 = this.aIy.aHY;
            if (z2) {
                Drawable drawable = ar.getDrawable(t.f.btn_dailog_choose_n);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                textView2 = this.aIy.aIg;
                textView2.setCompoundDrawables(drawable, null, null, null);
                this.aIy.aHX = false;
                this.aIy.aHY = false;
                return;
            }
            Drawable drawable2 = ar.getDrawable(t.f.btn_dailog_choose_s);
            drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
            textView = this.aIy.aIg;
            textView.setCompoundDrawables(drawable2, null, null, null);
            this.aIy.aHX = true;
            this.aIy.aHY = true;
        }
    }
}
