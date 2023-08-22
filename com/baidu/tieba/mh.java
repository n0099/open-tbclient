package com.baidu.tieba;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.BdStatsItem;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.statistic.ConfigSpeedStat;
import com.baidu.searchbox.retrieve.core.task.UploadTask;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes7.dex */
public class mh {
    public static /* synthetic */ Interceptable $ic;
    public static volatile mh j;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<String, tg> a;
    public final gh b;
    public String c;
    public mg d;
    public oh e;
    public f f;
    public ng g;
    public Handler h;
    public ph i;

    /* loaded from: classes7.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mh a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(mh mhVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mhVar, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mhVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 6) {
                for (Map.Entry entry : this.a.a.entrySet()) {
                    tg tgVar = (tg) entry.getValue();
                    if (tgVar.u() > 0) {
                        this.a.y(tgVar, true, true);
                    }
                    if (tgVar.t() > 0) {
                        jh.c(tgVar, true, true, true);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends DiskFileOperate {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tg a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ boolean c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(mh mhVar, String str, String str2, String str3, String str4, DiskFileOperate.Action action, tg tgVar, boolean z, boolean z2) {
            super(str, str2, str3, str4, action);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {mhVar, str, str2, str3, str4, action, tgVar, Boolean.valueOf(z), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (String) objArr2[1], (String) objArr2[2], (String) objArr2[3], (DiskFileOperate.Action) objArr2[4]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tgVar;
            this.b = z;
            this.c = z2;
        }

        @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
        public void callback(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                super.callback(z);
                if (z) {
                    this.a.H(0L);
                    ch.m().r(this.a, this.b, true, this.c);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends DiskFileOperate {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tg a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(mh mhVar, String str, String str2, String str3, String str4, DiskFileOperate.Action action, tg tgVar) {
            super(str, str2, str3, str4, action);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {mhVar, str, str2, str3, str4, action, tgVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (String) objArr2[1], (String) objArr2[2], (String) objArr2[3], (DiskFileOperate.Action) objArr2[4]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tgVar;
        }

        @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
        public void callback(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                super.callback(z);
                if (z) {
                    this.a.H(0L);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends zb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tg c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(mh mhVar, String str, String str2, DiskFileOperate.Action action, tg tgVar) {
            super(str, str2, action);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mhVar, str, str2, action, tgVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (String) objArr2[1], (DiskFileOperate.Action) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = tgVar;
        }

        @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
        public void callback(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                super.callback(z);
                if (z) {
                    this.c.H(getFileInfo().length());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements ph {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mh a;

        public e(mh mhVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mhVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mhVar;
        }

        @Override // com.baidu.tieba.ph
        public void a(tg tgVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, tgVar) == null) {
                if (this.a.o(tgVar)) {
                    this.a.z(tgVar);
                }
                if (this.a.m(tgVar)) {
                    this.a.u(tgVar);
                }
                if (this.a.n(tgVar)) {
                    this.a.x(tgVar);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mh this$0;

        public f(mh mhVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mhVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = mhVar;
        }

        public /* synthetic */ f(mh mhVar, a aVar) {
            this(mhVar);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLL(1048576, this, context, intent) != null) || intent == null) {
                return;
            }
            this.this$0.C(intent.getStringExtra("intent_data_userid"));
            this.this$0.p();
        }
    }

    public mh() {
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
        this.a = new ConcurrentHashMap<>();
        this.b = new gh();
        this.h = new a(this, Looper.getMainLooper());
        this.i = new e(this);
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            for (Map.Entry<String, tg> entry : this.a.entrySet()) {
                tg value = entry.getValue();
                z(value);
                u(value);
            }
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            for (Map.Entry<String, tg> entry : this.a.entrySet()) {
                tg value = entry.getValue();
                B(value);
                w(value);
            }
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            for (Map.Entry<String, tg> entry : this.a.entrySet()) {
                tg value = entry.getValue();
                B(value);
                y(value, false, false);
                w(value);
            }
        }
    }

    public void B(tg tgVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tgVar) != null) || tgVar == null) {
            return;
        }
        if (tgVar.l() > 0) {
            A(tgVar, true);
        } else if (tgVar.v() > 0) {
            nh.b(tgVar);
        }
    }

    public void C(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.c = str;
        }
    }

    public void r(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            tg j2 = i().j(str);
            B(j2);
            y(j2, false, true);
            w(j2);
        }
    }

    public void u(tg tgVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, tgVar) == null) {
            v(tgVar, false);
        }
    }

    public void w(tg tgVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048597, this, tgVar) != null) || tgVar == null) {
            return;
        }
        if (tgVar.m() > 0) {
            v(tgVar, true);
        } else if (tgVar.t() > 0) {
            jh.c(tgVar, false, false, false);
        }
    }

    public void z(tg tgVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, tgVar) == null) {
            A(tgVar, false);
        }
    }

    public final void A(tg tgVar, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048576, this, tgVar, z) != null) || tgVar == null) {
            return;
        }
        if (nh.a(tgVar) > UploadTask.SIZE_LIMIT_DEFAULT) {
            nh.b(tgVar);
        }
        nh.c(tgVar, z);
    }

    public final void v(tg tgVar, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048596, this, tgVar, z) != null) || tgVar == null) {
            return;
        }
        if (jh.b(tgVar) > ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT) {
            jh.c(tgVar, false, false, false);
        }
        jh.d(tgVar, z);
    }

    public static mh i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (j == null) {
                synchronized (mh.class) {
                    if (j == null) {
                        j = new mh();
                    }
                }
            }
            return j;
        }
        return (mh) invokeV.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.e == null) {
                this.e = new oh();
            }
            this.e.a();
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            Message obtainMessage = this.h.obtainMessage();
            obtainMessage.what = 6;
            this.h.removeMessages(6);
            this.h.sendMessageDelayed(obtainMessage, 3000L);
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            Message obtainMessage = this.h.obtainMessage();
            obtainMessage.what = 6;
            this.h.removeMessages(6);
            this.h.sendMessage(obtainMessage);
        }
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.c;
        }
        return (String) invokeV.objValue;
    }

    public void D(String str, String str2, String str3, String str4, BdStatsItem bdStatsItem, Object... objArr) {
        tg j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, str2, str3, str4, bdStatsItem, objArr}) == null) {
            if (str == null && str2 == null) {
                return;
            }
            if ((bdStatsItem != null || (objArr != null && objArr.length != 0)) && (j2 = j(str)) != null && zg.o().v(str, str2)) {
                if (bdStatsItem == null) {
                    bdStatsItem = new BdStatsItem(str);
                }
                if (!str.equals("stat") && !str.equals("crash")) {
                    bdStatsItem.append("module", str, "st", str2, "t", String.valueOf(System.currentTimeMillis()));
                }
                if (objArr != null && objArr.length > 0) {
                    bdStatsItem.append(objArr);
                }
                if (this.c != null && !str.equals("stat")) {
                    bdStatsItem.append("uid", this.c);
                }
                if (str3 != null && !str.equals("stat")) {
                    bdStatsItem.append("c_logid", str3);
                }
                if (!TextUtils.isEmpty(str4) && !str.equals("stat")) {
                    bdStatsItem.append(PushConstants.SEQ_ID, str4);
                }
                if (!str.equals("stat")) {
                    bdStatsItem.append("net", og.a(BdBaseApplication.getInst()));
                }
                if (!str.equals("stat") && !str.equals("pfmonitor")) {
                    bdStatsItem.append("pid", Integer.valueOf(Process.myPid()));
                    if (BdStatisticsManager.getInstance().isMainProcess()) {
                        bdStatsItem.append("ismainproc", "1");
                    } else {
                        bdStatsItem.append("ismainproc", "0");
                    }
                }
                qh a2 = this.b.a();
                if (a2 != null) {
                    bdStatsItem.append("cold_session_id", Long.valueOf(a2.b()));
                    bdStatsItem.append("cold_session_index", Long.valueOf(a2.c()));
                    bdStatsItem.append("cold_session_pid", a2.a());
                }
                if (qg.e() && qg.d(j2)) {
                    bdStatsItem.generateTrackLogInfo(this.g);
                    j2.c(bdStatsItem);
                }
                if (zg.o().u(str, str2)) {
                    j2.a(bdStatsItem);
                } else {
                    j2.b(bdStatsItem);
                }
                sg.e(j2, bdStatsItem);
            }
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            for (Map.Entry<String, tg> entry : this.a.entrySet()) {
                tg value = entry.getValue();
                mg mgVar = this.d;
                if (mgVar != null) {
                    long logUploadTime = mgVar.getLogUploadTime(value.o());
                    if (logUploadTime <= 0) {
                        logUploadTime = System.currentTimeMillis();
                        this.d.setLogUploadTime(value.o(), logUploadTime);
                    }
                    value.L(logUploadTime);
                }
                if (value != null) {
                    if (value.l() > 0) {
                        A(value, false);
                    }
                    if (value.v() > UploadTask.SIZE_LIMIT_DEFAULT) {
                        nh.b(value);
                    } else if (System.currentTimeMillis() - value.w() >= BdStatisticsManager.getInstance().getUploadInterval()) {
                        nh.b(value);
                    }
                    if (value.m() > 0) {
                        v(value, false);
                    }
                    if (value.t() > ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT) {
                        jh.c(value, false, false, false);
                    } else if (System.currentTimeMillis() - value.w() >= BdStatisticsManager.getInstance().getUploadInterval()) {
                        jh.c(value, false, false, false);
                    }
                }
            }
        }
    }

    public synchronized tg j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                String g = tg.g(str);
                tg tgVar = this.a.get(g);
                if (tgVar == null) {
                    if ("alert".equals(g)) {
                        tgVar = new fh(null);
                    } else if ("error".equals(g)) {
                        tgVar = new ih(this.i);
                    } else if ("dbg".equals(g)) {
                        tgVar = new hh(this.i);
                    } else if ("stat".equals(g)) {
                        tgVar = new lh(this.i);
                    } else if ("pfmonitor".equals(g)) {
                        tgVar = new kh(this.i);
                    } else {
                        tgVar = new ih(this.i);
                    }
                    tgVar.I(g);
                    this.a.put(g, tgVar);
                }
                return tgVar;
            }
        }
        return (tg) invokeL.objValue;
    }

    public void l(ng ngVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, ngVar) == null) {
            if (this.f == null) {
                this.f = new f(this, null);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("adp.bdstatisticsmanager.account_changed");
                BdBaseApplication.getInst().registerReceiver(this.f, intentFilter);
            }
            this.d = BdStatisticsManager.getInstance().getBdLogSetting();
            this.g = ngVar;
        }
    }

    public final boolean m(tg tgVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, tgVar)) == null) {
            boolean z = false;
            if (tgVar == null) {
                return false;
            }
            if (System.currentTimeMillis() - tgVar.i() >= 60000) {
                z = true;
            }
            if (zg.o().s(tgVar.o())) {
                z = true;
            }
            if (tgVar.m() >= 10) {
                return true;
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public final boolean n(tg tgVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, tgVar)) == null) {
            boolean z = false;
            if (tgVar == null) {
                return false;
            }
            if (System.currentTimeMillis() - tgVar.j() >= 60000) {
                z = true;
            }
            if (zg.o().s(tgVar.o())) {
                z = true;
            }
            if (tgVar.n() >= 10) {
                return true;
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            for (Map.Entry<String, tg> entry : this.a.entrySet()) {
                tg value = entry.getValue();
                z(value);
                u(value);
                x(value);
            }
            if (z) {
                h();
            } else {
                g();
            }
        }
    }

    public final boolean o(tg tgVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, tgVar)) == null) {
            boolean z = false;
            if (tgVar == null || !qg.e() || !qg.d(tgVar)) {
                return false;
            }
            if (System.currentTimeMillis() - tgVar.k() >= 60000) {
                z = true;
            }
            if (zg.o().s(tgVar.o())) {
                z = true;
            }
            if (tgVar.l() >= 10) {
                return true;
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public void x(tg tgVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048598, this, tgVar) == null) && tgVar != null && tgVar.n() != 0) {
            if (tgVar.u() > ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT) {
                c cVar = new c(this, BdStatisticsManager.getInstance().getNotUploadWriteDir(), tgVar.s(), BdStatisticsManager.getInstance().getNotUploadWriteDir(), tgVar.r(), DiskFileOperate.Action.RENAME, tgVar);
                cVar.setSdCard(tgVar.E());
                cVar.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
                ub.f().a(cVar);
            }
            d dVar = new d(this, BdStatisticsManager.getInstance().getNotUploadWriteDir(), tgVar.s(), DiskFileOperate.Action.APPEND, tgVar);
            dVar.setSdCard(tgVar.E());
            dVar.b(tgVar.y().toString());
            tgVar.e();
            if (!tgVar.A()) {
                dVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
                dVar.setTrySuccessWeight(3);
            }
            ub.f().a(dVar);
        }
    }

    public void y(tg tgVar, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{tgVar, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && tgVar != null && tgVar.u() > 0) {
            b bVar = new b(this, BdStatisticsManager.getInstance().getNotUploadWriteDir(), tgVar.s(), BdStatisticsManager.getInstance().getNotUploadWriteDir(), tgVar.r(), DiskFileOperate.Action.RENAME, tgVar, z, z2);
            bVar.setSdCard(tgVar.E());
            bVar.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
            ub.f().a(bVar);
        }
    }
}
