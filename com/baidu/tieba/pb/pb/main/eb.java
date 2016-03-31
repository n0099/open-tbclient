package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class eb implements View.OnClickListener {
    private final /* synthetic */ String den;
    private final /* synthetic */ String deo;
    private final /* synthetic */ String dep;
    final /* synthetic */ dz djW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public eb(dz dzVar, String str, String str2, String str3) {
        this.djW = dzVar;
        this.den = str;
        this.deo = str2;
        this.dep = str3;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        if (TbadkCoreApplication.m411getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(this.den) && !StringUtils.isNull(this.deo)) {
            if (com.baidu.adp.lib.util.i.jf()) {
                context = this.djW.mContext;
                String format = String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", String.valueOf(this.den) + "," + this.deo, this.dep, this.dep, context.getString(t.j.app_info_for_map));
                context2 = this.djW.mContext;
                com.baidu.tbadk.browser.f.s(context2, format);
                return;
            }
            this.djW.dfw.showToast(t.j.neterror);
        }
    }
}
