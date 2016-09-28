package com.baidu.tieba.pb.pb.a;

import android.content.Context;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    final /* synthetic */ e emY;
    private final /* synthetic */ String enc;
    private final /* synthetic */ String ene;
    private final /* synthetic */ String enf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(e eVar, String str, String str2, String str3) {
        this.emY = eVar;
        this.enc = str;
        this.ene = str2;
        this.enf = str3;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        PbActivity pbActivity;
        if (TbadkCoreApplication.m9getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(this.enc) && !StringUtils.isNull(this.ene)) {
            if (!com.baidu.adp.lib.util.i.gm()) {
                pbActivity = this.emY.eow;
                com.baidu.adp.lib.util.k.showToast(pbActivity.getPageContext().getPageActivity(), r.j.neterror);
                return;
            }
            context = this.emY.mContext;
            String format = String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", String.valueOf(this.enc) + "," + this.ene, this.enf, this.enf, context.getString(r.j.app_info_for_map));
            context2 = this.emY.mContext;
            com.baidu.tbadk.browser.f.u(context2, format);
        }
    }
}
