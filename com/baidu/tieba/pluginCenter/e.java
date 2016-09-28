package com.baidu.tieba.pluginCenter;

import android.widget.TextView;
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class e implements com.baidu.adp.plugin.packageManager.e {
    final /* synthetic */ PluginDetailActivity eZy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(PluginDetailActivity pluginDetailActivity) {
        this.eZy = pluginDetailActivity;
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
            pluginConfig = this.eZy.eZx;
            if (id.equals(pluginConfig.package_name)) {
                z = this.eZy.cNk;
                if (!z) {
                    textView = this.eZy.eZw;
                    av.c(textView, r.d.cp_cont_d, 1);
                    textView2 = this.eZy.eZw;
                    textView2.setText(this.eZy.getPageContext().getResources().getString(r.j.plugin_download_percent, Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                    textView3 = this.eZy.eZw;
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
            pluginConfig = this.eZy.eZx;
            if (id.equals(pluginConfig.package_name)) {
                textView = this.eZy.eZw;
                textView.setText(this.eZy.getPageContext().getString(r.j.plugin_download_finished));
                textView2 = this.eZy.eZw;
                textView2.setEnabled(false);
                this.eZy.cNk = true;
            }
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.e
    public void c(BdFileDownloadData bdFileDownloadData) {
        PluginNetConfigInfos.PluginConfig pluginConfig;
        if (bdFileDownloadData != null) {
            String id = bdFileDownloadData.getId();
            pluginConfig = this.eZy.eZx;
            if (id.equals(pluginConfig.package_name)) {
                this.eZy.showToast(bdFileDownloadData.getStatusMsg());
                this.eZy.baG();
                this.eZy.cNk = true;
            }
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.e
    public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
        if (i == 0) {
            this.eZy.showToast(this.eZy.getPageContext().getString(r.j.plugin_installation_finished));
            this.eZy.baG();
            return;
        }
        this.eZy.showToast(String.valueOf(this.eZy.getPageContext().getString(r.j.plugin_installation_failed)) + str);
        this.eZy.baG();
    }
}
