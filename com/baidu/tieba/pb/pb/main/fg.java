package com.baidu.tieba.pb.pb.main;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fg implements View.OnClickListener {
    private final /* synthetic */ boolean ebV;
    final /* synthetic */ ew eiu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fg(ew ewVar, boolean z) {
        this.eiu = ewVar;
        this.ebV = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        PbActivity pbActivity;
        Dialog dialog2;
        Dialog dialog3;
        PbActivity pbActivity2;
        dialog = this.eiu.egQ;
        if (dialog != null) {
            dialog2 = this.eiu.egQ;
            if (dialog2 instanceof Dialog) {
                dialog3 = this.eiu.egQ;
                pbActivity2 = this.eiu.eat;
                com.baidu.adp.lib.h.j.b(dialog3, pbActivity2.getPageContext());
            }
        }
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            pbActivity = this.eiu.eat;
            pbActivity.a(this.ebV, (String) sparseArray.get(u.g.tag_user_mute_mute_userid), sparseArray);
        }
    }
}
