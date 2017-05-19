package com.baidu.tieba.pluginCenter;

import android.widget.TextView;
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.w;
/* loaded from: classes2.dex */
class e implements com.baidu.adp.plugin.packageManager.e {
    final /* synthetic */ PluginDetailActivity eTF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(PluginDetailActivity pluginDetailActivity) {
        this.eTF = pluginDetailActivity;
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
            pluginConfig = this.eTF.eTE;
            if (id.equals(pluginConfig.package_name)) {
                z = this.eTF.cBh;
                if (!z) {
                    textView = this.eTF.eTD;
                    aq.c(textView, w.e.cp_cont_d, 1);
                    textView2 = this.eTF.eTD;
                    textView2.setText(this.eTF.getPageContext().getResources().getString(w.l.plugin_download_percent, Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                    textView3 = this.eTF.eTD;
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
            pluginConfig = this.eTF.eTE;
            if (id.equals(pluginConfig.package_name)) {
                textView = this.eTF.eTD;
                textView.setText(this.eTF.getPageContext().getString(w.l.plugin_download_finished));
                textView2 = this.eTF.eTD;
                textView2.setEnabled(false);
                this.eTF.cBh = true;
            }
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.e
    public void c(BdFileDownloadData bdFileDownloadData) {
        PluginNetConfigInfos.PluginConfig pluginConfig;
        if (bdFileDownloadData != null) {
            String id = bdFileDownloadData.getId();
            pluginConfig = this.eTF.eTE;
            if (id.equals(pluginConfig.package_name)) {
                this.eTF.showToast(bdFileDownloadData.getStatusMsg());
                this.eTF.aWN();
                this.eTF.cBh = true;
            }
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.e
    public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
        if (i == 0) {
            this.eTF.showToast(this.eTF.getPageContext().getString(w.l.plugin_installation_finished));
            this.eTF.aWN();
            return;
        }
        this.eTF.showToast(String.valueOf(this.eTF.getPageContext().getString(w.l.plugin_installation_failed)) + str);
        this.eTF.aWN();
    }
}
