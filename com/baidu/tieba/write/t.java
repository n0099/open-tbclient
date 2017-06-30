package com.baidu.tieba.write;

import android.content.DialogInterface;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements DialogInterface.OnCancelListener {
    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        q.coV = null;
        PluginPackageManager.jw().a((com.baidu.adp.plugin.packageManager.e) null);
    }
}
