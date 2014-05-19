package com.baidu.tieba.plugins;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.tbplugin.PluginsConfig;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class i extends Handler {
    final /* synthetic */ PluginDetailActivity a;

    private i(PluginDetailActivity pluginDetailActivity) {
        this.a = pluginDetailActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ i(PluginDetailActivity pluginDetailActivity, i iVar) {
        this(pluginDetailActivity);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        DownloadData downloadData;
        PluginsConfig.PluginConfig pluginConfig;
        DownloadData downloadData2;
        PluginsConfig.PluginConfig pluginConfig2;
        TextView textView;
        TextView textView2;
        PluginsConfig.PluginConfig pluginConfig3;
        DownloadData downloadData3;
        PluginsConfig.PluginConfig pluginConfig4;
        boolean z;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        switch (message.what) {
            case 5:
                BdLog.d("MSG_UPDATE");
                Bundle data = message.getData();
                if (data != null && (downloadData3 = (DownloadData) data.getSerializable("download_data")) != null) {
                    String id = downloadData3.getId();
                    pluginConfig4 = this.a.l;
                    if (id.equals(pluginConfig4.name)) {
                        z = this.a.m;
                        if (!z) {
                            textView3 = this.a.f;
                            textView3.setTextColor(this.a.getResources().getColor(com.baidu.tieba.o.cp_cont_d));
                            textView4 = this.a.f;
                            textView4.setText(String.format("正在下载插件：%d%%", Long.valueOf((downloadData3.getLength() * 100) / downloadData3.getSize())));
                            textView5 = this.a.f;
                            textView5.setEnabled(false);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            case 6:
            default:
                return;
            case 7:
                BdLog.d("MSG_FAILED");
                Bundle data2 = message.getData();
                if (data2 != null && (downloadData = (DownloadData) data2.getSerializable("download_data")) != null) {
                    String id2 = downloadData.getId();
                    pluginConfig = this.a.l;
                    if (id2.equals(pluginConfig.name)) {
                        this.a.showToast(downloadData.getStatusMsg());
                        this.a.a();
                        this.a.m = true;
                        return;
                    }
                    return;
                }
                return;
            case 8:
                BdLog.d("MSG_SUCCEED");
                Bundle data3 = message.getData();
                if (data3 != null && (downloadData2 = (DownloadData) data3.getSerializable("download_data")) != null) {
                    String id3 = downloadData2.getId();
                    pluginConfig2 = this.a.l;
                    if (id3.equals(pluginConfig2.name)) {
                        textView = this.a.f;
                        textView.setText(this.a.getString(u.plugin_download_finished));
                        textView2 = this.a.f;
                        textView2.setEnabled(false);
                        this.a.m = true;
                        PluginDetailActivity pluginDetailActivity = this.a;
                        com.baidu.tbadk.tbplugin.m a = com.baidu.tbadk.tbplugin.m.a();
                        pluginConfig3 = this.a.l;
                        new com.baidu.tbadk.tbplugin.f(pluginDetailActivity, a.a(pluginConfig3.name), downloadData2.getPath(), this.a).a();
                        return;
                    }
                    return;
                }
                return;
        }
    }
}
