package com.baidu.tieba;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.BaseWriteConfig;
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.service.TiebaPrepareImageService;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.SaveDraftDialogView;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.WriteVoteData;
import com.baidu.tbadk.data.AtSelectData;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.frs.SerializableItemInfo;
import com.baidu.tieba.oo8;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public abstract class l89 implements z69, t69, l65, oo8.g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public boolean B;
    @NonNull
    public TbPageContext<?> a;
    @NonNull
    public NavigationBar b;
    @NonNull
    public LinearLayout c;
    @NonNull
    public EditorTools d;
    @NonNull
    public w69 e;
    @Nullable
    public x79 f;
    @NonNull
    public w79 g;
    public View h;
    public TextView i;
    public View j;
    public ImageView k;
    public TextView l;
    public SaveDraftDialogView m;
    public sv4 n;
    @NonNull
    public final List<x69<?>> o;
    @NonNull
    public WriteData p;
    public boolean q;
    public Handler r;
    public m59 s;
    public h89 t;
    public z79 u;
    public l59 v;
    public q59 w;
    public final CustomMessageListener x;
    public boolean y;
    public boolean z;

    @Override // com.baidu.tieba.z69
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    @Override // com.baidu.tieba.z69
    public LinkedList<i05> F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return null;
        }
        return (LinkedList) invokeV.objValue;
    }

    public abstract void M(@NonNull List<x69<?>> list);

    public abstract void O(@NonNull EditorTools editorTools);

    public abstract x79 V();

    public abstract void Y();

    @Override // com.baidu.tieba.z69
    public void e(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048605, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
        }
    }

    public abstract boolean e0();

    @Override // com.baidu.tieba.z69
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.z69
    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.z69
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, intent) == null) {
        }
    }

    @Override // com.baidu.tieba.z69
    @CallSuper
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
        }
    }

    @Override // com.baidu.tieba.z69
    @CallSuper
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
        }
    }

    @Override // com.baidu.tieba.z69
    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048638, this) == null) {
        }
    }

    @Override // com.baidu.tieba.z69
    public void x(int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048640, this, iArr) == null) {
        }
    }

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l89 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(l89 l89Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l89Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l89Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                this.a.a.showToast((String) customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l89 a;

        public b(l89 l89Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l89Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l89Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.a0();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ l89 b;

        public c(l89 l89Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l89Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = l89Var;
            this.a = z;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || view2 == null) {
                return;
            }
            int id = view2.getId();
            if (id == R.id.obfuscated_res_0x7f091e01) {
                this.b.j();
                if (this.a) {
                    this.b.X();
                }
                this.b.e.setResult(100);
                this.b.e.finish();
            } else if (id == R.id.obfuscated_res_0x7f091e02) {
                this.b.c0();
                if (this.a) {
                    this.b.X();
                }
                this.b.e.setResult(100);
                this.b.e.finish();
            }
            this.b.n.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l89 a;

        public d(l89 l89Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l89Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l89Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (!this.a.A) {
                    for (x69<?> x69Var : this.a.o) {
                        if (x69Var instanceof y69) {
                            y69 y69Var = (y69) x69Var;
                            if (y69Var.f() == 2) {
                                y69Var.l();
                            }
                        }
                    }
                    return;
                }
                this.a.A = false;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l89 a;

        public e(l89 l89Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l89Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l89Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                l89 l89Var = this.a;
                if (l89Var.d.a == null) {
                    return;
                }
                if (l89Var.v == null) {
                    l89 l89Var2 = this.a;
                    l89Var2.v = new l59(l89Var2.a);
                }
                this.a.v.b(this.a.d.a.s(2));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements CustomMessageTask.CustomRunnable<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l89 a;

        public f(l89 l89Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l89Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l89Var;
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage != null && customMessage.getData() != null && customMessage.getData().booleanValue()) {
                    l89 l89Var = this.a;
                    l89Var.d(l89Var.a.getString(R.string.obfuscated_res_0x7f0f153c));
                    return null;
                }
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l89 a;

        public g(l89 l89Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l89Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l89Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.a.getPageActivity() != null && !this.a.a.getPageActivity().isFinishing()) {
                yi.N(this.a.a.getPageActivity(), this.a.a.getPageActivity().getCurrentFocus());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l89 a;

        public h(l89 l89Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l89Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l89Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.a.getPageActivity() != null && !this.a.a.getPageActivity().isFinishing()) {
                yi.z(this.a.a.getPageActivity(), this.a.a.getPageActivity().getCurrentFocus());
            }
        }
    }

    public l89(@NonNull TbPageContext<?> tbPageContext, @NonNull NavigationBar navigationBar, @NonNull LinearLayout linearLayout, @NonNull EditorTools editorTools, @NonNull w69 w69Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, navigationBar, linearLayout, editorTools, w69Var, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = new ArrayList();
        this.r = new Handler(Looper.getMainLooper());
        this.s = new m59();
        this.x = new a(this, 2016554);
        this.a = tbPageContext;
        this.b = navigationBar;
        this.c = linearLayout;
        this.d = editorTools;
        this.e = w69Var;
        this.z = z;
        this.p = new WriteData();
        this.f = V();
        this.g = new w79(this.d);
        this.p.setNewWritePage(true);
    }

    @Override // com.baidu.tieba.l65
    public void B(k65 k65Var) {
        x79 x79Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k65Var) == null) && (x79Var = this.f) != null) {
            x79Var.B(k65Var);
        }
    }

    @Override // com.baidu.tieba.z69
    public void D(k65 k65Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, k65Var) != null) || k65Var == null) {
            return;
        }
        this.d.A(k65Var);
    }

    @Override // com.baidu.tieba.z69
    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, str) == null) {
            this.e.d(str);
        }
    }

    public void d0(boolean z) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048604, this, z) != null) || (textView = this.l) == null) {
            return;
        }
        textView.setEnabled(z);
    }

    @Override // com.baidu.tieba.z69
    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048616, this, z) == null) {
            this.p.setPrivacy(z);
        }
    }

    @Override // com.baidu.tieba.z69
    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048621, this, z) == null) {
            if (z) {
                k0();
            } else {
                yi.N(this.a.getPageActivity(), this.a.getPageActivity().getCurrentFocus());
            }
        }
    }

    @Override // com.baidu.tieba.z69
    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048633, this, z) == null) {
            if (z) {
                S();
            } else {
                yi.z(this.a.getPageActivity(), this.a.getPageActivity().getCurrentFocus());
            }
        }
    }

    @Override // com.baidu.tieba.z69
    public void y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048641, this, z) == null) {
            this.p.setShowCustomFigure(z);
        }
    }

    @Override // com.baidu.tieba.z69
    public void z(k65 k65Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, k65Var) == null) {
            for (x69<?> x69Var : this.o) {
                x69Var.r(k65Var);
            }
        }
    }

    @CallSuper
    public void q(@NonNull y69 y69Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048634, this, y69Var, z) == null) {
            if (z) {
                o(true);
                this.d.q();
            }
            w();
        }
    }

    @Override // com.baidu.tieba.z69
    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.A = true;
        }
    }

    @Override // com.baidu.tieba.z69
    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.d.q();
        }
    }

    public final void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.a.registerListener(this.x);
            if (this.y) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921583));
            }
            b0();
            h0();
        }
    }

    public final void Q() {
        l59 l59Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (l59Var = this.v) != null) {
            l59Var.a();
        }
    }

    public void R() {
        q59 q59Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (q59Var = this.w) != null) {
            q59Var.b();
        }
    }

    public final void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.r.postDelayed(new h(this), 150L);
        }
    }

    public final void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            z79 z79Var = new z79(this.a, this.d);
            this.u = z79Var;
            z79Var.g();
        }
    }

    public final void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.t = new h89(this.a, this.s);
        }
    }

    public void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            onBackPressed();
        }
    }

    public final void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2921500, new f(this));
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    @Override // com.baidu.tieba.z69
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.e.c();
        }
    }

    @Override // com.baidu.tieba.z69
    public void f() {
        v65 n;
        w65 w65Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048607, this) == null) && (n = this.d.n(6)) != null && (w65Var = n.m) != null) {
            w65Var.B(new k65(52, 0, null));
        }
    }

    public final void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            this.d.post(new e(this));
        }
    }

    @Override // com.baidu.tieba.z69
    public void h() {
        z79 z79Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048611, this) == null) && (z79Var = this.u) != null) {
            z79Var.f();
        }
    }

    @Override // com.baidu.tieba.z69
    @CallSuper
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            this.B = true;
        }
    }

    public final void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            if (this.w == null) {
                this.w = new q59(this.a);
            }
            this.w.c(this.d);
        }
    }

    public final void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            this.r.postDelayed(new g(this), 150L);
        }
    }

    @Override // com.baidu.tieba.z69
    @CallSuper
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            C();
            for (x69<?> x69Var : this.o) {
                x69Var.onPause();
            }
        }
    }

    @Override // com.baidu.tieba.z69
    @CallSuper
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            for (x69<?> x69Var : this.o) {
                x69Var.onResume();
            }
        }
    }

    @Override // com.baidu.tieba.z69
    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048637, this) == null) {
            C();
            if (this.p.getWriteImagesInfo() == null) {
                return;
            }
            f89.d(this.a, this.p);
        }
    }

    @Override // com.baidu.tieba.z69
    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048639, this) == null) {
            this.g.a();
        }
    }

    @CallSuper
    public void L(Bundle bundle) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, bundle) != null) || this.a.getPageActivity() == null) {
            return;
        }
        Intent intent = this.a.getPageActivity().getIntent();
        for (x69<?> x69Var : this.o) {
            if (x69Var != null) {
                x69Var.m(bundle, intent, this.p);
                LinearLayout linearLayout = this.c;
                linearLayout.addView(x69Var.s(linearLayout));
                x69Var.j(this);
            }
        }
        this.c.setDrawingCacheEnabled(false);
        this.c.setOnClickListener(new d(this));
        i();
    }

    public void a(WriteData writeData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048597, this, writeData) != null) || writeData == null) {
            return;
        }
        if (this.q) {
            if (writeData.isRichTextEditorMode() && 11 != this.p.getType()) {
                this.e.v0(11, true);
                return;
            } else if (!writeData.isRichTextEditorMode() && 9 != this.p.getType()) {
                this.e.v0(9, true);
                return;
            }
        }
        for (x69<?> x69Var : this.o) {
            x69Var.a(writeData);
        }
        i();
    }

    @Override // com.baidu.tieba.z69
    @CallSuper
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048624, this, i) == null) {
            this.b.onChangeSkinType(this.a, i);
            WebPManager.setPureDrawable(this.b.getBackImageView(), R.drawable.obfuscated_res_0x7f080a30, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            this.l.setTextColor(SkinManager.getColorStateListWithClickAndDisableState(R.color.CAM_X0302, i));
            this.d.w(i);
            SkinManager.setBackgroundColor(this.c, R.color.CAM_X0205);
            for (x69<?> x69Var : this.o) {
                x69Var.onChangeSkinType(i);
            }
            i();
            w();
        }
    }

    @Override // com.baidu.tieba.z69
    @CallSuper
    public void onCreate(Bundle bundle) {
        h89 h89Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, bundle) == null) {
            U(bundle);
            P(this.b);
            O(this.d);
            M(this.o);
            L(bundle);
            W();
            T();
            N();
            if (this.z) {
                Y();
            }
            if (this.p.isFromErrorDialog() && (h89Var = this.t) != null) {
                h89Var.h();
            }
            Z();
        }
    }

    public void P(@NonNull NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, navigationBar) == null) {
            this.i = navigationBar.getCenterText();
            this.k = (ImageView) navigationBar.getCenterImgBox();
            this.j = navigationBar.getCenterImgBoxLayout();
            View addSystemImageButton = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.h = addSystemImageButton;
            addSystemImageButton.setOnClickListener(new b(this));
            String string = this.a.getString(R.string.obfuscated_res_0x7f0f1161);
            if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.p.getFrom())) {
                string = this.a.getString(R.string.obfuscated_res_0x7f0f117f);
            }
            TextView addTextButton = navigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, string);
            this.l = addTextButton;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) addTextButton.getLayoutParams();
            layoutParams.rightMargin = yi.g(this.a.getPageActivity(), R.dimen.obfuscated_res_0x7f0701b2);
            this.l.setLayoutParams(layoutParams);
            i();
        }
    }

    public void g0(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048610, this, z) == null) && this.a.getPageActivity() != null && !this.a.getPageActivity().isFinishing()) {
            if (this.m == null) {
                this.m = new SaveDraftDialogView(this.a.getPageActivity());
                this.m.setOnClickListener(new c(this, z));
            }
            if (this.n == null) {
                sv4 sv4Var = new sv4(this.a);
                this.n = sv4Var;
                sv4Var.setContentView(this.m);
            }
            this.m.setText(this.a.getString(R.string.obfuscated_res_0x7f0f163d), this.a.getString(R.string.obfuscated_res_0x7f0f10d6));
            this.n.k();
        }
    }

    @CallSuper
    public void U(Bundle bundle) {
        Intent intent;
        WriteData writeData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048591, this, bundle) != null) || this.a.getPageActivity() == null) {
            return;
        }
        Intent intent2 = this.a.getPageActivity().getIntent();
        if (bundle != null) {
            this.p.setType(bundle.getInt("type", 9));
            this.p.setForumId(bundle.getString("forum_id"));
            this.p.setForumName(bundle.getString("forum_name"));
            this.p.setFirstDir(bundle.getString(IntentConfig.FORUM_FIRST_DIR));
            this.p.setSecondDir(bundle.getString(IntentConfig.FORUM_SECOND_DIR));
            this.p.setThreadId(bundle.getString("thread_id"));
            this.p.setTitle(bundle.getString(BaseWriteConfig.TITLE));
            this.p.setContent(bundle.getString(BaseWriteConfig.CONTENT));
            this.p.setCallFrom(bundle.getString(BaseWriteConfig.KEY_CALL_FROM));
            String string = bundle.getString(BaseWriteConfig.PREFIX_DATA);
            PostPrefixData postPrefixData = null;
            if (!StringUtils.isNull(string)) {
                postPrefixData = (PostPrefixData) OrmObject.objectWithJsonStr(string, PostPrefixData.class);
            }
            this.p.setPrefixData(postPrefixData);
            this.p.setFrom(bundle.getString("from"));
            this.p.setTopicId(bundle.getString(WriteActivityConfig.HOT_TOPIC_ID));
            this.p.setStatisticFrom(bundle.getInt(WriteActivityConfig.KEY_STATISTIS_FROM, 0));
            this.p.setPrivateThread(bundle.getInt(BaseWriteConfig.PRIVATE_THREAD));
            this.p.setFrsTabInfoData((FrsTabInfoData) bundle.getSerializable("tab_list"));
            this.p.setCanGoods(bundle.getBoolean(WriteActivityConfig.CAN_GOODS));
            this.y = bundle.getBoolean(WriteActivityConfig.NEED_CLOSE_PRE_PAGE);
            this.q = bundle.getBoolean(WriteActivityConfig.RICH_MODE_ENABLE, false);
            this.p.setNotificationH5(intent2.getBooleanExtra(WriteActivityConfig.KEY_NOTIFICATION_H5, false));
            this.p.setNotFakePost(intent2.getBooleanExtra(WriteActivityConfig.KEY_NOT_FAKE_POST, false));
            intent = intent2;
        } else {
            intent = intent2;
            if (intent != null) {
                this.p.setType(intent.getIntExtra("type", 9));
                this.p.setForumId(intent.getStringExtra("forum_id"));
                this.p.setForumName(intent.getStringExtra("forum_name"));
                this.p.setFirstDir(intent.getStringExtra(IntentConfig.FORUM_FIRST_DIR));
                this.p.setSecondDir(intent.getStringExtra(IntentConfig.FORUM_SECOND_DIR));
                this.p.setThreadId(intent.getStringExtra("thread_id"));
                this.p.setTitle(intent.getStringExtra(BaseWriteConfig.TITLE));
                this.p.setContent(intent.getStringExtra(BaseWriteConfig.CONTENT));
                this.p.setCallFrom(intent.getStringExtra(BaseWriteConfig.KEY_CALL_FROM));
                this.p.setFrom(intent.getStringExtra("from"));
                this.p.setProZone(intent.getIntExtra(WriteActivityConfig.KEY_PROFESSION_ZONE, -1));
                this.p.setTopicId(intent.getStringExtra(WriteActivityConfig.HOT_TOPIC_ID));
                this.p.setStatisticFrom(intent.getIntExtra(WriteActivityConfig.KEY_STATISTIS_FROM, 0));
                this.p.setPrivateThread(intent.getIntExtra(BaseWriteConfig.PRIVATE_THREAD, 0));
                this.p.setFrsTabInfoData((FrsTabInfoData) intent.getSerializableExtra("tab_list"));
                this.p.setVoiceEnable(intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true));
                this.p.setDisableAudioMessage(intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE));
                this.p.setCanGoods(intent.getBooleanExtra(WriteActivityConfig.CAN_GOODS, false));
                this.y = intent.getBooleanExtra(WriteActivityConfig.NEED_CLOSE_PRE_PAGE, false);
                PostPrefixData postPrefixData2 = (PostPrefixData) intent.getSerializableExtra(BaseWriteConfig.PREFIX_DATA);
                if (postPrefixData2 != null && postPrefixData2.getPrefixs().size() > 0) {
                    postPrefixData2.getPrefixs().add(this.a.getString(R.string.obfuscated_res_0x7f0f1638));
                }
                this.p.setPrefixData(postPrefixData2);
                this.p.setWriteVoteData((WriteVoteData) intent.getSerializableExtra(IntentConfig.WRITE_VOTE_DATA));
                this.p.setFromItemDetail(intent.getBooleanExtra(IntentConfig.IS_ITEM_DETAIL, false));
                this.p.setIntentStarCount(intent.getIntExtra(WriteActivityConfig.STAR_COUNT, 0));
                Serializable serializableExtra = intent.getSerializableExtra(WriteActivityConfig.ITEM_INFO);
                if (serializableExtra instanceof SerializableItemInfo) {
                    SerializableItemInfo serializableItemInfo = (SerializableItemInfo) serializableExtra;
                    this.p.setIntentItemInfo(serializableItemInfo);
                    this.p.setItem_id(String.valueOf(serializableItemInfo.id));
                }
                this.p.setSaveDraft(intent.getBooleanExtra(BaseWriteConfig.IS_SAVE_DRAFTE, true));
                this.p.setMoreForumImg(intent.getStringExtra("more_forum_img"));
                this.p.setMoreForumTitle(intent.getStringExtra("more_forum_title"));
                this.p.setMoreForumUrl(intent.getStringExtra("more_forum_url"));
                this.p.setIsArticle(intent.getStringExtra(WriteActivityConfig.IS_ARTICLE));
                this.p.setNetImgUrl(intent.getStringExtra(WriteActivityConfig.KEY_GAME_RANK_IMG_URL));
                this.p.setFromGameRank(intent.getBooleanExtra(WriteActivityConfig.KEY_IS_FROM_GAME_RANK, false));
                this.p.setGameId(intent.getStringExtra(WriteActivityConfig.KEY_GAME_ID));
                this.p.setGameName(intent.getStringExtra(WriteActivityConfig.KEY_GAME_NAME));
                this.p.setRewardsType(intent.getStringExtra(WriteActivityConfig.KEY_REWARDS_TYPE));
                this.p.setXiuxiuOriginalContent(intent.getStringExtra(WriteActivityConfig.KEY_XIUXIU_ORIGINAL_CONTENT));
                this.p.setXiuxiuOriginalFname(intent.getStringExtra(WriteActivityConfig.KEY_XIUXIU_ORIGINAL_FNAME));
                this.p.setIsArticle(intent.getStringExtra(WriteActivityConfig.IS_ARTICLE));
                this.p.setNotificationH5(intent.getBooleanExtra(WriteActivityConfig.KEY_NOTIFICATION_H5, false));
                this.p.setNotFakePost(intent.getBooleanExtra(WriteActivityConfig.KEY_NOT_FAKE_POST, false));
                this.q = intent.getBooleanExtra(WriteActivityConfig.RICH_MODE_ENABLE, false);
            }
        }
        if (this.p.getType() == 10) {
            this.p.setEntranceType(2);
            this.p.setType(9);
        } else {
            this.p.setEntranceType(1);
        }
        if (bundle == null && intent != null) {
            this.p.setFromErrorDialog(intent.getBooleanExtra(WriteActivityConfig.IS_FROM_ERROR_DIALOG, false));
        }
        if (this.p.isFromErrorDialog() && (writeData = ir8.f) != null) {
            this.p = writeData;
            writeData.setFromErrorDialog(true);
            WriteData writeData2 = this.p;
            writeData2.setContent(writeData2.getContentString());
        }
        w();
    }

    public void X() {
        String forumId;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048594, this) != null) || WriteActivityConfig.isAsyncWriting()) {
            return;
        }
        WriteActivityConfig type = WriteActivityConfig.newInstance(this.a.getPageActivity()).setType(9);
        if (TextUtils.isEmpty(this.p.getForumId())) {
            forumId = "0";
        } else {
            forumId = this.p.getForumId();
        }
        type.setForumId(forumId).setForumName(this.p.getForumName()).setEnableAudio(this.p.isVoiceEnable()).setAudioMsg(this.p.getDisableAudioMessage()).setCanGoods(false).setPrefixData(this.p.getPrefixData()).setPrivateThread(this.p.getPrivateThread()).setForumDir(this.p.getFirstDir(), this.p.getSecondDir()).setProfessionZone(this.p.getProZone()).setFrsTabInfo(this.p.getFrsTabInfoData()).setCallFrom(this.p.getCallFrom()).setStatisticFrom(this.p.getStatisticFrom()).setIsEvaluate(true).setScoreItemInfo(this.p.getIntentItemInfo()).setStarCount(this.p.getIntentStarCount()).setFrom(this.p.getFrom()).send();
        StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_ENTRANCE_CLICKED);
        if ("main_tab".equals(this.p.getFrom())) {
            i = 8;
        } else {
            i = 2;
        }
        statisticItem.param("obj_locate", i);
        statisticItem.param("obj_type", 6);
        TiebaStatic.log(statisticItem);
    }

    public final void Z() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            switch (this.p.getType()) {
                case 9:
                case 13:
                    i = 1;
                    break;
                case 10:
                default:
                    i = -1;
                    break;
                case 11:
                    i = 2;
                    break;
                case 12:
                    i = 4;
                    break;
                case 14:
                    i = 5;
                    break;
            }
            v59.a(i);
            v59.d(this.p);
        }
    }

    public void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            this.B = true;
            if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.p.getFrom())) {
                this.e.finish();
                return;
            }
            for (x69<?> x69Var : this.o) {
                x69Var.e(this.p);
            }
        }
    }

    @Override // com.baidu.tieba.z69
    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048635, this) == null) {
            C();
            if (this.p.getWriteImagesInfo() == null) {
                return;
            }
            TbPageContext<?> tbPageContext = this.a;
            WriteData writeData = this.p;
            f89.b(tbPageContext, writeData, writeData.getWriteImagesInfo(), this.p.getFrom(), this.p.getDisableAudioMessage(), this.p.isVoiceEnable(), this.p.getPrefixData());
        }
    }

    @Override // com.baidu.tieba.z69
    @NonNull
    public PermissionJudgePolicy t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            Activity pageActivity = this.a.getPageActivity();
            if (pageActivity instanceof BaseActivity) {
                return ((BaseActivity) pageActivity).getCurrentPermissionJudgePolicy();
            }
            if (pageActivity instanceof BaseFragmentActivity) {
                return ((BaseFragmentActivity) pageActivity).getCurrentPermissionJudgePolicy();
            }
            return new PermissionJudgePolicy();
        }
        return (PermissionJudgePolicy) invokeV.objValue;
    }

    @Override // com.baidu.tieba.z69
    @CallSuper
    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            if (this.v != null && !z) {
                Q();
            }
            if (z) {
                C();
            }
            for (x69<?> x69Var : this.o) {
                if (x69Var instanceof y69) {
                    ((y69) x69Var).b(z);
                }
            }
        }
    }

    @Override // com.baidu.tieba.t69
    public void l(@NonNull y69 y69Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048618, this, y69Var) != null) || this.t == null) {
            return;
        }
        if (y69Var.f() == 1) {
            this.t.j(y69Var.p());
        } else if (y69Var.f() == 2) {
            this.t.i(y69Var.p());
        }
    }

    @Override // com.baidu.tieba.z69
    public void n(@Nullable ArrayList<AtSelectData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, arrayList) == null) {
            AtListActivityConfig atListActivityConfig = new AtListActivityConfig(this.a.getPageActivity(), 12004, true);
            atListActivityConfig.setSelectedAtList(arrayList);
            this.a.sendMessage(new CustomMessage(2002001, atListActivityConfig));
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_AT_PANEL_SHOW);
            statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
        }
    }

    public final void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            int l = py4.k().l("write_associate_item_hint_tip_key", 0);
            if (py4.k().l("commodity_tip_show_controller", 0) == 0 && this.p.isCanGoods()) {
                if (l > 0) {
                    f0();
                    return;
                } else {
                    py4.k().w("commodity_tip_show_controller", py4.k().l("commodity_tip_show_controller", 0) + 1);
                    return;
                }
            }
            j0();
            z79 z79Var = this.u;
            if (z79Var != null) {
                z79Var.e();
            }
        }
    }

    @Override // com.baidu.tieba.z69
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(this.a.getPageActivity(), 25004, HotSelectActivityConfig.FROM_POST_THREAD);
            hotSelectActivityConfig.setForumExtra(xg.g(this.p.getForumId(), 0L), this.p.getFirstDir(), this.p.getSecondDir());
            this.a.sendMessage(new CustomMessage(2002001, hotSelectActivityConfig));
        }
    }

    @Override // com.baidu.tieba.z69
    public boolean onBackPressed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            for (x69<?> x69Var : this.o) {
                if (x69Var.g()) {
                    return true;
                }
            }
            if (this.d.u()) {
                C();
                return true;
            } else if (e0()) {
                j();
                this.e.setResult(100);
                this.e.finish();
                return false;
            } else {
                g0(false);
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.z69
    @CallSuper
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            if (!this.B) {
                c0();
            }
            for (x69<?> x69Var : this.o) {
                x69Var.d();
            }
            h89 h89Var = this.t;
            if (h89Var != null) {
                h89Var.g();
            }
            this.r.removeCallbacksAndMessages(null);
            TiebaPrepareImageService.StopService();
            R();
            Q();
            ch.b(this.n, this.a);
            wo8.d();
            MessageManager.getInstance().unRegisterTask(2921500);
        }
    }

    @Override // com.baidu.tieba.z69
    @CallSuper
    public void onActivityResult(int i, int i2, Intent intent) {
        PostWriteCallBackData postWriteCallBackData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048622, this, i, i2, intent) == null) {
            if (i2 == -1) {
                if (i == 12002) {
                    if (intent.getBooleanExtra(AlbumActivityConfig.FINISH_SELF, false)) {
                        this.a.getPageActivity().setResult(-1, intent);
                        this.a.getPageActivity().finish();
                        return;
                    }
                } else if (i == 25064) {
                    f89.a(this.a, this.p);
                } else if (i == 23004) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010040));
                }
            } else if (i2 == 0 && i == 12006 && intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                this.a.showToast(postWriteCallBackData.getErrorString());
                this.s.n(postWriteCallBackData.getErrorString());
                this.s.m(postWriteCallBackData.getSensitiveWords());
                for (x69<?> x69Var : this.o) {
                    if (x69Var instanceof y69) {
                        ((y69) x69Var).n();
                    }
                }
            }
            for (x69<?> x69Var2 : this.o) {
                x69Var2.onActivityResult(i, i2, intent);
            }
        }
    }

    @Override // com.baidu.tieba.z69
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048630, this, bundle) != null) || bundle == null) {
            return;
        }
        bundle.putInt("type", this.p.getType());
        bundle.putString("forum_id", this.p.getForumId());
        bundle.putString("forum_name", this.p.getForumName());
        bundle.putString(IntentConfig.FORUM_FIRST_DIR, this.p.getFirstDir());
        bundle.putString(IntentConfig.FORUM_SECOND_DIR, this.p.getSecondDir());
        bundle.putString("thread_id", this.p.getThreadId());
        bundle.putString(BaseWriteConfig.KEY_CALL_FROM, this.p.getCallFrom());
        bundle.putInt(BaseWriteConfig.PRIVATE_THREAD, this.p.getPrivateThread());
        bundle.putString("from", this.p.getFrom());
        bundle.putSerializable("tab_list", this.p.getFrsTabInfoData());
        bundle.putBoolean(WriteActivityConfig.NEED_CLOSE_PRE_PAGE, this.y);
        PostPrefixData prefixData = this.p.getPrefixData();
        if (prefixData != null) {
            bundle.putString(BaseWriteConfig.PREFIX_DATA, OrmObject.jsonStrWithObject(prefixData));
        }
        for (x69<?> x69Var : this.o) {
            x69Var.onSaveInstanceState(bundle);
        }
    }
}
