package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class dt implements View.OnClickListener {
    final /* synthetic */ dr eoS;
    private final /* synthetic */ String eoT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dt(dr drVar, String str) {
        this.eoS = drVar;
        this.eoT = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!StringUtils.isNull(this.eoT) && com.baidu.adp.lib.util.k.hB()) {
            TiebaStatic.log("c10854");
            com.baidu.tbadk.browser.f.T(this.eoS.elf.getActivity(), this.eoT);
        }
    }
}
