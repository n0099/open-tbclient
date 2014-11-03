package com.baidu.tieba.pb.main.a;

import android.view.View;
import com.baidu.tbadk.browser.TbWebViewActivity;
import com.baidu.tieba.pb.main.PbActivity;
import com.baidu.tieba.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ a bzm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.bzm = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        String str;
        pbActivity = this.bzm.bxe;
        pbActivity2 = this.bzm.bxe;
        String string = pbActivity2.getString(y.user_icon_intro);
        str = a.bzh;
        TbWebViewActivity.startActivity(pbActivity, string, String.valueOf(str) + "?st_type=pb_user_icon");
    }
}
