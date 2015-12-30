package com.baidu.tieba.themeCenter;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements a.b {
    private final /* synthetic */ TbPageContext SL;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a bzl;
    private final /* synthetic */ String dLI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(com.baidu.tbadk.core.dialog.a aVar, String str, TbPageContext tbPageContext) {
        this.bzl = aVar;
        this.dLI = str;
        this.SL = tbPageContext;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.bzl.dismiss();
        if (this.dLI != null) {
            TbadkCoreApplication.m411getInst().setThemeWebviewOpen(true);
            com.baidu.tbadk.browser.f.C(this.SL.getPageActivity(), this.dLI);
        }
    }
}
