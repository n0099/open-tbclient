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
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
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
import com.baidu.tbadk.performanceLog.PerformanceLoggerHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.signall.GetForumListModel;
import com.baidu.tieba.signall.SignAllForumModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.a85;
import com.repackage.cc8;
import com.repackage.dq4;
import com.repackage.ec8;
import com.repackage.fc8;
import com.repackage.ft4;
import com.repackage.hx4;
import com.repackage.jc8;
import com.repackage.ji;
import com.repackage.lc8;
import com.repackage.nn;
import com.repackage.tx5;
import com.repackage.x8;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class SignAllForumActivity extends BaseActivity<SignAllForumActivity> implements ft4.g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long beginTime;
    public long creatTime;
    public boolean isBack;
    public boolean isClickAllSign;
    public boolean isDestory;
    public dq4 mDialog;
    public GetForumListModel mGetForumListModel;
    public AntiHelper.k mInjectListener;
    public boolean mIsFromSchema;
    public final CustomMessageListener mMemListener;
    public GetForumListModel.b mOnGetForumListDataCallBack;
    public SignAllForumModel.a mOnSignAllForumCallback;
    public final CustomMessageListener mRefreshSignStateListener;
    public SignAllForumModel mSignAllForumModel;
    public lc8 mView;
    public long refrehStartTime;

    /* loaded from: classes3.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || (num = (Integer) customResponsedMessage.getData()) == null || num.intValue() != 2) {
                return;
            }
            this.a.mView.m().setHasPrivilege(true);
        }
    }

    /* loaded from: classes3.dex */
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
            ec8 i;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof SignData) || (i = this.a.mView.i()) == null) {
                return;
            }
            i.E((SignData) customResponsedMessage.getData());
            this.a.mView.h().notifyDataSetChanged();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements GetForumListModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SignAllForumActivity a;

        /* loaded from: classes3.dex */
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
                    this.c.a.logCostTimeLog(this.a, this.b);
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
        public void a(ec8 ec8Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ec8Var) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                this.a.mView.e();
                cc8 i = ec8Var.i();
                if (i != null) {
                    if (i.a() == 0) {
                        this.a.mView.o(ec8Var, this.a.mGetForumListModel.F());
                    } else {
                        this.a.showToast(i.b(), false);
                        this.a.finish();
                    }
                }
                Looper.myQueue().addIdleHandler(new a(this, this.a.beginTime > 0 ? System.currentTimeMillis() - this.a.beginTime : (System.currentTimeMillis() - this.a.refrehStartTime) + this.a.creatTime, System.currentTimeMillis() - currentTimeMillis));
            }
        }

        @Override // com.baidu.tieba.signall.GetForumListModel.b
        public void onNetError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.a.mView.e();
                this.a.showToast(str, false);
                this.a.finish();
            }
        }
    }

    /* loaded from: classes3.dex */
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
        public void a(jc8 jc8Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jc8Var) == null) || jc8Var == null) {
                return;
            }
            if (jc8Var.a() == 3250013 && this.a.isClickAllSign) {
                this.a.isClickAllSign = false;
                BdToast.h(TbadkCoreApplication.getInst().getContext(), jc8Var.c(), R.drawable.obfuscated_res_0x7f0809ca, 3000, true).n();
                if (this.a.mView == null || this.a.mView.m() == null) {
                    return;
                }
                this.a.mView.m().setSignBefore(0);
                return;
            }
            cc8 b = jc8Var.b();
            if (b != null) {
                if (b.a() == 0) {
                    ec8 i = this.a.mView.i();
                    i.D(jc8Var);
                    if (this.a.isBack) {
                        Intent intent = new Intent(this.a.getPageContext().getPageActivity(), SignAllForumActivity.class);
                        intent.addFlags(805306368);
                        intent.putExtra("signall_noyify_click", true);
                        this.a.showNotification(this.a.getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f119d, new Object[]{Integer.valueOf(i.s()), Integer.valueOf(i.j())}), PendingIntent.getActivity(this.a.getPageContext().getPageActivity(), 0, intent, 134217728), false);
                        if (this.a.isDestory) {
                            return;
                        }
                    }
                    this.a.mView.h().notifyDataSetChanged();
                    SignAllForumProgressView m = this.a.mView.m();
                    if (!i.A()) {
                        if (jc8Var.h() != 0) {
                            this.a.createAlertDialog(jc8Var.f());
                            this.a.mDialog.show();
                        } else if (jc8Var.e() != 0) {
                            this.a.showToast(jc8Var.g());
                        } else {
                            this.a.showToast(R.string.obfuscated_res_0x7f0f11a2);
                        }
                    }
                    if (this.a.mDialog == null || !this.a.mDialog.isShowing()) {
                        this.a.checkAndShowTimePicker();
                    }
                    m.setSignSuccess();
                    this.a.showAdvert(i);
                    return;
                }
                this.a.signFailed(b.b());
            }
        }

        @Override // com.baidu.tieba.signall.SignAllForumModel.a
        public void onNetError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.a.signFailed(str);
            }
        }
    }

    /* loaded from: classes3.dex */
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
        public void onNavigationButtonClick(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_SIGN));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dq4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_SIGN));
            }
        }
    }

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public class g implements dq4.e {
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

        @Override // com.repackage.dq4.e
        public void onClick(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                dq4Var.dismiss();
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
        this.isClickAllSign = false;
        this.beginTime = 0L;
        this.creatTime = 0L;
        this.refrehStartTime = 0L;
        this.mIsFromSchema = false;
        this.mMemListener = new a(this, 2001194);
        this.mRefreshSignStateListener = new b(this, 2001222);
        this.mOnGetForumListDataCallBack = new c(this);
        this.mOnSignAllForumCallback = new d(this);
        this.mInjectListener = new e(this);
    }

    private void cancelNotification() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            NotificationHelper.cancelNotification(getPageContext().getPageActivity(), R.drawable.obfuscated_res_0x7f0810fc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkAndShowTimePicker() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65553, this) == null) || this.mView == null) {
            return;
        }
        hx4.c().a(getPageContext(), this.mView.n());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createAlertDialog(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, this, str) == null) {
            dq4 positiveButton = new dq4(getPageContext().getPageActivity()).setMessage(str).setPositiveButton(R.string.obfuscated_res_0x7f0f11a9, new g(this));
            this.mDialog = positiveButton;
            positiveButton.create(getPageContext());
        }
    }

    private void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, this) == null) {
            GetForumListModel getForumListModel = new GetForumListModel(this);
            this.mGetForumListModel = getForumListModel;
            getForumListModel.G(this.mOnGetForumListDataCallBack);
            SignAllForumModel signAllForumModel = new SignAllForumModel(this);
            this.mSignAllForumModel = signAllForumModel;
            signAllForumModel.G(this.mOnSignAllForumCallback);
        }
    }

    private void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65556, this) == null) {
            lc8 lc8Var = new lc8(this);
            this.mView = lc8Var;
            lc8Var.q(this);
            this.mView.s(this);
            SignAllForumModel signAllForumModel = this.mSignAllForumModel;
            if (signAllForumModel.isRunning) {
                this.mOnGetForumListDataCallBack.a(signAllForumModel.E());
                this.mView.m().setSigning(90);
                return;
            }
            this.mView.t();
        }
    }

    private void moveToBack() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65557, this) == null) {
            this.isBack = true;
            Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
            intent.addFlags(805306368);
            showNotification(getPageContext().getString(R.string.obfuscated_res_0x7f0f119e), PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728), true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showAdvert(ec8 ec8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65558, this, ec8Var) == null) || ec8Var == null) {
            return;
        }
        String d2 = ec8Var.d();
        String e2 = ec8Var.e();
        boolean B = ec8Var.B();
        if (ec8Var.C()) {
            this.mView.r(0);
            new Handler().postDelayed(new f(this, d2, e2, B), 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNotification(String str, PendingIntent pendingIntent, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65559, this, str, pendingIntent, z) == null) {
            NotificationHelper.showNotification(getPageContext().getPageActivity(), R.drawable.obfuscated_res_0x7f0810fc, getPageContext().getString(R.string.obfuscated_res_0x7f0f029e), str, str, pendingIntent, z);
        }
    }

    private void signAllForum() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65560, this) == null) {
            ec8 i = this.mView.i();
            this.mView.m().setDuration(Math.max(i.x().size() * 50, 2000));
            this.mView.m().setSigning(0);
            this.mSignAllForumModel.F(i);
            this.mSignAllForumModel.loadData();
            this.mView.h().notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void signFailed(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65561, this, str) == null) {
            if (this.isBack) {
                ec8 i = this.mView.i();
                Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
                intent.addFlags(805306368);
                intent.putExtra("signall_noyify_click", true);
                PendingIntent activity = PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728);
                str = getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f119d, new Object[]{0, Integer.valueOf(i.x().size())});
                showNotification(str, activity, false);
                if (this.isDestory) {
                    return;
                }
            }
            showToast(str);
            this.mView.m().setSignSuccess();
            ArrayList<fc8> x = this.mView.i().x();
            int size = x.size();
            for (int i2 = 0; i2 < size; i2++) {
                fc8 fc8Var = x.get(i2);
                fc8Var.s(true);
                fc8Var.t(false);
                fc8Var.u(false);
            }
            this.mView.h().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.mIsFromSchema) {
                ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            } else {
                ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 1);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.mIsFromSchema) {
                sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            }
            super.finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.repackage.f75
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "a022" : (String) invokeV.objValue;
    }

    public void logCostTimeLog(long j, long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) && PerformanceLoggerHelper.getInstance().isSmallFlow() && this.creatTime > 0) {
            new a85(1009, true, this.mGetForumListModel.getResponsedMessage(), 0L, this.creatTime, j2, false, 0L, 0L, j).c();
            this.creatTime = 0L;
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        lc8 lc8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048580, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            if (i2 == -1 && i == 25050 && (lc8Var = this.mView) != null) {
                lc8Var.t();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            super.onChangeSkinType(i);
            this.mView.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view2) == null) {
            ec8 i = this.mView.i();
            if (view2 != this.mView.l()) {
                if (view2 == this.mView.j()) {
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "consume_3", "click", 1, new Object[0]);
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(getPageContext().getPageActivity(), 2, "msign", 1);
                    memberPayActivityConfig.setSceneId("4007001000");
                    memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_A_KEY_TO_SIGN, MemberPayStatistic.CLICK_ZONE_BOTTOM_OPENDE_RENEWALFEE_BUTTON);
                    sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
                }
            } else if (i == null) {
            } else {
                if (i.f() != null) {
                    if (i.f().appeal_status == 1) {
                        BdToast.h(getPageContext().getPageActivity(), i.f().appeal_msg, R.drawable.obfuscated_res_0x7f0809ca, 3000, true).n();
                    } else if (AntiHelper.t(getPageContext().getPageActivity(), i.f(), this.mInjectListener) != null) {
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_SIGN));
                    }
                } else if (this.mView.m().getCurrentStatus() == 2) {
                    showToast(R.string.obfuscated_res_0x7f0f11a3);
                } else {
                    if (i.o() != 0) {
                        createAlertDialog(i.p());
                        this.mDialog.show();
                    } else if (ji.z()) {
                        this.isClickAllSign = true;
                        signAllForum();
                    } else {
                        showToast(R.string.obfuscated_res_0x7f0f0c33);
                    }
                    TiebaStatic.log("signall_click");
                }
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            this.beginTime = System.currentTimeMillis();
            if (getIntent() != null && getIntent().getParcelableExtra(IntentConfig.KEY_URI) != null && !x8.g().i("MainTabActivity")) {
                this.mIsFromSchema = true;
            }
            if (this.mIsFromSchema) {
                setIsAddSwipeBackLayout(false);
            }
            super.onCreate(bundle);
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(getActivity());
                finish();
                return;
            }
            cancelNotification();
            Intent intent = getIntent();
            if (intent.hasExtra("signall_noyify_click") && intent.getBooleanExtra("signall_noyify_click", false)) {
                TiebaStatic.log("signall_noyify_click");
            }
            registerListener(this.mMemListener);
            registerListener(this.mRefreshSignStateListener);
            initData();
            initUI();
            this.creatTime = System.currentTimeMillis() - this.beginTime;
            tx5.a(getIntent(), getPageContext(), 25050);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onDestroy();
            this.isDestory = true;
            dq4 dq4Var = this.mDialog;
            if (dq4Var != null && dq4Var.isShowing()) {
                this.mDialog.dismiss();
            }
            GetForumListModel getForumListModel = this.mGetForumListModel;
            if (getForumListModel != null) {
                getForumListModel.cancelLoadData();
                this.mGetForumListModel = null;
            }
            lc8 lc8Var = this.mView;
            if (lc8Var != null && lc8Var.h() != null) {
                this.mView.h().d();
            }
            SignAllForumModel signAllForumModel = this.mSignAllForumModel;
            if (signAllForumModel != null) {
                if (signAllForumModel.isRunning) {
                    moveToBack();
                }
                this.mSignAllForumModel.cancelMessage();
                this.mSignAllForumModel = null;
            }
            GetForumListModel getForumListModel2 = this.mGetForumListModel;
            if (getForumListModel2 != null) {
                getForumListModel2.cancelLoadData();
                this.mGetForumListModel = null;
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public nn onGetPreLoadListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            lc8 lc8Var = this.mView;
            if (lc8Var == null || lc8Var.k() == null) {
                return null;
            }
            return this.mView.k().getPreLoadHandle();
        }
        return (nn) invokeV.objValue;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
        fc8 fc8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) || this.mView.h().getItemViewType(i) != 0 || this.mView.i() == null || this.mView.i().k() == null || this.mView.i().k().size() <= i || (fc8Var = this.mView.i().k().get(i)) == null) {
            return;
        }
        sendMessage(new CustomMessage(2003000, new FrsActivityConfig(getPageContext().getPageActivity()).createNormalCfg(fc8Var.d(), "SignTogetherPage").setCallFrom(6)));
        TiebaStatic.log("signall_frs_click");
    }

    @Override // com.repackage.ft4.g
    public void onListPullRefresh(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.refrehStartTime = System.currentTimeMillis();
            if (!ji.z()) {
                showToast(R.string.obfuscated_res_0x7f0f0c33);
                this.mView.e();
                return;
            }
            GetForumListModel getForumListModel = this.mGetForumListModel;
            if (getForumListModel == null) {
                showToast(R.string.obfuscated_res_0x7f0f0c33);
            } else if (getForumListModel.loadData()) {
            } else {
                this.mView.e();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onStop();
            SignAllForumModel signAllForumModel = this.mSignAllForumModel;
            if (signAllForumModel == null || !signAllForumModel.isRunning) {
                return;
            }
            moveToBack();
        }
    }
}
