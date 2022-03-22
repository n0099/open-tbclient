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
import c.a.d.f.m.g;
import c.a.d.f.p.l;
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
/* loaded from: classes5.dex */
public class PluginDownloadActivity extends BaseActivity<PluginDownloadActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c mDialog;
    public boolean mFinished;
    public PluginNetConfigInfos.PluginConfig mPluginConfig;
    public boolean mStarting;

    /* loaded from: classes5.dex */
    public class a implements DialogInterface.OnKeyListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PluginDownloadActivity a;

        public a(PluginDownloadActivity pluginDownloadActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pluginDownloadActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pluginDownloadActivity;
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, dialogInterface, i, keyEvent)) == null) {
                if (!this.a.mStarting) {
                    g.b(this.a.mDialog, this.a.getPageContext());
                    return true;
                } else if (i == 4 && keyEvent.getAction() == 1) {
                    if (this.a.mDialog.f35603h.getVisibility() == 0) {
                        this.a.mDialog.f35603h.setVisibility(8);
                        this.a.mDialog.a.setVisibility(0);
                    } else {
                        this.a.mDialog.f35603h.setVisibility(0);
                        this.a.mDialog.a.setVisibility(8);
                    }
                    return true;
                } else {
                    return false;
                }
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PluginDownloadActivity a;

        public b(PluginDownloadActivity pluginDownloadActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pluginDownloadActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pluginDownloadActivity;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.a.setResult(0);
                this.a.finish();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends Dialog {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public LinearLayout a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f35597b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f35598c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f35599d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f35600e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f35601f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f35602g;

        /* renamed from: h  reason: collision with root package name */
        public LinearLayout f35603h;
        public TextView i;
        public TextView j;
        public TextView k;
        public TextView l;
        public final /* synthetic */ PluginDownloadActivity m;

        /* loaded from: classes5.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.a.m.setResult(0);
                    this.a.m.finish();
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public b(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.a.f35603h.setVisibility(8);
                    this.a.a.setVisibility(0);
                }
            }
        }

        /* renamed from: com.baidu.tieba.pluginCenter.PluginDownloadActivity$c$c  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class View$OnClickListenerC1888c implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            /* renamed from: com.baidu.tieba.pluginCenter.PluginDownloadActivity$c$c$a */
            /* loaded from: classes5.dex */
            public class a implements c.a.d.j.j.c {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ View$OnClickListenerC1888c a;

                public a(View$OnClickListenerC1888c view$OnClickListenerC1888c) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {view$OnClickListenerC1888c};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = view$OnClickListenerC1888c;
                }

                @Override // c.a.d.j.j.c
                public void a(BdFileDownloadData bdFileDownloadData) {
                    Interceptable interceptable = $ic;
                    if ((interceptable == null || interceptable.invokeL(1048576, this, bdFileDownloadData) == null) && bdFileDownloadData != null && bdFileDownloadData.getId().equals(this.a.a.m.mPluginConfig.package_name)) {
                        this.a.a.m.showToast(bdFileDownloadData.getStatusMsg());
                        this.a.a.m.mFinished = true;
                        g.b(this.a.a.m.mDialog, this.a.a.m.getPageContext());
                    }
                }
            }

            public View$OnClickListenerC1888c(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    if (l.z()) {
                        this.a.m.mStarting = true;
                        this.a.f35599d.setVisibility(8);
                        this.a.f35600e.setVisibility(8);
                        this.a.f35601f.setVisibility(0);
                        PluginPackageManager.u().K(this.a.m.mPluginConfig, new a(this));
                        return;
                    }
                    this.a.m.showToast(R.string.obfuscated_res_0x7f0f0c15);
                }
            }
        }

        /* loaded from: classes5.dex */
        public class d implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public d(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.a.m.setResult(0);
                    this.a.m.finish();
                    c.a.o0.r.j0.b.k().u("install_plugin_dialog_closed", true);
                    c.a.o0.r.j0.b.k().x("install_plugin_dialog_shown_time", new Date().getTime());
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(PluginDownloadActivity pluginDownloadActivity, Context context, int i) {
            super(context, i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pluginDownloadActivity, context, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.m = pluginDownloadActivity;
        }

        @Override // android.app.Dialog
        public void onCreate(Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
                super.onCreate(bundle);
                setContentView(R.layout.obfuscated_res_0x7f0d085d);
                findViewById(R.id.obfuscated_res_0x7f092443).setVisibility(8);
                findViewById(R.id.obfuscated_res_0x7f090eec).setVisibility(8);
                findViewById(R.id.obfuscated_res_0x7f090eef).setVisibility(8);
                this.a = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090814);
                this.k = (TextView) findViewById(R.id.obfuscated_res_0x7f092285);
                this.f35597b = (TextView) findViewById(R.id.obfuscated_res_0x7f09156e);
                this.f35598c = (TextView) findViewById(R.id.obfuscated_res_0x7f090777);
                TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f092283);
                this.f35599d = textView;
                textView.setText(this.m.getPageContext().getString(R.string.obfuscated_res_0x7f0f08e8));
                this.f35600e = (TextView) findViewById(R.id.obfuscated_res_0x7f092284);
                this.f35601f = (TextView) findViewById(R.id.obfuscated_res_0x7f09082f);
                TextView textView2 = (TextView) findViewById(R.id.obfuscated_res_0x7f091624);
                this.l = textView2;
                textView2.setVisibility(8);
                this.f35602g = (TextView) findViewById(R.id.obfuscated_res_0x7f090292);
                this.f35603h = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090492);
                this.i = (TextView) findViewById(R.id.obfuscated_res_0x7f091de2);
                this.j = (TextView) findViewById(R.id.obfuscated_res_0x7f09048f);
                this.i.setOnClickListener(new a(this));
                this.j.setOnClickListener(new b(this));
                if (!TextUtils.isEmpty(this.m.mPluginConfig.display_name)) {
                    this.k.setText(this.m.mPluginConfig.display_name);
                } else {
                    this.k.setText("");
                }
                if (this.m.mPluginConfig.newest != null) {
                    if (TextUtils.isEmpty(this.m.mPluginConfig.newest.version)) {
                        this.f35597b.setText("");
                    } else {
                        TextView textView3 = this.f35597b;
                        textView3.setText("版本：" + this.m.mPluginConfig.newest.version);
                    }
                    if (!TextUtils.isEmpty(this.m.mPluginConfig.newest.change_log)) {
                        this.f35598c.setText(this.m.mPluginConfig.newest.change_log);
                    } else {
                        this.f35598c.setText("");
                    }
                    String valueOf = String.valueOf(this.m.mPluginConfig.newest.size / 1024);
                    if (valueOf != null && !"".equals(valueOf)) {
                        this.f35602g.setVisibility(0);
                        TextView textView4 = this.f35602g;
                        textView4.setText(((Object) this.f35602g.getText()) + valueOf + "KB");
                    } else {
                        this.f35602g.setVisibility(8);
                    }
                } else {
                    this.f35597b.setText("");
                    this.f35598c.setText("");
                    this.f35602g.setText("");
                }
                this.f35599d.setOnClickListener(new View$OnClickListenerC1888c(this));
                this.f35600e.setOnClickListener(new d(this));
            }
        }
    }

    public PluginDownloadActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            super.onChangeSkinType(i);
            getLayoutMode().k(i == 1);
            getLayoutMode().j(this.mDialog.findViewById(R.id.obfuscated_res_0x7f0907aa));
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
                showToast(getPageContext().getString(R.string.obfuscated_res_0x7f0f0e57), false);
                finish();
                return;
            }
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.alpha = 0.0f;
            getWindow().setAttributes(attributes);
            c cVar = new c(this, getPageContext().getPageActivity(), R.style.obfuscated_res_0x7f10039e);
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
                PluginPackageManager.u().k(this.mPluginConfig.package_name);
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
