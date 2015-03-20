package com.baidu.tieba.pluginCenter;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
class j implements View.OnClickListener {
    final /* synthetic */ g bUI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(g gVar) {
        this.bUI = gVar;
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
        if (!com.baidu.adp.lib.util.k.iH()) {
            pluginDownloadActivity3 = this.bUI.bUy;
            pluginDownloadActivity3.showToast(y.neterror);
            return;
        }
        pluginDownloadActivity = this.bUI.bUy;
        pluginDownloadActivity.bUx = true;
        textView = this.bUI.bUB;
        textView.setVisibility(8);
        textView2 = this.bUI.axw;
        textView2.setVisibility(8);
        textView3 = this.bUI.bUC;
        textView3.setVisibility(0);
        PluginPackageManager ls = PluginPackageManager.ls();
        pluginDownloadActivity2 = this.bUI.bUy;
        pluginConfig = pluginDownloadActivity2.bUu;
        ls.a(pluginConfig, new k(this));
    }
}
