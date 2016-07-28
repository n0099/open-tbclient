package com.baidu.tieba.pluginCenter;

import android.widget.TextView;
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class e implements com.baidu.adp.plugin.packageManager.e {
    final /* synthetic */ PluginDetailActivity ePG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(PluginDetailActivity pluginDetailActivity) {
        this.ePG = pluginDetailActivity;
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
            pluginConfig = this.ePG.ePF;
            if (id.equals(pluginConfig.package_name)) {
                z = this.ePG.cAO;
                if (!z) {
                    textView = this.ePG.ePE;
                    av.c(textView, u.d.cp_cont_d, 1);
                    textView2 = this.ePG.ePE;
                    textView2.setText(this.ePG.getPageContext().getResources().getString(u.j.plugin_download_percent, Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                    textView3 = this.ePG.ePE;
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
            pluginConfig = this.ePG.ePF;
            if (id.equals(pluginConfig.package_name)) {
                textView = this.ePG.ePE;
                textView.setText(this.ePG.getPageContext().getString(u.j.plugin_download_finished));
                textView2 = this.ePG.ePE;
                textView2.setEnabled(false);
                this.ePG.cAO = true;
            }
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.e
    public void c(BdFileDownloadData bdFileDownloadData) {
        PluginNetConfigInfos.PluginConfig pluginConfig;
        if (bdFileDownloadData != null) {
            String id = bdFileDownloadData.getId();
            pluginConfig = this.ePG.ePF;
            if (id.equals(pluginConfig.package_name)) {
                this.ePG.showToast(bdFileDownloadData.getStatusMsg());
                this.ePG.aWG();
                this.ePG.cAO = true;
            }
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.e
    public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
        if (i == 0) {
            this.ePG.showToast(this.ePG.getPageContext().getString(u.j.plugin_installation_finished));
            this.ePG.aWG();
            return;
        }
        this.ePG.showToast(String.valueOf(this.ePG.getPageContext().getString(u.j.plugin_installation_failed)) + str);
        this.ePG.aWG();
    }
}
