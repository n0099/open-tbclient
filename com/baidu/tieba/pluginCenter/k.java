package com.baidu.tieba.pluginCenter;

import android.widget.TextView;
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
class k implements com.baidu.adp.plugin.packageManager.i {
    final /* synthetic */ j bUZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.bUZ = jVar;
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
            gVar = this.bUZ.bUY;
            pluginDownloadActivity = gVar.bUO;
            pluginConfig = pluginDownloadActivity.bUK;
            if (id.equals(pluginConfig.package_name)) {
                gVar2 = this.bUZ.bUY;
                pluginDownloadActivity2 = gVar2.bUO;
                z = pluginDownloadActivity2.mFinished;
                if (!z) {
                    gVar3 = this.bUZ.bUY;
                    pluginDownloadActivity3 = gVar3.bUO;
                    gVar4 = pluginDownloadActivity3.bUM;
                    textView = gVar4.bUS;
                    textView.setText(String.format("正在下载插件：%d%%", Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                    gVar5 = this.bUZ.bUY;
                    pluginDownloadActivity4 = gVar5.bUO;
                    gVar6 = pluginDownloadActivity4.bUM;
                    textView2 = gVar6.bUS;
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
            gVar6 = this.bUZ.bUY;
            pluginDownloadActivity6 = gVar6.bUO;
            gVar7 = this.bUZ.bUY;
            pluginDownloadActivity7 = gVar7.bUO;
            pluginDownloadActivity6.showToast(pluginDownloadActivity7.getPageContext().getString(y.plugin_installation_finished));
            gVar8 = this.bUZ.bUY;
            pluginDownloadActivity8 = gVar8.bUO;
            pluginDownloadActivity8.setResult(-1);
            gVar9 = this.bUZ.bUY;
            pluginDownloadActivity9 = gVar9.bUO;
            pluginDownloadActivity9.setResult(-1);
            gVar10 = this.bUZ.bUY;
            pluginDownloadActivity10 = gVar10.bUO;
            pluginDownloadActivity10.finish();
            return;
        }
        gVar = this.bUZ.bUY;
        pluginDownloadActivity = gVar.bUO;
        pluginDownloadActivity.setResult(0);
        gVar2 = this.bUZ.bUY;
        pluginDownloadActivity2 = gVar2.bUO;
        gVar3 = this.bUZ.bUY;
        pluginDownloadActivity3 = gVar3.bUO;
        pluginDownloadActivity2.showToast(pluginDownloadActivity3.getPageContext().getString(y.plugin_installation_failed), false);
        gVar4 = this.bUZ.bUY;
        pluginDownloadActivity4 = gVar4.bUO;
        pluginDownloadActivity4.setResult(0);
        gVar5 = this.bUZ.bUY;
        pluginDownloadActivity5 = gVar5.bUO;
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
            gVar = this.bUZ.bUY;
            pluginDownloadActivity = gVar.bUO;
            pluginConfig = pluginDownloadActivity.bUK;
            if (id.equals(pluginConfig.package_name)) {
                gVar2 = this.bUZ.bUY;
                pluginDownloadActivity2 = gVar2.bUO;
                gVar3 = pluginDownloadActivity2.bUM;
                textView = gVar3.bUS;
                gVar4 = this.bUZ.bUY;
                pluginDownloadActivity3 = gVar4.bUO;
                textView.setText(pluginDownloadActivity3.getPageContext().getString(y.plugin_download_finished));
                gVar5 = this.bUZ.bUY;
                pluginDownloadActivity4 = gVar5.bUO;
                gVar6 = pluginDownloadActivity4.bUM;
                textView2 = gVar6.bUS;
                textView2.setEnabled(false);
                gVar7 = this.bUZ.bUY;
                pluginDownloadActivity5 = gVar7.bUO;
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
            gVar = this.bUZ.bUY;
            pluginDownloadActivity = gVar.bUO;
            pluginConfig = pluginDownloadActivity.bUK;
            if (id.equals(pluginConfig.package_name)) {
                gVar2 = this.bUZ.bUY;
                pluginDownloadActivity2 = gVar2.bUO;
                pluginDownloadActivity2.showToast(bdFileDownloadData.getStatusMsg());
                gVar3 = this.bUZ.bUY;
                pluginDownloadActivity3 = gVar3.bUO;
                pluginDownloadActivity3.mFinished = true;
                gVar4 = this.bUZ.bUY;
                pluginDownloadActivity4 = gVar4.bUO;
                gVar5 = pluginDownloadActivity4.bUM;
                gVar5.dismiss();
            }
        }
    }
}
