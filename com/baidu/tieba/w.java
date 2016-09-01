package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.t;
import com.baidu.tieba.v;
/* loaded from: classes.dex */
class w implements View.OnClickListener {
    final /* synthetic */ v aMp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v vVar) {
        this.aMp = vVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        boolean z;
        v.a aVar;
        boolean z2;
        TextView textView2;
        com.baidu.tbadk.core.util.TiebaStatic.log("c10003");
        textView = this.aMp.aLZ;
        textView.setEnabled(false);
        this.aMp.aLQ = true;
        z = this.aMp.aLP;
        if (z) {
            Drawable drawable = av.getDrawable(t.f.btn_dailog_choose_d);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            textView2 = this.aMp.aLX;
            textView2.setCompoundDrawables(drawable, null, null, null);
        }
        aVar = this.aMp.aMk;
        z2 = this.aMp.aLP;
        aVar.cb(z2);
    }
}
