package com.baidu.tieba.pluginCenter;

import android.widget.TextView;
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class e implements com.baidu.adp.plugin.packageManager.e {
    final /* synthetic */ PluginDetailActivity eVo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(PluginDetailActivity pluginDetailActivity) {
        this.eVo = pluginDetailActivity;
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
            pluginConfig = this.eVo.eVn;
            if (id.equals(pluginConfig.package_name)) {
                z = this.eVo.cEG;
                if (!z) {
                    textView = this.eVo.eVm;
                    aq.c(textView, w.e.cp_cont_d, 1);
                    textView2 = this.eVo.eVm;
                    textView2.setText(this.eVo.getPageContext().getResources().getString(w.l.plugin_download_percent, Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                    textView3 = this.eVo.eVm;
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
            pluginConfig = this.eVo.eVn;
            if (id.equals(pluginConfig.package_name)) {
                textView = this.eVo.eVm;
                textView.setText(this.eVo.getPageContext().getString(w.l.plugin_download_finished));
                textView2 = this.eVo.eVm;
                textView2.setEnabled(false);
                this.eVo.cEG = true;
            }
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.e
    public void c(BdFileDownloadData bdFileDownloadData) {
        PluginNetConfigInfos.PluginConfig pluginConfig;
        if (bdFileDownloadData != null) {
            String id = bdFileDownloadData.getId();
            pluginConfig = this.eVo.eVn;
            if (id.equals(pluginConfig.package_name)) {
                this.eVo.showToast(bdFileDownloadData.getStatusMsg());
                this.eVo.aYn();
                this.eVo.cEG = true;
            }
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.e
    public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
        if (i == 0) {
            this.eVo.showToast(this.eVo.getPageContext().getString(w.l.plugin_installation_finished));
            this.eVo.aYn();
            return;
        }
        this.eVo.showToast(String.valueOf(this.eVo.getPageContext().getString(w.l.plugin_installation_failed)) + str);
        this.eVo.aYn();
    }
}
