package com.baidu.tieba.pluginCenter;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.tieba.pluginCenter.PluginDownloadActivity;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class n implements View.OnClickListener {
    final /* synthetic */ PluginDownloadActivity.a ePS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(PluginDownloadActivity.a aVar) {
        this.ePS = aVar;
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
            pluginDownloadActivity3.showToast(u.j.neterror);
            return;
        }
        pluginDownloadActivity = PluginDownloadActivity.this;
        pluginDownloadActivity.ePI = true;
        textView = this.ePS.ePM;
        textView.setVisibility(8);
        textView2 = this.ePS.aNV;
        textView2.setVisibility(8);
        textView3 = this.ePS.dAy;
        textView3.setVisibility(0);
        PluginPackageManager hG = PluginPackageManager.hG();
        pluginDownloadActivity2 = PluginDownloadActivity.this;
        hG.a(pluginDownloadActivity2.ePF, new o(this));
    }
}
