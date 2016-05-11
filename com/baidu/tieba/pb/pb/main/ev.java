package com.baidu.tieba.pb.pb.main;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ev implements View.OnClickListener {
    private final /* synthetic */ boolean djG;
    final /* synthetic */ el dpu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ev(el elVar, boolean z) {
        this.dpu = elVar;
        this.djG = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        PbActivity pbActivity;
        Dialog dialog2;
        Dialog dialog3;
        PbActivity pbActivity2;
        dialog = this.dpu.dnR;
        if (dialog != null) {
            dialog2 = this.dpu.dnR;
            if (dialog2 instanceof Dialog) {
                dialog3 = this.dpu.dnR;
                pbActivity2 = this.dpu.dhY;
                com.baidu.adp.lib.h.j.b(dialog3, pbActivity2.getPageContext());
            }
        }
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            pbActivity = this.dpu.dhY;
            pbActivity.a(this.djG, (String) sparseArray.get(t.g.tag_user_mute_mute_userid), sparseArray);
        }
    }
}
