package com.baidu.tieba.pluginCenter;

import android.widget.TextView;
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.s;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
class c implements com.baidu.adp.plugin.packageManager.i {
    final /* synthetic */ PluginDetailActivity bUL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(PluginDetailActivity pluginDetailActivity) {
        this.bUL = pluginDetailActivity;
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
            pluginConfig = this.bUL.bUK;
            if (id.equals(pluginConfig.package_name)) {
                z = this.bUL.mFinished;
                if (!z) {
                    textView = this.bUL.bUI;
                    ba.b(textView, s.cp_cont_d, 1);
                    textView2 = this.bUL.bUI;
                    textView2.setText(this.bUL.getPageContext().getResources().getString(y.plugin_download_percent, Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                    textView3 = this.bUL.bUI;
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
            pluginConfig = this.bUL.bUK;
            if (id.equals(pluginConfig.package_name)) {
                textView = this.bUL.bUI;
                textView.setText(this.bUL.getPageContext().getString(y.plugin_download_finished));
                textView2 = this.bUL.bUI;
                textView2.setEnabled(false);
                this.bUL.mFinished = true;
            }
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.i
    public void c(BdFileDownloadData bdFileDownloadData) {
        PluginNetConfigInfos.PluginConfig pluginConfig;
        if (bdFileDownloadData != null) {
            String id = bdFileDownloadData.getId();
            pluginConfig = this.bUL.bUK;
            if (id.equals(pluginConfig.package_name)) {
                this.bUL.showToast(bdFileDownloadData.getStatusMsg());
                this.bUL.aeI();
                this.bUL.mFinished = true;
            }
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.i
    public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
        if (i == 0) {
            this.bUL.showToast(this.bUL.getPageContext().getString(y.plugin_installation_finished));
            this.bUL.aeI();
            return;
        }
        this.bUL.showToast(String.valueOf(this.bUL.getPageContext().getString(y.plugin_installation_failed)) + str);
        this.bUL.aeI();
    }
}
