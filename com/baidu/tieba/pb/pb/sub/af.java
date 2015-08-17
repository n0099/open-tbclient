package com.baidu.tieba.pb.pb.sub;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import com.baidu.tieba.i;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements View.OnClickListener {
    final /* synthetic */ t cgt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(t tVar) {
        this.cgt = tVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        NewSubPbActivity.a aVar;
        NewSubPbActivity.a aVar2;
        Dialog dialog2;
        Dialog dialog3;
        NewSubPbActivity newSubPbActivity;
        dialog = this.cgt.cep;
        if (dialog != null) {
            dialog2 = this.cgt.cep;
            if (dialog2 instanceof Dialog) {
                dialog3 = this.cgt.cep;
                newSubPbActivity = this.cgt.cgc;
                com.baidu.adp.lib.g.j.b(dialog3, newSubPbActivity.getPageContext());
            }
        }
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            aVar = this.cgt.cgk;
            if (aVar != null) {
                aVar2 = this.cgt.cgk;
                aVar2.d(new Object[]{sparseArray.get(i.f.tag_manage_user_identity), sparseArray.get(i.f.tag_forbid_user_name), sparseArray.get(i.f.tag_forbid_user_post_id)});
            }
        }
    }
}
