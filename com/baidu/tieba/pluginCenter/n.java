package com.baidu.tieba.pluginCenter;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.tieba.pluginCenter.PluginDownloadActivity;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class n implements View.OnClickListener {
    final /* synthetic */ PluginDownloadActivity.a eEj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(PluginDownloadActivity.a aVar) {
        this.eEj = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PluginDownloadActivity pluginDownloadActivity;
        TextView textView;
        TextView textView2;
        TextView textView3;
        PluginDownloadActivity pluginDownloadActivity2;
        PluginDownloadActivity pluginDownloadActivity3;
        if (!com.baidu.adp.lib.util.i.fr()) {
            pluginDownloadActivity3 = PluginDownloadActivity.this;
            pluginDownloadActivity3.showToast(u.j.neterror);
            return;
        }
        pluginDownloadActivity = PluginDownloadActivity.this;
        pluginDownloadActivity.eDZ = true;
        textView = this.eEj.eEd;
        textView.setVisibility(8);
        textView2 = this.eEj.aNb;
        textView2.setVisibility(8);
        textView3 = this.eEj.dxa;
        textView3.setVisibility(0);
        PluginPackageManager hH = PluginPackageManager.hH();
        pluginDownloadActivity2 = PluginDownloadActivity.this;
        hH.a(pluginDownloadActivity2.eDW, new o(this));
    }
}
