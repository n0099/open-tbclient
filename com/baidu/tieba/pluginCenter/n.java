package com.baidu.tieba.pluginCenter;

import android.widget.TextView;
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.tieba.i;
import com.baidu.tieba.pluginCenter.PluginDownloadActivity;
/* loaded from: classes.dex */
class n implements com.baidu.adp.plugin.packageManager.d {
    final /* synthetic */ m cox;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.cox = mVar;
    }

    @Override // com.baidu.adp.plugin.packageManager.d
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
            aVar = this.cox.cow;
            pluginDownloadActivity = PluginDownloadActivity.this;
            if (id.equals(pluginDownloadActivity.coh.package_name)) {
                aVar2 = this.cox.cow;
                pluginDownloadActivity2 = PluginDownloadActivity.this;
                z = pluginDownloadActivity2.coi;
                if (!z) {
                    aVar3 = this.cox.cow;
                    pluginDownloadActivity3 = PluginDownloadActivity.this;
                    aVar4 = pluginDownloadActivity3.cok;
                    textView = aVar4.coq;
                    textView.setText(String.format("正在下载插件：%d%%", Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                    aVar5 = this.cox.cow;
                    pluginDownloadActivity4 = PluginDownloadActivity.this;
                    aVar6 = pluginDownloadActivity4.cok;
                    textView2 = aVar6.coq;
                    textView2.setEnabled(false);
                }
            }
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.d
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
            aVar6 = this.cox.cow;
            pluginDownloadActivity6 = PluginDownloadActivity.this;
            aVar7 = this.cox.cow;
            pluginDownloadActivity7 = PluginDownloadActivity.this;
            pluginDownloadActivity6.showToast(pluginDownloadActivity7.getPageContext().getString(i.C0057i.plugin_installation_finished));
            aVar8 = this.cox.cow;
            pluginDownloadActivity8 = PluginDownloadActivity.this;
            pluginDownloadActivity8.setResult(-1);
            aVar9 = this.cox.cow;
            pluginDownloadActivity9 = PluginDownloadActivity.this;
            pluginDownloadActivity9.setResult(-1);
            aVar10 = this.cox.cow;
            pluginDownloadActivity10 = PluginDownloadActivity.this;
            pluginDownloadActivity10.finish();
            return;
        }
        aVar = this.cox.cow;
        pluginDownloadActivity = PluginDownloadActivity.this;
        pluginDownloadActivity.setResult(0);
        aVar2 = this.cox.cow;
        pluginDownloadActivity2 = PluginDownloadActivity.this;
        aVar3 = this.cox.cow;
        pluginDownloadActivity3 = PluginDownloadActivity.this;
        pluginDownloadActivity2.showToast(pluginDownloadActivity3.getPageContext().getString(i.C0057i.plugin_installation_failed), false);
        aVar4 = this.cox.cow;
        pluginDownloadActivity4 = PluginDownloadActivity.this;
        pluginDownloadActivity4.setResult(0);
        aVar5 = this.cox.cow;
        pluginDownloadActivity5 = PluginDownloadActivity.this;
        pluginDownloadActivity5.finish();
    }

    @Override // com.baidu.adp.plugin.packageManager.d
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
            aVar = this.cox.cow;
            pluginDownloadActivity = PluginDownloadActivity.this;
            if (id.equals(pluginDownloadActivity.coh.package_name)) {
                aVar2 = this.cox.cow;
                pluginDownloadActivity2 = PluginDownloadActivity.this;
                aVar3 = pluginDownloadActivity2.cok;
                textView = aVar3.coq;
                aVar4 = this.cox.cow;
                pluginDownloadActivity3 = PluginDownloadActivity.this;
                textView.setText(pluginDownloadActivity3.getPageContext().getString(i.C0057i.plugin_download_finished));
                aVar5 = this.cox.cow;
                pluginDownloadActivity4 = PluginDownloadActivity.this;
                aVar6 = pluginDownloadActivity4.cok;
                textView2 = aVar6.coq;
                textView2.setEnabled(false);
                aVar7 = this.cox.cow;
                pluginDownloadActivity5 = PluginDownloadActivity.this;
                pluginDownloadActivity5.coi = true;
            }
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.d
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
            aVar = this.cox.cow;
            pluginDownloadActivity = PluginDownloadActivity.this;
            if (id.equals(pluginDownloadActivity.coh.package_name)) {
                aVar2 = this.cox.cow;
                pluginDownloadActivity2 = PluginDownloadActivity.this;
                pluginDownloadActivity2.showToast(bdFileDownloadData.getStatusMsg());
                aVar3 = this.cox.cow;
                pluginDownloadActivity3 = PluginDownloadActivity.this;
                pluginDownloadActivity3.coi = true;
                aVar4 = this.cox.cow;
                pluginDownloadActivity4 = PluginDownloadActivity.this;
                aVar5 = pluginDownloadActivity4.cok;
                aVar6 = this.cox.cow;
                pluginDownloadActivity5 = PluginDownloadActivity.this;
                com.baidu.adp.lib.g.j.b(aVar5, pluginDownloadActivity5.getPageContext());
            }
        }
    }
}
