package com.baidu.tieba.pb;

import android.util.SparseArray;
import android.view.View;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cs implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bn f1511a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cs(bn bnVar) {
        this.f1511a = bnVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            if (!"".equals(sparseArray.get(R.id.tag_forbid_user_name)) && !"".equals(sparseArray.get(R.id.tag_del_post_id))) {
                this.f1511a.a(view);
            } else {
                this.f1511a.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
            }
        }
    }
}
