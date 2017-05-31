package com.baidu.tieba.pluginCenter;

import android.widget.TextView;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class h implements a.b {
    final /* synthetic */ PluginDetailActivity fcA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(PluginDetailActivity pluginDetailActivity) {
        this.fcA = pluginDetailActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        TextView textView;
        TextView textView2;
        PluginNetConfigInfos.PluginConfig pluginConfig;
        com.baidu.adp.plugin.packageManager.e eVar;
        textView = this.fcA.fcy;
        aq.c(textView, w.e.cp_cont_d, 1);
        textView2 = this.fcA.fcy;
        textView2.setEnabled(false);
        PluginPackageManager jx = PluginPackageManager.jx();
        pluginConfig = this.fcA.fcz;
        eVar = this.fcA.Er;
        jx.a(pluginConfig, eVar);
        aVar.dismiss();
    }
}
