package com.baidu.tieba.pb.main;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bl implements View.OnClickListener {
    private final /* synthetic */ String aFm;
    private final /* synthetic */ String aFo;
    final /* synthetic */ bi bzJ;
    private final /* synthetic */ String bzK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(bi biVar, String str, String str2, String str3) {
        this.bzJ = biVar;
        this.aFm = str;
        this.bzK = str2;
        this.aFo = str3;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbPageContext tbPageContext;
        TbPageContext tbPageContext2;
        TbPageContext tbPageContext3;
        if (TbadkCoreApplication.m255getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(this.aFm) && !StringUtils.isNull(this.bzK)) {
            if (!com.baidu.adp.lib.util.i.fg()) {
                tbPageContext3 = this.bzJ.mContext;
                tbPageContext3.showToast(com.baidu.tieba.z.neterror);
                return;
            }
            tbPageContext = this.bzJ.mContext;
            String format = String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", String.valueOf(this.aFm) + "," + this.bzK, this.aFo, this.aFo, tbPageContext.getString(com.baidu.tieba.z.app_info_for_map));
            tbPageContext2 = this.bzJ.mContext;
            com.baidu.tbadk.browser.a.y(tbPageContext2.getPageActivity(), format);
        }
    }
}
