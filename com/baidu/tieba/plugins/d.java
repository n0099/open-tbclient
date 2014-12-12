package com.baidu.tieba.plugins;

import android.widget.TextView;
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.t;
import com.baidu.tieba.z;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements com.baidu.adp.plugin.packageManager.e {
    final /* synthetic */ PluginDetailActivity bKA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(PluginDetailActivity pluginDetailActivity) {
        this.bKA = pluginDetailActivity;
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
            pluginConfig = this.bKA.bKz;
            if (id.equals(pluginConfig.package_name)) {
                z = this.bKA.mFinished;
                if (!z) {
                    textView = this.bKA.bKx;
                    ax.b(textView, t.cp_cont_d, 1);
                    textView2 = this.bKA.bKx;
                    textView2.setText(this.bKA.getPageContext().getResources().getString(z.plugin_download_percent, Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                    textView3 = this.bKA.bKx;
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
            pluginConfig = this.bKA.bKz;
            if (id.equals(pluginConfig.package_name)) {
                textView = this.bKA.bKx;
                textView.setText(this.bKA.getPageContext().getString(z.plugin_download_finished));
                textView2 = this.bKA.bKx;
                textView2.setEnabled(false);
                this.bKA.mFinished = true;
            }
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.e
    public void c(BdFileDownloadData bdFileDownloadData) {
        PluginNetConfigInfos.PluginConfig pluginConfig;
        if (bdFileDownloadData != null) {
            String id = bdFileDownloadData.getId();
            pluginConfig = this.bKA.bKz;
            if (id.equals(pluginConfig.package_name)) {
                this.bKA.showToast(bdFileDownloadData.getStatusMsg());
                this.bKA.abG();
                this.bKA.mFinished = true;
            }
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.e
    public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
        if (i == 0) {
            this.bKA.showToast(this.bKA.getPageContext().getString(z.plugin_installation_finished));
            this.bKA.abG();
            return;
        }
        this.bKA.showToast(String.valueOf(this.bKA.getPageContext().getString(z.plugin_installation_failed)) + str);
        this.bKA.abG();
    }
}
