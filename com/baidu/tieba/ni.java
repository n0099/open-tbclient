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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.statistic.ConfigSpeedStat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes5.dex */
public class ni {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ni i;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<String, uh> a;
    public String b;
    public mh c;
    public pi d;
    public f e;
    public oh f;
    public Handler g;
    public qi h;

    /* loaded from: classes5.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ni a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ni niVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {niVar, looper};
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
            this.a = niVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 6) {
                for (Map.Entry entry : this.a.a.entrySet()) {
                    uh uhVar = (uh) entry.getValue();
                    if (uhVar.u() > 0) {
                        this.a.y(uhVar, true, true);
                    }
                    if (uhVar.t() > 0) {
                        ki.c(uhVar, true, true, true);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends DiskFileOperate {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uh a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ boolean c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ni niVar, String str, String str2, String str3, String str4, DiskFileOperate.Action action, uh uhVar, boolean z, boolean z2) {
            super(str, str2, str3, str4, action);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {niVar, str, str2, str3, str4, action, uhVar, Boolean.valueOf(z), Boolean.valueOf(z2)};
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
            this.a = uhVar;
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
                    ei.m().r(this.a, this.b, true, this.c);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends DiskFileOperate {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uh a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(ni niVar, String str, String str2, String str3, String str4, DiskFileOperate.Action action, uh uhVar) {
            super(str, str2, str3, str4, action);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {niVar, str, str2, str3, str4, action, uhVar};
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
            this.a = uhVar;
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

    /* loaded from: classes5.dex */
    public class d extends pc {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uh c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(ni niVar, String str, String str2, DiskFileOperate.Action action, uh uhVar) {
            super(str, str2, action);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {niVar, str, str2, action, uhVar};
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
            this.c = uhVar;
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

    /* loaded from: classes5.dex */
    public class e implements qi {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ni a;

        public e(ni niVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {niVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = niVar;
        }

        @Override // com.baidu.tieba.qi
        public void a(uh uhVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, uhVar) == null) {
                if (this.a.o(uhVar)) {
                    this.a.z(uhVar);
                }
                if (this.a.m(uhVar)) {
                    this.a.u(uhVar);
                }
                if (this.a.n(uhVar)) {
                    this.a.x(uhVar);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ni this$0;

        public f(ni niVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {niVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = niVar;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) || intent == null) {
                return;
            }
            this.this$0.C(intent.getStringExtra("intent_data_userid"));
            this.this$0.p();
        }

        public /* synthetic */ f(ni niVar, a aVar) {
            this(niVar);
        }
    }

    public ni() {
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
        this.a = new ConcurrentHashMap<>();
        this.g = new a(this, Looper.getMainLooper());
        this.h = new e(this);
    }

    public static ni i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (i == null) {
                synchronized (ni.class) {
                    if (i == null) {
                        i = new ni();
                    }
                }
            }
            return i;
        }
        return (ni) invokeV.objValue;
    }

    public final void A(uh uhVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048576, this, uhVar, z) == null) || uhVar == null) {
            return;
        }
        if (oi.a(uhVar) > 20480) {
            oi.b(uhVar);
        }
        oi.c(uhVar, z);
    }

    public void B(uh uhVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uhVar) == null) || uhVar == null) {
            return;
        }
        if (uhVar.l() > 0) {
            A(uhVar, true);
        } else if (uhVar.v() > 0) {
            oi.b(uhVar);
        }
    }

    public void C(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.b = str;
        }
    }

    public void D(String str, String str2, String str3, String str4, lh lhVar, Object... objArr) {
        uh j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, str2, str3, str4, lhVar, objArr}) == null) {
            if (str == null && str2 == null) {
                return;
            }
            if ((lhVar == null && (objArr == null || objArr.length == 0)) || (j = j(str)) == null || !bi.o().v(str, str2)) {
                return;
            }
            if (lhVar == null) {
                lhVar = new lh(str);
            }
            if (!str.equals("stat") && !str.equals("crash")) {
                lhVar.c("module", str, "st", str2, "t", String.valueOf(System.currentTimeMillis()));
            }
            if (objArr != null && objArr.length > 0) {
                lhVar.c(objArr);
            }
            if (this.b != null && !str.equals("stat")) {
                lhVar.b("uid", this.b);
            }
            if (str3 != null && !str.equals("stat")) {
                lhVar.b("c_logid", str3);
            }
            if (!TextUtils.isEmpty(str4) && !str.equals("stat")) {
                lhVar.b("seq_id", str4);
            }
            if (!str.equals("stat")) {
                lhVar.b("net", ph.a(BdBaseApplication.getInst()));
            }
            if (!str.equals("stat") && !str.equals("pfmonitor")) {
                lhVar.c("pid", Integer.valueOf(Process.myPid()));
                if (BdStatisticsManager.getInstance().isMainProcess()) {
                    lhVar.b("ismainproc", "1");
                } else {
                    lhVar.b("ismainproc", "0");
                }
            }
            if (rh.e() && rh.d(j)) {
                lhVar.d(this.f);
                j.c(lhVar);
            }
            if (bi.o().u(str, str2)) {
                j.a(lhVar);
            } else {
                j.b(lhVar);
            }
            th.e(j, lhVar);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            for (Map.Entry<String, uh> entry : this.a.entrySet()) {
                uh value = entry.getValue();
                mh mhVar = this.c;
                if (mhVar != null) {
                    long logUploadTime = mhVar.getLogUploadTime(value.o());
                    if (logUploadTime <= 0) {
                        logUploadTime = System.currentTimeMillis();
                        this.c.setLogUploadTime(value.o(), logUploadTime);
                    }
                    value.L(logUploadTime);
                }
                if (value != null) {
                    if (value.l() > 0) {
                        A(value, false);
                    }
                    if (value.v() > 20480) {
                        oi.b(value);
                    } else if (System.currentTimeMillis() - value.w() >= BdStatisticsManager.getInstance().getUploadInterval()) {
                        oi.b(value);
                    }
                    if (value.m() > 0) {
                        v(value, false);
                    }
                    if (value.t() > ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT) {
                        ki.c(value, false, false, false);
                    } else if (System.currentTimeMillis() - value.w() >= BdStatisticsManager.getInstance().getUploadInterval()) {
                        ki.c(value, false, false, false);
                    }
                }
            }
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.d == null) {
                this.d = new pi();
            }
            this.d.a();
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            Message obtainMessage = this.g.obtainMessage();
            obtainMessage.what = 6;
            this.g.removeMessages(6);
            this.g.sendMessageDelayed(obtainMessage, 3000L);
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            Message obtainMessage = this.g.obtainMessage();
            obtainMessage.what = 6;
            this.g.removeMessages(6);
            this.g.sendMessage(obtainMessage);
        }
    }

    public synchronized uh j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                String g = uh.g(str);
                uh uhVar = this.a.get(g);
                if (uhVar == null) {
                    if ("alert".equals(g)) {
                        uhVar = new hi(null);
                    } else if ("error".equals(g)) {
                        uhVar = new ji(this.h);
                    } else if ("dbg".equals(g)) {
                        uhVar = new ii(this.h);
                    } else if ("stat".equals(g)) {
                        uhVar = new mi(this.h);
                    } else if ("pfmonitor".equals(g)) {
                        uhVar = new li(this.h);
                    } else {
                        uhVar = new ji(this.h);
                    }
                    uhVar.I(g);
                    this.a.put(g, uhVar);
                }
                return uhVar;
            }
        }
        return (uh) invokeL.objValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.b : (String) invokeV.objValue;
    }

    public void l(oh ohVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, ohVar) == null) {
            if (this.e == null) {
                this.e = new f(this, null);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("adp.bdstatisticsmanager.account_changed");
                BdBaseApplication.getInst().registerReceiver(this.e, intentFilter);
            }
            this.c = BdStatisticsManager.getInstance().getBdLogSetting();
            this.f = ohVar;
        }
    }

    public final boolean m(uh uhVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, uhVar)) == null) {
            if (uhVar == null) {
                return false;
            }
            boolean z = System.currentTimeMillis() - uhVar.i() >= 60000;
            if (bi.o().s(uhVar.o())) {
                z = true;
            }
            if (uhVar.m() >= 10) {
                return true;
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public final boolean n(uh uhVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, uhVar)) == null) {
            if (uhVar == null) {
                return false;
            }
            boolean z = System.currentTimeMillis() - uhVar.j() >= 60000;
            if (bi.o().s(uhVar.o())) {
                z = true;
            }
            if (uhVar.n() >= 10) {
                return true;
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public final boolean o(uh uhVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, uhVar)) == null) {
            if (uhVar != null && rh.e() && rh.d(uhVar)) {
                boolean z = System.currentTimeMillis() - uhVar.k() >= 60000;
                if (bi.o().s(uhVar.o())) {
                    z = true;
                }
                if (uhVar.l() >= 10) {
                    return true;
                }
                return z;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            for (Map.Entry<String, uh> entry : this.a.entrySet()) {
                uh value = entry.getValue();
                z(value);
                u(value);
            }
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            for (Map.Entry<String, uh> entry : this.a.entrySet()) {
                uh value = entry.getValue();
                B(value);
                w(value);
            }
        }
    }

    public void r(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            uh j = i().j(str);
            B(j);
            y(j, false, true);
            w(j);
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            for (Map.Entry<String, uh> entry : this.a.entrySet()) {
                uh value = entry.getValue();
                B(value);
                y(value, false, false);
                w(value);
            }
        }
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            for (Map.Entry<String, uh> entry : this.a.entrySet()) {
                uh value = entry.getValue();
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

    public void u(uh uhVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, uhVar) == null) {
            v(uhVar, false);
        }
    }

    public final void v(uh uhVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048596, this, uhVar, z) == null) || uhVar == null) {
            return;
        }
        if (ki.b(uhVar) > ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT) {
            ki.c(uhVar, false, false, false);
        }
        ki.d(uhVar, z);
    }

    public void w(uh uhVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, uhVar) == null) || uhVar == null) {
            return;
        }
        if (uhVar.m() > 0) {
            v(uhVar, true);
        } else if (uhVar.t() > 0) {
            ki.c(uhVar, false, false, false);
        }
    }

    public void x(uh uhVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, uhVar) == null) || uhVar == null || uhVar.n() == 0) {
            return;
        }
        if (uhVar.u() > ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT) {
            c cVar = new c(this, BdStatisticsManager.getInstance().getNotUploadWriteDir(), uhVar.s(), BdStatisticsManager.getInstance().getNotUploadWriteDir(), uhVar.r(), DiskFileOperate.Action.RENAME, uhVar);
            cVar.setSdCard(uhVar.E());
            cVar.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
            kc.f().a(cVar);
        }
        d dVar = new d(this, BdStatisticsManager.getInstance().getNotUploadWriteDir(), uhVar.s(), DiskFileOperate.Action.APPEND, uhVar);
        dVar.setSdCard(uhVar.E());
        dVar.b(uhVar.y().toString());
        uhVar.e();
        if (!uhVar.A()) {
            dVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            dVar.setTrySuccessWeight(3);
        }
        kc.f().a(dVar);
    }

    public void y(uh uhVar, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{uhVar, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || uhVar == null || uhVar.u() <= 0) {
            return;
        }
        b bVar = new b(this, BdStatisticsManager.getInstance().getNotUploadWriteDir(), uhVar.s(), BdStatisticsManager.getInstance().getNotUploadWriteDir(), uhVar.r(), DiskFileOperate.Action.RENAME, uhVar, z, z2);
        bVar.setSdCard(uhVar.E());
        bVar.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
        kc.f().a(bVar);
    }

    public void z(uh uhVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, uhVar) == null) {
            A(uhVar, false);
        }
    }
}
