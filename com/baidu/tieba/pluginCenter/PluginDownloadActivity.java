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
import b.a.e.e.m.g;
import b.a.e.e.p.j;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.PluginDownloadActivityConfig;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
/* loaded from: classes9.dex */
public class PluginDownloadActivity extends BaseActivity<PluginDownloadActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c mDialog;
    public boolean mFinished;
    public PluginNetConfigInfos.PluginConfig mPluginConfig;
    public boolean mStarting;

    /* loaded from: classes9.dex */
    public class a implements DialogInterface.OnKeyListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PluginDownloadActivity f53341e;

        public a(PluginDownloadActivity pluginDownloadActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pluginDownloadActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53341e = pluginDownloadActivity;
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, dialogInterface, i2, keyEvent)) == null) {
                if (!this.f53341e.mStarting) {
                    g.b(this.f53341e.mDialog, this.f53341e.getPageContext());
                    return true;
                } else if (i2 == 4 && keyEvent.getAction() == 1) {
                    if (this.f53341e.mDialog.l.getVisibility() == 0) {
                        this.f53341e.mDialog.l.setVisibility(8);
                        this.f53341e.mDialog.f53343e.setVisibility(0);
                    } else {
                        this.f53341e.mDialog.l.setVisibility(0);
                        this.f53341e.mDialog.f53343e.setVisibility(8);
                    }
                    return true;
                } else {
                    return false;
                }
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class b implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PluginDownloadActivity f53342e;

        public b(PluginDownloadActivity pluginDownloadActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pluginDownloadActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53342e = pluginDownloadActivity;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.f53342e.setResult(0);
                this.f53342e.finish();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c extends Dialog {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public LinearLayout f53343e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f53344f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f53345g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f53346h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f53347i;
        public TextView j;
        public TextView k;
        public LinearLayout l;
        public TextView m;
        public TextView n;
        public TextView o;
        public TextView p;
        public final /* synthetic */ PluginDownloadActivity q;

        /* loaded from: classes9.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f53348e;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f53348e = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.f53348e.q.setResult(0);
                    this.f53348e.q.finish();
                }
            }
        }

        /* loaded from: classes9.dex */
        public class b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f53349e;

            public b(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f53349e = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.f53349e.l.setVisibility(8);
                    this.f53349e.f53343e.setVisibility(0);
                }
            }
        }

        /* renamed from: com.baidu.tieba.pluginCenter.PluginDownloadActivity$c$c  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class View$OnClickListenerC1758c implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f53350e;

            /* renamed from: com.baidu.tieba.pluginCenter.PluginDownloadActivity$c$c$a */
            /* loaded from: classes9.dex */
            public class a implements b.a.e.h.j.d {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ View$OnClickListenerC1758c f53351a;

                public a(View$OnClickListenerC1758c view$OnClickListenerC1758c) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {view$OnClickListenerC1758c};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f53351a = view$OnClickListenerC1758c;
                }

                @Override // b.a.e.h.j.d
                public void a(BdFileDownloadData bdFileDownloadData) {
                    Interceptable interceptable = $ic;
                    if ((interceptable == null || interceptable.invokeL(1048576, this, bdFileDownloadData) == null) && bdFileDownloadData != null && bdFileDownloadData.getId().equals(this.f53351a.f53350e.q.mPluginConfig.package_name)) {
                        this.f53351a.f53350e.q.mDialog.j.setText(this.f53351a.f53350e.q.getPageContext().getString(R.string.plugin_download_finished));
                        this.f53351a.f53350e.q.mDialog.j.setEnabled(false);
                        this.f53351a.f53350e.q.mFinished = true;
                    }
                }

                @Override // b.a.e.h.j.d
                public void b(BdFileDownloadData bdFileDownloadData) {
                    Interceptable interceptable = $ic;
                    if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdFileDownloadData) == null) && bdFileDownloadData != null && bdFileDownloadData.getId().equals(this.f53351a.f53350e.q.mPluginConfig.package_name)) {
                        this.f53351a.f53350e.q.showToast(bdFileDownloadData.getStatusMsg());
                        this.f53351a.f53350e.q.mFinished = true;
                        g.b(this.f53351a.f53350e.q.mDialog, this.f53351a.f53350e.q.getPageContext());
                    }
                }

                @Override // b.a.e.h.j.d
                public void c(BdFileDownloadData bdFileDownloadData, int i2, String str) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, bdFileDownloadData, i2, str) == null) {
                        if (i2 == 0) {
                            PluginDownloadActivity pluginDownloadActivity = this.f53351a.f53350e.q;
                            pluginDownloadActivity.showToast(pluginDownloadActivity.getPageContext().getString(R.string.plugin_installation_finished));
                            this.f53351a.f53350e.q.setResult(-1);
                            this.f53351a.f53350e.q.setResult(-1);
                            this.f53351a.f53350e.q.finish();
                            return;
                        }
                        this.f53351a.f53350e.q.setResult(0);
                        PluginDownloadActivity pluginDownloadActivity2 = this.f53351a.f53350e.q;
                        pluginDownloadActivity2.showToast(pluginDownloadActivity2.getPageContext().getString(R.string.plugin_installation_failed), false);
                        this.f53351a.f53350e.q.setResult(0);
                        this.f53351a.f53350e.q.finish();
                    }
                }

                @Override // b.a.e.h.j.d
                public void d(BdFileDownloadData bdFileDownloadData) {
                    Interceptable interceptable = $ic;
                    if (!(interceptable == null || interceptable.invokeL(1048579, this, bdFileDownloadData) == null) || bdFileDownloadData == null || !bdFileDownloadData.getId().equals(this.f53351a.f53350e.q.mPluginConfig.package_name) || this.f53351a.f53350e.q.mFinished) {
                        return;
                    }
                    this.f53351a.f53350e.q.mDialog.j.setText(String.format("正在下载插件：%d%%", Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                    this.f53351a.f53350e.q.mDialog.j.setEnabled(false);
                }
            }

            public View$OnClickListenerC1758c(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f53350e = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    if (j.z()) {
                        this.f53350e.q.mStarting = true;
                        this.f53350e.f53346h.setVisibility(8);
                        this.f53350e.f53347i.setVisibility(8);
                        this.f53350e.j.setVisibility(0);
                        PluginPackageManager.O().x0(this.f53350e.q.mPluginConfig, new a(this));
                        return;
                    }
                    this.f53350e.q.showToast(R.string.neterror);
                }
            }
        }

        /* loaded from: classes9.dex */
        public class d implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f53352e;

            public d(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f53352e = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.f53352e.q.setResult(0);
                    this.f53352e.q.finish();
                    b.a.q0.s.e0.b.j().t("install_plugin_dialog_closed", true);
                    b.a.q0.s.e0.b.j().w("install_plugin_dialog_shown_time", new Date().getTime());
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(PluginDownloadActivity pluginDownloadActivity, Context context, int i2) {
            super(context, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pluginDownloadActivity, context, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.q = pluginDownloadActivity;
        }

        @Override // android.app.Dialog
        public void onCreate(Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
                super.onCreate(bundle);
                setContentView(R.layout.update_dialog);
                findViewById(R.id.warning).setVisibility(8);
                findViewById(R.id.incremental_button).setVisibility(8);
                findViewById(R.id.incremental_size).setVisibility(8);
                this.f53343e = (LinearLayout) findViewById(R.id.down_dialog);
                this.o = (TextView) findViewById(R.id.update_tip);
                this.f53344f = (TextView) findViewById(R.id.newversion);
                this.f53345g = (TextView) findViewById(R.id.desc);
                TextView textView = (TextView) findViewById(R.id.update_button);
                this.f53346h = textView;
                textView.setText(this.q.getPageContext().getString(R.string.install_app));
                this.f53347i = (TextView) findViewById(R.id.update_cancel);
                this.j = (TextView) findViewById(R.id.downloading);
                TextView textView2 = (TextView) findViewById(R.id.otherApp);
                this.p = textView2;
                textView2.setVisibility(8);
                this.k = (TextView) findViewById(R.id.app_size);
                this.l = (LinearLayout) findViewById(R.id.cancel_dialog);
                this.m = (TextView) findViewById(R.id.sure_cancel);
                this.n = (TextView) findViewById(R.id.cancel_button);
                this.m.setOnClickListener(new a(this));
                this.n.setOnClickListener(new b(this));
                if (!TextUtils.isEmpty(this.q.mPluginConfig.display_name)) {
                    this.o.setText(this.q.mPluginConfig.display_name);
                } else {
                    this.o.setText("");
                }
                if (this.q.mPluginConfig.newest != null) {
                    if (TextUtils.isEmpty(this.q.mPluginConfig.newest.version)) {
                        this.f53344f.setText("");
                    } else {
                        TextView textView3 = this.f53344f;
                        textView3.setText("版本：" + this.q.mPluginConfig.newest.version);
                    }
                    if (!TextUtils.isEmpty(this.q.mPluginConfig.newest.change_log)) {
                        this.f53345g.setText(this.q.mPluginConfig.newest.change_log);
                    } else {
                        this.f53345g.setText("");
                    }
                    String valueOf = String.valueOf(this.q.mPluginConfig.newest.size / 1024);
                    if (valueOf != null && !"".equals(valueOf)) {
                        this.k.setVisibility(0);
                        TextView textView4 = this.k;
                        textView4.setText(((Object) this.k.getText()) + valueOf + "KB");
                    } else {
                        this.k.setVisibility(8);
                    }
                } else {
                    this.f53344f.setText("");
                    this.f53345g.setText("");
                    this.k.setText("");
                }
                this.f53346h.setOnClickListener(new View$OnClickListenerC1758c(this));
                this.f53347i.setOnClickListener(new d(this));
            }
        }
    }

    public PluginDownloadActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            super.onChangeSkinType(i2);
            getLayoutMode().k(i2 == 1);
            getLayoutMode().j(this.mDialog.findViewById(R.id.dialog_layout));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
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
            c cVar = new c(this, getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.mDialog = cVar;
            cVar.setCancelable(false);
            this.mDialog.setOnKeyListener(new a(this));
            this.mDialog.setOnDismissListener(new b(this));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.mPluginConfig != null) {
                PluginPackageManager.O().x(this.mPluginConfig.package_name);
            }
            super.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onStart();
            g.j(this.mDialog, getPageContext());
        }
    }
}
