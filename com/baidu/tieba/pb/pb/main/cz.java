package com.baidu.tieba.pb.pb.main;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import com.baidu.tieba.i;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cz implements View.OnClickListener {
    final /* synthetic */ ct cmY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cz(ct ctVar) {
        this.cmY = ctVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        PbActivity.a aVar;
        PbActivity.a aVar2;
        Dialog dialog2;
        Dialog dialog3;
        PbActivity pbActivity;
        dialog = this.cmY.cme;
        if (dialog != null) {
            dialog2 = this.cmY.cme;
            if (dialog2 instanceof Dialog) {
                dialog3 = this.cmY.cme;
                pbActivity = this.cmY.cjZ;
                com.baidu.adp.lib.g.j.b(dialog3, pbActivity.getPageContext());
            }
        }
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray == null) {
            return;
        }
        aVar = this.cmY.cmV;
        if (aVar == null) {
            return;
        }
        aVar2 = this.cmY.cmV;
        aVar2.d(new Object[]{sparseArray.get(i.f.tag_manage_user_identity), sparseArray.get(i.f.tag_forbid_user_name), sparseArray.get(i.f.tag_forbid_user_post_id)});
    }
}
