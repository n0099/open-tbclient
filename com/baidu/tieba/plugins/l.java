package com.baidu.tieba.plugins;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.tbplugin.PluginsConfig;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
class l extends Handler {
    final /* synthetic */ PluginDownloadActivity a;

    private l(PluginDownloadActivity pluginDownloadActivity) {
        this.a = pluginDownloadActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ l(PluginDownloadActivity pluginDownloadActivity, l lVar) {
        this(pluginDownloadActivity);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        DownloadData downloadData;
        PluginsConfig.PluginConfig pluginConfig;
        m mVar;
        DownloadData downloadData2;
        PluginsConfig.PluginConfig pluginConfig2;
        m mVar2;
        TextView textView;
        m mVar3;
        TextView textView2;
        PluginsConfig.PluginConfig pluginConfig3;
        DownloadData downloadData3;
        PluginsConfig.PluginConfig pluginConfig4;
        boolean z;
        m mVar4;
        TextView textView3;
        m mVar5;
        TextView textView4;
        switch (message.what) {
            case 5:
                Bundle data = message.getData();
                if (data != null && (downloadData3 = (DownloadData) data.getSerializable("download_data")) != null) {
                    String id = downloadData3.getId();
                    pluginConfig4 = this.a.b;
                    if (id.equals(pluginConfig4.name)) {
                        z = this.a.f;
                        if (!z) {
                            mVar4 = this.a.a;
                            textView3 = mVar4.g;
                            textView3.setText(String.format("正在下载插件：%d%%", Long.valueOf((downloadData3.getLength() * 100) / downloadData3.getSize())));
                            mVar5 = this.a.a;
                            textView4 = mVar5.g;
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
                Bundle data2 = message.getData();
                if (data2 != null && (downloadData = (DownloadData) data2.getSerializable("download_data")) != null) {
                    String id2 = downloadData.getId();
                    pluginConfig = this.a.b;
                    if (id2.equals(pluginConfig.name)) {
                        this.a.showToast(downloadData.getStatusMsg());
                        this.a.f = true;
                        mVar = this.a.a;
                        mVar.dismiss();
                        return;
                    }
                    return;
                }
                return;
            case 8:
                Bundle data3 = message.getData();
                if (data3 != null && (downloadData2 = (DownloadData) data3.getSerializable("download_data")) != null) {
                    String id3 = downloadData2.getId();
                    pluginConfig2 = this.a.b;
                    if (id3.equals(pluginConfig2.name)) {
                        mVar2 = this.a.a;
                        textView = mVar2.g;
                        textView.setText(this.a.getString(y.plugin_download_finished));
                        mVar3 = this.a.a;
                        textView2 = mVar3.g;
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
