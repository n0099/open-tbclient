package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ge implements View.OnClickListener {
    final /* synthetic */ ex ewH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ge(ex exVar) {
        this.ewH = exVar;
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
                if (com.baidu.tieba.c.a.NO()) {
                    pbActivity3 = this.ewH.eow;
                    Context baseContext = pbActivity3.getBaseContext();
                    pbActivity4 = this.ewH.eow;
                    if (com.baidu.tieba.c.a.a(baseContext, pbActivity4.aNl().getThreadID(), (String) sparseArray.get(r.g.tag_subpb_main_floor_post_id), ((Integer) sparseArray.get(r.g.tag_manage_user_identity)).intValue())) {
                        return;
                    }
                }
                if (booleanValue2) {
                    sparseArray.put(r.g.tag_from, 1);
                    pbActivity2 = this.ewH.eow;
                    pbActivity2.d(sparseArray);
                    return;
                }
                this.ewH.aY(view);
            } else if (booleanValue2) {
                sparseArray.put(r.g.tag_from, 0);
                sparseArray.put(r.g.tag_check_mute_from, 1);
                pbActivity = this.ewH.eow;
                pbActivity.d(sparseArray);
            } else if (booleanValue3) {
                this.ewH.a(((Integer) sparseArray.get(r.g.tag_del_post_type)).intValue(), (String) sparseArray.get(r.g.tag_del_post_id), ((Integer) sparseArray.get(r.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(r.g.tag_del_post_is_self)).booleanValue());
            }
        }
    }
}
