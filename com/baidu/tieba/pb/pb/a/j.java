package com.baidu.tieba.pb.pb.a;

import android.content.Context;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {
    final /* synthetic */ i ekl;
    private final /* synthetic */ String ekm;
    private final /* synthetic */ String ekn;
    private final /* synthetic */ String eko;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar, String str, String str2, String str3) {
        this.ekl = iVar;
        this.ekm = str;
        this.ekn = str2;
        this.eko = str3;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        PbActivity pbActivity;
        if (TbadkCoreApplication.m9getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(this.ekm) && !StringUtils.isNull(this.ekn)) {
            if (!com.baidu.adp.lib.util.i.hk()) {
                pbActivity = this.ekl.elf;
                pbActivity.showToast(w.l.neterror);
                return;
            }
            context = this.ekl.mContext;
            String format = String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", String.valueOf(this.ekm) + "," + this.ekn, this.eko, this.eko, context.getString(w.l.app_info_for_map));
            context2 = this.ekl.mContext;
            com.baidu.tbadk.browser.f.S(context2, format);
        }
    }
}
