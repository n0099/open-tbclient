package com.baidu.tieba.pluginCenter;

import android.view.View;
/* loaded from: classes.dex */
class h implements View.OnClickListener {
    final /* synthetic */ g bUI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.bUI = gVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PluginDownloadActivity pluginDownloadActivity;
        PluginDownloadActivity pluginDownloadActivity2;
        pluginDownloadActivity = this.bUI.bUy;
        pluginDownloadActivity.setResult(0);
        pluginDownloadActivity2 = this.bUI.bUy;
        pluginDownloadActivity2.finish();
    }
}
