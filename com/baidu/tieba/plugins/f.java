package com.baidu.tieba.plugins;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class f implements DialogInterface.OnDismissListener {
    final /* synthetic */ PluginDownloadActivity bGV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(PluginDownloadActivity pluginDownloadActivity) {
        this.bGV = pluginDownloadActivity;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.bGV.setResult(0);
        this.bGV.finish();
    }
}
