package com.baidu.tieba.pluginCenter;

import android.view.View;
/* loaded from: classes.dex */
class j implements View.OnClickListener {
    final /* synthetic */ i bXD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.bXD = iVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PluginDownloadActivity pluginDownloadActivity;
        PluginDownloadActivity pluginDownloadActivity2;
        pluginDownloadActivity = this.bXD.bXt;
        pluginDownloadActivity.setResult(0);
        pluginDownloadActivity2 = this.bXD.bXt;
        pluginDownloadActivity2.finish();
    }
}
