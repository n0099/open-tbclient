package com.baidu.tieba.pluginCenter;

import android.widget.TextView;
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.tieba.pluginCenter.PluginDownloadActivity;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class o implements com.baidu.adp.plugin.packageManager.e {
    final /* synthetic */ n eKz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.eKz = nVar;
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
            aVar = this.eKz.eKy;
            pluginDownloadActivity = PluginDownloadActivity.this;
            if (id.equals(pluginDownloadActivity.eKl.package_name)) {
                aVar2 = this.eKz.eKy;
                pluginDownloadActivity2 = PluginDownloadActivity.this;
                z = pluginDownloadActivity2.cxH;
                if (!z) {
                    aVar3 = this.eKz.eKy;
                    pluginDownloadActivity3 = PluginDownloadActivity.this;
                    aVar4 = pluginDownloadActivity3.eKn;
                    textView = aVar4.dyq;
                    textView.setText(String.format("正在下载插件：%d%%", Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                    aVar5 = this.eKz.eKy;
                    pluginDownloadActivity4 = PluginDownloadActivity.this;
                    aVar6 = pluginDownloadActivity4.eKn;
                    textView2 = aVar6.dyq;
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
            aVar6 = this.eKz.eKy;
            pluginDownloadActivity6 = PluginDownloadActivity.this;
            aVar7 = this.eKz.eKy;
            pluginDownloadActivity7 = PluginDownloadActivity.this;
            pluginDownloadActivity6.showToast(pluginDownloadActivity7.getPageContext().getString(r.j.plugin_installation_finished));
            aVar8 = this.eKz.eKy;
            pluginDownloadActivity8 = PluginDownloadActivity.this;
            pluginDownloadActivity8.setResult(-1);
            aVar9 = this.eKz.eKy;
            pluginDownloadActivity9 = PluginDownloadActivity.this;
            pluginDownloadActivity9.setResult(-1);
            aVar10 = this.eKz.eKy;
            pluginDownloadActivity10 = PluginDownloadActivity.this;
            pluginDownloadActivity10.finish();
            return;
        }
        aVar = this.eKz.eKy;
        pluginDownloadActivity = PluginDownloadActivity.this;
        pluginDownloadActivity.setResult(0);
        aVar2 = this.eKz.eKy;
        pluginDownloadActivity2 = PluginDownloadActivity.this;
        aVar3 = this.eKz.eKy;
        pluginDownloadActivity3 = PluginDownloadActivity.this;
        pluginDownloadActivity2.showToast(pluginDownloadActivity3.getPageContext().getString(r.j.plugin_installation_failed), false);
        aVar4 = this.eKz.eKy;
        pluginDownloadActivity4 = PluginDownloadActivity.this;
        pluginDownloadActivity4.setResult(0);
        aVar5 = this.eKz.eKy;
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
            aVar = this.eKz.eKy;
            pluginDownloadActivity = PluginDownloadActivity.this;
            if (id.equals(pluginDownloadActivity.eKl.package_name)) {
                aVar2 = this.eKz.eKy;
                pluginDownloadActivity2 = PluginDownloadActivity.this;
                aVar3 = pluginDownloadActivity2.eKn;
                textView = aVar3.dyq;
                aVar4 = this.eKz.eKy;
                pluginDownloadActivity3 = PluginDownloadActivity.this;
                textView.setText(pluginDownloadActivity3.getPageContext().getString(r.j.plugin_download_finished));
                aVar5 = this.eKz.eKy;
                pluginDownloadActivity4 = PluginDownloadActivity.this;
                aVar6 = pluginDownloadActivity4.eKn;
                textView2 = aVar6.dyq;
                textView2.setEnabled(false);
                aVar7 = this.eKz.eKy;
                pluginDownloadActivity5 = PluginDownloadActivity.this;
                pluginDownloadActivity5.cxH = true;
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
            aVar = this.eKz.eKy;
            pluginDownloadActivity = PluginDownloadActivity.this;
            if (id.equals(pluginDownloadActivity.eKl.package_name)) {
                aVar2 = this.eKz.eKy;
                pluginDownloadActivity2 = PluginDownloadActivity.this;
                pluginDownloadActivity2.showToast(bdFileDownloadData.getStatusMsg());
                aVar3 = this.eKz.eKy;
                pluginDownloadActivity3 = PluginDownloadActivity.this;
                pluginDownloadActivity3.cxH = true;
                aVar4 = this.eKz.eKy;
                pluginDownloadActivity4 = PluginDownloadActivity.this;
                aVar5 = pluginDownloadActivity4.eKn;
                aVar6 = this.eKz.eKy;
                pluginDownloadActivity5 = PluginDownloadActivity.this;
                com.baidu.adp.lib.h.j.b(aVar5, pluginDownloadActivity5.getPageContext());
            }
        }
    }
}
