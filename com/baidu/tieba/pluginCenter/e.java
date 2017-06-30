package com.baidu.tieba.pluginCenter;

import android.widget.TextView;
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.w;
/* loaded from: classes2.dex */
class e implements com.baidu.adp.plugin.packageManager.e {
    final /* synthetic */ PluginDetailActivity fmQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(PluginDetailActivity pluginDetailActivity) {
        this.fmQ = pluginDetailActivity;
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
            pluginConfig = this.fmQ.fmP;
            if (id.equals(pluginConfig.package_name)) {
                z = this.fmQ.cOC;
                if (!z) {
                    textView = this.fmQ.fmO;
                    as.c(textView, w.e.cp_cont_d, 1);
                    textView2 = this.fmQ.fmO;
                    textView2.setText(this.fmQ.getPageContext().getResources().getString(w.l.plugin_download_percent, Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                    textView3 = this.fmQ.fmO;
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
            pluginConfig = this.fmQ.fmP;
            if (id.equals(pluginConfig.package_name)) {
                textView = this.fmQ.fmO;
                textView.setText(this.fmQ.getPageContext().getString(w.l.plugin_download_finished));
                textView2 = this.fmQ.fmO;
                textView2.setEnabled(false);
                this.fmQ.cOC = true;
            }
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.e
    public void c(BdFileDownloadData bdFileDownloadData) {
        PluginNetConfigInfos.PluginConfig pluginConfig;
        if (bdFileDownloadData != null) {
            String id = bdFileDownloadData.getId();
            pluginConfig = this.fmQ.fmP;
            if (id.equals(pluginConfig.package_name)) {
                this.fmQ.showToast(bdFileDownloadData.getStatusMsg());
                this.fmQ.bcr();
                this.fmQ.cOC = true;
            }
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.e
    public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
        if (i == 0) {
            this.fmQ.showToast(this.fmQ.getPageContext().getString(w.l.plugin_installation_finished));
            this.fmQ.bcr();
            return;
        }
        this.fmQ.showToast(String.valueOf(this.fmQ.getPageContext().getString(w.l.plugin_installation_failed)) + str);
        this.fmQ.bcr();
    }
}
