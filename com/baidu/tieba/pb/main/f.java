package com.baidu.tieba.pb.main;

import android.view.View;
import com.baidu.tbadk.browser.TbWebViewActivity;
/* loaded from: classes.dex */
class f implements View.OnClickListener {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        PbActivity pbActivity = this.a;
        String string = this.a.getString(com.baidu.tieba.y.user_icon_intro);
        str = PbActivity.e;
        TbWebViewActivity.startActivity(pbActivity, string, String.valueOf(str) + "?st_type=pb_user_icon");
    }
}
