package com.baidu.tieba.pb.pb.a;

import android.content.Context;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements View.OnClickListener {
    private final /* synthetic */ String cKW;
    private final /* synthetic */ String cKX;
    private final /* synthetic */ String cKY;
    final /* synthetic */ an cLv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(an anVar, String str, String str2, String str3) {
        this.cLv = anVar;
        this.cKW = str;
        this.cKX = str2;
        this.cKY = str3;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        PbActivity pbActivity;
        if (TbadkCoreApplication.m411getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(this.cKW) && !StringUtils.isNull(this.cKX)) {
            if (!com.baidu.adp.lib.util.i.iZ()) {
                pbActivity = this.cLv.cNL;
                pbActivity.showToast(t.j.neterror);
                return;
            }
            context = this.cLv.mContext;
            String format = String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", String.valueOf(this.cKW) + "," + this.cKX, this.cKY, this.cKY, context.getString(t.j.app_info_for_map));
            context2 = this.cLv.mContext;
            com.baidu.tbadk.browser.f.B(context2, format);
        }
    }
}
