package com.baidu.tieba.pb.pb.main;

import android.util.SparseArray;
import android.view.View;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dl implements View.OnClickListener {
    final /* synthetic */ ct cmY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dl(ct ctVar) {
        this.cmY = ctVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            boolean booleanValue = sparseArray.get(i.f.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(i.f.tag_should_manage_visible)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(i.f.tag_display_reply_visible) instanceof Boolean ? ((Boolean) sparseArray.get(i.f.tag_display_reply_visible)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(i.f.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(i.f.tag_should_delete_visible)).booleanValue() : false;
            if (booleanValue) {
                if (booleanValue2) {
                    sparseArray.put(i.f.tag_from, 1);
                    pbActivity2 = this.cmY.cjZ;
                    pbActivity2.d(sparseArray);
                    return;
                }
                this.cmY.ab(view);
            } else if (booleanValue2) {
                sparseArray.put(i.f.tag_from, 0);
                pbActivity = this.cmY.cjZ;
                pbActivity.d(sparseArray);
            } else if (booleanValue3) {
                this.cmY.a(((Integer) sparseArray.get(i.f.tag_del_post_type)).intValue(), (String) sparseArray.get(i.f.tag_del_post_id), ((Integer) sparseArray.get(i.f.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(i.f.tag_del_post_is_self)).booleanValue());
            }
        }
    }
}
