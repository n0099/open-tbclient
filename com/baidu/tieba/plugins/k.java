package com.baidu.tieba.plugins;

import android.widget.TextView;
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
class k implements com.baidu.adp.plugin.packageManager.e {
    final /* synthetic */ j bMz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.bMz = jVar;
    }

    @Override // com.baidu.adp.plugin.packageManager.e
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
            gVar = this.bMz.bMy;
            pluginDownloadActivity = gVar.bMo;
            pluginConfig = pluginDownloadActivity.bMk;
            if (id.equals(pluginConfig.package_name)) {
                gVar2 = this.bMz.bMy;
                pluginDownloadActivity2 = gVar2.bMo;
                z = pluginDownloadActivity2.mFinished;
                if (!z) {
                    gVar3 = this.bMz.bMy;
                    pluginDownloadActivity3 = gVar3.bMo;
                    gVar4 = pluginDownloadActivity3.bMm;
                    textView = gVar4.bMs;
                    textView.setText(String.format("正在下载插件：%d%%", Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                    gVar5 = this.bMz.bMy;
                    pluginDownloadActivity4 = gVar5.bMo;
                    gVar6 = pluginDownloadActivity4.bMm;
                    textView2 = gVar6.bMs;
                    textView2.setEnabled(false);
                }
            }
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.e
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
            gVar6 = this.bMz.bMy;
            pluginDownloadActivity6 = gVar6.bMo;
            gVar7 = this.bMz.bMy;
            pluginDownloadActivity7 = gVar7.bMo;
            pluginDownloadActivity6.showToast(pluginDownloadActivity7.getPageContext().getString(z.plugin_installation_finished));
            gVar8 = this.bMz.bMy;
            pluginDownloadActivity8 = gVar8.bMo;
            pluginDownloadActivity8.setResult(-1);
            gVar9 = this.bMz.bMy;
            pluginDownloadActivity9 = gVar9.bMo;
            pluginDownloadActivity9.setResult(-1);
            gVar10 = this.bMz.bMy;
            pluginDownloadActivity10 = gVar10.bMo;
            pluginDownloadActivity10.finish();
            return;
        }
        gVar = this.bMz.bMy;
        pluginDownloadActivity = gVar.bMo;
        pluginDownloadActivity.setResult(0);
        gVar2 = this.bMz.bMy;
        pluginDownloadActivity2 = gVar2.bMo;
        gVar3 = this.bMz.bMy;
        pluginDownloadActivity3 = gVar3.bMo;
        pluginDownloadActivity2.showToast(pluginDownloadActivity3.getPageContext().getString(z.plugin_installation_failed), false);
        gVar4 = this.bMz.bMy;
        pluginDownloadActivity4 = gVar4.bMo;
        pluginDownloadActivity4.setResult(0);
        gVar5 = this.bMz.bMy;
        pluginDownloadActivity5 = gVar5.bMo;
        pluginDownloadActivity5.finish();
    }

    @Override // com.baidu.adp.plugin.packageManager.e
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
            gVar = this.bMz.bMy;
            pluginDownloadActivity = gVar.bMo;
            pluginConfig = pluginDownloadActivity.bMk;
            if (id.equals(pluginConfig.package_name)) {
                gVar2 = this.bMz.bMy;
                pluginDownloadActivity2 = gVar2.bMo;
                gVar3 = pluginDownloadActivity2.bMm;
                textView = gVar3.bMs;
                gVar4 = this.bMz.bMy;
                pluginDownloadActivity3 = gVar4.bMo;
                textView.setText(pluginDownloadActivity3.getPageContext().getString(z.plugin_download_finished));
                gVar5 = this.bMz.bMy;
                pluginDownloadActivity4 = gVar5.bMo;
                gVar6 = pluginDownloadActivity4.bMm;
                textView2 = gVar6.bMs;
                textView2.setEnabled(false);
                gVar7 = this.bMz.bMy;
                pluginDownloadActivity5 = gVar7.bMo;
                pluginDownloadActivity5.mFinished = true;
            }
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.e
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
            gVar = this.bMz.bMy;
            pluginDownloadActivity = gVar.bMo;
            pluginConfig = pluginDownloadActivity.bMk;
            if (id.equals(pluginConfig.package_name)) {
                gVar2 = this.bMz.bMy;
                pluginDownloadActivity2 = gVar2.bMo;
                pluginDownloadActivity2.showToast(bdFileDownloadData.getStatusMsg());
                gVar3 = this.bMz.bMy;
                pluginDownloadActivity3 = gVar3.bMo;
                pluginDownloadActivity3.mFinished = true;
                gVar4 = this.bMz.bMy;
                pluginDownloadActivity4 = gVar4.bMo;
                gVar5 = pluginDownloadActivity4.bMm;
                gVar5.dismiss();
            }
        }
    }
}
