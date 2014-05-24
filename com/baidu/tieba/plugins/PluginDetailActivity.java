package com.baidu.tieba.plugins;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.service.PluginDownloadService;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.editortool.ab;
import com.baidu.tbadk.tbplugin.PluginsConfig;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
import java.io.File;
/* loaded from: classes.dex */
public class PluginDetailActivity extends BaseActivity implements com.baidu.tbadk.tbplugin.k {
    private HeadImageView a;
    private TextView b;
    private TextView c;
    private TextView d;
    private TextView e;
    private TextView f;
    private NavigationBar g;
    private Messenger h;
    private String j;
    private ab k;
    private PluginsConfig.PluginConfig l;
    private boolean m;
    private ServiceConnection i = new h(this, null);
    private final Messenger n = new Messenger(new i(this, null));

    public static void a(Context context, String str) {
        Intent intent = new Intent(context, PluginDetailActivity.class);
        intent.putExtra("name", str);
        context.startActivity(intent);
    }

    @Override // com.baidu.tbadk.tbplugin.k
    public void onFinish(int i, String str) {
        runOnUiThread(new e(this, i, str));
    }

    @Override // com.baidu.tbadk.tbplugin.k
    public void onProgress(int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(w.plugin_detail_activity);
        this.g = (NavigationBar) findViewById(v.navigation_bar);
        this.g.a(y.plugin_center);
        this.g.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.a = (HeadImageView) findViewById(v.icon);
        this.b = (TextView) findViewById(v.name);
        this.c = (TextView) findViewById(v.status);
        this.d = (TextView) findViewById(v.changelog);
        this.e = (TextView) findViewById(v.size);
        this.f = (TextView) findViewById(v.enable);
        this.f.setOnClickListener(this);
        this.k = new ab(this);
        this.j = getIntent().getStringExtra("name");
        this.l = com.baidu.tbadk.tbplugin.m.a().d(this.j);
        a((ServiceConnection) null);
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        if (this.l != null) {
            this.a.setTag(this.l.icon);
            this.k.a(this.l.icon, false, (com.baidu.tbadk.imageManager.d) new f(this), true);
            this.b.setText(this.l.description);
            a();
            this.d.setText(this.l.newest.changelog);
            this.e.setText(String.valueOf(getString(y.plugin_size)) + String.valueOf(this.l.newest.size / 1024) + "KB");
            this.f.setOnClickListener(this);
        }
    }

    public void a() {
        if (com.baidu.tbadk.tbplugin.m.a().c(this.j)) {
            this.c.setText(y.plugin_enabled);
            this.f.setText(y.plugin_update);
            this.f.setEnabled(true);
            this.f.setTextColor(getResources().getColor(com.baidu.tieba.s.cp_cont_g));
        } else if (com.baidu.tbadk.tbplugin.m.a().b(this.j)) {
            this.c.setText(y.plugin_enabled);
            this.f.setText(y.plugin_enabled);
            this.f.setEnabled(false);
            this.f.setTextColor(getResources().getColor(com.baidu.tieba.s.cp_cont_d));
        } else {
            this.c.setText(y.plugin_disabled);
            this.f.setText(y.plugin_enable);
            this.f.setEnabled(true);
            this.f.setTextColor(getResources().getColor(com.baidu.tieba.s.cp_cont_g));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.g.c(i);
        getLayoutMode().a(i == 1);
        getLayoutMode().a(findViewById(16908290));
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f) {
            if (UtilHelper.getNetStatusInfo(this) == UtilHelper.NetworkStateInfo.UNAVAIL) {
                showToast(y.neterror);
                return;
            }
            this.f.setTextColor(getResources().getColor(com.baidu.tieba.s.cp_cont_d));
            this.f.setEnabled(false);
            if (this.h != null) {
                Message obtain = Message.obtain((Handler) null, 3);
                Bundle bundle = new Bundle();
                bundle.putSerializable("download_data", a(this.l));
                if (obtain != null) {
                    obtain.setData(bundle);
                    try {
                        this.h.send(obtain);
                        return;
                    } catch (RemoteException e) {
                        return;
                    }
                }
                return;
            }
            a(new g(this, this));
        }
    }

    private void a(ServiceConnection serviceConnection) {
        Intent intent = new Intent(this, PluginDownloadService.class);
        if (serviceConnection != null) {
            bindService(intent, serviceConnection, 1);
        } else {
            bindService(intent, this.i, 1);
        }
    }

    private void b() {
        if (this.h != null) {
            try {
                this.h.send(Message.obtain((Handler) null, 2));
            } catch (RemoteException e) {
            }
        }
        unbindService(this.i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        b();
    }

    public DownloadData a(PluginsConfig.PluginConfig pluginConfig) {
        DownloadData downloadData = new DownloadData(pluginConfig.name, pluginConfig.newest.url);
        String str = String.valueOf(pluginConfig.name) + ".tbplugin";
        downloadData.setName(str);
        downloadData.setPath(String.valueOf(com.baidu.tbadk.tbplugin.i.f().getAbsolutePath()) + File.separator + str);
        return downloadData;
    }
}
