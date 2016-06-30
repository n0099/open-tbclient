package com.baidu.tieba.pb.pb.sub;

import android.util.SparseArray;
import android.view.View;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements View.OnClickListener {
    final /* synthetic */ af dXy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(af afVar) {
        this.dXy = afVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SparseArray<Object> sparseArray;
        NewSubPbActivity newSubPbActivity;
        NewSubPbActivity newSubPbActivity2;
        if (view != null && (sparseArray = (SparseArray) view.getTag()) != null) {
            boolean booleanValue = sparseArray.get(u.g.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(u.g.tag_should_manage_visible)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(u.g.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(u.g.tag_user_mute_visible)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(u.g.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(u.g.tag_should_delete_visible)).booleanValue() : false;
            if (booleanValue) {
                if (booleanValue2) {
                    sparseArray.put(u.g.tag_from, 1);
                    newSubPbActivity2 = this.dXy.dWU;
                    newSubPbActivity2.d(sparseArray);
                    return;
                }
                this.dXy.aZ(view);
            } else if (booleanValue2) {
                sparseArray.put(u.g.tag_from, 0);
                newSubPbActivity = this.dXy.dWU;
                newSubPbActivity.d(sparseArray);
            } else if (booleanValue3) {
                this.dXy.a(((Integer) sparseArray.get(u.g.tag_del_post_type)).intValue(), (String) sparseArray.get(u.g.tag_del_post_id), ((Integer) sparseArray.get(u.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(u.g.tag_del_post_is_self)).booleanValue());
            }
        }
    }
}
