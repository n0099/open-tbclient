package com.baidu.tieba.pb.pb.a;

import android.content.Context;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements View.OnClickListener {
    final /* synthetic */ u etr;
    private final /* synthetic */ String ets;
    private final /* synthetic */ String ett;
    private final /* synthetic */ String etu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar, String str, String str2, String str3) {
        this.etr = uVar;
        this.ets = str;
        this.ett = str2;
        this.etu = str3;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        PbActivity pbActivity;
        if (TbadkCoreApplication.m9getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(this.ets) && !StringUtils.isNull(this.ett)) {
            if (!com.baidu.adp.lib.util.i.gm()) {
                pbActivity = this.etr.eug;
                pbActivity.showToast(r.j.neterror);
                return;
            }
            context = this.etr.mContext;
            String format = String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", String.valueOf(this.ets) + "," + this.ett, this.etu, this.etu, context.getString(r.j.app_info_for_map));
            context2 = this.etr.mContext;
            com.baidu.tbadk.browser.f.u(context2, format);
        }
    }
}
