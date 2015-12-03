package com.baidu.tieba.themeCenter;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements a.b {
    private final /* synthetic */ TbPageContext Sn;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a bvu;
    private final /* synthetic */ String dEe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(com.baidu.tbadk.core.dialog.a aVar, String str, TbPageContext tbPageContext) {
        this.bvu = aVar;
        this.dEe = str;
        this.Sn = tbPageContext;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.bvu.dismiss();
        if (this.dEe != null) {
            TbadkCoreApplication.m411getInst().setThemeWebviewOpen(true);
            com.baidu.tbadk.browser.f.C(this.Sn.getPageActivity(), this.dEe);
        }
    }
}
