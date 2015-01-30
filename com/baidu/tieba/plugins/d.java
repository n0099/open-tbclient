package com.baidu.tieba.plugins;

import android.widget.TextView;
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.t;
import com.baidu.tieba.z;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements com.baidu.adp.plugin.packageManager.e {
    final /* synthetic */ PluginDetailActivity bMl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(PluginDetailActivity pluginDetailActivity) {
        this.bMl = pluginDetailActivity;
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
            pluginConfig = this.bMl.bMk;
            if (id.equals(pluginConfig.package_name)) {
                z = this.bMl.mFinished;
                if (!z) {
                    textView = this.bMl.bMi;
                    bc.b(textView, t.cp_cont_d, 1);
                    textView2 = this.bMl.bMi;
                    textView2.setText(this.bMl.getPageContext().getResources().getString(z.plugin_download_percent, Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                    textView3 = this.bMl.bMi;
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
            pluginConfig = this.bMl.bMk;
            if (id.equals(pluginConfig.package_name)) {
                textView = this.bMl.bMi;
                textView.setText(this.bMl.getPageContext().getString(z.plugin_download_finished));
                textView2 = this.bMl.bMi;
                textView2.setEnabled(false);
                this.bMl.mFinished = true;
            }
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.e
    public void c(BdFileDownloadData bdFileDownloadData) {
        PluginNetConfigInfos.PluginConfig pluginConfig;
        if (bdFileDownloadData != null) {
            String id = bdFileDownloadData.getId();
            pluginConfig = this.bMl.bMk;
            if (id.equals(pluginConfig.package_name)) {
                this.bMl.showToast(bdFileDownloadData.getStatusMsg());
                this.bMl.ack();
                this.bMl.mFinished = true;
            }
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.e
    public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
        if (i == 0) {
            this.bMl.showToast(this.bMl.getPageContext().getString(z.plugin_installation_finished));
            this.bMl.ack();
            return;
        }
        this.bMl.showToast(String.valueOf(this.bMl.getPageContext().getString(z.plugin_installation_failed)) + str);
        this.bMl.ack();
    }
}
