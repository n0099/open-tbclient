package com.baidu.tieba.plugins;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class f implements DialogInterface.OnDismissListener {
    final /* synthetic */ PluginDownloadActivity bKD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(PluginDownloadActivity pluginDownloadActivity) {
        this.bKD = pluginDownloadActivity;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.bKD.setResult(0);
        this.bKD.finish();
    }
}
