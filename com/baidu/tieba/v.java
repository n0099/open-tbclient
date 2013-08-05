package com.baidu.tieba;

import android.app.AlertDialog;
import android.view.View;
import com.baidu.tieba.data.bl;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class v implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LabelActivity f1780a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(LabelActivity labelActivity) {
        this.f1780a = labelActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.model.aq aqVar;
        aq aqVar2;
        com.baidu.tieba.model.aq aqVar3;
        AlertDialog alertDialog;
        aqVar = this.f1780a.q;
        aqVar.b((bl) view.getTag());
        aqVar2 = this.f1780a.J;
        aqVar2.notifyDataSetChanged();
        aqVar3 = this.f1780a.q;
        if (aqVar3.i().size() == 0) {
            this.f1780a.a(this.f1780a.getString(R.string.tag_is_null));
            alertDialog = this.f1780a.H;
            alertDialog.hide();
        }
        this.f1780a.c(false);
    }
}
