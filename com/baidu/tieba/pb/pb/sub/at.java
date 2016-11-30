package com.baidu.tieba.pb.pb.sub;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at implements View.OnClickListener {
    final /* synthetic */ ao eFb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(ao aoVar) {
        this.eFb = aoVar;
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
            boolean booleanValue = sparseArray.get(r.g.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(r.g.tag_should_manage_visible)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(r.g.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(r.g.tag_user_mute_visible)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(r.g.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(r.g.tag_should_delete_visible)).booleanValue() : false;
            if (booleanValue) {
                if (com.baidu.tieba.c.a.OR()) {
                    newSubPbActivity3 = this.eFb.eEy;
                    Context baseContext = newSubPbActivity3.getBaseContext();
                    newSubPbActivity4 = this.eFb.eEy;
                    String threadId = newSubPbActivity4.getThreadId();
                    newSubPbActivity5 = this.eFb.eEy;
                    String postId = newSubPbActivity5.getPostId();
                    newSubPbActivity6 = this.eFb.eEy;
                    if (com.baidu.tieba.c.a.a(baseContext, threadId, postId, newSubPbActivity6.aOt())) {
                        return;
                    }
                }
                if (booleanValue2) {
                    sparseArray.put(r.g.tag_from, 1);
                    newSubPbActivity2 = this.eFb.eEy;
                    newSubPbActivity2.d(sparseArray);
                    return;
                }
                this.eFb.aX(view);
            } else if (booleanValue2) {
                sparseArray.put(r.g.tag_from, 0);
                newSubPbActivity = this.eFb.eEy;
                newSubPbActivity.d(sparseArray);
            } else if (booleanValue3) {
                this.eFb.a(((Integer) sparseArray.get(r.g.tag_del_post_type)).intValue(), (String) sparseArray.get(r.g.tag_del_post_id), ((Integer) sparseArray.get(r.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(r.g.tag_del_post_is_self)).booleanValue());
            }
        }
    }
}
