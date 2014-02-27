package com.baidu.tieba.pb;

import android.view.View;
import com.baidu.tieba.util.TbWebViewActivity;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
final class am implements View.OnClickListener {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        String str;
        NewPbActivity newPbActivity = this.a;
        String string = this.a.getString(R.string.user_icon_intro);
        str = NewPbActivity.c;
        TbWebViewActivity.b(newPbActivity, string, String.valueOf(str) + "?st_type=pb_user_icon");
    }
}
