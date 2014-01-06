package com.baidu.tieba.pb;

import android.view.View;
import com.baidu.tieba.CommonWebviewActivity;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class aq implements View.OnClickListener {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        NewPbActivity newPbActivity = this.a;
        String string = this.a.getString(R.string.user_icon_intro);
        StringBuilder sb = new StringBuilder();
        str = NewPbActivity.c;
        CommonWebviewActivity.a(newPbActivity, string, sb.append(str).append("?st_type=pb_user_icon").toString(), true, "get");
    }
}
