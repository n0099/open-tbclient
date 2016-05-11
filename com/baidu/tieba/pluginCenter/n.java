package com.baidu.tieba.pluginCenter;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.tieba.pluginCenter.PluginDownloadActivity;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class n implements View.OnClickListener {
    final /* synthetic */ PluginDownloadActivity.a dUO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(PluginDownloadActivity.a aVar) {
        this.dUO = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PluginDownloadActivity pluginDownloadActivity;
        TextView textView;
        TextView textView2;
        TextView textView3;
        PluginDownloadActivity pluginDownloadActivity2;
        PluginDownloadActivity pluginDownloadActivity3;
        if (!com.baidu.adp.lib.util.i.fq()) {
            pluginDownloadActivity3 = PluginDownloadActivity.this;
            pluginDownloadActivity3.showToast(t.j.neterror);
            return;
        }
        pluginDownloadActivity = PluginDownloadActivity.this;
        pluginDownloadActivity.dUE = true;
        textView = this.dUO.dUI;
        textView.setVisibility(8);
        textView2 = this.dUO.aJD;
        textView2.setVisibility(8);
        textView3 = this.dUO.cRq;
        textView3.setVisibility(0);
        PluginPackageManager hF = PluginPackageManager.hF();
        pluginDownloadActivity2 = PluginDownloadActivity.this;
        hF.a(pluginDownloadActivity2.dUB, new o(this));
    }
}
