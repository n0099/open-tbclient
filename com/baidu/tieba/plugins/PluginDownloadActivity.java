package com.baidu.tieba.plugins;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.view.WindowManager;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.service.PluginDownloadService;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.tbplugin.PluginsConfig;
import com.baidu.tieba.v;
import com.baidu.tieba.y;
import com.baidu.tieba.z;
import java.io.File;
/* loaded from: classes.dex */
public class PluginDownloadActivity extends BaseActivity implements com.baidu.tbadk.tbplugin.k {
    private o a;
    private PluginsConfig.PluginConfig b;
    private Messenger c;
    private final Messenger d = new Messenger(new n(this, null));
    private ServiceConnection e;
    private boolean f;
    private boolean g;

    @Override // com.baidu.tbadk.tbplugin.k
    public void onFinish(int i, String str) {
        runOnUiThread(new j(this, i));
    }

    @Override // com.baidu.tbadk.tbplugin.k
    public void onProgress(int i) {
    }

    public static void a(Context context, PluginsConfig.PluginConfig pluginConfig) {
        Intent intent = new Intent(context, PluginDownloadActivity.class);
        intent.putExtra("plugin_config", pluginConfig);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a(this.e);
        this.b = (PluginsConfig.PluginConfig) getIntent().getSerializableExtra("plugin_config");
        if (this.b == null) {
            showToast(getString(y.plugin_config_not_found), false);
            finish();
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        this.a = new o(this, this, z.common_alert_dialog);
        this.a.setCancelable(false);
        this.a.setOnKeyListener(new k(this));
        this.a.setOnDismissListener(new l(this));
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.a.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().a(i == 1);
        getLayoutMode().a(this.a.findViewById(v.dialog_layout));
    }

    public void a(ServiceConnection serviceConnection) {
        Intent intent = new Intent(this, PluginDownloadService.class);
        if (serviceConnection != null) {
            this.e = serviceConnection;
        } else {
            this.e = new m(this, null, null);
        }
        bindService(intent, this.e, 1);
    }

    private void a() {
        if (this.c != null) {
            try {
                this.c.send(Message.obtain((Handler) null, 2));
            } catch (RemoteException e) {
            }
        }
        unbindService(this.e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        a();
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
    }

    public DownloadData a(PluginsConfig.PluginConfig pluginConfig) {
        DownloadData downloadData = new DownloadData(pluginConfig.name, pluginConfig.newest.url);
        String str = String.valueOf(pluginConfig.name) + ".tbplugin";
        downloadData.setName(str);
        downloadData.setPath(String.valueOf(com.baidu.tbadk.tbplugin.i.f().getAbsolutePath()) + File.separator + str);
        return downloadData;
    }
}
