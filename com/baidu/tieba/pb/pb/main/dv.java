package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dv implements View.OnClickListener {
    private final /* synthetic */ String elf;
    private final /* synthetic */ String elg;
    private final /* synthetic */ String elh;
    final /* synthetic */ du eqD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dv(du duVar, String str, String str2, String str3) {
        this.eqD = duVar;
        this.elf = str;
        this.elg = str2;
        this.elh = str3;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        if (TbadkCoreApplication.m9getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(this.elf) && !StringUtils.isNull(this.elg)) {
            if (com.baidu.adp.lib.util.i.gm()) {
                context = this.eqD.mContext;
                String format = String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", String.valueOf(this.elf) + "," + this.elg, this.elh, this.elh, context.getString(t.j.app_info_for_map));
                context2 = this.eqD.mContext;
                com.baidu.tbadk.browser.f.u(context2, format);
                return;
            }
            this.eqD.emy.showToast(t.j.neterror);
        }
    }
}
