package com.baidu.tieba.write;

import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.write.q;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements a.b {
    private final /* synthetic */ TbPageContext Qj;
    private final /* synthetic */ PluginNetConfigInfos.PluginConfig coY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(TbPageContext tbPageContext, PluginNetConfigInfos.PluginConfig pluginConfig) {
        this.Qj = tbPageContext;
        this.coY = pluginConfig;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        q.a aVar2;
        q.a aVar3;
        String str;
        String str2;
        q.a aVar4;
        q.a aVar5;
        aVar.dismiss();
        q.p(this.Qj);
        aVar2 = q.gdY;
        if (aVar2 == null) {
            q.gdY = new q.a(null);
        }
        aVar3 = q.gdY;
        TbPageContext tbPageContext = this.Qj;
        str = q.mForumId;
        str2 = q.mForumName;
        aVar3.d(tbPageContext, str, str2);
        if (PluginPackageManager.jw().bm(XiaoyingUtil.PKG_NAME_VIDEO)) {
            PluginPackageManager jw = PluginPackageManager.jw();
            aVar5 = q.gdY;
            jw.a(aVar5);
            return;
        }
        PluginPackageManager jw2 = PluginPackageManager.jw();
        PluginNetConfigInfos.PluginConfig pluginConfig = this.coY;
        aVar4 = q.gdY;
        jw2.a(pluginConfig, aVar4);
    }
}
