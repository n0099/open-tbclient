package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dx implements View.OnClickListener {
    final /* synthetic */ du eey;
    private final /* synthetic */ String eez;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dx(du duVar, String str) {
        this.eey = duVar;
        this.eez = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!StringUtils.isNull(this.eez) && com.baidu.adp.lib.util.k.fH()) {
            TiebaStatic.log("c10854");
            com.baidu.tbadk.browser.f.v(this.eey.eat.getActivity(), this.eez);
        }
    }
}
