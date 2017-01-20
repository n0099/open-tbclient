package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dz implements View.OnClickListener {
    final /* synthetic */ dx elZ;
    private final /* synthetic */ String ema;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dz(dx dxVar, String str) {
        this.elZ = dxVar;
        this.ema = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!StringUtils.isNull(this.ema) && com.baidu.adp.lib.util.k.gB()) {
            TiebaStatic.log("c10854");
            com.baidu.tbadk.browser.f.v(this.elZ.ehi.getActivity(), this.ema);
        }
    }
}
