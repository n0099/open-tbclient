package com.baidu.tieba.plugins;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.pluginArch.PluginCenter;
import com.baidu.tbadk.pluginArch.bean.ConfigInfos;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
class j implements View.OnClickListener {
    final /* synthetic */ g bHt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(g gVar) {
        this.bHt = gVar;
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
            pluginDownloadActivity3 = this.bHt.bHj;
            pluginDownloadActivity3.showToast(y.neterror);
            return;
        }
        pluginDownloadActivity = this.bHt.bHj;
        pluginDownloadActivity.bHi = true;
        textView = this.bHt.bHm;
        textView.setVisibility(8);
        textView2 = this.bHt.agU;
        textView2.setVisibility(8);
        textView3 = this.bHt.bHn;
        textView3.setVisibility(0);
        PluginCenter pluginCenter = PluginCenter.getInstance();
        pluginDownloadActivity2 = this.bHt.bHj;
        pluginConfig = pluginDownloadActivity2.bHe;
        pluginCenter.startDownloadForeground(pluginConfig, new k(this));
    }
}
