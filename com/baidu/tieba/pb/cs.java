package com.baidu.tieba.pb;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cs implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ cp f2124a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cs(cp cpVar) {
        this.f2124a = cpVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        bt btVar;
        bt btVar2;
        Dialog dialog2;
        dialog = this.f2124a.G;
        if (dialog != null) {
            dialog2 = this.f2124a.G;
            dialog2.dismiss();
        }
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            btVar = this.f2124a.au;
            if (btVar != null) {
                btVar2 = this.f2124a.au;
                btVar2.a((String) sparseArray.get(R.id.tag_forbid_user_name));
            }
        }
    }
}
