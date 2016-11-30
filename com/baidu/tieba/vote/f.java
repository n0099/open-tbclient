package com.baidu.tieba.vote;

import android.view.View;
import com.baidu.adp.base.h;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    private final /* synthetic */ String ets;
    private final /* synthetic */ String ett;
    private final /* synthetic */ String etu;
    final /* synthetic */ b ggH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(b bVar, String str, String str2, String str3) {
        this.ggH = bVar;
        this.ets = str;
        this.ett = str2;
        this.etu = str3;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        h hVar;
        PbActivity pbActivity;
        PbActivity pbActivity2;
        if (TbadkCoreApplication.m9getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(this.ets) && !StringUtils.isNull(this.ett)) {
            if (i.gm()) {
                hVar = this.ggH.mContext;
                String format = String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", String.valueOf(this.ets) + "," + this.ett, this.etu, this.etu, hVar.getString(r.j.app_info_for_map));
                pbActivity = this.ggH.eug;
                com.baidu.tbadk.browser.f.u(pbActivity.getPageContext().getPageActivity(), format);
                return;
            }
            pbActivity2 = this.ggH.eug;
            pbActivity2.showToast(r.j.neterror);
        }
    }
}
