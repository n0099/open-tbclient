package com.baidu.tieba.vote;

import android.view.View;
import com.baidu.adp.base.g;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    private final /* synthetic */ String eeM;
    private final /* synthetic */ String eeN;
    private final /* synthetic */ String eeO;
    final /* synthetic */ a fJL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar, String str, String str2, String str3) {
        this.fJL = aVar;
        this.eeM = str;
        this.eeN = str2;
        this.eeO = str3;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        g gVar;
        PbActivity pbActivity;
        PbActivity pbActivity2;
        if (TbadkCoreApplication.m9getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(this.eeM) && !StringUtils.isNull(this.eeN)) {
            if (i.hk()) {
                gVar = this.fJL.mContext;
                String format = String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", String.valueOf(this.eeM) + "," + this.eeN, this.eeO, this.eeO, gVar.getString(w.l.app_info_for_map));
                pbActivity = this.fJL.efF;
                com.baidu.tbadk.browser.f.S(pbActivity.getPageContext().getPageActivity(), format);
                return;
            }
            pbActivity2 = this.fJL.efF;
            pbActivity2.showToast(w.l.neterror);
        }
    }
}
