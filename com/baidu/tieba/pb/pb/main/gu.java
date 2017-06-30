package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.w;
import com.xiaomi.mipush.sdk.Constants;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class gu implements View.OnClickListener {
    final /* synthetic */ gg eEv;
    private final /* synthetic */ String etl;
    private final /* synthetic */ String etm;
    private final /* synthetic */ String etn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gu(gg ggVar, String str, String str2, String str3) {
        this.eEv = ggVar;
        this.etl = str;
        this.etm = str2;
        this.etn = str3;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        PbActivity pbActivity3;
        if (TbadkCoreApplication.m9getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(this.etl) && !StringUtils.isNull(this.etm)) {
            if (!com.baidu.adp.lib.util.i.hj()) {
                pbActivity3 = this.eEv.euf;
                pbActivity3.showToast(w.l.neterror);
                return;
            }
            pbActivity = this.eEv.euf;
            String format = String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", String.valueOf(this.etl) + Constants.ACCEPT_TIME_SEPARATOR_SP + this.etm, this.etn, this.etn, pbActivity.getPageContext().getString(w.l.app_info_for_map));
            pbActivity2 = this.eEv.euf;
            com.baidu.tbadk.browser.g.T(pbActivity2.getPageContext().getContext(), format);
        }
    }
}
