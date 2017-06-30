package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class ea implements View.OnClickListener {
    final /* synthetic */ dy exY;
    private final /* synthetic */ String exZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ea(dy dyVar, String str) {
        this.exY = dyVar;
        this.exZ = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!StringUtils.isNull(this.exZ) && com.baidu.adp.lib.util.k.hA()) {
            TiebaStatic.log("c10854");
            com.baidu.tbadk.browser.g.U(this.exY.euf.getActivity(), this.exZ);
        }
    }
}
