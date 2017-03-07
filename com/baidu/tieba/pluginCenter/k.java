package com.baidu.tieba.pluginCenter;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class k implements DialogInterface.OnDismissListener {
    final /* synthetic */ PluginDownloadActivity eXs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(PluginDownloadActivity pluginDownloadActivity) {
        this.eXs = pluginDownloadActivity;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.eXs.setResult(0);
        this.eXs.finish();
    }
}
