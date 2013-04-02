package com.baidu.tieba.pb;

import android.view.View;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.MainTabActivity;
import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at implements View.OnClickListener {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (TiebaApplication.b().l()) {
            StatService.onEvent(this.a, "pb_home_icon", "pbclick", 1);
        }
        String y = TiebaApplication.y();
        if ((y != null && y.length() > 0) || TiebaApplication.b().ai() >= 3) {
            MainTabActivity.a(this.a, "goto_home");
        } else {
            MainTabActivity.a(this.a, "goto_recommend");
        }
        this.a.a();
    }
}
