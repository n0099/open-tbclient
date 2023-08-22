package com.baidu.tieba.signall;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import android.view.View;
import android.widget.AdapterView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdActivityStack;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.ui.SystemBarTintManager;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.SignAllForumAdvertActivityConfig;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.MemberPayStatistic;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.coreExtra.messageCenter.SignManager;
import com.baidu.tbadk.performanceLog.PerformanceLoggerHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.fn;
import com.baidu.tieba.ls5;
import com.baidu.tieba.ns6;
import com.baidu.tieba.o9a;
import com.baidu.tieba.p95;
import com.baidu.tieba.pay.panel.PayPanelUtils;
import com.baidu.tieba.q9a;
import com.baidu.tieba.r9a;
import com.baidu.tieba.s45;
import com.baidu.tieba.signall.GetForumListModel;
import com.baidu.tieba.signall.SignAllForumModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.v9a;
import com.baidu.tieba.x9a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class SignAllForumActivity extends BaseActivity<SignAllForumActivity> implements p95.g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public x9a a;
    public GetForumListModel b;
    public s45 c;
    public SignAllForumModel d;
    public boolean e;
    public boolean f;
    public boolean g;
    public long h;
    public long i;
    public long j;
    public boolean k;
    public final CustomMessageListener l;
    public final CustomMessageListener m;
    public GetForumListModel.b n;
    public SignAllForumModel.a o;
    public AntiHelper.k p;

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.IPageStayDuration
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? "a022" : (String) invokeV.objValue;
    }

    /* loaded from: classes8.dex */
    public class c implements GetForumListModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SignAllForumActivity a;

        /* loaded from: classes8.dex */
        public class a implements MessageQueue.IdleHandler {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ long a;
            public final /* synthetic */ long b;
            public final /* synthetic */ c c;

            public a(c cVar, long j, long j2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, Long.valueOf(j), Long.valueOf(j2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = cVar;
                this.a = j;
                this.b = j2;
            }

            @Override // android.os.MessageQueue.IdleHandler
            public boolean queueIdle() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    this.c.a.N1(this.a, this.b);
                    return false;
                }
                return invokeV.booleanValue;
            }
        }

        public c(SignAllForumActivity signAllForumActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {signAllForumActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = signAllForumActivity;
        }

        @Override // com.baidu.tieba.signall.GetForumListModel.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.a.a.x();
                this.a.showToast(str, false);
                this.a.finish();
            }
        }

        @Override // com.baidu.tieba.signall.GetForumListModel.b
        public void b(q9a q9aVar) {
            long j;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, q9aVar) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                this.a.a.x();
                o9a i = q9aVar.i();
                if (i != null) {
                    if (i.a() == 0) {
                        this.a.a.I(q9aVar, this.a.b.U());
                    } else {
                        this.a.showToast(i.b(), false);
                        this.a.finish();
                    }
                }
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                long currentTimeMillis3 = System.currentTimeMillis() - this.a.j;
                if (this.a.h > 0) {
                    j = System.currentTimeMillis() - this.a.h;
                } else {
                    j = currentTimeMillis3 + this.a.i;
                }
                Looper.myQueue().addIdleHandler(new a(this, j, currentTimeMillis2));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SignAllForumActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(SignAllForumActivity signAllForumActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {signAllForumActivity, Integer.valueOf(i)};
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
            this.a = signAllForumActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && num.intValue() == 2) {
                this.a.a.G().setHasPrivilege(true);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SignAllForumActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(SignAllForumActivity signAllForumActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {signAllForumActivity, Integer.valueOf(i)};
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
            this.a = signAllForumActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            q9a A;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof SignData) || (A = this.a.a.A()) == null) {
                return;
            }
            A.E((SignData) customResponsedMessage.getData());
            this.a.a.z().notifyDataSetChanged();
        }
    }

    /* loaded from: classes8.dex */
    public class d implements SignAllForumModel.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SignAllForumActivity a;

        public d(SignAllForumActivity signAllForumActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {signAllForumActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = signAllForumActivity;
        }

        @Override // com.baidu.tieba.signall.SignAllForumModel.a
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, str) != null) {
                return;
            }
            this.a.U1(str);
        }

        @Override // com.baidu.tieba.signall.SignAllForumModel.a
        public void b(v9a v9aVar) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, v9aVar) != null) || v9aVar == null) {
                return;
            }
            if (v9aVar.a() != 3250013 || !this.a.g) {
                o9a b = v9aVar.b();
                if (b != null) {
                    if (b.a() == 0) {
                        q9a A = this.a.a.A();
                        A.D(v9aVar);
                        if (this.a.e) {
                            Intent intent = new Intent(this.a.getPageContext().getPageActivity(), SignAllForumActivity.class);
                            intent.addFlags(805306368);
                            intent.putExtra("signall_noyify_click", true);
                            this.a.R1(this.a.getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f13f1, new Object[]{Integer.valueOf(A.s()), Integer.valueOf(A.j())}), PendingIntent.getActivity(this.a.getPageContext().getPageActivity(), 0, intent, SystemBarTintManager.FLAG_TRANSLUCENT_NAVIGATION), false);
                            if (this.a.f) {
                                return;
                            }
                        }
                        this.a.a.z().notifyDataSetChanged();
                        SignAllForumProgressView G = this.a.a.G();
                        if (!A.A()) {
                            if (v9aVar.h() == 0) {
                                if (v9aVar.e() != 0) {
                                    this.a.showToast(v9aVar.g());
                                } else {
                                    this.a.showToast(R.string.obfuscated_res_0x7f0f13f6);
                                }
                            } else {
                                this.a.L1(v9aVar.f());
                                this.a.c.show();
                            }
                        }
                        if (this.a.c == null || !this.a.c.isShowing()) {
                            this.a.K1();
                        }
                        G.setSignSuccess();
                        this.a.Q1(A);
                        return;
                    }
                    this.a.U1(b.b());
                    return;
                }
                return;
            }
            this.a.g = false;
            BdToast.makeText(TbadkCoreApplication.getInst().getContext(), v9aVar.c()).setIcon(BdToast.ToastIcon.FAILURE).setDuration(3000).show();
            if (this.a.a != null && this.a.a.G() != null) {
                this.a.a.G().setSignBefore(0);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SignAllForumActivity a;

        public e(SignAllForumActivity signAllForumActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {signAllForumActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = signAllForumActivity;
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(s45 s45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, s45Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_SIGN));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(s45 s45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, s45Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_SIGN));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ SignAllForumActivity d;

        public f(SignAllForumActivity signAllForumActivity, String str, String str2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {signAllForumActivity, str, str2, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = signAllForumActivity;
            this.a = str;
            this.b = str2;
            this.c = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.d.sendMessage(new CustomMessage(2002001, new SignAllForumAdvertActivityConfig(this.d.getPageContext().getPageActivity(), this.a, this.b, Boolean.valueOf(this.c))));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements s45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SignAllForumActivity a;

        public g(SignAllForumActivity signAllForumActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {signAllForumActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = signAllForumActivity;
        }

        @Override // com.baidu.tieba.s45.e
        public void onClick(s45 s45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, s45Var) == null) {
                s45Var.dismiss();
            }
        }
    }

    public SignAllForumActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = false;
        this.h = 0L;
        this.i = 0L;
        this.j = 0L;
        this.k = false;
        this.l = new a(this, 2001194);
        this.m = new b(this, 2001222);
        this.n = new c(this);
        this.o = new d(this);
        this.p = new e(this);
    }

    public final void S1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            q9a A = this.a.A();
            this.a.G().setDuration(Math.max(A.x().size() * 50, 2000));
            this.a.G().setSigning(0);
            this.d.U(A);
            this.d.loadData();
            this.a.z().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onDestroy();
            this.f = true;
            s45 s45Var = this.c;
            if (s45Var != null && s45Var.isShowing()) {
                this.c.dismiss();
            }
            GetForumListModel getForumListModel = this.b;
            if (getForumListModel != null) {
                getForumListModel.cancelLoadData();
                this.b = null;
            }
            x9a x9aVar = this.a;
            if (x9aVar != null && x9aVar.z() != null) {
                this.a.z().d();
            }
            SignAllForumModel signAllForumModel = this.d;
            if (signAllForumModel != null) {
                if (signAllForumModel.isRunning) {
                    P1();
                }
                this.d.cancelMessage();
                this.d = null;
            }
            GetForumListModel getForumListModel2 = this.b;
            if (getForumListModel2 != null) {
                getForumListModel2.cancelLoadData();
                this.b = null;
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            super.onChangeSkinType(i);
            this.a.onChangeSkinType(i);
        }
    }

    public final void J1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            NotificationHelper.cancelNotification(getPageContext().getPageActivity(), R.drawable.obfuscated_res_0x7f0813c4);
        }
    }

    public final void K1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.a != null) {
            SignManager.getInstance().checkAndShowTimePicker(2, getPageContext(), this.a.H(), false);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (this.k) {
                ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            } else {
                ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 1);
            }
        }
    }

    public final void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            GetForumListModel getForumListModel = new GetForumListModel(this);
            this.b = getForumListModel;
            getForumListModel.V(this.n);
            SignAllForumModel signAllForumModel = new SignAllForumModel(this);
            this.d = signAllForumModel;
            signAllForumModel.V(this.o);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public fn onGetPreLoadListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            x9a x9aVar = this.a;
            if (x9aVar != null && x9aVar.E() != null) {
                return this.a.E().getPreLoadHandle();
            }
            return null;
        }
        return (fn) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.onStop();
            SignAllForumModel signAllForumModel = this.d;
            if (signAllForumModel != null && signAllForumModel.isRunning) {
                P1();
            }
        }
    }

    public final void L1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            s45 positiveButton = new s45(getPageContext().getPageActivity()).setMessage(str).setPositiveButton(R.string.signallforum_signnow, new g(this));
            this.c = positiveButton;
            positiveButton.create(getPageContext());
        }
    }

    public final void Q1(q9a q9aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, q9aVar) != null) || q9aVar == null) {
            return;
        }
        String d2 = q9aVar.d();
        String e2 = q9aVar.e();
        boolean B = q9aVar.B();
        if (q9aVar.C()) {
            this.a.K(0);
            new Handler().postDelayed(new f(this, d2, e2, B), 500L);
        }
    }

    @Override // com.baidu.tieba.p95.g
    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.j = System.currentTimeMillis();
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                showToast(R.string.obfuscated_res_0x7f0f0e29);
                this.a.x();
                return;
            }
            GetForumListModel getForumListModel = this.b;
            if (getForumListModel == null) {
                showToast(R.string.obfuscated_res_0x7f0f0e29);
            } else if (!getForumListModel.loadData()) {
                this.a.x();
            }
        }
    }

    public final void M1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            x9a x9aVar = new x9a(this);
            this.a = x9aVar;
            x9aVar.J(this);
            this.a.L(this);
            SignAllForumModel signAllForumModel = this.d;
            if (signAllForumModel.isRunning) {
                this.n.b(signAllForumModel.T());
                this.a.G().setSigning(90);
                return;
            }
            this.a.M();
        }
    }

    public final void P1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.e = true;
            Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
            intent.addFlags(805306368);
            R1(getPageContext().getString(R.string.obfuscated_res_0x7f0f13f2), PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, SystemBarTintManager.FLAG_TRANSLUCENT_NAVIGATION), true);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            if (this.k) {
                sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            }
            super.finish();
        }
    }

    public void N1(long j, long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) && PerformanceLoggerHelper.getInstance().isSmallFlow() && this.i > 0) {
            new ls5(1009, true, this.b.getResponsedMessage(), 0L, this.i, j2, false, 0L, 0L, j).c();
            this.i = 0L;
        }
    }

    public final void R1(String str, PendingIntent pendingIntent, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048583, this, str, pendingIntent, z) == null) {
            NotificationHelper.showNotification(getPageContext().getPageActivity(), R.drawable.obfuscated_res_0x7f0813c4, getPageContext().getString(R.string.obfuscated_res_0x7f0f029e), str, str, pendingIntent, z);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        x9a x9aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048591, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            if (i2 == -1 && i == 25050 && (x9aVar = this.a) != null) {
                x9aVar.M();
            }
        }
    }

    public final void U1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            if (this.e) {
                q9a A = this.a.A();
                Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
                intent.addFlags(805306368);
                intent.putExtra("signall_noyify_click", true);
                PendingIntent activity = PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, SystemBarTintManager.FLAG_TRANSLUCENT_NAVIGATION);
                str = getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f13f1, new Object[]{0, Integer.valueOf(A.x().size())});
                R1(str, activity, false);
                if (this.f) {
                    return;
                }
            }
            showToast(str);
            this.a.G().setSignSuccess();
            ArrayList<r9a> x = this.a.A().x();
            int size = x.size();
            for (int i = 0; i < size; i++) {
                r9a r9aVar = x.get(i);
                r9aVar.s(true);
                r9aVar.t(false);
                r9aVar.u(false);
            }
            this.a.z().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, view2) == null) {
            q9a A = this.a.A();
            if (view2 == this.a.F()) {
                if (A == null) {
                    return;
                }
                if (A.f() != null) {
                    if (A.f().appeal_status == 1) {
                        BdToast.makeText(getPageContext().getPageActivity(), A.f().appeal_msg).setIcon(BdToast.ToastIcon.FAILURE).setDuration(3000).show();
                    } else if (AntiHelper.t(getPageContext().getPageActivity(), A.f(), this.p) != null) {
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_SIGN));
                    }
                } else if (this.a.G().getCurrentStatus() == 2) {
                    showToast(R.string.obfuscated_res_0x7f0f13f7);
                } else {
                    if (A.o() != 0) {
                        L1(A.p());
                        this.c.show();
                    } else if (BdNetTypeUtil.isNetWorkAvailable()) {
                        this.g = true;
                        S1();
                    } else {
                        showToast(R.string.obfuscated_res_0x7f0f0e29);
                    }
                    TiebaStatic.log("signall_click");
                }
            } else if (view2 == this.a.D()) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "consume_3", "click", 1, new Object[0]);
                PayPanelUtils.launchPayPanel(getPageContext(), 2021, MemberPayStatistic.REFER_PAGE_A_KEY_TO_SIGN, MemberPayStatistic.CLICK_ZONE_BOTTOM_OPENDE_RENEWALFEE_BUTTON);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, bundle) == null) {
            this.h = System.currentTimeMillis();
            if (getIntent() != null && getIntent().getParcelableExtra(IntentConfig.KEY_URI) != null && !BdActivityStack.getInst().isActivityExist("MainTabActivity")) {
                this.k = true;
            }
            if (this.k) {
                setIsAddSwipeBackLayout(false);
            }
            super.onCreate(bundle);
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(getActivity());
                finish();
                return;
            }
            J1();
            Intent intent = getIntent();
            if (intent.hasExtra("signall_noyify_click") && intent.getBooleanExtra("signall_noyify_click", false)) {
                TiebaStatic.log("signall_noyify_click");
            }
            registerListener(this.l);
            registerListener(this.m);
            initData();
            M1();
            this.i = System.currentTimeMillis() - this.h;
            ns6.a(getIntent(), getPageContext(), 25050);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
        r9a r9aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) && this.a.z().getItemViewType(i) == 0 && this.a.A() != null && this.a.A().k() != null && this.a.A().k().size() > i && (r9aVar = this.a.A().k().get(i)) != null) {
            sendMessage(new CustomMessage(2003000, new FrsActivityConfig(getPageContext().getPageActivity()).createNormalCfg(r9aVar.d(), "SignTogetherPage").setCallFrom(6)));
            TiebaStatic.log("signall_frs_click");
        }
    }
}
