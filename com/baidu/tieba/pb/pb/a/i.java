package com.baidu.tieba.pb.pb.a;

import android.content.Context;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ h ejH;
    private final /* synthetic */ String ejI;
    private final /* synthetic */ String ejJ;
    private final /* synthetic */ String ejK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, String str, String str2, String str3) {
        this.ejH = hVar;
        this.ejI = str;
        this.ejJ = str2;
        this.ejK = str3;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        PbActivity pbActivity;
        if (TbadkCoreApplication.m9getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(this.ejI) && !StringUtils.isNull(this.ejJ)) {
            if (!com.baidu.adp.lib.util.i.hk()) {
                pbActivity = this.ejH.ekw;
                pbActivity.showToast(w.l.neterror);
                return;
            }
            context = this.ejH.mContext;
            String format = String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", String.valueOf(this.ejI) + "," + this.ejJ, this.ejK, this.ejK, context.getString(w.l.app_info_for_map));
            context2 = this.ejH.mContext;
            com.baidu.tbadk.browser.f.S(context2, format);
        }
    }
}
