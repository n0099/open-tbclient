package com.baidu.tieba.pb.pb.main;

import android.util.SparseArray;
import android.view.View;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fz implements View.OnClickListener {
    final /* synthetic */ es dVR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fz(es esVar) {
        this.dVR = esVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            boolean booleanValue = sparseArray.get(u.g.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(u.g.tag_should_manage_visible)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(u.g.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(u.g.tag_user_mute_visible)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(u.g.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(u.g.tag_should_delete_visible)).booleanValue() : false;
            if (booleanValue) {
                if (booleanValue2) {
                    sparseArray.put(u.g.tag_from, 1);
                    pbActivity2 = this.dVR.dOg;
                    pbActivity2.d(sparseArray);
                    return;
                }
                this.dVR.aZ(view);
            } else if (booleanValue2) {
                sparseArray.put(u.g.tag_from, 0);
                sparseArray.put(u.g.tag_check_mute_from, 1);
                pbActivity = this.dVR.dOg;
                pbActivity.d(sparseArray);
            } else if (booleanValue3) {
                this.dVR.a(((Integer) sparseArray.get(u.g.tag_del_post_type)).intValue(), (String) sparseArray.get(u.g.tag_del_post_id), ((Integer) sparseArray.get(u.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(u.g.tag_del_post_is_self)).booleanValue());
            }
        }
    }
}
