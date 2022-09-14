package com.baidu.tieba;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ala.utils.AlaStringHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.ala.personcenter.privilege.achievementmark.model.AlaUpdateMarkStatusModel;
import com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.MarkLevelGroup;
import com.baidu.tieba.au4;
import com.baidu.tieba.wallet.CurrencySwitchUtil;
import com.baidu.tieba.xy5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.protobuf.CodedInputStream;
/* loaded from: classes6.dex */
public class zy5 extends Dialog {
    public static /* synthetic */ Interceptable $ic;
    public static final int u;
    public static final int v;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public View b;
    public TbImageView c;
    public FrameLayout d;
    public TextView e;
    public RelativeLayout f;
    public TextView g;
    public TextView h;
    public MarkLevelGroup i;
    public TextView j;
    public cz5 k;
    public AlaUpdateMarkStatusModel l;
    public h m;
    public LinearLayout n;
    public TextView o;
    public TextView p;
    public LinearLayout q;
    public TextView r;
    public yy5 s;
    public xy5 t;

    /* loaded from: classes6.dex */
    public class a implements AlaUpdateMarkStatusModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zy5 a;

        public a(zy5 zy5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zy5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zy5Var;
        }

        @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.model.AlaUpdateMarkStatusModel.b
        public void onResult(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                this.a.j.setEnabled(true);
                if (z) {
                    if (this.a.m != null) {
                        this.a.m.a(true, this.a.k);
                    }
                    this.a.dismiss();
                    return;
                }
                if (StringUtils.isNull(str)) {
                    str = this.a.getContext().getResources().getString(R.string.obfuscated_res_0x7f0f01fa);
                }
                this.a.a.showToast(str);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements xy5.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zy5 a;

        public b(zy5 zy5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zy5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zy5Var;
        }

        @Override // com.baidu.tieba.xy5.b
        public void a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                if (z) {
                    if (this.a.k != null) {
                        this.a.a.showToast(R.string.obfuscated_res_0x7f0f01fc);
                        if (this.a.m != null) {
                            this.a.m.a(true, this.a.k);
                        }
                        this.a.k.q(2);
                        this.a.v();
                        this.a.u();
                        this.a.s();
                    }
                } else if (!StringUtils.isNull(str)) {
                    this.a.a.showToast(str);
                } else {
                    this.a.a.showToast(R.string.obfuscated_res_0x7f0f01fb);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zy5 a;

        public c(zy5 zy5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zy5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zy5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.m != null) {
                    this.a.m.a(false, this.a.k);
                }
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements MarkLevelGroup.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zy5 a;

        public d(zy5 zy5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zy5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zy5Var;
        }

        @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.MarkLevelGroup.b
        public void a(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
                this.a.t(str, str2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zy5 a;

        public e(zy5 zy5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zy5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zy5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.k.j() == 0 || 3 == this.a.k.j()) {
                    if (this.a.k.m()) {
                        if (this.a.k.n > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                            if (this.a.s != null) {
                                this.a.s.a(this.a.k.n);
                            }
                        } else if (this.a.t != null) {
                            this.a.t.c(this.a.k.d(), this.a.k.m, false);
                        }
                    } else if (this.a.k.l()) {
                    } else {
                        this.a.dismiss();
                    }
                } else if (!this.a.k.k() || 2 != this.a.k.j()) {
                    this.a.q();
                } else {
                    this.a.r();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements au4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zy5 a;

        public f(zy5 zy5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zy5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zy5Var;
        }

        @Override // com.baidu.tieba.au4.e
        public void onClick(au4 au4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, au4Var) == null) {
                au4Var.dismiss();
                this.a.j.setEnabled(false);
                this.a.q();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements au4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zy5 a;

        public g(zy5 zy5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zy5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zy5Var;
        }

        @Override // com.baidu.tieba.au4.e
        public void onClick(au4 au4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, au4Var) == null) {
                au4Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface h {
        void a(boolean z, cz5 cz5Var);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948376307, "Lcom/baidu/tieba/zy5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948376307, "Lcom/baidu/tieba/zy5;");
                return;
            }
        }
        u = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070215);
        v = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070207);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zy5(TbPageContext tbPageContext, h hVar) {
        super(tbPageContext.getPageActivity());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, hVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
        this.m = hVar;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.dismiss();
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
            getWindow().setLayout(-1, -1);
            setCancelable(true);
            setCanceledOnTouchOutside(true);
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            AlaUpdateMarkStatusModel alaUpdateMarkStatusModel = new AlaUpdateMarkStatusModel(getContext());
            this.l = alaUpdateMarkStatusModel;
            alaUpdateMarkStatusModel.D(new a(this));
            this.s = new yy5(this.a);
            this.t = new xy5(this.a, new b(this));
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            View inflate = getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d00e4, (ViewGroup) null);
            this.b = inflate;
            setContentView(inflate);
            this.b.setOnClickListener(new c(this));
            TbImageView tbImageView = (TbImageView) this.b.findViewById(R.id.obfuscated_res_0x7f0914ad);
            this.c = tbImageView;
            tbImageView.setDefaultBgResource(R.color.transparent);
            this.c.setDefaultResource(R.drawable.obfuscated_res_0x7f080f5c);
            this.d = (FrameLayout) this.b.findViewById(R.id.obfuscated_res_0x7f0914ae);
            this.e = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f0914b9);
            this.f = (RelativeLayout) this.b.findViewById(R.id.obfuscated_res_0x7f0914ab);
            this.g = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f0914aa);
            this.h = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f0914ba);
            MarkLevelGroup markLevelGroup = (MarkLevelGroup) this.b.findViewById(R.id.obfuscated_res_0x7f0914b3);
            this.i = markLevelGroup;
            markLevelGroup.setCallback(new d(this));
            this.j = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f0914b5);
            this.p = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f0914b4);
            this.n = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0914b7);
            this.o = (TextView) findViewById(R.id.obfuscated_res_0x7f0914b8);
            this.q = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0924d2);
            this.r = (TextView) findViewById(R.id.obfuscated_res_0x7f0924d3);
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            if (Build.VERSION.SDK_INT >= 19) {
                getWindow().addFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
                getWindow().addFlags(134217728);
            }
            super.onCreate(bundle);
            getWindow().requestFeature(1);
            o();
            m();
            n();
        }
    }

    public void p() {
        AlaUpdateMarkStatusModel alaUpdateMarkStatusModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (alaUpdateMarkStatusModel = this.l) == null) {
            return;
        }
        alaUpdateMarkStatusModel.onDestroy();
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (1 == this.k.j()) {
                this.l.E(false, this.k.d());
            } else if (2 == this.k.j()) {
                this.l.E(true, this.k.d());
            }
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            au4 au4Var = new au4(this.a.getPageActivity());
            au4Var.setMessageShowCenter(true);
            au4Var.setCanceledOnTouchOutside(false);
            au4Var.setTitle(R.string.obfuscated_res_0x7f0f01f9);
            au4Var.setMessageId(R.string.obfuscated_res_0x7f0f01f8);
            au4Var.setPositiveButton(R.string.dialog_ok, new f(this));
            au4Var.setNegativeButton(R.string.dialog_cancel, new g(this));
            au4Var.create(this.a).show();
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.g.setVisibility(4);
            this.h.setVisibility(4);
            this.n.setVisibility(4);
            this.i.setVisibility(4);
            this.q.setVisibility(8);
            if (this.k.m()) {
                this.n.setVisibility(0);
                this.q.setVisibility(0);
                Drawable normalSkinMoneyIcon = CurrencySwitchUtil.getNormalSkinMoneyIcon();
                int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701e8);
                normalSkinMoneyIcon.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                this.o.setCompoundDrawablePadding(getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070302));
                this.o.setCompoundDrawables(normalSkinMoneyIcon, null, null, null);
                this.o.setText(AlaStringHelper.formatLowercasekDou((float) this.k.n));
                this.r.setCompoundDrawablePadding(getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070224));
                this.r.setCompoundDrawables(normalSkinMoneyIcon, null, null, null);
                this.r.setText(AlaStringHelper.formatLowercasekDou((float) TbadkCoreApplication.getInst().currentAccountTdouNum));
                if (this.k.j() == 1) {
                    this.q.setVisibility(8);
                }
            } else if (this.k.l()) {
                this.g.setVisibility(0);
                this.g.setText(this.k.a());
            } else {
                this.i.setVisibility(0);
                this.g.setVisibility(0);
                this.h.setVisibility(0);
                this.g.setText(this.k.a());
                this.h.setText(this.k.i());
                this.i.f(this.k);
            }
        }
    }

    public final void t(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, str, str2) == null) {
            if (StringUtils.isNull(str)) {
                this.c.K(String.valueOf((int) R.drawable.obfuscated_res_0x7f080f5c), 24, false);
            } else {
                this.c.K(str, 10, false);
            }
            this.e.setText(str2);
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (this.k.j() != 1 && this.k.j() != 2) {
                this.p.setVisibility(8);
                return;
            }
            this.p.setVisibility(0);
            this.p.setText(this.k.b());
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            int j = this.k.j();
            if (j != 0) {
                if (j != 1) {
                    if (j != 2) {
                        if (j == 3) {
                            if (this.k.m()) {
                                this.j.setBackgroundResource(R.drawable.obfuscated_res_0x7f0801d5);
                                this.j.setTextSize(0, v);
                                this.j.setText(R.string.obfuscated_res_0x7f0f0217);
                                this.j.setTextColor(getContext().getResources().getColor(R.color.CAM_X0201));
                                if (this.k.n > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                                    this.j.setText(R.string.obfuscated_res_0x7f0f01ed);
                                }
                            } else if (this.k.l()) {
                                this.j.setBackgroundResource(R.drawable.obfuscated_res_0x7f0801e1);
                                this.j.setTextSize(0, v);
                                this.j.setText(R.string.obfuscated_res_0x7f0f0239);
                                this.j.setTextColor(getContext().getResources().getColor(R.color.obfuscated_res_0x7f060405));
                            } else {
                                this.j.setBackgroundResource(R.drawable.obfuscated_res_0x7f08123c);
                                this.j.setTextSize(0, u);
                                this.j.setText(R.string.obfuscated_res_0x7f0f01f2);
                                this.j.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d_alpha60));
                            }
                        }
                    } else if (this.k.m()) {
                        this.j.setBackgroundResource(R.drawable.obfuscated_res_0x7f0801d5);
                        this.j.setTextSize(0, v);
                        this.j.setText(R.string.obfuscated_res_0x7f0f01fe);
                        this.j.setTextColor(getContext().getResources().getColorStateList(R.color.CAM_X0201));
                    } else if (this.k.l()) {
                        this.j.setBackgroundResource(R.drawable.obfuscated_res_0x7f0801e1);
                        this.j.setTextSize(0, v);
                        this.j.setText(R.string.obfuscated_res_0x7f0f01fe);
                        this.j.setTextColor(getContext().getResources().getColorStateList(R.color.obfuscated_res_0x7f060405));
                    } else {
                        this.j.setBackgroundResource(R.drawable.obfuscated_res_0x7f080d4f);
                        this.j.setTextSize(0, v);
                        this.j.setText(R.string.obfuscated_res_0x7f0f01fe);
                        this.j.setTextColor(getContext().getResources().getColorStateList(R.color.obfuscated_res_0x7f0607af));
                    }
                } else if (this.k.m()) {
                    this.j.setBackgroundResource(R.drawable.obfuscated_res_0x7f080d4c);
                    this.j.setTextSize(0, v);
                    this.j.setText(R.string.obfuscated_res_0x7f0f01fd);
                    this.j.setTextColor(getContext().getResources().getColorStateList(R.color.obfuscated_res_0x7f0607ae));
                } else if (this.k.l()) {
                    this.j.setBackgroundResource(R.drawable.obfuscated_res_0x7f080d4c);
                    this.j.setTextSize(0, v);
                    this.j.setText(R.string.obfuscated_res_0x7f0f01fd);
                    this.j.setTextColor(getContext().getResources().getColorStateList(R.color.obfuscated_res_0x7f0607ae));
                } else {
                    this.j.setBackgroundResource(R.drawable.obfuscated_res_0x7f080d4c);
                    this.j.setTextSize(0, v);
                    this.j.setText(R.string.obfuscated_res_0x7f0f01fd);
                    this.j.setTextColor(getContext().getResources().getColorStateList(R.color.obfuscated_res_0x7f0607ae));
                }
            } else if (this.k.m()) {
                this.j.setBackgroundResource(R.drawable.obfuscated_res_0x7f0801d5);
                this.j.setTextSize(0, v);
                this.j.setText(R.string.obfuscated_res_0x7f0f0217);
                this.j.setTextColor(getContext().getResources().getColor(R.color.CAM_X0201));
                if (this.k.n > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                    this.j.setText(R.string.obfuscated_res_0x7f0f01ed);
                }
            } else if (this.k.l()) {
                this.j.setBackgroundResource(R.drawable.obfuscated_res_0x7f0801e1);
                this.j.setTextSize(0, v);
                this.j.setText(R.string.obfuscated_res_0x7f0f0239);
                this.j.setTextColor(getContext().getResources().getColor(R.color.obfuscated_res_0x7f060405));
            } else {
                this.j.setBackgroundResource(R.drawable.obfuscated_res_0x7f08123c);
                this.j.setTextSize(0, u);
                this.j.setText(R.string.obfuscated_res_0x7f0f01f4);
                this.j.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d_alpha60));
            }
            this.j.setOnClickListener(new e(this));
        }
    }
}
