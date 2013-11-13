package com.baidu.tieba.pb;

import android.view.View;
import com.baidu.tieba.CommonWebviewActivity;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class ar implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f2075a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(NewPbActivity newPbActivity) {
        this.f2075a = newPbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        NewPbActivity newPbActivity = this.f2075a;
        String string = this.f2075a.getString(R.string.user_icon_intro);
        StringBuilder sb = new StringBuilder();
        str = NewPbActivity.c;
        CommonWebviewActivity.a(newPbActivity, string, sb.append(str).append("?st_type=pb_user_icon").toString(), true, "get");
    }
}
