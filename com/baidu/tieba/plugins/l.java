package com.baidu.tieba.plugins;

import android.view.View;
import com.baidu.tbadk.browser.TbWebViewActivity;
import java.util.Date;
/* loaded from: classes.dex */
class l implements View.OnClickListener {
    final /* synthetic */ g bKN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(g gVar) {
        this.bKN = gVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PluginDownloadActivity pluginDownloadActivity;
        PluginDownloadActivity pluginDownloadActivity2;
        pluginDownloadActivity = this.bKN.bKD;
        pluginDownloadActivity.setResult(0);
        pluginDownloadActivity2 = this.bKN.bKD;
        pluginDownloadActivity2.finish();
        com.baidu.tbadk.core.sharedPref.b.og().putBoolean(TbWebViewActivity.KEY_INSTALL_PLUGIN_DIALOG_CLOSED, true);
        com.baidu.tbadk.core.sharedPref.b.og().putLong(TbWebViewActivity.KEY_INSTALL_PLUGIN_DIALOG_SHOWN_TIME, new Date().getTime());
    }
}
