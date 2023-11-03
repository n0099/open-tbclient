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
/* loaded from: classes9.dex */
public class zc {
    public static /* synthetic */ Interceptable $ic;
    public static volatile zc j;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<String, gc> a;
    public final tc b;
    public String c;
    public zb d;
    public bd e;
    public f f;
    public ac g;
    public Handler h;
    public cd i;

    /* loaded from: classes9.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zc a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(zc zcVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zcVar, looper};
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
            this.a = zcVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 6) {
                for (Map.Entry entry : this.a.a.entrySet()) {
                    gc gcVar = (gc) entry.getValue();
                    if (gcVar.u() > 0) {
                        this.a.y(gcVar, true, true);
                    }
                    if (gcVar.t() > 0) {
                        wc.c(gcVar, true, true, true);
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends DiskFileOperate {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gc a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ boolean c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(zc zcVar, String str, String str2, String str3, String str4, DiskFileOperate.Action action, gc gcVar, boolean z, boolean z2) {
            super(str, str2, str3, str4, action);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {zcVar, str, str2, str3, str4, action, gcVar, Boolean.valueOf(z), Boolean.valueOf(z2)};
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
            this.a = gcVar;
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
                    pc.m().r(this.a, this.b, true, this.c);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c extends DiskFileOperate {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gc a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(zc zcVar, String str, String str2, String str3, String str4, DiskFileOperate.Action action, gc gcVar) {
            super(str, str2, str3, str4, action);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {zcVar, str, str2, str3, str4, action, gcVar};
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
            this.a = gcVar;
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

    /* loaded from: classes9.dex */
    public class d extends o7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gc c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(zc zcVar, String str, String str2, DiskFileOperate.Action action, gc gcVar) {
            super(str, str2, action);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zcVar, str, str2, action, gcVar};
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
            this.c = gcVar;
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

    /* loaded from: classes9.dex */
    public class e implements cd {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zc a;

        public e(zc zcVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zcVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zcVar;
        }

        @Override // com.baidu.tieba.cd
        public void a(gc gcVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, gcVar) == null) {
                if (this.a.o(gcVar)) {
                    this.a.z(gcVar);
                }
                if (this.a.m(gcVar)) {
                    this.a.u(gcVar);
                }
                if (this.a.n(gcVar)) {
                    this.a.x(gcVar);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zc this$0;

        public f(zc zcVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zcVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = zcVar;
        }

        public /* synthetic */ f(zc zcVar, a aVar) {
            this(zcVar);
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

    public zc() {
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
        this.b = new tc();
        this.h = new a(this, Looper.getMainLooper());
        this.i = new e(this);
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            for (Map.Entry<String, gc> entry : this.a.entrySet()) {
                gc value = entry.getValue();
                z(value);
                u(value);
            }
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            for (Map.Entry<String, gc> entry : this.a.entrySet()) {
                gc value = entry.getValue();
                B(value);
                w(value);
            }
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            for (Map.Entry<String, gc> entry : this.a.entrySet()) {
                gc value = entry.getValue();
                B(value);
                y(value, false, false);
                w(value);
            }
        }
    }

    public void B(gc gcVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gcVar) != null) || gcVar == null) {
            return;
        }
        if (gcVar.l() > 0) {
            A(gcVar, true);
        } else if (gcVar.v() > 0) {
            ad.b(gcVar);
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
            gc j2 = i().j(str);
            B(j2);
            y(j2, false, true);
            w(j2);
        }
    }

    public void u(gc gcVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, gcVar) == null) {
            v(gcVar, false);
        }
    }

    public void w(gc gcVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048597, this, gcVar) != null) || gcVar == null) {
            return;
        }
        if (gcVar.m() > 0) {
            v(gcVar, true);
        } else if (gcVar.t() > 0) {
            wc.c(gcVar, false, false, false);
        }
    }

    public void z(gc gcVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, gcVar) == null) {
            A(gcVar, false);
        }
    }

    public final void A(gc gcVar, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048576, this, gcVar, z) != null) || gcVar == null) {
            return;
        }
        if (ad.a(gcVar) > UploadTask.SIZE_LIMIT_DEFAULT) {
            ad.b(gcVar);
        }
        ad.c(gcVar, z);
    }

    public final void v(gc gcVar, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048596, this, gcVar, z) != null) || gcVar == null) {
            return;
        }
        if (wc.b(gcVar) > ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT) {
            wc.c(gcVar, false, false, false);
        }
        wc.d(gcVar, z);
    }

    public static zc i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (j == null) {
                synchronized (zc.class) {
                    if (j == null) {
                        j = new zc();
                    }
                }
            }
            return j;
        }
        return (zc) invokeV.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.e == null) {
                this.e = new bd();
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
        gc j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, str2, str3, str4, bdStatsItem, objArr}) == null) {
            if (str == null && str2 == null) {
                return;
            }
            if ((bdStatsItem != null || (objArr != null && objArr.length != 0)) && (j2 = j(str)) != null && mc.o().v(str, str2)) {
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
                    bdStatsItem.append("net", bc.a(BdBaseApplication.getInst()));
                }
                if (!str.equals("stat") && !str.equals("pfmonitor")) {
                    bdStatsItem.append("pid", Integer.valueOf(Process.myPid()));
                    if (BdStatisticsManager.getInstance().isMainProcess()) {
                        bdStatsItem.append("ismainproc", "1");
                    } else {
                        bdStatsItem.append("ismainproc", "0");
                    }
                }
                dd a2 = this.b.a();
                if (a2 != null) {
                    bdStatsItem.append("cold_session_id", Long.valueOf(a2.b()));
                    bdStatsItem.append("cold_session_index", Long.valueOf(a2.c()));
                    bdStatsItem.append("cold_session_pid", a2.a());
                }
                if (dc.e() && dc.d(j2)) {
                    bdStatsItem.generateTrackLogInfo(this.g);
                    j2.c(bdStatsItem);
                }
                if (mc.o().u(str, str2)) {
                    j2.a(bdStatsItem);
                } else {
                    j2.b(bdStatsItem);
                }
                fc.e(j2, bdStatsItem);
            }
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            for (Map.Entry<String, gc> entry : this.a.entrySet()) {
                gc value = entry.getValue();
                zb zbVar = this.d;
                if (zbVar != null) {
                    long logUploadTime = zbVar.getLogUploadTime(value.o());
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
                        ad.b(value);
                    } else if (System.currentTimeMillis() - value.w() >= BdStatisticsManager.getInstance().getUploadInterval()) {
                        ad.b(value);
                    }
                    if (value.m() > 0) {
                        v(value, false);
                    }
                    if (value.t() > ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT) {
                        wc.c(value, false, false, false);
                    } else if (System.currentTimeMillis() - value.w() >= BdStatisticsManager.getInstance().getUploadInterval()) {
                        wc.c(value, false, false, false);
                    }
                }
            }
        }
    }

    public synchronized gc j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                String g = gc.g(str);
                gc gcVar = this.a.get(g);
                if (gcVar == null) {
                    if ("alert".equals(g)) {
                        gcVar = new sc(null);
                    } else if ("error".equals(g)) {
                        gcVar = new vc(this.i);
                    } else if ("dbg".equals(g)) {
                        gcVar = new uc(this.i);
                    } else if ("stat".equals(g)) {
                        gcVar = new yc(this.i);
                    } else if ("pfmonitor".equals(g)) {
                        gcVar = new xc(this.i);
                    } else {
                        gcVar = new vc(this.i);
                    }
                    gcVar.I(g);
                    this.a.put(g, gcVar);
                }
                return gcVar;
            }
        }
        return (gc) invokeL.objValue;
    }

    public void l(ac acVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, acVar) == null) {
            if (this.f == null) {
                this.f = new f(this, null);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("adp.bdstatisticsmanager.account_changed");
                BdBaseApplication.getInst().registerReceiver(this.f, intentFilter);
            }
            this.d = BdStatisticsManager.getInstance().getBdLogSetting();
            this.g = acVar;
        }
    }

    public final boolean m(gc gcVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, gcVar)) == null) {
            boolean z = false;
            if (gcVar == null) {
                return false;
            }
            if (System.currentTimeMillis() - gcVar.i() >= 60000) {
                z = true;
            }
            if (mc.o().s(gcVar.o())) {
                z = true;
            }
            if (gcVar.m() >= 10) {
                return true;
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public final boolean n(gc gcVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, gcVar)) == null) {
            boolean z = false;
            if (gcVar == null) {
                return false;
            }
            if (System.currentTimeMillis() - gcVar.j() >= 60000) {
                z = true;
            }
            if (mc.o().s(gcVar.o())) {
                z = true;
            }
            if (gcVar.n() >= 10) {
                return true;
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            for (Map.Entry<String, gc> entry : this.a.entrySet()) {
                gc value = entry.getValue();
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

    public final boolean o(gc gcVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, gcVar)) == null) {
            boolean z = false;
            if (gcVar == null || !dc.e() || !dc.d(gcVar)) {
                return false;
            }
            if (System.currentTimeMillis() - gcVar.k() >= 60000) {
                z = true;
            }
            if (mc.o().s(gcVar.o())) {
                z = true;
            }
            if (gcVar.l() >= 10) {
                return true;
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public void x(gc gcVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048598, this, gcVar) == null) && gcVar != null && gcVar.n() != 0) {
            if (gcVar.u() > ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT) {
                c cVar = new c(this, BdStatisticsManager.getInstance().getNotUploadWriteDir(), gcVar.s(), BdStatisticsManager.getInstance().getNotUploadWriteDir(), gcVar.r(), DiskFileOperate.Action.RENAME, gcVar);
                cVar.setSdCard(gcVar.E());
                cVar.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
                j7.g().a(cVar);
            }
            d dVar = new d(this, BdStatisticsManager.getInstance().getNotUploadWriteDir(), gcVar.s(), DiskFileOperate.Action.APPEND, gcVar);
            dVar.setSdCard(gcVar.E());
            dVar.b(gcVar.y().toString());
            gcVar.e();
            if (!gcVar.A()) {
                dVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
                dVar.setTrySuccessWeight(3);
            }
            j7.g().a(dVar);
        }
    }

    public void y(gc gcVar, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{gcVar, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && gcVar != null && gcVar.u() > 0) {
            b bVar = new b(this, BdStatisticsManager.getInstance().getNotUploadWriteDir(), gcVar.s(), BdStatisticsManager.getInstance().getNotUploadWriteDir(), gcVar.r(), DiskFileOperate.Action.RENAME, gcVar, z, z2);
            bVar.setSdCard(gcVar.E());
            bVar.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
            j7.g().a(bVar);
        }
    }
}
