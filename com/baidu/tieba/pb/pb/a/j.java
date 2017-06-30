package com.baidu.tieba.pb.pb.a;

import android.content.Context;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.w;
import com.xiaomi.mipush.sdk.Constants;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {
    final /* synthetic */ i etk;
    private final /* synthetic */ String etl;
    private final /* synthetic */ String etm;
    private final /* synthetic */ String etn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar, String str, String str2, String str3) {
        this.etk = iVar;
        this.etl = str;
        this.etm = str2;
        this.etn = str3;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        PbActivity pbActivity;
        if (TbadkCoreApplication.m9getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(this.etl) && !StringUtils.isNull(this.etm)) {
            if (!com.baidu.adp.lib.util.i.hj()) {
                pbActivity = this.etk.euf;
                pbActivity.showToast(w.l.neterror);
                return;
            }
            context = this.etk.mContext;
            String format = String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", String.valueOf(this.etl) + Constants.ACCEPT_TIME_SEPARATOR_SP + this.etm, this.etn, this.etn, context.getString(w.l.app_info_for_map));
            context2 = this.etk.mContext;
            com.baidu.tbadk.browser.g.T(context2, format);
        }
    }
}
