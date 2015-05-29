package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class by implements View.OnClickListener {
    final /* synthetic */ bw bMi;
    private final /* synthetic */ String bMj;
    private final /* synthetic */ String bMk;
    private final /* synthetic */ String bMl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public by(bw bwVar, String str, String str2, String str3) {
        this.bMi = bwVar;
        this.bMj = str;
        this.bMk = str2;
        this.bMl = str3;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        if (TbadkCoreApplication.m411getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(this.bMj) && !StringUtils.isNull(this.bMk)) {
            if (com.baidu.adp.lib.util.k.iX()) {
                context = this.bMi.mContext;
                String format = String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", String.valueOf(this.bMj) + "," + this.bMk, this.bMl, this.bMl, context.getString(com.baidu.tieba.t.app_info_for_map));
                context2 = this.bMi.mContext;
                com.baidu.tbadk.browser.f.x(context2, format);
                return;
            }
            this.bMi.bKZ.showToast(com.baidu.tieba.t.neterror);
        }
    }
}
