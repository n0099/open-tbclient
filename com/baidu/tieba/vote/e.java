package com.baidu.tieba.vote;

import android.view.View;
import com.baidu.adp.base.g;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.w;
import com.xiaomi.mipush.sdk.Constants;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    private final /* synthetic */ String etl;
    private final /* synthetic */ String etm;
    private final /* synthetic */ String etn;
    final /* synthetic */ a gby;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar, String str, String str2, String str3) {
        this.gby = aVar;
        this.etl = str;
        this.etm = str2;
        this.etn = str3;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        g gVar;
        PbActivity pbActivity;
        PbActivity pbActivity2;
        if (TbadkCoreApplication.m9getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(this.etl) && !StringUtils.isNull(this.etm)) {
            if (i.hj()) {
                gVar = this.gby.mContext;
                String format = String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", String.valueOf(this.etl) + Constants.ACCEPT_TIME_SEPARATOR_SP + this.etm, this.etn, this.etn, gVar.getString(w.l.app_info_for_map));
                pbActivity = this.gby.euf;
                com.baidu.tbadk.browser.g.T(pbActivity.getPageContext().getPageActivity(), format);
                return;
            }
            pbActivity2 = this.gby.euf;
            pbActivity2.showToast(w.l.neterror);
        }
    }
}
