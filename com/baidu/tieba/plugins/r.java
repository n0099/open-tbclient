package com.baidu.tieba.plugins;

import android.view.View;
import com.baidu.tbadk.browser.TbWebViewActivity;
import java.util.Date;
/* loaded from: classes.dex */
class r implements View.OnClickListener {
    final /* synthetic */ m a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(m mVar) {
        this.a = mVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PluginDownloadActivity pluginDownloadActivity;
        PluginDownloadActivity pluginDownloadActivity2;
        pluginDownloadActivity = this.a.a;
        pluginDownloadActivity.setResult(0);
        pluginDownloadActivity2 = this.a.a;
        pluginDownloadActivity2.finish();
        com.baidu.tbadk.core.sharedPref.b.a().c(TbWebViewActivity.KEY_INSTALL_PLUGIN_DIALOG_CLOSED, true);
        com.baidu.tbadk.core.sharedPref.b.a().b(TbWebViewActivity.KEY_INSTALL_PLUGIN_DIALOG_SHOWN_TIME, new Date().getTime());
    }
}
