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
import com.baidu.tieba.ci;
import com.baidu.tieba.d8a;
import com.baidu.tieba.f8a;
import com.baidu.tieba.g8a;
import com.baidu.tieba.go6;
import com.baidu.tieba.hz4;
import com.baidu.tieba.k8a;
import com.baidu.tieba.l45;
import com.baidu.tieba.m8a;
import com.baidu.tieba.mn5;
import com.baidu.tieba.pay.panel.PayPanelUtils;
import com.baidu.tieba.signall.GetForumListModel;
import com.baidu.tieba.signall.SignAllForumModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class SignAllForumActivity extends BaseActivity<SignAllForumActivity> implements l45.g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public m8a a;
    public GetForumListModel b;
    public hz4 c;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "a022" : (String) invokeV.objValue;
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
                    this.c.a.k1(this.a, this.b);
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
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.a.a.g();
                this.a.showToast(str, false);
                this.a.finish();
            }
        }

        @Override // com.baidu.tieba.signall.GetForumListModel.b
        public void a(f8a f8aVar) {
            long j;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, f8aVar) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                this.a.a.g();
                d8a i = f8aVar.i();
                if (i != null) {
                    if (i.a() == 0) {
                        this.a.a.D(f8aVar, this.a.b.U());
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
                this.a.a.B().setHasPrivilege(true);
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
            f8a x;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof SignData) || (x = this.a.a.x()) == null) {
                return;
            }
            x.E((SignData) customResponsedMessage.getData());
            this.a.a.u().notifyDataSetChanged();
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
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) != null) {
                return;
            }
            this.a.r1(str);
        }

        @Override // com.baidu.tieba.signall.SignAllForumModel.a
        public void a(k8a k8aVar) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, k8aVar) != null) || k8aVar == null) {
                return;
            }
            if (k8aVar.a() != 3250013 || !this.a.g) {
                d8a b = k8aVar.b();
                if (b != null) {
                    if (b.a() == 0) {
                        f8a x = this.a.a.x();
                        x.D(k8aVar);
                        if (this.a.e) {
                            Intent intent = new Intent(this.a.getPageContext().getPageActivity(), SignAllForumActivity.class);
                            intent.addFlags(805306368);
                            intent.putExtra("signall_noyify_click", true);
                            this.a.o1(this.a.getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f141c, new Object[]{Integer.valueOf(x.s()), Integer.valueOf(x.j())}), PendingIntent.getActivity(this.a.getPageContext().getPageActivity(), 0, intent, SystemBarTintManager.FLAG_TRANSLUCENT_NAVIGATION), false);
                            if (this.a.f) {
                                return;
                            }
                        }
                        this.a.a.u().notifyDataSetChanged();
                        SignAllForumProgressView B = this.a.a.B();
                        if (!x.A()) {
                            if (k8aVar.h() == 0) {
                                if (k8aVar.e() != 0) {
                                    this.a.showToast(k8aVar.g());
                                } else {
                                    this.a.showToast(R.string.obfuscated_res_0x7f0f1421);
                                }
                            } else {
                                this.a.i1(k8aVar.f());
                                this.a.c.show();
                            }
                        }
                        if (this.a.c == null || !this.a.c.isShowing()) {
                            this.a.h1();
                        }
                        B.setSignSuccess();
                        this.a.m1(x);
                        return;
                    }
                    this.a.r1(b.b());
                    return;
                }
                return;
            }
            this.a.g = false;
            BdToast.makeText(TbadkCoreApplication.getInst().getContext(), k8aVar.c()).setIcon(BdToast.ToastIcon.FAILURE).setDuration(3000).show();
            if (this.a.a != null && this.a.a.B() != null) {
                this.a.a.B().setSignBefore(0);
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
        public void onNavigationButtonClick(hz4 hz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, hz4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_SIGN));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(hz4 hz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hz4Var) == null) {
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
    public class g implements hz4.e {
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

        @Override // com.baidu.tieba.hz4.e
        public void onClick(hz4 hz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, hz4Var) == null) {
                hz4Var.dismiss();
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

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onDestroy();
            this.f = true;
            hz4 hz4Var = this.c;
            if (hz4Var != null && hz4Var.isShowing()) {
                this.c.dismiss();
            }
            GetForumListModel getForumListModel = this.b;
            if (getForumListModel != null) {
                getForumListModel.cancelLoadData();
                this.b = null;
            }
            m8a m8aVar = this.a;
            if (m8aVar != null && m8aVar.u() != null) {
                this.a.u().d();
            }
            SignAllForumModel signAllForumModel = this.d;
            if (signAllForumModel != null) {
                if (signAllForumModel.isRunning) {
                    l1();
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

    public final void q1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            f8a x = this.a.x();
            this.a.B().setDuration(Math.max(x.x().size() * 50, 2000));
            this.a.B().setSigning(0);
            this.d.U(x);
            this.d.loadData();
            this.a.u().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            super.onChangeSkinType(i);
            this.a.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.l45.g
    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.j = System.currentTimeMillis();
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                showToast(R.string.obfuscated_res_0x7f0f0e4f);
                this.a.g();
                return;
            }
            GetForumListModel getForumListModel = this.b;
            if (getForumListModel == null) {
                showToast(R.string.obfuscated_res_0x7f0f0e4f);
            } else if (!getForumListModel.loadData()) {
                this.a.g();
            }
        }
    }

    public final void i1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            hz4 positiveButton = new hz4(getPageContext().getPageActivity()).setMessage(str).setPositiveButton(R.string.signallforum_signnow, new g(this));
            this.c = positiveButton;
            positiveButton.create(getPageContext());
        }
    }

    public final void m1(f8a f8aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048587, this, f8aVar) != null) || f8aVar == null) {
            return;
        }
        String d2 = f8aVar.d();
        String e2 = f8aVar.e();
        boolean B = f8aVar.B();
        if (f8aVar.C()) {
            this.a.F(0);
            new Handler().postDelayed(new f(this, d2, e2, B), 500L);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.k) {
                ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            } else {
                ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 1);
            }
        }
    }

    public final void g1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            NotificationHelper.cancelNotification(getPageContext().getPageActivity(), R.drawable.obfuscated_res_0x7f0813e1);
        }
    }

    public final void h1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.a != null) {
            SignManager.getInstance().checkAndShowTimePicker(2, getPageContext(), this.a.C(), false);
        }
    }

    public final void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            GetForumListModel getForumListModel = new GetForumListModel(this);
            this.b = getForumListModel;
            getForumListModel.V(this.n);
            SignAllForumModel signAllForumModel = new SignAllForumModel(this);
            this.d = signAllForumModel;
            signAllForumModel.V(this.o);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public ci onGetPreLoadListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            m8a m8aVar = this.a;
            if (m8aVar != null && m8aVar.z() != null) {
                return this.a.z().getPreLoadHandle();
            }
            return null;
        }
        return (ci) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.onStop();
            SignAllForumModel signAllForumModel = this.d;
            if (signAllForumModel != null && signAllForumModel.isRunning) {
                l1();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.k) {
                sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            }
            super.finish();
        }
    }

    public final void j1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            m8a m8aVar = new m8a(this);
            this.a = m8aVar;
            m8aVar.E(this);
            this.a.G(this);
            SignAllForumModel signAllForumModel = this.d;
            if (signAllForumModel.isRunning) {
                this.n.a(signAllForumModel.T());
                this.a.B().setSigning(90);
                return;
            }
            this.a.H();
        }
    }

    public final void l1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.e = true;
            Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
            intent.addFlags(805306368);
            o1(getPageContext().getString(R.string.obfuscated_res_0x7f0f141d), PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, SystemBarTintManager.FLAG_TRANSLUCENT_NAVIGATION), true);
        }
    }

    public void k1(long j, long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) && PerformanceLoggerHelper.getInstance().isSmallFlow() && this.i > 0) {
            new mn5(1009, true, this.b.getResponsedMessage(), 0L, this.i, j2, false, 0L, 0L, j).c();
            this.i = 0L;
        }
    }

    public final void o1(String str, PendingIntent pendingIntent, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048588, this, str, pendingIntent, z) == null) {
            NotificationHelper.showNotification(getPageContext().getPageActivity(), R.drawable.obfuscated_res_0x7f0813e1, getPageContext().getString(R.string.obfuscated_res_0x7f0f029e), str, str, pendingIntent, z);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        m8a m8aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048589, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            if (i2 == -1 && i == 25050 && (m8aVar = this.a) != null) {
                m8aVar.H();
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, view2) == null) {
            f8a x = this.a.x();
            if (view2 == this.a.A()) {
                if (x == null) {
                    return;
                }
                if (x.f() != null) {
                    if (x.f().appeal_status == 1) {
                        BdToast.makeText(getPageContext().getPageActivity(), x.f().appeal_msg).setIcon(BdToast.ToastIcon.FAILURE).setDuration(3000).show();
                    } else if (AntiHelper.t(getPageContext().getPageActivity(), x.f(), this.p) != null) {
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_SIGN));
                    }
                } else if (this.a.B().getCurrentStatus() == 2) {
                    showToast(R.string.obfuscated_res_0x7f0f1422);
                } else {
                    if (x.o() != 0) {
                        i1(x.p());
                        this.c.show();
                    } else if (BdNetTypeUtil.isNetWorkAvailable()) {
                        this.g = true;
                        q1();
                    } else {
                        showToast(R.string.obfuscated_res_0x7f0f0e4f);
                    }
                    TiebaStatic.log("signall_click");
                }
            } else if (view2 == this.a.y()) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "consume_3", "click", 1, new Object[0]);
                PayPanelUtils.launchPayPanel(getPageContext(), 2021, MemberPayStatistic.REFER_PAGE_A_KEY_TO_SIGN, MemberPayStatistic.CLICK_ZONE_BOTTOM_OPENDE_RENEWALFEE_BUTTON);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bundle) == null) {
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
            g1();
            Intent intent = getIntent();
            if (intent.hasExtra("signall_noyify_click") && intent.getBooleanExtra("signall_noyify_click", false)) {
                TiebaStatic.log("signall_noyify_click");
            }
            registerListener(this.l);
            registerListener(this.m);
            initData();
            j1();
            this.i = System.currentTimeMillis() - this.h;
            go6.a(getIntent(), getPageContext(), 25050);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
        g8a g8aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) && this.a.u().getItemViewType(i) == 0 && this.a.x() != null && this.a.x().k() != null && this.a.x().k().size() > i && (g8aVar = this.a.x().k().get(i)) != null) {
            sendMessage(new CustomMessage(2003000, new FrsActivityConfig(getPageContext().getPageActivity()).createNormalCfg(g8aVar.d(), "SignTogetherPage").setCallFrom(6)));
            TiebaStatic.log("signall_frs_click");
        }
    }

    public final void r1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            if (this.e) {
                f8a x = this.a.x();
                Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
                intent.addFlags(805306368);
                intent.putExtra("signall_noyify_click", true);
                PendingIntent activity = PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, SystemBarTintManager.FLAG_TRANSLUCENT_NAVIGATION);
                str = getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f141c, new Object[]{0, Integer.valueOf(x.x().size())});
                o1(str, activity, false);
                if (this.f) {
                    return;
                }
            }
            showToast(str);
            this.a.B().setSignSuccess();
            ArrayList<g8a> x2 = this.a.x().x();
            int size = x2.size();
            for (int i = 0; i < size; i++) {
                g8a g8aVar = x2.get(i);
                g8aVar.s(true);
                g8aVar.t(false);
                g8aVar.u(false);
            }
            this.a.u().notifyDataSetChanged();
        }
    }
}
