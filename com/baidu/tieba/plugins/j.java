package com.baidu.tieba.plugins;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
class j implements View.OnClickListener {
    final /* synthetic */ g bKN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(g gVar) {
        this.bKN = gVar;
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
        if (!com.baidu.adp.lib.util.i.fg()) {
            pluginDownloadActivity3 = this.bKN.bKD;
            pluginDownloadActivity3.showToast(z.neterror);
            return;
        }
        pluginDownloadActivity = this.bKN.bKD;
        pluginDownloadActivity.bKC = true;
        textView = this.bKN.bKG;
        textView.setVisibility(8);
        textView2 = this.bKN.aok;
        textView2.setVisibility(8);
        textView3 = this.bKN.bKH;
        textView3.setVisibility(0);
        PluginPackageManager ic = PluginPackageManager.ic();
        pluginDownloadActivity2 = this.bKN.bKD;
        pluginConfig = pluginDownloadActivity2.bKz;
        ic.a(pluginConfig, new k(this));
    }
}
