package com.baidu.tieba.tblauncher;

import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.tblauncher.au;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av implements a.b {
    private final /* synthetic */ TbPageContext QC;
    private final /* synthetic */ PluginNetConfigInfos.PluginConfig caw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(TbPageContext tbPageContext, PluginNetConfigInfos.PluginConfig pluginConfig) {
        this.QC = tbPageContext;
        this.caw = pluginConfig;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        au.a aVar2;
        au.a aVar3;
        String str;
        String str2;
        au.a aVar4;
        au.a aVar5;
        aVar.dismiss();
        au.q(this.QC);
        aVar2 = au.fzh;
        if (aVar2 == null) {
            au.fzh = new au.a(null);
        }
        aVar3 = au.fzh;
        TbPageContext tbPageContext = this.QC;
        str = au.mForumId;
        str2 = au.mForumName;
        aVar3.d(tbPageContext, str, str2);
        if (PluginPackageManager.jx().bh(XiaoyingUtil.PKG_NAME_VIDEO)) {
            PluginPackageManager jx = PluginPackageManager.jx();
            aVar5 = au.fzh;
            jx.a(aVar5);
            return;
        }
        PluginPackageManager jx2 = PluginPackageManager.jx();
        PluginNetConfigInfos.PluginConfig pluginConfig = this.caw;
        aVar4 = au.fzh;
        jx2.a(pluginConfig, aVar4);
    }
}
