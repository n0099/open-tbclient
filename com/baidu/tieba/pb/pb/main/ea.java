package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ea implements View.OnClickListener {
    final /* synthetic */ dy eoW;
    private final /* synthetic */ String eoX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ea(dy dyVar, String str) {
        this.eoW = dyVar;
        this.eoX = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!StringUtils.isNull(this.eoX) && com.baidu.adp.lib.util.k.hv()) {
            TiebaStatic.log("c10854");
            com.baidu.tbadk.browser.f.P(this.eoW.eka.getActivity(), this.eoX);
        }
    }
}
