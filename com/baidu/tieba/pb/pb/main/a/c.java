package com.baidu.tieba.pb.pb.main.a;

import android.view.View;
import com.baidu.tbadk.browser.f;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.n;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ a cGq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.cGq = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        PbActivity pbActivity;
        if (view.getTag(n.f.tag_user_id) instanceof String) {
            str = a.cGm;
            String string = TbadkCoreApplication.m411getInst().getString(n.i.user_icon_web_view_title);
            pbActivity = this.cGq.cCy;
            f.a(pbActivity.getApplicationContext(), string, String.valueOf(str) + "?user_id=" + ((String) view.getTag(n.f.tag_user_id)), true, true, false);
            TiebaStatic.log(new av("c10134").r("obj_type", 2));
        }
    }
}
