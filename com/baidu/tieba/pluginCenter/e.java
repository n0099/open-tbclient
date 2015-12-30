package com.baidu.tieba.pluginCenter;

import android.widget.TextView;
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class e implements com.baidu.adp.plugin.packageManager.e {
    final /* synthetic */ PluginDetailActivity djj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(PluginDetailActivity pluginDetailActivity) {
        this.djj = pluginDetailActivity;
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
            pluginConfig = this.djj.dji;
            if (id.equals(pluginConfig.package_name)) {
                z = this.djj.bFR;
                if (!z) {
                    textView = this.djj.djh;
                    as.b(textView, n.d.cp_cont_d, 1);
                    textView2 = this.djj.djh;
                    textView2.setText(this.djj.getPageContext().getResources().getString(n.j.plugin_download_percent, Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                    textView3 = this.djj.djh;
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
            pluginConfig = this.djj.dji;
            if (id.equals(pluginConfig.package_name)) {
                textView = this.djj.djh;
                textView.setText(this.djj.getPageContext().getString(n.j.plugin_download_finished));
                textView2 = this.djj.djh;
                textView2.setEnabled(false);
                this.djj.bFR = true;
            }
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.e
    public void c(BdFileDownloadData bdFileDownloadData) {
        PluginNetConfigInfos.PluginConfig pluginConfig;
        if (bdFileDownloadData != null) {
            String id = bdFileDownloadData.getId();
            pluginConfig = this.djj.dji;
            if (id.equals(pluginConfig.package_name)) {
                this.djj.showToast(bdFileDownloadData.getStatusMsg());
                this.djj.awi();
                this.djj.bFR = true;
            }
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.e
    public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
        if (i == 0) {
            this.djj.showToast(this.djj.getPageContext().getString(n.j.plugin_installation_finished));
            this.djj.awi();
            return;
        }
        this.djj.showToast(String.valueOf(this.djj.getPageContext().getString(n.j.plugin_installation_failed)) + str);
        this.djj.awi();
    }
}
