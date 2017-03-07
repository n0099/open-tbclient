package com.baidu.tieba.pluginCenter;

import android.widget.TextView;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements a.b {
    final /* synthetic */ PluginDetailActivity eXp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(PluginDetailActivity pluginDetailActivity) {
        this.eXp = pluginDetailActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        TextView textView;
        TextView textView2;
        PluginNetConfigInfos.PluginConfig pluginConfig;
        com.baidu.adp.plugin.packageManager.e eVar;
        textView = this.eXp.eXn;
        aq.c(textView, w.e.cp_cont_d, 1);
        textView2 = this.eXp.eXn;
        textView2.setEnabled(false);
        PluginPackageManager jt = PluginPackageManager.jt();
        pluginConfig = this.eXp.eXo;
        eVar = this.eXp.EN;
        jt.a(pluginConfig, eVar);
        aVar.dismiss();
    }
}
