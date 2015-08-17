package com.baidu.tieba.pluginCenter;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class j implements DialogInterface.OnDismissListener {

    /* renamed from: com  reason: collision with root package name */
    final /* synthetic */ PluginDownloadActivity f129com;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(PluginDownloadActivity pluginDownloadActivity) {
        this.f129com = pluginDownloadActivity;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.f129com.setResult(0);
        this.f129com.finish();
    }
}
