package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class co implements View.OnClickListener {
    private final /* synthetic */ String cAA;
    private final /* synthetic */ String cAy;
    private final /* synthetic */ String cAz;
    final /* synthetic */ cn cDY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public co(cn cnVar, String str, String str2, String str3) {
        this.cDY = cnVar;
        this.cAy = str;
        this.cAz = str2;
        this.cAA = str3;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        if (TbadkCoreApplication.m411getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(this.cAy) && !StringUtils.isNull(this.cAz)) {
            if (com.baidu.adp.lib.util.i.iP()) {
                context = this.cDY.mContext;
                String format = String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", String.valueOf(this.cAy) + "," + this.cAz, this.cAA, this.cAA, context.getString(n.i.app_info_for_map));
                context2 = this.cDY.mContext;
                com.baidu.tbadk.browser.f.B(context2, format);
                return;
            }
            this.cDY.cCy.showToast(n.i.neterror);
        }
    }
}
