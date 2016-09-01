package com.baidu.tieba.pb.pb.a;

import android.content.Context;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements View.OnClickListener {
    final /* synthetic */ z elE;
    private final /* synthetic */ String elf;
    private final /* synthetic */ String elg;
    private final /* synthetic */ String elh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(z zVar, String str, String str2, String str3) {
        this.elE = zVar;
        this.elf = str;
        this.elg = str2;
        this.elh = str3;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        PbActivity pbActivity;
        if (TbadkCoreApplication.m9getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(this.elf) && !StringUtils.isNull(this.elg)) {
            if (!com.baidu.adp.lib.util.i.gm()) {
                pbActivity = this.elE.emy;
                pbActivity.showToast(t.j.neterror);
                return;
            }
            context = this.elE.mContext;
            String format = String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", String.valueOf(this.elf) + "," + this.elg, this.elh, this.elh, context.getString(t.j.app_info_for_map));
            context2 = this.elE.mContext;
            com.baidu.tbadk.browser.f.u(context2, format);
        }
    }
}
