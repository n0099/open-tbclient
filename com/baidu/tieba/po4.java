package com.baidu.tieba;

import android.util.Pair;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BdToken.activeConfig.ActiveCenterData;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.rp4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public class po4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ScheduledExecutorService a;
    public final SparseArray<List<oo4>> b;
    public final LinkedList<oo4> c;
    public f d;
    public AtomicBoolean e;
    public boolean f;
    public boolean g;
    public BdUniqueId h;
    public rp4 i;
    public lp4 j;
    public int k;
    public long l;
    public int m;
    public long n;
    public boolean o;
    public CustomMessageListener p;
    public CustomMessageListener q;
    public CustomMessageListener r;
    public jp4<kp4> s;
    public vu4 t;

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ po4 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(po4 po4Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {po4Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = po4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) {
                return;
            }
            this.a.f = true;
            if (!this.a.c.isEmpty()) {
                Iterator it = this.a.c.iterator();
                while (it.hasNext()) {
                    this.a.m((oo4) it.next());
                }
                this.a.c.clear();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ po4 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(po4 po4Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {po4Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = po4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof BackgroundSwitchMessage)) {
                this.a.q();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ po4 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(po4 po4Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {po4Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = po4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2001371) {
                return;
            }
            this.a.g = true;
            this.a.q();
        }
    }

    /* loaded from: classes7.dex */
    public class d implements jp4<kp4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ po4 a;

        @Override // com.baidu.tieba.uu4
        public void onError(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) {
            }
        }

        public d(po4 po4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {po4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = po4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.uu4
        /* renamed from: c */
        public void onSuccess(kp4 kp4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, kp4Var) == null) && kp4Var != null) {
                this.a.n(kp4Var.b());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jp4
        /* renamed from: b */
        public void a(kp4 kp4Var) {
            ActiveCenterData activeCenterData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kp4Var) == null) && kp4Var != null && (activeCenterData = kp4Var.g) != null && activeCenterData.mission != null) {
                oo4 oo4Var = new oo4();
                oo4Var.P(kp4Var.g.mission);
                ArrayList arrayList = new ArrayList();
                arrayList.add(oo4Var);
                this.a.n(arrayList);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements vu4<oo4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ po4 a;

        public e(po4 po4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {po4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = po4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vu4
        /* renamed from: b */
        public void a(oo4 oo4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, oo4Var) != null) || oo4Var == null) {
                return;
            }
            oo4 u = this.a.u(oo4Var);
            if (u != null && u.z) {
                u.S();
                this.a.T(u);
                return;
            }
            ap4.b().h(u);
            if (u != null && u.x() == 7) {
                u.I();
                int F = u.F();
                int w = u.w();
                if (F <= 1 || F <= w) {
                    this.a.G(u);
                } else {
                    this.a.T(u);
                }
            } else if (u == null || u.x() != 8) {
                this.a.G(oo4Var);
            } else {
                this.a.G(u);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile int a;
        public volatile long b;
        public volatile long c;
        public volatile boolean d;
        public final /* synthetic */ po4 e;

        public f(po4 po4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {po4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = po4Var;
            this.d = false;
        }

        public synchronized void f(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
                synchronized (this) {
                    this.a = i;
                }
            }
        }

        public synchronized void g(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048582, this, j) == null) {
                synchronized (this) {
                    this.c = j;
                }
            }
        }

        public synchronized void h(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048583, this, j) == null) {
                synchronized (this) {
                    this.b = j;
                }
            }
        }

        public /* synthetic */ f(po4 po4Var, a aVar) {
            this(po4Var);
        }

        public final void d(List<oo4> list, rp4.d dVar) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLL(1048579, this, list, dVar) != null) || ListUtils.isEmpty(list)) {
                return;
            }
            for (oo4 oo4Var : list) {
                b(oo4Var, dVar);
            }
        }

        public final void e(List<oo4> list, rp4.d dVar) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLL(1048580, this, list, dVar) != null) || ListUtils.isEmpty(list)) {
                return;
            }
            for (oo4 oo4Var : list) {
                a(oo4Var, dVar);
            }
        }

        public final void a(oo4 oo4Var, rp4.d dVar) {
            ArrayList<uo4> n;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLL(1048576, this, oo4Var, dVar) != null) || oo4Var == null || dVar == null || (n = oo4Var.n()) == null) {
                return;
            }
            Iterator<uo4> it = n.iterator();
            int i = 0;
            while (it.hasNext()) {
                uo4 next = it.next();
                if (next instanceof zo4) {
                    zo4 zo4Var = (zo4) next;
                    if (this.b != 0 && zo4Var.i() == this.b && !next.e()) {
                        this.d = false;
                        next.a(1);
                        if (next.b() >= next.c().f()) {
                            next.f(true);
                            if (next.c().J() >= next.c().A()) {
                                dVar.b(next);
                            }
                        }
                        dVar.c(oo4Var);
                    }
                } else if (next instanceof xo4) {
                    xo4 xo4Var = (xo4) next;
                    if (!oo4Var.M() && xo4Var.d() == oo4Var.w()) {
                        if (this.b != 0 && xo4Var.i() == this.b && !next.e()) {
                            this.d = false;
                            next.a(1);
                        }
                        i = (int) (i + next.b());
                        if (this.b != 0 && xo4Var.i() == this.b && !next.e()) {
                            if (next.b() >= oo4Var.f()) {
                                next.f(true);
                                oo4Var.J();
                            }
                            dVar.c(oo4Var);
                        }
                        int l = oo4Var.l();
                        int A = oo4Var.A();
                        long f = oo4Var.f() * oo4Var.A();
                        if (this.b != 0 && xo4Var.i() == this.b) {
                            next.e();
                        }
                        if (i >= f && l >= A) {
                            dVar.a(oo4Var);
                            oo4Var.d0(true);
                        }
                    }
                } else if (next instanceof wo4) {
                    if (this.c != 0 && ((wo4) next).i() == this.c && !next.e()) {
                        this.d = false;
                        next.a(1);
                        if (next.b() >= next.c().f()) {
                            next.f(true);
                            if (next.c().H() >= next.c().p()) {
                                dVar.b(next);
                            }
                        }
                    }
                } else if ((next instanceof vo4) && !next.e()) {
                    this.d = false;
                    next.a(1);
                    if (next.b() >= next.c().f()) {
                        next.f(true);
                        dVar.b(next);
                    }
                }
            }
        }

        public final void b(oo4 oo4Var, rp4.d dVar) {
            ArrayList<uo4> n;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, oo4Var, dVar) != null) || oo4Var == null || dVar == null || (n = oo4Var.n()) == null) {
                return;
            }
            Iterator<uo4> it = n.iterator();
            while (it.hasNext()) {
                uo4 next = it.next();
                if ((next instanceof yo4) && !((yo4) next).j() && !next.e()) {
                    this.d = false;
                    next.a(1);
                    if (next.b() >= next.c().f()) {
                        next.f(true);
                        dVar.a(oo4Var);
                    }
                    dVar.c(oo4Var);
                }
            }
        }

        public final void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.d = true;
                List<oo4> list = (List) this.e.b.get(oo4.Y);
                List<oo4> list2 = (List) this.e.b.get(this.a);
                if (ListUtils.isEmpty(list) && ListUtils.isEmpty(list2)) {
                    this.e.e.compareAndSet(true, false);
                    return;
                }
                rp4.d dVar = new rp4.d();
                dVar.a = new LinkedList();
                dVar.b = new LinkedList();
                dVar.c = new LinkedList();
                d(list, dVar);
                e(list2, dVar);
                if (this.d) {
                    this.e.e.compareAndSet(true, false);
                }
                if (!ListUtils.isEmpty(dVar.c)) {
                    mo4.g().k(dVar.c);
                }
                if (!ListUtils.isEmpty(dVar.a) || !ListUtils.isEmpty(dVar.b)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921379, dVar));
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                if (this.a == 0 || !this.e.e.get()) {
                    synchronized (this.e.e) {
                        try {
                            this.e.e.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                c();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g extends BdAsyncTask<oo4, Integer, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public g(po4 po4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {po4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(oo4... oo4VarArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, oo4VarArr)) == null) {
                if (oo4VarArr != null && oo4VarArr.length > 0 && oo4VarArr[0] != null) {
                    mo4.g().a(oo4VarArr[0]);
                    return null;
                }
                return null;
            }
            return (Void) invokeL.objValue;
        }

        public /* synthetic */ g(po4 po4Var, a aVar) {
            this(po4Var);
        }
    }

    /* loaded from: classes7.dex */
    public class h extends BdAsyncTask<List<oo4>, Integer, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public h(po4 po4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {po4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(List<oo4>... listArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, listArr)) == null) {
                if (listArr != null && listArr.length > 0 && listArr[0] != null) {
                    mo4.g().b(listArr[0]);
                    return null;
                }
                return null;
            }
            return (Void) invokeL.objValue;
        }

        public /* synthetic */ h(po4 po4Var, a aVar) {
            this(po4Var);
        }
    }

    /* loaded from: classes7.dex */
    public class i extends BdAsyncTask<oo4, Integer, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public i(po4 po4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {po4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(oo4... oo4VarArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, oo4VarArr)) == null) {
                if (oo4VarArr != null && oo4VarArr.length > 0 && oo4VarArr[0] != null) {
                    mo4.g().e(oo4VarArr[0]);
                    return null;
                }
                return null;
            }
            return (Void) invokeL.objValue;
        }

        public /* synthetic */ i(po4 po4Var, a aVar) {
            this(po4Var);
        }
    }

    /* loaded from: classes7.dex */
    public class j extends BdAsyncTask<Pair<oo4, oo4>, Integer, Pair<oo4, oo4>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ po4 a;

        public j(po4 po4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {po4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = po4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(Pair<oo4, oo4> pair) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pair) == null) && pair != null) {
                oo4 oo4Var = (oo4) pair.first;
                oo4 oo4Var2 = (oo4) pair.second;
                if (oo4Var2 != null) {
                    this.a.t(oo4Var2);
                }
                if (oo4Var == null) {
                    return;
                }
                this.a.K(oo4Var);
            }
        }

        public /* synthetic */ j(po4 po4Var, a aVar) {
            this(po4Var);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Pair<oo4, oo4> doInBackground(Pair<oo4, oo4>... pairArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pairArr)) == null) {
                if (pairArr != null && pairArr.length > 0 && pairArr[0] != null) {
                    Pair<oo4, oo4> pair = pairArr[0];
                    oo4 oo4Var = (oo4) pair.first;
                    oo4 oo4Var2 = (oo4) pair.second;
                    if (oo4Var2 != null) {
                        mo4.g().e(oo4Var2);
                    }
                    if (oo4Var != null) {
                        mo4.g().a(oo4Var);
                        return pair;
                    }
                    return pair;
                }
                return null;
            }
            return (Pair) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class k extends BdAsyncTask<Void, Integer, LinkedList<oo4>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ po4 a;

        public k(po4 po4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {po4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = po4Var;
        }

        public /* synthetic */ k(po4 po4Var, a aVar) {
            this(po4Var);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public LinkedList<oo4> doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                LinkedList<oo4> linkedList = new LinkedList<>();
                linkedList.addAll(mo4.g().f());
                Iterator<oo4> it = linkedList.iterator();
                while (it.hasNext()) {
                    oo4 next = it.next();
                    if (next != null && next.N()) {
                        mo4.g().e(next);
                        it.remove();
                    } else if (next != null && next.x() == 7) {
                        next.o0();
                        mo4.g().i(next);
                    }
                }
                return linkedList;
            }
            return (LinkedList) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(LinkedList<oo4> linkedList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, linkedList) == null) {
                super.onPostExecute(linkedList);
                if (linkedList == null) {
                    return;
                }
                if (!linkedList.isEmpty()) {
                    Iterator<oo4> it = linkedList.iterator();
                    while (it.hasNext()) {
                        oo4 next = it.next();
                        if (next.h() != null) {
                            this.a.K(next);
                        }
                    }
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921391));
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class l {
        public static /* synthetic */ Interceptable $ic;
        public static final po4 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-511685236, "Lcom/baidu/tieba/po4$l;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-511685236, "Lcom/baidu/tieba/po4$l;");
                    return;
                }
            }
            a = new po4(null);
        }
    }

    /* loaded from: classes7.dex */
    public class m extends BdAsyncTask<oo4, Integer, oo4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ po4 a;

        public m(po4 po4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {po4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = po4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public oo4 doInBackground(oo4... oo4VarArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, oo4VarArr)) == null) {
                if (oo4VarArr != null && oo4VarArr.length > 0 && oo4VarArr[0] != null) {
                    oo4 oo4Var = oo4VarArr[0];
                    mo4.g().i(oo4Var);
                    return oo4Var;
                }
                return null;
            }
            return (oo4) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(oo4 oo4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, oo4Var) == null) && oo4Var != null && oo4Var.z) {
                oo4Var.z = false;
                po4 po4Var = this.a;
                po4Var.Q(po4Var.k, this.a.l);
            }
        }

        public /* synthetic */ m(po4 po4Var, a aVar) {
            this(po4Var);
        }
    }

    public po4() {
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
        this.a = Executors.newSingleThreadScheduledExecutor();
        this.b = new SparseArray<>();
        this.c = new LinkedList<>();
        this.d = new f(this, null);
        this.e = new AtomicBoolean(false);
        this.f = false;
        this.g = false;
        this.o = false;
        this.p = new a(this, 2921391);
        this.q = new b(this, 2001011);
        this.r = new c(this, 2001371);
        this.s = new d(this);
        this.t = new e(this);
        BdUniqueId gen = BdUniqueId.gen();
        this.h = gen;
        rp4 rp4Var = new rp4(gen);
        this.i = rp4Var;
        rp4Var.w(this.t);
        lp4 lp4Var = new lp4(this.h);
        this.j = lp4Var;
        lp4Var.g(this.s);
        new np4(this.h);
        this.r.setTag(this.h);
        MessageManager.getInstance().registerListener(this.r);
        this.q.setTag(this.h);
        MessageManager.getInstance().registerListener(this.q);
        this.p.setPriority(Integer.MIN_VALUE);
        this.p.setTag(this.h);
        MessageManager.getInstance().registerListener(this.p);
        w45.e().f();
        cp4.c().d(this.h);
        R();
        if (A()) {
            new k(this, null).execute(new Void[0]);
        }
    }

    public /* synthetic */ po4(a aVar) {
        this();
    }

    public final void G(oo4 oo4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, oo4Var) == null) {
            t(oo4Var);
            new i(this, null).execute(oo4Var);
        }
    }

    public void M(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.o = z;
        }
    }

    public final void T(oo4 oo4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, oo4Var) == null) {
            U(oo4Var);
            new m(this, null).execute(oo4Var);
        }
    }

    public boolean y(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048608, this, i2)) == null) {
            List<oo4> list = this.b.get(i2);
            if (list != null && !list.isEmpty()) {
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public final void H(oo4 oo4Var, oo4 oo4Var2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, oo4Var, oo4Var2) == null) {
            t(oo4Var2);
            new j(this, null).execute(new Pair(oo4Var, oo4Var2));
        }
    }

    public static final po4 w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            return l.a;
        }
        return (po4) invokeV.objValue;
    }

    public final boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return TbadkCoreApplication.getInst().isMainProcess(true);
        }
        return invokeV.booleanValue;
    }

    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.o;
        }
        return invokeV.booleanValue;
    }

    public boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int i2 = SharedPrefHelper.getInstance().getInt("app_restart_times", 0);
            if (TbSingleton.getInstance().isNewUserRedPackageShowed() || i2 <= 1) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.e.compareAndSet(true, false);
            this.d.f(0);
            this.d.h(0L);
            this.d.g(0L);
            rp4 rp4Var = this.i;
            if (rp4Var != null) {
                rp4Var.m();
            }
        }
    }

    public boolean I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.j == null || !A() || !this.g) {
                return false;
            }
            this.j.f(z(), C(), 1);
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.j == null || A()) {
                return false;
            }
            this.j.f(z(), C(), 1);
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.a.scheduleWithFixedDelay(this.d, 0L, 1L, TimeUnit.SECONDS);
        }
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return UtilHelper.isSameDay(SharedPrefHelper.getInstance().getLong("pref_key_last_active_config", 0L), System.currentTimeMillis());
        }
        return invokeV.booleanValue;
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return UtilHelper.isSameDay(x(), System.currentTimeMillis());
        }
        return invokeV.booleanValue;
    }

    public int v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.m;
        }
        return invokeV.intValue;
    }

    public final long x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            long j2 = SharedPrefHelper.getInstance().getLong("pref_key_active_config_info", 0L);
            this.n = j2;
            return j2;
        }
        return invokeV.longValue;
    }

    public boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return !r();
        }
        return invokeV.booleanValue;
    }

    public final boolean B(oo4 oo4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, oo4Var)) == null) {
            if (oo4Var == null) {
                return false;
            }
            int[] h2 = oo4Var.h();
            if (h2 == null) {
                return true;
            }
            for (int i2 : h2) {
                List<oo4> list = this.b.get(i2);
                if (list == null) {
                    return false;
                }
                for (oo4 oo4Var2 : list) {
                    if (oo4Var2 != null && oo4Var2.d() == oo4Var.d() && oo4Var2.q() == oo4Var.q()) {
                        if (oo4Var2.N()) {
                            H(oo4Var, oo4Var2);
                        }
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final oo4 u(oo4 oo4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, oo4Var)) == null) {
            if (oo4Var == null) {
                return null;
            }
            for (int i2 = 0; i2 < this.b.size(); i2++) {
                List<oo4> valueAt = this.b.valueAt(i2);
                if (valueAt != null && !valueAt.isEmpty()) {
                    for (oo4 oo4Var2 : valueAt) {
                        if (oo4Var2 != null && oo4Var2.d() == oo4Var.d() && oo4Var2.q() == oo4Var.q()) {
                            return oo4Var2;
                        }
                    }
                    continue;
                }
            }
            return null;
        }
        return (oo4) invokeL.objValue;
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            List<oo4> list = this.b.get(oo4.Y);
            if (ListUtils.isEmpty(list)) {
                return;
            }
            boolean z = false;
            for (oo4 oo4Var : list) {
                Iterator<uo4> it = oo4Var.n().iterator();
                while (it.hasNext()) {
                    uo4 next = it.next();
                    if (next instanceof yo4) {
                        yo4 yo4Var = (yo4) next;
                        if (!next.e()) {
                            yo4Var.i();
                            z = true;
                        }
                    }
                }
            }
            if (z && !this.e.get()) {
                this.d.f(oo4.Y);
                this.e.compareAndSet(false, true);
                synchronized (this.e) {
                    this.e.notify();
                }
            }
        }
    }

    public final void K(oo4 oo4Var) {
        int[] h2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, oo4Var) == null) {
            for (int i2 : oo4Var.h()) {
                List<oo4> list = this.b.get(i2);
                if (list == null) {
                    LinkedList linkedList = new LinkedList();
                    linkedList.add(oo4Var);
                    this.b.put(i2, linkedList);
                } else {
                    list.add(oo4Var);
                }
            }
        }
    }

    public void m(oo4 oo4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048597, this, oo4Var) != null) || oo4Var == null) {
            return;
        }
        if (oo4Var.x() == 9) {
            cp4.c().f(oo4Var);
        } else if (!this.f) {
            this.c.add(oo4Var);
        } else if (B(oo4Var)) {
        } else {
            K(oo4Var);
            new g(this, null).execute(oo4Var);
        }
    }

    public void L(int i2, long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) != null) || !A()) {
            return;
        }
        this.m = i2;
        long j3 = this.l;
        if (j3 > 0 && this.k > 0 && (j2 == 0 || j2 != j3)) {
            S(this.k, this.l);
            this.l = 0L;
            this.k = 0;
        }
        N();
    }

    public void N() {
        int i2;
        List<oo4> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && A() && this.f && (list = this.b.get((i2 = oo4.Y))) != null && !list.isEmpty()) {
            boolean z = false;
            for (oo4 oo4Var : list) {
                if (oo4Var.x() == 8) {
                    Iterator<uo4> it = oo4Var.n().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        uo4 next = it.next();
                        oo4 c2 = next.c();
                        if (c2 != null && (next instanceof yo4) && c2.d() == oo4Var.d() && c2.q() == oo4Var.q()) {
                            ((yo4) next).i();
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        yo4 yo4Var = new yo4(oo4Var);
                        yo4Var.g(0L);
                        yo4Var.f(false);
                        oo4Var.a(yo4Var);
                    }
                }
            }
            this.d.f(i2);
            this.e.compareAndSet(false, true);
            synchronized (this.e) {
                this.e.notify();
            }
        }
    }

    public void O(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048590, this, i2) == null) && A() && i2 != 0 && this.f) {
            this.k = i2;
            List<oo4> list = this.b.get(i2);
            if (list != null && !list.isEmpty()) {
                boolean z = false;
                for (oo4 oo4Var : list) {
                    if (oo4Var.x() == 4) {
                        Iterator<uo4> it = oo4Var.n().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            uo4 next = it.next();
                            if ((next instanceof vo4) && next.c().d() == oo4Var.d() && next.c().q() == oo4Var.q()) {
                                z = true;
                                break;
                            }
                        }
                        if (!z) {
                            vo4 vo4Var = new vo4(oo4Var);
                            vo4Var.g(0L);
                            vo4Var.f(false);
                            oo4Var.a(vo4Var);
                        }
                    }
                }
                this.d.f(i2);
                this.e.compareAndSet(false, true);
                synchronized (this.e) {
                    this.e.notify();
                }
            }
        }
    }

    public final void t(oo4 oo4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048604, this, oo4Var) != null) || oo4Var == null) {
            return;
        }
        Iterator<uo4> it = oo4Var.n().iterator();
        while (it.hasNext()) {
            uo4 next = it.next();
            if (next != null && next.c() != null) {
                oo4 c2 = next.c();
                if (c2.d() == oo4Var.d() && c2.q() == oo4Var.q()) {
                    it.remove();
                }
            }
        }
        for (int i2 = 0; i2 < this.b.size(); i2++) {
            List<oo4> valueAt = this.b.valueAt(i2);
            if (valueAt != null && !valueAt.isEmpty()) {
                Iterator<oo4> it2 = valueAt.iterator();
                while (it2.hasNext()) {
                    oo4 next2 = it2.next();
                    if (next2 != null && next2.d() == oo4Var.d() && next2.q() == oo4Var.q()) {
                        it2.remove();
                    }
                }
            }
        }
        no4.a("deleteActivityMissionInfoDataInMemory-->activityId=" + oo4Var.d() + ",missionId=" + oo4Var.q());
    }

    public void P(int i2, long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) && A() && i2 != 0 && j2 != 0 && this.f) {
            this.k = i2;
            List<oo4> list = this.b.get(i2);
            if (list != null && !list.isEmpty()) {
                boolean z = false;
                for (oo4 oo4Var : list) {
                    if (oo4Var.x() == 2) {
                        Iterator<uo4> it = oo4Var.n().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            uo4 next = it.next();
                            if ((next instanceof wo4) && next.c().d() == oo4Var.d() && next.c().q() == oo4Var.q() && ((wo4) next).i() == j2) {
                                z = true;
                                break;
                            }
                        }
                        if (!z) {
                            wo4 wo4Var = new wo4(oo4Var, j2);
                            wo4Var.g(0L);
                            wo4Var.f(false);
                            wo4Var.h(oo4Var.w());
                            oo4Var.a(wo4Var);
                        }
                    }
                }
                this.d.f(i2);
                this.d.g(j2);
                this.e.compareAndSet(false, true);
                synchronized (this.e) {
                    this.e.notify();
                }
            }
        }
    }

    public void Q(int i2, long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) && A() && i2 != 0 && j2 != 0 && this.f) {
            this.k = i2;
            List<oo4> list = this.b.get(i2);
            if (list != null && !list.isEmpty()) {
                for (oo4 oo4Var : list) {
                    if (oo4Var.x() == 1) {
                        p(oo4Var, j2);
                    } else if (oo4Var.x() == 7 && !oo4Var.K(j2)) {
                        o(oo4Var, j2);
                    }
                }
                this.d.f(i2);
                this.d.h(j2);
                this.l = j2;
                this.e.compareAndSet(false, true);
                synchronized (this.e) {
                    this.e.notify();
                }
            }
        }
    }

    public void S(int i2, long j2) {
        List<oo4> list;
        xo4 xo4Var;
        oo4 c2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) && (list = this.b.get(i2)) != null && !list.isEmpty()) {
            for (oo4 oo4Var : list) {
                if (oo4Var.x() == 7) {
                    Iterator<uo4> it = oo4Var.n().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            uo4 next = it.next();
                            if ((next instanceof xo4) && (c2 = (xo4Var = (xo4) next).c()) != null && xo4Var.i() == j2 && c2.d() == oo4Var.d() && c2.q() == oo4Var.q()) {
                                next.f(true);
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public final void o(oo4 oo4Var, long j2) {
        boolean z;
        xo4 xo4Var;
        oo4 c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048599, this, oo4Var, j2) == null) {
            Iterator<uo4> it = oo4Var.n().iterator();
            while (true) {
                if (it.hasNext()) {
                    uo4 next = it.next();
                    if ((next instanceof xo4) && (c2 = (xo4Var = (xo4) next).c()) != null && xo4Var.i() == j2 && c2.d() == oo4Var.d() && c2.q() == oo4Var.q()) {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
            if (!z) {
                xo4 xo4Var2 = new xo4(oo4Var, j2);
                xo4Var2.g(0L);
                xo4Var2.f(false);
                xo4Var2.h(oo4Var.w());
                oo4Var.a(xo4Var2);
            }
        }
    }

    public final void p(oo4 oo4Var, long j2) {
        boolean z;
        zo4 zo4Var;
        oo4 c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048600, this, oo4Var, j2) == null) {
            Iterator<uo4> it = oo4Var.n().iterator();
            while (true) {
                if (it.hasNext()) {
                    uo4 next = it.next();
                    if ((next instanceof zo4) && (c2 = (zo4Var = (zo4) next).c()) != null && zo4Var.i() == j2 && c2.d() == oo4Var.d() && c2.q() == oo4Var.q()) {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
            if (!z) {
                zo4 zo4Var2 = new zo4(oo4Var, j2);
                zo4Var2.g(0L);
                zo4Var2.f(false);
                zo4Var2.h(oo4Var.w());
                oo4Var.a(zo4Var2);
            }
        }
    }

    public final void U(oo4 oo4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048596, this, oo4Var) != null) || oo4Var == null) {
            return;
        }
        int x = oo4Var.x();
        Iterator<uo4> it = oo4Var.n().iterator();
        while (it.hasNext()) {
            uo4 next = it.next();
            if (next != null && next.c() != null) {
                oo4 c2 = next.c();
                if (c2.d() == oo4Var.d() && c2.q() == oo4Var.q()) {
                    if (x == 7 && (next instanceof xo4)) {
                        ((xo4) next).f(true);
                    } else if (x == 1 && (next instanceof zo4)) {
                        ((zo4) next).f(true);
                    }
                }
            }
        }
        oo4Var.d0(false);
    }

    public void n(List<oo4> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048598, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (!this.f) {
            this.c.addAll(list);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (oo4 oo4Var : list) {
            if (oo4Var != null) {
                if (oo4Var.x() == 9) {
                    cp4.c().f(oo4Var);
                } else if (!B(oo4Var)) {
                    K(oo4Var);
                    arrayList.add(oo4Var);
                }
            }
        }
        new h(this, null).execute(arrayList);
    }

    public void q() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048601, this) != null) || this.j == null || !A() || !this.g) {
            return;
        }
        if (!s() || D()) {
            this.j.f(z(), C(), 0);
        }
    }
}
