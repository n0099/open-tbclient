package com.baidu.tieba;

import android.app.AlertDialog;
import android.view.View;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class t implements View.OnClickListener {
    final /* synthetic */ LabelActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(LabelActivity labelActivity) {
        this.a = labelActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.model.ai aiVar;
        ao aoVar;
        com.baidu.tieba.model.ai aiVar2;
        AlertDialog alertDialog;
        aiVar = this.a.q;
        aiVar.b((com.baidu.tieba.data.az) view.getTag());
        aoVar = this.a.J;
        aoVar.notifyDataSetChanged();
        aiVar2 = this.a.q;
        if (aiVar2.h().size() == 0) {
            this.a.a(this.a.getString(R.string.tag_is_null));
            alertDialog = this.a.H;
            alertDialog.hide();
        }
        this.a.c(false);
    }
}
