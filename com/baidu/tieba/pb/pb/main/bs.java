package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bs implements View.OnClickListener {
    final /* synthetic */ br cdH;
    private final /* synthetic */ String cdI;
    private final /* synthetic */ String cdJ;
    private final /* synthetic */ String cdK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bs(br brVar, String str, String str2, String str3) {
        this.cdH = brVar;
        this.cdI = str;
        this.cdJ = str2;
        this.cdK = str3;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        if (TbadkCoreApplication.m411getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(this.cdI) && !StringUtils.isNull(this.cdJ)) {
            if (com.baidu.adp.lib.util.i.iL()) {
                context = this.cdH.mContext;
                String format = String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", String.valueOf(this.cdI) + "," + this.cdJ, this.cdK, this.cdK, context.getString(i.h.app_info_for_map));
                context2 = this.cdH.mContext;
                com.baidu.tbadk.browser.g.B(context2, format);
                return;
            }
            this.cdH.ccs.showToast(i.h.neterror);
        }
    }
}
