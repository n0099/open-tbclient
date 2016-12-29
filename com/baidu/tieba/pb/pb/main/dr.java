package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dr implements View.OnClickListener {
    private final /* synthetic */ String dXN;
    private final /* synthetic */ String dXO;
    private final /* synthetic */ String dXP;
    final /* synthetic */ dq edg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dr(dq dqVar, String str, String str2, String str3) {
        this.edg = dqVar;
        this.dXN = str;
        this.dXO = str2;
        this.dXP = str3;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        if (TbadkCoreApplication.m9getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(this.dXN) && !StringUtils.isNull(this.dXO)) {
            if (com.baidu.adp.lib.util.i.gm()) {
                context = this.edg.mContext;
                String format = String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", String.valueOf(this.dXN) + "," + this.dXO, this.dXP, this.dXP, context.getString(r.j.app_info_for_map));
                context2 = this.edg.mContext;
                com.baidu.tbadk.browser.f.u(context2, format);
                return;
            }
            this.edg.dYB.showToast(r.j.neterror);
        }
    }
}
