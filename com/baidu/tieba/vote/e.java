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
    private final /* synthetic */ String ekm;
    private final /* synthetic */ String ekn;
    private final /* synthetic */ String eko;
    final /* synthetic */ a fRs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar, String str, String str2, String str3) {
        this.fRs = aVar;
        this.ekm = str;
        this.ekn = str2;
        this.eko = str3;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        g gVar;
        PbActivity pbActivity;
        PbActivity pbActivity2;
        if (TbadkCoreApplication.m9getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(this.ekm) && !StringUtils.isNull(this.ekn)) {
            if (i.hk()) {
                gVar = this.fRs.mContext;
                String format = String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", String.valueOf(this.ekm) + "," + this.ekn, this.eko, this.eko, gVar.getString(w.l.app_info_for_map));
                pbActivity = this.fRs.elf;
                com.baidu.tbadk.browser.f.S(pbActivity.getPageContext().getPageActivity(), format);
                return;
            }
            pbActivity2 = this.fRs.elf;
            pbActivity2.showToast(w.l.neterror);
        }
    }
}
