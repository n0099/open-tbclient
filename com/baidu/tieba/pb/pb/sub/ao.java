package com.baidu.tieba.pb.pb.sub;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements View.OnClickListener {
    final /* synthetic */ ag ewi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(ag agVar) {
        this.ewi = agVar;
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
            boolean booleanValue = sparseArray.get(t.g.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(t.g.tag_should_manage_visible)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(t.g.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(t.g.tag_user_mute_visible)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(t.g.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(t.g.tag_should_delete_visible)).booleanValue() : false;
            if (booleanValue) {
                if (com.baidu.tieba.c.a.Nn()) {
                    newSubPbActivity3 = this.ewi.evD;
                    Context baseContext = newSubPbActivity3.getBaseContext();
                    newSubPbActivity4 = this.ewi.evD;
                    String threadId = newSubPbActivity4.getThreadId();
                    newSubPbActivity5 = this.ewi.evD;
                    String postId = newSubPbActivity5.getPostId();
                    newSubPbActivity6 = this.ewi.evD;
                    if (com.baidu.tieba.c.a.a(baseContext, threadId, postId, newSubPbActivity6.aLX())) {
                        return;
                    }
                }
                if (booleanValue2) {
                    sparseArray.put(t.g.tag_from, 1);
                    newSubPbActivity2 = this.ewi.evD;
                    newSubPbActivity2.d(sparseArray);
                    return;
                }
                this.ewi.aZ(view);
            } else if (booleanValue2) {
                sparseArray.put(t.g.tag_from, 0);
                newSubPbActivity = this.ewi.evD;
                newSubPbActivity.d(sparseArray);
            } else if (booleanValue3) {
                this.ewi.a(((Integer) sparseArray.get(t.g.tag_del_post_type)).intValue(), (String) sparseArray.get(t.g.tag_del_post_id), ((Integer) sparseArray.get(t.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(t.g.tag_del_post_is_self)).booleanValue());
            }
        }
    }
}
