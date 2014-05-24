package com.baidu.tieba.plugins;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.service.PluginDownloadService;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.tbplugin.PluginsConfig;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class PluginDownloadReceiver extends BroadcastReceiver {
    private static final String TAG = "PluginDownloadReceiver";
    private boolean mInit;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        int i = 1;
        BdLog.d("onReceive");
        if (UtilHelper.getNetStatusInfo(context) == UtilHelper.NetworkStateInfo.WIFI) {
            if (!com.baidu.tbadk.tbplugin.m.a().b("motusdk") || !com.baidu.tbadk.tbplugin.m.a().b("browser")) {
                if (!this.mInit) {
                    init();
                }
                Intent intent2 = new Intent(context, PluginDownloadService.class);
                intent2.putExtra("background_download", true);
                ArrayList arrayList = new ArrayList();
                if (com.baidu.tbadk.tbplugin.m.a().b("motusdk")) {
                    i = 0;
                } else {
                    arrayList.add("motusdk");
                }
                if (!com.baidu.tbadk.tbplugin.m.a().b("browser")) {
                    arrayList.add("browser");
                    i++;
                }
                intent2.putExtra("plugins_download", (String[]) arrayList.toArray(new String[i]));
                context.startService(intent2);
                return;
            }
            return;
        }
        context.stopService(new Intent(context, PluginDownloadService.class));
    }

    private void init() {
        this.mInit = true;
    }

    private DownloadData configToDownloadData(PluginsConfig.PluginConfig pluginConfig) {
        DownloadData downloadData = new DownloadData(pluginConfig.name, pluginConfig.newest.url);
        String str = String.valueOf(pluginConfig.name) + ".tbplugin";
        downloadData.setName(str);
        downloadData.setPath(String.valueOf(com.baidu.tbadk.tbplugin.i.f().getAbsolutePath()) + File.separator + str);
        return downloadData;
    }
}
