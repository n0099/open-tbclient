package com.baidu.tieba.pluginCenter;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.PluginDownloadActivityConfig;
import com.baidu.tieba.R;
import d.b.b.e.m.g;
import d.b.b.e.p.j;
import java.util.Date;
/* loaded from: classes5.dex */
public class PluginDownloadActivity extends BaseActivity<PluginDownloadActivity> {
    public c mDialog;
    public boolean mFinished;
    public PluginNetConfigInfos.PluginConfig mPluginConfig;
    public boolean mStarting;

    /* loaded from: classes5.dex */
    public class a implements DialogInterface.OnKeyListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (!PluginDownloadActivity.this.mStarting) {
                g.b(PluginDownloadActivity.this.mDialog, PluginDownloadActivity.this.getPageContext());
                return true;
            } else if (i == 4 && keyEvent.getAction() == 1) {
                if (PluginDownloadActivity.this.mDialog.l.getVisibility() == 0) {
                    PluginDownloadActivity.this.mDialog.l.setVisibility(8);
                    PluginDownloadActivity.this.mDialog.f20550e.setVisibility(0);
                } else {
                    PluginDownloadActivity.this.mDialog.l.setVisibility(0);
                    PluginDownloadActivity.this.mDialog.f20550e.setVisibility(8);
                }
                return true;
            } else {
                return false;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements DialogInterface.OnDismissListener {
        public b() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            PluginDownloadActivity.this.setResult(0);
            PluginDownloadActivity.this.finish();
        }
    }

    /* loaded from: classes5.dex */
    public class c extends Dialog {

        /* renamed from: e  reason: collision with root package name */
        public LinearLayout f20550e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f20551f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f20552g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f20553h;
        public TextView i;
        public TextView j;
        public TextView k;
        public LinearLayout l;
        public TextView m;
        public TextView n;
        public TextView o;
        public TextView p;

        /* loaded from: classes5.dex */
        public class a implements View.OnClickListener {
            public a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PluginDownloadActivity.this.setResult(0);
                PluginDownloadActivity.this.finish();
            }
        }

        /* loaded from: classes5.dex */
        public class b implements View.OnClickListener {
            public b() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.l.setVisibility(8);
                c.this.f20550e.setVisibility(0);
            }
        }

        /* renamed from: com.baidu.tieba.pluginCenter.PluginDownloadActivity$c$c  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class View$OnClickListenerC0220c implements View.OnClickListener {

            /* renamed from: com.baidu.tieba.pluginCenter.PluginDownloadActivity$c$c$a */
            /* loaded from: classes5.dex */
            public class a implements d.b.b.h.j.d {
                public a() {
                }

                @Override // d.b.b.h.j.d
                public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
                    if (i == 0) {
                        PluginDownloadActivity pluginDownloadActivity = PluginDownloadActivity.this;
                        pluginDownloadActivity.showToast(pluginDownloadActivity.getPageContext().getString(R.string.plugin_installation_finished));
                        PluginDownloadActivity.this.setResult(-1);
                        PluginDownloadActivity.this.setResult(-1);
                        PluginDownloadActivity.this.finish();
                        return;
                    }
                    PluginDownloadActivity.this.setResult(0);
                    PluginDownloadActivity pluginDownloadActivity2 = PluginDownloadActivity.this;
                    pluginDownloadActivity2.showToast(pluginDownloadActivity2.getPageContext().getString(R.string.plugin_installation_failed), false);
                    PluginDownloadActivity.this.setResult(0);
                    PluginDownloadActivity.this.finish();
                }

                @Override // d.b.b.h.j.d
                public void b(BdFileDownloadData bdFileDownloadData) {
                    if (bdFileDownloadData == null || !bdFileDownloadData.getId().equals(PluginDownloadActivity.this.mPluginConfig.package_name) || PluginDownloadActivity.this.mFinished) {
                        return;
                    }
                    PluginDownloadActivity.this.mDialog.j.setText(String.format("正在下载插件：%d%%", Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                    PluginDownloadActivity.this.mDialog.j.setEnabled(false);
                }

                @Override // d.b.b.h.j.d
                public void c(BdFileDownloadData bdFileDownloadData) {
                    if (bdFileDownloadData == null || !bdFileDownloadData.getId().equals(PluginDownloadActivity.this.mPluginConfig.package_name)) {
                        return;
                    }
                    PluginDownloadActivity.this.mDialog.j.setText(PluginDownloadActivity.this.getPageContext().getString(R.string.plugin_download_finished));
                    PluginDownloadActivity.this.mDialog.j.setEnabled(false);
                    PluginDownloadActivity.this.mFinished = true;
                }

                @Override // d.b.b.h.j.d
                public void d(BdFileDownloadData bdFileDownloadData) {
                    if (bdFileDownloadData == null || !bdFileDownloadData.getId().equals(PluginDownloadActivity.this.mPluginConfig.package_name)) {
                        return;
                    }
                    PluginDownloadActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                    PluginDownloadActivity.this.mFinished = true;
                    g.b(PluginDownloadActivity.this.mDialog, PluginDownloadActivity.this.getPageContext());
                }
            }

            public View$OnClickListenerC0220c() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.z()) {
                    PluginDownloadActivity.this.mStarting = true;
                    c.this.f20553h.setVisibility(8);
                    c.this.i.setVisibility(8);
                    c.this.j.setVisibility(0);
                    PluginPackageManager.O().x0(PluginDownloadActivity.this.mPluginConfig, new a());
                    return;
                }
                PluginDownloadActivity.this.showToast(R.string.neterror);
            }
        }

        /* loaded from: classes5.dex */
        public class d implements View.OnClickListener {
            public d() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PluginDownloadActivity.this.setResult(0);
                PluginDownloadActivity.this.finish();
                d.b.h0.r.d0.b.i().s("install_plugin_dialog_closed", true);
                d.b.h0.r.d0.b.i().v("install_plugin_dialog_shown_time", new Date().getTime());
            }
        }

        public c(Context context, int i) {
            super(context, i);
        }

        @Override // android.app.Dialog
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            setContentView(R.layout.update_dialog);
            findViewById(R.id.warning).setVisibility(8);
            findViewById(R.id.incremental_button).setVisibility(8);
            findViewById(R.id.incremental_size).setVisibility(8);
            this.f20550e = (LinearLayout) findViewById(R.id.down_dialog);
            this.o = (TextView) findViewById(R.id.update_tip);
            this.f20551f = (TextView) findViewById(R.id.newversion);
            this.f20552g = (TextView) findViewById(R.id.desc);
            TextView textView = (TextView) findViewById(R.id.update_button);
            this.f20553h = textView;
            textView.setText(PluginDownloadActivity.this.getPageContext().getString(R.string.install_app));
            this.i = (TextView) findViewById(R.id.update_cancel);
            this.j = (TextView) findViewById(R.id.downloading);
            TextView textView2 = (TextView) findViewById(R.id.otherApp);
            this.p = textView2;
            textView2.setVisibility(8);
            this.k = (TextView) findViewById(R.id.app_size);
            this.l = (LinearLayout) findViewById(R.id.cancel_dialog);
            this.m = (TextView) findViewById(R.id.sure_cancel);
            this.n = (TextView) findViewById(R.id.cancel_button);
            this.m.setOnClickListener(new a());
            this.n.setOnClickListener(new b());
            if (!TextUtils.isEmpty(PluginDownloadActivity.this.mPluginConfig.display_name)) {
                this.o.setText(PluginDownloadActivity.this.mPluginConfig.display_name);
            } else {
                this.o.setText("");
            }
            if (PluginDownloadActivity.this.mPluginConfig.newest != null) {
                if (TextUtils.isEmpty(PluginDownloadActivity.this.mPluginConfig.newest.version)) {
                    this.f20551f.setText("");
                } else {
                    TextView textView3 = this.f20551f;
                    textView3.setText("版本：" + PluginDownloadActivity.this.mPluginConfig.newest.version);
                }
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.mPluginConfig.newest.change_log)) {
                    this.f20552g.setText(PluginDownloadActivity.this.mPluginConfig.newest.change_log);
                } else {
                    this.f20552g.setText("");
                }
                String valueOf = String.valueOf(PluginDownloadActivity.this.mPluginConfig.newest.size / 1024);
                if (valueOf != null && !"".equals(valueOf)) {
                    this.k.setVisibility(0);
                    TextView textView4 = this.k;
                    textView4.setText(((Object) this.k.getText()) + valueOf + "KB");
                } else {
                    this.k.setVisibility(8);
                }
            } else {
                this.f20551f.setText("");
                this.f20552g.setText("");
                this.k.setText("");
            }
            this.f20553h.setOnClickListener(new View$OnClickListenerC0220c());
            this.i.setOnClickListener(new d());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().k(i == 1);
        getLayoutMode().j(this.mDialog.findViewById(R.id.dialog_layout));
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        PluginNetConfigInfos.PluginConfig pluginConfig = (PluginNetConfigInfos.PluginConfig) getIntent().getSerializableExtra(PluginDownloadActivityConfig.PLUGIN_CONFIG);
        this.mPluginConfig = pluginConfig;
        if (pluginConfig == null) {
            showToast(getPageContext().getString(R.string.plugin_config_not_found), false);
            finish();
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        c cVar = new c(getPageContext().getPageActivity(), R.style.common_alert_dialog);
        this.mDialog = cVar;
        cVar.setCancelable(false);
        this.mDialog.setOnKeyListener(new a());
        this.mDialog.setOnDismissListener(new b());
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.mPluginConfig != null) {
            PluginPackageManager.O().x(this.mPluginConfig.package_name);
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        g.j(this.mDialog, getPageContext());
    }
}
