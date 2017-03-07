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
    private final /* synthetic */ String ejm;
    private final /* synthetic */ String ejn;
    private final /* synthetic */ String ejo;
    final /* synthetic */ a fIU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar, String str, String str2, String str3) {
        this.fIU = aVar;
        this.ejm = str;
        this.ejn = str2;
        this.ejo = str3;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        g gVar;
        PbActivity pbActivity;
        PbActivity pbActivity2;
        if (TbadkCoreApplication.m9getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(this.ejm) && !StringUtils.isNull(this.ejn)) {
            if (i.he()) {
                gVar = this.fIU.mContext;
                String format = String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", String.valueOf(this.ejm) + "," + this.ejn, this.ejo, this.ejo, gVar.getString(w.l.app_info_for_map));
                pbActivity = this.fIU.eka;
                com.baidu.tbadk.browser.f.O(pbActivity.getPageContext().getPageActivity(), format);
                return;
            }
            pbActivity2 = this.fIU.eka;
            pbActivity2.showToast(w.l.neterror);
        }
    }
}
