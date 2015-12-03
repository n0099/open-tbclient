package com.baidu.tieba.pb.pb.a;

import android.content.Context;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.n;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    private final /* synthetic */ String cAA;
    final /* synthetic */ n cAx;
    private final /* synthetic */ String cAy;
    private final /* synthetic */ String cAz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar, String str, String str2, String str3) {
        this.cAx = nVar;
        this.cAy = str;
        this.cAz = str2;
        this.cAA = str3;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        PbActivity pbActivity;
        if (TbadkCoreApplication.m411getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(this.cAy) && !StringUtils.isNull(this.cAz)) {
            if (!com.baidu.adp.lib.util.i.iP()) {
                pbActivity = this.cAx.cCy;
                pbActivity.showToast(n.i.neterror);
                return;
            }
            context = this.cAx.mContext;
            String format = String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", String.valueOf(this.cAy) + "," + this.cAz, this.cAA, this.cAA, context.getString(n.i.app_info_for_map));
            context2 = this.cAx.mContext;
            com.baidu.tbadk.browser.f.B(context2, format);
        }
    }
}
