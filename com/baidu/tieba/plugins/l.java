package com.baidu.tieba.plugins;

import android.view.View;
import com.baidu.tbadk.browser.TbWebViewActivity;
import java.util.Date;
/* loaded from: classes.dex */
class l implements View.OnClickListener {
    final /* synthetic */ g bHf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(g gVar) {
        this.bHf = gVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PluginDownloadActivity pluginDownloadActivity;
        PluginDownloadActivity pluginDownloadActivity2;
        pluginDownloadActivity = this.bHf.bGV;
        pluginDownloadActivity.setResult(0);
        pluginDownloadActivity2 = this.bHf.bGV;
        pluginDownloadActivity2.finish();
        com.baidu.tbadk.core.sharedPref.b.lk().putBoolean(TbWebViewActivity.KEY_INSTALL_PLUGIN_DIALOG_CLOSED, true);
        com.baidu.tbadk.core.sharedPref.b.lk().putLong(TbWebViewActivity.KEY_INSTALL_PLUGIN_DIALOG_SHOWN_TIME, new Date().getTime());
    }
}
