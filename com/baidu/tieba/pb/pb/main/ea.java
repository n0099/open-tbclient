package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ea implements View.OnClickListener {
    private final /* synthetic */ String ejI;
    private final /* synthetic */ String ejJ;
    private final /* synthetic */ String ejK;
    final /* synthetic */ dw epw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ea(dw dwVar, String str, String str2, String str3) {
        this.epw = dwVar;
        this.ejI = str;
        this.ejJ = str2;
        this.ejK = str3;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        if (TbadkCoreApplication.m9getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(this.ejI) && !StringUtils.isNull(this.ejJ)) {
            if (com.baidu.adp.lib.util.i.hk()) {
                context = this.epw.mContext;
                String format = String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", String.valueOf(this.ejI) + "," + this.ejJ, this.ejK, this.ejK, context.getString(w.l.app_info_for_map));
                context2 = this.epw.mContext;
                com.baidu.tbadk.browser.f.S(context2, format);
                return;
            }
            this.epw.ekw.showToast(w.l.neterror);
        }
    }
}
