package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dz implements View.OnClickListener {
    final /* synthetic */ dx eyV;
    private final /* synthetic */ String eyW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dz(dx dxVar, String str) {
        this.eyV = dxVar;
        this.eyW = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!StringUtils.isNull(this.eyW) && com.baidu.adp.lib.util.k.gD()) {
            TiebaStatic.log("c10854");
            com.baidu.tbadk.browser.f.v(this.eyV.eug.getActivity(), this.eyW);
        }
    }
}
