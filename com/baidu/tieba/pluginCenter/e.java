package com.baidu.tieba.pluginCenter;

import android.widget.TextView;
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class e implements com.baidu.adp.plugin.packageManager.e {
    final /* synthetic */ PluginDetailActivity dxd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(PluginDetailActivity pluginDetailActivity) {
        this.dxd = pluginDetailActivity;
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
            pluginConfig = this.dxd.dxc;
            if (id.equals(pluginConfig.package_name)) {
                z = this.dxd.bJb;
                if (!z) {
                    textView = this.dxd.dxb;
                    ar.b(textView, t.d.cp_cont_d, 1);
                    textView2 = this.dxd.dxb;
                    textView2.setText(this.dxd.getPageContext().getResources().getString(t.j.plugin_download_percent, Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                    textView3 = this.dxd.dxb;
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
            pluginConfig = this.dxd.dxc;
            if (id.equals(pluginConfig.package_name)) {
                textView = this.dxd.dxb;
                textView.setText(this.dxd.getPageContext().getString(t.j.plugin_download_finished));
                textView2 = this.dxd.dxb;
                textView2.setEnabled(false);
                this.dxd.bJb = true;
            }
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.e
    public void c(BdFileDownloadData bdFileDownloadData) {
        PluginNetConfigInfos.PluginConfig pluginConfig;
        if (bdFileDownloadData != null) {
            String id = bdFileDownloadData.getId();
            pluginConfig = this.dxd.dxc;
            if (id.equals(pluginConfig.package_name)) {
                this.dxd.showToast(bdFileDownloadData.getStatusMsg());
                this.dxd.aCD();
                this.dxd.bJb = true;
            }
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.e
    public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
        if (i == 0) {
            this.dxd.showToast(this.dxd.getPageContext().getString(t.j.plugin_installation_finished));
            this.dxd.aCD();
            return;
        }
        this.dxd.showToast(String.valueOf(this.dxd.getPageContext().getString(t.j.plugin_installation_failed)) + str);
        this.dxd.aCD();
    }
}
