package com.baidu.tieba.pb.pb.sub;

import android.util.SparseArray;
import android.view.View;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements View.OnClickListener {
    final /* synthetic */ w cLC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(w wVar) {
        this.cLC = wVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SparseArray<Object> sparseArray;
        NewSubPbActivity newSubPbActivity;
        NewSubPbActivity newSubPbActivity2;
        if (view != null && (sparseArray = (SparseArray) view.getTag()) != null) {
            boolean booleanValue = sparseArray.get(n.g.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(n.g.tag_should_manage_visible)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(n.g.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(n.g.tag_user_mute_visible)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(n.g.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(n.g.tag_should_delete_visible)).booleanValue() : false;
            if (booleanValue) {
                if (booleanValue2) {
                    sparseArray.put(n.g.tag_from, 1);
                    newSubPbActivity2 = this.cLC.cLg;
                    newSubPbActivity2.d(sparseArray);
                    return;
                }
                this.cLC.ap(view);
            } else if (booleanValue2) {
                sparseArray.put(n.g.tag_from, 0);
                newSubPbActivity = this.cLC.cLg;
                newSubPbActivity.d(sparseArray);
            } else if (booleanValue3) {
                this.cLC.a(((Integer) sparseArray.get(n.g.tag_del_post_type)).intValue(), (String) sparseArray.get(n.g.tag_del_post_id), ((Integer) sparseArray.get(n.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(n.g.tag_del_post_is_self)).booleanValue());
            }
        }
    }
}
