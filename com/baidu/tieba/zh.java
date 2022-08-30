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
/* loaded from: classes6.dex */
public class zh {
    public static /* synthetic */ Interceptable $ic;
    public static volatile zh i;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<String, gh> a;
    public String b;
    public yg c;
    public bi d;
    public f e;
    public ah f;
    public Handler g;
    public ci h;

    /* loaded from: classes6.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zh a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(zh zhVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zhVar, looper};
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
            this.a = zhVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 6) {
                for (Map.Entry entry : this.a.a.entrySet()) {
                    gh ghVar = (gh) entry.getValue();
                    if (ghVar.u() > 0) {
                        this.a.y(ghVar, true, true);
                    }
                    if (ghVar.t() > 0) {
                        wh.c(ghVar, true, true, true);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends DiskFileOperate {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gh a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ boolean c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(zh zhVar, String str, String str2, String str3, String str4, DiskFileOperate.Action action, gh ghVar, boolean z, boolean z2) {
            super(str, str2, str3, str4, action);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {zhVar, str, str2, str3, str4, action, ghVar, Boolean.valueOf(z), Boolean.valueOf(z2)};
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
            this.a = ghVar;
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
                    qh.m().r(this.a, this.b, true, this.c);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends DiskFileOperate {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gh a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(zh zhVar, String str, String str2, String str3, String str4, DiskFileOperate.Action action, gh ghVar) {
            super(str, str2, str3, str4, action);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {zhVar, str, str2, str3, str4, action, ghVar};
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
            this.a = ghVar;
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
    public class d extends bc {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gh c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(zh zhVar, String str, String str2, DiskFileOperate.Action action, gh ghVar) {
            super(str, str2, action);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zhVar, str, str2, action, ghVar};
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
            this.c = ghVar;
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
    public class e implements ci {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zh a;

        public e(zh zhVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zhVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zhVar;
        }

        @Override // com.baidu.tieba.ci
        public void a(gh ghVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ghVar) == null) {
                if (this.a.o(ghVar)) {
                    this.a.z(ghVar);
                }
                if (this.a.m(ghVar)) {
                    this.a.u(ghVar);
                }
                if (this.a.n(ghVar)) {
                    this.a.x(ghVar);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zh this$0;

        public f(zh zhVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zhVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = zhVar;
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

        public /* synthetic */ f(zh zhVar, a aVar) {
            this(zhVar);
        }
    }

    public zh() {
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

    public static zh i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (i == null) {
                synchronized (zh.class) {
                    if (i == null) {
                        i = new zh();
                    }
                }
            }
            return i;
        }
        return (zh) invokeV.objValue;
    }

    public final void A(gh ghVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048576, this, ghVar, z) == null) || ghVar == null) {
            return;
        }
        if (ai.a(ghVar) > 20480) {
            ai.b(ghVar);
        }
        ai.c(ghVar, z);
    }

    public void B(gh ghVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ghVar) == null) || ghVar == null) {
            return;
        }
        if (ghVar.l() > 0) {
            A(ghVar, true);
        } else if (ghVar.v() > 0) {
            ai.b(ghVar);
        }
    }

    public void C(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.b = str;
        }
    }

    public void D(String str, String str2, String str3, String str4, xg xgVar, Object... objArr) {
        gh j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, str2, str3, str4, xgVar, objArr}) == null) {
            if (str == null && str2 == null) {
                return;
            }
            if ((xgVar == null && (objArr == null || objArr.length == 0)) || (j = j(str)) == null || !nh.o().v(str, str2)) {
                return;
            }
            if (xgVar == null) {
                xgVar = new xg(str);
            }
            if (!str.equals("stat") && !str.equals("crash")) {
                xgVar.c("module", str, "st", str2, "t", String.valueOf(System.currentTimeMillis()));
            }
            if (objArr != null && objArr.length > 0) {
                xgVar.c(objArr);
            }
            if (this.b != null && !str.equals("stat")) {
                xgVar.b("uid", this.b);
            }
            if (str3 != null && !str.equals("stat")) {
                xgVar.b("c_logid", str3);
            }
            if (!TextUtils.isEmpty(str4) && !str.equals("stat")) {
                xgVar.b("seq_id", str4);
            }
            if (!str.equals("stat")) {
                xgVar.b("net", bh.a(BdBaseApplication.getInst()));
            }
            if (!str.equals("stat") && !str.equals("pfmonitor")) {
                xgVar.c("pid", Integer.valueOf(Process.myPid()));
                if (BdStatisticsManager.getInstance().isMainProcess()) {
                    xgVar.b("ismainproc", "1");
                } else {
                    xgVar.b("ismainproc", "0");
                }
            }
            if (dh.e() && dh.d(j)) {
                xgVar.d(this.f);
                j.c(xgVar);
            }
            if (nh.o().u(str, str2)) {
                j.a(xgVar);
            } else {
                j.b(xgVar);
            }
            fh.e(j, xgVar);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            for (Map.Entry<String, gh> entry : this.a.entrySet()) {
                gh value = entry.getValue();
                yg ygVar = this.c;
                if (ygVar != null) {
                    long logUploadTime = ygVar.getLogUploadTime(value.o());
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
                        ai.b(value);
                    } else if (System.currentTimeMillis() - value.w() >= BdStatisticsManager.getInstance().getUploadInterval()) {
                        ai.b(value);
                    }
                    if (value.m() > 0) {
                        v(value, false);
                    }
                    if (value.t() > ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT) {
                        wh.c(value, false, false, false);
                    } else if (System.currentTimeMillis() - value.w() >= BdStatisticsManager.getInstance().getUploadInterval()) {
                        wh.c(value, false, false, false);
                    }
                }
            }
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.d == null) {
                this.d = new bi();
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

    public synchronized gh j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                String g = gh.g(str);
                gh ghVar = this.a.get(g);
                if (ghVar == null) {
                    if ("alert".equals(g)) {
                        ghVar = new th(null);
                    } else if ("error".equals(g)) {
                        ghVar = new vh(this.h);
                    } else if ("dbg".equals(g)) {
                        ghVar = new uh(this.h);
                    } else if ("stat".equals(g)) {
                        ghVar = new yh(this.h);
                    } else if ("pfmonitor".equals(g)) {
                        ghVar = new xh(this.h);
                    } else {
                        ghVar = new vh(this.h);
                    }
                    ghVar.I(g);
                    this.a.put(g, ghVar);
                }
                return ghVar;
            }
        }
        return (gh) invokeL.objValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.b : (String) invokeV.objValue;
    }

    public void l(ah ahVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, ahVar) == null) {
            if (this.e == null) {
                this.e = new f(this, null);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("adp.bdstatisticsmanager.account_changed");
                BdBaseApplication.getInst().registerReceiver(this.e, intentFilter);
            }
            this.c = BdStatisticsManager.getInstance().getBdLogSetting();
            this.f = ahVar;
        }
    }

    public final boolean m(gh ghVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, ghVar)) == null) {
            if (ghVar == null) {
                return false;
            }
            boolean z = System.currentTimeMillis() - ghVar.i() >= 60000;
            if (nh.o().s(ghVar.o())) {
                z = true;
            }
            if (ghVar.m() >= 10) {
                return true;
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public final boolean n(gh ghVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, ghVar)) == null) {
            if (ghVar == null) {
                return false;
            }
            boolean z = System.currentTimeMillis() - ghVar.j() >= 60000;
            if (nh.o().s(ghVar.o())) {
                z = true;
            }
            if (ghVar.n() >= 10) {
                return true;
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public final boolean o(gh ghVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, ghVar)) == null) {
            if (ghVar != null && dh.e() && dh.d(ghVar)) {
                boolean z = System.currentTimeMillis() - ghVar.k() >= 60000;
                if (nh.o().s(ghVar.o())) {
                    z = true;
                }
                if (ghVar.l() >= 10) {
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
            for (Map.Entry<String, gh> entry : this.a.entrySet()) {
                gh value = entry.getValue();
                z(value);
                u(value);
            }
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            for (Map.Entry<String, gh> entry : this.a.entrySet()) {
                gh value = entry.getValue();
                B(value);
                w(value);
            }
        }
    }

    public void r(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            gh j = i().j(str);
            B(j);
            y(j, false, true);
            w(j);
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            for (Map.Entry<String, gh> entry : this.a.entrySet()) {
                gh value = entry.getValue();
                B(value);
                y(value, false, false);
                w(value);
            }
        }
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            for (Map.Entry<String, gh> entry : this.a.entrySet()) {
                gh value = entry.getValue();
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

    public void u(gh ghVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, ghVar) == null) {
            v(ghVar, false);
        }
    }

    public final void v(gh ghVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048596, this, ghVar, z) == null) || ghVar == null) {
            return;
        }
        if (wh.b(ghVar) > ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT) {
            wh.c(ghVar, false, false, false);
        }
        wh.d(ghVar, z);
    }

    public void w(gh ghVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, ghVar) == null) || ghVar == null) {
            return;
        }
        if (ghVar.m() > 0) {
            v(ghVar, true);
        } else if (ghVar.t() > 0) {
            wh.c(ghVar, false, false, false);
        }
    }

    public void x(gh ghVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, ghVar) == null) || ghVar == null || ghVar.n() == 0) {
            return;
        }
        if (ghVar.u() > ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT) {
            c cVar = new c(this, BdStatisticsManager.getInstance().getNotUploadWriteDir(), ghVar.s(), BdStatisticsManager.getInstance().getNotUploadWriteDir(), ghVar.r(), DiskFileOperate.Action.RENAME, ghVar);
            cVar.setSdCard(ghVar.E());
            cVar.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
            wb.f().a(cVar);
        }
        d dVar = new d(this, BdStatisticsManager.getInstance().getNotUploadWriteDir(), ghVar.s(), DiskFileOperate.Action.APPEND, ghVar);
        dVar.setSdCard(ghVar.E());
        dVar.b(ghVar.y().toString());
        ghVar.e();
        if (!ghVar.A()) {
            dVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            dVar.setTrySuccessWeight(3);
        }
        wb.f().a(dVar);
    }

    public void y(gh ghVar, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{ghVar, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || ghVar == null || ghVar.u() <= 0) {
            return;
        }
        b bVar = new b(this, BdStatisticsManager.getInstance().getNotUploadWriteDir(), ghVar.s(), BdStatisticsManager.getInstance().getNotUploadWriteDir(), ghVar.r(), DiskFileOperate.Action.RENAME, ghVar, z, z2);
        bVar.setSdCard(ghVar.E());
        bVar.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
        wb.f().a(bVar);
    }

    public void z(gh ghVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, ghVar) == null) {
            A(ghVar, false);
        }
    }
}
