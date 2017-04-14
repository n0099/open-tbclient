package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dz implements View.OnClickListener {
    final /* synthetic */ dw ene;
    private final /* synthetic */ String enf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dz(dw dwVar, String str) {
        this.ene = dwVar;
        this.enf = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!StringUtils.isNull(this.enf) && com.baidu.adp.lib.util.k.hA()) {
            TiebaStatic.log("c10854");
            com.baidu.tbadk.browser.f.T(this.ene.eig.getActivity(), this.enf);
        }
    }
}
