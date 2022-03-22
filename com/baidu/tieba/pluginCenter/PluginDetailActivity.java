package com.baidu.tieba.pluginCenter;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import c.a.d.f.p.l;
import c.a.d.f.p.m;
import c.a.o0.r.t.a;
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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.plugin.ShadowLayout;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes5.dex */
public class PluginDetailActivity extends BaseActivity<PluginDetailActivity> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final float M_BYTE = 1048576.0f;
    public static final int STATUS_FORBIDDEN = 2;
    public static final int STATUS_UNFORBIDDEN = 3;
    public static final int STATUS_UNINSTALL = 0;
    public static final int STATUS_UPDATE = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView mChangelogText;
    public c.a.d.j.j.c mDownLoadAndInstallCallback;
    public ProgressBar mDownloadProgressBar;
    public TextView mDownloadText;
    public TextView mEnableText;
    public boolean mFinished;
    public HeadImageView mIcon;
    public TextView mName;
    public NavigationBar mNavigationBar;
    public final CustomMessageListener mNetworkChangedMessageListener;
    public PluginNetConfigInfos.PluginConfig mPluginConfig;
    public String mPluginName;
    public TextView mSizeText;
    public int mStatus;
    public ShadowLayout mStatusContainer;
    public TextView mStatusText;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PluginDetailActivity a;

        public a(PluginDetailActivity pluginDetailActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pluginDetailActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pluginDetailActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.closeActivity();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PluginDetailActivity a;

        public b(PluginDetailActivity pluginDetailActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pluginDetailActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pluginDetailActivity;
        }

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                SkinManager.setViewTextColor(this.a.mEnableText, R.color.CAM_X0109, 1);
                this.a.mEnableText.setEnabled(false);
                PluginPackageManager.u().K(this.a.mPluginConfig, this.a.mDownLoadAndInstallCallback);
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PluginDetailActivity a;

        public c(PluginDetailActivity pluginDetailActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pluginDetailActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pluginDetailActivity;
        }

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements c.a.d.j.j.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PluginDetailActivity a;

        public d(PluginDetailActivity pluginDetailActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pluginDetailActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pluginDetailActivity;
        }

        @Override // c.a.d.j.j.c
        public void a(BdFileDownloadData bdFileDownloadData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, bdFileDownloadData) == null) || bdFileDownloadData == null || this.a.mPluginConfig == null || !bdFileDownloadData.getId().equals(this.a.mPluginConfig.package_name)) {
                return;
            }
            this.a.showToast(bdFileDownloadData.getStatusMsg());
            this.a.setStatus();
            this.a.mFinished = true;
        }
    }

    /* loaded from: classes5.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PluginDetailActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(PluginDetailActivity pluginDetailActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pluginDetailActivity, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pluginDetailActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && l.z()) {
                this.a.setStatus();
            }
        }
    }

    public PluginDetailActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mDownLoadAndInstallCallback = new d(this);
        this.mNetworkChangedMessageListener = new e(this, 2000994);
    }

    private int getDownloadPercent(PluginNetConfigInfos.PluginConfig pluginConfig) {
        InterceptResult invokeL;
        PluginSetting h2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, this, pluginConfig)) == null) {
            if (pluginConfig == null || (h2 = c.a.d.j.j.f.c.j().h(pluginConfig.package_name)) == null) {
                return 0;
            }
            String h3 = Util.h(h2);
            if (m.isEmpty(h3)) {
                return 0;
            }
            try {
                File file = new File(h3 + ".tmp");
                if (file.exists() && h2.size > 0) {
                    return (int) (((file.length() * 1.0d) / h2.size) * 100.0d);
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            return 0;
        }
        return invokeL.intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStatus() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001303));
            if (PluginPackageManager.u().x(this.mPluginName) && PluginPackageManager.u().l(this.mPluginName)) {
                this.mStatusText.setText(R.string.obfuscated_res_0x7f0f0e5d);
                this.mEnableText.setVisibility(0);
                this.mEnableText.setText(R.string.obfuscated_res_0x7f0f04f8);
                this.mEnableText.setEnabled(true);
                SkinManager.setBackgroundResource(this.mEnableText, R.drawable.selector_blue_gradient_button);
                this.mStatusContainer.setShadowColor(R.color.plugin_button_shadow_blue);
                SkinManager.setViewTextColor(this.mEnableText, R.color.CAM_X0111, 1);
                this.mDownloadProgressBar.setVisibility(8);
                this.mDownloadText.setVisibility(8);
                this.mStatus = 1;
            } else if (PluginPackageManager.u().l(this.mPluginName)) {
                this.mEnableText.setEnabled(true);
                SkinManager.setViewTextColor(this.mEnableText, R.color.CAM_X0111, 1);
                this.mEnableText.setVisibility(0);
                this.mDownloadProgressBar.setVisibility(8);
                this.mDownloadText.setVisibility(8);
                if (PluginPackageManager.u().A(this.mPluginName)) {
                    this.mStatusText.setText(R.string.obfuscated_res_0x7f0f0e78);
                    this.mEnableText.setText(R.string.obfuscated_res_0x7f0f0e5c);
                    SkinManager.setBackgroundResource(this.mEnableText, R.drawable.selector_blue_gradient_button);
                    this.mStatusContainer.setShadowColor(R.color.plugin_button_shadow_blue);
                    this.mStatus = 2;
                    return;
                }
                this.mStatusText.setText(R.string.obfuscated_res_0x7f0f0e5d);
                this.mEnableText.setText(R.string.obfuscated_res_0x7f0f0e77);
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
                this.mStatusText.setText(R.string.obfuscated_res_0x7f0f0e58);
                this.mEnableText.setText(R.string.obfuscated_res_0x7f0f08e8);
                this.mEnableText.setEnabled(true);
                SkinManager.setBackgroundResource(this.mEnableText, R.drawable.selector_blue_gradient_button);
                this.mStatusContainer.setShadowColor(R.color.plugin_button_shadow_blue);
                SkinManager.setViewTextColor(this.mEnableText, R.color.CAM_X0111, 1);
                this.mStatus = 0;
                this.mDownloadProgressBar.setVisibility(8);
                this.mDownloadText.setVisibility(8);
            }
        }
    }

    private void showMobileNetDownloadDialog() {
        PluginNetConfigInfos.PluginConfig pluginConfig;
        String string;
        String string2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65548, this) == null) || (pluginConfig = this.mPluginConfig) == null || pluginConfig.newest == null) {
            return;
        }
        c.a.o0.r.t.a aVar = new c.a.o0.r.t.a(getPageContext().getPageActivity());
        boolean z = this.mStatus == 1;
        float f2 = this.mPluginConfig.newest.size / 1048576.0f;
        if (z) {
            string = getResources().getString(R.string.obfuscated_res_0x7f0f0e79, Float.valueOf(f2));
            string2 = getResources().getString(R.string.obfuscated_res_0x7f0f04f8);
        } else {
            string = getResources().getString(R.string.obfuscated_res_0x7f0f0e5a, Float.valueOf(f2));
            string2 = getResources().getString(R.string.obfuscated_res_0x7f0f04e3);
        }
        aVar.setMessage(string);
        aVar.setPositiveButton(string2, new b(this));
        aVar.setNegativeButton(R.string.obfuscated_res_0x7f0f036c, new c(this));
        aVar.create(getPageContext());
        aVar.show();
    }

    private void startLoadPlugin() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            if (!l.z()) {
                showToast(R.string.obfuscated_res_0x7f0f0c15);
            } else if (l.x()) {
                showMobileNetDownloadDialog();
            } else {
                PluginNetConfigInfos.PluginConfig pluginConfig = this.mPluginConfig;
                if (pluginConfig == null || TextUtils.isEmpty(pluginConfig.package_name) || PluginPackageManager.u().y(this.mPluginConfig.package_name)) {
                    return;
                }
                this.mEnableText.setEnabled(false);
                this.mFinished = false;
                PluginPackageManager.u().K(this.mPluginConfig, this.mDownLoadAndInstallCallback);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setResult(-1);
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            super.onChangeSkinType(i);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            this.mDownloadProgressBar.setProgressDrawable(SkinManager.getDrawable(R.drawable.download_progressbar));
            this.mDownloadProgressBar.setIndeterminateDrawable(SkinManager.getDrawable(R.drawable.download_progressbar));
            getLayoutMode().k(i == 1);
            getLayoutMode().j(findViewById(16908290));
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) && view == this.mEnableText) {
            int i = this.mStatus;
            if (i == 0 || i == 1) {
                startLoadPlugin();
            } else if (i == 3) {
                PluginPackageManager.u().s(this.mPluginName);
                setStatus();
            } else if (i == 2) {
                PluginPackageManager.u().M(this.mPluginName);
                setStatus();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d06f0);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f091519);
            this.mNavigationBar = navigationBar;
            navigationBar.setCenterTextTitle(getString(R.string.obfuscated_res_0x7f0f0e56));
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
            this.mIcon = (HeadImageView) findViewById(R.id.obfuscated_res_0x7f090e06);
            this.mName = (TextView) findViewById(R.id.obfuscated_res_0x7f0914e9);
            this.mStatusText = (TextView) findViewById(R.id.obfuscated_res_0x7f091da7);
            this.mDownloadProgressBar = (ProgressBar) findViewById(R.id.obfuscated_res_0x7f091864);
            this.mDownloadText = (TextView) findViewById(R.id.obfuscated_res_0x7f091865);
            this.mChangelogText = (TextView) findViewById(R.id.obfuscated_res_0x7f0905e4);
            this.mSizeText = (TextView) findViewById(R.id.obfuscated_res_0x7f091d2b);
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f0908cf);
            this.mEnableText = textView;
            textView.setOnClickListener(this);
            this.mStatusContainer = (ShadowLayout) findViewById(R.id.obfuscated_res_0x7f09186f);
            this.mPluginName = getIntent().getStringExtra("name");
            if (c.a.d.j.j.e.d.a().b() != null) {
                this.mPluginConfig = c.a.d.j.j.e.d.a().b().getPluginConfig(this.mPluginName);
            }
            if (PluginPackageManager.u().y(this.mPluginName)) {
                PluginPackageManager.u().I(this.mDownLoadAndInstallCallback);
                SkinManager.setViewTextColor(this.mEnableText, R.color.CAM_X0109, 1);
                this.mEnableText.setEnabled(false);
            }
            registerListener(this.mNetworkChangedMessageListener);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048580, this, i, keyEvent)) == null) {
            if (i == 4) {
                closeActivity();
                return true;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onPause();
            PluginPackageManager.u().I(null);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        int downloadPercent;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onResume();
            if (this.mDownloadProgressBar != null && PluginPackageManager.u().y(this.mPluginName) && (downloadPercent = getDownloadPercent(this.mPluginConfig)) < 100) {
                SkinManager.setViewTextColor(this.mEnableText, R.color.CAM_X0109, 1);
                this.mStatusContainer.setShadowColor(0);
                this.mEnableText.setEnabled(false);
                this.mEnableText.setVisibility(8);
                this.mDownloadProgressBar.setVisibility(0);
                this.mDownloadText.setVisibility(0);
                this.mDownloadProgressBar.setProgress(downloadPercent);
            }
            PluginPackageManager.u().I(this.mDownLoadAndInstallCallback);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onStart();
            PluginNetConfigInfos.PluginConfig pluginConfig = this.mPluginConfig;
            if (pluginConfig != null) {
                this.mIcon.J(pluginConfig.icon, 10, false);
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
                        this.mSizeText.setText(getPageContext().getString(R.string.obfuscated_res_0x7f0f0e75) + String.valueOf(this.mPluginConfig.newest.size / 1024) + "KB");
                    }
                }
                this.mEnableText.setOnClickListener(this);
            }
        }
    }
}
