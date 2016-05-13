package com.baidu.tieba.pluginCenter;

import android.widget.TextView;
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class e implements com.baidu.adp.plugin.packageManager.e {
    final /* synthetic */ PluginDetailActivity dUC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(PluginDetailActivity pluginDetailActivity) {
        this.dUC = pluginDetailActivity;
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
            pluginConfig = this.dUC.dUB;
            if (id.equals(pluginConfig.package_name)) {
                z = this.dUC.bTZ;
                if (!z) {
                    textView = this.dUC.dUA;
                    at.c(textView, t.d.cp_cont_d, 1);
                    textView2 = this.dUC.dUA;
                    textView2.setText(this.dUC.getPageContext().getResources().getString(t.j.plugin_download_percent, Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                    textView3 = this.dUC.dUA;
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
            pluginConfig = this.dUC.dUB;
            if (id.equals(pluginConfig.package_name)) {
                textView = this.dUC.dUA;
                textView.setText(this.dUC.getPageContext().getString(t.j.plugin_download_finished));
                textView2 = this.dUC.dUA;
                textView2.setEnabled(false);
                this.dUC.bTZ = true;
            }
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.e
    public void c(BdFileDownloadData bdFileDownloadData) {
        PluginNetConfigInfos.PluginConfig pluginConfig;
        if (bdFileDownloadData != null) {
            String id = bdFileDownloadData.getId();
            pluginConfig = this.dUC.dUB;
            if (id.equals(pluginConfig.package_name)) {
                this.dUC.showToast(bdFileDownloadData.getStatusMsg());
                this.dUC.aKy();
                this.dUC.bTZ = true;
            }
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.e
    public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
        if (i == 0) {
            this.dUC.showToast(this.dUC.getPageContext().getString(t.j.plugin_installation_finished));
            this.dUC.aKy();
            return;
        }
        this.dUC.showToast(String.valueOf(this.dUC.getPageContext().getString(t.j.plugin_installation_failed)) + str);
        this.dUC.aKy();
    }
}
