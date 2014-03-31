package com.baidu.tieba.pb.main;

import android.view.View;
import com.baidu.tbadk.browser.TbWebViewActivity;
/* loaded from: classes.dex */
final class g implements View.OnClickListener {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        TbWebViewActivity.a(this.a, this.a.getString(com.baidu.tieba.a.k.member_benefits), String.valueOf(com.baidu.tieba.data.d.a) + "mo/q/topic_page/tbeannote?st_type=pb_t_show");
    }
}
