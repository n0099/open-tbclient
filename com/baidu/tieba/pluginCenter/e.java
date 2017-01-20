package com.baidu.tieba.pluginCenter;

import android.widget.TextView;
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class e implements com.baidu.adp.plugin.packageManager.e {
    final /* synthetic */ PluginDetailActivity eTJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(PluginDetailActivity pluginDetailActivity) {
        this.eTJ = pluginDetailActivity;
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
            pluginConfig = this.eTJ.eTI;
            if (id.equals(pluginConfig.package_name)) {
                z = this.eTJ.cEL;
                if (!z) {
                    textView = this.eTJ.eTH;
                    ap.c(textView, r.e.cp_cont_d, 1);
                    textView2 = this.eTJ.eTH;
                    textView2.setText(this.eTJ.getPageContext().getResources().getString(r.l.plugin_download_percent, Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                    textView3 = this.eTJ.eTH;
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
            pluginConfig = this.eTJ.eTI;
            if (id.equals(pluginConfig.package_name)) {
                textView = this.eTJ.eTH;
                textView.setText(this.eTJ.getPageContext().getString(r.l.plugin_download_finished));
                textView2 = this.eTJ.eTH;
                textView2.setEnabled(false);
                this.eTJ.cEL = true;
            }
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.e
    public void c(BdFileDownloadData bdFileDownloadData) {
        PluginNetConfigInfos.PluginConfig pluginConfig;
        if (bdFileDownloadData != null) {
            String id = bdFileDownloadData.getId();
            pluginConfig = this.eTJ.eTI;
            if (id.equals(pluginConfig.package_name)) {
                this.eTJ.showToast(bdFileDownloadData.getStatusMsg());
                this.eTJ.aYz();
                this.eTJ.cEL = true;
            }
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.e
    public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
        if (i == 0) {
            this.eTJ.showToast(this.eTJ.getPageContext().getString(r.l.plugin_installation_finished));
            this.eTJ.aYz();
            return;
        }
        this.eTJ.showToast(String.valueOf(this.eTJ.getPageContext().getString(r.l.plugin_installation_failed)) + str);
        this.eTJ.aYz();
    }
}
