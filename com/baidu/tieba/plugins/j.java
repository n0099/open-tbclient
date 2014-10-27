package com.baidu.tieba.plugins;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.pluginArch.PluginCenter;
import com.baidu.tbadk.pluginArch.bean.ConfigInfos;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
class j implements View.OnClickListener {
    final /* synthetic */ g bHf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(g gVar) {
        this.bHf = gVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PluginDownloadActivity pluginDownloadActivity;
        TextView textView;
        TextView textView2;
        TextView textView3;
        PluginDownloadActivity pluginDownloadActivity2;
        ConfigInfos.PluginConfig pluginConfig;
        PluginDownloadActivity pluginDownloadActivity3;
        if (!com.baidu.adp.lib.util.j.fh()) {
            pluginDownloadActivity3 = this.bHf.bGV;
            pluginDownloadActivity3.showToast(y.neterror);
            return;
        }
        pluginDownloadActivity = this.bHf.bGV;
        pluginDownloadActivity.bGU = true;
        textView = this.bHf.bGY;
        textView.setVisibility(8);
        textView2 = this.bHf.agL;
        textView2.setVisibility(8);
        textView3 = this.bHf.bGZ;
        textView3.setVisibility(0);
        PluginCenter pluginCenter = PluginCenter.getInstance();
        pluginDownloadActivity2 = this.bHf.bGV;
        pluginConfig = pluginDownloadActivity2.bGQ;
        pluginCenter.startDownloadForeground(pluginConfig, new k(this));
    }
}
