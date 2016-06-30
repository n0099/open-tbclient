package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dw implements View.OnClickListener {
    final /* synthetic */ dt dSh;
    private final /* synthetic */ String dSi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dw(dt dtVar, String str) {
        this.dSh = dtVar;
        this.dSi = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!StringUtils.isNull(this.dSi) && com.baidu.adp.lib.util.k.fI()) {
            TiebaStatic.log("c10854");
            com.baidu.tbadk.browser.f.v(this.dSh.dOg.getActivity(), this.dSi);
        }
    }
}
