package com.baidu.tieba.plugins;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.tbplugin.PluginsConfig;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
class n extends Handler {
    final /* synthetic */ PluginDownloadActivity a;

    private n(PluginDownloadActivity pluginDownloadActivity) {
        this.a = pluginDownloadActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ n(PluginDownloadActivity pluginDownloadActivity, n nVar) {
        this(pluginDownloadActivity);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        DownloadData downloadData;
        PluginsConfig.PluginConfig pluginConfig;
        o oVar;
        DownloadData downloadData2;
        PluginsConfig.PluginConfig pluginConfig2;
        o oVar2;
        TextView textView;
        o oVar3;
        TextView textView2;
        PluginsConfig.PluginConfig pluginConfig3;
        DownloadData downloadData3;
        PluginsConfig.PluginConfig pluginConfig4;
        boolean z;
        o oVar4;
        TextView textView3;
        o oVar5;
        TextView textView4;
        switch (message.what) {
            case 5:
                BdLog.d("MSG_UPDATE");
                Bundle data = message.getData();
                if (data != null && (downloadData3 = (DownloadData) data.getSerializable("download_data")) != null) {
                    String id = downloadData3.getId();
                    pluginConfig4 = this.a.b;
                    if (id.equals(pluginConfig4.name)) {
                        z = this.a.f;
                        if (!z) {
                            oVar4 = this.a.a;
                            textView3 = oVar4.g;
                            textView3.setText(String.format("正在下载插件：%d%%", Long.valueOf((downloadData3.getLength() * 100) / downloadData3.getSize())));
                            oVar5 = this.a.a;
                            textView4 = oVar5.g;
                            textView4.setEnabled(false);
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
                    pluginConfig = this.a.b;
                    if (id2.equals(pluginConfig.name)) {
                        this.a.showToast(downloadData.getStatusMsg());
                        this.a.f = true;
                        oVar = this.a.a;
                        oVar.dismiss();
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
                    pluginConfig2 = this.a.b;
                    if (id3.equals(pluginConfig2.name)) {
                        oVar2 = this.a.a;
                        textView = oVar2.g;
                        textView.setText(this.a.getString(y.plugin_download_finished));
                        oVar3 = this.a.a;
                        textView2 = oVar3.g;
                        textView2.setEnabled(false);
                        this.a.f = true;
                        PluginDownloadActivity pluginDownloadActivity = this.a;
                        com.baidu.tbadk.tbplugin.m a = com.baidu.tbadk.tbplugin.m.a();
                        pluginConfig3 = this.a.b;
                        new com.baidu.tbadk.tbplugin.f(pluginDownloadActivity, a.a(pluginConfig3.name), downloadData2.getPath(), this.a).a();
                        return;
                    }
                    return;
                }
                return;
        }
    }
}
