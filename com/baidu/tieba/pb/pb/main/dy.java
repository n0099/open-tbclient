package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dy implements View.OnClickListener {
    final /* synthetic */ dw epw;
    private final /* synthetic */ String epx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dy(dw dwVar, String str) {
        this.epw = dwVar;
        this.epx = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!StringUtils.isNull(this.epx) && com.baidu.adp.lib.util.k.hB()) {
            TiebaStatic.log("c10854");
            com.baidu.tbadk.browser.f.T(this.epw.ekw.getActivity(), this.epx);
        }
    }
}
