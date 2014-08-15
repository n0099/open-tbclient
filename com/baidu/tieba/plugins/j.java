package com.baidu.tieba.plugins;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.pluginArch.bean.ConfigInfos;
import com.baidu.tieba.x;
/* loaded from: classes.dex */
class j implements View.OnClickListener {
    final /* synthetic */ g a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(g gVar) {
        this.a = gVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PluginDownloadActivity pluginDownloadActivity;
        PluginDownloadActivity pluginDownloadActivity2;
        TextView textView;
        TextView textView2;
        TextView textView3;
        PluginDownloadActivity pluginDownloadActivity3;
        ConfigInfos.PluginConfig pluginConfig;
        PluginDownloadActivity pluginDownloadActivity4;
        pluginDownloadActivity = this.a.a;
        if (UtilHelper.getNetStatusInfo(pluginDownloadActivity) == UtilHelper.NetworkStateInfo.UNAVAIL) {
            pluginDownloadActivity4 = this.a.a;
            pluginDownloadActivity4.showToast(x.neterror);
            return;
        }
        pluginDownloadActivity2 = this.a.a;
        pluginDownloadActivity2.d = true;
        textView = this.a.e;
        textView.setVisibility(8);
        textView2 = this.a.f;
        textView2.setVisibility(8);
        textView3 = this.a.g;
        textView3.setVisibility(0);
        com.baidu.tbadk.pluginArch.d a = com.baidu.tbadk.pluginArch.d.a();
        pluginDownloadActivity3 = this.a.a;
        pluginConfig = pluginDownloadActivity3.b;
        a.a(pluginConfig, new k(this));
    }
}
