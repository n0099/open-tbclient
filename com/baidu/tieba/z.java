package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class z implements View.OnClickListener {
    final /* synthetic */ v aMp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(v vVar) {
        this.aMp = vVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        boolean z2;
        TextView textView;
        TextView textView2;
        z = this.aMp.aLQ;
        if (!z) {
            z2 = this.aMp.aLP;
            if (z2) {
                Drawable drawable = av.getDrawable(t.f.btn_dailog_choose_n);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                textView2 = this.aMp.aLX;
                textView2.setCompoundDrawables(drawable, null, null, null);
                this.aMp.aLO = false;
                this.aMp.aLP = false;
                return;
            }
            Drawable drawable2 = av.getDrawable(t.f.btn_dailog_choose_s);
            drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
            textView = this.aMp.aLX;
            textView.setCompoundDrawables(drawable2, null, null, null);
            this.aMp.aLO = true;
            this.aMp.aLP = true;
        }
    }
}
