package com.baidu.tieba.plugins;

import android.view.View;
/* loaded from: classes.dex */
class n implements View.OnClickListener {
    final /* synthetic */ m a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.a = mVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PluginDownloadActivity pluginDownloadActivity;
        PluginDownloadActivity pluginDownloadActivity2;
        pluginDownloadActivity = this.a.a;
        pluginDownloadActivity.setResult(0);
        pluginDownloadActivity2 = this.a.a;
        pluginDownloadActivity2.finish();
    }
}
