package com.baidu.tieba.pluginCenter;

import android.widget.TextView;
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class e implements com.baidu.adp.plugin.packageManager.e {
    final /* synthetic */ PluginDetailActivity eXF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(PluginDetailActivity pluginDetailActivity) {
        this.eXF = pluginDetailActivity;
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
            pluginConfig = this.eXF.eXE;
            if (id.equals(pluginConfig.package_name)) {
                z = this.eXF.cGX;
                if (!z) {
                    textView = this.eXF.eXD;
                    aq.c(textView, w.e.cp_cont_d, 1);
                    textView2 = this.eXF.eXD;
                    textView2.setText(this.eXF.getPageContext().getResources().getString(w.l.plugin_download_percent, Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                    textView3 = this.eXF.eXD;
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
            pluginConfig = this.eXF.eXE;
            if (id.equals(pluginConfig.package_name)) {
                textView = this.eXF.eXD;
                textView.setText(this.eXF.getPageContext().getString(w.l.plugin_download_finished));
                textView2 = this.eXF.eXD;
                textView2.setEnabled(false);
                this.eXF.cGX = true;
            }
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.e
    public void c(BdFileDownloadData bdFileDownloadData) {
        PluginNetConfigInfos.PluginConfig pluginConfig;
        if (bdFileDownloadData != null) {
            String id = bdFileDownloadData.getId();
            pluginConfig = this.eXF.eXE;
            if (id.equals(pluginConfig.package_name)) {
                this.eXF.showToast(bdFileDownloadData.getStatusMsg());
                this.eXF.aZo();
                this.eXF.cGX = true;
            }
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.e
    public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
        if (i == 0) {
            this.eXF.showToast(this.eXF.getPageContext().getString(w.l.plugin_installation_finished));
            this.eXF.aZo();
            return;
        }
        this.eXF.showToast(String.valueOf(this.eXF.getPageContext().getString(w.l.plugin_installation_failed)) + str);
        this.eXF.aZo();
    }
}
