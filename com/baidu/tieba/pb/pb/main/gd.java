package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class gd implements View.OnClickListener {
    private final /* synthetic */ String eeM;
    private final /* synthetic */ String eeN;
    private final /* synthetic */ String eeO;
    final /* synthetic */ fm epr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gd(fm fmVar, String str, String str2, String str3) {
        this.epr = fmVar;
        this.eeM = str;
        this.eeN = str2;
        this.eeO = str3;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        PbActivity pbActivity3;
        if (TbadkCoreApplication.m9getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(this.eeM) && !StringUtils.isNull(this.eeN)) {
            if (!com.baidu.adp.lib.util.i.hk()) {
                pbActivity3 = this.epr.efF;
                pbActivity3.showToast(w.l.neterror);
                return;
            }
            pbActivity = this.epr.efF;
            String format = String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", String.valueOf(this.eeM) + "," + this.eeN, this.eeO, this.eeO, pbActivity.getPageContext().getString(w.l.app_info_for_map));
            pbActivity2 = this.epr.efF;
            com.baidu.tbadk.browser.f.S(pbActivity2.getPageContext().getContext(), format);
        }
    }
}
