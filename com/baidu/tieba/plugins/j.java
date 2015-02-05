package com.baidu.tieba.plugins;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
class j implements View.OnClickListener {
    final /* synthetic */ g bMx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(g gVar) {
        this.bMx = gVar;
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
        if (!com.baidu.adp.lib.util.i.ff()) {
            pluginDownloadActivity3 = this.bMx.bMn;
            pluginDownloadActivity3.showToast(z.neterror);
            return;
        }
        pluginDownloadActivity = this.bMx.bMn;
        pluginDownloadActivity.bMm = true;
        textView = this.bMx.bMq;
        textView.setVisibility(8);
        textView2 = this.bMx.apc;
        textView2.setVisibility(8);
        textView3 = this.bMx.bMr;
        textView3.setVisibility(0);
        PluginPackageManager hV = PluginPackageManager.hV();
        pluginDownloadActivity2 = this.bMx.bMn;
        pluginConfig = pluginDownloadActivity2.bMj;
        hV.a(pluginConfig, new k(this));
    }
}
