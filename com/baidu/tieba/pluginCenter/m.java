package com.baidu.tieba.pluginCenter;

import android.widget.TextView;
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class m implements com.baidu.adp.plugin.packageManager.i {
    final /* synthetic */ l bXE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.bXE = lVar;
    }

    @Override // com.baidu.adp.plugin.packageManager.i
    public void a(BdFileDownloadData bdFileDownloadData) {
        i iVar;
        PluginDownloadActivity pluginDownloadActivity;
        PluginNetConfigInfos.PluginConfig pluginConfig;
        i iVar2;
        PluginDownloadActivity pluginDownloadActivity2;
        boolean z;
        i iVar3;
        PluginDownloadActivity pluginDownloadActivity3;
        i iVar4;
        TextView textView;
        i iVar5;
        PluginDownloadActivity pluginDownloadActivity4;
        i iVar6;
        TextView textView2;
        if (bdFileDownloadData != null) {
            String id = bdFileDownloadData.getId();
            iVar = this.bXE.bXD;
            pluginDownloadActivity = iVar.bXt;
            pluginConfig = pluginDownloadActivity.bXp;
            if (id.equals(pluginConfig.package_name)) {
                iVar2 = this.bXE.bXD;
                pluginDownloadActivity2 = iVar2.bXt;
                z = pluginDownloadActivity2.mFinished;
                if (!z) {
                    iVar3 = this.bXE.bXD;
                    pluginDownloadActivity3 = iVar3.bXt;
                    iVar4 = pluginDownloadActivity3.bXr;
                    textView = iVar4.bXx;
                    textView.setText(String.format("正在下载插件：%d%%", Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                    iVar5 = this.bXE.bXD;
                    pluginDownloadActivity4 = iVar5.bXt;
                    iVar6 = pluginDownloadActivity4.bXr;
                    textView2 = iVar6.bXx;
                    textView2.setEnabled(false);
                }
            }
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.i
    public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
        i iVar;
        PluginDownloadActivity pluginDownloadActivity;
        i iVar2;
        PluginDownloadActivity pluginDownloadActivity2;
        i iVar3;
        PluginDownloadActivity pluginDownloadActivity3;
        i iVar4;
        PluginDownloadActivity pluginDownloadActivity4;
        i iVar5;
        PluginDownloadActivity pluginDownloadActivity5;
        i iVar6;
        PluginDownloadActivity pluginDownloadActivity6;
        i iVar7;
        PluginDownloadActivity pluginDownloadActivity7;
        i iVar8;
        PluginDownloadActivity pluginDownloadActivity8;
        i iVar9;
        PluginDownloadActivity pluginDownloadActivity9;
        i iVar10;
        PluginDownloadActivity pluginDownloadActivity10;
        if (i == 0) {
            iVar6 = this.bXE.bXD;
            pluginDownloadActivity6 = iVar6.bXt;
            iVar7 = this.bXE.bXD;
            pluginDownloadActivity7 = iVar7.bXt;
            pluginDownloadActivity6.showToast(pluginDownloadActivity7.getPageContext().getString(t.plugin_installation_finished));
            iVar8 = this.bXE.bXD;
            pluginDownloadActivity8 = iVar8.bXt;
            pluginDownloadActivity8.setResult(-1);
            iVar9 = this.bXE.bXD;
            pluginDownloadActivity9 = iVar9.bXt;
            pluginDownloadActivity9.setResult(-1);
            iVar10 = this.bXE.bXD;
            pluginDownloadActivity10 = iVar10.bXt;
            pluginDownloadActivity10.finish();
            return;
        }
        iVar = this.bXE.bXD;
        pluginDownloadActivity = iVar.bXt;
        pluginDownloadActivity.setResult(0);
        iVar2 = this.bXE.bXD;
        pluginDownloadActivity2 = iVar2.bXt;
        iVar3 = this.bXE.bXD;
        pluginDownloadActivity3 = iVar3.bXt;
        pluginDownloadActivity2.showToast(pluginDownloadActivity3.getPageContext().getString(t.plugin_installation_failed), false);
        iVar4 = this.bXE.bXD;
        pluginDownloadActivity4 = iVar4.bXt;
        pluginDownloadActivity4.setResult(0);
        iVar5 = this.bXE.bXD;
        pluginDownloadActivity5 = iVar5.bXt;
        pluginDownloadActivity5.finish();
    }

    @Override // com.baidu.adp.plugin.packageManager.i
    public void b(BdFileDownloadData bdFileDownloadData) {
        i iVar;
        PluginDownloadActivity pluginDownloadActivity;
        PluginNetConfigInfos.PluginConfig pluginConfig;
        i iVar2;
        PluginDownloadActivity pluginDownloadActivity2;
        i iVar3;
        TextView textView;
        i iVar4;
        PluginDownloadActivity pluginDownloadActivity3;
        i iVar5;
        PluginDownloadActivity pluginDownloadActivity4;
        i iVar6;
        TextView textView2;
        i iVar7;
        PluginDownloadActivity pluginDownloadActivity5;
        if (bdFileDownloadData != null) {
            String id = bdFileDownloadData.getId();
            iVar = this.bXE.bXD;
            pluginDownloadActivity = iVar.bXt;
            pluginConfig = pluginDownloadActivity.bXp;
            if (id.equals(pluginConfig.package_name)) {
                iVar2 = this.bXE.bXD;
                pluginDownloadActivity2 = iVar2.bXt;
                iVar3 = pluginDownloadActivity2.bXr;
                textView = iVar3.bXx;
                iVar4 = this.bXE.bXD;
                pluginDownloadActivity3 = iVar4.bXt;
                textView.setText(pluginDownloadActivity3.getPageContext().getString(t.plugin_download_finished));
                iVar5 = this.bXE.bXD;
                pluginDownloadActivity4 = iVar5.bXt;
                iVar6 = pluginDownloadActivity4.bXr;
                textView2 = iVar6.bXx;
                textView2.setEnabled(false);
                iVar7 = this.bXE.bXD;
                pluginDownloadActivity5 = iVar7.bXt;
                pluginDownloadActivity5.mFinished = true;
            }
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.i
    public void c(BdFileDownloadData bdFileDownloadData) {
        i iVar;
        PluginDownloadActivity pluginDownloadActivity;
        PluginNetConfigInfos.PluginConfig pluginConfig;
        i iVar2;
        PluginDownloadActivity pluginDownloadActivity2;
        i iVar3;
        PluginDownloadActivity pluginDownloadActivity3;
        i iVar4;
        PluginDownloadActivity pluginDownloadActivity4;
        i iVar5;
        if (bdFileDownloadData != null) {
            String id = bdFileDownloadData.getId();
            iVar = this.bXE.bXD;
            pluginDownloadActivity = iVar.bXt;
            pluginConfig = pluginDownloadActivity.bXp;
            if (id.equals(pluginConfig.package_name)) {
                iVar2 = this.bXE.bXD;
                pluginDownloadActivity2 = iVar2.bXt;
                pluginDownloadActivity2.showToast(bdFileDownloadData.getStatusMsg());
                iVar3 = this.bXE.bXD;
                pluginDownloadActivity3 = iVar3.bXt;
                pluginDownloadActivity3.mFinished = true;
                iVar4 = this.bXE.bXD;
                pluginDownloadActivity4 = iVar4.bXt;
                iVar5 = pluginDownloadActivity4.bXr;
                iVar5.dismiss();
            }
        }
    }
}
