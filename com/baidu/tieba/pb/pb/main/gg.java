package com.baidu.tieba.pb.pb.main;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class gg implements View.OnClickListener {
    private final /* synthetic */ boolean enf;
    final /* synthetic */ fx evi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gg(fx fxVar, boolean z) {
        this.evi = fxVar;
        this.enf = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        PbActivity pbActivity;
        Dialog dialog2;
        Dialog dialog3;
        PbActivity pbActivity2;
        dialog = this.evi.etD;
        if (dialog != null) {
            dialog2 = this.evi.etD;
            if (dialog2 instanceof Dialog) {
                dialog3 = this.evi.etD;
                pbActivity2 = this.evi.elf;
                com.baidu.adp.lib.g.j.b(dialog3, pbActivity2.getPageContext());
            }
        }
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            pbActivity = this.evi.elf;
            pbActivity.a(this.enf, (String) sparseArray.get(w.h.tag_user_mute_mute_userid), sparseArray);
        }
    }
}
