package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cj implements View.OnClickListener {
    private final /* synthetic */ String cib;
    private final /* synthetic */ String cic;
    private final /* synthetic */ String cie;
    final /* synthetic */ ch cln;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cj(ch chVar, String str, String str2, String str3) {
        this.cln = chVar;
        this.cib = str;
        this.cic = str2;
        this.cie = str3;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        if (TbadkCoreApplication.m411getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(this.cib) && !StringUtils.isNull(this.cic)) {
            if (com.baidu.adp.lib.util.i.iN()) {
                context = this.cln.mContext;
                String format = String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", String.valueOf(this.cib) + "," + this.cic, this.cie, this.cie, context.getString(i.h.app_info_for_map));
                context2 = this.cln.mContext;
                com.baidu.tbadk.browser.g.B(context2, format);
                return;
            }
            this.cln.cjZ.showToast(i.h.neterror);
        }
    }
}
