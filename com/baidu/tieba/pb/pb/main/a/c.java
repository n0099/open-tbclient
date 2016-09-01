package com.baidu.tieba.pb.pb.main.a;

import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ a euT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.euT = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        PbActivity pbActivity;
        if (view.getTag(t.g.tag_user_id) instanceof String) {
            str = a.euP;
            String string = TbadkCoreApplication.m9getInst().getString(t.j.user_icon_web_view_title);
            pbActivity = this.euT.emy;
            com.baidu.tbadk.browser.f.a(pbActivity.getApplicationContext(), string, String.valueOf(str) + "?user_id=" + ((String) view.getTag(t.g.tag_user_id)), true, true, true);
            TiebaStatic.log(new ay("c10134").s("obj_type", 2));
        }
    }
}
