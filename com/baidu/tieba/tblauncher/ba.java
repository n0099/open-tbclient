package com.baidu.tieba.tblauncher;

import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.tblauncher.az;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ba implements a.b {
    private final /* synthetic */ TbPageContext Qp;
    private final /* synthetic */ PluginNetConfigInfos.PluginConfig cgI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(TbPageContext tbPageContext, PluginNetConfigInfos.PluginConfig pluginConfig) {
        this.Qp = tbPageContext;
        this.cgI = pluginConfig;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        az.a aVar2;
        az.a aVar3;
        String str;
        String str2;
        az.a aVar4;
        az.a aVar5;
        aVar.dismiss();
        az.p(this.Qp);
        aVar2 = az.fHc;
        if (aVar2 == null) {
            az.fHc = new az.a(null);
        }
        aVar3 = az.fHc;
        TbPageContext tbPageContext = this.Qp;
        str = az.mForumId;
        str2 = az.mForumName;
        aVar3.d(tbPageContext, str, str2);
        if (PluginPackageManager.jx().bh(XiaoyingUtil.PKG_NAME_VIDEO)) {
            PluginPackageManager jx = PluginPackageManager.jx();
            aVar5 = az.fHc;
            jx.a(aVar5);
            return;
        }
        PluginPackageManager jx2 = PluginPackageManager.jx();
        PluginNetConfigInfos.PluginConfig pluginConfig = this.cgI;
        aVar4 = az.fHc;
        jx2.a(pluginConfig, aVar4);
    }
}
