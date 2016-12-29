package com.baidu.tieba.pb.pb.a;

import android.content.Context;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements View.OnClickListener {
    final /* synthetic */ t dXM;
    private final /* synthetic */ String dXN;
    private final /* synthetic */ String dXO;
    private final /* synthetic */ String dXP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar, String str, String str2, String str3) {
        this.dXM = tVar;
        this.dXN = str;
        this.dXO = str2;
        this.dXP = str3;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        PbActivity pbActivity;
        if (TbadkCoreApplication.m9getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(this.dXN) && !StringUtils.isNull(this.dXO)) {
            if (!com.baidu.adp.lib.util.i.gm()) {
                pbActivity = this.dXM.dYB;
                pbActivity.showToast(r.j.neterror);
                return;
            }
            context = this.dXM.mContext;
            String format = String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", String.valueOf(this.dXN) + "," + this.dXO, this.dXP, this.dXP, context.getString(r.j.app_info_for_map));
            context2 = this.dXM.mContext;
            com.baidu.tbadk.browser.f.u(context2, format);
        }
    }
}
