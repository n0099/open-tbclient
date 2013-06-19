package com.baidu.tieba.pb;

import android.view.View;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class cp implements View.OnClickListener {
    final /* synthetic */ bk a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cp(bk bkVar) {
        this.a = bkVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!"".equals(view.getTag(R.id.tag_forbid_user_name)) && !"".equals(view.getTag(R.id.tag_del_post_id))) {
            this.a.a(view);
        } else {
            this.a.a(((Integer) view.getTag(R.id.tag_del_post_type)).intValue(), (String) view.getTag(R.id.tag_del_post_id), ((Integer) view.getTag(R.id.tag_manage_user_identity)).intValue(), ((Boolean) view.getTag(R.id.tag_del_post_is_self)).booleanValue());
        }
    }
}
