package com.baidu.tieba.pluginCenter;

import android.view.View;
/* loaded from: classes.dex */
class h implements View.OnClickListener {
    final /* synthetic */ g bUY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.bUY = gVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PluginDownloadActivity pluginDownloadActivity;
        PluginDownloadActivity pluginDownloadActivity2;
        pluginDownloadActivity = this.bUY.bUO;
        pluginDownloadActivity.setResult(0);
        pluginDownloadActivity2 = this.bUY.bUO;
        pluginDownloadActivity2.finish();
    }
}
