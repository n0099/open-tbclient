package com.baidu.tieba.plugins;

import android.widget.TextView;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.pluginArch.PluginDownloader;
import com.baidu.tbadk.pluginArch.bean.ConfigInfos;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
class k implements PluginDownloader.Callback {
    final /* synthetic */ j bHg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.bHg = jVar;
    }

    @Override // com.baidu.tbadk.pluginArch.PluginDownloader.Callback
    public void processUpdate(DownloadData downloadData) {
        g gVar;
        PluginDownloadActivity pluginDownloadActivity;
        ConfigInfos.PluginConfig pluginConfig;
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
        if (downloadData != null) {
            String id = downloadData.getId();
            gVar = this.bHg.bHf;
            pluginDownloadActivity = gVar.bGV;
            pluginConfig = pluginDownloadActivity.bGQ;
            if (id.equals(pluginConfig.name)) {
                gVar2 = this.bHg.bHf;
                pluginDownloadActivity2 = gVar2.bGV;
                z = pluginDownloadActivity2.bGR;
                if (!z) {
                    gVar3 = this.bHg.bHf;
                    pluginDownloadActivity3 = gVar3.bGV;
                    gVar4 = pluginDownloadActivity3.bGT;
                    textView = gVar4.bGZ;
                    textView.setText(String.format("正在下载插件：%d%%", Long.valueOf((downloadData.getLength() * 100) / downloadData.getSize())));
                    gVar5 = this.bHg.bHf;
                    pluginDownloadActivity4 = gVar5.bGV;
                    gVar6 = pluginDownloadActivity4.bGT;
                    textView2 = gVar6.bGZ;
                    textView2.setEnabled(false);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.pluginArch.PluginDownloader.Callback
    public void installFinish(DownloadData downloadData, int i, String str) {
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
            gVar6 = this.bHg.bHf;
            pluginDownloadActivity6 = gVar6.bGV;
            gVar7 = this.bHg.bHf;
            pluginDownloadActivity7 = gVar7.bGV;
            pluginDownloadActivity6.showToast(pluginDownloadActivity7.getString(y.plugin_installation_finished));
            gVar8 = this.bHg.bHf;
            pluginDownloadActivity8 = gVar8.bGV;
            pluginDownloadActivity8.setResult(-1);
            gVar9 = this.bHg.bHf;
            pluginDownloadActivity9 = gVar9.bGV;
            pluginDownloadActivity9.setResult(-1);
            gVar10 = this.bHg.bHf;
            pluginDownloadActivity10 = gVar10.bGV;
            pluginDownloadActivity10.finish();
            return;
        }
        gVar = this.bHg.bHf;
        pluginDownloadActivity = gVar.bGV;
        pluginDownloadActivity.setResult(0);
        gVar2 = this.bHg.bHf;
        pluginDownloadActivity2 = gVar2.bGV;
        gVar3 = this.bHg.bHf;
        pluginDownloadActivity3 = gVar3.bGV;
        pluginDownloadActivity2.showToast(pluginDownloadActivity3.getString(y.plugin_installation_failed), false);
        gVar4 = this.bHg.bHf;
        pluginDownloadActivity4 = gVar4.bGV;
        pluginDownloadActivity4.setResult(0);
        gVar5 = this.bHg.bHf;
        pluginDownloadActivity5 = gVar5.bGV;
        pluginDownloadActivity5.finish();
    }

    @Override // com.baidu.tbadk.pluginArch.PluginDownloader.Callback
    public void downloadSuccess(DownloadData downloadData) {
        g gVar;
        PluginDownloadActivity pluginDownloadActivity;
        ConfigInfos.PluginConfig pluginConfig;
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
        if (downloadData != null) {
            String id = downloadData.getId();
            gVar = this.bHg.bHf;
            pluginDownloadActivity = gVar.bGV;
            pluginConfig = pluginDownloadActivity.bGQ;
            if (id.equals(pluginConfig.name)) {
                gVar2 = this.bHg.bHf;
                pluginDownloadActivity2 = gVar2.bGV;
                gVar3 = pluginDownloadActivity2.bGT;
                textView = gVar3.bGZ;
                gVar4 = this.bHg.bHf;
                pluginDownloadActivity3 = gVar4.bGV;
                textView.setText(pluginDownloadActivity3.getString(y.plugin_download_finished));
                gVar5 = this.bHg.bHf;
                pluginDownloadActivity4 = gVar5.bGV;
                gVar6 = pluginDownloadActivity4.bGT;
                textView2 = gVar6.bGZ;
                textView2.setEnabled(false);
                gVar7 = this.bHg.bHf;
                pluginDownloadActivity5 = gVar7.bGV;
                pluginDownloadActivity5.bGR = true;
            }
        }
    }

    @Override // com.baidu.tbadk.pluginArch.PluginDownloader.Callback
    public void downloadFail(DownloadData downloadData) {
        g gVar;
        PluginDownloadActivity pluginDownloadActivity;
        ConfigInfos.PluginConfig pluginConfig;
        g gVar2;
        PluginDownloadActivity pluginDownloadActivity2;
        g gVar3;
        PluginDownloadActivity pluginDownloadActivity3;
        g gVar4;
        PluginDownloadActivity pluginDownloadActivity4;
        g gVar5;
        if (downloadData != null) {
            String id = downloadData.getId();
            gVar = this.bHg.bHf;
            pluginDownloadActivity = gVar.bGV;
            pluginConfig = pluginDownloadActivity.bGQ;
            if (id.equals(pluginConfig.name)) {
                gVar2 = this.bHg.bHf;
                pluginDownloadActivity2 = gVar2.bGV;
                pluginDownloadActivity2.showToast(downloadData.getStatusMsg());
                gVar3 = this.bHg.bHf;
                pluginDownloadActivity3 = gVar3.bGV;
                pluginDownloadActivity3.bGR = true;
                gVar4 = this.bHg.bHf;
                pluginDownloadActivity4 = gVar4.bGV;
                gVar5 = pluginDownloadActivity4.bGT;
                gVar5.dismiss();
            }
        }
    }
}
