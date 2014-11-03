package com.baidu.tieba.plugins;

import android.widget.TextView;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.pluginArch.PluginDownloader;
import com.baidu.tbadk.pluginArch.bean.ConfigInfos;
import com.baidu.tieba.s;
import com.baidu.tieba.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements PluginDownloader.Callback {
    final /* synthetic */ PluginDetailActivity bHg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(PluginDetailActivity pluginDetailActivity) {
        this.bHg = pluginDetailActivity;
    }

    @Override // com.baidu.tbadk.pluginArch.PluginDownloader.Callback
    public void processUpdate(DownloadData downloadData) {
        ConfigInfos.PluginConfig pluginConfig;
        boolean z;
        TextView textView;
        TextView textView2;
        TextView textView3;
        if (downloadData != null) {
            String id = downloadData.getId();
            pluginConfig = this.bHg.bHe;
            if (id.equals(pluginConfig.name)) {
                z = this.bHg.bHf;
                if (!z) {
                    textView = this.bHg.bHd;
                    aw.b(textView, s.cp_cont_d, 1);
                    textView2 = this.bHg.bHd;
                    textView2.setText(this.bHg.getString(y.plugin_download_percent, new Object[]{Long.valueOf((downloadData.getLength() * 100) / downloadData.getSize())}));
                    textView3 = this.bHg.bHd;
                    textView3.setEnabled(false);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.pluginArch.PluginDownloader.Callback
    public void downloadSuccess(DownloadData downloadData) {
        ConfigInfos.PluginConfig pluginConfig;
        TextView textView;
        TextView textView2;
        if (downloadData != null) {
            String id = downloadData.getId();
            pluginConfig = this.bHg.bHe;
            if (id.equals(pluginConfig.name)) {
                textView = this.bHg.bHd;
                textView.setText(this.bHg.getString(y.plugin_download_finished));
                textView2 = this.bHg.bHd;
                textView2.setEnabled(false);
                this.bHg.bHf = true;
            }
        }
    }

    @Override // com.baidu.tbadk.pluginArch.PluginDownloader.Callback
    public void downloadFail(DownloadData downloadData) {
        ConfigInfos.PluginConfig pluginConfig;
        if (downloadData != null) {
            String id = downloadData.getId();
            pluginConfig = this.bHg.bHe;
            if (id.equals(pluginConfig.name)) {
                this.bHg.showToast(downloadData.getStatusMsg());
                this.bHg.abk();
                this.bHg.bHf = true;
            }
        }
    }

    @Override // com.baidu.tbadk.pluginArch.PluginDownloader.Callback
    public void installFinish(DownloadData downloadData, int i, String str) {
        if (i == 0) {
            this.bHg.showToast(this.bHg.getString(y.plugin_installation_finished));
            this.bHg.abk();
            return;
        }
        this.bHg.showToast(String.valueOf(this.bHg.getString(y.plugin_installation_failed)) + str);
        this.bHg.abk();
    }
}
