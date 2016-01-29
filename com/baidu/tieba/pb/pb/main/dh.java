package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dh implements View.OnClickListener {
    final /* synthetic */ de cPG;
    private final /* synthetic */ String cPH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dh(de deVar, String str) {
        this.cPG = deVar;
        this.cPH = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!StringUtils.isNull(this.cPH) && com.baidu.adp.lib.util.k.jq()) {
            TiebaStatic.log("c10854");
            com.baidu.tbadk.browser.f.C(this.cPG.cNL.getActivity(), this.cPH);
        }
    }
}
