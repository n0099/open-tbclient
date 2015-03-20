package com.baidu.tieba.pluginCenter;

import android.widget.TextView;
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.s;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
class c implements com.baidu.adp.plugin.packageManager.i {
    final /* synthetic */ PluginDetailActivity bUv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(PluginDetailActivity pluginDetailActivity) {
        this.bUv = pluginDetailActivity;
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
            pluginConfig = this.bUv.bUu;
            if (id.equals(pluginConfig.package_name)) {
                z = this.bUv.mFinished;
                if (!z) {
                    textView = this.bUv.bUs;
                    ba.b(textView, s.cp_cont_d, 1);
                    textView2 = this.bUv.bUs;
                    textView2.setText(this.bUv.getPageContext().getResources().getString(y.plugin_download_percent, Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                    textView3 = this.bUv.bUs;
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
            pluginConfig = this.bUv.bUu;
            if (id.equals(pluginConfig.package_name)) {
                textView = this.bUv.bUs;
                textView.setText(this.bUv.getPageContext().getString(y.plugin_download_finished));
                textView2 = this.bUv.bUs;
                textView2.setEnabled(false);
                this.bUv.mFinished = true;
            }
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.i
    public void c(BdFileDownloadData bdFileDownloadData) {
        PluginNetConfigInfos.PluginConfig pluginConfig;
        if (bdFileDownloadData != null) {
            String id = bdFileDownloadData.getId();
            pluginConfig = this.bUv.bUu;
            if (id.equals(pluginConfig.package_name)) {
                this.bUv.showToast(bdFileDownloadData.getStatusMsg());
                this.bUv.aet();
                this.bUv.mFinished = true;
            }
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.i
    public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
        if (i == 0) {
            this.bUv.showToast(this.bUv.getPageContext().getString(y.plugin_installation_finished));
            this.bUv.aet();
            return;
        }
        this.bUv.showToast(String.valueOf(this.bUv.getPageContext().getString(y.plugin_installation_failed)) + str);
        this.bUv.aet();
    }
}
