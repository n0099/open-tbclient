package com.baidu.tieba.plugins;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.tbplugin.PluginsConfig;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class r implements View.OnClickListener {
    final /* synthetic */ o a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(o oVar) {
        this.a = oVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PluginDownloadActivity pluginDownloadActivity;
        PluginDownloadActivity pluginDownloadActivity2;
        Button button;
        Button button2;
        TextView textView;
        PluginDownloadActivity pluginDownloadActivity3;
        Messenger messenger;
        PluginDownloadActivity pluginDownloadActivity4;
        PluginDownloadActivity pluginDownloadActivity5;
        PluginDownloadActivity pluginDownloadActivity6;
        PluginDownloadActivity pluginDownloadActivity7;
        PluginsConfig.PluginConfig pluginConfig;
        DownloadData a;
        PluginDownloadActivity pluginDownloadActivity8;
        Messenger messenger2;
        PluginDownloadActivity pluginDownloadActivity9;
        pluginDownloadActivity = this.a.a;
        if (UtilHelper.getNetStatusInfo(pluginDownloadActivity) == UtilHelper.NetworkStateInfo.UNAVAIL) {
            pluginDownloadActivity9 = this.a.a;
            pluginDownloadActivity9.showToast(u.neterror);
            return;
        }
        pluginDownloadActivity2 = this.a.a;
        pluginDownloadActivity2.g = true;
        button = this.a.e;
        button.setVisibility(8);
        button2 = this.a.f;
        button2.setVisibility(8);
        textView = this.a.g;
        textView.setVisibility(0);
        pluginDownloadActivity3 = this.a.a;
        messenger = pluginDownloadActivity3.c;
        if (messenger == null) {
            pluginDownloadActivity4 = this.a.a;
            pluginDownloadActivity5 = this.a.a;
            pluginDownloadActivity4.a(new s(this, pluginDownloadActivity5));
            return;
        }
        Message obtain = Message.obtain((Handler) null, 3);
        Bundle bundle = new Bundle();
        pluginDownloadActivity6 = this.a.a;
        pluginDownloadActivity7 = this.a.a;
        pluginConfig = pluginDownloadActivity7.b;
        a = pluginDownloadActivity6.a(pluginConfig);
        bundle.putSerializable("download_data", a);
        if (obtain != null) {
            obtain.setData(bundle);
            try {
                pluginDownloadActivity8 = this.a.a;
                messenger2 = pluginDownloadActivity8.c;
                messenger2.send(obtain);
            } catch (RemoteException e) {
            }
        }
    }
}
