package com.baidu.tieba.pb.pb.main.a;

import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ a eiM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.eiM = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        PbActivity pbActivity;
        if (view.getTag(u.g.tag_user_id) instanceof String) {
            str = a.eiI;
            String string = TbadkCoreApplication.m10getInst().getString(u.j.user_icon_web_view_title);
            pbActivity = this.eiM.eat;
            com.baidu.tbadk.browser.f.a(pbActivity.getApplicationContext(), string, String.valueOf(str) + "?user_id=" + ((String) view.getTag(u.g.tag_user_id)), true, true, true);
            TiebaStatic.log(new ay("c10134").s("obj_type", 2));
        }
    }
}
