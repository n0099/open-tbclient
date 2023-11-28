package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.IntentConstants;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.CombineDownload;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tbadk.switchs.UpdateDialogStyleSyncSwitch;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class r16 extends Dialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View A;
    public LinearLayout B;
    public f C;
    public View.OnClickListener D;
    public View.OnClickListener E;
    public boolean F;
    public boolean G;
    public View.OnClickListener H;
    public Context a;
    public VersionData b;
    public CombineDownload c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;
    public LinearLayout h;
    public LinearLayout i;
    public TextView j;
    public TextView k;
    public TextView l;
    public String m;
    public TextView n;
    public TextView o;
    public TextView p;
    public TextView q;
    public View r;
    public ImageView s;
    public TextView t;
    public TextView u;
    public View v;
    public LinearLayout w;
    public TextView x;
    public TextView y;
    public TextView z;

    /* loaded from: classes8.dex */
    public interface f {
        void a(boolean z);

        void b(boolean z);

        void c();

        void d();

        void e();
    }

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r16 a;

        public a(r16 r16Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r16Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r16Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_CLICK);
                this.a.f = true;
                if (this.a.e) {
                    Drawable drawable = SkinManager.getDrawable(R.drawable.btn_dailog_choose_d);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    this.a.n.setCompoundDrawables(drawable, null, null, null);
                }
                this.a.C.a(this.a.e);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r16 a;

        public b(r16 r16Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r16Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r16Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.G) {
                    TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_CLICK);
                } else {
                    TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_SUPER_SPEED_CLICK);
                }
                this.a.t.setEnabled(false);
                this.a.C.b(this.a.e);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r16 a;

        public c(r16 r16Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r16Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r16Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.C.d();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r16 a;

        public d(r16 r16Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r16Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r16Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.a.f) {
                return;
            }
            if (this.a.e) {
                Drawable drawable = SkinManager.getDrawable(R.drawable.btn_dailog_choose_n);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.a.n.setCompoundDrawables(drawable, null, null, null);
                this.a.d = false;
                this.a.e = false;
                return;
            }
            Drawable drawable2 = SkinManager.getDrawable(R.drawable.btn_dailog_choose_s);
            drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
            this.a.n.setCompoundDrawables(drawable2, null, null, null);
            this.a.d = true;
            this.a.e = true;
        }
    }

    /* loaded from: classes8.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r16 a;

        public e(r16 r16Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r16Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r16Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (view2.getId() == this.a.p.getId()) {
                    this.a.C.d();
                    r16 r16Var = this.a;
                    r16Var.n(r16Var.a);
                } else if (view2.getId() == this.a.s.getId()) {
                    this.a.C.d();
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r16(Context context, int i) {
        super(context, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i)};
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
        this.e = true;
        this.f = false;
        this.g = false;
        this.F = true;
        this.G = true;
        this.H = new e(this);
        this.a = context;
    }

    public void m(TbPageContext<?> tbPageContext, int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, tbPageContext, i) == null) {
            if (tbPageContext != null) {
                if (i == 4) {
                    z = true;
                } else {
                    z = false;
                }
                tbPageContext.getLayoutMode().setNightMode(z);
                tbPageContext.getLayoutMode().onModeChanged(findViewById(R.id.app_download_dialog_layout));
            }
            SkinManager.setImageResource(this.s, R.drawable.write_close_selector);
            EMManager.from(this.i).setCorner(R.string.J_X06).setBackGroundColor(R.color.CAM_X0211);
        }
    }

    public void p(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, onClickListener) == null) {
            this.D = onClickListener;
        }
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.q.setEnabled(z);
        }
    }

    public void u(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, onClickListener) == null) {
            this.E = onClickListener;
        }
    }

    public void n(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            Intent intent = new Intent(IntentConstants.ACTION_BOX_BROWSER, Uri.parse("market://details?id=" + context.getPackageName()));
            try {
                intent.setClassName("com.tencent.android.qqdownloader", "com.tencent.pangu.link.LinkProxyActivity");
                if (!(context instanceof Activity)) {
                    intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
                }
                context.startActivity(intent);
            } catch (ActivityNotFoundException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void v(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.q.setVisibility(8);
            this.v.setVisibility(8);
            this.o.setVisibility(8);
            this.r.setVisibility(8);
            this.f = true;
            this.B.setVisibility(0);
            this.l.setVisibility(0);
            TextView textView = this.l;
            textView.setText(this.m + i + "%");
            this.s.setVisibility(8);
            this.p.setVisibility(8);
        }
    }

    public final void o() {
        Window window;
        WindowManager.LayoutParams attributes;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || (window = getWindow()) == null || (attributes = window.getAttributes()) == null) {
            return;
        }
        attributes.width = -1;
        attributes.height = -1;
        window.setAttributes(attributes);
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.w.setVisibility(8);
            this.h.setVisibility(0);
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onBackPressed();
            if (this.f) {
                this.C.c();
                this.h.setVisibility(8);
                if (this.g) {
                    this.x.setText(getContext().getString(R.string.download_exit));
                }
                this.w.setVisibility(0);
                return;
            }
            this.C.e();
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.app_download_dialog);
            this.i = (LinearLayout) findViewById(R.id.dialog_content_ll);
            this.h = (LinearLayout) findViewById(R.id.app_info);
            this.j = (TextView) findViewById(R.id.app_version_and_size);
            this.k = (TextView) findViewById(R.id.app_description);
            this.q = (TextView) findViewById(R.id.fullsize_download_button);
            this.o = (TextView) findViewById(R.id.cancel_download_button);
            this.p = (TextView) findViewById(R.id.btn_update_save_flow);
            this.s = (ImageView) findViewById(R.id.img_close);
            this.p.setOnClickListener(this.H);
            this.s.setOnClickListener(this.H);
            this.r = findViewById(R.id.obfuscated_res_0x7f090957);
            this.l = (TextView) findViewById(R.id.download_process);
            this.t = (TextView) findViewById(R.id.incremental_download_button);
            this.u = (TextView) findViewById(R.id.not_install_as_tip);
            this.v = findViewById(R.id.incremental_download_layout);
            this.n = (TextView) findViewById(R.id.other_app_recommend);
            this.A = findViewById(R.id.divider_under_button);
            this.B = (LinearLayout) findViewById(R.id.cancel_confirm_ll);
            this.m = this.l.getText().toString();
            this.w = (LinearLayout) findViewById(R.id.cancel_dialog);
            this.y = (TextView) findViewById(R.id.sure_cancel);
            this.z = (TextView) findViewById(R.id.obfuscated_res_0x7f090576);
            this.x = (TextView) findViewById(R.id.cancel_tip);
            this.y.setOnClickListener(this.D);
            this.z.setOnClickListener(this.E);
            if (SwitchManager.getInstance().findType(UpdateDialogStyleSyncSwitch.KEY) == 1) {
                this.F = true;
            } else {
                this.F = false;
            }
            String size = this.b.getSize();
            String newVersion = this.b.getNewVersion();
            String newVersionDesc = this.b.getNewVersionDesc();
            StringBuilder sb = new StringBuilder();
            sb.append(this.a.getString(R.string.new_version_format));
            if (!TextUtils.isEmpty(newVersion)) {
                sb.append(newVersion);
            }
            if (!TextUtils.isEmpty(size)) {
                sb.append(" / " + String.format("%.2f", Float.valueOf(JavaTypesHelper.toFloat(size, 0.0f) / 1048576.0f)) + "MB");
            }
            this.j.setText(sb.toString());
            this.k.setText(newVersionDesc);
            if (this.b.forceUpdate()) {
                this.g = true;
                this.o.setText(this.a.getString(R.string.obfuscated_res_0x7f0f120e));
                this.p.setVisibility(8);
                this.s.setVisibility(8);
            } else {
                this.o.setText(this.a.getString(R.string.update_after));
                this.p.setVisibility(8);
                this.s.setVisibility(8);
            }
            CombineDownload combineDownload = this.c;
            if (combineDownload != null && combineDownload.showCombineDownload() && !TextUtils.isEmpty(this.c.getApkMD5RSA())) {
                this.n.setText(this.c.getAppName());
                if (!sva.b(this.a, this.c.getAppProc()) && !TextUtils.isEmpty(this.c.getAppUrl())) {
                    this.n.setVisibility(0);
                    Drawable drawable = this.a.getResources().getDrawable(R.drawable.btn_dailog_choose_s);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    this.n.setCompoundDrawables(drawable, null, null, null);
                } else {
                    this.n.setVisibility(8);
                }
            } else {
                this.n.setVisibility(8);
            }
            s(this.F);
            this.q.setOnClickListener(new a(this));
            this.t.setOnClickListener(new b(this));
            this.o.setOnClickListener(new c(this));
            this.n.setOnClickListener(new d(this));
            o();
        }
    }

    public void q(VersionData versionData, CombineDownload combineDownload, f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, versionData, combineDownload, fVar) == null) {
            this.b = versionData;
            this.c = combineDownload;
            this.C = fVar;
        }
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            if (z) {
                VersionData versionData = this.b;
                if (versionData != null && !TextUtils.isEmpty(versionData.getPatch()) && this.b.getNewVersionCode() >= 0) {
                    this.v.setVisibility(0);
                    this.t.setText(R.string.incremental_update);
                    SkinManager.setBackgroundResource(this.t, R.drawable.dialog_single_button_bg_selector);
                    this.A.setVisibility(8);
                    this.B.setVisibility(8);
                    this.G = true;
                    TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_SHOW);
                    return;
                }
                this.v.setVisibility(0);
                this.t.setText(R.string.super_update);
                SkinManager.setBackgroundResource(this.t, R.drawable.dialog_middle_item_bg_selector);
                this.B.setVisibility(0);
                this.G = false;
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_SUPER_SPEED_SHOW);
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
                return;
            }
            VersionData versionData2 = this.b;
            if (versionData2 != null && !TextUtils.isEmpty(versionData2.getPatch()) && this.b.getNewVersionCode() >= 0) {
                this.v.setVisibility(0);
                SkinManager.setBackgroundResource(this.t, R.drawable.dialog_middle_item_bg_selector);
                this.t.setText(R.string.incremental_update);
                this.B.setVisibility(0);
                this.G = true;
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_SHOW);
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
                return;
            }
            this.v.setVisibility(8);
            this.B.setVisibility(0);
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
        }
    }
}
