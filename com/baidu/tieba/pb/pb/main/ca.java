package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ca implements View.OnClickListener {
    final /* synthetic */ by bJN;
    private final /* synthetic */ String bJO;
    private final /* synthetic */ String bJP;
    private final /* synthetic */ String bJQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ca(by byVar, String str, String str2, String str3) {
        this.bJN = byVar;
        this.bJO = str;
        this.bJP = str2;
        this.bJQ = str3;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        if (TbadkCoreApplication.m411getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(this.bJO) && !StringUtils.isNull(this.bJP)) {
            if (com.baidu.adp.lib.util.k.iH()) {
                context = this.bJN.mContext;
                String format = String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", String.valueOf(this.bJO) + "," + this.bJP, this.bJQ, this.bJQ, context.getString(com.baidu.tieba.y.app_info_for_map));
                context2 = this.bJN.mContext;
                com.baidu.tbadk.browser.f.x(context2, format);
                return;
            }
            this.bJN.bIF.showToast(com.baidu.tieba.y.neterror);
        }
    }
}
