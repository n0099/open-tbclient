package com.baidu.tieba.pluginCenter;

import android.widget.TextView;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements a.b {
    final /* synthetic */ PluginDetailActivity eDX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(PluginDetailActivity pluginDetailActivity) {
        this.eDX = pluginDetailActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        TextView textView;
        TextView textView2;
        PluginNetConfigInfos.PluginConfig pluginConfig;
        com.baidu.adp.plugin.packageManager.e eVar;
        textView = this.eDX.eDV;
        av.c(textView, u.d.cp_cont_d, 1);
        textView2 = this.eDX.eDV;
        textView2.setEnabled(false);
        PluginPackageManager hH = PluginPackageManager.hH();
        pluginConfig = this.eDX.eDW;
        eVar = this.eDX.uV;
        hH.a(pluginConfig, eVar);
        aVar.dismiss();
    }
}
