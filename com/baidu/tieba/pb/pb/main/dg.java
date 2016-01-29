package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dg implements View.OnClickListener {
    private final /* synthetic */ String cKW;
    private final /* synthetic */ String cKX;
    private final /* synthetic */ String cKY;
    final /* synthetic */ de cPG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dg(de deVar, String str, String str2, String str3) {
        this.cPG = deVar;
        this.cKW = str;
        this.cKX = str2;
        this.cKY = str3;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        if (TbadkCoreApplication.m411getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(this.cKW) && !StringUtils.isNull(this.cKX)) {
            if (com.baidu.adp.lib.util.i.iZ()) {
                context = this.cPG.mContext;
                String format = String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", String.valueOf(this.cKW) + "," + this.cKX, this.cKY, this.cKY, context.getString(t.j.app_info_for_map));
                context2 = this.cPG.mContext;
                com.baidu.tbadk.browser.f.B(context2, format);
                return;
            }
            this.cPG.cNL.showToast(t.j.neterror);
        }
    }
}
