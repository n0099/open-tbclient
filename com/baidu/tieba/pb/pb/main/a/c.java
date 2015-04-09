package com.baidu.tieba.pb.pb.main.a;

import android.app.Activity;
import android.view.View;
import com.baidu.tbadk.browser.f;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ a bMP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.bMP = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        String str;
        pbActivity = this.bMP.bIT;
        Activity pageActivity = pbActivity.getPageContext().getPageActivity();
        pbActivity2 = this.bMP.bIT;
        String string = pbActivity2.getPageContext().getString(y.user_icon_intro);
        str = a.bMK;
        f.a(pageActivity, string, String.valueOf(str) + "?st_type=pb_user_icon", true, false, false);
    }
}
