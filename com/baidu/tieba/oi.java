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
public class oi {
    public static /* synthetic */ Interceptable $ic;
    public static volatile oi i;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap a;
    public String b;
    public nh c;
    public qi d;
    public f e;
    public ph f;
    public Handler g;
    public ri h;

    /* loaded from: classes5.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oi a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(oi oiVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oiVar, looper};
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
            this.a = oiVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 6) {
                for (Map.Entry entry : this.a.a.entrySet()) {
                    vh vhVar = (vh) entry.getValue();
                    if (vhVar.u() > 0) {
                        this.a.y(vhVar, true, true);
                    }
                    if (vhVar.t() > 0) {
                        li.c(vhVar, true, true, true);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends DiskFileOperate {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vh a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ boolean c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(oi oiVar, String str, String str2, String str3, String str4, DiskFileOperate.Action action, vh vhVar, boolean z, boolean z2) {
            super(str, str2, str3, str4, action);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {oiVar, str, str2, str3, str4, action, vhVar, Boolean.valueOf(z), Boolean.valueOf(z2)};
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
            this.a = vhVar;
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
                    fi.m().r(this.a, this.b, true, this.c);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends DiskFileOperate {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vh a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(oi oiVar, String str, String str2, String str3, String str4, DiskFileOperate.Action action, vh vhVar) {
            super(str, str2, str3, str4, action);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {oiVar, str, str2, str3, str4, action, vhVar};
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
            this.a = vhVar;
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
    public class d extends qc {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vh c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(oi oiVar, String str, String str2, DiskFileOperate.Action action, vh vhVar) {
            super(str, str2, action);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oiVar, str, str2, action, vhVar};
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
            this.c = vhVar;
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
    public class e implements ri {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oi a;

        public e(oi oiVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oiVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oiVar;
        }

        @Override // com.baidu.tieba.ri
        public void a(vh vhVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, vhVar) == null) {
                if (this.a.o(vhVar)) {
                    this.a.z(vhVar);
                }
                if (this.a.m(vhVar)) {
                    this.a.u(vhVar);
                }
                if (this.a.n(vhVar)) {
                    this.a.x(vhVar);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oi this$0;

        public f(oi oiVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oiVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = oiVar;
        }

        public /* synthetic */ f(oi oiVar, a aVar) {
            this(oiVar);
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

    public oi() {
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
        this.a = new ConcurrentHashMap();
        this.g = new a(this, Looper.getMainLooper());
        this.h = new e(this);
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            for (Map.Entry entry : this.a.entrySet()) {
                vh vhVar = (vh) entry.getValue();
                z(vhVar);
                u(vhVar);
            }
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            for (Map.Entry entry : this.a.entrySet()) {
                vh vhVar = (vh) entry.getValue();
                B(vhVar);
                w(vhVar);
            }
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            for (Map.Entry entry : this.a.entrySet()) {
                vh vhVar = (vh) entry.getValue();
                B(vhVar);
                y(vhVar, false, false);
                w(vhVar);
            }
        }
    }

    public void B(vh vhVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vhVar) != null) || vhVar == null) {
            return;
        }
        if (vhVar.l() > 0) {
            A(vhVar, true);
        } else if (vhVar.v() > 0) {
            pi.b(vhVar);
        }
    }

    public void C(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.b = str;
        }
    }

    public void r(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            vh j = i().j(str);
            B(j);
            y(j, false, true);
            w(j);
        }
    }

    public void u(vh vhVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, vhVar) == null) {
            v(vhVar, false);
        }
    }

    public void w(vh vhVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048597, this, vhVar) != null) || vhVar == null) {
            return;
        }
        if (vhVar.m() > 0) {
            v(vhVar, true);
        } else if (vhVar.t() > 0) {
            li.c(vhVar, false, false, false);
        }
    }

    public void z(vh vhVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, vhVar) == null) {
            A(vhVar, false);
        }
    }

    public final void A(vh vhVar, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048576, this, vhVar, z) != null) || vhVar == null) {
            return;
        }
        if (pi.a(vhVar) > 20480) {
            pi.b(vhVar);
        }
        pi.c(vhVar, z);
    }

    public final void v(vh vhVar, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048596, this, vhVar, z) != null) || vhVar == null) {
            return;
        }
        if (li.b(vhVar) > ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT) {
            li.c(vhVar, false, false, false);
        }
        li.d(vhVar, z);
    }

    public static oi i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (i == null) {
                synchronized (oi.class) {
                    if (i == null) {
                        i = new oi();
                    }
                }
            }
            return i;
        }
        return (oi) invokeV.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.d == null) {
                this.d = new qi();
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

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public void D(String str, String str2, String str3, String str4, mh mhVar, Object... objArr) {
        vh j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, str2, str3, str4, mhVar, objArr}) == null) {
            if (str == null && str2 == null) {
                return;
            }
            if ((mhVar != null || (objArr != null && objArr.length != 0)) && (j = j(str)) != null && ci.o().v(str, str2)) {
                if (mhVar == null) {
                    mhVar = new mh(str);
                }
                if (!str.equals("stat") && !str.equals("crash")) {
                    mhVar.c("module", str, "st", str2, "t", String.valueOf(System.currentTimeMillis()));
                }
                if (objArr != null && objArr.length > 0) {
                    mhVar.c(objArr);
                }
                if (this.b != null && !str.equals("stat")) {
                    mhVar.b("uid", this.b);
                }
                if (str3 != null && !str.equals("stat")) {
                    mhVar.b("c_logid", str3);
                }
                if (!TextUtils.isEmpty(str4) && !str.equals("stat")) {
                    mhVar.b("seq_id", str4);
                }
                if (!str.equals("stat")) {
                    mhVar.b("net", qh.a(BdBaseApplication.getInst()));
                }
                if (!str.equals("stat") && !str.equals("pfmonitor")) {
                    mhVar.c("pid", Integer.valueOf(Process.myPid()));
                    if (BdStatisticsManager.getInstance().isMainProcess()) {
                        mhVar.b("ismainproc", "1");
                    } else {
                        mhVar.b("ismainproc", "0");
                    }
                }
                if (sh.e() && sh.d(j)) {
                    mhVar.d(this.f);
                    j.c(mhVar);
                }
                if (ci.o().u(str, str2)) {
                    j.a(mhVar);
                } else {
                    j.b(mhVar);
                }
                uh.e(j, mhVar);
            }
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            for (Map.Entry entry : this.a.entrySet()) {
                vh vhVar = (vh) entry.getValue();
                nh nhVar = this.c;
                if (nhVar != null) {
                    long logUploadTime = nhVar.getLogUploadTime(vhVar.o());
                    if (logUploadTime <= 0) {
                        logUploadTime = System.currentTimeMillis();
                        this.c.setLogUploadTime(vhVar.o(), logUploadTime);
                    }
                    vhVar.L(logUploadTime);
                }
                if (vhVar != null) {
                    if (vhVar.l() > 0) {
                        A(vhVar, false);
                    }
                    if (vhVar.v() > 20480) {
                        pi.b(vhVar);
                    } else if (System.currentTimeMillis() - vhVar.w() >= BdStatisticsManager.getInstance().getUploadInterval()) {
                        pi.b(vhVar);
                    }
                    if (vhVar.m() > 0) {
                        v(vhVar, false);
                    }
                    if (vhVar.t() > ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT) {
                        li.c(vhVar, false, false, false);
                    } else if (System.currentTimeMillis() - vhVar.w() >= BdStatisticsManager.getInstance().getUploadInterval()) {
                        li.c(vhVar, false, false, false);
                    }
                }
            }
        }
    }

    public synchronized vh j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                String g = vh.g(str);
                vh vhVar = (vh) this.a.get(g);
                if (vhVar == null) {
                    if ("alert".equals(g)) {
                        vhVar = new ii(null);
                    } else if ("error".equals(g)) {
                        vhVar = new ki(this.h);
                    } else if ("dbg".equals(g)) {
                        vhVar = new ji(this.h);
                    } else if ("stat".equals(g)) {
                        vhVar = new ni(this.h);
                    } else if ("pfmonitor".equals(g)) {
                        vhVar = new mi(this.h);
                    } else {
                        vhVar = new ki(this.h);
                    }
                    vhVar.I(g);
                    this.a.put(g, vhVar);
                }
                return vhVar;
            }
        }
        return (vh) invokeL.objValue;
    }

    public void l(ph phVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, phVar) == null) {
            if (this.e == null) {
                this.e = new f(this, null);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("adp.bdstatisticsmanager.account_changed");
                BdBaseApplication.getInst().registerReceiver(this.e, intentFilter);
            }
            this.c = BdStatisticsManager.getInstance().getBdLogSetting();
            this.f = phVar;
        }
    }

    public final boolean m(vh vhVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, vhVar)) == null) {
            boolean z = false;
            if (vhVar == null) {
                return false;
            }
            if (System.currentTimeMillis() - vhVar.i() >= 60000) {
                z = true;
            }
            if (ci.o().s(vhVar.o())) {
                z = true;
            }
            if (vhVar.m() >= 10) {
                return true;
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public final boolean n(vh vhVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, vhVar)) == null) {
            boolean z = false;
            if (vhVar == null) {
                return false;
            }
            if (System.currentTimeMillis() - vhVar.j() >= 60000) {
                z = true;
            }
            if (ci.o().s(vhVar.o())) {
                z = true;
            }
            if (vhVar.n() >= 10) {
                return true;
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            for (Map.Entry entry : this.a.entrySet()) {
                vh vhVar = (vh) entry.getValue();
                z(vhVar);
                u(vhVar);
                x(vhVar);
            }
            if (z) {
                h();
            } else {
                g();
            }
        }
    }

    public final boolean o(vh vhVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, vhVar)) == null) {
            boolean z = false;
            if (vhVar == null || !sh.e() || !sh.d(vhVar)) {
                return false;
            }
            if (System.currentTimeMillis() - vhVar.k() >= 60000) {
                z = true;
            }
            if (ci.o().s(vhVar.o())) {
                z = true;
            }
            if (vhVar.l() >= 10) {
                return true;
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public void x(vh vhVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048598, this, vhVar) == null) && vhVar != null && vhVar.n() != 0) {
            if (vhVar.u() > ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT) {
                c cVar = new c(this, BdStatisticsManager.getInstance().getNotUploadWriteDir(), vhVar.s(), BdStatisticsManager.getInstance().getNotUploadWriteDir(), vhVar.r(), DiskFileOperate.Action.RENAME, vhVar);
                cVar.setSdCard(vhVar.E());
                cVar.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
                lc.f().a(cVar);
            }
            d dVar = new d(this, BdStatisticsManager.getInstance().getNotUploadWriteDir(), vhVar.s(), DiskFileOperate.Action.APPEND, vhVar);
            dVar.setSdCard(vhVar.E());
            dVar.b(vhVar.y().toString());
            vhVar.e();
            if (!vhVar.A()) {
                dVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
                dVar.setTrySuccessWeight(3);
            }
            lc.f().a(dVar);
        }
    }

    public void y(vh vhVar, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{vhVar, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && vhVar != null && vhVar.u() > 0) {
            b bVar = new b(this, BdStatisticsManager.getInstance().getNotUploadWriteDir(), vhVar.s(), BdStatisticsManager.getInstance().getNotUploadWriteDir(), vhVar.r(), DiskFileOperate.Action.RENAME, vhVar, z, z2);
            bVar.setSdCard(vhVar.E());
            bVar.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
            lc.f().a(bVar);
        }
    }
}
