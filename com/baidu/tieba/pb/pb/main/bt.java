package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bt implements View.OnClickListener {
    private final /* synthetic */ String cgO;
    private final /* synthetic */ String cgP;
    private final /* synthetic */ String cgQ;
    final /* synthetic */ bs cjP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bt(bs bsVar, String str, String str2, String str3) {
        this.cjP = bsVar;
        this.cgO = str;
        this.cgP = str2;
        this.cgQ = str3;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        if (TbadkCoreApplication.m411getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(this.cgO) && !StringUtils.isNull(this.cgP)) {
            if (com.baidu.adp.lib.util.i.iM()) {
                context = this.cjP.mContext;
                String format = String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", String.valueOf(this.cgO) + "," + this.cgP, this.cgQ, this.cgQ, context.getString(i.h.app_info_for_map));
                context2 = this.cjP.mContext;
                com.baidu.tbadk.browser.g.B(context2, format);
                return;
            }
            this.cjP.ciJ.showToast(i.h.neterror);
        }
    }
}
