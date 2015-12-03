package com.baidu.tieba.pb.pb.main;

import android.util.SparseArray;
import android.view.View;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class eb implements View.OnClickListener {
    final /* synthetic */ da cGh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public eb(da daVar) {
        this.cGh = daVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            boolean booleanValue = sparseArray.get(n.f.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(n.f.tag_should_manage_visible)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(n.f.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(n.f.tag_user_mute_visible)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(n.f.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(n.f.tag_should_delete_visible)).booleanValue() : false;
            if (booleanValue) {
                if (booleanValue2) {
                    sparseArray.put(n.f.tag_from, 1);
                    pbActivity2 = this.cGh.cCy;
                    pbActivity2.d(sparseArray);
                    return;
                }
                this.cGh.ak(view);
            } else if (booleanValue2) {
                sparseArray.put(n.f.tag_from, 0);
                sparseArray.put(n.f.tag_check_mute_from, 1);
                pbActivity = this.cGh.cCy;
                pbActivity.d(sparseArray);
            } else if (booleanValue3) {
                this.cGh.a(((Integer) sparseArray.get(n.f.tag_del_post_type)).intValue(), (String) sparseArray.get(n.f.tag_del_post_id), ((Integer) sparseArray.get(n.f.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(n.f.tag_del_post_is_self)).booleanValue());
            }
        }
    }
}
