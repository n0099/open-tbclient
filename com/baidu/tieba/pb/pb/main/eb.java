package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class eb implements View.OnClickListener {
    private final /* synthetic */ String egu;
    private final /* synthetic */ String egv;
    private final /* synthetic */ String egw;
    final /* synthetic */ dx elZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public eb(dx dxVar, String str, String str2, String str3) {
        this.elZ = dxVar;
        this.egu = str;
        this.egv = str2;
        this.egw = str3;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        if (TbadkCoreApplication.m9getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(this.egu) && !StringUtils.isNull(this.egv)) {
            if (com.baidu.adp.lib.util.i.gk()) {
                context = this.elZ.mContext;
                String format = String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", String.valueOf(this.egu) + "," + this.egv, this.egw, this.egw, context.getString(r.l.app_info_for_map));
                context2 = this.elZ.mContext;
                com.baidu.tbadk.browser.f.u(context2, format);
                return;
            }
            this.elZ.ehi.showToast(r.l.neterror);
        }
    }
}
