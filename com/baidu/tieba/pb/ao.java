package com.baidu.tieba.pb;

import android.view.View;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.MainTabActivity;
import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements View.OnClickListener {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (TiebaApplication.b().k()) {
            StatService.onEvent(this.a, "pb_home_icon", "pbclick", 1);
        }
        String w = TiebaApplication.w();
        if ((w != null && w.length() > 0) || TiebaApplication.b().ag() >= 3) {
            MainTabActivity.a(this.a, "goto_home");
        } else {
            MainTabActivity.a(this.a, "goto_recommend");
        }
        this.a.a();
    }
}
