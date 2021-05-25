package com.baidu.tieba.pluginCenter;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.util.Util;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.plugin.ShadowLayout;
import com.baidu.tieba.R;
import d.a.c.e.p.j;
import d.a.c.e.p.k;
import d.a.m0.r.s.a;
import java.io.File;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes5.dex */
public class PluginDetailActivity extends BaseActivity<PluginDetailActivity> {
    public static final float M_BYTE = 1048576.0f;
    public static final int STATUS_FORBIDDEN = 2;
    public static final int STATUS_UNFORBIDDEN = 3;
    public static final int STATUS_UNINSTALL = 0;
    public static final int STATUS_UPDATE = 1;
    public TextView mChangelogText;
    public ProgressBar mDownloadProgressBar;
    public TextView mDownloadText;
    public TextView mEnableText;
    public boolean mFinished;
    public HeadImageView mIcon;
    public TextView mName;
    public NavigationBar mNavigationBar;
    public PluginNetConfigInfos.PluginConfig mPluginConfig;
    public String mPluginName;
    public TextView mSizeText;
    public int mStatus;
    public ShadowLayout mStatusContainer;
    public TextView mStatusText;
    public d.a.c.h.j.d mDownLoadAndInstallCallback = new d();
    public final CustomMessageListener mNetworkChangedMessageListener = new e(2000994);

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PluginDetailActivity.this.closeActivity();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements a.e {
        public b() {
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            SkinManager.setViewTextColor(PluginDetailActivity.this.mEnableText, R.color.CAM_X0109, 1);
            PluginDetailActivity.this.mEnableText.setEnabled(false);
            PluginPackageManager.O().x0(PluginDetailActivity.this.mPluginConfig, PluginDetailActivity.this.mDownLoadAndInstallCallback);
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class c implements a.e {
        public c() {
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class d implements d.a.c.h.j.d {
        public d() {
        }

        @Override // d.a.c.h.j.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData == null || PluginDetailActivity.this.mPluginConfig == null || !bdFileDownloadData.getId().equals(PluginDetailActivity.this.mPluginConfig.package_name)) {
                return;
            }
            PluginDetailActivity.this.mEnableText.setText(PluginDetailActivity.this.getPageContext().getString(R.string.plugin_download_finished));
            PluginDetailActivity.this.mEnableText.setEnabled(false);
            PluginDetailActivity.this.mFinished = true;
        }

        @Override // d.a.c.h.j.d
        public void b(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData == null || PluginDetailActivity.this.mPluginConfig == null || !bdFileDownloadData.getId().equals(PluginDetailActivity.this.mPluginConfig.package_name)) {
                return;
            }
            PluginDetailActivity.this.showToast(bdFileDownloadData.getStatusMsg());
            PluginDetailActivity.this.setStatus();
            PluginDetailActivity.this.mFinished = true;
        }

        @Override // d.a.c.h.j.d
        public void c(BdFileDownloadData bdFileDownloadData, int i2, String str) {
            if (i2 == 0) {
                PluginDetailActivity pluginDetailActivity = PluginDetailActivity.this;
                pluginDetailActivity.showToast(pluginDetailActivity.getPageContext().getString(R.string.plugin_installation_finished));
                PluginDetailActivity.this.setStatus();
                return;
            }
            PluginDetailActivity pluginDetailActivity2 = PluginDetailActivity.this;
            pluginDetailActivity2.showToast(PluginDetailActivity.this.getPageContext().getString(R.string.plugin_installation_failed) + str);
            PluginDetailActivity.this.setStatus();
        }

        @Override // d.a.c.h.j.d
        public void d(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData == null || PluginDetailActivity.this.mPluginConfig == null || !bdFileDownloadData.getId().equals(PluginDetailActivity.this.mPluginConfig.package_name) || PluginDetailActivity.this.mFinished) {
                return;
            }
            SkinManager.setViewTextColor(PluginDetailActivity.this.mEnableText, R.color.CAM_X0109, 1);
            PluginDetailActivity.this.mStatusContainer.setShadowColor(0);
            PluginDetailActivity.this.mEnableText.setEnabled(false);
            PluginDetailActivity.this.mEnableText.setVisibility(8);
            PluginDetailActivity.this.mDownloadProgressBar.setVisibility(0);
            PluginDetailActivity.this.mDownloadText.setVisibility(0);
            PluginDetailActivity.this.mDownloadProgressBar.setProgress((int) ((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize()));
        }
    }

    /* loaded from: classes5.dex */
    public class e extends CustomMessageListener {
        public e(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.z()) {
                PluginDetailActivity.this.setStatus();
            }
        }
    }

    private int getDownloadPercent(PluginNetConfigInfos.PluginConfig pluginConfig) {
        PluginSetting h2;
        if (pluginConfig == null || (h2 = d.a.c.h.j.g.d.k().h(pluginConfig.package_name)) == null) {
            return 0;
        }
        String l = Util.l(h2);
        if (k.isEmpty(l)) {
            return 0;
        }
        try {
            File file = new File(l + ".tmp");
            if (file.exists() && h2.size > 0) {
                return (int) (((file.length() * 1.0d) / h2.size) * 100.0d);
            }
        } catch (Exception e2) {
            BdLog.e(e2);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStatus() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001303));
        if (PluginPackageManager.O().T(this.mPluginName) && PluginPackageManager.O().y(this.mPluginName)) {
            this.mStatusText.setText(R.string.plugin_enabled);
            this.mEnableText.setVisibility(0);
            this.mEnableText.setText(R.string.download_update);
            this.mEnableText.setEnabled(true);
            SkinManager.setBackgroundResource(this.mEnableText, R.drawable.selector_blue_gradient_button);
            this.mStatusContainer.setShadowColor(R.color.plugin_button_shadow_blue);
            SkinManager.setViewTextColor(this.mEnableText, R.color.CAM_X0111, 1);
            this.mDownloadProgressBar.setVisibility(8);
            this.mDownloadText.setVisibility(8);
            this.mStatus = 1;
        } else if (PluginPackageManager.O().y(this.mPluginName)) {
            this.mEnableText.setEnabled(true);
            SkinManager.setViewTextColor(this.mEnableText, R.color.CAM_X0111, 1);
            this.mEnableText.setVisibility(0);
            this.mDownloadProgressBar.setVisibility(8);
            this.mDownloadText.setVisibility(8);
            if (PluginPackageManager.O().b0(this.mPluginName)) {
                this.mStatusText.setText(R.string.plugin_unenabled);
                this.mEnableText.setText(R.string.plugin_enable);
                SkinManager.setBackgroundResource(this.mEnableText, R.drawable.selector_blue_gradient_button);
                this.mStatusContainer.setShadowColor(R.color.plugin_button_shadow_blue);
                this.mStatus = 2;
                return;
            }
            this.mStatusText.setText(R.string.plugin_enabled);
            this.mEnableText.setText(R.string.plugin_unenable);
            this.mStatus = 3;
            PluginNetConfigInfos.PluginConfig pluginConfig = this.mPluginConfig;
            if (pluginConfig != null && pluginConfig.can_forbidden == 1) {
                this.mEnableText.setEnabled(false);
                this.mEnableText.setVisibility(8);
                this.mStatusContainer.setShadowColor(0);
                return;
            }
            this.mEnableText.setEnabled(true);
            this.mEnableText.setVisibility(0);
            SkinManager.setBackgroundResource(this.mEnableText, R.drawable.button_plugin_forbidden);
            this.mStatusContainer.setShadowColor(R.color.plugin_button_shadow_red);
        } else {
            this.mEnableText.setVisibility(0);
            this.mStatusText.setText(R.string.plugin_disabled);
            this.mEnableText.setText(R.string.install_app);
            this.mEnableText.setEnabled(true);
            SkinManager.setBackgroundResource(this.mEnableText, R.drawable.selector_blue_gradient_button);
            this.mStatusContainer.setShadowColor(R.color.plugin_button_shadow_blue);
            SkinManager.setViewTextColor(this.mEnableText, R.color.CAM_X0111, 1);
            this.mStatus = 0;
            this.mDownloadProgressBar.setVisibility(8);
            this.mDownloadText.setVisibility(8);
        }
    }

    private void showMobileNetDownloadDialog() {
        String string;
        String string2;
        PluginNetConfigInfos.PluginConfig pluginConfig = this.mPluginConfig;
        if (pluginConfig == null || pluginConfig.newest == null) {
            return;
        }
        d.a.m0.r.s.a aVar = new d.a.m0.r.s.a(getPageContext().getPageActivity());
        boolean z = this.mStatus == 1;
        float f2 = this.mPluginConfig.newest.size / 1048576.0f;
        if (z) {
            string = getResources().getString(R.string.plugin_update_size_prompt, Float.valueOf(f2));
            string2 = getResources().getString(R.string.download_update);
        } else {
            string = getResources().getString(R.string.plugin_download_size_prompt, Float.valueOf(f2));
            string2 = getResources().getString(R.string.download);
        }
        aVar.setMessage(string);
        aVar.setPositiveButton(string2, new b());
        aVar.setNegativeButton(R.string.cancel, new c());
        aVar.create(getPageContext());
        aVar.show();
    }

    private void startLoadPlugin() {
        if (!j.z()) {
            showToast(R.string.neterror);
        } else if (j.x()) {
            showMobileNetDownloadDialog();
        } else {
            PluginNetConfigInfos.PluginConfig pluginConfig = this.mPluginConfig;
            if (pluginConfig == null || TextUtils.isEmpty(pluginConfig.package_name) || PluginPackageManager.O().Z(this.mPluginConfig.package_name)) {
                return;
            }
            this.mEnableText.setEnabled(false);
            this.mFinished = false;
            PluginPackageManager.O().x0(this.mPluginConfig, this.mDownLoadAndInstallCallback);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        setResult(-1);
        finish();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i2);
        this.mDownloadProgressBar.setProgressDrawable(SkinManager.getDrawable(R.drawable.download_progressbar));
        this.mDownloadProgressBar.setIndeterminateDrawable(SkinManager.getDrawable(R.drawable.download_progressbar));
        getLayoutMode().k(i2 == 1);
        getLayoutMode().j(findViewById(16908290));
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mEnableText) {
            int i2 = this.mStatus;
            if (i2 == 0 || i2 == 1) {
                startLoadPlugin();
            } else if (i2 == 3) {
                PluginPackageManager.O().K(this.mPluginName);
                setStatus();
            } else if (i2 == 2) {
                PluginPackageManager.O().z0(this.mPluginName);
                setStatus();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.plugin_detail_activity);
        NavigationBar navigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.mNavigationBar = navigationBar;
        navigationBar.setCenterTextTitle(getString(R.string.plugin_center));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a());
        this.mIcon = (HeadImageView) findViewById(R.id.icon);
        this.mName = (TextView) findViewById(R.id.name);
        this.mStatusText = (TextView) findViewById(R.id.status);
        this.mDownloadProgressBar = (ProgressBar) findViewById(R.id.plugin_download_progress);
        this.mDownloadText = (TextView) findViewById(R.id.plugin_download_text);
        this.mChangelogText = (TextView) findViewById(R.id.changelog);
        this.mSizeText = (TextView) findViewById(R.id.size);
        TextView textView = (TextView) findViewById(R.id.enable);
        this.mEnableText = textView;
        textView.setOnClickListener(this);
        this.mStatusContainer = (ShadowLayout) findViewById(R.id.plugin_status_container);
        this.mPluginName = getIntent().getStringExtra("name");
        if (d.a.c.h.j.f.d.c().d() != null) {
            this.mPluginConfig = d.a.c.h.j.f.d.c().d().getPluginConfig(this.mPluginName);
        }
        if (PluginPackageManager.O().Z(this.mPluginName)) {
            PluginPackageManager.O().u0(this.mDownLoadAndInstallCallback);
            SkinManager.setViewTextColor(this.mEnableText, R.color.CAM_X0109, 1);
            this.mEnableText.setEnabled(false);
        }
        registerListener(this.mNetworkChangedMessageListener);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            closeActivity();
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        PluginPackageManager.O().u0(null);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        int downloadPercent;
        super.onResume();
        if (this.mDownloadProgressBar != null && PluginPackageManager.O().Z(this.mPluginName) && (downloadPercent = getDownloadPercent(this.mPluginConfig)) < 100) {
            SkinManager.setViewTextColor(this.mEnableText, R.color.CAM_X0109, 1);
            this.mStatusContainer.setShadowColor(0);
            this.mEnableText.setEnabled(false);
            this.mEnableText.setVisibility(8);
            this.mDownloadProgressBar.setVisibility(0);
            this.mDownloadText.setVisibility(0);
            this.mDownloadProgressBar.setProgress(downloadPercent);
        }
        PluginPackageManager.O().u0(this.mDownLoadAndInstallCallback);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        PluginNetConfigInfos.PluginConfig pluginConfig = this.mPluginConfig;
        if (pluginConfig != null) {
            this.mIcon.V(pluginConfig.icon, 10, false);
            PluginNetConfigInfos.PluginConfig pluginConfig2 = this.mPluginConfig;
            if (pluginConfig2.display_name == null) {
                pluginConfig2.display_name = "";
            }
            this.mName.setText(this.mPluginConfig.display_name);
            setStatus();
            PluginNetConfigInfos.Newest newest = this.mPluginConfig.newest;
            if (newest != null) {
                if (TextUtils.isEmpty(newest.change_log)) {
                    this.mChangelogText.setText("");
                } else {
                    this.mChangelogText.setText(this.mPluginConfig.newest.change_log);
                }
                if (this.mPluginConfig.newest.size <= 0) {
                    this.mSizeText.setText("");
                } else {
                    this.mSizeText.setText(getPageContext().getString(R.string.plugin_size) + String.valueOf(this.mPluginConfig.newest.size / 1024) + "KB");
                }
            }
            this.mEnableText.setOnClickListener(this);
        }
    }
}
