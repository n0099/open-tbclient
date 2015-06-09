package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bx implements View.OnClickListener {
    final /* synthetic */ bw bMj;
    private final /* synthetic */ String bMk;
    private final /* synthetic */ String bMl;
    private final /* synthetic */ String bMm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bx(bw bwVar, String str, String str2, String str3) {
        this.bMj = bwVar;
        this.bMk = str;
        this.bMl = str2;
        this.bMm = str3;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        if (TbadkCoreApplication.m411getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(this.bMk) && !StringUtils.isNull(this.bMl)) {
            if (com.baidu.adp.lib.util.k.iX()) {
                context = this.bMj.mContext;
                String format = String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", String.valueOf(this.bMk) + "," + this.bMl, this.bMm, this.bMm, context.getString(com.baidu.tieba.t.app_info_for_map));
                context2 = this.bMj.mContext;
                com.baidu.tbadk.browser.f.x(context2, format);
                return;
            }
            this.bMj.bLa.showToast(com.baidu.tieba.t.neterror);
        }
    }
}
