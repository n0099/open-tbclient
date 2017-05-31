package com.baidu.tieba.pb.pb.sub;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at implements View.OnClickListener {
    final /* synthetic */ ao eyO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(ao aoVar) {
        this.eyO = aoVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SparseArray<Object> sparseArray;
        NewSubPbActivity newSubPbActivity;
        NewSubPbActivity newSubPbActivity2;
        NewSubPbActivity newSubPbActivity3;
        NewSubPbActivity newSubPbActivity4;
        NewSubPbActivity newSubPbActivity5;
        NewSubPbActivity newSubPbActivity6;
        if (view != null && (sparseArray = (SparseArray) view.getTag()) != null) {
            boolean booleanValue = sparseArray.get(w.h.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(w.h.tag_should_manage_visible)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(w.h.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(w.h.tag_user_mute_visible)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(w.h.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(w.h.tag_should_delete_visible)).booleanValue() : false;
            if (booleanValue) {
                if (com.baidu.tieba.c.a.SV()) {
                    newSubPbActivity3 = this.eyO.eyk;
                    Context baseContext = newSubPbActivity3.getBaseContext();
                    newSubPbActivity4 = this.eyO.eyk;
                    String threadId = newSubPbActivity4.getThreadId();
                    newSubPbActivity5 = this.eyO.eyk;
                    String postId = newSubPbActivity5.getPostId();
                    newSubPbActivity6 = this.eyO.eyk;
                    if (com.baidu.tieba.c.a.a(baseContext, threadId, postId, newSubPbActivity6.aIM())) {
                        return;
                    }
                }
                if (booleanValue2) {
                    sparseArray.put(w.h.tag_from, 1);
                    newSubPbActivity2 = this.eyO.eyk;
                    newSubPbActivity2.d(sparseArray);
                    return;
                }
                this.eyO.aX(view);
            } else if (booleanValue2) {
                sparseArray.put(w.h.tag_from, 0);
                newSubPbActivity = this.eyO.eyk;
                newSubPbActivity.d(sparseArray);
            } else if (booleanValue3) {
                this.eyO.a(((Integer) sparseArray.get(w.h.tag_del_post_type)).intValue(), (String) sparseArray.get(w.h.tag_del_post_id), ((Integer) sparseArray.get(w.h.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(w.h.tag_del_post_is_self)).booleanValue());
            }
        }
    }
}
