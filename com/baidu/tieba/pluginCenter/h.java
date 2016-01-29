package com.baidu.tieba.pluginCenter;

import android.widget.TextView;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements a.b {
    final /* synthetic */ PluginDetailActivity dxd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(PluginDetailActivity pluginDetailActivity) {
        this.dxd = pluginDetailActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        TextView textView;
        TextView textView2;
        PluginNetConfigInfos.PluginConfig pluginConfig;
        com.baidu.adp.plugin.packageManager.e eVar;
        textView = this.dxd.dxb;
        ar.b(textView, t.d.cp_cont_d, 1);
        textView2 = this.dxd.dxb;
        textView2.setEnabled(false);
        PluginPackageManager lD = PluginPackageManager.lD();
        pluginConfig = this.dxd.dxc;
        eVar = this.dxd.Ev;
        lD.a(pluginConfig, eVar);
        aVar.dismiss();
    }
}
