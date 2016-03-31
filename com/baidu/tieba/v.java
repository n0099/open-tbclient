package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.t;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class v implements View.OnClickListener {
    final /* synthetic */ u aLu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar) {
        this.aLu = uVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        boolean z;
        u.a aVar;
        boolean z2;
        TextView textView2;
        com.baidu.tbadk.core.util.TiebaStatic.log("c10003");
        textView = this.aLu.aLe;
        textView.setEnabled(false);
        this.aLu.aKV = true;
        z = this.aLu.aKU;
        if (z) {
            Drawable drawable = at.getDrawable(t.f.btn_dailog_choose_d);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            textView2 = this.aLu.aLc;
            textView2.setCompoundDrawables(drawable, null, null, null);
        }
        aVar = this.aLu.aLp;
        z2 = this.aLu.aKU;
        aVar.bR(z2);
    }
}
