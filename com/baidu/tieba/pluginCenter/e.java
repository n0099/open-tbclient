package com.baidu.tieba.pluginCenter;

import android.widget.TextView;
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class e implements com.baidu.adp.plugin.packageManager.d {
    final /* synthetic */ PluginDetailActivity coj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(PluginDetailActivity pluginDetailActivity) {
        this.coj = pluginDetailActivity;
    }

    @Override // com.baidu.adp.plugin.packageManager.d
    public void a(BdFileDownloadData bdFileDownloadData) {
        PluginNetConfigInfos.PluginConfig pluginConfig;
        boolean z;
        TextView textView;
        TextView textView2;
        TextView textView3;
        if (bdFileDownloadData != null) {
            String id = bdFileDownloadData.getId();
            pluginConfig = this.coj.coh;
            if (id.equals(pluginConfig.package_name)) {
                z = this.coj.coi;
                if (!z) {
                    textView = this.coj.cog;
                    al.b(textView, i.c.cp_cont_d, 1);
                    textView2 = this.coj.cog;
                    textView2.setText(this.coj.getPageContext().getResources().getString(i.C0057i.plugin_download_percent, Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                    textView3 = this.coj.cog;
                    textView3.setEnabled(false);
                }
            }
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.d
    public void b(BdFileDownloadData bdFileDownloadData) {
        PluginNetConfigInfos.PluginConfig pluginConfig;
        TextView textView;
        TextView textView2;
        if (bdFileDownloadData != null) {
            String id = bdFileDownloadData.getId();
            pluginConfig = this.coj.coh;
            if (id.equals(pluginConfig.package_name)) {
                textView = this.coj.cog;
                textView.setText(this.coj.getPageContext().getString(i.C0057i.plugin_download_finished));
                textView2 = this.coj.cog;
                textView2.setEnabled(false);
                this.coj.coi = true;
            }
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.d
    public void c(BdFileDownloadData bdFileDownloadData) {
        PluginNetConfigInfos.PluginConfig pluginConfig;
        if (bdFileDownloadData != null) {
            String id = bdFileDownloadData.getId();
            pluginConfig = this.coj.coh;
            if (id.equals(pluginConfig.package_name)) {
                this.coj.showToast(bdFileDownloadData.getStatusMsg());
                this.coj.ahM();
                this.coj.coi = true;
            }
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.d
    public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
        if (i == 0) {
            this.coj.showToast(this.coj.getPageContext().getString(i.C0057i.plugin_installation_finished));
            this.coj.ahM();
            return;
        }
        this.coj.showToast(String.valueOf(this.coj.getPageContext().getString(i.C0057i.plugin_installation_failed)) + str);
        this.coj.ahM();
    }
}
