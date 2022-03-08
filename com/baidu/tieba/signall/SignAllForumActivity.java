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
import c.a.d.f.p.l;
import c.a.d.o.e.q;
import c.a.q0.r.l0.f;
import c.a.q0.r.t.a;
import c.a.r0.r3.h;
import c.a.r0.r3.j;
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
import com.baidu.tieba.flutter.base.util.OpenFlutter;
import com.baidu.tieba.signall.GetForumListModel;
import com.baidu.tieba.signall.SignAllForumModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class SignAllForumActivity extends BaseActivity<SignAllForumActivity> implements f.g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long beginTime;
    public long creatTime;
    public boolean isBack;
    public boolean isClickAllSign;
    public boolean isDestory;
    public c.a.q0.r.t.a mDialog;
    public GetForumListModel mGetForumListModel;
    public AntiHelper.k mInjectListener;
    public boolean mIsFromSchema;
    public final CustomMessageListener mMemListener;
    public GetForumListModel.b mOnGetForumListDataCallBack;
    public SignAllForumModel.a mOnSignAllForumCallback;
    public final CustomMessageListener mRefreshSignStateListener;
    public SignAllForumModel mSignAllForumModel;
    public j mView;
    public long refrehStartTime;

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SignAllForumActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(SignAllForumActivity signAllForumActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {signAllForumActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
            this.a.mView.k().setHasPrivilege(true);
        }
    }

    /* loaded from: classes6.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SignAllForumActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(SignAllForumActivity signAllForumActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {signAllForumActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
            c.a.r0.r3.c g2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof SignData) || (g2 = this.a.mView.g()) == null) {
                return;
            }
            g2.E((SignData) customResponsedMessage.getData());
            this.a.mView.f().notifyDataSetChanged();
        }
    }

    /* loaded from: classes6.dex */
    public class c implements GetForumListModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SignAllForumActivity a;

        /* loaded from: classes6.dex */
        public class a implements MessageQueue.IdleHandler {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ long a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ long f46494b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ c f46495c;

            public a(c cVar, long j2, long j3) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, Long.valueOf(j2), Long.valueOf(j3)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f46495c = cVar;
                this.a = j2;
                this.f46494b = j3;
            }

            @Override // android.os.MessageQueue.IdleHandler
            public boolean queueIdle() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    this.f46495c.a.logCostTimeLog(this.a, this.f46494b);
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = signAllForumActivity;
        }

        @Override // com.baidu.tieba.signall.GetForumListModel.b
        public void a(c.a.r0.r3.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                this.a.mView.d();
                c.a.r0.r3.a i2 = cVar.i();
                if (i2 != null) {
                    if (i2.a() == 0) {
                        this.a.mView.m(cVar, this.a.mGetForumListModel.D());
                    } else {
                        this.a.showToast(i2.b(), false);
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
                this.a.mView.d();
                this.a.showToast(str, false);
                this.a.finish();
            }
        }
    }

    /* loaded from: classes6.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = signAllForumActivity;
        }

        @Override // com.baidu.tieba.signall.SignAllForumModel.a
        public void a(h hVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, hVar) == null) || hVar == null) {
                return;
            }
            if (hVar.a() == 3250013 && this.a.isClickAllSign) {
                this.a.isClickAllSign = false;
                BdToast.h(TbadkCoreApplication.getInst().getContext(), hVar.c(), R.drawable.icon_pure_toast_mistake40_svg, 3000, true).q();
                if (this.a.mView == null || this.a.mView.k() == null) {
                    return;
                }
                this.a.mView.k().setSignBefore(0);
                return;
            }
            c.a.r0.r3.a b2 = hVar.b();
            if (b2 != null) {
                if (b2.a() == 0) {
                    c.a.r0.r3.c g2 = this.a.mView.g();
                    g2.D(hVar);
                    if (this.a.isBack) {
                        Intent intent = new Intent(this.a.getPageContext().getPageActivity(), SignAllForumActivity.class);
                        intent.addFlags(805306368);
                        intent.putExtra("signall_noyify_click", true);
                        this.a.showNotification(this.a.getPageContext().getPageActivity().getString(R.string.signallforum_back_finish, new Object[]{Integer.valueOf(g2.s()), Integer.valueOf(g2.j())}), PendingIntent.getActivity(this.a.getPageContext().getPageActivity(), 0, intent, 134217728), false);
                        if (this.a.isDestory) {
                            return;
                        }
                    }
                    this.a.mView.f().notifyDataSetChanged();
                    SignAllForumProgressView k = this.a.mView.k();
                    if (!g2.A()) {
                        if (hVar.h() != 0) {
                            this.a.createAlertDialog(hVar.f());
                            this.a.mDialog.show();
                        } else if (hVar.e() != 0) {
                            this.a.showToast(hVar.g());
                        } else {
                            this.a.showToast(R.string.signallforum_error);
                        }
                    }
                    if (this.a.mDialog == null || !this.a.mDialog.isShowing()) {
                        this.a.checkAndShowTimePicker();
                    }
                    k.setSignSuccess();
                    this.a.showAdvert(g2);
                    return;
                }
                this.a.signFailed(b2.b());
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

    /* loaded from: classes6.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = signAllForumActivity;
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(c.a.q0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_SIGN));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(c.a.q0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_SIGN));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f46496e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46497f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f46498g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ SignAllForumActivity f46499h;

        public f(SignAllForumActivity signAllForumActivity, String str, String str2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {signAllForumActivity, str, str2, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46499h = signAllForumActivity;
            this.f46496e = str;
            this.f46497f = str2;
            this.f46498g = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f46499h.sendMessage(new CustomMessage(2002001, new SignAllForumAdvertActivityConfig(this.f46499h.getPageContext().getPageActivity(), this.f46496e, this.f46497f, Boolean.valueOf(this.f46498g))));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SignAllForumActivity f46500e;

        public g(SignAllForumActivity signAllForumActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {signAllForumActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46500e = signAllForumActivity;
        }

        @Override // c.a.q0.r.t.a.e
        public void onClick(c.a.q0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    public SignAllForumActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            NotificationHelper.cancelNotification(getPageContext().getPageActivity(), R.drawable.singnallforum_progress);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkAndShowTimePicker() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65553, this) == null) || this.mView == null) {
            return;
        }
        c.a.q0.s.d.f.c().a(getPageContext(), this.mView.l());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createAlertDialog(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, this, str) == null) {
            c.a.q0.r.t.a positiveButton = new c.a.q0.r.t.a(getPageContext().getPageActivity()).setMessage(str).setPositiveButton(R.string.signallforum_signnow, new g(this));
            this.mDialog = positiveButton;
            positiveButton.create(getPageContext());
        }
    }

    private void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, this) == null) {
            GetForumListModel getForumListModel = new GetForumListModel(this);
            this.mGetForumListModel = getForumListModel;
            getForumListModel.E(this.mOnGetForumListDataCallBack);
            SignAllForumModel signAllForumModel = new SignAllForumModel(this);
            this.mSignAllForumModel = signAllForumModel;
            signAllForumModel.E(this.mOnSignAllForumCallback);
        }
    }

    private void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65556, this) == null) {
            j jVar = new j(this);
            this.mView = jVar;
            jVar.n(this);
            this.mView.p(this);
            SignAllForumModel signAllForumModel = this.mSignAllForumModel;
            if (signAllForumModel.isRunning) {
                this.mOnGetForumListDataCallBack.a(signAllForumModel.C());
                this.mView.k().setSigning(90);
                return;
            }
            this.mView.q();
        }
    }

    private void moveToBack() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65557, this) == null) {
            this.isBack = true;
            Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
            intent.addFlags(805306368);
            showNotification(getPageContext().getString(R.string.signallforum_back_signing), PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728), true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showAdvert(c.a.r0.r3.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65558, this, cVar) == null) || cVar == null) {
            return;
        }
        String d2 = cVar.d();
        String e2 = cVar.e();
        boolean B = cVar.B();
        if (cVar.C()) {
            this.mView.o(0);
            new Handler().postDelayed(new f(this, d2, e2, B), 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNotification(String str, PendingIntent pendingIntent, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65559, this, str, pendingIntent, z) == null) {
            NotificationHelper.showNotification(getPageContext().getPageActivity(), R.drawable.singnallforum_progress, getPageContext().getString(R.string.app_name), str, str, pendingIntent, z);
        }
    }

    private void signAllForum() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65560, this) == null) {
            c.a.r0.r3.c g2 = this.mView.g();
            this.mView.k().setDuration(Math.max(g2.x().size() * 50, 2000));
            this.mView.k().setSigning(0);
            this.mSignAllForumModel.D(g2);
            this.mSignAllForumModel.loadData();
            this.mView.f().notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void signFailed(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65561, this, str) == null) {
            if (this.isBack) {
                c.a.r0.r3.c g2 = this.mView.g();
                Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
                intent.addFlags(805306368);
                intent.putExtra("signall_noyify_click", true);
                PendingIntent activity = PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728);
                str = getPageContext().getPageActivity().getString(R.string.signallforum_back_finish, new Object[]{0, Integer.valueOf(g2.x().size())});
                showNotification(str, activity, false);
                if (this.isDestory) {
                    return;
                }
            }
            showToast(str);
            this.mView.k().setSignSuccess();
            ArrayList<c.a.r0.r3.d> x = this.mView.g().x();
            int size = x.size();
            for (int i2 = 0; i2 < size; i2++) {
                c.a.r0.r3.d dVar = x.get(i2);
                dVar.s(true);
                dVar.t(false);
                dVar.u(false);
            }
            this.mView.f().notifyDataSetChanged();
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

    @Override // com.baidu.tbadk.BaseActivity, c.a.q0.p0.a
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "a022" : (String) invokeV.objValue;
    }

    public void logCostTimeLog(long j2, long j3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) && PerformanceLoggerHelper.getInstance().isSmallFlow() && this.creatTime > 0) {
            new c.a.q0.r0.h(1009, true, this.mGetForumListModel.getResponsedMessage(), 0L, this.creatTime, j3, false, 0L, 0L, j2).c();
            this.creatTime = 0L;
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        j jVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048580, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i3 == -1 && i2 == 25050 && (jVar = this.mView) != null) {
                jVar.q();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            super.onChangeSkinType(i2);
            this.mView.onChangeSkinType(i2);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view) == null) {
            c.a.r0.r3.c g2 = this.mView.g();
            if (view != this.mView.j()) {
                if (view == this.mView.h()) {
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "consume_3", "click", 1, new Object[0]);
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(getPageContext().getPageActivity(), 2, "msign", 1);
                    memberPayActivityConfig.setSceneId("4007001000");
                    memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_A_KEY_TO_SIGN, MemberPayStatistic.CLICK_ZONE_BOTTOM_OPENDE_RENEWALFEE_BUTTON);
                    sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
                }
            } else if (g2 == null) {
            } else {
                if (g2.f() != null) {
                    if (g2.f().appeal_status == 1) {
                        BdToast.h(getPageContext().getPageActivity(), g2.f().appeal_msg, R.drawable.icon_pure_toast_mistake40_svg, 3000, true).q();
                    } else if (AntiHelper.t(getPageContext().getPageActivity(), g2.f(), this.mInjectListener) != null) {
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_SIGN));
                    }
                } else if (this.mView.k().getCurrentStatus() == 2) {
                    showToast(R.string.signallforum_finished);
                } else {
                    if (g2.o() != 0) {
                        createAlertDialog(g2.p());
                        this.mDialog.show();
                    } else if (l.z()) {
                        this.isClickAllSign = true;
                        signAllForum();
                    } else {
                        showToast(R.string.neterror);
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
            if (getIntent() != null && getIntent().getParcelableExtra(IntentConfig.KEY_URI) != null && !c.a.d.a.b.g().i("MainTabActivity")) {
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
            c.a.r0.j0.a.a(getIntent(), getPageContext(), 25050);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onDestroy();
            this.isDestory = true;
            c.a.q0.r.t.a aVar = this.mDialog;
            if (aVar != null && aVar.isShowing()) {
                this.mDialog.dismiss();
            }
            GetForumListModel getForumListModel = this.mGetForumListModel;
            if (getForumListModel != null) {
                getForumListModel.cancelLoadData();
                this.mGetForumListModel = null;
            }
            j jVar = this.mView;
            if (jVar != null && jVar.f() != null) {
                this.mView.f().d();
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
    public q onGetPreLoadListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            j jVar = this.mView;
            if (jVar == null || jVar.i() == null) {
                return null;
            }
            return this.mView.i().getPreLoadHandle();
        }
        return (q) invokeV.objValue;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        c.a.r0.r3.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || this.mView.f().getItemViewType(i2) != 0 || this.mView.g() == null || this.mView.g().k() == null || this.mView.g().k().size() <= i2 || (dVar = this.mView.g().k().get(i2)) == null) {
            return;
        }
        sendMessage(new CustomMessage(2003000, new FrsActivityConfig(getPageContext().getPageActivity()).createNormalCfg(dVar.d(), OpenFlutter.ACTIVITY_SIGN_TOGETHER).setCallFrom(6)));
        TiebaStatic.log("signall_frs_click");
    }

    @Override // c.a.q0.r.l0.f.g
    public void onListPullRefresh(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.refrehStartTime = System.currentTimeMillis();
            if (!l.z()) {
                showToast(R.string.neterror);
                this.mView.d();
                return;
            }
            GetForumListModel getForumListModel = this.mGetForumListModel;
            if (getForumListModel == null) {
                showToast(R.string.neterror);
            } else if (getForumListModel.loadData()) {
            } else {
                this.mView.d();
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
