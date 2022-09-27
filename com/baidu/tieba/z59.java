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
/* loaded from: classes6.dex */
public class z59 extends a69 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final x59 C;
    @Nullable
    public j49 D;
    @Nullable
    public z39 E;
    @Nullable
    public i49 F;
    @Nullable
    public l49 G;
    @Nullable
    public m49 H;
    @Nullable
    public y39 I;
    @NonNull
    public t59 J;
    @NonNull
    public ep8 K;
    public final n59 L;
    public final n59 M;
    public final n59 N;
    public final n59 O;
    public final n59 P;
    public final n59 Q;
    public final n59 R;
    public final n59 S;
    public final n59 T;
    public final n59 U;

    /* loaded from: classes6.dex */
    public class a implements n59 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z59 a;

        public a(z59 z59Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z59Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z59Var;
        }

        @Override // com.baidu.tieba.n59
        public boolean a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                if (11 == this.a.p.getType() || 12 == this.a.p.getType() || 13 == this.a.p.getType()) {
                    return false;
                }
                j49 j49Var = this.a.D;
                return j49Var == null || !j49Var.L();
            }
            return invokeI.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements n59 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z59 a;

        public b(z59 z59Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z59Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z59Var;
        }

        @Override // com.baidu.tieba.n59
        public boolean a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                j49 j49Var = this.a.D;
                return j49Var == null || !j49Var.L();
            }
            return invokeI.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z59 a;

        public c(z59 z59Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z59Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z59Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                z59 z59Var = this.a;
                z59Var.a.showToast(z59Var.p.getDisableAudioMessage());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z59 a;

        public d(z59 z59Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z59Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z59Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                v39.b(1);
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.a.showToast((int) R.string.obfuscated_res_0x7f0f0c59);
                } else if (!ki5.a()) {
                    for (s49<?> s49Var : this.a.o) {
                        if (!s49Var.n()) {
                            return;
                        }
                    }
                    j49 j49Var = this.a.D;
                    EditText o = j49Var != null ? j49Var.o() : null;
                    z39 z39Var = this.a.E;
                    if (this.a.s.b(o, z39Var != null ? z39Var.o() : null)) {
                        z59 z59Var = this.a;
                        z59Var.a.showToast(z59Var.s.e());
                        return;
                    }
                    this.a.p(true);
                    this.a.C();
                    this.a.s0();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements n59 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z59 a;

        public e(z59 z59Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z59Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z59Var;
        }

        @Override // com.baidu.tieba.n59
        public boolean a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                j49 j49Var = this.a.D;
                return (j49Var == null || !j49Var.L()) && ListUtils.getCount(this.a.C.f().getChosedFiles()) < this.a.C.f().getMaxImagesAllowed();
            }
            return invokeI.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class f implements n59 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z59 a;

        public f(z59 z59Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z59Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z59Var;
        }

        @Override // com.baidu.tieba.n59
        public boolean a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                j49 j49Var = this.a.D;
                return j49Var == null || !j49Var.L();
            }
            return invokeI.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class g implements n59 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z59 a;

        public g(z59 z59Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z59Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z59Var;
        }

        @Override // com.baidu.tieba.n59
        public boolean a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                j49 j49Var = this.a.D;
                return j49Var == null || !j49Var.L();
            }
            return invokeI.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class h implements n59 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z59 a;

        public h(z59 z59Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z59Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z59Var;
        }

        @Override // com.baidu.tieba.n59
        public boolean a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                j49 j49Var = this.a.D;
                if ((j49Var != null && j49Var.L()) || 13 == this.a.p.getType() || 11 == this.a.p.getType()) {
                    return false;
                }
                l49 l49Var = this.a.G;
                return (l49Var == null || l49Var.v() == null || this.a.G.v().a == null) && ListUtils.getCount(this.a.C.f().getChosedFiles()) <= 0;
            }
            return invokeI.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class i implements n59 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z59 a;

        public i(z59 z59Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z59Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z59Var;
        }

        @Override // com.baidu.tieba.n59
        public boolean a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                j49 j49Var = this.a.D;
                if ((j49Var == null || !j49Var.L()) && 11 != this.a.p.getType()) {
                    m49 m49Var = this.a.H;
                    if (m49Var == null || !m49Var.r()) {
                        z39 z39Var = this.a.E;
                        return z39Var == null || z39Var.T() == 0;
                    }
                    return false;
                }
                return false;
            }
            return invokeI.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class j implements n59 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z59 a;

        public j(z59 z59Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z59Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z59Var;
        }

        @Override // com.baidu.tieba.n59
        public boolean a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                j49 j49Var = this.a.D;
                if ((j49Var == null || !j49Var.L()) && 11 != this.a.p.getType()) {
                    return ListUtils.isEmpty(this.a.p.getItemDatas());
                }
                return false;
            }
            return invokeI.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class k implements n59 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z59 a;

        public k(z59 z59Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z59Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z59Var;
        }

        @Override // com.baidu.tieba.n59
        public boolean a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                j49 j49Var = this.a.D;
                if ((j49Var == null || !j49Var.L()) && 11 != this.a.p.getType()) {
                    return ListUtils.isEmpty(this.a.p.getItemDatas());
                }
                return false;
            }
            return invokeI.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class l implements n59 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z59 a;

        public l(z59 z59Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z59Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z59Var;
        }

        @Override // com.baidu.tieba.n59
        public boolean a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                if (11 == this.a.p.getType()) {
                    return false;
                }
                j49 j49Var = this.a.D;
                if (j49Var == null || !j49Var.L()) {
                    return this.a.p.isVoiceEnable();
                }
                return false;
            }
            return invokeI.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z59(@NonNull TbPageContext<?> tbPageContext, @NonNull NavigationBar navigationBar, @NonNull LinearLayout linearLayout, @NonNull EditorTools editorTools, @NonNull r49 r49Var, boolean z) {
        super(tbPageContext, navigationBar, linearLayout, editorTools, r49Var, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, navigationBar, linearLayout, editorTools, r49Var, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (NavigationBar) objArr2[1], (LinearLayout) objArr2[2], (EditorTools) objArr2[3], (r49) objArr2[4], ((Boolean) objArr2[5]).booleanValue());
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
        this.C = new x59(this.a);
        this.J = new t59(this.a, this);
        this.K = ep8.k();
    }

    @Override // com.baidu.tieba.a69
    public void L(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            super.L(bundle);
            this.C.e(this, this.p);
            z39 z39Var = this.E;
            if (z39Var == null || !(z39Var.o() instanceof SpanGroupEditText)) {
                return;
            }
            this.K.G(((SpanGroupEditText) this.E.o()).getSpanGroupManager());
        }
    }

    @Override // com.baidu.tieba.a69
    public void O(@NonNull EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, editorTools) == null) {
            n0();
            q0();
        }
    }

    @Override // com.baidu.tieba.a69
    public void P(@NonNull NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, navigationBar) == null) {
            super.P(navigationBar);
            this.l.setOnClickListener(new d(this));
        }
    }

    @Override // com.baidu.tieba.a69
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

    @Override // com.baidu.tieba.a69
    public m59 V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? new k59(this.a, this) : (m59) invokeV.objValue;
    }

    @Override // com.baidu.tieba.a69
    public void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (TextUtils.isEmpty(this.p.getTopicId())) {
                nm8.k(this.p.getForumId(), this);
            } else {
                nm8.r(this.p.getTopicId(), this);
            }
        }
    }

    @Override // com.baidu.tieba.a69
    public void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.c0();
            if (13 == this.p.getType() || 14 == this.p.getType() || 12 == this.p.getType()) {
                return;
            }
            if (TextUtils.isEmpty(this.p.getTopicId())) {
                nm8.t(this.p.getForumId(), this.p);
            } else {
                nm8.B(this.p.getTopicId(), this.p);
            }
        }
    }

    @Override // com.baidu.tieba.a69
    public boolean e0() {
        InterceptResult invokeV;
        TextView textView;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? !this.p.isSaveDraft() || (textView = this.l) == null || (!textView.isEnabled() && ListUtils.isEmpty(this.p.getItemDatas())) : invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.a69, com.baidu.tieba.u49
    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (super.h()) {
                return true;
            }
            j49 j49Var = this.D;
            if (j49Var != null && j49Var.r()) {
                d0(true);
                return true;
            }
            z39 z39Var = this.E;
            if (z39Var != null && z39Var.r()) {
                d0(true);
                return true;
            }
            i49 i49Var = this.F;
            if (i49Var != null && i49Var.r()) {
                d0(true);
                return true;
            } else if (this.C.f().getChosedFiles() != null && this.C.f().size() > 0) {
                d0(true);
                return true;
            } else {
                l49 l49Var = this.G;
                if (l49Var != null && l49Var.r()) {
                    d0(true);
                    return true;
                }
                m49 m49Var = this.H;
                if (m49Var != null && m49Var.r()) {
                    d0(true);
                    return true;
                }
                d0(false);
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.a69, com.baidu.tieba.u49
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.i();
            if (TextUtils.isEmpty(this.p.getTopicId())) {
                nm8.u(this.p.getForumId(), this.p, true);
            } else {
                nm8.B(this.p.getTopicId(), null);
            }
        }
    }

    @Override // com.baidu.tieba.a69, com.baidu.tieba.nm8.g
    public void k(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, writeData) == null) || WriteActivityConfig.FROM_FORUM_SHARE.equals(this.p.getFrom())) {
            return;
        }
        y39 y39Var = this.I;
        if (y39Var == null || !y39Var.r()) {
            if (!this.q || this.C.f().size() <= 0) {
                super.k(writeData);
            }
        }
    }

    public boolean l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            for (s49<?> s49Var : this.o) {
                if (s49Var.r()) {
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.a69, com.baidu.tieba.u49
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            j49 j49Var = this.D;
            this.J.f((j49Var == null || !j49Var.L()) ? "from_content" : "from_title");
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

    @Override // com.baidu.tieba.a69, com.baidu.tieba.u49
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            super.onChangeSkinType(i2);
            m39 m39Var = this.s;
            j49 j49Var = this.D;
            EditText o = j49Var == null ? null : j49Var.o();
            z39 z39Var = this.E;
            m39Var.l(o, z39Var != null ? z39Var.o() : null);
        }
    }

    @Override // com.baidu.tieba.a69, com.baidu.tieba.u49
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onDestroy();
            this.K.t();
        }
    }

    @Override // com.baidu.tieba.a69, com.baidu.tieba.u49
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, intent) == null) {
            super.onNewIntent(intent);
            this.C.m(intent);
        }
    }

    @Override // com.baidu.tieba.a69, com.baidu.tieba.u49
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

    @Override // com.baidu.tieba.a69, com.baidu.tieba.o49
    public void q(@NonNull t49 t49Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048597, this, t49Var, z) == null) {
            super.q(t49Var, z);
        }
    }

    public final void q0() {
        o55 m;
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
            for (s49<?> s49Var : this.o) {
                s49Var.b(this.p);
            }
            this.p.setVcode(null);
            this.K.A(this.C.f().size() > 0);
            this.K.H(this.p);
            if (!this.K.e()) {
                this.a.showToast((int) R.string.obfuscated_res_0x7f0f15f3);
            } else if (!BdNetTypeUtil.isNetWorkAvailable()) {
                this.a.showToast((int) R.string.obfuscated_res_0x7f0f0c59);
            } else if (g48.a().b() == 0 && this.p.isShowCustomFigure()) {
                this.e.A();
            } else {
                t0();
            }
        }
    }

    @Override // com.baidu.tieba.u49
    public void s() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && this.p.isShowCustomFigure()) {
            this.p.setShowCustomFigure(false);
            ox4 k2 = ox4.k();
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
            this.d.A(new h55(54, 15, null));
            this.d.A(new h55(65, 15, null));
            if (this.p.getVideoInfo() != null) {
                TiebaStatic.log("c10063");
            }
            WriteData writeData = this.p;
            ox4 k2 = ox4.k();
            writeData.setShowCustomFigure(k2.h("key_write_virtual_image_enable" + TbadkCoreApplication.getCurrentAccount(), true));
            r0();
        }
    }

    public final void t0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            this.K.I();
            z29.e(this.p);
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

    @Override // com.baidu.tieba.a69, com.baidu.tieba.u49
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
