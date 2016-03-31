package com.baidu.tieba.tblauncher;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements View.OnClickListener {
    final /* synthetic */ aa etY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(aa aaVar) {
        this.etY = aaVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MainTabActivity mainTabActivity;
        TiebaStatic.log("c10821");
        String str = TbadkCoreApplication.m411getInst().getaDKillerUrl();
        if (!StringUtils.isNull(str)) {
            mainTabActivity = this.etY.etM;
            com.baidu.tbadk.browser.f.a(mainTabActivity.getPageContext().getPageActivity(), true, str);
        }
    }
}
