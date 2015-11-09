package com.baidu.tieba.pb.pb.sub;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import com.baidu.tieba.i;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements View.OnClickListener {
    final /* synthetic */ v coo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(v vVar) {
        this.coo = vVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        NewSubPbActivity.a aVar;
        NewSubPbActivity.a aVar2;
        Dialog dialog2;
        Dialog dialog3;
        NewSubPbActivity newSubPbActivity;
        dialog = this.coo.cme;
        if (dialog != null) {
            dialog2 = this.coo.cme;
            if (dialog2 instanceof Dialog) {
                dialog3 = this.coo.cme;
                newSubPbActivity = this.coo.cnX;
                com.baidu.adp.lib.g.j.b(dialog3, newSubPbActivity.getPageContext());
            }
        }
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            aVar = this.coo.cog;
            if (aVar != null) {
                aVar2 = this.coo.cog;
                aVar2.d(new Object[]{sparseArray.get(i.f.tag_manage_user_identity), sparseArray.get(i.f.tag_forbid_user_name), sparseArray.get(i.f.tag_forbid_user_post_id)});
            }
        }
    }
}
