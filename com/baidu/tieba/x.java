package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
/* loaded from: classes.dex */
class x implements View.OnClickListener {
    final /* synthetic */ w avP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(w wVar) {
        this.avP = wVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        boolean z;
        boolean z2;
        ab abVar;
        boolean z3;
        TextView textView2;
        TiebaStatic.eventStat(this.avP.getContext(), "c10003", "click", 1, new Object[0]);
        textView = this.avP.avz;
        textView.setEnabled(false);
        z = this.avP.avo;
        TiebaStatic.eventStat(this.avP.getContext(), "upgrade_channel", z ? "withOtherApp" : "withoutOtherApp", 1, new Object[0]);
        this.avP.avq = true;
        z2 = this.avP.avp;
        if (z2) {
            Drawable drawable = ay.getDrawable(p.btn_dailog_choose_d);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            textView2 = this.avP.avx;
            textView2.setCompoundDrawables(drawable, null, null, null);
        }
        abVar = this.avP.avK;
        z3 = this.avP.avp;
        abVar.br(z3);
    }
}
