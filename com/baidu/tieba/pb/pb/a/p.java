package com.baidu.tieba.pb.pb.a;

import android.content.Context;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.n;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    final /* synthetic */ n cEc;
    private final /* synthetic */ String cEd;
    private final /* synthetic */ String cEe;
    private final /* synthetic */ String cEf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(n nVar, String str, String str2, String str3) {
        this.cEc = nVar;
        this.cEd = str;
        this.cEe = str2;
        this.cEf = str3;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        PbActivity pbActivity;
        if (TbadkCoreApplication.m411getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(this.cEd) && !StringUtils.isNull(this.cEe)) {
            if (!com.baidu.adp.lib.util.i.iQ()) {
                pbActivity = this.cEc.cGj;
                pbActivity.showToast(n.j.neterror);
                return;
            }
            context = this.cEc.mContext;
            String format = String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", String.valueOf(this.cEd) + "," + this.cEe, this.cEf, this.cEf, context.getString(n.j.app_info_for_map));
            context2 = this.cEc.mContext;
            com.baidu.tbadk.browser.f.B(context2, format);
        }
    }
}
