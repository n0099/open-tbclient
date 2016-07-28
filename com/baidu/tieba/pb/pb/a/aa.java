package com.baidu.tieba.pb.pb.a;

import android.content.Context;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements View.OnClickListener {
    final /* synthetic */ z dZA;
    private final /* synthetic */ String dZb;
    private final /* synthetic */ String dZc;
    private final /* synthetic */ String dZd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(z zVar, String str, String str2, String str3) {
        this.dZA = zVar;
        this.dZb = str;
        this.dZc = str2;
        this.dZd = str3;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        PbActivity pbActivity;
        if (TbadkCoreApplication.m10getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(this.dZb) && !StringUtils.isNull(this.dZc)) {
            if (!com.baidu.adp.lib.util.i.fq()) {
                pbActivity = this.dZA.eat;
                pbActivity.showToast(u.j.neterror);
                return;
            }
            context = this.dZA.mContext;
            String format = String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", String.valueOf(this.dZb) + "," + this.dZc, this.dZd, this.dZd, context.getString(u.j.app_info_for_map));
            context2 = this.dZA.mContext;
            com.baidu.tbadk.browser.f.u(context2, format);
        }
    }
}
