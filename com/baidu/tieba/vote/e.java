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
    private final /* synthetic */ String ehs;
    private final /* synthetic */ String eht;
    private final /* synthetic */ String ehu;
    final /* synthetic */ a fKD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar, String str, String str2, String str3) {
        this.fKD = aVar;
        this.ehs = str;
        this.eht = str2;
        this.ehu = str3;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        g gVar;
        PbActivity pbActivity;
        PbActivity pbActivity2;
        if (TbadkCoreApplication.m9getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(this.ehs) && !StringUtils.isNull(this.eht)) {
            if (i.hj()) {
                gVar = this.fKD.mContext;
                String format = String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", String.valueOf(this.ehs) + "," + this.eht, this.ehu, this.ehu, gVar.getString(w.l.app_info_for_map));
                pbActivity = this.fKD.eig;
                com.baidu.tbadk.browser.f.S(pbActivity.getPageContext().getPageActivity(), format);
                return;
            }
            pbActivity2 = this.fKD.eig;
            pbActivity2.showToast(w.l.neterror);
        }
    }
}
