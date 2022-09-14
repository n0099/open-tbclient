package com.baidu.tieba;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupEditText;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class k59 extends l59 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final i59 C;
    @Nullable
    public u39 D;
    @Nullable
    public k39 E;
    @Nullable
    public t39 F;
    @Nullable
    public w39 G;
    @Nullable
    public x39 H;
    @Nullable
    public j39 I;
    @NonNull
    public e59 J;
    @NonNull
    public po8 K;
    public final y49 L;
    public final y49 M;
    public final y49 N;
    public final y49 O;
    public final y49 P;
    public final y49 Q;
    public final y49 R;
    public final y49 S;
    public final y49 T;
    public final y49 U;

    /* loaded from: classes4.dex */
    public class a implements y49 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k59 a;

        public a(k59 k59Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k59Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k59Var;
        }

        @Override // com.baidu.tieba.y49
        public boolean a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                if (11 == this.a.p.getType() || 12 == this.a.p.getType() || 13 == this.a.p.getType()) {
                    return false;
                }
                u39 u39Var = this.a.D;
                return u39Var == null || !u39Var.L();
            }
            return invokeI.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements y49 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k59 a;

        public b(k59 k59Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k59Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k59Var;
        }

        @Override // com.baidu.tieba.y49
        public boolean a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                u39 u39Var = this.a.D;
                return u39Var == null || !u39Var.L();
            }
            return invokeI.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k59 a;

        public c(k59 k59Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k59Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k59Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                k59 k59Var = this.a;
                k59Var.a.showToast(k59Var.p.getDisableAudioMessage());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k59 a;

        public d(k59 k59Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k59Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k59Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                g39.b(1);
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.a.showToast((int) R.string.obfuscated_res_0x7f0f0c59);
                } else if (!xh5.a()) {
                    for (d49<?> d49Var : this.a.o) {
                        if (!d49Var.n()) {
                            return;
                        }
                    }
                    u39 u39Var = this.a.D;
                    EditText o = u39Var != null ? u39Var.o() : null;
                    k39 k39Var = this.a.E;
                    if (this.a.s.b(o, k39Var != null ? k39Var.o() : null)) {
                        k59 k59Var = this.a;
                        k59Var.a.showToast(k59Var.s.e());
                        return;
                    }
                    this.a.p(true);
                    this.a.C();
                    this.a.s0();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements y49 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k59 a;

        public e(k59 k59Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k59Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k59Var;
        }

        @Override // com.baidu.tieba.y49
        public boolean a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                u39 u39Var = this.a.D;
                return (u39Var == null || !u39Var.L()) && ListUtils.getCount(this.a.C.f().getChosedFiles()) < this.a.C.f().getMaxImagesAllowed();
            }
            return invokeI.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class f implements y49 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k59 a;

        public f(k59 k59Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k59Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k59Var;
        }

        @Override // com.baidu.tieba.y49
        public boolean a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                u39 u39Var = this.a.D;
                return u39Var == null || !u39Var.L();
            }
            return invokeI.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class g implements y49 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k59 a;

        public g(k59 k59Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k59Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k59Var;
        }

        @Override // com.baidu.tieba.y49
        public boolean a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                u39 u39Var = this.a.D;
                return u39Var == null || !u39Var.L();
            }
            return invokeI.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class h implements y49 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k59 a;

        public h(k59 k59Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k59Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k59Var;
        }

        @Override // com.baidu.tieba.y49
        public boolean a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                u39 u39Var = this.a.D;
                if ((u39Var != null && u39Var.L()) || 13 == this.a.p.getType() || 11 == this.a.p.getType()) {
                    return false;
                }
                w39 w39Var = this.a.G;
                return (w39Var == null || w39Var.v() == null || this.a.G.v().a == null) && ListUtils.getCount(this.a.C.f().getChosedFiles()) <= 0;
            }
            return invokeI.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class i implements y49 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k59 a;

        public i(k59 k59Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k59Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k59Var;
        }

        @Override // com.baidu.tieba.y49
        public boolean a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                u39 u39Var = this.a.D;
                if ((u39Var == null || !u39Var.L()) && 11 != this.a.p.getType()) {
                    x39 x39Var = this.a.H;
                    if (x39Var == null || !x39Var.r()) {
                        k39 k39Var = this.a.E;
                        return k39Var == null || k39Var.T() == 0;
                    }
                    return false;
                }
                return false;
            }
            return invokeI.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class j implements y49 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k59 a;

        public j(k59 k59Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k59Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k59Var;
        }

        @Override // com.baidu.tieba.y49
        public boolean a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                u39 u39Var = this.a.D;
                if ((u39Var == null || !u39Var.L()) && 11 != this.a.p.getType()) {
                    return ListUtils.isEmpty(this.a.p.getItemDatas());
                }
                return false;
            }
            return invokeI.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class k implements y49 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k59 a;

        public k(k59 k59Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k59Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k59Var;
        }

        @Override // com.baidu.tieba.y49
        public boolean a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                u39 u39Var = this.a.D;
                if ((u39Var == null || !u39Var.L()) && 11 != this.a.p.getType()) {
                    return ListUtils.isEmpty(this.a.p.getItemDatas());
                }
                return false;
            }
            return invokeI.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class l implements y49 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k59 a;

        public l(k59 k59Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k59Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k59Var;
        }

        @Override // com.baidu.tieba.y49
        public boolean a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                if (11 == this.a.p.getType()) {
                    return false;
                }
                u39 u39Var = this.a.D;
                if (u39Var == null || !u39Var.L()) {
                    return this.a.p.isVoiceEnable();
                }
                return false;
            }
            return invokeI.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k59(@NonNull TbPageContext<?> tbPageContext, @NonNull NavigationBar navigationBar, @NonNull LinearLayout linearLayout, @NonNull EditorTools editorTools, @NonNull c49 c49Var, boolean z) {
        super(tbPageContext, navigationBar, linearLayout, editorTools, c49Var, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, navigationBar, linearLayout, editorTools, c49Var, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (NavigationBar) objArr2[1], (LinearLayout) objArr2[2], (EditorTools) objArr2[3], (c49) objArr2[4], ((Boolean) objArr2[5]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.L = new e(this);
        this.M = new f(this);
        this.N = new g(this);
        this.O = new h(this);
        this.P = new i(this);
        this.Q = new j(this);
        this.R = new k(this);
        this.S = new l(this);
        this.T = new a(this);
        this.U = new b(this);
        this.C = new i59(this.a);
        this.J = new e59(this.a, this);
        this.K = po8.k();
    }

    @Override // com.baidu.tieba.l59
    public void L(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            super.L(bundle);
            this.C.e(this, this.p);
            k39 k39Var = this.E;
            if (k39Var == null || !(k39Var.o() instanceof SpanGroupEditText)) {
                return;
            }
            this.K.G(((SpanGroupEditText) this.E.o()).getSpanGroupManager());
        }
    }

    @Override // com.baidu.tieba.l59
    public void O(@NonNull EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, editorTools) == null) {
            n0();
            q0();
        }
    }

    @Override // com.baidu.tieba.l59
    public void P(@NonNull NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, navigationBar) == null) {
            super.P(navigationBar);
            this.l.setOnClickListener(new d(this));
        }
    }

    @Override // com.baidu.tieba.l59
    public void U(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            TbPageContext<?> tbPageContext = this.a;
            if (tbPageContext instanceof TbPageContextSupport) {
                this.K.p((TbPageContextSupport) tbPageContext);
            }
            super.U(bundle);
            if (this.a.getPageActivity() == null) {
                return;
            }
            this.C.g(bundle, this.a.getPageActivity().getIntent(), this.p);
        }
    }

    @Override // com.baidu.tieba.l59
    public x49 V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? new v49(this.a, this) : (x49) invokeV.objValue;
    }

    @Override // com.baidu.tieba.l59
    public void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (TextUtils.isEmpty(this.p.getTopicId())) {
                yl8.k(this.p.getForumId(), this);
            } else {
                yl8.r(this.p.getTopicId(), this);
            }
        }
    }

    @Override // com.baidu.tieba.l59
    public void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.c0();
            if (13 == this.p.getType() || 14 == this.p.getType() || 12 == this.p.getType()) {
                return;
            }
            if (TextUtils.isEmpty(this.p.getTopicId())) {
                yl8.t(this.p.getForumId(), this.p);
            } else {
                yl8.B(this.p.getTopicId(), this.p);
            }
        }
    }

    @Override // com.baidu.tieba.l59
    public boolean e0() {
        InterceptResult invokeV;
        TextView textView;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? !this.p.isSaveDraft() || (textView = this.l) == null || (!textView.isEnabled() && ListUtils.isEmpty(this.p.getItemDatas())) : invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.l59, com.baidu.tieba.f49
    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (super.h()) {
                return true;
            }
            u39 u39Var = this.D;
            if (u39Var != null && u39Var.r()) {
                d0(true);
                return true;
            }
            k39 k39Var = this.E;
            if (k39Var != null && k39Var.r()) {
                d0(true);
                return true;
            }
            t39 t39Var = this.F;
            if (t39Var != null && t39Var.r()) {
                d0(true);
                return true;
            } else if (this.C.f().getChosedFiles() != null && this.C.f().size() > 0) {
                d0(true);
                return true;
            } else {
                w39 w39Var = this.G;
                if (w39Var != null && w39Var.r()) {
                    d0(true);
                    return true;
                }
                x39 x39Var = this.H;
                if (x39Var != null && x39Var.r()) {
                    d0(true);
                    return true;
                }
                d0(false);
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.l59, com.baidu.tieba.f49
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.i();
            if (TextUtils.isEmpty(this.p.getTopicId())) {
                yl8.u(this.p.getForumId(), this.p, true);
            } else {
                yl8.B(this.p.getTopicId(), null);
            }
        }
    }

    @Override // com.baidu.tieba.l59, com.baidu.tieba.yl8.g
    public void k(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, writeData) == null) || WriteActivityConfig.FROM_FORUM_SHARE.equals(this.p.getFrom())) {
            return;
        }
        j39 j39Var = this.I;
        if (j39Var == null || !j39Var.r()) {
            if (!this.q || this.C.f().size() <= 0) {
                super.k(writeData);
            }
        }
    }

    public boolean l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            for (d49<?> d49Var : this.o) {
                if (d49Var.r()) {
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.l59, com.baidu.tieba.f49
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            u39 u39Var = this.D;
            this.J.f((u39Var == null || !u39Var.L()) ? "from_content" : "from_title");
            this.J.g(true);
            super.m();
        }
    }

    public void m0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_CHANGE_RICH_TEXT_MODE);
            statisticItem.param("obj_type", i2);
            TiebaStatic.log(statisticItem);
            if (i2 == 0) {
                TiebaStatic.log(CommonStatisticKey.KEY_LIMIT_MODE_CHANGE_TOAST);
            }
        }
    }

    public void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.g.c(10, this.L);
            this.g.c(5, this.M);
            this.g.c(9, this.N);
            this.g.c(34, this.O);
            this.g.c(35, this.P);
            this.g.c(33, this.Q);
            this.g.c(32, this.R);
            this.g.c(6, this.S);
            this.g.c(31, this.T);
            this.g.c(2, this.U);
        }
    }

    public void o0(int i2, int i3) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048591, this, i2, i3) == null) || (textView = this.i) == null) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView.getLayoutParams();
        layoutParams.rightMargin = i3;
        layoutParams.leftMargin = i2;
        this.i.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tieba.l59, com.baidu.tieba.f49
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            super.onChangeSkinType(i2);
            x29 x29Var = this.s;
            u39 u39Var = this.D;
            EditText o = u39Var == null ? null : u39Var.o();
            k39 k39Var = this.E;
            x29Var.l(o, k39Var != null ? k39Var.o() : null);
        }
    }

    @Override // com.baidu.tieba.l59, com.baidu.tieba.f49
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onDestroy();
            this.K.t();
        }
    }

    @Override // com.baidu.tieba.l59, com.baidu.tieba.f49
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, intent) == null) {
            super.onNewIntent(intent);
            this.C.m(intent);
        }
    }

    @Override // com.baidu.tieba.l59, com.baidu.tieba.f49
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            if (bundle == null) {
                return;
            }
            bundle.putString(WriteActivityConfig.HOT_TOPIC_ID, this.p.getTopicId());
            bundle.putInt(WriteActivityConfig.KEY_STATISTIS_FROM, this.p.getStatisticFrom());
        }
    }

    public void p0(@DrawableRes int i2, @DimenRes int i3, @DimenRes int i4, @DimenRes int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048596, this, i2, i3, i4, i5) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.k.getLayoutParams();
            layoutParams.width = ej.f(this.a.getPageActivity(), i3);
            layoutParams.height = ej.f(this.a.getPageActivity(), i4);
            layoutParams.topMargin = ej.f(this.a.getPageActivity(), i5);
            this.k.setLayoutParams(layoutParams);
            this.k.setImageDrawable(WebPManager.getPureDrawable(i2, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_DISABLE));
            this.k.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.l59, com.baidu.tieba.z39
    public void q(@NonNull e49 e49Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048597, this, e49Var, z) == null) {
            super.q(e49Var, z);
        }
    }

    public final void q0() {
        b55 m;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || (m = this.d.m(6)) == null || TextUtils.isEmpty(this.p.getDisableAudioMessage())) {
            return;
        }
        ((View) m).setOnClickListener(new c(this));
    }

    public final void r0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            u0();
            for (d49<?> d49Var : this.o) {
                d49Var.b(this.p);
            }
            this.p.setVcode(null);
            this.K.A(this.C.f().size() > 0);
            this.K.H(this.p);
            if (!this.K.e()) {
                this.a.showToast((int) R.string.obfuscated_res_0x7f0f15f3);
            } else if (!BdNetTypeUtil.isNetWorkAvailable()) {
                this.a.showToast((int) R.string.obfuscated_res_0x7f0f0c59);
            } else if (s38.a().b() == 0 && this.p.isShowCustomFigure()) {
                this.e.A();
            } else {
                t0();
            }
        }
    }

    @Override // com.baidu.tieba.f49
    public void s() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && this.p.isShowCustomFigure()) {
            this.p.setShowCustomFigure(false);
            bx4 k2 = bx4.k();
            k2.u("key_write_virtual_image_enable" + TbadkCoreApplication.getCurrentAccount(), false);
        }
    }

    public void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            if ("1".equals(this.p.getCallFrom())) {
                this.p.setCanNoForum(true);
                this.p.setTransmitForumData("[]");
            } else if ("2".equals(this.p.getCallFrom())) {
                this.p.setCanNoForum(false);
            }
            this.d.A(new u45(54, 15, null));
            this.d.A(new u45(65, 15, null));
            if (this.p.getVideoInfo() != null) {
                TiebaStatic.log("c10063");
            }
            WriteData writeData = this.p;
            bx4 k2 = bx4.k();
            writeData.setShowCustomFigure(k2.h("key_write_virtual_image_enable" + TbadkCoreApplication.getCurrentAccount(), true));
            r0();
        }
    }

    public final void t0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            this.K.I();
            k29.e(this.p);
            this.e.x();
            c0();
            if ("topic_detail".equals(this.p.getFrom())) {
                this.e.setResult(-1);
            } else {
                this.e.setResult(100);
            }
            this.e.finish();
        }
    }

    public void u0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.K.d();
        }
    }

    @Override // com.baidu.tieba.l59, com.baidu.tieba.f49
    public void x(int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, iArr) == null) {
            super.x(iArr);
            if (iArr == null || iArr.length == 0) {
                return;
            }
            this.g.b(iArr);
        }
    }
}
