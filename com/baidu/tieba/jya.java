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
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.person.ProfileVirtualImageInfo;
import com.baidu.tieba.vva;
import com.baidu.tieba.xva;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.List;
/* loaded from: classes6.dex */
public class jya extends kya {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final hya C;
    @Nullable
    public mwa D;
    @Nullable
    public bwa E;
    @Nullable
    public lwa F;
    @Nullable
    public owa G;
    @Nullable
    public pwa H;
    @Nullable
    public awa I;
    @NonNull
    public dya J;
    @NonNull
    public uea K;
    public final xxa L;
    public final xxa M;
    public final xxa N;
    public final xxa O;
    public final xxa P;
    public final xxa Q;
    public final xxa R;
    public final xxa S;

    /* renamed from: T  reason: collision with root package name */
    public final xxa f1134T;
    public final xxa U;

    @Override // com.baidu.tieba.kya
    public void M(@NonNull List<wwa<?>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public static class m implements vva.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<jya> a;

        /* loaded from: classes6.dex */
        public class a implements xva.f {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ jya a;

            public a(m mVar, jya jyaVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {mVar, jyaVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = jyaVar;
            }

            @Override // com.baidu.tieba.xva.f
            public void a(boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                    this.a.v0(z);
                }
            }
        }

        public m(jya jyaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jyaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(jyaVar);
        }

        @Override // com.baidu.tieba.vva.b
        public void a(boolean z) {
            jya jyaVar;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeZ(1048576, this, z) != null) || (jyaVar = this.a.get()) == null) {
                return;
            }
            wva.c(jyaVar.a.getPageActivity());
            if (wva.f()) {
                return;
            }
            if (z) {
                new xva(jyaVar.a.getPageActivity(), new a(this, jyaVar)).j();
            } else {
                jyaVar.v0(false);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a implements xxa {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jya a;

        public a(jya jyaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jyaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jyaVar;
        }

        @Override // com.baidu.tieba.xxa
        public boolean a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                if (11 == this.a.p.getType() || 12 == this.a.p.getType() || 13 == this.a.p.getType()) {
                    return false;
                }
                mwa mwaVar = this.a.D;
                if (mwaVar != null && mwaVar.N()) {
                    return false;
                }
                return true;
            }
            return invokeI.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements xxa {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jya a;

        public b(jya jyaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jyaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jyaVar;
        }

        @Override // com.baidu.tieba.xxa
        public boolean a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                mwa mwaVar = this.a.D;
                if (mwaVar != null && mwaVar.N()) {
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
        public final /* synthetic */ jya a;

        public c(jya jyaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jyaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jyaVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                jya jyaVar = this.a;
                jyaVar.a.showToast(jyaVar.p.getDisableAudioMessage());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jya a;

        public d(jya jyaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jyaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jyaVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            EditText editText;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                uva.b(1);
                uva.c(this.a.p);
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.a.showToast((int) R.string.obfuscated_res_0x7f0f0e1f);
                } else if (!ez5.a()) {
                    for (wwa<?> wwaVar : this.a.o) {
                        if (!wwaVar.o()) {
                            return;
                        }
                    }
                    mwa mwaVar = this.a.D;
                    EditText editText2 = null;
                    if (mwaVar != null) {
                        editText = mwaVar.p();
                    } else {
                        editText = null;
                    }
                    bwa bwaVar = this.a.E;
                    if (bwaVar != null) {
                        editText2 = bwaVar.p();
                    }
                    if (this.a.s.b(editText, editText2)) {
                        jya jyaVar = this.a;
                        jyaVar.a.showToast(jyaVar.s.e());
                        return;
                    }
                    this.a.w0();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements xxa {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jya a;

        public e(jya jyaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jyaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jyaVar;
        }

        @Override // com.baidu.tieba.xxa
        public boolean a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                mwa mwaVar = this.a.D;
                if ((mwaVar != null && mwaVar.N()) || ListUtils.getCount(this.a.C.g().getChosedFiles()) >= this.a.C.g().getMaxImagesAllowed()) {
                    return false;
                }
                return true;
            }
            return invokeI.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class f implements xxa {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jya a;

        public f(jya jyaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jyaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jyaVar;
        }

        @Override // com.baidu.tieba.xxa
        public boolean a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                mwa mwaVar = this.a.D;
                if (mwaVar != null && mwaVar.N()) {
                    return false;
                }
                return true;
            }
            return invokeI.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class g implements xxa {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jya a;

        public g(jya jyaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jyaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jyaVar;
        }

        @Override // com.baidu.tieba.xxa
        public boolean a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                mwa mwaVar = this.a.D;
                if (mwaVar != null && mwaVar.N()) {
                    return false;
                }
                return true;
            }
            return invokeI.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class h implements xxa {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jya a;

        public h(jya jyaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jyaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jyaVar;
        }

        @Override // com.baidu.tieba.xxa
        public boolean a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                mwa mwaVar = this.a.D;
                if ((mwaVar != null && mwaVar.N()) || 13 == this.a.p.getType() || 11 == this.a.p.getType()) {
                    return false;
                }
                owa owaVar = this.a.G;
                if ((owaVar != null && owaVar.x() != null && this.a.G.x().a != null) || ListUtils.getCount(this.a.C.g().getChosedFiles()) > 0) {
                    return false;
                }
                return true;
            }
            return invokeI.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class i implements xxa {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jya a;

        public i(jya jyaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jyaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jyaVar;
        }

        @Override // com.baidu.tieba.xxa
        public boolean a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                mwa mwaVar = this.a.D;
                if ((mwaVar != null && mwaVar.N()) || 11 == this.a.p.getType()) {
                    return false;
                }
                pwa pwaVar = this.a.H;
                if (pwaVar != null && pwaVar.t()) {
                    return false;
                }
                bwa bwaVar = this.a.E;
                if (bwaVar != null && bwaVar.W() != 0) {
                    return false;
                }
                return true;
            }
            return invokeI.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class j implements xxa {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jya a;

        public j(jya jyaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jyaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jyaVar;
        }

        @Override // com.baidu.tieba.xxa
        public boolean a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                mwa mwaVar = this.a.D;
                if ((mwaVar != null && mwaVar.N()) || 11 == this.a.p.getType()) {
                    return false;
                }
                return ListUtils.isEmpty(this.a.p.getItemDatas());
            }
            return invokeI.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class k implements xxa {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jya a;

        public k(jya jyaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jyaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jyaVar;
        }

        @Override // com.baidu.tieba.xxa
        public boolean a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                mwa mwaVar = this.a.D;
                if ((mwaVar != null && mwaVar.N()) || 11 == this.a.p.getType()) {
                    return false;
                }
                return ListUtils.isEmpty(this.a.p.getItemDatas());
            }
            return invokeI.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class l implements xxa {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jya a;

        public l(jya jyaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jyaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jyaVar;
        }

        @Override // com.baidu.tieba.xxa
        public boolean a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                if (11 == this.a.p.getType()) {
                    return false;
                }
                mwa mwaVar = this.a.D;
                if (mwaVar != null && mwaVar.N()) {
                    return false;
                }
                return this.a.p.isVoiceEnable();
            }
            return invokeI.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jya(@NonNull TbPageContext<?> tbPageContext, @NonNull NavigationBar navigationBar, @NonNull LinearLayout linearLayout, @NonNull EditorTools editorTools, @NonNull vwa vwaVar, boolean z) {
        super(tbPageContext, navigationBar, linearLayout, editorTools, vwaVar, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, navigationBar, linearLayout, editorTools, vwaVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (NavigationBar) objArr2[1], (LinearLayout) objArr2[2], (EditorTools) objArr2[3], (vwa) objArr2[4], ((Boolean) objArr2[5]).booleanValue());
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
        this.f1134T = new a(this);
        this.U = new b(this);
        this.C = new hya(this.a);
        this.J = new dya(this.a, this);
        this.K = uea.k();
    }

    @Override // com.baidu.tieba.kya, com.baidu.tieba.swa
    public void q(@NonNull xwa xwaVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048596, this, xwaVar, z) == null) {
            super.q(xwaVar, z);
        }
    }

    public void r0(int i2, int i3) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeII(1048598, this, i2, i3) != null) || (textView = this.i) == null) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView.getLayoutParams();
        layoutParams.rightMargin = i3;
        layoutParams.leftMargin = i2;
        this.i.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tieba.kya
    public void L(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            super.L(bundle);
            this.C.e(this, this.p);
            this.C.f(this, this.p);
        }
    }

    @Override // com.baidu.tieba.kya
    public void O(@NonNull EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, editorTools) == null) {
            q0();
            u0();
        }
    }

    @Override // com.baidu.tieba.kya
    public void P(@NonNull NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, navigationBar) == null) {
            super.P(navigationBar);
            this.l.setOnClickListener(new d(this));
        }
    }

    @Override // com.baidu.tieba.kya, com.baidu.tieba.ywa
    public void onChangeSkinType(int i2) {
        EditText p;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            super.onChangeSkinType(i2);
            lva lvaVar = this.s;
            mwa mwaVar = this.D;
            EditText editText = null;
            if (mwaVar == null) {
                p = null;
            } else {
                p = mwaVar.p();
            }
            bwa bwaVar = this.E;
            if (bwaVar != null) {
                editText = bwaVar.p();
            }
            lvaVar.l(p, editText);
        }
    }

    @Override // com.baidu.tieba.kya, com.baidu.tieba.ywa
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, intent) == null) {
            super.onNewIntent(intent);
            this.C.n(intent);
        }
    }

    @Override // com.baidu.tieba.kya, com.baidu.tieba.ywa
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            if (bundle == null) {
                return;
            }
            bundle.putString(WriteActivityConfig.HOT_TOPIC_ID, this.p.getTopicId());
            bundle.putInt(WriteActivityConfig.KEY_STATISTIS_FROM, this.p.getStatisticFrom());
        }
    }

    public void p0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_CHANGE_RICH_TEXT_MODE);
            statisticItem.param("obj_type", i2);
            TiebaStatic.log(statisticItem);
            if (i2 == 0) {
                TiebaStatic.log(CommonStatisticKey.KEY_LIMIT_MODE_CHANGE_TOAST);
            }
        }
    }

    @Override // com.baidu.tieba.kya, com.baidu.tieba.ywa
    public void x(int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, iArr) == null) {
            super.x(iArr);
            if (iArr != null && iArr.length != 0) {
                this.g.b(iArr);
            }
        }
    }

    @Override // com.baidu.tieba.kya
    public void U(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            TbPageContext<?> tbPageContext = this.a;
            if (tbPageContext instanceof TbPageContextSupport) {
                this.K.m((TbPageContextSupport) tbPageContext);
            }
            super.U(bundle);
            if (this.a.getPageActivity() == null) {
                return;
            }
            this.C.h(bundle, this.a.getPageActivity().getIntent(), this.p);
        }
    }

    @Override // com.baidu.tieba.kya, com.baidu.tieba.bca.g
    public void a(WriteData writeData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, writeData) != null) || WriteActivityConfig.FROM_FORUM_SHARE.equals(this.p.getFrom())) {
            return;
        }
        awa awaVar = this.I;
        if (awaVar != null && awaVar.t()) {
            return;
        }
        if (this.q && this.C.g().size() > 0) {
            return;
        }
        super.a(writeData);
    }

    @Override // com.baidu.tieba.kya
    public wxa V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return new uxa(this.a, this);
        }
        return (wxa) invokeV.objValue;
    }

    @Override // com.baidu.tieba.kya
    public void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (TextUtils.isEmpty(this.p.getTopicId())) {
                bca.l(this.p.getForumId(), this);
            } else {
                bca.s(this.p.getTopicId(), this);
            }
        }
    }

    @Override // com.baidu.tieba.kya, com.baidu.tieba.ywa
    public void m() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            mwa mwaVar = this.D;
            if (mwaVar != null && mwaVar.N()) {
                str = "from_title";
            } else {
                str = "from_content";
            }
            this.J.f(str);
            this.J.g(true);
            super.m();
        }
    }

    public boolean o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            for (wwa<?> wwaVar : this.o) {
                if (wwaVar.t()) {
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.kya, com.baidu.tieba.ywa
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onDestroy();
            this.K.o(this.a);
        }
    }

    @Override // com.baidu.tieba.kya, com.baidu.tieba.ywa
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onResume();
            this.K.p(this.a);
        }
    }

    public final void u0() {
        hj5 o;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && (o = this.d.o(6)) != null && !TextUtils.isEmpty(this.p.getDisableAudioMessage())) {
            ((View) o).setOnClickListener(new c(this));
        }
    }

    public void y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            this.K.e();
        }
    }

    @Override // com.baidu.tieba.kya
    public void c0() {
        String forumId;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            bwa bwaVar = this.E;
            if (bwaVar != null && bwaVar.x() != null) {
                this.p.onSaveDrafDataParse(this.E.x().a());
            }
            super.c0();
            if (13 != this.p.getType() && 14 != this.p.getType() && 12 != this.p.getType()) {
                if (TextUtils.isEmpty(this.p.getTopicId())) {
                    if (this.p.getForumId() == null) {
                        forumId = "0";
                    } else {
                        forumId = this.p.getForumId();
                    }
                    bca.u(forumId, this.p);
                    return;
                }
                bca.C(this.p.getTopicId(), this.p);
            }
        }
    }

    @Override // com.baidu.tieba.kya, com.baidu.tieba.ywa
    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (super.i()) {
                return true;
            }
            mwa mwaVar = this.D;
            if (mwaVar != null && mwaVar.t()) {
                e0(true);
                return true;
            }
            bwa bwaVar = this.E;
            if (bwaVar != null && bwaVar.t()) {
                e0(true);
                return true;
            }
            lwa lwaVar = this.F;
            if (lwaVar != null && lwaVar.t()) {
                e0(true);
                return true;
            } else if (this.C.g().getChosedFiles() != null && this.C.g().size() > 0) {
                e0(true);
                return true;
            } else {
                owa owaVar = this.G;
                if (owaVar != null && owaVar.t()) {
                    e0(true);
                    return true;
                }
                pwa pwaVar = this.H;
                if (pwaVar != null && pwaVar.t()) {
                    e0(true);
                    return true;
                }
                e0(false);
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.g.c(10, this.L);
            this.g.c(5, this.M);
            this.g.c(9, this.N);
            this.g.c(34, this.O);
            this.g.c(35, this.P);
            this.g.c(33, this.Q);
            this.g.c(32, this.R);
            this.g.c(6, this.S);
            this.g.c(31, this.f1134T);
            this.g.c(2, this.U);
        }
    }

    @Override // com.baidu.tieba.kya
    public boolean f0() {
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

    @Override // com.baidu.tieba.kya, com.baidu.tieba.ywa
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.j();
            if (TextUtils.isEmpty(this.p.getTopicId())) {
                bca.v(this.p.getForumId(), this.p, true);
            } else {
                bca.C(this.p.getTopicId(), null);
            }
        }
    }

    @Override // com.baidu.tieba.ywa
    public void s() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048599, this) == null) && this.p.isShowCustomFigure()) {
            this.p.setShowCustomFigure(false);
            da5 p = da5.p();
            p.A("key_write_virtual_image_enable" + TbadkCoreApplication.getCurrentAccount(), false);
        }
    }

    public final void x0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            this.K.z();
            sua.f(this.p);
            this.e.M();
            c0();
            if ("topic_detail".equals(this.p.getFrom())) {
                this.e.setResult(-1);
            } else {
                this.e.setResult(100);
            }
            this.e.y();
        }
    }

    public void s0(@DrawableRes int i2, @DimenRes int i3, @DimenRes int i4, @DimenRes int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048600, this, i2, i3, i4, i5) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.k.getLayoutParams();
            layoutParams.width = yi.g(this.a.getPageActivity(), i3);
            layoutParams.height = yi.g(this.a.getPageActivity(), i4);
            layoutParams.topMargin = yi.g(this.a.getPageActivity(), i5);
            this.k.setLayoutParams(layoutParams);
            this.k.setImageDrawable(WebPManager.getPureDrawable(i2, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_DISABLE));
            this.k.setVisibility(0);
        }
    }

    public final void t0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            y0();
            boolean z = false;
            for (wwa<?> wwaVar : this.o) {
                wwaVar.c(this.p);
                if (((wwaVar instanceof owa) || (wwaVar instanceof pwa) || (wwaVar instanceof dwa) || (wwaVar instanceof yva) || (wwaVar instanceof awa)) && wwaVar.t()) {
                    z = true;
                }
                if ((wwaVar instanceof bwa) && ((bwa) wwaVar).Y()) {
                    z = true;
                }
            }
            if (!this.p.isQuestionThread() && wva.d() && !z && wva.e()) {
                if (wva.g()) {
                    wva.h(this.a.getPageActivity());
                }
                vva.c().g(this.p.getTitle(), this.p.getContent(), new m(this));
                if (wva.f()) {
                    v0(false);
                    return;
                }
                return;
            }
            v0(false);
        }
    }

    public void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            if ("1".equals(this.p.getCallFrom())) {
                this.p.setCanNoForum(true);
                this.p.setTransmitForumData("[]");
            } else if ("2".equals(this.p.getCallFrom())) {
                this.p.setCanNoForum(false);
            }
            this.d.D(new zi5(54, 15, null));
            this.d.D(new zi5(65, 15, null));
            if (this.p.getVideoInfo() != null) {
                TiebaStatic.log("c10063");
            }
            WriteData writeData = this.p;
            da5 p = da5.p();
            writeData.setShowCustomFigure(p.l("key_write_virtual_image_enable" + TbadkCoreApplication.getCurrentAccount(), true));
            if (cl5.a()) {
                this.p.setShowBless(da5.p().l(da5.t("key_write_add_bless_enable"), true));
            }
            t0();
        }
    }

    public final void v0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            boolean z2 = true;
            p(true);
            C();
            this.p.setVcode(null);
            uea ueaVar = this.K;
            if (this.C.g().size() <= 0) {
                z2 = false;
            }
            ueaVar.v(z2);
            this.K.y(this.p);
            if (!this.K.f()) {
                this.a.showToast((int) R.string.write_img_limit);
            } else if (!BdNetTypeUtil.isNetWorkAvailable()) {
                this.a.showToast((int) R.string.obfuscated_res_0x7f0f0e1f);
            } else if (ProfileVirtualImageInfo.getInstance().getIsSetVirtualImage() == 0 && this.p.isShowCustomFigure()) {
                this.e.Q();
            } else {
                if (z) {
                    this.p.setQuestionThread(z);
                    this.p.setType(14);
                }
                bwa bwaVar = this.E;
                if (bwaVar != null && bwaVar.x() != null) {
                    this.p.onPostDataParse(this.E.x().a());
                }
                x0();
            }
        }
    }
}
