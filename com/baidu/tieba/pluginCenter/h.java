package com.baidu.tieba.pluginCenter;

import android.widget.TextView;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements a.b {
    final /* synthetic */ PluginDetailActivity djj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(PluginDetailActivity pluginDetailActivity) {
        this.djj = pluginDetailActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        TextView textView;
        TextView textView2;
        PluginNetConfigInfos.PluginConfig pluginConfig;
        com.baidu.adp.plugin.packageManager.e eVar;
        textView = this.djj.djh;
        as.b(textView, n.d.cp_cont_d, 1);
        textView2 = this.djj.djh;
        textView2.setEnabled(false);
        PluginPackageManager ls = PluginPackageManager.ls();
        pluginConfig = this.djj.dji;
        eVar = this.djj.Eh;
        ls.a(pluginConfig, eVar);
        aVar.dismiss();
    }
}
