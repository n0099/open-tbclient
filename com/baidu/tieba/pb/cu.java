package com.baidu.tieba.pb;

import android.util.SparseArray;
import android.view.View;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class cu implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bt f2108a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cu(bt btVar) {
        this.f2108a = btVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            if (!"".equals(sparseArray.get(R.id.tag_forbid_user_name)) && !"".equals(sparseArray.get(R.id.tag_del_post_id))) {
                this.f2108a.a(view);
            } else {
                this.f2108a.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
            }
        }
    }
}
