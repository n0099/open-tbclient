package com.baidu.tieba.pluginCenter;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.tieba.pluginCenter.PluginDownloadActivity;
import com.baidu.tieba.w;
/* loaded from: classes2.dex */
class n implements View.OnClickListener {
    final /* synthetic */ PluginDownloadActivity.a fnc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(PluginDownloadActivity.a aVar) {
        this.fnc = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PluginDownloadActivity pluginDownloadActivity;
        TextView textView;
        TextView textView2;
        TextView textView3;
        PluginDownloadActivity pluginDownloadActivity2;
        PluginDownloadActivity pluginDownloadActivity3;
        if (!com.baidu.adp.lib.util.i.hj()) {
            pluginDownloadActivity3 = PluginDownloadActivity.this;
            pluginDownloadActivity3.showToast(w.l.neterror);
            return;
        }
        pluginDownloadActivity = PluginDownloadActivity.this;
        pluginDownloadActivity.fmS = true;
        textView = this.fnc.fmW;
        textView.setVisibility(8);
        textView2 = this.fnc.aWU;
        textView2.setVisibility(8);
        textView3 = this.fnc.dRo;
        textView3.setVisibility(0);
        PluginPackageManager jw = PluginPackageManager.jw();
        pluginDownloadActivity2 = PluginDownloadActivity.this;
        jw.a(pluginDownloadActivity2.fmP, new o(this));
    }
}
