package com.baidu.tieba.pluginCenter;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class f implements DialogInterface.OnDismissListener {
    final /* synthetic */ PluginDownloadActivity bUy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(PluginDownloadActivity pluginDownloadActivity) {
        this.bUy = pluginDownloadActivity;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.bUy.setResult(0);
        this.bUy.finish();
    }
}
