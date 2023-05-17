package com.baidu.tieba.view.anniversary;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.TBAlertBuilder;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ev4;
import com.baidu.tieba.n45;
import com.baidu.tieba.p45;
import com.baidu.tieba.r4a;
import com.baidu.tieba.ri;
import com.baidu.tieba.s4a;
import com.baidu.tieba.v4a;
import com.baidu.tieba.view.anniversary.model.AnniversaryEtModel;
import com.baidu.tieba.view.anniversary.view.MaxureLayerView;
import com.baidu.tieba.wp9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class Anniversary18thActivity extends BaseActivity<Anniversary18thActivity> implements s4a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AnniversaryEtModel a;
    public NavigationBar b;
    public RelativeLayout c;
    public TbImageView d;
    public EMTextView e;
    public EMTextView f;
    public EMTextView g;
    public ImageView h;
    public LinearLayout i;
    public LinearLayout j;
    public String k;
    public String l;
    public String m;
    public String n;
    public int o;
    public v4a p;
    public MaxureLayerView q;
    public PermissionJudgePolicy r;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Anniversary18thActivity a;

        public a(Anniversary18thActivity anniversary18thActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {anniversary18thActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = anniversary18thActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.o <= 0 || this.a.o >= 100) {
                    this.a.finish();
                } else {
                    this.a.H1();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Anniversary18thActivity a;

        public b(Anniversary18thActivity anniversary18thActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {anniversary18thActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = anniversary18thActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.o == 100 && !TextUtils.isEmpty(this.a.k)) {
                    r4a.n(this.a.getPageContext(), this.a.k, this.a.l, this.a.n, this.a.m);
                } else {
                    ri.Q(TbadkCoreApplication.getInst(), this.a.getString(R.string.obfuscated_res_0x7f0f13d3));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Anniversary18thActivity a;

        public c(Anniversary18thActivity anniversary18thActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {anniversary18thActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = anniversary18thActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.p != null) {
                UrlManager urlManager = UrlManager.getInstance();
                TbPageContext<Anniversary18thActivity> pageContext = this.a.getPageContext();
                urlManager.dealOneLink(pageContext, new String[]{ev4.a + this.a.p.a()});
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements PermissionJudgePolicy.PermissionDialogClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Anniversary18thActivity a;

        @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.PermissionDialogClickListener
        public void onDialogComfirmed(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            }
        }

        public d(Anniversary18thActivity anniversary18thActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {anniversary18thActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = anniversary18thActivity;
        }

        @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.PermissionDialogClickListener
        public void onDialogCaneled(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.a.finish();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements PermissionJudgePolicy.OnPermissionsGrantedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Anniversary18thActivity a;

        public e(Anniversary18thActivity anniversary18thActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {anniversary18thActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = anniversary18thActivity;
        }

        @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.OnPermissionsGrantedListener
        public void onPermissionsGranted() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.a != null) {
                this.a.a.X(this.a.p);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;
        public final /* synthetic */ Anniversary18thActivity b;

        public f(Anniversary18thActivity anniversary18thActivity, AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {anniversary18thActivity, alertDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = anniversary18thActivity;
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            AlertDialog alertDialog;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (alertDialog = this.a) != null) {
                alertDialog.dismiss();
                this.b.a.cancel();
                this.b.finish();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;
        public final /* synthetic */ Anniversary18thActivity b;

        public g(Anniversary18thActivity anniversary18thActivity, AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {anniversary18thActivity, alertDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = anniversary18thActivity;
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            AlertDialog alertDialog;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (alertDialog = this.a) != null) {
                alertDialog.dismiss();
            }
        }
    }

    public Anniversary18thActivity() {
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

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onDestroy();
            AnniversaryEtModel anniversaryEtModel = this.a;
            if (anniversaryEtModel != null) {
                anniversaryEtModel.cancel();
            }
        }
    }

    @Override // com.baidu.tieba.s4a
    public void onFinish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            finish();
        }
    }

    @Override // com.baidu.tieba.s4a
    public void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.o = i;
            this.q.setProgress(i);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d002b);
            setSwipeBackEnabled(false);
            this.a = new AnniversaryEtModel(getPageContext(), this);
            init();
        }
    }

    @Override // com.baidu.tieba.s4a
    public void E0(v4a v4aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, v4aVar) == null) {
            this.p = v4aVar;
            TbImageView tbImageView = this.d;
            if (tbImageView != null) {
                tbImageView.N(v4aVar.b(), 10, false);
            }
            if (this.r == null) {
                this.r = new PermissionJudgePolicy();
            }
            this.r.clearRequestPermissionList();
            this.r.appendRequestPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE");
            this.r.setDialogClickListener(new d(this));
            this.r.setOnPermissionsGrantedListener(new e(this));
            if (this.r.startRequestPermission(this)) {
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            super.onChangeSkinType(i);
            this.b.onChangeSkinType(getPageContext(), 0);
            if (this.b.getBackImageView() != null) {
                this.b.getBackImageView().setImageDrawable(SvgManager.getInstance().getPureDrawable(R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS, false));
            }
            this.h.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_list_arrow16_right, SkinManager.getColor(0, (int) R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL));
        }
    }

    public final void H1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            TBAlertConfig.a aVar = new TBAlertConfig.a(getString(R.string.pickerview_submit), TBAlertConfig.OperateBtnStyle.MAIN);
            TBAlertConfig.a aVar2 = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f03c3, TBAlertConfig.OperateBtnStyle.SECONDARY);
            TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(TbadkCoreApplication.getInst().getCurrentActivity());
            tBAlertBuilder.x(getString(R.string.obfuscated_res_0x7f0f13d2));
            tBAlertBuilder.q(getString(R.string.obfuscated_res_0x7f0f13d1));
            tBAlertBuilder.o(true);
            tBAlertBuilder.u(aVar2, aVar);
            tBAlertBuilder.j(false);
            AlertDialog z = tBAlertBuilder.z();
            aVar.a(new f(this, z));
            aVar2.a(new g(this, z));
        }
    }

    @Override // com.baidu.tieba.s4a
    public void N0(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, str3, str4) == null) {
            this.k = r4a.m(getPageContext(), str);
            this.l = str2;
            this.n = str3;
            this.m = str4;
            this.q.setVisibility(8);
            this.e.setText(getString(R.string.obfuscated_res_0x7f0f13d5));
        }
    }

    public final void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
            this.b = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).setOnClickListener(new a(this));
            this.c = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f09168e);
            this.d = (TbImageView) findViewById(R.id.obfuscated_res_0x7f09233a);
            this.e = (EMTextView) findViewById(R.id.obfuscated_res_0x7f091791);
            this.f = (EMTextView) findViewById(R.id.obfuscated_res_0x7f0920e3);
            this.j = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0920e4);
            this.g = (EMTextView) findViewById(R.id.obfuscated_res_0x7f091790);
            MaxureLayerView maxureLayerView = (MaxureLayerView) findViewById(R.id.obfuscated_res_0x7f09169d);
            this.q = maxureLayerView;
            maxureLayerView.c(true);
            this.q.d(wp9.a(SkinManager.getColor(0, (int) R.color.CAM_X0611), SkinManager.RESOURCE_ALPHA_DISABLE));
            this.q.g(getResources().getColor(R.color.CAM_X0101));
            this.q.f(wp9.a(SkinManager.getColor(0, (int) R.color.CAM_X0611), n45.b(R.string.A_X05)));
            this.q.e(wp9.a(SkinManager.getColor(0, (int) R.color.CAM_X0101), SkinManager.RESOURCE_ALPHA_PRESS));
            this.q.h(UtilHelper.getDimenPixelSize(R.dimen.T_X07));
            this.h = (ImageView) findViewById(R.id.obfuscated_res_0x7f091e31);
            this.i = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090088);
            this.d.setAutoChangeStyle(false);
            this.d.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.d.setDrawCorner(true);
            this.d.setConrers(15);
            this.d.setRadiusById(R.string.J_X06);
            this.d.setPlaceHolderAutoChangeSkinType(2);
            this.d.setDrawBorder(false);
            p45.d(this.f).C(R.string.F_X02);
            this.j.setBackgroundDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f0809d0, WebPManager.ResourceStateType.NORMAL));
            this.f.setOnClickListener(new b(this));
            this.i.setOnClickListener(new c(this));
            c(0);
            this.a.W(1);
        }
    }

    @Override // com.baidu.tieba.s4a
    public void onError(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, str) == null) {
            ri.Q(TbadkCoreApplication.getInst(), str);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048586, this, i, keyEvent)) == null) {
            if (i == 4 && (i2 = this.o) > 0 && i2 < 100) {
                H1();
                return true;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        boolean z;
        PermissionJudgePolicy permissionJudgePolicy;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048587, this, i, strArr, iArr) == null) {
            super.onRequestPermissionsResult(i, strArr, iArr);
            if (iArr != null && iArr.length > 0 && strArr != null && strArr.length > 0) {
                if (iArr[0] != 0 && (permissionJudgePolicy = this.mCurrentPermissionJudgePolicy) != null) {
                    z = permissionJudgePolicy.checkPermissionForbidden(this, strArr[0]);
                } else {
                    z = false;
                }
                for (int i2 = 0; i2 < strArr.length; i2++) {
                    if (iArr[i2] != 0) {
                        if (z) {
                            finish();
                            return;
                        }
                        return;
                    }
                }
            }
        }
    }
}
