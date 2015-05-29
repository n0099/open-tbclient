package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
/* loaded from: classes.dex */
class x implements View.OnClickListener {
    final /* synthetic */ w avO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(w wVar) {
        this.avO = wVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        boolean z;
        boolean z2;
        ab abVar;
        boolean z3;
        TextView textView2;
        textView = this.avO.avz;
        textView.setEnabled(false);
        z = this.avO.avo;
        TiebaStatic.eventStat(this.avO.getContext(), "upgrade_channel", z ? "withOtherApp" : "withoutOtherApp", 1, new Object[0]);
        this.avO.avq = true;
        z2 = this.avO.avp;
        if (z2) {
            Drawable drawable = ay.getDrawable(p.btn_dailog_choose_d);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            textView2 = this.avO.avx;
            textView2.setCompoundDrawables(drawable, null, null, null);
        }
        abVar = this.avO.avK;
        z3 = this.avO.avp;
        abVar.br(z3);
    }
}
