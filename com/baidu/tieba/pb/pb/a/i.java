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
    final /* synthetic */ h ejl;
    private final /* synthetic */ String ejm;
    private final /* synthetic */ String ejn;
    private final /* synthetic */ String ejo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, String str, String str2, String str3) {
        this.ejl = hVar;
        this.ejm = str;
        this.ejn = str2;
        this.ejo = str3;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        PbActivity pbActivity;
        if (TbadkCoreApplication.m9getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(this.ejm) && !StringUtils.isNull(this.ejn)) {
            if (!com.baidu.adp.lib.util.i.he()) {
                pbActivity = this.ejl.eka;
                pbActivity.showToast(w.l.neterror);
                return;
            }
            context = this.ejl.mContext;
            String format = String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", String.valueOf(this.ejm) + "," + this.ejn, this.ejo, this.ejo, context.getString(w.l.app_info_for_map));
            context2 = this.ejl.mContext;
            com.baidu.tbadk.browser.f.O(context2, format);
        }
    }
}
