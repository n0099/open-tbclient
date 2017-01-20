package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class gj implements View.OnClickListener {
    final /* synthetic */ ez eqf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gj(ez ezVar) {
        this.eqf = ezVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        PbActivity pbActivity3;
        PbActivity pbActivity4;
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            boolean booleanValue = sparseArray.get(r.h.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(r.h.tag_should_manage_visible)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(r.h.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(r.h.tag_user_mute_visible)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(r.h.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(r.h.tag_should_delete_visible)).booleanValue() : false;
            if (booleanValue) {
                if (com.baidu.tieba.c.a.QW()) {
                    pbActivity3 = this.eqf.ehi;
                    Context baseContext = pbActivity3.getBaseContext();
                    pbActivity4 = this.eqf.ehi;
                    if (com.baidu.tieba.c.a.a(baseContext, pbActivity4.aKP().getThreadID(), (String) sparseArray.get(r.h.tag_subpb_main_floor_post_id), ((Integer) sparseArray.get(r.h.tag_manage_user_identity)).intValue())) {
                        return;
                    }
                }
                if (booleanValue2) {
                    sparseArray.put(r.h.tag_from, 1);
                    pbActivity2 = this.eqf.ehi;
                    pbActivity2.d(sparseArray);
                    return;
                }
                this.eqf.bd(view);
            } else if (booleanValue2) {
                sparseArray.put(r.h.tag_from, 0);
                sparseArray.put(r.h.tag_check_mute_from, 1);
                pbActivity = this.eqf.ehi;
                pbActivity.d(sparseArray);
            } else if (booleanValue3) {
                this.eqf.a(((Integer) sparseArray.get(r.h.tag_del_post_type)).intValue(), (String) sparseArray.get(r.h.tag_del_post_id), ((Integer) sparseArray.get(r.h.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(r.h.tag_del_post_is_self)).booleanValue());
            }
        }
    }
}
