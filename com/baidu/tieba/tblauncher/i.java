package com.baidu.tieba.tblauncher;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class i implements a.b {
    final /* synthetic */ g fGJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar) {
        this.fGJ = gVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        String string = com.baidu.tbadk.core.sharedPref.b.um().getString("across_forum_theme_id", "");
        if (!StringUtils.isNull(string)) {
            TbadkCoreApplication.m9getInst().setUsedTheme(com.baidu.adp.lib.h.b.g(string, 0), 0);
        }
        aVar.dismiss();
    }
}
