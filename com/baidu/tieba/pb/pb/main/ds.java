package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ds implements View.OnClickListener {
    final /* synthetic */ dq edg;
    private final /* synthetic */ String edh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ds(dq dqVar, String str) {
        this.edg = dqVar;
        this.edh = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!StringUtils.isNull(this.edh) && com.baidu.adp.lib.util.k.gD()) {
            TiebaStatic.log("c10854");
            com.baidu.tbadk.browser.f.v(this.edg.dYB.getActivity(), this.edh);
        }
    }
}
