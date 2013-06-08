package com.baidu.tieba;

import android.app.AlertDialog;
import android.view.View;
import com.baidu.tieba.a.bb;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class q implements View.OnClickListener {
    final /* synthetic */ LabelActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(LabelActivity labelActivity) {
        this.a = labelActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.c.af afVar;
        ah ahVar;
        com.baidu.tieba.c.af afVar2;
        AlertDialog alertDialog;
        afVar = this.a.q;
        afVar.b((bb) view.getTag());
        ahVar = this.a.J;
        ahVar.notifyDataSetChanged();
        afVar2 = this.a.q;
        if (afVar2.h().size() == 0) {
            this.a.a(this.a.getString(R.string.tag_is_null));
            alertDialog = this.a.H;
            alertDialog.hide();
        }
        this.a.c(false);
    }
}
