package com.baidu.tieba.pb.pb.a;

import android.content.Context;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.i;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ a cgN;
    private final /* synthetic */ String cgO;
    private final /* synthetic */ String cgP;
    private final /* synthetic */ String cgQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, String str, String str2, String str3) {
        this.cgN = aVar;
        this.cgO = str;
        this.cgP = str2;
        this.cgQ = str3;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        PbActivity pbActivity;
        if (TbadkCoreApplication.m411getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(this.cgO) && !StringUtils.isNull(this.cgP)) {
            if (!com.baidu.adp.lib.util.i.iM()) {
                pbActivity = this.cgN.ciJ;
                pbActivity.showToast(i.h.neterror);
                return;
            }
            context = this.cgN.mContext;
            String format = String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", String.valueOf(this.cgO) + "," + this.cgP, this.cgQ, this.cgQ, context.getString(i.h.app_info_for_map));
            context2 = this.cgN.mContext;
            com.baidu.tbadk.browser.g.B(context2, format);
        }
    }
}
