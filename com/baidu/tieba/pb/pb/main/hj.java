package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class hj implements View.OnClickListener {
    final /* synthetic */ gg eEv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public hj(gg ggVar) {
        this.eEv = ggVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        PbActivity pbActivity3;
        PbActivity pbActivity4;
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            boolean booleanValue = sparseArray.get(w.h.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(w.h.tag_should_manage_visible)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(w.h.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(w.h.tag_user_mute_visible)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(w.h.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(w.h.tag_should_delete_visible)).booleanValue() : false;
            if (booleanValue) {
                if (com.baidu.tieba.c.a.Ux()) {
                    pbActivity3 = this.eEv.euf;
                    Context baseContext = pbActivity3.getBaseContext();
                    pbActivity4 = this.eEv.euf;
                    if (com.baidu.tieba.c.a.a(baseContext, pbActivity4.aNz().getThreadID(), (String) sparseArray.get(w.h.tag_subpb_main_floor_post_id), ((Integer) sparseArray.get(w.h.tag_manage_user_identity)).intValue())) {
                        return;
                    }
                }
                if (booleanValue2) {
                    sparseArray.put(w.h.tag_from, 1);
                    pbActivity2 = this.eEv.euf;
                    pbActivity2.d(sparseArray);
                    return;
                }
                this.eEv.ba(view);
            } else if (booleanValue2) {
                sparseArray.put(w.h.tag_from, 0);
                sparseArray.put(w.h.tag_check_mute_from, 1);
                pbActivity = this.eEv.euf;
                pbActivity.d(sparseArray);
            } else if (booleanValue3) {
                this.eEv.a(((Integer) sparseArray.get(w.h.tag_del_post_type)).intValue(), (String) sparseArray.get(w.h.tag_del_post_id), ((Integer) sparseArray.get(w.h.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(w.h.tag_del_post_is_self)).booleanValue());
            }
        }
    }
}
