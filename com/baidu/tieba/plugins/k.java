package com.baidu.tieba.plugins;

import android.widget.TextView;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.pluginArch.bean.ConfigInfos;
import com.baidu.tieba.x;
/* loaded from: classes.dex */
class k implements com.baidu.tbadk.pluginArch.i {
    final /* synthetic */ j a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.a = jVar;
    }

    @Override // com.baidu.tbadk.pluginArch.i
    public void a(DownloadData downloadData) {
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
            gVar = this.a.a;
            pluginDownloadActivity = gVar.a;
            pluginConfig = pluginDownloadActivity.b;
            if (id.equals(pluginConfig.name)) {
                gVar2 = this.a.a;
                pluginDownloadActivity2 = gVar2.a;
                z = pluginDownloadActivity2.c;
                if (!z) {
                    gVar3 = this.a.a;
                    pluginDownloadActivity3 = gVar3.a;
                    gVar4 = pluginDownloadActivity3.a;
                    textView = gVar4.g;
                    textView.setText(String.format("正在下载插件：%d%%", Long.valueOf((downloadData.getLength() * 100) / downloadData.getSize())));
                    gVar5 = this.a.a;
                    pluginDownloadActivity4 = gVar5.a;
                    gVar6 = pluginDownloadActivity4.a;
                    textView2 = gVar6.g;
                    textView2.setEnabled(false);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.pluginArch.i
    public void a(int i, String str) {
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
            gVar6 = this.a.a;
            pluginDownloadActivity6 = gVar6.a;
            gVar7 = this.a.a;
            pluginDownloadActivity7 = gVar7.a;
            pluginDownloadActivity6.showToast(pluginDownloadActivity7.getString(x.plugin_installation_finished));
            gVar8 = this.a.a;
            pluginDownloadActivity8 = gVar8.a;
            pluginDownloadActivity8.setResult(-1);
            gVar9 = this.a.a;
            pluginDownloadActivity9 = gVar9.a;
            pluginDownloadActivity9.setResult(-1);
            gVar10 = this.a.a;
            pluginDownloadActivity10 = gVar10.a;
            pluginDownloadActivity10.finish();
            return;
        }
        gVar = this.a.a;
        pluginDownloadActivity = gVar.a;
        pluginDownloadActivity.setResult(0);
        gVar2 = this.a.a;
        pluginDownloadActivity2 = gVar2.a;
        gVar3 = this.a.a;
        pluginDownloadActivity3 = gVar3.a;
        pluginDownloadActivity2.showToast(pluginDownloadActivity3.getString(x.plugin_installation_failed), false);
        gVar4 = this.a.a;
        pluginDownloadActivity4 = gVar4.a;
        pluginDownloadActivity4.setResult(0);
        gVar5 = this.a.a;
        pluginDownloadActivity5 = gVar5.a;
        pluginDownloadActivity5.finish();
    }

    @Override // com.baidu.tbadk.pluginArch.i
    public void b(DownloadData downloadData) {
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
            gVar = this.a.a;
            pluginDownloadActivity = gVar.a;
            pluginConfig = pluginDownloadActivity.b;
            if (id.equals(pluginConfig.name)) {
                gVar2 = this.a.a;
                pluginDownloadActivity2 = gVar2.a;
                gVar3 = pluginDownloadActivity2.a;
                textView = gVar3.g;
                gVar4 = this.a.a;
                pluginDownloadActivity3 = gVar4.a;
                textView.setText(pluginDownloadActivity3.getString(x.plugin_download_finished));
                gVar5 = this.a.a;
                pluginDownloadActivity4 = gVar5.a;
                gVar6 = pluginDownloadActivity4.a;
                textView2 = gVar6.g;
                textView2.setEnabled(false);
                gVar7 = this.a.a;
                pluginDownloadActivity5 = gVar7.a;
                pluginDownloadActivity5.c = true;
            }
        }
    }

    @Override // com.baidu.tbadk.pluginArch.i
    public void c(DownloadData downloadData) {
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
            gVar = this.a.a;
            pluginDownloadActivity = gVar.a;
            pluginConfig = pluginDownloadActivity.b;
            if (id.equals(pluginConfig.name)) {
                gVar2 = this.a.a;
                pluginDownloadActivity2 = gVar2.a;
                pluginDownloadActivity2.showToast(downloadData.getStatusMsg());
                gVar3 = this.a.a;
                pluginDownloadActivity3 = gVar3.a;
                pluginDownloadActivity3.c = true;
                gVar4 = this.a.a;
                pluginDownloadActivity4 = gVar4.a;
                gVar5 = pluginDownloadActivity4.a;
                gVar5.dismiss();
            }
        }
    }
}
