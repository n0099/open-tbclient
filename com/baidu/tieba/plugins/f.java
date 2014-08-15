package com.baidu.tieba.plugins;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class f implements DialogInterface.OnDismissListener {
    final /* synthetic */ PluginDownloadActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(PluginDownloadActivity pluginDownloadActivity) {
        this.a = pluginDownloadActivity;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.a.setResult(0);
        this.a.finish();
    }
}
