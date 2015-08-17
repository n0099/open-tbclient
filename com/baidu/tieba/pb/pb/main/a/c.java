package com.baidu.tieba.pb.pb.main.a;

import android.view.View;
import com.baidu.tbadk.browser.f;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.i;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ a cfq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.cfq = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        PbActivity pbActivity;
        if (view.getTag(i.f.tag_user_id) instanceof String) {
            str = a.cfm;
            String string = TbadkCoreApplication.m411getInst().getString(i.C0057i.user_icon_web_view_title);
            pbActivity = this.cfq.cbx;
            f.a(pbActivity.getApplicationContext(), string, String.valueOf(str) + "?user_id=" + ((String) view.getTag(i.f.tag_user_id)), true, true, false);
            TiebaStatic.log(new ao("c10134").r("obj_type", 2));
        }
    }
}
