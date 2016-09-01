package com.baidu.tieba.pluginCenter;

import android.widget.TextView;
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class e implements com.baidu.adp.plugin.packageManager.e {
    final /* synthetic */ PluginDetailActivity eWR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(PluginDetailActivity pluginDetailActivity) {
        this.eWR = pluginDetailActivity;
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
            pluginConfig = this.eWR.eWQ;
            if (id.equals(pluginConfig.package_name)) {
                z = this.eWR.cMt;
                if (!z) {
                    textView = this.eWR.eWP;
                    av.c(textView, t.d.cp_cont_d, 1);
                    textView2 = this.eWR.eWP;
                    textView2.setText(this.eWR.getPageContext().getResources().getString(t.j.plugin_download_percent, Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                    textView3 = this.eWR.eWP;
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
            pluginConfig = this.eWR.eWQ;
            if (id.equals(pluginConfig.package_name)) {
                textView = this.eWR.eWP;
                textView.setText(this.eWR.getPageContext().getString(t.j.plugin_download_finished));
                textView2 = this.eWR.eWP;
                textView2.setEnabled(false);
                this.eWR.cMt = true;
            }
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.e
    public void c(BdFileDownloadData bdFileDownloadData) {
        PluginNetConfigInfos.PluginConfig pluginConfig;
        if (bdFileDownloadData != null) {
            String id = bdFileDownloadData.getId();
            pluginConfig = this.eWR.eWQ;
            if (id.equals(pluginConfig.package_name)) {
                this.eWR.showToast(bdFileDownloadData.getStatusMsg());
                this.eWR.aZZ();
                this.eWR.cMt = true;
            }
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.e
    public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
        if (i == 0) {
            this.eWR.showToast(this.eWR.getPageContext().getString(t.j.plugin_installation_finished));
            this.eWR.aZZ();
            return;
        }
        this.eWR.showToast(String.valueOf(this.eWR.getPageContext().getString(t.j.plugin_installation_failed)) + str);
        this.eWR.aZZ();
    }
}
