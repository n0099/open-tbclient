package com.baidu.tieba.pluginCenter;

import android.widget.TextView;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements a.b {
    final /* synthetic */ PluginDetailActivity coj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PluginDetailActivity pluginDetailActivity) {
        this.coj = pluginDetailActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        TextView textView;
        TextView textView2;
        PluginNetConfigInfos.PluginConfig pluginConfig;
        com.baidu.adp.plugin.packageManager.d dVar;
        textView = this.coj.cog;
        al.b(textView, i.c.cp_cont_d, 1);
        textView2 = this.coj.cog;
        textView2.setEnabled(false);
        PluginPackageManager lT = PluginPackageManager.lT();
        pluginConfig = this.coj.coh;
        dVar = this.coj.DA;
        lT.a(pluginConfig, dVar);
        aVar.dismiss();
    }
}
