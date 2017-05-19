package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class dm implements View.OnClickListener {
    final /* synthetic */ dl eji;
    private final /* synthetic */ String ejj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dm(dl dlVar, String str) {
        this.eji = dlVar;
        this.ejj = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!StringUtils.isNull(this.ejj) && com.baidu.adp.lib.util.k.hB()) {
            TiebaStatic.log("c10854");
            com.baidu.tbadk.browser.f.T(this.eji.efF.getActivity(), this.ejj);
        }
    }
}
