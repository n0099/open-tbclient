package com.baidu.tieba.pushdialog;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.core.app.NotificationCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PushDialogActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.pushdialog.data.PullTidHttpRespMessage;
import com.baidu.tieba.pushdialog.data.PullTidReqNetMessage;
import com.baidu.tieba.pushdialog.data.PullTidSocketResponseMessage;
import com.baidu.tieba.screenlocknotify.ScreenLockActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public class PushDialogLoopManager {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static PushDialogLoopManager f49289g;
    public transient /* synthetic */ FieldHolder $fh;
    public Handler a;

    /* renamed from: b  reason: collision with root package name */
    public String f49290b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f49291c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f49292d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f49293e;

    /* renamed from: f  reason: collision with root package name */
    public AlarmManager f49294f;

    /* loaded from: classes12.dex */
    public static class PushAlarmReceiver extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public PushAlarmReceiver() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
                PushDialogLoopManager.i().o();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class a implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PushDialogLoopManager f49295e;

        public a(PushDialogLoopManager pushDialogLoopManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pushDialogLoopManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49295e = pushDialogLoopManager;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                if (message.what != 1) {
                    return false;
                }
                this.f49295e.n();
                PushDialogLoopManager.i().l();
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes12.dex */
    public class b extends c.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PushDialogLoopManager a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(PushDialogLoopManager pushDialogLoopManager, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pushDialogLoopManager, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pushDialogLoopManager;
        }

        @Override // c.a.d.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String tid;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                if (responsedMessage instanceof PullTidHttpRespMessage) {
                    tid = ((PullTidHttpRespMessage) responsedMessage).getTid();
                } else {
                    tid = responsedMessage instanceof PullTidSocketResponseMessage ? ((PullTidSocketResponseMessage) responsedMessage).getTid() : "";
                }
                if (StringUtils.isNull(tid) || responsedMessage.getError() != 0 || this.a.f49290b.equals(tid) || "0".equals(tid)) {
                    return;
                }
                this.a.f49290b = tid;
                if (c.a.t0.l3.a.j().f19640d.c()) {
                    this.a.f49291c = true;
                } else {
                    this.a.p(tid);
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class c extends c.a.d.c.g.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PushDialogLoopManager a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(PushDialogLoopManager pushDialogLoopManager, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pushDialogLoopManager, Integer.valueOf(i2)};
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
            this.a = pushDialogLoopManager;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage) == null) {
                this.a.n();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PushDialogLoopManager a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(PushDialogLoopManager pushDialogLoopManager, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pushDialogLoopManager, Integer.valueOf(i2)};
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
            this.a = pushDialogLoopManager;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.m();
            }
        }
    }

    /* loaded from: classes12.dex */
    public static class e extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) && intent != null && "android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                PushDialogLoopManager.i().j();
            }
        }

        public /* synthetic */ e(a aVar) {
            this();
        }
    }

    public PushDialogLoopManager() {
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
        this.f49290b = "";
        this.f49291c = false;
        this.f49292d = false;
        this.f49293e = false;
        Handler handler = new Handler(Looper.getMainLooper(), new a(this));
        this.a = handler;
        handler.sendEmptyMessage(1);
        MessageManager.getInstance().registerListener(new b(this, CmdConfigHttp.CMD_GET_PUSH_DIALOG_TID, 309618));
        MessageManager.getInstance().registerListener(new c(this, 1003));
        MessageManager.getInstance().registerListener(new d(this, 2001371));
        this.f49290b = c.a.s0.s.g0.b.j().p("key_push_dialog_last_show_tid", "0");
        TbadkCoreApplication.getInst().registerReceiver(new e(null), new IntentFilter("android.intent.action.SCREEN_OFF"));
        this.f49294f = (AlarmManager) TbadkCoreApplication.getInst().getApp().getSystemService(NotificationCompat.CATEGORY_ALARM);
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                TbadkCoreApplication.getInst().startService(new Intent().setClass(TbadkCoreApplication.getInst(), PushDialogJobService.class));
                this.f49293e = true;
            }
        } catch (Throwable th) {
            BdLog.e(th);
            this.f49293e = false;
        }
    }

    public static PushDialogLoopManager i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (f49289g == null) {
                synchronized (PushDialogLoopManager.class) {
                    if (f49289g == null) {
                        f49289g = new PushDialogLoopManager();
                    }
                }
            }
            return f49289g;
        }
        return (PushDialogLoopManager) invokeV.objValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f49291c && c.a.t0.l3.a.j().g() && !this.f49292d) {
            if (Build.VERSION.SDK_INT >= 21 && this.f49293e) {
                try {
                    ((JobScheduler) TbadkCoreApplication.getInst().getSystemService("jobscheduler")).schedule(new JobInfo.Builder(29467, new ComponentName(TbadkCoreApplication.getInst(), PushDialogJobService.class)).setMinimumLatency(TbSingleton.getInstance().getPushDialogShowTime()).setOverrideDeadline(TbSingleton.getInstance().getPushDialogShowTime()).setRequiredNetworkType(1).setRequiresCharging(false).setRequiresDeviceIdle(false).build());
                } catch (Throwable th) {
                    BdLog.e(th);
                    k();
                }
            } else {
                k();
            }
            this.f49292d = true;
            TiebaStatic.log(new StatisticItem("c13196").param("obj_type", 1).param("obj_source", 2).param("tid", this.f49290b));
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f49294f.set(0, System.currentTimeMillis() + TbSingleton.getInstance().getPushDialogShowTime(), PendingIntent.getBroadcast(TbadkCoreApplication.getInst().getApp(), 29467, new Intent(TbadkCoreApplication.getInst().getApp(), PushAlarmReceiver.class), 134217728));
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.a.hasMessages(1)) {
                this.a.removeMessages(1);
            }
            this.a.sendEmptyMessageDelayed(1, TbSingleton.getInstance().getPushDialogLoopTime());
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.a.removeMessages(1);
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) || TbSingleton.getInstance().getPushDialogLoopTime() <= 0) {
                return;
            }
            this.a.sendEmptyMessageDelayed(1, TbSingleton.getInstance().getPushDialogLoopTime());
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            return;
        }
        MessageManager.getInstance().sendMessage(new PullTidReqNetMessage(CmdConfigHttp.CMD_GET_PUSH_DIALOG_TID, 309618));
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f49292d = false;
            p(this.f49290b);
        }
    }

    public final void p(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || c.a.t0.l3.a.j().f19640d.c() || TbSingleton.getInstance().getLastResumeTime() > UtilHelper.getTodayZeroTime()) {
            return;
        }
        Activity b2 = c.a.d.a.b.g().b();
        if (b2 != null && b2.getClass() != null && b2.getClass().getName().equals(ScreenLockActivity.class.getName())) {
            b2.finish();
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PushDialogActivityConfig(TbadkCoreApplication.getInst(), 0L, str)));
        c.a.s0.s.g0.b.j().x("key_push_dialog_last_show_tid", str);
        this.f49291c = false;
    }
}
