package com.baidu.tieba;

import android.app.AlertDialog;
import android.view.View;
import com.baidu.tieba.a.ba;
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
        com.baidu.tieba.c.ac acVar;
        ah ahVar;
        com.baidu.tieba.c.ac acVar2;
        AlertDialog alertDialog;
        acVar = this.a.q;
        acVar.b((ba) view.getTag());
        ahVar = this.a.J;
        ahVar.notifyDataSetChanged();
        acVar2 = this.a.q;
        if (acVar2.h().size() == 0) {
            this.a.a(this.a.getString(R.string.tag_is_null));
            alertDialog = this.a.H;
            alertDialog.hide();
        }
        this.a.c(false);
    }
}
