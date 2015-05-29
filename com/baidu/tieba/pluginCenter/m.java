package com.baidu.tieba.pluginCenter;

import android.widget.TextView;
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class m implements com.baidu.adp.plugin.packageManager.i {
    final /* synthetic */ l bXD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.bXD = lVar;
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
            iVar = this.bXD.bXC;
            pluginDownloadActivity = iVar.bXs;
            pluginConfig = pluginDownloadActivity.bXo;
            if (id.equals(pluginConfig.package_name)) {
                iVar2 = this.bXD.bXC;
                pluginDownloadActivity2 = iVar2.bXs;
                z = pluginDownloadActivity2.mFinished;
                if (!z) {
                    iVar3 = this.bXD.bXC;
                    pluginDownloadActivity3 = iVar3.bXs;
                    iVar4 = pluginDownloadActivity3.bXq;
                    textView = iVar4.bXw;
                    textView.setText(String.format("正在下载插件：%d%%", Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                    iVar5 = this.bXD.bXC;
                    pluginDownloadActivity4 = iVar5.bXs;
                    iVar6 = pluginDownloadActivity4.bXq;
                    textView2 = iVar6.bXw;
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
            iVar6 = this.bXD.bXC;
            pluginDownloadActivity6 = iVar6.bXs;
            iVar7 = this.bXD.bXC;
            pluginDownloadActivity7 = iVar7.bXs;
            pluginDownloadActivity6.showToast(pluginDownloadActivity7.getPageContext().getString(t.plugin_installation_finished));
            iVar8 = this.bXD.bXC;
            pluginDownloadActivity8 = iVar8.bXs;
            pluginDownloadActivity8.setResult(-1);
            iVar9 = this.bXD.bXC;
            pluginDownloadActivity9 = iVar9.bXs;
            pluginDownloadActivity9.setResult(-1);
            iVar10 = this.bXD.bXC;
            pluginDownloadActivity10 = iVar10.bXs;
            pluginDownloadActivity10.finish();
            return;
        }
        iVar = this.bXD.bXC;
        pluginDownloadActivity = iVar.bXs;
        pluginDownloadActivity.setResult(0);
        iVar2 = this.bXD.bXC;
        pluginDownloadActivity2 = iVar2.bXs;
        iVar3 = this.bXD.bXC;
        pluginDownloadActivity3 = iVar3.bXs;
        pluginDownloadActivity2.showToast(pluginDownloadActivity3.getPageContext().getString(t.plugin_installation_failed), false);
        iVar4 = this.bXD.bXC;
        pluginDownloadActivity4 = iVar4.bXs;
        pluginDownloadActivity4.setResult(0);
        iVar5 = this.bXD.bXC;
        pluginDownloadActivity5 = iVar5.bXs;
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
            iVar = this.bXD.bXC;
            pluginDownloadActivity = iVar.bXs;
            pluginConfig = pluginDownloadActivity.bXo;
            if (id.equals(pluginConfig.package_name)) {
                iVar2 = this.bXD.bXC;
                pluginDownloadActivity2 = iVar2.bXs;
                iVar3 = pluginDownloadActivity2.bXq;
                textView = iVar3.bXw;
                iVar4 = this.bXD.bXC;
                pluginDownloadActivity3 = iVar4.bXs;
                textView.setText(pluginDownloadActivity3.getPageContext().getString(t.plugin_download_finished));
                iVar5 = this.bXD.bXC;
                pluginDownloadActivity4 = iVar5.bXs;
                iVar6 = pluginDownloadActivity4.bXq;
                textView2 = iVar6.bXw;
                textView2.setEnabled(false);
                iVar7 = this.bXD.bXC;
                pluginDownloadActivity5 = iVar7.bXs;
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
            iVar = this.bXD.bXC;
            pluginDownloadActivity = iVar.bXs;
            pluginConfig = pluginDownloadActivity.bXo;
            if (id.equals(pluginConfig.package_name)) {
                iVar2 = this.bXD.bXC;
                pluginDownloadActivity2 = iVar2.bXs;
                pluginDownloadActivity2.showToast(bdFileDownloadData.getStatusMsg());
                iVar3 = this.bXD.bXC;
                pluginDownloadActivity3 = iVar3.bXs;
                pluginDownloadActivity3.mFinished = true;
                iVar4 = this.bXD.bXC;
                pluginDownloadActivity4 = iVar4.bXs;
                iVar5 = pluginDownloadActivity4.bXq;
                iVar5.dismiss();
            }
        }
    }
}
