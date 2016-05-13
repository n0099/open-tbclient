package com.baidu.tieba.tblauncher;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as implements View.OnClickListener {
    final /* synthetic */ ab exg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(ab abVar) {
        this.exg = abVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MainTabActivity mainTabActivity;
        TiebaStatic.log("c10821");
        String str = TbadkCoreApplication.m11getInst().getaDKillerUrl();
        if (!StringUtils.isNull(str)) {
            mainTabActivity = this.exg.ewR;
            com.baidu.tbadk.browser.f.a(mainTabActivity.getPageContext().getPageActivity(), true, str);
        }
    }
}
