package com.baidu.tieba.pluginCenter;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class l implements View.OnClickListener {
    final /* synthetic */ i bXD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(i iVar) {
        this.bXD = iVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PluginDownloadActivity pluginDownloadActivity;
        TextView textView;
        TextView textView2;
        TextView textView3;
        PluginDownloadActivity pluginDownloadActivity2;
        PluginNetConfigInfos.PluginConfig pluginConfig;
        PluginDownloadActivity pluginDownloadActivity3;
        if (!com.baidu.adp.lib.util.k.iX()) {
            pluginDownloadActivity3 = this.bXD.bXt;
            pluginDownloadActivity3.showToast(t.neterror);
            return;
        }
        pluginDownloadActivity = this.bXD.bXt;
        pluginDownloadActivity.bXs = true;
        textView = this.bXD.bXw;
        textView.setVisibility(8);
        textView2 = this.bXD.azr;
        textView2.setVisibility(8);
        textView3 = this.bXD.bXx;
        textView3.setVisibility(0);
        PluginPackageManager lM = PluginPackageManager.lM();
        pluginDownloadActivity2 = this.bXD.bXt;
        pluginConfig = pluginDownloadActivity2.bXp;
        lM.a(pluginConfig, new m(this));
    }
}
