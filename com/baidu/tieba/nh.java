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
public class nh {
    public static /* synthetic */ Interceptable $ic;
    public static volatile nh j;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<String, ug> a;
    public final hh b;
    public String c;
    public ng d;
    public ph e;
    public f f;
    public og g;
    public Handler h;
    public qh i;

    /* loaded from: classes7.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nh a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(nh nhVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nhVar, looper};
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
            this.a = nhVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 6) {
                for (Map.Entry entry : this.a.a.entrySet()) {
                    ug ugVar = (ug) entry.getValue();
                    if (ugVar.u() > 0) {
                        this.a.y(ugVar, true, true);
                    }
                    if (ugVar.t() > 0) {
                        kh.c(ugVar, true, true, true);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends DiskFileOperate {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ug a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ boolean c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(nh nhVar, String str, String str2, String str3, String str4, DiskFileOperate.Action action, ug ugVar, boolean z, boolean z2) {
            super(str, str2, str3, str4, action);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {nhVar, str, str2, str3, str4, action, ugVar, Boolean.valueOf(z), Boolean.valueOf(z2)};
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
            this.a = ugVar;
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
                    dh.m().r(this.a, this.b, true, this.c);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends DiskFileOperate {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ug a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(nh nhVar, String str, String str2, String str3, String str4, DiskFileOperate.Action action, ug ugVar) {
            super(str, str2, str3, str4, action);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {nhVar, str, str2, str3, str4, action, ugVar};
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
            this.a = ugVar;
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
    public class d extends ac {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ug c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(nh nhVar, String str, String str2, DiskFileOperate.Action action, ug ugVar) {
            super(str, str2, action);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nhVar, str, str2, action, ugVar};
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
            this.c = ugVar;
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
    public class e implements qh {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nh a;

        public e(nh nhVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nhVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nhVar;
        }

        @Override // com.baidu.tieba.qh
        public void a(ug ugVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ugVar) == null) {
                if (this.a.o(ugVar)) {
                    this.a.z(ugVar);
                }
                if (this.a.m(ugVar)) {
                    this.a.u(ugVar);
                }
                if (this.a.n(ugVar)) {
                    this.a.x(ugVar);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nh this$0;

        public f(nh nhVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nhVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = nhVar;
        }

        public /* synthetic */ f(nh nhVar, a aVar) {
            this(nhVar);
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

    public nh() {
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
        this.b = new hh();
        this.h = new a(this, Looper.getMainLooper());
        this.i = new e(this);
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            for (Map.Entry<String, ug> entry : this.a.entrySet()) {
                ug value = entry.getValue();
                z(value);
                u(value);
            }
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            for (Map.Entry<String, ug> entry : this.a.entrySet()) {
                ug value = entry.getValue();
                B(value);
                w(value);
            }
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            for (Map.Entry<String, ug> entry : this.a.entrySet()) {
                ug value = entry.getValue();
                B(value);
                y(value, false, false);
                w(value);
            }
        }
    }

    public void B(ug ugVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ugVar) != null) || ugVar == null) {
            return;
        }
        if (ugVar.l() > 0) {
            A(ugVar, true);
        } else if (ugVar.v() > 0) {
            oh.b(ugVar);
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
            ug j2 = i().j(str);
            B(j2);
            y(j2, false, true);
            w(j2);
        }
    }

    public void u(ug ugVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, ugVar) == null) {
            v(ugVar, false);
        }
    }

    public void w(ug ugVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048597, this, ugVar) != null) || ugVar == null) {
            return;
        }
        if (ugVar.m() > 0) {
            v(ugVar, true);
        } else if (ugVar.t() > 0) {
            kh.c(ugVar, false, false, false);
        }
    }

    public void z(ug ugVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, ugVar) == null) {
            A(ugVar, false);
        }
    }

    public final void A(ug ugVar, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048576, this, ugVar, z) != null) || ugVar == null) {
            return;
        }
        if (oh.a(ugVar) > UploadTask.SIZE_LIMIT_DEFAULT) {
            oh.b(ugVar);
        }
        oh.c(ugVar, z);
    }

    public final void v(ug ugVar, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048596, this, ugVar, z) != null) || ugVar == null) {
            return;
        }
        if (kh.b(ugVar) > ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT) {
            kh.c(ugVar, false, false, false);
        }
        kh.d(ugVar, z);
    }

    public static nh i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (j == null) {
                synchronized (nh.class) {
                    if (j == null) {
                        j = new nh();
                    }
                }
            }
            return j;
        }
        return (nh) invokeV.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.e == null) {
                this.e = new ph();
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
        ug j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, str2, str3, str4, bdStatsItem, objArr}) == null) {
            if (str == null && str2 == null) {
                return;
            }
            if ((bdStatsItem != null || (objArr != null && objArr.length != 0)) && (j2 = j(str)) != null && ah.o().v(str, str2)) {
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
                    bdStatsItem.append("net", pg.a(BdBaseApplication.getInst()));
                }
                if (!str.equals("stat") && !str.equals("pfmonitor")) {
                    bdStatsItem.append("pid", Integer.valueOf(Process.myPid()));
                    if (BdStatisticsManager.getInstance().isMainProcess()) {
                        bdStatsItem.append("ismainproc", "1");
                    } else {
                        bdStatsItem.append("ismainproc", "0");
                    }
                }
                rh a2 = this.b.a();
                if (a2 != null) {
                    bdStatsItem.append("cold_session_id", Long.valueOf(a2.b()));
                    bdStatsItem.append("cold_session_index", Long.valueOf(a2.c()));
                    bdStatsItem.append("cold_session_pid", a2.a());
                }
                if (rg.e() && rg.d(j2)) {
                    bdStatsItem.generateTrackLogInfo(this.g);
                    j2.c(bdStatsItem);
                }
                if (ah.o().u(str, str2)) {
                    j2.a(bdStatsItem);
                } else {
                    j2.b(bdStatsItem);
                }
                tg.e(j2, bdStatsItem);
            }
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            for (Map.Entry<String, ug> entry : this.a.entrySet()) {
                ug value = entry.getValue();
                ng ngVar = this.d;
                if (ngVar != null) {
                    long logUploadTime = ngVar.getLogUploadTime(value.o());
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
                        oh.b(value);
                    } else if (System.currentTimeMillis() - value.w() >= BdStatisticsManager.getInstance().getUploadInterval()) {
                        oh.b(value);
                    }
                    if (value.m() > 0) {
                        v(value, false);
                    }
                    if (value.t() > ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT) {
                        kh.c(value, false, false, false);
                    } else if (System.currentTimeMillis() - value.w() >= BdStatisticsManager.getInstance().getUploadInterval()) {
                        kh.c(value, false, false, false);
                    }
                }
            }
        }
    }

    public synchronized ug j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                String g = ug.g(str);
                ug ugVar = this.a.get(g);
                if (ugVar == null) {
                    if ("alert".equals(g)) {
                        ugVar = new gh(null);
                    } else if ("error".equals(g)) {
                        ugVar = new jh(this.i);
                    } else if ("dbg".equals(g)) {
                        ugVar = new ih(this.i);
                    } else if ("stat".equals(g)) {
                        ugVar = new mh(this.i);
                    } else if ("pfmonitor".equals(g)) {
                        ugVar = new lh(this.i);
                    } else {
                        ugVar = new jh(this.i);
                    }
                    ugVar.I(g);
                    this.a.put(g, ugVar);
                }
                return ugVar;
            }
        }
        return (ug) invokeL.objValue;
    }

    public void l(og ogVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, ogVar) == null) {
            if (this.f == null) {
                this.f = new f(this, null);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("adp.bdstatisticsmanager.account_changed");
                BdBaseApplication.getInst().registerReceiver(this.f, intentFilter);
            }
            this.d = BdStatisticsManager.getInstance().getBdLogSetting();
            this.g = ogVar;
        }
    }

    public final boolean m(ug ugVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, ugVar)) == null) {
            boolean z = false;
            if (ugVar == null) {
                return false;
            }
            if (System.currentTimeMillis() - ugVar.i() >= 60000) {
                z = true;
            }
            if (ah.o().s(ugVar.o())) {
                z = true;
            }
            if (ugVar.m() >= 10) {
                return true;
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public final boolean n(ug ugVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, ugVar)) == null) {
            boolean z = false;
            if (ugVar == null) {
                return false;
            }
            if (System.currentTimeMillis() - ugVar.j() >= 60000) {
                z = true;
            }
            if (ah.o().s(ugVar.o())) {
                z = true;
            }
            if (ugVar.n() >= 10) {
                return true;
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            for (Map.Entry<String, ug> entry : this.a.entrySet()) {
                ug value = entry.getValue();
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

    public final boolean o(ug ugVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, ugVar)) == null) {
            boolean z = false;
            if (ugVar == null || !rg.e() || !rg.d(ugVar)) {
                return false;
            }
            if (System.currentTimeMillis() - ugVar.k() >= 60000) {
                z = true;
            }
            if (ah.o().s(ugVar.o())) {
                z = true;
            }
            if (ugVar.l() >= 10) {
                return true;
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public void x(ug ugVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048598, this, ugVar) == null) && ugVar != null && ugVar.n() != 0) {
            if (ugVar.u() > ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT) {
                c cVar = new c(this, BdStatisticsManager.getInstance().getNotUploadWriteDir(), ugVar.s(), BdStatisticsManager.getInstance().getNotUploadWriteDir(), ugVar.r(), DiskFileOperate.Action.RENAME, ugVar);
                cVar.setSdCard(ugVar.E());
                cVar.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
                vb.f().a(cVar);
            }
            d dVar = new d(this, BdStatisticsManager.getInstance().getNotUploadWriteDir(), ugVar.s(), DiskFileOperate.Action.APPEND, ugVar);
            dVar.setSdCard(ugVar.E());
            dVar.b(ugVar.y().toString());
            ugVar.e();
            if (!ugVar.A()) {
                dVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
                dVar.setTrySuccessWeight(3);
            }
            vb.f().a(dVar);
        }
    }

    public void y(ug ugVar, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{ugVar, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && ugVar != null && ugVar.u() > 0) {
            b bVar = new b(this, BdStatisticsManager.getInstance().getNotUploadWriteDir(), ugVar.s(), BdStatisticsManager.getInstance().getNotUploadWriteDir(), ugVar.r(), DiskFileOperate.Action.RENAME, ugVar, z, z2);
            bVar.setSdCard(ugVar.E());
            bVar.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
            vb.f().a(bVar);
        }
    }
}
