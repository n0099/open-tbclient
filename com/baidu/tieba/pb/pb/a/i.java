package com.baidu.tieba.pb.pb.a;

import android.content.Context;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ h ehr;
    private final /* synthetic */ String ehs;
    private final /* synthetic */ String eht;
    private final /* synthetic */ String ehu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, String str, String str2, String str3) {
        this.ehr = hVar;
        this.ehs = str;
        this.eht = str2;
        this.ehu = str3;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        PbActivity pbActivity;
        if (TbadkCoreApplication.m9getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(this.ehs) && !StringUtils.isNull(this.eht)) {
            if (!com.baidu.adp.lib.util.i.hj()) {
                pbActivity = this.ehr.eig;
                pbActivity.showToast(w.l.neterror);
                return;
            }
            context = this.ehr.mContext;
            String format = String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", String.valueOf(this.ehs) + "," + this.eht, this.ehu, this.ehu, context.getString(w.l.app_info_for_map));
            context2 = this.ehr.mContext;
            com.baidu.tbadk.browser.f.S(context2, format);
        }
    }
}
