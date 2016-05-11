package com.baidu.tieba.pluginCenter;

import android.widget.TextView;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements a.b {
    final /* synthetic */ PluginDetailActivity dUC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(PluginDetailActivity pluginDetailActivity) {
        this.dUC = pluginDetailActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        TextView textView;
        TextView textView2;
        PluginNetConfigInfos.PluginConfig pluginConfig;
        com.baidu.adp.plugin.packageManager.e eVar;
        textView = this.dUC.dUA;
        at.c(textView, t.d.cp_cont_d, 1);
        textView2 = this.dUC.dUA;
        textView2.setEnabled(false);
        PluginPackageManager hF = PluginPackageManager.hF();
        pluginConfig = this.dUC.dUB;
        eVar = this.dUC.uT;
        hF.a(pluginConfig, eVar);
        aVar.dismiss();
    }
}
