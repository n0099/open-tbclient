package com.baidu.tieba.plugins;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
class j implements View.OnClickListener {
    final /* synthetic */ g bMy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(g gVar) {
        this.bMy = gVar;
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
            pluginDownloadActivity3 = this.bMy.bMo;
            pluginDownloadActivity3.showToast(z.neterror);
            return;
        }
        pluginDownloadActivity = this.bMy.bMo;
        pluginDownloadActivity.bMn = true;
        textView = this.bMy.bMr;
        textView.setVisibility(8);
        textView2 = this.bMy.apf;
        textView2.setVisibility(8);
        textView3 = this.bMy.bMs;
        textView3.setVisibility(0);
        PluginPackageManager ic = PluginPackageManager.ic();
        pluginDownloadActivity2 = this.bMy.bMo;
        pluginConfig = pluginDownloadActivity2.bMk;
        ic.a(pluginConfig, new k(this));
    }
}
