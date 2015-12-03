package com.baidu.tieba.pluginCenter;

import android.widget.TextView;
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.tieba.n;
import com.baidu.tieba.pluginCenter.PluginDownloadActivity;
/* loaded from: classes.dex */
class o implements com.baidu.adp.plugin.packageManager.e {
    final /* synthetic */ n ddS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.ddS = nVar;
    }

    @Override // com.baidu.adp.plugin.packageManager.e
    public void a(BdFileDownloadData bdFileDownloadData) {
        PluginDownloadActivity.a aVar;
        PluginDownloadActivity pluginDownloadActivity;
        PluginDownloadActivity.a aVar2;
        PluginDownloadActivity pluginDownloadActivity2;
        boolean z;
        PluginDownloadActivity.a aVar3;
        PluginDownloadActivity pluginDownloadActivity3;
        PluginDownloadActivity.a aVar4;
        TextView textView;
        PluginDownloadActivity.a aVar5;
        PluginDownloadActivity pluginDownloadActivity4;
        PluginDownloadActivity.a aVar6;
        TextView textView2;
        if (bdFileDownloadData != null) {
            String id = bdFileDownloadData.getId();
            aVar = this.ddS.ddR;
            pluginDownloadActivity = PluginDownloadActivity.this;
            if (id.equals(pluginDownloadActivity.ddC.package_name)) {
                aVar2 = this.ddS.ddR;
                pluginDownloadActivity2 = PluginDownloadActivity.this;
                z = pluginDownloadActivity2.ddD;
                if (!z) {
                    aVar3 = this.ddS.ddR;
                    pluginDownloadActivity3 = PluginDownloadActivity.this;
                    aVar4 = pluginDownloadActivity3.ddF;
                    textView = aVar4.ddL;
                    textView.setText(String.format("正在下载插件：%d%%", Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                    aVar5 = this.ddS.ddR;
                    pluginDownloadActivity4 = PluginDownloadActivity.this;
                    aVar6 = pluginDownloadActivity4.ddF;
                    textView2 = aVar6.ddL;
                    textView2.setEnabled(false);
                }
            }
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.e
    public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
        PluginDownloadActivity.a aVar;
        PluginDownloadActivity pluginDownloadActivity;
        PluginDownloadActivity.a aVar2;
        PluginDownloadActivity pluginDownloadActivity2;
        PluginDownloadActivity.a aVar3;
        PluginDownloadActivity pluginDownloadActivity3;
        PluginDownloadActivity.a aVar4;
        PluginDownloadActivity pluginDownloadActivity4;
        PluginDownloadActivity.a aVar5;
        PluginDownloadActivity pluginDownloadActivity5;
        PluginDownloadActivity.a aVar6;
        PluginDownloadActivity pluginDownloadActivity6;
        PluginDownloadActivity.a aVar7;
        PluginDownloadActivity pluginDownloadActivity7;
        PluginDownloadActivity.a aVar8;
        PluginDownloadActivity pluginDownloadActivity8;
        PluginDownloadActivity.a aVar9;
        PluginDownloadActivity pluginDownloadActivity9;
        PluginDownloadActivity.a aVar10;
        PluginDownloadActivity pluginDownloadActivity10;
        if (i == 0) {
            aVar6 = this.ddS.ddR;
            pluginDownloadActivity6 = PluginDownloadActivity.this;
            aVar7 = this.ddS.ddR;
            pluginDownloadActivity7 = PluginDownloadActivity.this;
            pluginDownloadActivity6.showToast(pluginDownloadActivity7.getPageContext().getString(n.i.plugin_installation_finished));
            aVar8 = this.ddS.ddR;
            pluginDownloadActivity8 = PluginDownloadActivity.this;
            pluginDownloadActivity8.setResult(-1);
            aVar9 = this.ddS.ddR;
            pluginDownloadActivity9 = PluginDownloadActivity.this;
            pluginDownloadActivity9.setResult(-1);
            aVar10 = this.ddS.ddR;
            pluginDownloadActivity10 = PluginDownloadActivity.this;
            pluginDownloadActivity10.finish();
            return;
        }
        aVar = this.ddS.ddR;
        pluginDownloadActivity = PluginDownloadActivity.this;
        pluginDownloadActivity.setResult(0);
        aVar2 = this.ddS.ddR;
        pluginDownloadActivity2 = PluginDownloadActivity.this;
        aVar3 = this.ddS.ddR;
        pluginDownloadActivity3 = PluginDownloadActivity.this;
        pluginDownloadActivity2.showToast(pluginDownloadActivity3.getPageContext().getString(n.i.plugin_installation_failed), false);
        aVar4 = this.ddS.ddR;
        pluginDownloadActivity4 = PluginDownloadActivity.this;
        pluginDownloadActivity4.setResult(0);
        aVar5 = this.ddS.ddR;
        pluginDownloadActivity5 = PluginDownloadActivity.this;
        pluginDownloadActivity5.finish();
    }

    @Override // com.baidu.adp.plugin.packageManager.e
    public void b(BdFileDownloadData bdFileDownloadData) {
        PluginDownloadActivity.a aVar;
        PluginDownloadActivity pluginDownloadActivity;
        PluginDownloadActivity.a aVar2;
        PluginDownloadActivity pluginDownloadActivity2;
        PluginDownloadActivity.a aVar3;
        TextView textView;
        PluginDownloadActivity.a aVar4;
        PluginDownloadActivity pluginDownloadActivity3;
        PluginDownloadActivity.a aVar5;
        PluginDownloadActivity pluginDownloadActivity4;
        PluginDownloadActivity.a aVar6;
        TextView textView2;
        PluginDownloadActivity.a aVar7;
        PluginDownloadActivity pluginDownloadActivity5;
        if (bdFileDownloadData != null) {
            String id = bdFileDownloadData.getId();
            aVar = this.ddS.ddR;
            pluginDownloadActivity = PluginDownloadActivity.this;
            if (id.equals(pluginDownloadActivity.ddC.package_name)) {
                aVar2 = this.ddS.ddR;
                pluginDownloadActivity2 = PluginDownloadActivity.this;
                aVar3 = pluginDownloadActivity2.ddF;
                textView = aVar3.ddL;
                aVar4 = this.ddS.ddR;
                pluginDownloadActivity3 = PluginDownloadActivity.this;
                textView.setText(pluginDownloadActivity3.getPageContext().getString(n.i.plugin_download_finished));
                aVar5 = this.ddS.ddR;
                pluginDownloadActivity4 = PluginDownloadActivity.this;
                aVar6 = pluginDownloadActivity4.ddF;
                textView2 = aVar6.ddL;
                textView2.setEnabled(false);
                aVar7 = this.ddS.ddR;
                pluginDownloadActivity5 = PluginDownloadActivity.this;
                pluginDownloadActivity5.ddD = true;
            }
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.e
    public void c(BdFileDownloadData bdFileDownloadData) {
        PluginDownloadActivity.a aVar;
        PluginDownloadActivity pluginDownloadActivity;
        PluginDownloadActivity.a aVar2;
        PluginDownloadActivity pluginDownloadActivity2;
        PluginDownloadActivity.a aVar3;
        PluginDownloadActivity pluginDownloadActivity3;
        PluginDownloadActivity.a aVar4;
        PluginDownloadActivity pluginDownloadActivity4;
        PluginDownloadActivity.a aVar5;
        PluginDownloadActivity.a aVar6;
        PluginDownloadActivity pluginDownloadActivity5;
        if (bdFileDownloadData != null) {
            String id = bdFileDownloadData.getId();
            aVar = this.ddS.ddR;
            pluginDownloadActivity = PluginDownloadActivity.this;
            if (id.equals(pluginDownloadActivity.ddC.package_name)) {
                aVar2 = this.ddS.ddR;
                pluginDownloadActivity2 = PluginDownloadActivity.this;
                pluginDownloadActivity2.showToast(bdFileDownloadData.getStatusMsg());
                aVar3 = this.ddS.ddR;
                pluginDownloadActivity3 = PluginDownloadActivity.this;
                pluginDownloadActivity3.ddD = true;
                aVar4 = this.ddS.ddR;
                pluginDownloadActivity4 = PluginDownloadActivity.this;
                aVar5 = pluginDownloadActivity4.ddF;
                aVar6 = this.ddS.ddR;
                pluginDownloadActivity5 = PluginDownloadActivity.this;
                com.baidu.adp.lib.h.j.b(aVar5, pluginDownloadActivity5.getPageContext());
            }
        }
    }
}
