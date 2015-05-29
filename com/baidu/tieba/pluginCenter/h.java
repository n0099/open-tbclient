package com.baidu.tieba.pluginCenter;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class h implements DialogInterface.OnDismissListener {
    final /* synthetic */ PluginDownloadActivity bXs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(PluginDownloadActivity pluginDownloadActivity) {
        this.bXs = pluginDownloadActivity;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.bXs.setResult(0);
        this.bXs.finish();
    }
}
