package com.baidu.tieba.pb.pb.main.a;

import android.view.View;
import com.baidu.tbadk.browser.g;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.i;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ a cnf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.cnf = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        PbActivity pbActivity;
        if (view.getTag(i.f.tag_user_id) instanceof String) {
            str = a.cnb;
            String string = TbadkCoreApplication.m411getInst().getString(i.h.user_icon_web_view_title);
            pbActivity = this.cnf.cjZ;
            g.a(pbActivity.getApplicationContext(), string, String.valueOf(str) + "?user_id=" + ((String) view.getTag(i.f.tag_user_id)), true, true, false);
            TiebaStatic.log(new aq("c10134").r("obj_type", 2));
        }
    }
}
