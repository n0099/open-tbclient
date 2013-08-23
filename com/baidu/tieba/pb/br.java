package com.baidu.tieba.pb;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class br implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bo f1521a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public br(bo boVar) {
        this.f1521a = boVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        Dialog dialog2;
        dialog = this.f1521a.R;
        if (dialog != null) {
            dialog2 = this.f1521a.R;
            dialog2.dismiss();
        }
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            this.f1521a.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
        }
    }
}
