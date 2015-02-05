package com.baidu.tieba.pb.main;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bl implements View.OnClickListener {
    private final /* synthetic */ String aGr;
    private final /* synthetic */ String aGt;
    final /* synthetic */ bi bBs;
    private final /* synthetic */ String bBt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(bi biVar, String str, String str2, String str3) {
        this.bBs = biVar;
        this.aGr = str;
        this.bBt = str2;
        this.aGt = str3;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbPageContext tbPageContext;
        TbPageContext tbPageContext2;
        TbPageContext tbPageContext3;
        if (TbadkCoreApplication.m255getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(this.aGr) && !StringUtils.isNull(this.bBt)) {
            if (!com.baidu.adp.lib.util.i.ff()) {
                tbPageContext3 = this.bBs.mContext;
                tbPageContext3.showToast(com.baidu.tieba.z.neterror);
                return;
            }
            tbPageContext = this.bBs.mContext;
            String format = String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", String.valueOf(this.aGr) + "," + this.bBt, this.aGt, this.aGt, tbPageContext.getString(com.baidu.tieba.z.app_info_for_map));
            tbPageContext2 = this.bBs.mContext;
            com.baidu.tbadk.browser.a.x(tbPageContext2.getPageActivity(), format);
        }
    }
}
