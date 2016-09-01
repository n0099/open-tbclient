package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dx implements View.OnClickListener {
    final /* synthetic */ du eqD;
    private final /* synthetic */ String eqE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dx(du duVar, String str) {
        this.eqD = duVar;
        this.eqE = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!StringUtils.isNull(this.eqE) && com.baidu.adp.lib.util.k.gD()) {
            TiebaStatic.log("c10854");
            com.baidu.tbadk.browser.f.v(this.eqD.emy.getActivity(), this.eqE);
        }
    }
}
