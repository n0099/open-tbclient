package com.baidu.tieba.pb;

import android.view.View;
import com.baidu.tieba.util.TbWebViewActivity;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class an implements View.OnClickListener {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbWebViewActivity.a(this.a, this.a.getString(R.string.member_benefits), String.valueOf(com.baidu.tieba.data.i.b) + "mo/q/topic_page/tbeannote?st_type=pb_t_show");
    }
}
