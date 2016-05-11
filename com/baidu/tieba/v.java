package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.t;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class v implements View.OnClickListener {
    final /* synthetic */ u aHF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar) {
        this.aHF = uVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        boolean z;
        u.a aVar;
        boolean z2;
        TextView textView2;
        com.baidu.tbadk.core.util.TiebaStatic.log("c10003");
        textView = this.aHF.aHp;
        textView.setEnabled(false);
        this.aHF.aHg = true;
        z = this.aHF.aHf;
        if (z) {
            Drawable drawable = at.getDrawable(t.f.btn_dailog_choose_d);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            textView2 = this.aHF.aHn;
            textView2.setCompoundDrawables(drawable, null, null, null);
        }
        aVar = this.aHF.aHA;
        z2 = this.aHF.aHf;
        aVar.bX(z2);
    }
}
