package com.baidu.tieba.pb.pb.main.a;

import android.view.View;
import com.baidu.tbadk.browser.f;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ a cSH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.cSH = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        PbActivity pbActivity;
        if (view.getTag(t.g.tag_user_id) instanceof String) {
            str = a.cSD;
            String string = TbadkCoreApplication.m411getInst().getString(t.j.user_icon_web_view_title);
            pbActivity = this.cSH.cNL;
            f.a(pbActivity.getApplicationContext(), string, String.valueOf(str) + "?user_id=" + ((String) view.getTag(t.g.tag_user_id)), true, true, false);
            TiebaStatic.log(new au("c10134").r("obj_type", 2));
        }
    }
}
