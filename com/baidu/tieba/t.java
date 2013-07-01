package com.baidu.tieba;

import android.app.AlertDialog;
import android.view.View;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class t implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LabelActivity f1442a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(LabelActivity labelActivity) {
        this.f1442a = labelActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.model.ai aiVar;
        ao aoVar;
        com.baidu.tieba.model.ai aiVar2;
        AlertDialog alertDialog;
        aiVar = this.f1442a.q;
        aiVar.b((com.baidu.tieba.data.az) view.getTag());
        aoVar = this.f1442a.J;
        aoVar.notifyDataSetChanged();
        aiVar2 = this.f1442a.q;
        if (aiVar2.h().size() == 0) {
            this.f1442a.a(this.f1442a.getString(R.string.tag_is_null));
            alertDialog = this.f1442a.H;
            alertDialog.hide();
        }
        this.f1442a.c(false);
    }
}
