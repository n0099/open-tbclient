package com.baidu.tieba.pb.pb.sub;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements View.OnClickListener {
    final /* synthetic */ t cmM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(t tVar) {
        this.cmM = tVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
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
            this.cmM.a(((Integer) sparseArray.get(i.f.tag_del_post_type)).intValue(), (String) sparseArray.get(i.f.tag_del_post_id), ((Integer) sparseArray.get(i.f.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(i.f.tag_del_post_is_self)).booleanValue());
        }
    }
}
