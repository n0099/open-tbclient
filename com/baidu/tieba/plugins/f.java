package com.baidu.tieba.plugins;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class f implements DialogInterface.OnDismissListener {
    final /* synthetic */ PluginDownloadActivity bHj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(PluginDownloadActivity pluginDownloadActivity) {
        this.bHj = pluginDownloadActivity;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.bHj.setResult(0);
        this.bHj.finish();
    }
}
