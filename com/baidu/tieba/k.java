package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.i;
import com.baidu.tieba.j;
/* loaded from: classes.dex */
class k implements View.OnClickListener {
    final /* synthetic */ j aCZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.aCZ = jVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        boolean z;
        j.a aVar;
        boolean z2;
        TextView textView2;
        TiebaStatic.log("c10003");
        textView = this.aCZ.aCJ;
        textView.setEnabled(false);
        this.aCZ.aCA = true;
        z = this.aCZ.aCz;
        if (z) {
            Drawable drawable = an.getDrawable(i.e.btn_dailog_choose_d);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            textView2 = this.aCZ.aCH;
            textView2.setCompoundDrawables(drawable, null, null, null);
        }
        aVar = this.aCZ.aCU;
        z2 = this.aCZ.aCz;
        aVar.by(z2);
    }
}
