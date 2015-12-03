package com.baidu.tieba.pluginCenter;

import android.widget.TextView;
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class e implements com.baidu.adp.plugin.packageManager.e {
    final /* synthetic */ PluginDetailActivity ddE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(PluginDetailActivity pluginDetailActivity) {
        this.ddE = pluginDetailActivity;
    }

    @Override // com.baidu.adp.plugin.packageManager.e
    public void a(BdFileDownloadData bdFileDownloadData) {
        PluginNetConfigInfos.PluginConfig pluginConfig;
        boolean z;
        TextView textView;
        TextView textView2;
        TextView textView3;
        if (bdFileDownloadData != null) {
            String id = bdFileDownloadData.getId();
            pluginConfig = this.ddE.ddC;
            if (id.equals(pluginConfig.package_name)) {
                z = this.ddE.ddD;
                if (!z) {
                    textView = this.ddE.ddB;
                    as.b(textView, n.c.cp_cont_d, 1);
                    textView2 = this.ddE.ddB;
                    textView2.setText(this.ddE.getPageContext().getResources().getString(n.i.plugin_download_percent, Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                    textView3 = this.ddE.ddB;
                    textView3.setEnabled(false);
                }
            }
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.e
    public void b(BdFileDownloadData bdFileDownloadData) {
        PluginNetConfigInfos.PluginConfig pluginConfig;
        TextView textView;
        TextView textView2;
        if (bdFileDownloadData != null) {
            String id = bdFileDownloadData.getId();
            pluginConfig = this.ddE.ddC;
            if (id.equals(pluginConfig.package_name)) {
                textView = this.ddE.ddB;
                textView.setText(this.ddE.getPageContext().getString(n.i.plugin_download_finished));
                textView2 = this.ddE.ddB;
                textView2.setEnabled(false);
                this.ddE.ddD = true;
            }
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.e
    public void c(BdFileDownloadData bdFileDownloadData) {
        PluginNetConfigInfos.PluginConfig pluginConfig;
        if (bdFileDownloadData != null) {
            String id = bdFileDownloadData.getId();
            pluginConfig = this.ddE.ddC;
            if (id.equals(pluginConfig.package_name)) {
                this.ddE.showToast(bdFileDownloadData.getStatusMsg());
                this.ddE.aup();
                this.ddE.ddD = true;
            }
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.e
    public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
        if (i == 0) {
            this.ddE.showToast(this.ddE.getPageContext().getString(n.i.plugin_installation_finished));
            this.ddE.aup();
            return;
        }
        this.ddE.showToast(String.valueOf(this.ddE.getPageContext().getString(n.i.plugin_installation_failed)) + str);
        this.ddE.aup();
    }
}
