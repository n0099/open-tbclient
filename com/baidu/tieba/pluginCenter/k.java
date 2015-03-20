package com.baidu.tieba.pluginCenter;

import android.widget.TextView;
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
class k implements com.baidu.adp.plugin.packageManager.i {
    final /* synthetic */ j bUJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.bUJ = jVar;
    }

    @Override // com.baidu.adp.plugin.packageManager.i
    public void a(BdFileDownloadData bdFileDownloadData) {
        g gVar;
        PluginDownloadActivity pluginDownloadActivity;
        PluginNetConfigInfos.PluginConfig pluginConfig;
        g gVar2;
        PluginDownloadActivity pluginDownloadActivity2;
        boolean z;
        g gVar3;
        PluginDownloadActivity pluginDownloadActivity3;
        g gVar4;
        TextView textView;
        g gVar5;
        PluginDownloadActivity pluginDownloadActivity4;
        g gVar6;
        TextView textView2;
        if (bdFileDownloadData != null) {
            String id = bdFileDownloadData.getId();
            gVar = this.bUJ.bUI;
            pluginDownloadActivity = gVar.bUy;
            pluginConfig = pluginDownloadActivity.bUu;
            if (id.equals(pluginConfig.package_name)) {
                gVar2 = this.bUJ.bUI;
                pluginDownloadActivity2 = gVar2.bUy;
                z = pluginDownloadActivity2.mFinished;
                if (!z) {
                    gVar3 = this.bUJ.bUI;
                    pluginDownloadActivity3 = gVar3.bUy;
                    gVar4 = pluginDownloadActivity3.bUw;
                    textView = gVar4.bUC;
                    textView.setText(String.format("正在下载插件：%d%%", Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                    gVar5 = this.bUJ.bUI;
                    pluginDownloadActivity4 = gVar5.bUy;
                    gVar6 = pluginDownloadActivity4.bUw;
                    textView2 = gVar6.bUC;
                    textView2.setEnabled(false);
                }
            }
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.i
    public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
        g gVar;
        PluginDownloadActivity pluginDownloadActivity;
        g gVar2;
        PluginDownloadActivity pluginDownloadActivity2;
        g gVar3;
        PluginDownloadActivity pluginDownloadActivity3;
        g gVar4;
        PluginDownloadActivity pluginDownloadActivity4;
        g gVar5;
        PluginDownloadActivity pluginDownloadActivity5;
        g gVar6;
        PluginDownloadActivity pluginDownloadActivity6;
        g gVar7;
        PluginDownloadActivity pluginDownloadActivity7;
        g gVar8;
        PluginDownloadActivity pluginDownloadActivity8;
        g gVar9;
        PluginDownloadActivity pluginDownloadActivity9;
        g gVar10;
        PluginDownloadActivity pluginDownloadActivity10;
        if (i == 0) {
            gVar6 = this.bUJ.bUI;
            pluginDownloadActivity6 = gVar6.bUy;
            gVar7 = this.bUJ.bUI;
            pluginDownloadActivity7 = gVar7.bUy;
            pluginDownloadActivity6.showToast(pluginDownloadActivity7.getPageContext().getString(y.plugin_installation_finished));
            gVar8 = this.bUJ.bUI;
            pluginDownloadActivity8 = gVar8.bUy;
            pluginDownloadActivity8.setResult(-1);
            gVar9 = this.bUJ.bUI;
            pluginDownloadActivity9 = gVar9.bUy;
            pluginDownloadActivity9.setResult(-1);
            gVar10 = this.bUJ.bUI;
            pluginDownloadActivity10 = gVar10.bUy;
            pluginDownloadActivity10.finish();
            return;
        }
        gVar = this.bUJ.bUI;
        pluginDownloadActivity = gVar.bUy;
        pluginDownloadActivity.setResult(0);
        gVar2 = this.bUJ.bUI;
        pluginDownloadActivity2 = gVar2.bUy;
        gVar3 = this.bUJ.bUI;
        pluginDownloadActivity3 = gVar3.bUy;
        pluginDownloadActivity2.showToast(pluginDownloadActivity3.getPageContext().getString(y.plugin_installation_failed), false);
        gVar4 = this.bUJ.bUI;
        pluginDownloadActivity4 = gVar4.bUy;
        pluginDownloadActivity4.setResult(0);
        gVar5 = this.bUJ.bUI;
        pluginDownloadActivity5 = gVar5.bUy;
        pluginDownloadActivity5.finish();
    }

    @Override // com.baidu.adp.plugin.packageManager.i
    public void b(BdFileDownloadData bdFileDownloadData) {
        g gVar;
        PluginDownloadActivity pluginDownloadActivity;
        PluginNetConfigInfos.PluginConfig pluginConfig;
        g gVar2;
        PluginDownloadActivity pluginDownloadActivity2;
        g gVar3;
        TextView textView;
        g gVar4;
        PluginDownloadActivity pluginDownloadActivity3;
        g gVar5;
        PluginDownloadActivity pluginDownloadActivity4;
        g gVar6;
        TextView textView2;
        g gVar7;
        PluginDownloadActivity pluginDownloadActivity5;
        if (bdFileDownloadData != null) {
            String id = bdFileDownloadData.getId();
            gVar = this.bUJ.bUI;
            pluginDownloadActivity = gVar.bUy;
            pluginConfig = pluginDownloadActivity.bUu;
            if (id.equals(pluginConfig.package_name)) {
                gVar2 = this.bUJ.bUI;
                pluginDownloadActivity2 = gVar2.bUy;
                gVar3 = pluginDownloadActivity2.bUw;
                textView = gVar3.bUC;
                gVar4 = this.bUJ.bUI;
                pluginDownloadActivity3 = gVar4.bUy;
                textView.setText(pluginDownloadActivity3.getPageContext().getString(y.plugin_download_finished));
                gVar5 = this.bUJ.bUI;
                pluginDownloadActivity4 = gVar5.bUy;
                gVar6 = pluginDownloadActivity4.bUw;
                textView2 = gVar6.bUC;
                textView2.setEnabled(false);
                gVar7 = this.bUJ.bUI;
                pluginDownloadActivity5 = gVar7.bUy;
                pluginDownloadActivity5.mFinished = true;
            }
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.i
    public void c(BdFileDownloadData bdFileDownloadData) {
        g gVar;
        PluginDownloadActivity pluginDownloadActivity;
        PluginNetConfigInfos.PluginConfig pluginConfig;
        g gVar2;
        PluginDownloadActivity pluginDownloadActivity2;
        g gVar3;
        PluginDownloadActivity pluginDownloadActivity3;
        g gVar4;
        PluginDownloadActivity pluginDownloadActivity4;
        g gVar5;
        if (bdFileDownloadData != null) {
            String id = bdFileDownloadData.getId();
            gVar = this.bUJ.bUI;
            pluginDownloadActivity = gVar.bUy;
            pluginConfig = pluginDownloadActivity.bUu;
            if (id.equals(pluginConfig.package_name)) {
                gVar2 = this.bUJ.bUI;
                pluginDownloadActivity2 = gVar2.bUy;
                pluginDownloadActivity2.showToast(bdFileDownloadData.getStatusMsg());
                gVar3 = this.bUJ.bUI;
                pluginDownloadActivity3 = gVar3.bUy;
                pluginDownloadActivity3.mFinished = true;
                gVar4 = this.bUJ.bUI;
                pluginDownloadActivity4 = gVar4.bUy;
                gVar5 = pluginDownloadActivity4.bUw;
                gVar5.dismiss();
            }
        }
    }
}
