package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class df implements View.OnClickListener {
    private final /* synthetic */ String eeM;
    private final /* synthetic */ String eeN;
    private final /* synthetic */ String eeO;
    final /* synthetic */ dc eiI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public df(dc dcVar, String str, String str2, String str3) {
        this.eiI = dcVar;
        this.eeM = str;
        this.eeN = str2;
        this.eeO = str3;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        if (TbadkCoreApplication.m9getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(this.eeM) && !StringUtils.isNull(this.eeN)) {
            if (com.baidu.adp.lib.util.i.hk()) {
                context = this.eiI.mContext;
                String format = String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", String.valueOf(this.eeM) + "," + this.eeN, this.eeO, this.eeO, context.getString(w.l.app_info_for_map));
                context2 = this.eiI.mContext;
                com.baidu.tbadk.browser.f.S(context2, format);
                return;
            }
            this.eiI.efF.showToast(w.l.neterror);
        }
    }
}
