package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ec implements View.OnClickListener {
    final /* synthetic */ dz djW;
    private final /* synthetic */ String djX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ec(dz dzVar, String str) {
        this.djW = dzVar;
        this.djX = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!StringUtils.isNull(this.djX) && com.baidu.adp.lib.util.k.jw()) {
            TiebaStatic.log("c10854");
            com.baidu.tbadk.browser.f.t(this.djW.dfw.getActivity(), this.djX);
        }
    }
}
