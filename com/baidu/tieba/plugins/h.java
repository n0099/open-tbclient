package com.baidu.tieba.plugins;

import android.view.View;
/* loaded from: classes.dex */
class h implements View.OnClickListener {
    final /* synthetic */ g bHf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.bHf = gVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PluginDownloadActivity pluginDownloadActivity;
        PluginDownloadActivity pluginDownloadActivity2;
        pluginDownloadActivity = this.bHf.bGV;
        pluginDownloadActivity.setResult(0);
        pluginDownloadActivity2 = this.bHf.bGV;
        pluginDownloadActivity2.finish();
    }
}
