package com.baidu.tieba;

import android.app.AlertDialog;
import android.view.View;
import com.baidu.tieba.a.aw;
/* loaded from: classes.dex */
class p implements View.OnClickListener {
    final /* synthetic */ LabelActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(LabelActivity labelActivity) {
        this.a = labelActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.b.f fVar;
        ai aiVar;
        com.baidu.tieba.b.f fVar2;
        AlertDialog alertDialog;
        fVar = this.a.q;
        fVar.b((aw) view.getTag());
        aiVar = this.a.J;
        aiVar.notifyDataSetChanged();
        fVar2 = this.a.q;
        if (fVar2.h().size() == 0) {
            this.a.b(this.a.getString(R.string.tag_is_null));
            alertDialog = this.a.H;
            alertDialog.hide();
        }
        this.a.c(false);
    }
}
