package com.baidu.tieba.pluginCenter;

import android.view.View;
import com.baidu.tbadk.browser.BaseWebViewActivity;
import java.util.Date;
/* loaded from: classes.dex */
class n implements View.OnClickListener {
    final /* synthetic */ i bXC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(i iVar) {
        this.bXC = iVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PluginDownloadActivity pluginDownloadActivity;
        PluginDownloadActivity pluginDownloadActivity2;
        pluginDownloadActivity = this.bXC.bXs;
        pluginDownloadActivity.setResult(0);
        pluginDownloadActivity2 = this.bXC.bXs;
        pluginDownloadActivity2.finish();
        com.baidu.tbadk.core.sharedPref.b.sl().putBoolean(BaseWebViewActivity.KEY_INSTALL_PLUGIN_DIALOG_CLOSED, true);
        com.baidu.tbadk.core.sharedPref.b.sl().putLong(BaseWebViewActivity.KEY_INSTALL_PLUGIN_DIALOG_SHOWN_TIME, new Date().getTime());
    }
}
