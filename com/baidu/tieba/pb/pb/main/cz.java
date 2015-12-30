package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cz implements View.OnClickListener {
    private final /* synthetic */ String cEd;
    private final /* synthetic */ String cEe;
    private final /* synthetic */ String cEf;
    final /* synthetic */ cx cHX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cz(cx cxVar, String str, String str2, String str3) {
        this.cHX = cxVar;
        this.cEd = str;
        this.cEe = str2;
        this.cEf = str3;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        if (TbadkCoreApplication.m411getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(this.cEd) && !StringUtils.isNull(this.cEe)) {
            if (com.baidu.adp.lib.util.i.iQ()) {
                context = this.cHX.mContext;
                String format = String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", String.valueOf(this.cEd) + "," + this.cEe, this.cEf, this.cEf, context.getString(n.j.app_info_for_map));
                context2 = this.cHX.mContext;
                com.baidu.tbadk.browser.f.B(context2, format);
                return;
            }
            this.cHX.cGj.showToast(n.j.neterror);
        }
    }
}
