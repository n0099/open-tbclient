package com.baidu.tieba.plugins;

import android.widget.TextView;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.pluginArch.bean.ConfigInfos;
import com.baidu.tieba.r;
import com.baidu.tieba.x;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements com.baidu.tbadk.pluginArch.j {
    final /* synthetic */ PluginDetailActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(PluginDetailActivity pluginDetailActivity) {
        this.a = pluginDetailActivity;
    }

    @Override // com.baidu.tbadk.pluginArch.j
    public void a(DownloadData downloadData) {
        ConfigInfos.PluginConfig pluginConfig;
        boolean z;
        TextView textView;
        TextView textView2;
        TextView textView3;
        if (downloadData != null) {
            String id = downloadData.getId();
            pluginConfig = this.a.i;
            if (id.equals(pluginConfig.name)) {
                z = this.a.j;
                if (!z) {
                    textView = this.a.f;
                    textView.setTextColor(this.a.getResources().getColor(r.cp_cont_d));
                    textView2 = this.a.f;
                    textView2.setText(this.a.getString(x.plugin_download_percent, new Object[]{Long.valueOf((downloadData.getLength() * 100) / downloadData.getSize())}));
                    textView3 = this.a.f;
                    textView3.setEnabled(false);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.pluginArch.j
    public void b(DownloadData downloadData) {
        ConfigInfos.PluginConfig pluginConfig;
        TextView textView;
        TextView textView2;
        if (downloadData != null) {
            String id = downloadData.getId();
            pluginConfig = this.a.i;
            if (id.equals(pluginConfig.name)) {
                textView = this.a.f;
                textView.setText(this.a.getString(x.plugin_download_finished));
                textView2 = this.a.f;
                textView2.setEnabled(false);
                this.a.j = true;
            }
        }
    }

    @Override // com.baidu.tbadk.pluginArch.j
    public void c(DownloadData downloadData) {
        ConfigInfos.PluginConfig pluginConfig;
        if (downloadData != null) {
            String id = downloadData.getId();
            pluginConfig = this.a.i;
            if (id.equals(pluginConfig.name)) {
                this.a.showToast(downloadData.getStatusMsg());
                this.a.a();
                this.a.j = true;
            }
        }
    }

    @Override // com.baidu.tbadk.pluginArch.j
    public void a(DownloadData downloadData, int i, String str) {
        if (i == 0) {
            this.a.showToast(this.a.getString(x.plugin_installation_finished));
            this.a.a();
            return;
        }
        this.a.showToast(String.valueOf(this.a.getString(x.plugin_installation_failed)) + str);
        this.a.a();
    }
}
