package com.baidu.tieba.pb.pb.sub;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az implements View.OnClickListener {
    private final /* synthetic */ boolean eiX;
    final /* synthetic */ ao esl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(ao aoVar, boolean z) {
        this.esl = aoVar;
        this.eiX = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        NewSubPbActivity newSubPbActivity;
        Dialog dialog2;
        Dialog dialog3;
        NewSubPbActivity newSubPbActivity2;
        dialog = this.esl.eoD;
        if (dialog != null) {
            dialog2 = this.esl.eoD;
            if (dialog2 instanceof Dialog) {
                dialog3 = this.esl.eoD;
                newSubPbActivity2 = this.esl.erI;
                com.baidu.adp.lib.g.j.b(dialog3, newSubPbActivity2.getPageContext());
            }
        }
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            newSubPbActivity = this.esl.erI;
            newSubPbActivity.a(this.eiX, (String) sparseArray.get(r.h.tag_user_mute_mute_userid), sparseArray);
        }
    }
}
