package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.t;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class v implements View.OnClickListener {
    final /* synthetic */ u aIy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar) {
        this.aIy = uVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        boolean z;
        u.a aVar;
        boolean z2;
        TextView textView2;
        com.baidu.tbadk.core.util.TiebaStatic.log("c10003");
        textView = this.aIy.aIi;
        textView.setEnabled(false);
        this.aIy.aHZ = true;
        z = this.aIy.aHY;
        if (z) {
            Drawable drawable = ar.getDrawable(t.f.btn_dailog_choose_d);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            textView2 = this.aIy.aIg;
            textView2.setCompoundDrawables(drawable, null, null, null);
        }
        aVar = this.aIy.aIt;
        z2 = this.aIy.aHY;
        aVar.bI(z2);
    }
}
