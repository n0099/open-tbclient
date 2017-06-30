package com.baidu.tieba.pluginCenter;

import android.content.DialogInterface;
/* loaded from: classes2.dex */
class k implements DialogInterface.OnDismissListener {
    final /* synthetic */ PluginDownloadActivity fmT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(PluginDownloadActivity pluginDownloadActivity) {
        this.fmT = pluginDownloadActivity;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.fmT.setResult(0);
        this.fmT.finish();
    }
}
