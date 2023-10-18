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
/* loaded from: classes6.dex */
public class jc {
    public static /* synthetic */ Interceptable $ic;
    public static volatile jc j;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<String, qb> a;
    public final dc b;
    public String c;
    public jb d;
    public lc e;
    public f f;
    public kb g;
    public Handler h;
    public mc i;

    /* loaded from: classes6.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jc a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(jc jcVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jcVar, looper};
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
            this.a = jcVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 6) {
                for (Map.Entry entry : this.a.a.entrySet()) {
                    qb qbVar = (qb) entry.getValue();
                    if (qbVar.u() > 0) {
                        this.a.y(qbVar, true, true);
                    }
                    if (qbVar.t() > 0) {
                        gc.c(qbVar, true, true, true);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends DiskFileOperate {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qb a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ boolean c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(jc jcVar, String str, String str2, String str3, String str4, DiskFileOperate.Action action, qb qbVar, boolean z, boolean z2) {
            super(str, str2, str3, str4, action);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {jcVar, str, str2, str3, str4, action, qbVar, Boolean.valueOf(z), Boolean.valueOf(z2)};
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
            this.a = qbVar;
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
                    zb.m().r(this.a, this.b, true, this.c);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends DiskFileOperate {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qb a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(jc jcVar, String str, String str2, String str3, String str4, DiskFileOperate.Action action, qb qbVar) {
            super(str, str2, str3, str4, action);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {jcVar, str, str2, str3, str4, action, qbVar};
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
            this.a = qbVar;
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

    /* loaded from: classes6.dex */
    public class d extends y6 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qb c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(jc jcVar, String str, String str2, DiskFileOperate.Action action, qb qbVar) {
            super(str, str2, action);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jcVar, str, str2, action, qbVar};
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
            this.c = qbVar;
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

    /* loaded from: classes6.dex */
    public class e implements mc {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jc a;

        public e(jc jcVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jcVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jcVar;
        }

        @Override // com.baidu.tieba.mc
        public void a(qb qbVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, qbVar) == null) {
                if (this.a.o(qbVar)) {
                    this.a.z(qbVar);
                }
                if (this.a.m(qbVar)) {
                    this.a.u(qbVar);
                }
                if (this.a.n(qbVar)) {
                    this.a.x(qbVar);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jc this$0;

        public f(jc jcVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jcVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = jcVar;
        }

        public /* synthetic */ f(jc jcVar, a aVar) {
            this(jcVar);
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

    public jc() {
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
        this.b = new dc();
        this.h = new a(this, Looper.getMainLooper());
        this.i = new e(this);
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            for (Map.Entry<String, qb> entry : this.a.entrySet()) {
                qb value = entry.getValue();
                z(value);
                u(value);
            }
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            for (Map.Entry<String, qb> entry : this.a.entrySet()) {
                qb value = entry.getValue();
                B(value);
                w(value);
            }
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            for (Map.Entry<String, qb> entry : this.a.entrySet()) {
                qb value = entry.getValue();
                B(value);
                y(value, false, false);
                w(value);
            }
        }
    }

    public void B(qb qbVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qbVar) != null) || qbVar == null) {
            return;
        }
        if (qbVar.l() > 0) {
            A(qbVar, true);
        } else if (qbVar.v() > 0) {
            kc.b(qbVar);
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
            qb j2 = i().j(str);
            B(j2);
            y(j2, false, true);
            w(j2);
        }
    }

    public void u(qb qbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, qbVar) == null) {
            v(qbVar, false);
        }
    }

    public void w(qb qbVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048597, this, qbVar) != null) || qbVar == null) {
            return;
        }
        if (qbVar.m() > 0) {
            v(qbVar, true);
        } else if (qbVar.t() > 0) {
            gc.c(qbVar, false, false, false);
        }
    }

    public void z(qb qbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, qbVar) == null) {
            A(qbVar, false);
        }
    }

    public final void A(qb qbVar, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048576, this, qbVar, z) != null) || qbVar == null) {
            return;
        }
        if (kc.a(qbVar) > UploadTask.SIZE_LIMIT_DEFAULT) {
            kc.b(qbVar);
        }
        kc.c(qbVar, z);
    }

    public final void v(qb qbVar, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048596, this, qbVar, z) != null) || qbVar == null) {
            return;
        }
        if (gc.b(qbVar) > ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT) {
            gc.c(qbVar, false, false, false);
        }
        gc.d(qbVar, z);
    }

    public static jc i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (j == null) {
                synchronized (jc.class) {
                    if (j == null) {
                        j = new jc();
                    }
                }
            }
            return j;
        }
        return (jc) invokeV.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.e == null) {
                this.e = new lc();
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
        qb j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, str2, str3, str4, bdStatsItem, objArr}) == null) {
            if (str == null && str2 == null) {
                return;
            }
            if ((bdStatsItem != null || (objArr != null && objArr.length != 0)) && (j2 = j(str)) != null && wb.o().v(str, str2)) {
                if (bdStatsItem == null) {
                    bdStatsItem = new BdStatsItem(str);
                }
                if (!"stat".equals(str) && !"crash".equals(str)) {
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
                    bdStatsItem.append("net", lb.a(BdBaseApplication.getInst()));
                }
                if (!str.equals("stat") && !str.equals("pfmonitor")) {
                    bdStatsItem.append("pid", Integer.valueOf(Process.myPid()));
                    if (BdStatisticsManager.getInstance().isMainProcess()) {
                        bdStatsItem.append("ismainproc", "1");
                    } else {
                        bdStatsItem.append("ismainproc", "0");
                    }
                }
                nc a2 = this.b.a();
                if (a2 != null) {
                    bdStatsItem.append("cold_session_id", Long.valueOf(a2.b()));
                    bdStatsItem.append("cold_session_index", Long.valueOf(a2.c()));
                    bdStatsItem.append("cold_session_pid", a2.a());
                }
                if (nb.e() && nb.d(j2)) {
                    bdStatsItem.generateTrackLogInfo(this.g);
                    j2.c(bdStatsItem);
                }
                if (wb.o().u(str, str2)) {
                    j2.a(bdStatsItem);
                } else {
                    j2.b(bdStatsItem);
                }
                pb.e(j2, bdStatsItem);
            }
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            for (Map.Entry<String, qb> entry : this.a.entrySet()) {
                qb value = entry.getValue();
                jb jbVar = this.d;
                if (jbVar != null) {
                    long logUploadTime = jbVar.getLogUploadTime(value.o());
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
                        kc.b(value);
                    } else if (System.currentTimeMillis() - value.w() >= BdStatisticsManager.getInstance().getUploadInterval()) {
                        kc.b(value);
                    }
                    if (value.m() > 0) {
                        v(value, false);
                    }
                    if (value.t() > ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT) {
                        gc.c(value, false, false, false);
                    } else if (System.currentTimeMillis() - value.w() >= BdStatisticsManager.getInstance().getUploadInterval()) {
                        gc.c(value, false, false, false);
                    }
                }
            }
        }
    }

    public synchronized qb j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                String g = qb.g(str);
                qb qbVar = this.a.get(g);
                if (qbVar == null) {
                    if ("alert".equals(g)) {
                        qbVar = new cc(null);
                    } else if ("error".equals(g)) {
                        qbVar = new fc(this.i);
                    } else if ("dbg".equals(g)) {
                        qbVar = new ec(this.i);
                    } else if ("stat".equals(g)) {
                        qbVar = new ic(this.i);
                    } else if ("pfmonitor".equals(g)) {
                        qbVar = new hc(this.i);
                    } else {
                        qbVar = new fc(this.i);
                    }
                    qbVar.I(g);
                    this.a.put(g, qbVar);
                }
                return qbVar;
            }
        }
        return (qb) invokeL.objValue;
    }

    public void l(kb kbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, kbVar) == null) {
            if (this.f == null) {
                this.f = new f(this, null);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("adp.bdstatisticsmanager.account_changed");
                BdBaseApplication.getInst().registerReceiver(this.f, intentFilter);
            }
            this.d = BdStatisticsManager.getInstance().getBdLogSetting();
            this.g = kbVar;
        }
    }

    public final boolean m(qb qbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, qbVar)) == null) {
            boolean z = false;
            if (qbVar == null) {
                return false;
            }
            if (System.currentTimeMillis() - qbVar.i() >= 60000) {
                z = true;
            }
            if (wb.o().s(qbVar.o())) {
                z = true;
            }
            if (qbVar.m() >= 10) {
                return true;
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public final boolean n(qb qbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, qbVar)) == null) {
            boolean z = false;
            if (qbVar == null) {
                return false;
            }
            if (System.currentTimeMillis() - qbVar.j() >= 60000) {
                z = true;
            }
            if (wb.o().s(qbVar.o())) {
                z = true;
            }
            if (qbVar.n() >= 10) {
                return true;
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            for (Map.Entry<String, qb> entry : this.a.entrySet()) {
                qb value = entry.getValue();
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

    public final boolean o(qb qbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, qbVar)) == null) {
            boolean z = false;
            if (qbVar == null || !nb.e() || !nb.d(qbVar)) {
                return false;
            }
            if (System.currentTimeMillis() - qbVar.k() >= 60000) {
                z = true;
            }
            if (wb.o().s(qbVar.o())) {
                z = true;
            }
            if (qbVar.l() >= 10) {
                return true;
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public void x(qb qbVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048598, this, qbVar) == null) && qbVar != null && qbVar.n() != 0) {
            if (qbVar.u() > ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT) {
                c cVar = new c(this, BdStatisticsManager.getInstance().getNotUploadWriteDir(), qbVar.s(), BdStatisticsManager.getInstance().getNotUploadWriteDir(), qbVar.r(), DiskFileOperate.Action.RENAME, qbVar);
                cVar.setSdCard(qbVar.E());
                cVar.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
                t6.g().a(cVar);
            }
            d dVar = new d(this, BdStatisticsManager.getInstance().getNotUploadWriteDir(), qbVar.s(), DiskFileOperate.Action.APPEND, qbVar);
            dVar.setSdCard(qbVar.E());
            dVar.b(qbVar.y().toString());
            qbVar.e();
            if (!qbVar.A()) {
                dVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
                dVar.setTrySuccessWeight(3);
            }
            t6.g().a(dVar);
        }
    }

    public void y(qb qbVar, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{qbVar, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && qbVar != null && qbVar.u() > 0) {
            b bVar = new b(this, BdStatisticsManager.getInstance().getNotUploadWriteDir(), qbVar.s(), BdStatisticsManager.getInstance().getNotUploadWriteDir(), qbVar.r(), DiskFileOperate.Action.RENAME, qbVar, z, z2);
            bVar.setSdCard(qbVar.E());
            bVar.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
            t6.g().a(bVar);
        }
    }
}
