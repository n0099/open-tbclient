package com.baidu.tieba.pluginCenter;

import android.widget.TextView;
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class e implements com.baidu.adp.plugin.packageManager.i {
    final /* synthetic */ PluginDetailActivity bXp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(PluginDetailActivity pluginDetailActivity) {
        this.bXp = pluginDetailActivity;
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
            pluginConfig = this.bXp.bXo;
            if (id.equals(pluginConfig.package_name)) {
                z = this.bXp.mFinished;
                if (!z) {
                    textView = this.bXp.bXm;
                    ay.b(textView, com.baidu.tieba.n.cp_cont_d, 1);
                    textView2 = this.bXp.bXm;
                    textView2.setText(this.bXp.getPageContext().getResources().getString(t.plugin_download_percent, Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                    textView3 = this.bXp.bXm;
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
            pluginConfig = this.bXp.bXo;
            if (id.equals(pluginConfig.package_name)) {
                textView = this.bXp.bXm;
                textView.setText(this.bXp.getPageContext().getString(t.plugin_download_finished));
                textView2 = this.bXp.bXm;
                textView2.setEnabled(false);
                this.bXp.mFinished = true;
            }
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.i
    public void c(BdFileDownloadData bdFileDownloadData) {
        PluginNetConfigInfos.PluginConfig pluginConfig;
        if (bdFileDownloadData != null) {
            String id = bdFileDownloadData.getId();
            pluginConfig = this.bXp.bXo;
            if (id.equals(pluginConfig.package_name)) {
                this.bXp.showToast(bdFileDownloadData.getStatusMsg());
                this.bXp.afO();
                this.bXp.mFinished = true;
            }
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.i
    public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
        if (i == 0) {
            this.bXp.showToast(this.bXp.getPageContext().getString(t.plugin_installation_finished));
            this.bXp.afO();
            return;
        }
        this.bXp.showToast(String.valueOf(this.bXp.getPageContext().getString(t.plugin_installation_failed)) + str);
        this.bXp.afO();
    }
}
