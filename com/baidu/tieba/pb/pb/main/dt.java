package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dt implements View.OnClickListener {
    final /* synthetic */ dq dmt;
    private final /* synthetic */ String dmu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dt(dq dqVar, String str) {
        this.dmt = dqVar;
        this.dmu = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!StringUtils.isNull(this.dmu) && com.baidu.adp.lib.util.k.fH()) {
            TiebaStatic.log("c10854");
            com.baidu.tbadk.browser.f.u(this.dmt.dhY.getActivity(), this.dmu);
        }
    }
}
