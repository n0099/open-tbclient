package com.baidu.tieba.pb.pb.sub;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az implements View.OnClickListener {
    private final /* synthetic */ boolean emm;
    final /* synthetic */ ao evV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(ao aoVar, boolean z) {
        this.evV = aoVar;
        this.emm = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        NewSubPbActivity newSubPbActivity;
        Dialog dialog2;
        Dialog dialog3;
        NewSubPbActivity newSubPbActivity2;
        dialog = this.evV.esg;
        if (dialog != null) {
            dialog2 = this.evV.esg;
            if (dialog2 instanceof Dialog) {
                dialog3 = this.evV.esg;
                newSubPbActivity2 = this.evV.evs;
                com.baidu.adp.lib.g.j.b(dialog3, newSubPbActivity2.getPageContext());
            }
        }
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            newSubPbActivity = this.evV.evs;
            newSubPbActivity.a(this.emm, (String) sparseArray.get(w.h.tag_user_mute_mute_userid), sparseArray);
        }
    }
}
