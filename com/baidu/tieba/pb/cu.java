package com.baidu.tieba.pb;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cu implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ cr f2217a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cu(cr crVar) {
        this.f2217a = crVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        bv bvVar;
        bv bvVar2;
        Dialog dialog2;
        dialog = this.f2217a.G;
        if (dialog != null) {
            dialog2 = this.f2217a.G;
            dialog2.dismiss();
        }
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            bvVar = this.f2217a.au;
            if (bvVar != null) {
                bvVar2 = this.f2217a.au;
                bvVar2.a(new Object[]{sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_forbid_user_name)});
            }
        }
    }
}
