package com.baidu.tieba.tblauncher;

import android.content.DialogInterface;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bc implements DialogInterface.OnCancelListener {
    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        az.cgF = null;
        PluginPackageManager.jx().a((com.baidu.adp.plugin.packageManager.e) null);
    }
}
