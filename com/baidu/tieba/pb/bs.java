package com.baidu.tieba.pb;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bs implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bo f1522a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bs(bo boVar) {
        this.f1522a = boVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        Dialog dialog2;
        dialog = this.f1522a.R;
        if (dialog != null) {
            dialog2 = this.f1522a.R;
            dialog2.dismiss();
        }
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            this.f1522a.a((String) sparseArray.get(R.id.tag_forbid_user_name), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue());
        }
    }
}
