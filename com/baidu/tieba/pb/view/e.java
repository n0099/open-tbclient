package com.baidu.tieba.pb.view;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ d chq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.chq = dVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String string = TbadkCoreApplication.m411getInst().getString(i.C0057i.tail_web_view_title);
        String string2 = com.baidu.tbadk.core.sharedPref.b.ts().getString("tail_link", "");
        if (!StringUtils.isNull(string2)) {
            com.baidu.tbadk.browser.f.a(view.getContext(), string, string2, true, true, true);
        }
    }
}
