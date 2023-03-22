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
public class qh {
    public static /* synthetic */ Interceptable $ic;
    public static volatile qh i;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<String, xg> a;
    public String b;
    public pg c;
    public sh d;
    public f e;
    public rg f;
    public Handler g;
    public th h;

    /* loaded from: classes6.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qh a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(qh qhVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qhVar, looper};
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
            this.a = qhVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 6) {
                for (Map.Entry entry : this.a.a.entrySet()) {
                    xg xgVar = (xg) entry.getValue();
                    if (xgVar.u() > 0) {
                        this.a.y(xgVar, true, true);
                    }
                    if (xgVar.t() > 0) {
                        nh.c(xgVar, true, true, true);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends DiskFileOperate {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xg a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ boolean c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(qh qhVar, String str, String str2, String str3, String str4, DiskFileOperate.Action action, xg xgVar, boolean z, boolean z2) {
            super(str, str2, str3, str4, action);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {qhVar, str, str2, str3, str4, action, xgVar, Boolean.valueOf(z), Boolean.valueOf(z2)};
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
            this.a = xgVar;
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
                    hh.m().r(this.a, this.b, true, this.c);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends DiskFileOperate {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xg a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(qh qhVar, String str, String str2, String str3, String str4, DiskFileOperate.Action action, xg xgVar) {
            super(str, str2, str3, str4, action);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {qhVar, str, str2, str3, str4, action, xgVar};
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
            this.a = xgVar;
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
    public class d extends zb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xg c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(qh qhVar, String str, String str2, DiskFileOperate.Action action, xg xgVar) {
            super(str, str2, action);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qhVar, str, str2, action, xgVar};
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
            this.c = xgVar;
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
    public class e implements th {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qh a;

        public e(qh qhVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qhVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qhVar;
        }

        @Override // com.baidu.tieba.th
        public void a(xg xgVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, xgVar) == null) {
                if (this.a.o(xgVar)) {
                    this.a.z(xgVar);
                }
                if (this.a.m(xgVar)) {
                    this.a.u(xgVar);
                }
                if (this.a.n(xgVar)) {
                    this.a.x(xgVar);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qh this$0;

        public f(qh qhVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qhVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = qhVar;
        }

        public /* synthetic */ f(qh qhVar, a aVar) {
            this(qhVar);
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

    public qh() {
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

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            for (Map.Entry<String, xg> entry : this.a.entrySet()) {
                xg value = entry.getValue();
                z(value);
                u(value);
            }
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            for (Map.Entry<String, xg> entry : this.a.entrySet()) {
                xg value = entry.getValue();
                B(value);
                w(value);
            }
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            for (Map.Entry<String, xg> entry : this.a.entrySet()) {
                xg value = entry.getValue();
                B(value);
                y(value, false, false);
                w(value);
            }
        }
    }

    public void B(xg xgVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xgVar) != null) || xgVar == null) {
            return;
        }
        if (xgVar.l() > 0) {
            A(xgVar, true);
        } else if (xgVar.v() > 0) {
            rh.b(xgVar);
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
            xg j = i().j(str);
            B(j);
            y(j, false, true);
            w(j);
        }
    }

    public void u(xg xgVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, xgVar) == null) {
            v(xgVar, false);
        }
    }

    public void w(xg xgVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048597, this, xgVar) != null) || xgVar == null) {
            return;
        }
        if (xgVar.m() > 0) {
            v(xgVar, true);
        } else if (xgVar.t() > 0) {
            nh.c(xgVar, false, false, false);
        }
    }

    public void z(xg xgVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, xgVar) == null) {
            A(xgVar, false);
        }
    }

    public final void A(xg xgVar, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048576, this, xgVar, z) != null) || xgVar == null) {
            return;
        }
        if (rh.a(xgVar) > UploadTask.SIZE_LIMIT_DEFAULT) {
            rh.b(xgVar);
        }
        rh.c(xgVar, z);
    }

    public final void v(xg xgVar, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048596, this, xgVar, z) != null) || xgVar == null) {
            return;
        }
        if (nh.b(xgVar) > ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT) {
            nh.c(xgVar, false, false, false);
        }
        nh.d(xgVar, z);
    }

    public static qh i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (i == null) {
                synchronized (qh.class) {
                    if (i == null) {
                        i = new qh();
                    }
                }
            }
            return i;
        }
        return (qh) invokeV.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.d == null) {
                this.d = new sh();
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

    public void D(String str, String str2, String str3, String str4, og ogVar, Object... objArr) {
        xg j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, str2, str3, str4, ogVar, objArr}) == null) {
            if (str == null && str2 == null) {
                return;
            }
            if ((ogVar != null || (objArr != null && objArr.length != 0)) && (j = j(str)) != null && eh.o().v(str, str2)) {
                if (ogVar == null) {
                    ogVar = new og(str);
                }
                if (!str.equals("stat") && !str.equals("crash")) {
                    ogVar.c("module", str, "st", str2, "t", String.valueOf(System.currentTimeMillis()));
                }
                if (objArr != null && objArr.length > 0) {
                    ogVar.c(objArr);
                }
                if (this.b != null && !str.equals("stat")) {
                    ogVar.b("uid", this.b);
                }
                if (str3 != null && !str.equals("stat")) {
                    ogVar.b("c_logid", str3);
                }
                if (!TextUtils.isEmpty(str4) && !str.equals("stat")) {
                    ogVar.b(PushConstants.SEQ_ID, str4);
                }
                if (!str.equals("stat")) {
                    ogVar.b("net", sg.a(BdBaseApplication.getInst()));
                }
                if (!str.equals("stat") && !str.equals("pfmonitor")) {
                    ogVar.c("pid", Integer.valueOf(Process.myPid()));
                    if (BdStatisticsManager.getInstance().isMainProcess()) {
                        ogVar.b("ismainproc", "1");
                    } else {
                        ogVar.b("ismainproc", "0");
                    }
                }
                if (ug.e() && ug.d(j)) {
                    ogVar.d(this.f);
                    j.c(ogVar);
                }
                if (eh.o().u(str, str2)) {
                    j.a(ogVar);
                } else {
                    j.b(ogVar);
                }
                wg.e(j, ogVar);
            }
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            for (Map.Entry<String, xg> entry : this.a.entrySet()) {
                xg value = entry.getValue();
                pg pgVar = this.c;
                if (pgVar != null) {
                    long logUploadTime = pgVar.getLogUploadTime(value.o());
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
                    if (value.v() > UploadTask.SIZE_LIMIT_DEFAULT) {
                        rh.b(value);
                    } else if (System.currentTimeMillis() - value.w() >= BdStatisticsManager.getInstance().getUploadInterval()) {
                        rh.b(value);
                    }
                    if (value.m() > 0) {
                        v(value, false);
                    }
                    if (value.t() > ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT) {
                        nh.c(value, false, false, false);
                    } else if (System.currentTimeMillis() - value.w() >= BdStatisticsManager.getInstance().getUploadInterval()) {
                        nh.c(value, false, false, false);
                    }
                }
            }
        }
    }

    public synchronized xg j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                String g = xg.g(str);
                xg xgVar = this.a.get(g);
                if (xgVar == null) {
                    if ("alert".equals(g)) {
                        xgVar = new kh(null);
                    } else if ("error".equals(g)) {
                        xgVar = new mh(this.h);
                    } else if ("dbg".equals(g)) {
                        xgVar = new lh(this.h);
                    } else if ("stat".equals(g)) {
                        xgVar = new ph(this.h);
                    } else if ("pfmonitor".equals(g)) {
                        xgVar = new oh(this.h);
                    } else {
                        xgVar = new mh(this.h);
                    }
                    xgVar.I(g);
                    this.a.put(g, xgVar);
                }
                return xgVar;
            }
        }
        return (xg) invokeL.objValue;
    }

    public void l(rg rgVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, rgVar) == null) {
            if (this.e == null) {
                this.e = new f(this, null);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("adp.bdstatisticsmanager.account_changed");
                BdBaseApplication.getInst().registerReceiver(this.e, intentFilter);
            }
            this.c = BdStatisticsManager.getInstance().getBdLogSetting();
            this.f = rgVar;
        }
    }

    public final boolean m(xg xgVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, xgVar)) == null) {
            boolean z = false;
            if (xgVar == null) {
                return false;
            }
            if (System.currentTimeMillis() - xgVar.i() >= 60000) {
                z = true;
            }
            if (eh.o().s(xgVar.o())) {
                z = true;
            }
            if (xgVar.m() >= 10) {
                return true;
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public final boolean n(xg xgVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, xgVar)) == null) {
            boolean z = false;
            if (xgVar == null) {
                return false;
            }
            if (System.currentTimeMillis() - xgVar.j() >= 60000) {
                z = true;
            }
            if (eh.o().s(xgVar.o())) {
                z = true;
            }
            if (xgVar.n() >= 10) {
                return true;
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            for (Map.Entry<String, xg> entry : this.a.entrySet()) {
                xg value = entry.getValue();
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

    public final boolean o(xg xgVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, xgVar)) == null) {
            boolean z = false;
            if (xgVar == null || !ug.e() || !ug.d(xgVar)) {
                return false;
            }
            if (System.currentTimeMillis() - xgVar.k() >= 60000) {
                z = true;
            }
            if (eh.o().s(xgVar.o())) {
                z = true;
            }
            if (xgVar.l() >= 10) {
                return true;
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public void x(xg xgVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048598, this, xgVar) == null) && xgVar != null && xgVar.n() != 0) {
            if (xgVar.u() > ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT) {
                c cVar = new c(this, BdStatisticsManager.getInstance().getNotUploadWriteDir(), xgVar.s(), BdStatisticsManager.getInstance().getNotUploadWriteDir(), xgVar.r(), DiskFileOperate.Action.RENAME, xgVar);
                cVar.setSdCard(xgVar.E());
                cVar.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
                ub.f().a(cVar);
            }
            d dVar = new d(this, BdStatisticsManager.getInstance().getNotUploadWriteDir(), xgVar.s(), DiskFileOperate.Action.APPEND, xgVar);
            dVar.setSdCard(xgVar.E());
            dVar.b(xgVar.y().toString());
            xgVar.e();
            if (!xgVar.A()) {
                dVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
                dVar.setTrySuccessWeight(3);
            }
            ub.f().a(dVar);
        }
    }

    public void y(xg xgVar, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{xgVar, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && xgVar != null && xgVar.u() > 0) {
            b bVar = new b(this, BdStatisticsManager.getInstance().getNotUploadWriteDir(), xgVar.s(), BdStatisticsManager.getInstance().getNotUploadWriteDir(), xgVar.r(), DiskFileOperate.Action.RENAME, xgVar, z, z2);
            bVar.setSdCard(xgVar.E());
            bVar.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
            ub.f().a(bVar);
        }
    }
}
