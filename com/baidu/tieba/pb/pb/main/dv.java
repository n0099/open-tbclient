package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dv implements View.OnClickListener {
    private final /* synthetic */ String dMP;
    private final /* synthetic */ String dMQ;
    private final /* synthetic */ String dMR;
    final /* synthetic */ dt dSh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dv(dt dtVar, String str, String str2, String str3) {
        this.dSh = dtVar;
        this.dMP = str;
        this.dMQ = str2;
        this.dMR = str3;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        if (TbadkCoreApplication.m9getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(this.dMP) && !StringUtils.isNull(this.dMQ)) {
            if (com.baidu.adp.lib.util.i.fr()) {
                context = this.dSh.mContext;
                String format = String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", String.valueOf(this.dMP) + "," + this.dMQ, this.dMR, this.dMR, context.getString(u.j.app_info_for_map));
                context2 = this.dSh.mContext;
                com.baidu.tbadk.browser.f.u(context2, format);
                return;
            }
            this.dSh.dOg.showToast(u.j.neterror);
        }
    }
}
