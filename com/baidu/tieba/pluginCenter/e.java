package com.baidu.tieba.pluginCenter;

import android.widget.TextView;
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class e implements com.baidu.adp.plugin.packageManager.i {
    final /* synthetic */ PluginDetailActivity bXq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(PluginDetailActivity pluginDetailActivity) {
        this.bXq = pluginDetailActivity;
    }

    @Override // com.baidu.adp.plugin.packageManager.i
    public void a(BdFileDownloadData bdFileDownloadData) {
        PluginNetConfigInfos.PluginConfig pluginConfig;
        boolean z;
        TextView textView;
        TextView textView2;
        TextView textView3;
        if (bdFileDownloadData != null) {
            String id = bdFileDownloadData.getId();
            pluginConfig = this.bXq.bXp;
            if (id.equals(pluginConfig.package_name)) {
                z = this.bXq.mFinished;
                if (!z) {
                    textView = this.bXq.bXn;
                    ay.b(textView, com.baidu.tieba.n.cp_cont_d, 1);
                    textView2 = this.bXq.bXn;
                    textView2.setText(this.bXq.getPageContext().getResources().getString(t.plugin_download_percent, Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                    textView3 = this.bXq.bXn;
                    textView3.setEnabled(false);
                }
            }
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.i
    public void b(BdFileDownloadData bdFileDownloadData) {
        PluginNetConfigInfos.PluginConfig pluginConfig;
        TextView textView;
        TextView textView2;
        if (bdFileDownloadData != null) {
            String id = bdFileDownloadData.getId();
            pluginConfig = this.bXq.bXp;
            if (id.equals(pluginConfig.package_name)) {
                textView = this.bXq.bXn;
                textView.setText(this.bXq.getPageContext().getString(t.plugin_download_finished));
                textView2 = this.bXq.bXn;
                textView2.setEnabled(false);
                this.bXq.mFinished = true;
            }
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.i
    public void c(BdFileDownloadData bdFileDownloadData) {
        PluginNetConfigInfos.PluginConfig pluginConfig;
        if (bdFileDownloadData != null) {
            String id = bdFileDownloadData.getId();
            pluginConfig = this.bXq.bXp;
            if (id.equals(pluginConfig.package_name)) {
                this.bXq.showToast(bdFileDownloadData.getStatusMsg());
                this.bXq.afP();
                this.bXq.mFinished = true;
            }
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.i
    public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
        if (i == 0) {
            this.bXq.showToast(this.bXq.getPageContext().getString(t.plugin_installation_finished));
            this.bXq.afP();
            return;
        }
        this.bXq.showToast(String.valueOf(this.bXq.getPageContext().getString(t.plugin_installation_failed)) + str);
        this.bXq.afP();
    }
}
