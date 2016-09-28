package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dy implements View.OnClickListener {
    final /* synthetic */ du esD;
    private final /* synthetic */ String esE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dy(du duVar, String str) {
        this.esD = duVar;
        this.esE = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!StringUtils.isNull(this.esE) && com.baidu.adp.lib.util.k.gD()) {
            TiebaStatic.log("c10854");
            com.baidu.tbadk.browser.f.v(this.esD.eow.getActivity(), this.esE);
        }
    }
}
