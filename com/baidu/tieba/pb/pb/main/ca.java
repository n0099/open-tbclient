package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ca implements View.OnClickListener {
    final /* synthetic */ bz bKc;
    private final /* synthetic */ String bKd;
    private final /* synthetic */ String bKe;
    private final /* synthetic */ String bKf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ca(bz bzVar, String str, String str2, String str3) {
        this.bKc = bzVar;
        this.bKd = str;
        this.bKe = str2;
        this.bKf = str3;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        if (TbadkCoreApplication.m411getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(this.bKd) && !StringUtils.isNull(this.bKe)) {
            if (com.baidu.adp.lib.util.k.iH()) {
                context = this.bKc.mContext;
                String format = String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", String.valueOf(this.bKd) + "," + this.bKe, this.bKf, this.bKf, context.getString(com.baidu.tieba.y.app_info_for_map));
                context2 = this.bKc.mContext;
                com.baidu.tbadk.browser.f.x(context2, format);
                return;
            }
            this.bKc.bIT.showToast(com.baidu.tieba.y.neterror);
        }
    }
}
