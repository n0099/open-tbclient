package com.baidu.tieba.pluginCenter;

import android.view.View;
import com.baidu.tieba.pluginCenter.PluginDownloadActivity;
/* loaded from: classes.dex */
class l implements View.OnClickListener {
    final /* synthetic */ PluginDownloadActivity.a eXB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(PluginDownloadActivity.a aVar) {
        this.eXB = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PluginDownloadActivity pluginDownloadActivity;
        PluginDownloadActivity pluginDownloadActivity2;
        pluginDownloadActivity = PluginDownloadActivity.this;
        pluginDownloadActivity.setResult(0);
        pluginDownloadActivity2 = PluginDownloadActivity.this;
        pluginDownloadActivity2.finish();
    }
}
