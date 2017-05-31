package com.baidu.tieba.pb.pb.main.a;

import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ a ewD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.ewD = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        PbActivity pbActivity;
        if (view.getTag(w.h.tag_user_id) instanceof String) {
            str = a.ewz;
            String string = TbadkCoreApplication.m9getInst().getString(w.l.user_icon_web_view_title);
            pbActivity = this.ewD.elf;
            com.baidu.tbadk.browser.f.a(pbActivity.getApplicationContext(), string, String.valueOf(str) + "?user_id=" + ((String) view.getTag(w.h.tag_user_id)), true, true, true);
            TiebaStatic.log(new as("c10134").r("obj_type", 2));
        }
    }
}
