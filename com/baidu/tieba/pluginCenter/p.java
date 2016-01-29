package com.baidu.tieba.pluginCenter;

import android.view.View;
import com.baidu.tbadk.browser.BaseWebViewActivity;
import com.baidu.tieba.pluginCenter.PluginDownloadActivity;
import java.util.Date;
/* loaded from: classes.dex */
class p implements View.OnClickListener {
    final /* synthetic */ PluginDownloadActivity.a dxq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(PluginDownloadActivity.a aVar) {
        this.dxq = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PluginDownloadActivity pluginDownloadActivity;
        PluginDownloadActivity pluginDownloadActivity2;
        pluginDownloadActivity = PluginDownloadActivity.this;
        pluginDownloadActivity.setResult(0);
        pluginDownloadActivity2 = PluginDownloadActivity.this;
        pluginDownloadActivity2.finish();
        com.baidu.tbadk.core.sharedPref.b.uO().putBoolean(BaseWebViewActivity.KEY_INSTALL_PLUGIN_DIALOG_CLOSED, true);
        com.baidu.tbadk.core.sharedPref.b.uO().putLong(BaseWebViewActivity.KEY_INSTALL_PLUGIN_DIALOG_SHOWN_TIME, new Date().getTime());
    }
}
