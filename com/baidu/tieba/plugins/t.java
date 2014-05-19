package com.baidu.tieba.plugins;

import android.view.View;
import java.util.Date;
/* loaded from: classes.dex */
class t implements View.OnClickListener {
    final /* synthetic */ o a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(o oVar) {
        this.a = oVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PluginDownloadActivity pluginDownloadActivity;
        PluginDownloadActivity pluginDownloadActivity2;
        pluginDownloadActivity = this.a.a;
        pluginDownloadActivity.setResult(0);
        pluginDownloadActivity2 = this.a.a;
        pluginDownloadActivity2.finish();
        com.baidu.tbadk.core.sharedPref.b.a().b("install_plugin_dialog_closed", true);
        com.baidu.tbadk.core.sharedPref.b.a().b("install_plugin_dialog_shown_time", new Date().getTime());
    }
}
