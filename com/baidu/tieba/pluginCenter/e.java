package com.baidu.tieba.pluginCenter;

import android.widget.TextView;
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class e implements com.baidu.adp.plugin.packageManager.e {
    final /* synthetic */ PluginDetailActivity eXp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(PluginDetailActivity pluginDetailActivity) {
        this.eXp = pluginDetailActivity;
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
            pluginConfig = this.eXp.eXo;
            if (id.equals(pluginConfig.package_name)) {
                z = this.eXp.cGh;
                if (!z) {
                    textView = this.eXp.eXn;
                    aq.c(textView, w.e.cp_cont_d, 1);
                    textView2 = this.eXp.eXn;
                    textView2.setText(this.eXp.getPageContext().getResources().getString(w.l.plugin_download_percent, Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                    textView3 = this.eXp.eXn;
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
            pluginConfig = this.eXp.eXo;
            if (id.equals(pluginConfig.package_name)) {
                textView = this.eXp.eXn;
                textView.setText(this.eXp.getPageContext().getString(w.l.plugin_download_finished));
                textView2 = this.eXp.eXn;
                textView2.setEnabled(false);
                this.eXp.cGh = true;
            }
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.e
    public void c(BdFileDownloadData bdFileDownloadData) {
        PluginNetConfigInfos.PluginConfig pluginConfig;
        if (bdFileDownloadData != null) {
            String id = bdFileDownloadData.getId();
            pluginConfig = this.eXp.eXo;
            if (id.equals(pluginConfig.package_name)) {
                this.eXp.showToast(bdFileDownloadData.getStatusMsg());
                this.eXp.aYe();
                this.eXp.cGh = true;
            }
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.e
    public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
        if (i == 0) {
            this.eXp.showToast(this.eXp.getPageContext().getString(w.l.plugin_installation_finished));
            this.eXp.aYe();
            return;
        }
        this.eXp.showToast(String.valueOf(this.eXp.getPageContext().getString(w.l.plugin_installation_failed)) + str);
        this.eXp.aYe();
    }
}
