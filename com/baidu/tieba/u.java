package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.r;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class u implements View.OnClickListener {
    final /* synthetic */ t aNz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar) {
        this.aNz = tVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        boolean z;
        t.a aVar;
        boolean z2;
        TextView textView2;
        com.baidu.tbadk.core.util.TiebaStatic.log("c10003");
        textView = this.aNz.aNj;
        textView.setEnabled(false);
        this.aNz.aNa = true;
        z = this.aNz.aMZ;
        if (z) {
            Drawable drawable = av.getDrawable(r.f.btn_dailog_choose_d);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            textView2 = this.aNz.aNh;
            textView2.setCompoundDrawables(drawable, null, null, null);
        }
        aVar = this.aNz.aNu;
        z2 = this.aNz.aMZ;
        aVar.cb(z2);
    }
}
