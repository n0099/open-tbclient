package com.baidu.tieba.pluginCenter;

import android.widget.TextView;
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.tieba.pluginCenter.PluginDownloadActivity;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class o implements com.baidu.adp.plugin.packageManager.e {
    final /* synthetic */ n dxr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.dxr = nVar;
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
            aVar = this.dxr.dxq;
            pluginDownloadActivity = PluginDownloadActivity.this;
            if (id.equals(pluginDownloadActivity.dxc.package_name)) {
                aVar2 = this.dxr.dxq;
                pluginDownloadActivity2 = PluginDownloadActivity.this;
                z = pluginDownloadActivity2.bJb;
                if (!z) {
                    aVar3 = this.dxr.dxq;
                    pluginDownloadActivity3 = PluginDownloadActivity.this;
                    aVar4 = pluginDownloadActivity3.dxe;
                    textView = aVar4.dxk;
                    textView.setText(String.format("正在下载插件：%d%%", Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                    aVar5 = this.dxr.dxq;
                    pluginDownloadActivity4 = PluginDownloadActivity.this;
                    aVar6 = pluginDownloadActivity4.dxe;
                    textView2 = aVar6.dxk;
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
            aVar6 = this.dxr.dxq;
            pluginDownloadActivity6 = PluginDownloadActivity.this;
            aVar7 = this.dxr.dxq;
            pluginDownloadActivity7 = PluginDownloadActivity.this;
            pluginDownloadActivity6.showToast(pluginDownloadActivity7.getPageContext().getString(t.j.plugin_installation_finished));
            aVar8 = this.dxr.dxq;
            pluginDownloadActivity8 = PluginDownloadActivity.this;
            pluginDownloadActivity8.setResult(-1);
            aVar9 = this.dxr.dxq;
            pluginDownloadActivity9 = PluginDownloadActivity.this;
            pluginDownloadActivity9.setResult(-1);
            aVar10 = this.dxr.dxq;
            pluginDownloadActivity10 = PluginDownloadActivity.this;
            pluginDownloadActivity10.finish();
            return;
        }
        aVar = this.dxr.dxq;
        pluginDownloadActivity = PluginDownloadActivity.this;
        pluginDownloadActivity.setResult(0);
        aVar2 = this.dxr.dxq;
        pluginDownloadActivity2 = PluginDownloadActivity.this;
        aVar3 = this.dxr.dxq;
        pluginDownloadActivity3 = PluginDownloadActivity.this;
        pluginDownloadActivity2.showToast(pluginDownloadActivity3.getPageContext().getString(t.j.plugin_installation_failed), false);
        aVar4 = this.dxr.dxq;
        pluginDownloadActivity4 = PluginDownloadActivity.this;
        pluginDownloadActivity4.setResult(0);
        aVar5 = this.dxr.dxq;
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
            aVar = this.dxr.dxq;
            pluginDownloadActivity = PluginDownloadActivity.this;
            if (id.equals(pluginDownloadActivity.dxc.package_name)) {
                aVar2 = this.dxr.dxq;
                pluginDownloadActivity2 = PluginDownloadActivity.this;
                aVar3 = pluginDownloadActivity2.dxe;
                textView = aVar3.dxk;
                aVar4 = this.dxr.dxq;
                pluginDownloadActivity3 = PluginDownloadActivity.this;
                textView.setText(pluginDownloadActivity3.getPageContext().getString(t.j.plugin_download_finished));
                aVar5 = this.dxr.dxq;
                pluginDownloadActivity4 = PluginDownloadActivity.this;
                aVar6 = pluginDownloadActivity4.dxe;
                textView2 = aVar6.dxk;
                textView2.setEnabled(false);
                aVar7 = this.dxr.dxq;
                pluginDownloadActivity5 = PluginDownloadActivity.this;
                pluginDownloadActivity5.bJb = true;
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
            aVar = this.dxr.dxq;
            pluginDownloadActivity = PluginDownloadActivity.this;
            if (id.equals(pluginDownloadActivity.dxc.package_name)) {
                aVar2 = this.dxr.dxq;
                pluginDownloadActivity2 = PluginDownloadActivity.this;
                pluginDownloadActivity2.showToast(bdFileDownloadData.getStatusMsg());
                aVar3 = this.dxr.dxq;
                pluginDownloadActivity3 = PluginDownloadActivity.this;
                pluginDownloadActivity3.bJb = true;
                aVar4 = this.dxr.dxq;
                pluginDownloadActivity4 = PluginDownloadActivity.this;
                aVar5 = pluginDownloadActivity4.dxe;
                aVar6 = this.dxr.dxq;
                pluginDownloadActivity5 = PluginDownloadActivity.this;
                com.baidu.adp.lib.h.j.b(aVar5, pluginDownloadActivity5.getPageContext());
            }
        }
    }
}
