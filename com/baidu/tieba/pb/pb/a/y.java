package com.baidu.tieba.pb.pb.a;

import android.content.Context;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements View.OnClickListener {
    final /* synthetic */ r dgC;
    private final /* synthetic */ String dgG;
    private final /* synthetic */ String dgH;
    private final /* synthetic */ String dgI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(r rVar, String str, String str2, String str3) {
        this.dgC = rVar;
        this.dgG = str;
        this.dgH = str2;
        this.dgI = str3;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        if (TbadkCoreApplication.m11getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(this.dgG) && !StringUtils.isNull(this.dgH)) {
            if (!com.baidu.adp.lib.util.i.fq()) {
                com.baidu.adp.lib.util.k.showToast(this.dgC.dhY.getPageContext().getPageActivity(), t.j.neterror);
                return;
            }
            context = this.dgC.mContext;
            String format = String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", String.valueOf(this.dgG) + "," + this.dgH, this.dgI, this.dgI, context.getString(t.j.app_info_for_map));
            context2 = this.dgC.mContext;
            com.baidu.tbadk.browser.f.t(context2, format);
        }
    }
}
