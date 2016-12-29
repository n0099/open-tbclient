package com.baidu.tieba.pluginCenter;

import android.widget.TextView;
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class e implements com.baidu.adp.plugin.packageManager.e {
    final /* synthetic */ PluginDetailActivity eKm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(PluginDetailActivity pluginDetailActivity) {
        this.eKm = pluginDetailActivity;
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
            pluginConfig = this.eKm.eKl;
            if (id.equals(pluginConfig.package_name)) {
                z = this.eKm.cxH;
                if (!z) {
                    textView = this.eKm.eKk;
                    ar.c(textView, r.d.cp_cont_d, 1);
                    textView2 = this.eKm.eKk;
                    textView2.setText(this.eKm.getPageContext().getResources().getString(r.j.plugin_download_percent, Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                    textView3 = this.eKm.eKk;
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
            pluginConfig = this.eKm.eKl;
            if (id.equals(pluginConfig.package_name)) {
                textView = this.eKm.eKk;
                textView.setText(this.eKm.getPageContext().getString(r.j.plugin_download_finished));
                textView2 = this.eKm.eKk;
                textView2.setEnabled(false);
                this.eKm.cxH = true;
            }
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.e
    public void c(BdFileDownloadData bdFileDownloadData) {
        PluginNetConfigInfos.PluginConfig pluginConfig;
        if (bdFileDownloadData != null) {
            String id = bdFileDownloadData.getId();
            pluginConfig = this.eKm.eKl;
            if (id.equals(pluginConfig.package_name)) {
                this.eKm.showToast(bdFileDownloadData.getStatusMsg());
                this.eKm.aWL();
                this.eKm.cxH = true;
            }
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.e
    public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
        if (i == 0) {
            this.eKm.showToast(this.eKm.getPageContext().getString(r.j.plugin_installation_finished));
            this.eKm.aWL();
            return;
        }
        this.eKm.showToast(String.valueOf(this.eKm.getPageContext().getString(r.j.plugin_installation_failed)) + str);
        this.eKm.aWL();
    }
}
