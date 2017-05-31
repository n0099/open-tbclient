package com.baidu.tieba.pluginCenter;

import android.widget.TextView;
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.w;
/* loaded from: classes2.dex */
class e implements com.baidu.adp.plugin.packageManager.e {
    final /* synthetic */ PluginDetailActivity fcA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(PluginDetailActivity pluginDetailActivity) {
        this.fcA = pluginDetailActivity;
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
            pluginConfig = this.fcA.fcz;
            if (id.equals(pluginConfig.package_name)) {
                z = this.fcA.cGG;
                if (!z) {
                    textView = this.fcA.fcy;
                    aq.c(textView, w.e.cp_cont_d, 1);
                    textView2 = this.fcA.fcy;
                    textView2.setText(this.fcA.getPageContext().getResources().getString(w.l.plugin_download_percent, Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                    textView3 = this.fcA.fcy;
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
            pluginConfig = this.fcA.fcz;
            if (id.equals(pluginConfig.package_name)) {
                textView = this.fcA.fcy;
                textView.setText(this.fcA.getPageContext().getString(w.l.plugin_download_finished));
                textView2 = this.fcA.fcy;
                textView2.setEnabled(false);
                this.fcA.cGG = true;
            }
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.e
    public void c(BdFileDownloadData bdFileDownloadData) {
        PluginNetConfigInfos.PluginConfig pluginConfig;
        if (bdFileDownloadData != null) {
            String id = bdFileDownloadData.getId();
            pluginConfig = this.fcA.fcz;
            if (id.equals(pluginConfig.package_name)) {
                this.fcA.showToast(bdFileDownloadData.getStatusMsg());
                this.fcA.aYg();
                this.fcA.cGG = true;
            }
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.e
    public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
        if (i == 0) {
            this.fcA.showToast(this.fcA.getPageContext().getString(w.l.plugin_installation_finished));
            this.fcA.aYg();
            return;
        }
        this.fcA.showToast(String.valueOf(this.fcA.getPageContext().getString(w.l.plugin_installation_failed)) + str);
        this.fcA.aYg();
    }
}
