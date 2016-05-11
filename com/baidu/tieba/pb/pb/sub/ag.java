package com.baidu.tieba.pb.pb.sub;

import android.util.SparseArray;
import android.view.View;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements View.OnClickListener {
    final /* synthetic */ y dqN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(y yVar) {
        this.dqN = yVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SparseArray<Object> sparseArray;
        NewSubPbActivity newSubPbActivity;
        NewSubPbActivity newSubPbActivity2;
        if (view != null && (sparseArray = (SparseArray) view.getTag()) != null) {
            boolean booleanValue = sparseArray.get(t.g.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(t.g.tag_should_manage_visible)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(t.g.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(t.g.tag_user_mute_visible)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(t.g.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(t.g.tag_should_delete_visible)).booleanValue() : false;
            if (booleanValue) {
                if (booleanValue2) {
                    sparseArray.put(t.g.tag_from, 1);
                    newSubPbActivity2 = this.dqN.dqr;
                    newSubPbActivity2.d(sparseArray);
                    return;
                }
                this.dqN.aR(view);
            } else if (booleanValue2) {
                sparseArray.put(t.g.tag_from, 0);
                newSubPbActivity = this.dqN.dqr;
                newSubPbActivity.d(sparseArray);
            } else if (booleanValue3) {
                this.dqN.a(((Integer) sparseArray.get(t.g.tag_del_post_type)).intValue(), (String) sparseArray.get(t.g.tag_del_post_id), ((Integer) sparseArray.get(t.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(t.g.tag_del_post_is_self)).booleanValue());
            }
        }
    }
}
