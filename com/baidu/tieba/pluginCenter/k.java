package com.baidu.tieba.pluginCenter;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class k implements DialogInterface.OnDismissListener {
    final /* synthetic */ PluginDownloadActivity eEa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(PluginDownloadActivity pluginDownloadActivity) {
        this.eEa = pluginDownloadActivity;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.eEa.setResult(0);
        this.eEa.finish();
    }
}
