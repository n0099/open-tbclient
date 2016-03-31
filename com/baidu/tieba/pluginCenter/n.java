package com.baidu.tieba.pluginCenter;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.tieba.pluginCenter.PluginDownloadActivity;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class n implements View.OnClickListener {
    final /* synthetic */ PluginDownloadActivity.a dRW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(PluginDownloadActivity.a aVar) {
        this.dRW = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PluginDownloadActivity pluginDownloadActivity;
        TextView textView;
        TextView textView2;
        TextView textView3;
        PluginDownloadActivity pluginDownloadActivity2;
        PluginDownloadActivity pluginDownloadActivity3;
        if (!com.baidu.adp.lib.util.i.jf()) {
            pluginDownloadActivity3 = PluginDownloadActivity.this;
            pluginDownloadActivity3.showToast(t.j.neterror);
            return;
        }
        pluginDownloadActivity = PluginDownloadActivity.this;
        pluginDownloadActivity.dRM = true;
        textView = this.dRW.dRQ;
        textView.setVisibility(8);
        textView2 = this.dRW.aNt;
        textView2.setVisibility(8);
        textView3 = this.dRW.cQt;
        textView3.setVisibility(0);
        PluginPackageManager ls = PluginPackageManager.ls();
        pluginDownloadActivity2 = PluginDownloadActivity.this;
        ls.a(pluginDownloadActivity2.dRJ, new o(this));
    }
}
