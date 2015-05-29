package com.baidu.tieba.pluginCenter;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class l implements View.OnClickListener {
    final /* synthetic */ i bXC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(i iVar) {
        this.bXC = iVar;
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
            pluginDownloadActivity3 = this.bXC.bXs;
            pluginDownloadActivity3.showToast(t.neterror);
            return;
        }
        pluginDownloadActivity = this.bXC.bXs;
        pluginDownloadActivity.bXr = true;
        textView = this.bXC.bXv;
        textView.setVisibility(8);
        textView2 = this.bXC.azq;
        textView2.setVisibility(8);
        textView3 = this.bXC.bXw;
        textView3.setVisibility(0);
        PluginPackageManager lM = PluginPackageManager.lM();
        pluginDownloadActivity2 = this.bXC.bXs;
        pluginConfig = pluginDownloadActivity2.bXo;
        lM.a(pluginConfig, new m(this));
    }
}
