package com.baidu.tieba.pluginCenter;

import android.view.View;
import com.baidu.tbadk.browser.BaseWebViewActivity;
import java.util.Date;
/* loaded from: classes.dex */
class l implements View.OnClickListener {
    final /* synthetic */ g bUI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(g gVar) {
        this.bUI = gVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PluginDownloadActivity pluginDownloadActivity;
        PluginDownloadActivity pluginDownloadActivity2;
        pluginDownloadActivity = this.bUI.bUy;
        pluginDownloadActivity.setResult(0);
        pluginDownloadActivity2 = this.bUI.bUy;
        pluginDownloadActivity2.finish();
        com.baidu.tbadk.core.sharedPref.b.rB().putBoolean(BaseWebViewActivity.KEY_INSTALL_PLUGIN_DIALOG_CLOSED, true);
        com.baidu.tbadk.core.sharedPref.b.rB().putLong(BaseWebViewActivity.KEY_INSTALL_PLUGIN_DIALOG_SHOWN_TIME, new Date().getTime());
    }
}
