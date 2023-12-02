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
import com.baidu.tieba.iib;
import com.baidu.tieba.kib;
import com.baidu.tieba.pb.bot.BotEntranceManager;
import com.baidu.tieba.person.ProfileVirtualImageInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.List;
/* loaded from: classes8.dex */
public class wkb extends xkb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final ukb C;
    @Nullable
    public zib D;
    @Nullable
    public oib E;
    @Nullable
    public yib F;
    @Nullable
    public bjb G;
    @Nullable
    public cjb H;
    @Nullable
    public nib I;
    @NonNull
    public qkb J;
    @NonNull
    public lya K;
    public final kkb L;
    public final kkb M;
    public final kkb N;
    public final kkb O;
    public final kkb P;
    public final kkb Q;
    public final kkb R;
    public final kkb S;

    /* renamed from: T  reason: collision with root package name */
    public final kkb f1171T;
    public final kkb U;

    @Override // com.baidu.tieba.xkb
    public void K(@NonNull List<jjb<?>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
        }
    }

    /* loaded from: classes8.dex */
    public static class m implements iib.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<wkb> a;

        /* loaded from: classes8.dex */
        public class a implements kib.f {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ wkb a;

            public a(m mVar, wkb wkbVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {mVar, wkbVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = wkbVar;
            }

            @Override // com.baidu.tieba.kib.f
            public void a(boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                    this.a.u0(z);
                }
            }
        }

        public m(wkb wkbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wkbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(wkbVar);
        }

        @Override // com.baidu.tieba.iib.b
        public void a(boolean z) {
            wkb wkbVar;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeZ(1048576, this, z) != null) || (wkbVar = this.a.get()) == null) {
                return;
            }
            jib.c(wkbVar.a.getPageActivity());
            if (jib.f()) {
                return;
            }
            if (z) {
                new kib(wkbVar.a.getPageActivity(), new a(this, wkbVar)).j();
            } else {
                wkbVar.u0(false);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class a implements kkb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wkb a;

        public a(wkb wkbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wkbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wkbVar;
        }

        @Override // com.baidu.tieba.kkb
        public boolean a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                if (11 == this.a.p.getType() || 12 == this.a.p.getType() || 13 == this.a.p.getType()) {
                    return false;
                }
                zib zibVar = this.a.D;
                if (zibVar != null && zibVar.N()) {
                    return false;
                }
                return true;
            }
            return invokeI.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class b implements kkb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wkb a;

        public b(wkb wkbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wkbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wkbVar;
        }

        @Override // com.baidu.tieba.kkb
        public boolean a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                zib zibVar = this.a.D;
                if (zibVar != null && zibVar.N()) {
                    return false;
                }
                return true;
            }
            return invokeI.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wkb a;

        public c(wkb wkbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wkbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wkbVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                wkb wkbVar = this.a;
                wkbVar.a.showToast(wkbVar.p.getDisableAudioMessage());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wkb a;

        public d(wkb wkbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wkbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wkbVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            EditText editText;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                hib.d(this.a.a.getPageActivity(), 1);
                hib.e(this.a.p);
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.a.showToast((int) R.string.obfuscated_res_0x7f0f0e70);
                } else if (!vu5.a()) {
                    for (jjb<?> jjbVar : this.a.o) {
                        if (!jjbVar.o()) {
                            return;
                        }
                    }
                    zib zibVar = this.a.D;
                    EditText editText2 = null;
                    if (zibVar != null) {
                        editText = zibVar.p();
                    } else {
                        editText = null;
                    }
                    oib oibVar = this.a.E;
                    if (oibVar != null) {
                        editText2 = oibVar.p();
                    }
                    if (this.a.s.b(editText, editText2)) {
                        wkb wkbVar = this.a;
                        wkbVar.a.showToast(wkbVar.s.e());
                        return;
                    }
                    this.a.v0();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements kkb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wkb a;

        public e(wkb wkbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wkbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wkbVar;
        }

        @Override // com.baidu.tieba.kkb
        public boolean a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                zib zibVar = this.a.D;
                if ((zibVar != null && zibVar.N()) || ListUtils.getCount(this.a.C.g().getChosedFiles()) >= this.a.C.g().getMaxImagesAllowed()) {
                    return false;
                }
                return true;
            }
            return invokeI.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class f implements kkb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wkb a;

        public f(wkb wkbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wkbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wkbVar;
        }

        @Override // com.baidu.tieba.kkb
        public boolean a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                zib zibVar = this.a.D;
                if (zibVar != null && zibVar.N()) {
                    return false;
                }
                return true;
            }
            return invokeI.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class g implements kkb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wkb a;

        public g(wkb wkbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wkbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wkbVar;
        }

        @Override // com.baidu.tieba.kkb
        public boolean a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                zib zibVar = this.a.D;
                if (zibVar != null && zibVar.N()) {
                    return false;
                }
                return true;
            }
            return invokeI.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class h implements kkb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wkb a;

        public h(wkb wkbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wkbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wkbVar;
        }

        @Override // com.baidu.tieba.kkb
        public boolean a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                zib zibVar = this.a.D;
                if ((zibVar != null && zibVar.N()) || 13 == this.a.p.getType() || 11 == this.a.p.getType()) {
                    return false;
                }
                bjb bjbVar = this.a.G;
                if ((bjbVar != null && bjbVar.x() != null && this.a.G.x().a != null) || ListUtils.getCount(this.a.C.g().getChosedFiles()) > 0) {
                    return false;
                }
                return true;
            }
            return invokeI.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class i implements kkb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wkb a;

        public i(wkb wkbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wkbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wkbVar;
        }

        @Override // com.baidu.tieba.kkb
        public boolean a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                zib zibVar = this.a.D;
                if ((zibVar != null && zibVar.N()) || 11 == this.a.p.getType()) {
                    return false;
                }
                cjb cjbVar = this.a.H;
                if (cjbVar != null && cjbVar.t()) {
                    return false;
                }
                oib oibVar = this.a.E;
                if (oibVar != null && oibVar.W() != 0) {
                    return false;
                }
                return true;
            }
            return invokeI.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class j implements kkb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wkb a;

        public j(wkb wkbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wkbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wkbVar;
        }

        @Override // com.baidu.tieba.kkb
        public boolean a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                zib zibVar = this.a.D;
                if ((zibVar != null && zibVar.N()) || 11 == this.a.p.getType()) {
                    return false;
                }
                return ListUtils.isEmpty(this.a.p.getItemDatas());
            }
            return invokeI.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class k implements kkb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wkb a;

        public k(wkb wkbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wkbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wkbVar;
        }

        @Override // com.baidu.tieba.kkb
        public boolean a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                zib zibVar = this.a.D;
                if ((zibVar != null && zibVar.N()) || 11 == this.a.p.getType()) {
                    return false;
                }
                return ListUtils.isEmpty(this.a.p.getItemDatas());
            }
            return invokeI.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class l implements kkb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wkb a;

        public l(wkb wkbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wkbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wkbVar;
        }

        @Override // com.baidu.tieba.kkb
        public boolean a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                if (11 == this.a.p.getType()) {
                    return false;
                }
                zib zibVar = this.a.D;
                if (zibVar != null && zibVar.N()) {
                    return false;
                }
                return this.a.p.isVoiceEnable();
            }
            return invokeI.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wkb(@NonNull TbPageContext<?> tbPageContext, @NonNull NavigationBar navigationBar, @NonNull LinearLayout linearLayout, @NonNull EditorTools editorTools, @NonNull ijb ijbVar, boolean z) {
        super(tbPageContext, navigationBar, linearLayout, editorTools, ijbVar, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, navigationBar, linearLayout, editorTools, ijbVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (NavigationBar) objArr2[1], (LinearLayout) objArr2[2], (EditorTools) objArr2[3], (ijb) objArr2[4], ((Boolean) objArr2[5]).booleanValue());
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
        this.f1171T = new a(this);
        this.U = new b(this);
        this.C = new ukb(this.a);
        this.J = new qkb(this.a, this);
        this.K = lya.l();
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

    @Override // com.baidu.tieba.xkb
    public void J(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            super.J(bundle);
            this.C.e(this, this.p);
            this.C.f(this, this.p);
        }
    }

    @Override // com.baidu.tieba.xkb
    public void M(@NonNull EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, editorTools) == null) {
            p0();
            t0();
        }
    }

    @Override // com.baidu.tieba.xkb
    public void N(@NonNull NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, navigationBar) == null) {
            super.N(navigationBar);
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

    @Override // com.baidu.tieba.xkb, com.baidu.tieba.ljb
    public void onChangeSkinType(int i2) {
        EditText p;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            super.onChangeSkinType(i2);
            yhb yhbVar = this.s;
            zib zibVar = this.D;
            EditText editText = null;
            if (zibVar == null) {
                p = null;
            } else {
                p = zibVar.p();
            }
            oib oibVar = this.E;
            if (oibVar != null) {
                editText = oibVar.p();
            }
            yhbVar.l(p, editText);
        }
    }

    @Override // com.baidu.tieba.xkb, com.baidu.tieba.ljb
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, intent) == null) {
            super.onNewIntent(intent);
            this.C.n(intent);
        }
    }

    @Override // com.baidu.tieba.xkb, com.baidu.tieba.ljb
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

    @Override // com.baidu.tieba.xkb, com.baidu.tieba.ljb
    public void x(int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, iArr) == null) {
            super.x(iArr);
            if (iArr != null && iArr.length != 0) {
                this.g.b(iArr);
            }
        }
    }

    @Override // com.baidu.tieba.xkb
    public void S(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            TbPageContext<?> tbPageContext = this.a;
            if (tbPageContext instanceof TbPageContextSupport) {
                this.K.n((TbPageContextSupport) tbPageContext);
            }
            super.S(bundle);
            if (this.a.getPageActivity() == null) {
                return;
            }
            this.C.h(bundle, this.a.getPageActivity().getIntent(), this.p);
        }
    }

    @Override // com.baidu.tieba.xkb, com.baidu.tieba.qva.h
    public void d(WriteData writeData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048585, this, writeData) != null) || WriteActivityConfig.FROM_FORUM_SHARE.equals(this.p.getFrom())) {
            return;
        }
        nib nibVar = this.I;
        if (nibVar != null && nibVar.t()) {
            return;
        }
        if (this.q && this.C.g().size() > 0) {
            return;
        }
        super.d(writeData);
    }

    @Override // com.baidu.tieba.xkb
    public jkb T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return new hkb(this.a, this);
        }
        return (jkb) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xkb
    public void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (TextUtils.isEmpty(this.p.getTopicId())) {
                qva.n(this.p.getForumId(), this);
            } else {
                qva.u(this.p.getTopicId(), this);
            }
        }
    }

    @Override // com.baidu.tieba.xkb, com.baidu.tieba.ljb
    public void m() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            zib zibVar = this.D;
            if (zibVar != null && zibVar.N()) {
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
            for (jjb<?> jjbVar : this.o) {
                if (jjbVar.t()) {
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.xkb, com.baidu.tieba.ljb
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onDestroy();
            this.K.p(this.a);
        }
    }

    @Override // com.baidu.tieba.xkb, com.baidu.tieba.ljb
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.onResume();
            this.K.q(this.a);
        }
    }

    public final void t0() {
        qe5 t;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && (t = this.d.t(6)) != null && !TextUtils.isEmpty(this.p.getDisableAudioMessage())) {
            ((View) t).setOnClickListener(new c(this));
        }
    }

    public void x0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            this.K.f();
        }
    }

    @Override // com.baidu.tieba.xkb, com.baidu.tieba.ljb
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.b();
            if (TextUtils.isEmpty(this.p.getTopicId())) {
                qva.y(this.p.getForumId(), this.p, true);
            } else {
                qva.F(this.p.getTopicId(), null);
            }
        }
    }

    @Override // com.baidu.tieba.xkb
    public boolean d0() {
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

    @Override // com.baidu.tieba.ljb
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
            this.K.A();
            bfb.f(this.p);
            this.e.E();
            b0();
            if ("topic_detail".equals(this.p.getFrom())) {
                this.e.setResult(-1);
            } else {
                this.e.setResult(100);
            }
            this.e.t();
        }
    }

    @Override // com.baidu.tieba.xkb
    public void b0() {
        String forumId;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            oib oibVar = this.E;
            if (oibVar != null && oibVar.x() != null) {
                this.p.onSaveDrafDataParse(this.E.x().a());
            }
            super.b0();
            if (13 != this.p.getType() && 14 != this.p.getType() && 12 != this.p.getType()) {
                if (TextUtils.isEmpty(this.p.getTopicId())) {
                    if (this.p.getForumId() == null) {
                        forumId = "0";
                    } else {
                        forumId = this.p.getForumId();
                    }
                    qva.x(forumId, this.p);
                    return;
                }
                qva.F(this.p.getTopicId(), this.p);
            }
        }
    }

    @Override // com.baidu.tieba.xkb, com.baidu.tieba.ljb
    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (super.j()) {
                return true;
            }
            zib zibVar = this.D;
            if (zibVar != null && zibVar.t()) {
                c0(true);
                return true;
            }
            oib oibVar = this.E;
            if (oibVar != null && oibVar.t()) {
                c0(true);
                return true;
            }
            yib yibVar = this.F;
            if (yibVar != null && yibVar.t()) {
                c0(true);
                return true;
            } else if (this.C.g().getChosedFiles() != null && this.C.g().size() > 0) {
                c0(true);
                return true;
            } else {
                bjb bjbVar = this.G;
                if (bjbVar != null && bjbVar.t()) {
                    c0(true);
                    return true;
                }
                cjb cjbVar = this.H;
                if (cjbVar != null && cjbVar.t()) {
                    c0(true);
                    return true;
                }
                c0(false);
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
            this.g.c(31, this.f1171T);
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
            for (jjb<?> jjbVar : this.o) {
                jjbVar.a(this.p);
                if (((jjbVar instanceof bjb) || (jjbVar instanceof cjb) || (jjbVar instanceof qib) || (jjbVar instanceof lib) || (jjbVar instanceof nib)) && jjbVar.t()) {
                    z = true;
                }
                if ((jjbVar instanceof oib) && ((oib) jjbVar).Z()) {
                    z = true;
                }
            }
            if (!this.p.isQuestionThread() && jib.d() && !z && jib.e()) {
                if (jib.g()) {
                    jib.h(this.a.getPageActivity());
                }
                iib.c().g(this.p.getTitle(), this.p.getContent(), new m(this));
                if (jib.f()) {
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
            this.d.K(new he5(54, 15, null));
            this.d.K(new he5(65, 15, null));
            if (this.p.getVideoInfo() != null) {
                TiebaStatic.log("c10063");
            }
            WriteData writeData = this.p;
            SharedPrefHelper sharedPrefHelper = SharedPrefHelper.getInstance();
            writeData.setShowCustomFigure(sharedPrefHelper.getBoolean("key_write_virtual_image_enable" + TbadkCoreApplication.getCurrentAccount(), true));
            this.p.setBotConfig(BotEntranceManager.g().h());
            if (ch5.a()) {
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
            lya lyaVar = this.K;
            if (this.C.g().size() <= 0) {
                z2 = false;
            }
            lyaVar.w(z2);
            this.K.z(this.p);
            if (!this.K.g()) {
                this.a.showToast((int) R.string.write_img_limit);
            } else if (!BdNetTypeUtil.isNetWorkAvailable()) {
                this.a.showToast((int) R.string.obfuscated_res_0x7f0f0e70);
            } else if (ProfileVirtualImageInfo.getInstance().getIsSetVirtualImage() == 0 && this.p.isShowCustomFigure()) {
                this.e.I();
            } else {
                if (z) {
                    this.p.setQuestionThread(z);
                    this.p.setType(14);
                }
                oib oibVar = this.E;
                if (oibVar != null && oibVar.x() != null) {
                    this.p.onPostDataParse(this.E.x().a());
                }
                w0();
            }
        }
    }
}
