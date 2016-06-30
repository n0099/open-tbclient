package com.baidu.tieba.pluginCenter;

import android.widget.TextView;
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class e implements com.baidu.adp.plugin.packageManager.e {
    final /* synthetic */ PluginDetailActivity eDX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(PluginDetailActivity pluginDetailActivity) {
        this.eDX = pluginDetailActivity;
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
            pluginConfig = this.eDX.eDW;
            if (id.equals(pluginConfig.package_name)) {
                z = this.eDX.cxZ;
                if (!z) {
                    textView = this.eDX.eDV;
                    av.c(textView, u.d.cp_cont_d, 1);
                    textView2 = this.eDX.eDV;
                    textView2.setText(this.eDX.getPageContext().getResources().getString(u.j.plugin_download_percent, Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                    textView3 = this.eDX.eDV;
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
            pluginConfig = this.eDX.eDW;
            if (id.equals(pluginConfig.package_name)) {
                textView = this.eDX.eDV;
                textView.setText(this.eDX.getPageContext().getString(u.j.plugin_download_finished));
                textView2 = this.eDX.eDV;
                textView2.setEnabled(false);
                this.eDX.cxZ = true;
            }
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.e
    public void c(BdFileDownloadData bdFileDownloadData) {
        PluginNetConfigInfos.PluginConfig pluginConfig;
        if (bdFileDownloadData != null) {
            String id = bdFileDownloadData.getId();
            pluginConfig = this.eDX.eDW;
            if (id.equals(pluginConfig.package_name)) {
                this.eDX.showToast(bdFileDownloadData.getStatusMsg());
                this.eDX.aTD();
                this.eDX.cxZ = true;
            }
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.e
    public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
        if (i == 0) {
            this.eDX.showToast(this.eDX.getPageContext().getString(u.j.plugin_installation_finished));
            this.eDX.aTD();
            return;
        }
        this.eDX.showToast(String.valueOf(this.eDX.getPageContext().getString(u.j.plugin_installation_failed)) + str);
        this.eDX.aTD();
    }
}
