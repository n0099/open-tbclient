package com.baidu.tieba.vote;

import android.view.View;
import com.baidu.adp.base.g;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    private final /* synthetic */ String egu;
    private final /* synthetic */ String egv;
    private final /* synthetic */ String egw;
    final /* synthetic */ a fEt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar, String str, String str2, String str3) {
        this.fEt = aVar;
        this.egu = str;
        this.egv = str2;
        this.egw = str3;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        g gVar;
        PbActivity pbActivity;
        PbActivity pbActivity2;
        if (TbadkCoreApplication.m9getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(this.egu) && !StringUtils.isNull(this.egv)) {
            if (i.gk()) {
                gVar = this.fEt.mContext;
                String format = String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", String.valueOf(this.egu) + "," + this.egv, this.egw, this.egw, gVar.getString(r.l.app_info_for_map));
                pbActivity = this.fEt.ehi;
                com.baidu.tbadk.browser.f.u(pbActivity.getPageContext().getPageActivity(), format);
                return;
            }
            pbActivity2 = this.fEt.ehi;
            pbActivity2.showToast(r.l.neterror);
        }
    }
}
