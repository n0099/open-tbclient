package com.baidu.tieba.pluginCenter;

import android.widget.TextView;
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class e implements com.baidu.adp.plugin.packageManager.e {
    final /* synthetic */ PluginDetailActivity fgT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(PluginDetailActivity pluginDetailActivity) {
        this.fgT = pluginDetailActivity;
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
            pluginConfig = this.fgT.fgS;
            if (id.equals(pluginConfig.package_name)) {
                z = this.fgT.cSA;
                if (!z) {
                    textView = this.fgT.fgR;
                    at.c(textView, r.d.cp_cont_d, 1);
                    textView2 = this.fgT.fgR;
                    textView2.setText(this.fgT.getPageContext().getResources().getString(r.j.plugin_download_percent, Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                    textView3 = this.fgT.fgR;
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
            pluginConfig = this.fgT.fgS;
            if (id.equals(pluginConfig.package_name)) {
                textView = this.fgT.fgR;
                textView.setText(this.fgT.getPageContext().getString(r.j.plugin_download_finished));
                textView2 = this.fgT.fgR;
                textView2.setEnabled(false);
                this.fgT.cSA = true;
            }
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.e
    public void c(BdFileDownloadData bdFileDownloadData) {
        PluginNetConfigInfos.PluginConfig pluginConfig;
        if (bdFileDownloadData != null) {
            String id = bdFileDownloadData.getId();
            pluginConfig = this.fgT.fgS;
            if (id.equals(pluginConfig.package_name)) {
                this.fgT.showToast(bdFileDownloadData.getStatusMsg());
                this.fgT.bde();
                this.fgT.cSA = true;
            }
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.e
    public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
        if (i == 0) {
            this.fgT.showToast(this.fgT.getPageContext().getString(r.j.plugin_installation_finished));
            this.fgT.bde();
            return;
        }
        this.fgT.showToast(String.valueOf(this.fgT.getPageContext().getString(r.j.plugin_installation_failed)) + str);
        this.fgT.bde();
    }
}
