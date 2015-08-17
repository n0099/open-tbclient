package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bt implements View.OnClickListener {
    final /* synthetic */ br ccK;
    private final /* synthetic */ String ccL;
    private final /* synthetic */ String ccM;
    private final /* synthetic */ String ccN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bt(br brVar, String str, String str2, String str3) {
        this.ccK = brVar;
        this.ccL = str;
        this.ccM = str2;
        this.ccN = str3;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        if (TbadkCoreApplication.m411getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(this.ccL) && !StringUtils.isNull(this.ccM)) {
            if (com.baidu.adp.lib.util.i.iO()) {
                context = this.ccK.mContext;
                String format = String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", String.valueOf(this.ccL) + "," + this.ccM, this.ccN, this.ccN, context.getString(i.C0057i.app_info_for_map));
                context2 = this.ccK.mContext;
                com.baidu.tbadk.browser.f.B(context2, format);
                return;
            }
            this.ccK.cbx.showToast(i.C0057i.neterror);
        }
    }
}
