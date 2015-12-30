package com.baidu.tieba.pb.pb.main;

import android.util.SparseArray;
import android.view.View;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class el implements View.OnClickListener {
    final /* synthetic */ dk cKg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public el(dk dkVar) {
        this.cKg = dkVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            boolean booleanValue = sparseArray.get(n.g.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(n.g.tag_should_manage_visible)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(n.g.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(n.g.tag_user_mute_visible)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(n.g.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(n.g.tag_should_delete_visible)).booleanValue() : false;
            if (booleanValue) {
                if (booleanValue2) {
                    sparseArray.put(n.g.tag_from, 1);
                    pbActivity2 = this.cKg.cGj;
                    pbActivity2.d(sparseArray);
                    return;
                }
                this.cKg.ap(view);
            } else if (booleanValue2) {
                sparseArray.put(n.g.tag_from, 0);
                sparseArray.put(n.g.tag_check_mute_from, 1);
                pbActivity = this.cKg.cGj;
                pbActivity.d(sparseArray);
            } else if (booleanValue3) {
                this.cKg.a(((Integer) sparseArray.get(n.g.tag_del_post_type)).intValue(), (String) sparseArray.get(n.g.tag_del_post_id), ((Integer) sparseArray.get(n.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(n.g.tag_del_post_is_self)).booleanValue());
            }
        }
    }
}
