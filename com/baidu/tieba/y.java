package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class y implements View.OnClickListener {
    final /* synthetic */ u aHF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(u uVar) {
        this.aHF = uVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        boolean z2;
        TextView textView;
        TextView textView2;
        z = this.aHF.aHg;
        if (!z) {
            z2 = this.aHF.aHf;
            if (z2) {
                Drawable drawable = at.getDrawable(t.f.btn_dailog_choose_n);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                textView2 = this.aHF.aHn;
                textView2.setCompoundDrawables(drawable, null, null, null);
                this.aHF.aHe = false;
                this.aHF.aHf = false;
                return;
            }
            Drawable drawable2 = at.getDrawable(t.f.btn_dailog_choose_s);
            drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
            textView = this.aHF.aHn;
            textView.setCompoundDrawables(drawable2, null, null, null);
            this.aHF.aHe = true;
            this.aHF.aHf = true;
        }
    }
}
