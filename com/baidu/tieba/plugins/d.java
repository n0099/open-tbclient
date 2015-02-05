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
    final /* synthetic */ PluginDetailActivity bMk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(PluginDetailActivity pluginDetailActivity) {
        this.bMk = pluginDetailActivity;
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
            pluginConfig = this.bMk.bMj;
            if (id.equals(pluginConfig.package_name)) {
                z = this.bMk.mFinished;
                if (!z) {
                    textView = this.bMk.bMh;
                    bc.b(textView, t.cp_cont_d, 1);
                    textView2 = this.bMk.bMh;
                    textView2.setText(this.bMk.getPageContext().getResources().getString(z.plugin_download_percent, Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                    textView3 = this.bMk.bMh;
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
            pluginConfig = this.bMk.bMj;
            if (id.equals(pluginConfig.package_name)) {
                textView = this.bMk.bMh;
                textView.setText(this.bMk.getPageContext().getString(z.plugin_download_finished));
                textView2 = this.bMk.bMh;
                textView2.setEnabled(false);
                this.bMk.mFinished = true;
            }
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.e
    public void c(BdFileDownloadData bdFileDownloadData) {
        PluginNetConfigInfos.PluginConfig pluginConfig;
        if (bdFileDownloadData != null) {
            String id = bdFileDownloadData.getId();
            pluginConfig = this.bMk.bMj;
            if (id.equals(pluginConfig.package_name)) {
                this.bMk.showToast(bdFileDownloadData.getStatusMsg());
                this.bMk.acf();
                this.bMk.mFinished = true;
            }
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.e
    public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
        if (i == 0) {
            this.bMk.showToast(this.bMk.getPageContext().getString(z.plugin_installation_finished));
            this.bMk.acf();
            return;
        }
        this.bMk.showToast(String.valueOf(this.bMk.getPageContext().getString(z.plugin_installation_failed)) + str);
        this.bMk.acf();
    }
}
