package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fy implements View.OnClickListener {
    final /* synthetic */ er egZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fy(er erVar) {
        this.egZ = erVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        PbActivity pbActivity3;
        PbActivity pbActivity4;
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            boolean booleanValue = sparseArray.get(r.g.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(r.g.tag_should_manage_visible)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(r.g.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(r.g.tag_user_mute_visible)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(r.g.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(r.g.tag_should_delete_visible)).booleanValue() : false;
            if (booleanValue) {
                if (com.baidu.tieba.c.a.Od()) {
                    pbActivity3 = this.egZ.dYB;
                    Context baseContext = pbActivity3.getBaseContext();
                    pbActivity4 = this.egZ.dYB;
                    if (com.baidu.tieba.c.a.a(baseContext, pbActivity4.aJc().getThreadID(), (String) sparseArray.get(r.g.tag_subpb_main_floor_post_id), ((Integer) sparseArray.get(r.g.tag_manage_user_identity)).intValue())) {
                        return;
                    }
                }
                if (booleanValue2) {
                    sparseArray.put(r.g.tag_from, 1);
                    pbActivity2 = this.egZ.dYB;
                    pbActivity2.d(sparseArray);
                    return;
                }
                this.egZ.aW(view);
            } else if (booleanValue2) {
                sparseArray.put(r.g.tag_from, 0);
                sparseArray.put(r.g.tag_check_mute_from, 1);
                pbActivity = this.egZ.dYB;
                pbActivity.d(sparseArray);
            } else if (booleanValue3) {
                this.egZ.a(((Integer) sparseArray.get(r.g.tag_del_post_type)).intValue(), (String) sparseArray.get(r.g.tag_del_post_id), ((Integer) sparseArray.get(r.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(r.g.tag_del_post_is_self)).booleanValue());
            }
        }
    }
}
