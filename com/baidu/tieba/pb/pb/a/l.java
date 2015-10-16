package com.baidu.tieba.pb.pb.a;

import android.content.Context;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.i;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    private final /* synthetic */ String cgZ;
    final /* synthetic */ k chO;
    private final /* synthetic */ String cha;
    private final /* synthetic */ String chb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar, String str, String str2, String str3) {
        this.chO = kVar;
        this.cgZ = str;
        this.cha = str2;
        this.chb = str3;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        PbActivity pbActivity;
        if (TbadkCoreApplication.m411getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(this.cgZ) && !StringUtils.isNull(this.cha)) {
            if (!com.baidu.adp.lib.util.i.iM()) {
                pbActivity = this.chO.ciU;
                pbActivity.showToast(i.h.neterror);
                return;
            }
            context = this.chO.mContext;
            String format = String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", String.valueOf(this.cgZ) + "," + this.cha, this.chb, this.chb, context.getString(i.h.app_info_for_map));
            context2 = this.chO.mContext;
            com.baidu.tbadk.browser.g.B(context2, format);
        }
    }
}
