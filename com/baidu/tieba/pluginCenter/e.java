package com.baidu.tieba.pluginCenter;

import android.widget.TextView;
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class e implements com.baidu.adp.plugin.packageManager.e {
    final /* synthetic */ PluginDetailActivity dRK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(PluginDetailActivity pluginDetailActivity) {
        this.dRK = pluginDetailActivity;
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
            pluginConfig = this.dRK.dRJ;
            if (id.equals(pluginConfig.package_name)) {
                z = this.dRK.bTx;
                if (!z) {
                    textView = this.dRK.dRI;
                    at.b(textView, t.d.cp_cont_d, 1);
                    textView2 = this.dRK.dRI;
                    textView2.setText(this.dRK.getPageContext().getResources().getString(t.j.plugin_download_percent, Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                    textView3 = this.dRK.dRI;
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
            pluginConfig = this.dRK.dRJ;
            if (id.equals(pluginConfig.package_name)) {
                textView = this.dRK.dRI;
                textView.setText(this.dRK.getPageContext().getString(t.j.plugin_download_finished));
                textView2 = this.dRK.dRI;
                textView2.setEnabled(false);
                this.dRK.bTx = true;
            }
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.e
    public void c(BdFileDownloadData bdFileDownloadData) {
        PluginNetConfigInfos.PluginConfig pluginConfig;
        if (bdFileDownloadData != null) {
            String id = bdFileDownloadData.getId();
            pluginConfig = this.dRK.dRJ;
            if (id.equals(pluginConfig.package_name)) {
                this.dRK.showToast(bdFileDownloadData.getStatusMsg());
                this.dRK.aKr();
                this.dRK.bTx = true;
            }
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.e
    public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
        if (i == 0) {
            this.dRK.showToast(this.dRK.getPageContext().getString(t.j.plugin_installation_finished));
            this.dRK.aKr();
            return;
        }
        this.dRK.showToast(String.valueOf(this.dRK.getPageContext().getString(t.j.plugin_installation_failed)) + str);
        this.dRK.aKr();
    }
}
