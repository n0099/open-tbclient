package com.baidu.tieba.pb.pb.sub;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import com.baidu.tieba.i;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements View.OnClickListener {
    final /* synthetic */ t cmM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(t tVar) {
        this.cmM = tVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        NewSubPbActivity.a aVar;
        NewSubPbActivity.a aVar2;
        Dialog dialog2;
        Dialog dialog3;
        NewSubPbActivity newSubPbActivity;
        dialog = this.cmM.ckF;
        if (dialog != null) {
            dialog2 = this.cmM.ckF;
            if (dialog2 instanceof Dialog) {
                dialog3 = this.cmM.ckF;
                newSubPbActivity = this.cmM.cmv;
                com.baidu.adp.lib.g.j.b(dialog3, newSubPbActivity.getPageContext());
            }
        }
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            aVar = this.cmM.cmE;
            if (aVar != null) {
                aVar2 = this.cmM.cmE;
                aVar2.d(new Object[]{sparseArray.get(i.f.tag_manage_user_identity), sparseArray.get(i.f.tag_forbid_user_name), sparseArray.get(i.f.tag_forbid_user_post_id)});
            }
        }
    }
}
