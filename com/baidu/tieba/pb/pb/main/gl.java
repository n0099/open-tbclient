package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class gl implements View.OnClickListener {
    private final /* synthetic */ String ekm;
    private final /* synthetic */ String ekn;
    private final /* synthetic */ String eko;
    final /* synthetic */ fx evi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gl(fx fxVar, String str, String str2, String str3) {
        this.evi = fxVar;
        this.ekm = str;
        this.ekn = str2;
        this.eko = str3;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        PbActivity pbActivity3;
        if (TbadkCoreApplication.m9getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(this.ekm) && !StringUtils.isNull(this.ekn)) {
            if (!com.baidu.adp.lib.util.i.hk()) {
                pbActivity3 = this.evi.elf;
                pbActivity3.showToast(w.l.neterror);
                return;
            }
            pbActivity = this.evi.elf;
            String format = String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", String.valueOf(this.ekm) + "," + this.ekn, this.eko, this.eko, pbActivity.getPageContext().getString(w.l.app_info_for_map));
            pbActivity2 = this.evi.elf;
            com.baidu.tbadk.browser.f.S(pbActivity2.getPageContext().getContext(), format);
        }
    }
}
