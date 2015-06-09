package com.baidu.tieba.pb.pb.main.a;

import android.app.Activity;
import android.view.View;
import com.baidu.tbadk.browser.f;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ a bOO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.bOO = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        String str;
        pbActivity = this.bOO.bLa;
        Activity pageActivity = pbActivity.getPageContext().getPageActivity();
        pbActivity2 = this.bOO.bLa;
        String string = pbActivity2.getPageContext().getString(t.user_icon_intro);
        str = a.bOJ;
        f.a(pageActivity, string, String.valueOf(str) + "?st_type=pb_user_icon", true, false, false);
    }
}
