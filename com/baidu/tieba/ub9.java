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
import com.baidu.tieba.g99;
import com.baidu.tieba.i99;
import com.baidu.tieba.person.ProfileVirtualImageInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.List;
/* loaded from: classes6.dex */
public class ub9 extends vb9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final sb9 C;
    @Nullable
    public x99 D;
    @Nullable
    public m99 E;
    @Nullable
    public w99 F;
    @Nullable
    public z99 G;
    @Nullable
    public aa9 H;
    @Nullable
    public l99 I;
    @NonNull
    public ob9 J;
    @NonNull
    public gu8 K;
    public final ib9 L;
    public final ib9 M;
    public final ib9 N;
    public final ib9 O;
    public final ib9 P;
    public final ib9 Q;
    public final ib9 R;
    public final ib9 S;
    public final ib9 T;
    public final ib9 U;

    @Override // com.baidu.tieba.vb9
    public void M(@NonNull List<ha9<?>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public static class m implements g99.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<ub9> a;

        /* loaded from: classes6.dex */
        public class a implements i99.f {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ub9 a;

            public a(m mVar, ub9 ub9Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {mVar, ub9Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = ub9Var;
            }

            @Override // com.baidu.tieba.i99.f
            public void a(boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                    this.a.t0(z);
                }
            }
        }

        public m(ub9 ub9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ub9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(ub9Var);
        }

        @Override // com.baidu.tieba.g99.b
        public void a(boolean z) {
            ub9 ub9Var;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeZ(1048576, this, z) != null) || (ub9Var = this.a.get()) == null) {
                return;
            }
            h99.c(ub9Var.a.getPageActivity());
            if (h99.f()) {
                return;
            }
            if (z) {
                new i99(ub9Var.a.getPageActivity(), new a(this, ub9Var)).j();
            } else {
                ub9Var.t0(false);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a implements ib9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ub9 a;

        public a(ub9 ub9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ub9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ub9Var;
        }

        @Override // com.baidu.tieba.ib9
        public boolean a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                if (11 == this.a.p.getType() || 12 == this.a.p.getType() || 13 == this.a.p.getType()) {
                    return false;
                }
                x99 x99Var = this.a.D;
                if (x99Var != null && x99Var.N()) {
                    return false;
                }
                return true;
            }
            return invokeI.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements ib9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ub9 a;

        public b(ub9 ub9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ub9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ub9Var;
        }

        @Override // com.baidu.tieba.ib9
        public boolean a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                x99 x99Var = this.a.D;
                if (x99Var != null && x99Var.N()) {
                    return false;
                }
                return true;
            }
            return invokeI.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ub9 a;

        public c(ub9 ub9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ub9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ub9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                ub9 ub9Var = this.a;
                ub9Var.a.showToast(ub9Var.p.getDisableAudioMessage());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ub9 a;

        public d(ub9 ub9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ub9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ub9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            EditText editText;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                f99.b(1);
                f99.c(this.a.p);
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.a.showToast((int) R.string.obfuscated_res_0x7f0f0cb8);
                } else if (!qk5.a()) {
                    for (ha9<?> ha9Var : this.a.o) {
                        if (!ha9Var.o()) {
                            return;
                        }
                    }
                    x99 x99Var = this.a.D;
                    EditText editText2 = null;
                    if (x99Var != null) {
                        editText = x99Var.p();
                    } else {
                        editText = null;
                    }
                    m99 m99Var = this.a.E;
                    if (m99Var != null) {
                        editText2 = m99Var.p();
                    }
                    if (this.a.s.b(editText, editText2)) {
                        ub9 ub9Var = this.a;
                        ub9Var.a.showToast(ub9Var.s.e());
                        return;
                    }
                    this.a.u0();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements ib9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ub9 a;

        public e(ub9 ub9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ub9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ub9Var;
        }

        @Override // com.baidu.tieba.ib9
        public boolean a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                x99 x99Var = this.a.D;
                if ((x99Var != null && x99Var.N()) || ListUtils.getCount(this.a.C.g().getChosedFiles()) >= this.a.C.g().getMaxImagesAllowed()) {
                    return false;
                }
                return true;
            }
            return invokeI.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class f implements ib9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ub9 a;

        public f(ub9 ub9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ub9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ub9Var;
        }

        @Override // com.baidu.tieba.ib9
        public boolean a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                x99 x99Var = this.a.D;
                if (x99Var != null && x99Var.N()) {
                    return false;
                }
                return true;
            }
            return invokeI.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class g implements ib9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ub9 a;

        public g(ub9 ub9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ub9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ub9Var;
        }

        @Override // com.baidu.tieba.ib9
        public boolean a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                x99 x99Var = this.a.D;
                if (x99Var != null && x99Var.N()) {
                    return false;
                }
                return true;
            }
            return invokeI.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class h implements ib9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ub9 a;

        public h(ub9 ub9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ub9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ub9Var;
        }

        @Override // com.baidu.tieba.ib9
        public boolean a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                x99 x99Var = this.a.D;
                if ((x99Var != null && x99Var.N()) || 13 == this.a.p.getType() || 11 == this.a.p.getType()) {
                    return false;
                }
                z99 z99Var = this.a.G;
                if ((z99Var != null && z99Var.x() != null && this.a.G.x().a != null) || ListUtils.getCount(this.a.C.g().getChosedFiles()) > 0) {
                    return false;
                }
                return true;
            }
            return invokeI.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class i implements ib9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ub9 a;

        public i(ub9 ub9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ub9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ub9Var;
        }

        @Override // com.baidu.tieba.ib9
        public boolean a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                x99 x99Var = this.a.D;
                if ((x99Var != null && x99Var.N()) || 11 == this.a.p.getType()) {
                    return false;
                }
                aa9 aa9Var = this.a.H;
                if (aa9Var != null && aa9Var.t()) {
                    return false;
                }
                m99 m99Var = this.a.E;
                if (m99Var != null && m99Var.V() != 0) {
                    return false;
                }
                return true;
            }
            return invokeI.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class j implements ib9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ub9 a;

        public j(ub9 ub9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ub9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ub9Var;
        }

        @Override // com.baidu.tieba.ib9
        public boolean a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                x99 x99Var = this.a.D;
                if ((x99Var != null && x99Var.N()) || 11 == this.a.p.getType()) {
                    return false;
                }
                return ListUtils.isEmpty(this.a.p.getItemDatas());
            }
            return invokeI.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class k implements ib9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ub9 a;

        public k(ub9 ub9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ub9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ub9Var;
        }

        @Override // com.baidu.tieba.ib9
        public boolean a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                x99 x99Var = this.a.D;
                if ((x99Var != null && x99Var.N()) || 11 == this.a.p.getType()) {
                    return false;
                }
                return ListUtils.isEmpty(this.a.p.getItemDatas());
            }
            return invokeI.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class l implements ib9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ub9 a;

        public l(ub9 ub9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ub9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ub9Var;
        }

        @Override // com.baidu.tieba.ib9
        public boolean a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                if (11 == this.a.p.getType()) {
                    return false;
                }
                x99 x99Var = this.a.D;
                if (x99Var != null && x99Var.N()) {
                    return false;
                }
                return this.a.p.isVoiceEnable();
            }
            return invokeI.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ub9(@NonNull TbPageContext<?> tbPageContext, @NonNull NavigationBar navigationBar, @NonNull LinearLayout linearLayout, @NonNull EditorTools editorTools, @NonNull ga9 ga9Var, boolean z) {
        super(tbPageContext, navigationBar, linearLayout, editorTools, ga9Var, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, navigationBar, linearLayout, editorTools, ga9Var, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (NavigationBar) objArr2[1], (LinearLayout) objArr2[2], (EditorTools) objArr2[3], (ga9) objArr2[4], ((Boolean) objArr2[5]).booleanValue());
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
        this.C = new sb9(this.a);
        this.J = new ob9(this.a, this);
        this.K = gu8.k();
    }

    public void p0(int i2, int i3) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeII(1048597, this, i2, i3) != null) || (textView = this.i) == null) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView.getLayoutParams();
        layoutParams.rightMargin = i3;
        layoutParams.leftMargin = i2;
        this.i.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tieba.vb9, com.baidu.tieba.da9
    public void q(@NonNull ia9 ia9Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048598, this, ia9Var, z) == null) {
            super.q(ia9Var, z);
        }
    }

    @Override // com.baidu.tieba.vb9
    public void L(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            super.L(bundle);
            this.C.e(this, this.p);
            this.C.f(this, this.p);
        }
    }

    @Override // com.baidu.tieba.vb9
    public void O(@NonNull EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, editorTools) == null) {
            o0();
            s0();
        }
    }

    @Override // com.baidu.tieba.vb9
    public void P(@NonNull NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, navigationBar) == null) {
            super.P(navigationBar);
            this.l.setOnClickListener(new d(this));
        }
    }

    public void n0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_CHANGE_RICH_TEXT_MODE);
            statisticItem.param("obj_type", i2);
            TiebaStatic.log(statisticItem);
            if (i2 == 0) {
                TiebaStatic.log(CommonStatisticKey.KEY_LIMIT_MODE_CHANGE_TOAST);
            }
        }
    }

    @Override // com.baidu.tieba.vb9, com.baidu.tieba.ja9
    public void onChangeSkinType(int i2) {
        EditText p;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            super.onChangeSkinType(i2);
            w89 w89Var = this.s;
            x99 x99Var = this.D;
            EditText editText = null;
            if (x99Var == null) {
                p = null;
            } else {
                p = x99Var.p();
            }
            m99 m99Var = this.E;
            if (m99Var != null) {
                editText = m99Var.p();
            }
            w89Var.l(p, editText);
        }
    }

    @Override // com.baidu.tieba.vb9, com.baidu.tieba.ja9
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, intent) == null) {
            super.onNewIntent(intent);
            this.C.n(intent);
        }
    }

    @Override // com.baidu.tieba.vb9, com.baidu.tieba.ja9
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            if (bundle == null) {
                return;
            }
            bundle.putString(WriteActivityConfig.HOT_TOPIC_ID, this.p.getTopicId());
            bundle.putInt(WriteActivityConfig.KEY_STATISTIS_FROM, this.p.getStatisticFrom());
        }
    }

    @Override // com.baidu.tieba.vb9, com.baidu.tieba.ja9
    public void x(int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, iArr) == null) {
            super.x(iArr);
            if (iArr != null && iArr.length != 0) {
                this.g.b(iArr);
            }
        }
    }

    @Override // com.baidu.tieba.vb9
    public void U(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            TbPageContext<?> tbPageContext = this.a;
            if (tbPageContext instanceof TbPageContextSupport) {
                this.K.p((TbPageContextSupport) tbPageContext);
            }
            super.U(bundle);
            if (this.a.getPageActivity() == null) {
                return;
            }
            this.C.h(bundle, this.a.getPageActivity().getIntent(), this.p);
        }
    }

    @Override // com.baidu.tieba.vb9, com.baidu.tieba.or8.g
    public void a(WriteData writeData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, writeData) != null) || WriteActivityConfig.FROM_FORUM_SHARE.equals(this.p.getFrom())) {
            return;
        }
        l99 l99Var = this.I;
        if (l99Var != null && l99Var.t()) {
            return;
        }
        if (this.q && this.C.g().size() > 0) {
            return;
        }
        super.a(writeData);
    }

    @Override // com.baidu.tieba.vb9
    public hb9 V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return new fb9(this.a, this);
        }
        return (hb9) invokeV.objValue;
    }

    @Override // com.baidu.tieba.vb9
    public void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (TextUtils.isEmpty(this.p.getTopicId())) {
                or8.k(this.p.getForumId(), this);
            } else {
                or8.r(this.p.getTopicId(), this);
            }
        }
    }

    @Override // com.baidu.tieba.vb9, com.baidu.tieba.ja9
    public void m() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            x99 x99Var = this.D;
            if (x99Var != null && x99Var.N()) {
                str = "from_title";
            } else {
                str = "from_content";
            }
            this.J.f(str);
            this.J.g(true);
            super.m();
        }
    }

    public boolean m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            for (ha9<?> ha9Var : this.o) {
                if (ha9Var.t()) {
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.vb9, com.baidu.tieba.ja9
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onDestroy();
            this.K.t(this.a);
        }
    }

    public final void s0() {
        t65 n;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && (n = this.d.n(6)) != null && !TextUtils.isEmpty(this.p.getDisableAudioMessage())) {
            ((View) n).setOnClickListener(new c(this));
        }
    }

    public void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            this.K.d();
        }
    }

    @Override // com.baidu.tieba.vb9
    public void c0() {
        String forumId;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.c0();
            if (13 != this.p.getType() && 14 != this.p.getType() && 12 != this.p.getType()) {
                if (TextUtils.isEmpty(this.p.getTopicId())) {
                    if (this.p.getForumId() == null) {
                        forumId = "0";
                    } else {
                        forumId = this.p.getForumId();
                    }
                    or8.t(forumId, this.p);
                    return;
                }
                or8.B(this.p.getTopicId(), this.p);
            }
        }
    }

    @Override // com.baidu.tieba.vb9
    public boolean e0() {
        InterceptResult invokeV;
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.p.isSaveDraft() && (textView = this.l) != null && (textView.isEnabled() || !ListUtils.isEmpty(this.p.getItemDatas()))) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.vb9, com.baidu.tieba.ja9
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.j();
            if (TextUtils.isEmpty(this.p.getTopicId())) {
                or8.u(this.p.getForumId(), this.p, true);
            } else {
                or8.B(this.p.getTopicId(), null);
            }
        }
    }

    @Override // com.baidu.tieba.vb9, com.baidu.tieba.ja9
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onResume();
            this.K.u(this.a);
            m99 m99Var = this.E;
            if (m99Var != null && (m99Var.p() instanceof SpanGroupEditText)) {
                this.K.H(((SpanGroupEditText) this.E.p()).getSpanGroupManager());
            }
        }
    }

    @Override // com.baidu.tieba.ja9
    public void s() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && this.p.isShowCustomFigure()) {
            this.p.setShowCustomFigure(false);
            ry4 l2 = ry4.l();
            l2.v("key_write_virtual_image_enable" + TbadkCoreApplication.getCurrentAccount(), false);
        }
    }

    public final void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            this.K.J();
            j89.f(this.p);
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

    @Override // com.baidu.tieba.vb9, com.baidu.tieba.ja9
    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (super.i()) {
                return true;
            }
            x99 x99Var = this.D;
            if (x99Var != null && x99Var.t()) {
                d0(true);
                return true;
            }
            m99 m99Var = this.E;
            if (m99Var != null && m99Var.t()) {
                d0(true);
                return true;
            }
            w99 w99Var = this.F;
            if (w99Var != null && w99Var.t()) {
                d0(true);
                return true;
            } else if (this.C.g().getChosedFiles() != null && this.C.g().size() > 0) {
                d0(true);
                return true;
            } else {
                z99 z99Var = this.G;
                if (z99Var != null && z99Var.t()) {
                    d0(true);
                    return true;
                }
                aa9 aa9Var = this.H;
                if (aa9Var != null && aa9Var.t()) {
                    d0(true);
                    return true;
                }
                d0(false);
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
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

    public void u0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            if ("1".equals(this.p.getCallFrom())) {
                this.p.setCanNoForum(true);
                this.p.setTransmitForumData("[]");
            } else if ("2".equals(this.p.getCallFrom())) {
                this.p.setCanNoForum(false);
            }
            this.d.B(new m65(54, 15, null));
            this.d.B(new m65(65, 15, null));
            if (this.p.getVideoInfo() != null) {
                TiebaStatic.log("c10063");
            }
            WriteData writeData = this.p;
            ry4 l2 = ry4.l();
            writeData.setShowCustomFigure(l2.i("key_write_virtual_image_enable" + TbadkCoreApplication.getCurrentAccount(), true));
            r0();
        }
    }

    public void q0(@DrawableRes int i2, @DimenRes int i3, @DimenRes int i4, @DimenRes int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048599, this, i2, i3, i4, i5) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.k.getLayoutParams();
            layoutParams.width = yi.g(this.a.getPageActivity(), i3);
            layoutParams.height = yi.g(this.a.getPageActivity(), i4);
            layoutParams.topMargin = yi.g(this.a.getPageActivity(), i5);
            this.k.setLayoutParams(layoutParams);
            this.k.setImageDrawable(WebPManager.getPureDrawable(i2, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_DISABLE));
            this.k.setVisibility(0);
        }
    }

    public final void r0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            w0();
            boolean z = false;
            for (ha9<?> ha9Var : this.o) {
                ha9Var.c(this.p);
                if (((ha9Var instanceof z99) || (ha9Var instanceof aa9) || (ha9Var instanceof o99) || (ha9Var instanceof j99) || (ha9Var instanceof l99)) && ha9Var.t()) {
                    z = true;
                }
                if ((ha9Var instanceof m99) && ((m99) ha9Var).X()) {
                    z = true;
                }
            }
            if (!this.p.isQuestionThread() && h99.d() && !z && h99.e()) {
                if (h99.g()) {
                    h99.h(this.a.getPageActivity());
                }
                g99.c().g(this.p.getTitle(), this.p.getContent(), new m(this));
                if (h99.f()) {
                    t0(false);
                    return;
                }
                return;
            }
            t0(false);
        }
    }

    public final void t0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            boolean z2 = true;
            p(true);
            C();
            this.p.setVcode(null);
            gu8 gu8Var = this.K;
            if (this.C.g().size() <= 0) {
                z2 = false;
            }
            gu8Var.B(z2);
            this.K.I(this.p);
            if (!this.K.e()) {
                this.a.showToast((int) R.string.write_img_limit);
            } else if (!BdNetTypeUtil.isNetWorkAvailable()) {
                this.a.showToast((int) R.string.obfuscated_res_0x7f0f0cb8);
            } else if (ProfileVirtualImageInfo.getInstance().getIsSetVirtualImage() == 0 && this.p.isShowCustomFigure()) {
                this.e.A();
            } else {
                if (z) {
                    this.p.setQuestionThread(z);
                    this.p.setType(14);
                }
                v0();
            }
        }
    }
}
