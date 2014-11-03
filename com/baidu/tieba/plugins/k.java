package com.baidu.tieba.plugins;

import android.widget.TextView;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.pluginArch.PluginDownloader;
import com.baidu.tbadk.pluginArch.bean.ConfigInfos;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
class k implements PluginDownloader.Callback {
    final /* synthetic */ j bHu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.bHu = jVar;
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
            gVar = this.bHu.bHt;
            pluginDownloadActivity = gVar.bHj;
            pluginConfig = pluginDownloadActivity.bHe;
            if (id.equals(pluginConfig.name)) {
                gVar2 = this.bHu.bHt;
                pluginDownloadActivity2 = gVar2.bHj;
                z = pluginDownloadActivity2.bHf;
                if (!z) {
                    gVar3 = this.bHu.bHt;
                    pluginDownloadActivity3 = gVar3.bHj;
                    gVar4 = pluginDownloadActivity3.bHh;
                    textView = gVar4.bHn;
                    textView.setText(String.format("正在下载插件：%d%%", Long.valueOf((downloadData.getLength() * 100) / downloadData.getSize())));
                    gVar5 = this.bHu.bHt;
                    pluginDownloadActivity4 = gVar5.bHj;
                    gVar6 = pluginDownloadActivity4.bHh;
                    textView2 = gVar6.bHn;
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
            gVar6 = this.bHu.bHt;
            pluginDownloadActivity6 = gVar6.bHj;
            gVar7 = this.bHu.bHt;
            pluginDownloadActivity7 = gVar7.bHj;
            pluginDownloadActivity6.showToast(pluginDownloadActivity7.getString(y.plugin_installation_finished));
            gVar8 = this.bHu.bHt;
            pluginDownloadActivity8 = gVar8.bHj;
            pluginDownloadActivity8.setResult(-1);
            gVar9 = this.bHu.bHt;
            pluginDownloadActivity9 = gVar9.bHj;
            pluginDownloadActivity9.setResult(-1);
            gVar10 = this.bHu.bHt;
            pluginDownloadActivity10 = gVar10.bHj;
            pluginDownloadActivity10.finish();
            return;
        }
        gVar = this.bHu.bHt;
        pluginDownloadActivity = gVar.bHj;
        pluginDownloadActivity.setResult(0);
        gVar2 = this.bHu.bHt;
        pluginDownloadActivity2 = gVar2.bHj;
        gVar3 = this.bHu.bHt;
        pluginDownloadActivity3 = gVar3.bHj;
        pluginDownloadActivity2.showToast(pluginDownloadActivity3.getString(y.plugin_installation_failed), false);
        gVar4 = this.bHu.bHt;
        pluginDownloadActivity4 = gVar4.bHj;
        pluginDownloadActivity4.setResult(0);
        gVar5 = this.bHu.bHt;
        pluginDownloadActivity5 = gVar5.bHj;
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
            gVar = this.bHu.bHt;
            pluginDownloadActivity = gVar.bHj;
            pluginConfig = pluginDownloadActivity.bHe;
            if (id.equals(pluginConfig.name)) {
                gVar2 = this.bHu.bHt;
                pluginDownloadActivity2 = gVar2.bHj;
                gVar3 = pluginDownloadActivity2.bHh;
                textView = gVar3.bHn;
                gVar4 = this.bHu.bHt;
                pluginDownloadActivity3 = gVar4.bHj;
                textView.setText(pluginDownloadActivity3.getString(y.plugin_download_finished));
                gVar5 = this.bHu.bHt;
                pluginDownloadActivity4 = gVar5.bHj;
                gVar6 = pluginDownloadActivity4.bHh;
                textView2 = gVar6.bHn;
                textView2.setEnabled(false);
                gVar7 = this.bHu.bHt;
                pluginDownloadActivity5 = gVar7.bHj;
                pluginDownloadActivity5.bHf = true;
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
            gVar = this.bHu.bHt;
            pluginDownloadActivity = gVar.bHj;
            pluginConfig = pluginDownloadActivity.bHe;
            if (id.equals(pluginConfig.name)) {
                gVar2 = this.bHu.bHt;
                pluginDownloadActivity2 = gVar2.bHj;
                pluginDownloadActivity2.showToast(downloadData.getStatusMsg());
                gVar3 = this.bHu.bHt;
                pluginDownloadActivity3 = gVar3.bHj;
                pluginDownloadActivity3.bHf = true;
                gVar4 = this.bHu.bHt;
                pluginDownloadActivity4 = gVar4.bHj;
                gVar5 = pluginDownloadActivity4.bHh;
                gVar5.dismiss();
            }
        }
    }
}
