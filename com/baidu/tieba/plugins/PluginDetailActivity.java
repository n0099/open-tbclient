package com.baidu.tieba.plugins;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.bl;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.pluginArch.bean.ConfigInfos;
import com.baidu.tieba.r;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.x;
/* loaded from: classes.dex */
public class PluginDetailActivity extends BaseActivity {
    private HeadImageView a;
    private TextView b;
    private TextView c;
    private TextView d;
    private TextView e;
    private TextView f;
    private NavigationBar g;
    private String h;
    private ConfigInfos.PluginConfig i;
    private boolean j;
    private int k;

    static {
        TbadkApplication.m252getInst().RegisterIntent(bl.class, PluginDetailActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context, String str) {
        Intent intent = new Intent(context, PluginDetailActivity.class);
        intent.putExtra("name", str);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(v.plugin_detail_activity);
        this.g = (NavigationBar) findViewById(u.navigation_bar);
        this.g.a(x.plugin_center);
        this.g.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new c(this));
        this.a = (HeadImageView) findViewById(u.icon);
        this.b = (TextView) findViewById(u.name);
        this.c = (TextView) findViewById(u.status);
        this.d = (TextView) findViewById(u.changelog);
        this.e = (TextView) findViewById(u.size);
        this.f = (TextView) findViewById(u.enable);
        this.f.setOnClickListener(this);
        this.h = getIntent().getStringExtra("name");
        this.i = com.baidu.tbadk.pluginArch.d.a().b(this.h);
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        if (this.i != null) {
            this.a.a(this.i.icon, 10, false);
            this.b.setText(this.i.description);
            a();
            this.d.setText(this.i.newest.changelog);
            this.e.setText(String.valueOf(getString(x.plugin_size)) + String.valueOf(this.i.newest.size / 1024) + "KB");
            this.f.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (com.baidu.tbadk.pluginArch.d.a().e(this.h)) {
            this.c.setText(x.plugin_enabled);
            this.f.setText(x.plugin_update);
            this.f.setEnabled(true);
            this.f.setTextColor(getResources().getColor(r.cp_cont_g));
            this.k = 1;
        } else if (com.baidu.tbadk.pluginArch.d.a().c(this.h)) {
            this.f.setEnabled(true);
            this.f.setTextColor(getResources().getColor(r.cp_cont_g));
            boolean d = com.baidu.tbadk.pluginArch.d.a().d(this.h);
            if (!d) {
                this.c.setText(x.plugin_unenabled);
                this.f.setText(x.plugin_enable);
                this.k = 2;
            } else if (d) {
                this.c.setText(x.plugin_enabled);
                this.f.setText(x.plugin_unenable);
                this.k = 3;
            }
        } else {
            this.c.setText(x.plugin_disabled);
            this.f.setText(x.plugin_enable);
            this.f.setEnabled(true);
            this.f.setTextColor(getResources().getColor(r.cp_cont_g));
            this.k = 0;
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
            if (this.k == 0 || this.k == 1) {
                b();
            } else if (this.k == 3) {
                com.baidu.tbadk.pluginArch.d.a().a(this.h, true);
                a();
            } else if (this.k == 2) {
                com.baidu.tbadk.pluginArch.d.a().a(this.h, false);
                a();
            }
        }
    }

    private void b() {
        if (UtilHelper.getNetStatusInfo(this) == UtilHelper.NetworkStateInfo.UNAVAIL) {
            showToast(x.neterror);
            return;
        }
        this.f.setTextColor(getResources().getColor(r.cp_cont_d));
        this.f.setEnabled(false);
        com.baidu.tbadk.pluginArch.d.a().a(this.i, new d(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        setResult(-1);
        finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            closeActivity();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }
}
