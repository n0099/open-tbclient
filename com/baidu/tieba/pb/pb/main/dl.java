package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dl implements View.OnClickListener {
    private final /* synthetic */ String ekm;
    private final /* synthetic */ String ekn;
    private final /* synthetic */ String eko;
    final /* synthetic */ dh eor;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dl(dh dhVar, String str, String str2, String str3) {
        this.eor = dhVar;
        this.ekm = str;
        this.ekn = str2;
        this.eko = str3;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        if (TbadkCoreApplication.m9getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(this.ekm) && !StringUtils.isNull(this.ekn)) {
            if (com.baidu.adp.lib.util.i.hk()) {
                context = this.eor.mContext;
                String format = String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", String.valueOf(this.ekm) + "," + this.ekn, this.eko, this.eko, context.getString(w.l.app_info_for_map));
                context2 = this.eor.mContext;
                com.baidu.tbadk.browser.f.S(context2, format);
                return;
            }
            this.eor.elf.showToast(w.l.neterror);
        }
    }
}
