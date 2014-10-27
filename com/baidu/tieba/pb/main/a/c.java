package com.baidu.tieba.pb.main.a;

import android.view.View;
import com.baidu.tbadk.browser.TbWebViewActivity;
import com.baidu.tieba.pb.main.PbActivity;
import com.baidu.tieba.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ a byY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.byY = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        String str;
        pbActivity = this.byY.bwQ;
        pbActivity2 = this.byY.bwQ;
        String string = pbActivity2.getString(y.user_icon_intro);
        str = a.byT;
        TbWebViewActivity.startActivity(pbActivity, string, String.valueOf(str) + "?st_type=pb_user_icon");
    }
}
