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
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.a4b;
import com.baidu.tieba.pb.bot.BotEntranceManager;
import com.baidu.tieba.person.ProfileVirtualImageInfo;
import com.baidu.tieba.y3b;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.List;
/* loaded from: classes7.dex */
public class m6b extends n6b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final k6b C;
    @Nullable
    public p4b D;
    @Nullable
    public e4b E;
    @Nullable
    public o4b F;
    @Nullable
    public r4b G;
    @Nullable
    public s4b H;
    @Nullable
    public d4b I;
    @NonNull
    public g6b J;
    @NonNull
    public rja K;
    public final a6b L;
    public final a6b M;
    public final a6b N;
    public final a6b O;
    public final a6b P;
    public final a6b Q;
    public final a6b R;
    public final a6b S;

    /* renamed from: T  reason: collision with root package name */
    public final a6b f1131T;
    public final a6b U;

    @Override // com.baidu.tieba.n6b
    public void L(@NonNull List<z4b<?>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
        }
    }

    /* loaded from: classes7.dex */
    public static class m implements y3b.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<m6b> a;

        /* loaded from: classes7.dex */
        public class a implements a4b.f {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ m6b a;

            public a(m mVar, m6b m6bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {mVar, m6bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = m6bVar;
            }

            @Override // com.baidu.tieba.a4b.f
            public void a(boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                    this.a.u0(z);
                }
            }
        }

        public m(m6b m6bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m6bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(m6bVar);
        }

        @Override // com.baidu.tieba.y3b.b
        public void a(boolean z) {
            m6b m6bVar;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeZ(1048576, this, z) != null) || (m6bVar = this.a.get()) == null) {
                return;
            }
            z3b.c(m6bVar.a.getPageActivity());
            if (z3b.f()) {
                return;
            }
            if (z) {
                new a4b(m6bVar.a.getPageActivity(), new a(this, m6bVar)).j();
            } else {
                m6bVar.u0(false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a implements a6b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m6b a;

        public a(m6b m6bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m6bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m6bVar;
        }

        @Override // com.baidu.tieba.a6b
        public boolean a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                if (11 == this.a.p.getType() || 12 == this.a.p.getType() || 13 == this.a.p.getType()) {
                    return false;
                }
                p4b p4bVar = this.a.D;
                if (p4bVar != null && p4bVar.N()) {
                    return false;
                }
                return true;
            }
            return invokeI.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements a6b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m6b a;

        public b(m6b m6bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m6bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m6bVar;
        }

        @Override // com.baidu.tieba.a6b
        public boolean a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                p4b p4bVar = this.a.D;
                if (p4bVar != null && p4bVar.N()) {
                    return false;
                }
                return true;
            }
            return invokeI.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m6b a;

        public c(m6b m6bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m6bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m6bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                m6b m6bVar = this.a;
                m6bVar.a.showToast(m6bVar.p.getDisableAudioMessage());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m6b a;

        public d(m6b m6bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m6bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m6bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            EditText editText;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                x3b.d(this.a.a.getPageActivity(), 1);
                x3b.e(this.a.p);
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.a.showToast((int) R.string.obfuscated_res_0x7f0f0e40);
                } else if (!fy5.a()) {
                    for (z4b<?> z4bVar : this.a.o) {
                        if (!z4bVar.o()) {
                            return;
                        }
                    }
                    p4b p4bVar = this.a.D;
                    EditText editText2 = null;
                    if (p4bVar != null) {
                        editText = p4bVar.p();
                    } else {
                        editText = null;
                    }
                    e4b e4bVar = this.a.E;
                    if (e4bVar != null) {
                        editText2 = e4bVar.p();
                    }
                    if (this.a.s.b(editText, editText2)) {
                        m6b m6bVar = this.a;
                        m6bVar.a.showToast(m6bVar.s.e());
                        return;
                    }
                    this.a.v0();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements a6b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m6b a;

        public e(m6b m6bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m6bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m6bVar;
        }

        @Override // com.baidu.tieba.a6b
        public boolean a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                p4b p4bVar = this.a.D;
                if ((p4bVar != null && p4bVar.N()) || ListUtils.getCount(this.a.C.g().getChosedFiles()) >= this.a.C.g().getMaxImagesAllowed()) {
                    return false;
                }
                return true;
            }
            return invokeI.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class f implements a6b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m6b a;

        public f(m6b m6bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m6bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m6bVar;
        }

        @Override // com.baidu.tieba.a6b
        public boolean a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                p4b p4bVar = this.a.D;
                if (p4bVar != null && p4bVar.N()) {
                    return false;
                }
                return true;
            }
            return invokeI.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class g implements a6b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m6b a;

        public g(m6b m6bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m6bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m6bVar;
        }

        @Override // com.baidu.tieba.a6b
        public boolean a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                p4b p4bVar = this.a.D;
                if (p4bVar != null && p4bVar.N()) {
                    return false;
                }
                return true;
            }
            return invokeI.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class h implements a6b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m6b a;

        public h(m6b m6bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m6bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m6bVar;
        }

        @Override // com.baidu.tieba.a6b
        public boolean a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                p4b p4bVar = this.a.D;
                if ((p4bVar != null && p4bVar.N()) || 13 == this.a.p.getType() || 11 == this.a.p.getType()) {
                    return false;
                }
                r4b r4bVar = this.a.G;
                if ((r4bVar != null && r4bVar.x() != null && this.a.G.x().a != null) || ListUtils.getCount(this.a.C.g().getChosedFiles()) > 0) {
                    return false;
                }
                return true;
            }
            return invokeI.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class i implements a6b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m6b a;

        public i(m6b m6bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m6bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m6bVar;
        }

        @Override // com.baidu.tieba.a6b
        public boolean a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                p4b p4bVar = this.a.D;
                if ((p4bVar != null && p4bVar.N()) || 11 == this.a.p.getType()) {
                    return false;
                }
                s4b s4bVar = this.a.H;
                if (s4bVar != null && s4bVar.t()) {
                    return false;
                }
                e4b e4bVar = this.a.E;
                if (e4bVar != null && e4bVar.W() != 0) {
                    return false;
                }
                return true;
            }
            return invokeI.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class j implements a6b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m6b a;

        public j(m6b m6bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m6bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m6bVar;
        }

        @Override // com.baidu.tieba.a6b
        public boolean a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                p4b p4bVar = this.a.D;
                if ((p4bVar != null && p4bVar.N()) || 11 == this.a.p.getType()) {
                    return false;
                }
                return ListUtils.isEmpty(this.a.p.getItemDatas());
            }
            return invokeI.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class k implements a6b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m6b a;

        public k(m6b m6bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m6bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m6bVar;
        }

        @Override // com.baidu.tieba.a6b
        public boolean a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                p4b p4bVar = this.a.D;
                if ((p4bVar != null && p4bVar.N()) || 11 == this.a.p.getType()) {
                    return false;
                }
                return ListUtils.isEmpty(this.a.p.getItemDatas());
            }
            return invokeI.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class l implements a6b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m6b a;

        public l(m6b m6bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m6bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m6bVar;
        }

        @Override // com.baidu.tieba.a6b
        public boolean a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                if (11 == this.a.p.getType()) {
                    return false;
                }
                p4b p4bVar = this.a.D;
                if (p4bVar != null && p4bVar.N()) {
                    return false;
                }
                return this.a.p.isVoiceEnable();
            }
            return invokeI.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m6b(@NonNull TbPageContext<?> tbPageContext, @NonNull NavigationBar navigationBar, @NonNull LinearLayout linearLayout, @NonNull EditorTools editorTools, @NonNull y4b y4bVar, boolean z) {
        super(tbPageContext, navigationBar, linearLayout, editorTools, y4bVar, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, navigationBar, linearLayout, editorTools, y4bVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (NavigationBar) objArr2[1], (LinearLayout) objArr2[2], (EditorTools) objArr2[3], (y4b) objArr2[4], ((Boolean) objArr2[5]).booleanValue());
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
        this.f1131T = new a(this);
        this.U = new b(this);
        this.C = new k6b(this.a);
        this.J = new g6b(this.a, this);
        this.K = rja.k();
    }

    public void q0(int i2, int i3) {
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

    @Override // com.baidu.tieba.n6b
    public void K(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            super.K(bundle);
            this.C.e(this, this.p);
            this.C.f(this, this.p);
        }
    }

    @Override // com.baidu.tieba.n6b
    public void N(@NonNull EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, editorTools) == null) {
            p0();
            t0();
        }
    }

    @Override // com.baidu.tieba.n6b
    public void O(@NonNull NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, navigationBar) == null) {
            super.O(navigationBar);
            this.l.setOnClickListener(new d(this));
        }
    }

    public void o0(int i2) {
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

    @Override // com.baidu.tieba.n6b, com.baidu.tieba.b5b
    public void onChangeSkinType(int i2) {
        EditText p;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            super.onChangeSkinType(i2);
            o3b o3bVar = this.s;
            p4b p4bVar = this.D;
            EditText editText = null;
            if (p4bVar == null) {
                p = null;
            } else {
                p = p4bVar.p();
            }
            e4b e4bVar = this.E;
            if (e4bVar != null) {
                editText = e4bVar.p();
            }
            o3bVar.l(p, editText);
        }
    }

    @Override // com.baidu.tieba.n6b, com.baidu.tieba.b5b
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, intent) == null) {
            super.onNewIntent(intent);
            this.C.n(intent);
        }
    }

    @Override // com.baidu.tieba.n6b, com.baidu.tieba.b5b
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

    @Override // com.baidu.tieba.n6b, com.baidu.tieba.b5b
    public void x(int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, iArr) == null) {
            super.x(iArr);
            if (iArr != null && iArr.length != 0) {
                this.g.b(iArr);
            }
        }
    }

    @Override // com.baidu.tieba.n6b
    public void T(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            TbPageContext<?> tbPageContext = this.a;
            if (tbPageContext instanceof TbPageContextSupport) {
                this.K.m((TbPageContextSupport) tbPageContext);
            }
            super.T(bundle);
            if (this.a.getPageActivity() == null) {
                return;
            }
            this.C.h(bundle, this.a.getPageActivity().getIntent(), this.p);
        }
    }

    @Override // com.baidu.tieba.n6b, com.baidu.tieba.wga.h
    public void c(WriteData writeData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, writeData) != null) || WriteActivityConfig.FROM_FORUM_SHARE.equals(this.p.getFrom())) {
            return;
        }
        d4b d4bVar = this.I;
        if (d4bVar != null && d4bVar.t()) {
            return;
        }
        if (this.q && this.C.g().size() > 0) {
            return;
        }
        super.c(writeData);
    }

    @Override // com.baidu.tieba.n6b
    public z5b V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return new x5b(this.a, this);
        }
        return (z5b) invokeV.objValue;
    }

    @Override // com.baidu.tieba.n6b
    public void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (TextUtils.isEmpty(this.p.getTopicId())) {
                wga.n(this.p.getForumId(), this);
            } else {
                wga.u(this.p.getTopicId(), this);
            }
        }
    }

    @Override // com.baidu.tieba.n6b, com.baidu.tieba.b5b
    public void m() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            p4b p4bVar = this.D;
            if (p4bVar != null && p4bVar.N()) {
                str = "from_title";
            } else {
                str = "from_content";
            }
            this.J.f(str);
            this.J.g(true);
            super.m();
        }
    }

    public boolean n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            for (z4b<?> z4bVar : this.o) {
                if (z4bVar.t()) {
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.n6b, com.baidu.tieba.b5b
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onDestroy();
            this.K.o(this.a);
        }
    }

    @Override // com.baidu.tieba.n6b, com.baidu.tieba.b5b
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.onResume();
            this.K.p(this.a);
        }
    }

    public final void t0() {
        aj5 o;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && (o = this.d.o(6)) != null && !TextUtils.isEmpty(this.p.getDisableAudioMessage())) {
            ((View) o).setOnClickListener(new c(this));
        }
    }

    public void x0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            this.K.e();
        }
    }

    @Override // com.baidu.tieba.n6b, com.baidu.tieba.b5b
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.b();
            if (TextUtils.isEmpty(this.p.getTopicId())) {
                wga.y(this.p.getForumId(), this.p, true);
            } else {
                wga.F(this.p.getTopicId(), null);
            }
        }
    }

    @Override // com.baidu.tieba.n6b
    public boolean e0() {
        InterceptResult invokeV;
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.p.isSaveDraft() && (textView = this.l) != null && (textView.isEnabled() || !ListUtils.isEmpty(this.p.getItemDatas()))) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.b5b
    public void s() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048599, this) == null) && this.p.isShowCustomFigure()) {
            this.p.setShowCustomFigure(false);
            SharedPrefHelper sharedPrefHelper = SharedPrefHelper.getInstance();
            sharedPrefHelper.putBoolean("key_write_virtual_image_enable" + TbadkCoreApplication.getCurrentAccount(), false);
        }
    }

    public final void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            this.K.z();
            r0b.f(this.p);
            this.e.I();
            c0();
            if ("topic_detail".equals(this.p.getFrom())) {
                this.e.setResult(-1);
            } else {
                this.e.setResult(100);
            }
            this.e.x();
        }
    }

    @Override // com.baidu.tieba.n6b
    public void c0() {
        String forumId;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            e4b e4bVar = this.E;
            if (e4bVar != null && e4bVar.x() != null) {
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
                    wga.x(forumId, this.p);
                    return;
                }
                wga.F(this.p.getTopicId(), this.p);
            }
        }
    }

    @Override // com.baidu.tieba.n6b, com.baidu.tieba.b5b
    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (super.j()) {
                return true;
            }
            p4b p4bVar = this.D;
            if (p4bVar != null && p4bVar.t()) {
                d0(true);
                return true;
            }
            e4b e4bVar = this.E;
            if (e4bVar != null && e4bVar.t()) {
                d0(true);
                return true;
            }
            o4b o4bVar = this.F;
            if (o4bVar != null && o4bVar.t()) {
                d0(true);
                return true;
            } else if (this.C.g().getChosedFiles() != null && this.C.g().size() > 0) {
                d0(true);
                return true;
            } else {
                r4b r4bVar = this.G;
                if (r4bVar != null && r4bVar.t()) {
                    d0(true);
                    return true;
                }
                s4b s4bVar = this.H;
                if (s4bVar != null && s4bVar.t()) {
                    d0(true);
                    return true;
                }
                d0(false);
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public void p0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.g.c(10, this.L);
            this.g.c(5, this.M);
            this.g.c(9, this.N);
            this.g.c(34, this.O);
            this.g.c(35, this.P);
            this.g.c(33, this.Q);
            this.g.c(32, this.R);
            this.g.c(6, this.S);
            this.g.c(31, this.f1131T);
            this.g.c(2, this.U);
        }
    }

    public void r0(@DrawableRes int i2, @DimenRes int i3, @DimenRes int i4, @DimenRes int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048598, this, i2, i3, i4, i5) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.k.getLayoutParams();
            layoutParams.width = BdUtilHelper.getDimens(this.a.getPageActivity(), i3);
            layoutParams.height = BdUtilHelper.getDimens(this.a.getPageActivity(), i4);
            layoutParams.topMargin = BdUtilHelper.getDimens(this.a.getPageActivity(), i5);
            this.k.setLayoutParams(layoutParams);
            this.k.setImageDrawable(WebPManager.getPureDrawable(i2, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_DISABLE));
            this.k.setVisibility(0);
        }
    }

    public final void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            x0();
            boolean z = false;
            for (z4b<?> z4bVar : this.o) {
                z4bVar.a(this.p);
                if (((z4bVar instanceof r4b) || (z4bVar instanceof s4b) || (z4bVar instanceof g4b) || (z4bVar instanceof b4b) || (z4bVar instanceof d4b)) && z4bVar.t()) {
                    z = true;
                }
                if ((z4bVar instanceof e4b) && ((e4b) z4bVar).Y()) {
                    z = true;
                }
            }
            if (!this.p.isQuestionThread() && z3b.d() && !z && z3b.e()) {
                if (z3b.g()) {
                    z3b.h(this.a.getPageActivity());
                }
                y3b.c().g(this.p.getTitle(), this.p.getContent(), new m(this));
                if (z3b.f()) {
                    u0(false);
                    return;
                }
                return;
            }
            u0(false);
        }
    }

    public void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            if ("1".equals(this.p.getCallFrom())) {
                this.p.setCanNoForum(true);
                this.p.setTransmitForumData("[]");
            } else if ("2".equals(this.p.getCallFrom())) {
                this.p.setCanNoForum(false);
            }
            this.d.D(new si5(54, 15, null));
            this.d.D(new si5(65, 15, null));
            if (this.p.getVideoInfo() != null) {
                TiebaStatic.log("c10063");
            }
            WriteData writeData = this.p;
            SharedPrefHelper sharedPrefHelper = SharedPrefHelper.getInstance();
            writeData.setShowCustomFigure(sharedPrefHelper.getBoolean("key_write_virtual_image_enable" + TbadkCoreApplication.getCurrentAccount(), true));
            this.p.setBotConfig(BotEntranceManager.h().i());
            if (vk5.a()) {
                this.p.setShowBless(SharedPrefHelper.getInstance().getBoolean(SharedPrefHelper.getSharedPrefKeyWithAccount("key_write_add_bless_enable"), true));
            }
            s0();
        }
    }

    public final void u0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            boolean z2 = true;
            p(true);
            B();
            this.p.setVcode(null);
            rja rjaVar = this.K;
            if (this.C.g().size() <= 0) {
                z2 = false;
            }
            rjaVar.v(z2);
            this.K.y(this.p);
            if (!this.K.f()) {
                this.a.showToast((int) R.string.write_img_limit);
            } else if (!BdNetTypeUtil.isNetWorkAvailable()) {
                this.a.showToast((int) R.string.obfuscated_res_0x7f0f0e40);
            } else if (ProfileVirtualImageInfo.getInstance().getIsSetVirtualImage() == 0 && this.p.isShowCustomFigure()) {
                this.e.N();
            } else {
                if (z) {
                    this.p.setQuestionThread(z);
                    this.p.setType(14);
                }
                e4b e4bVar = this.E;
                if (e4bVar != null && e4bVar.x() != null) {
                    this.p.onPostDataParse(this.E.x().a());
                }
                w0();
            }
        }
    }
}
