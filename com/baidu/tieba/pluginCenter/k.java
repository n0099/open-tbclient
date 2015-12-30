package com.baidu.tieba.pluginCenter;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class k implements DialogInterface.OnDismissListener {
    final /* synthetic */ PluginDownloadActivity djm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(PluginDownloadActivity pluginDownloadActivity) {
        this.djm = pluginDownloadActivity;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.djm.setResult(0);
        this.djm.finish();
    }
}
