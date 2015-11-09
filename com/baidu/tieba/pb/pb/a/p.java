package com.baidu.tieba.pb.pb.a;

import android.content.Context;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.i;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    final /* synthetic */ n cia;
    private final /* synthetic */ String cib;
    private final /* synthetic */ String cic;
    private final /* synthetic */ String cie;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(n nVar, String str, String str2, String str3) {
        this.cia = nVar;
        this.cib = str;
        this.cic = str2;
        this.cie = str3;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        PbActivity pbActivity;
        if (TbadkCoreApplication.m411getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(this.cib) && !StringUtils.isNull(this.cic)) {
            if (!com.baidu.adp.lib.util.i.iN()) {
                pbActivity = this.cia.cjZ;
                pbActivity.showToast(i.h.neterror);
                return;
            }
            context = this.cia.mContext;
            String format = String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", String.valueOf(this.cib) + "," + this.cic, this.cie, this.cie, context.getString(i.h.app_info_for_map));
            context2 = this.cia.mContext;
            com.baidu.tbadk.browser.g.B(context2, format);
        }
    }
}
