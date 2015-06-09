package com.baidu.tieba.pluginCenter;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class h implements DialogInterface.OnDismissListener {
    final /* synthetic */ PluginDownloadActivity bXt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(PluginDownloadActivity pluginDownloadActivity) {
        this.bXt = pluginDownloadActivity;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.bXt.setResult(0);
        this.bXt.finish();
    }
}
