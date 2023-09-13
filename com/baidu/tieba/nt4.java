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
import com.baidu.tieba.pu4;
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
public class nt4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ScheduledExecutorService a;
    public final SparseArray<List<mt4>> b;
    public final LinkedList<mt4> c;
    public f d;
    public AtomicBoolean e;
    public boolean f;
    public boolean g;
    public BdUniqueId h;
    public pu4 i;
    public ju4 j;
    public int k;
    public long l;
    public int m;
    public long n;
    public boolean o;
    public CustomMessageListener p;
    public CustomMessageListener q;
    public CustomMessageListener r;
    public hu4<iu4> s;
    public rz4 t;

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nt4 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(nt4 nt4Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nt4Var, Integer.valueOf(i)};
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
            this.a = nt4Var;
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
                    this.a.m((mt4) it.next());
                }
                this.a.c.clear();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nt4 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(nt4 nt4Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nt4Var, Integer.valueOf(i)};
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
            this.a = nt4Var;
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
        public final /* synthetic */ nt4 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(nt4 nt4Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nt4Var, Integer.valueOf(i)};
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
            this.a = nt4Var;
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
    public class d implements hu4<iu4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nt4 a;

        @Override // com.baidu.tieba.qz4
        public void onError(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) {
            }
        }

        public d(nt4 nt4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nt4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nt4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qz4
        /* renamed from: c */
        public void onSuccess(iu4 iu4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, iu4Var) == null) && iu4Var != null) {
                this.a.n(iu4Var.b());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.hu4
        /* renamed from: b */
        public void a(iu4 iu4Var) {
            ActiveCenterData activeCenterData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iu4Var) == null) && iu4Var != null && (activeCenterData = iu4Var.g) != null && activeCenterData.mission != null) {
                mt4 mt4Var = new mt4();
                mt4Var.P(iu4Var.g.mission);
                ArrayList arrayList = new ArrayList();
                arrayList.add(mt4Var);
                this.a.n(arrayList);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements rz4<mt4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nt4 a;

        public e(nt4 nt4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nt4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nt4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rz4
        /* renamed from: b */
        public void a(mt4 mt4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mt4Var) != null) || mt4Var == null) {
                return;
            }
            mt4 u = this.a.u(mt4Var);
            if (u != null && u.z) {
                u.S();
                this.a.T(u);
                return;
            }
            yt4.b().h(u);
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
                this.a.G(mt4Var);
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
        public final /* synthetic */ nt4 e;

        public f(nt4 nt4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nt4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = nt4Var;
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

        public /* synthetic */ f(nt4 nt4Var, a aVar) {
            this(nt4Var);
        }

        public final void d(List<mt4> list, pu4.d dVar) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLL(1048579, this, list, dVar) != null) || ListUtils.isEmpty(list)) {
                return;
            }
            for (mt4 mt4Var : list) {
                b(mt4Var, dVar);
            }
        }

        public final void e(List<mt4> list, pu4.d dVar) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLL(1048580, this, list, dVar) != null) || ListUtils.isEmpty(list)) {
                return;
            }
            for (mt4 mt4Var : list) {
                a(mt4Var, dVar);
            }
        }

        public final void a(mt4 mt4Var, pu4.d dVar) {
            ArrayList<st4> n;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLL(1048576, this, mt4Var, dVar) != null) || mt4Var == null || dVar == null || (n = mt4Var.n()) == null) {
                return;
            }
            Iterator<st4> it = n.iterator();
            int i = 0;
            while (it.hasNext()) {
                st4 next = it.next();
                if (next instanceof xt4) {
                    xt4 xt4Var = (xt4) next;
                    if (this.b != 0 && xt4Var.i() == this.b && !next.e()) {
                        this.d = false;
                        next.a(1);
                        if (next.b() >= next.c().f()) {
                            next.f(true);
                            if (next.c().J() >= next.c().A()) {
                                dVar.b(next);
                            }
                        }
                        dVar.c(mt4Var);
                    }
                } else if (next instanceof vt4) {
                    vt4 vt4Var = (vt4) next;
                    if (!mt4Var.M() && vt4Var.d() == mt4Var.w()) {
                        if (this.b != 0 && vt4Var.i() == this.b && !next.e()) {
                            this.d = false;
                            next.a(1);
                        }
                        i = (int) (i + next.b());
                        if (this.b != 0 && vt4Var.i() == this.b && !next.e()) {
                            if (next.b() >= mt4Var.f()) {
                                next.f(true);
                                mt4Var.J();
                            }
                            dVar.c(mt4Var);
                        }
                        int l = mt4Var.l();
                        int A = mt4Var.A();
                        long f = mt4Var.f() * mt4Var.A();
                        if (this.b != 0 && vt4Var.i() == this.b) {
                            next.e();
                        }
                        if (i >= f && l >= A) {
                            dVar.a(mt4Var);
                            mt4Var.d0(true);
                        }
                    }
                } else if (next instanceof ut4) {
                    if (this.c != 0 && ((ut4) next).i() == this.c && !next.e()) {
                        this.d = false;
                        next.a(1);
                        if (next.b() >= next.c().f()) {
                            next.f(true);
                            if (next.c().H() >= next.c().p()) {
                                dVar.b(next);
                            }
                        }
                    }
                } else if ((next instanceof tt4) && !next.e()) {
                    this.d = false;
                    next.a(1);
                    if (next.b() >= next.c().f()) {
                        next.f(true);
                        dVar.b(next);
                    }
                }
            }
        }

        public final void b(mt4 mt4Var, pu4.d dVar) {
            ArrayList<st4> n;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mt4Var, dVar) != null) || mt4Var == null || dVar == null || (n = mt4Var.n()) == null) {
                return;
            }
            Iterator<st4> it = n.iterator();
            while (it.hasNext()) {
                st4 next = it.next();
                if ((next instanceof wt4) && !((wt4) next).j() && !next.e()) {
                    this.d = false;
                    next.a(1);
                    if (next.b() >= next.c().f()) {
                        next.f(true);
                        dVar.a(mt4Var);
                    }
                    dVar.c(mt4Var);
                }
            }
        }

        public final void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.d = true;
                List<mt4> list = (List) this.e.b.get(mt4.Y);
                List<mt4> list2 = (List) this.e.b.get(this.a);
                if (ListUtils.isEmpty(list) && ListUtils.isEmpty(list2)) {
                    this.e.e.compareAndSet(true, false);
                    return;
                }
                pu4.d dVar = new pu4.d();
                dVar.a = new LinkedList();
                dVar.b = new LinkedList();
                dVar.c = new LinkedList();
                d(list, dVar);
                e(list2, dVar);
                if (this.d) {
                    this.e.e.compareAndSet(true, false);
                }
                if (!ListUtils.isEmpty(dVar.c)) {
                    kt4.g().k(dVar.c);
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
    public class g extends BdAsyncTask<mt4, Integer, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public g(nt4 nt4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nt4Var};
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
        public Void doInBackground(mt4... mt4VarArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, mt4VarArr)) == null) {
                if (mt4VarArr != null && mt4VarArr.length > 0 && mt4VarArr[0] != null) {
                    kt4.g().a(mt4VarArr[0]);
                    return null;
                }
                return null;
            }
            return (Void) invokeL.objValue;
        }

        public /* synthetic */ g(nt4 nt4Var, a aVar) {
            this(nt4Var);
        }
    }

    /* loaded from: classes7.dex */
    public class h extends BdAsyncTask<List<mt4>, Integer, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public h(nt4 nt4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nt4Var};
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
        public Void doInBackground(List<mt4>... listArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, listArr)) == null) {
                if (listArr != null && listArr.length > 0 && listArr[0] != null) {
                    kt4.g().b(listArr[0]);
                    return null;
                }
                return null;
            }
            return (Void) invokeL.objValue;
        }

        public /* synthetic */ h(nt4 nt4Var, a aVar) {
            this(nt4Var);
        }
    }

    /* loaded from: classes7.dex */
    public class i extends BdAsyncTask<mt4, Integer, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public i(nt4 nt4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nt4Var};
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
        public Void doInBackground(mt4... mt4VarArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, mt4VarArr)) == null) {
                if (mt4VarArr != null && mt4VarArr.length > 0 && mt4VarArr[0] != null) {
                    kt4.g().e(mt4VarArr[0]);
                    return null;
                }
                return null;
            }
            return (Void) invokeL.objValue;
        }

        public /* synthetic */ i(nt4 nt4Var, a aVar) {
            this(nt4Var);
        }
    }

    /* loaded from: classes7.dex */
    public class j extends BdAsyncTask<Pair<mt4, mt4>, Integer, Pair<mt4, mt4>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nt4 a;

        public j(nt4 nt4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nt4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nt4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(Pair<mt4, mt4> pair) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pair) == null) && pair != null) {
                mt4 mt4Var = (mt4) pair.first;
                mt4 mt4Var2 = (mt4) pair.second;
                if (mt4Var2 != null) {
                    this.a.t(mt4Var2);
                }
                if (mt4Var == null) {
                    return;
                }
                this.a.K(mt4Var);
            }
        }

        public /* synthetic */ j(nt4 nt4Var, a aVar) {
            this(nt4Var);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Pair<mt4, mt4> doInBackground(Pair<mt4, mt4>... pairArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pairArr)) == null) {
                if (pairArr != null && pairArr.length > 0 && pairArr[0] != null) {
                    Pair<mt4, mt4> pair = pairArr[0];
                    mt4 mt4Var = (mt4) pair.first;
                    mt4 mt4Var2 = (mt4) pair.second;
                    if (mt4Var2 != null) {
                        kt4.g().e(mt4Var2);
                    }
                    if (mt4Var != null) {
                        kt4.g().a(mt4Var);
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
    public class k extends BdAsyncTask<Void, Integer, LinkedList<mt4>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nt4 a;

        public k(nt4 nt4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nt4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nt4Var;
        }

        public /* synthetic */ k(nt4 nt4Var, a aVar) {
            this(nt4Var);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public LinkedList<mt4> doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                LinkedList<mt4> linkedList = new LinkedList<>();
                linkedList.addAll(kt4.g().f());
                Iterator<mt4> it = linkedList.iterator();
                while (it.hasNext()) {
                    mt4 next = it.next();
                    if (next != null && next.N()) {
                        kt4.g().e(next);
                        it.remove();
                    } else if (next != null && next.x() == 7) {
                        next.o0();
                        kt4.g().i(next);
                    }
                }
                return linkedList;
            }
            return (LinkedList) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(LinkedList<mt4> linkedList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, linkedList) == null) {
                super.onPostExecute(linkedList);
                if (linkedList == null) {
                    return;
                }
                if (!linkedList.isEmpty()) {
                    Iterator<mt4> it = linkedList.iterator();
                    while (it.hasNext()) {
                        mt4 next = it.next();
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
        public static final nt4 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-564325933, "Lcom/baidu/tieba/nt4$l;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-564325933, "Lcom/baidu/tieba/nt4$l;");
                    return;
                }
            }
            a = new nt4(null);
        }
    }

    /* loaded from: classes7.dex */
    public class m extends BdAsyncTask<mt4, Integer, mt4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nt4 a;

        public m(nt4 nt4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nt4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nt4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public mt4 doInBackground(mt4... mt4VarArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, mt4VarArr)) == null) {
                if (mt4VarArr != null && mt4VarArr.length > 0 && mt4VarArr[0] != null) {
                    mt4 mt4Var = mt4VarArr[0];
                    kt4.g().i(mt4Var);
                    return mt4Var;
                }
                return null;
            }
            return (mt4) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(mt4 mt4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mt4Var) == null) && mt4Var != null && mt4Var.z) {
                mt4Var.z = false;
                nt4 nt4Var = this.a;
                nt4Var.Q(nt4Var.k, this.a.l);
            }
        }

        public /* synthetic */ m(nt4 nt4Var, a aVar) {
            this(nt4Var);
        }
    }

    public nt4() {
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
        pu4 pu4Var = new pu4(gen);
        this.i = pu4Var;
        pu4Var.w(this.t);
        ju4 ju4Var = new ju4(this.h);
        this.j = ju4Var;
        ju4Var.g(this.s);
        new lu4(this.h);
        this.r.setTag(this.h);
        MessageManager.getInstance().registerListener(this.r);
        this.q.setTag(this.h);
        MessageManager.getInstance().registerListener(this.q);
        this.p.setPriority(Integer.MIN_VALUE);
        this.p.setTag(this.h);
        MessageManager.getInstance().registerListener(this.p);
        j95.e().f();
        au4.c().d(this.h);
        R();
        if (A()) {
            new k(this, null).execute(new Void[0]);
        }
    }

    public /* synthetic */ nt4(a aVar) {
        this();
    }

    public final void G(mt4 mt4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, mt4Var) == null) {
            t(mt4Var);
            new i(this, null).execute(mt4Var);
        }
    }

    public void M(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.o = z;
        }
    }

    public final void T(mt4 mt4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, mt4Var) == null) {
            U(mt4Var);
            new m(this, null).execute(mt4Var);
        }
    }

    public boolean y(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048608, this, i2)) == null) {
            List<mt4> list = this.b.get(i2);
            if (list != null && !list.isEmpty()) {
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public final void H(mt4 mt4Var, mt4 mt4Var2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, mt4Var, mt4Var2) == null) {
            t(mt4Var2);
            new j(this, null).execute(new Pair(mt4Var, mt4Var2));
        }
    }

    public static final nt4 w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            return l.a;
        }
        return (nt4) invokeV.objValue;
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
            pu4 pu4Var = this.i;
            if (pu4Var != null) {
                pu4Var.m();
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

    public final boolean B(mt4 mt4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mt4Var)) == null) {
            if (mt4Var == null) {
                return false;
            }
            int[] h2 = mt4Var.h();
            if (h2 == null) {
                return true;
            }
            for (int i2 : h2) {
                List<mt4> list = this.b.get(i2);
                if (list == null) {
                    return false;
                }
                for (mt4 mt4Var2 : list) {
                    if (mt4Var2 != null && mt4Var2.d() == mt4Var.d() && mt4Var2.q() == mt4Var.q()) {
                        if (mt4Var2.N()) {
                            H(mt4Var, mt4Var2);
                        }
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final mt4 u(mt4 mt4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, mt4Var)) == null) {
            if (mt4Var == null) {
                return null;
            }
            for (int i2 = 0; i2 < this.b.size(); i2++) {
                List<mt4> valueAt = this.b.valueAt(i2);
                if (valueAt != null && !valueAt.isEmpty()) {
                    for (mt4 mt4Var2 : valueAt) {
                        if (mt4Var2 != null && mt4Var2.d() == mt4Var.d() && mt4Var2.q() == mt4Var.q()) {
                            return mt4Var2;
                        }
                    }
                    continue;
                }
            }
            return null;
        }
        return (mt4) invokeL.objValue;
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            List<mt4> list = this.b.get(mt4.Y);
            if (ListUtils.isEmpty(list)) {
                return;
            }
            boolean z = false;
            for (mt4 mt4Var : list) {
                Iterator<st4> it = mt4Var.n().iterator();
                while (it.hasNext()) {
                    st4 next = it.next();
                    if (next instanceof wt4) {
                        wt4 wt4Var = (wt4) next;
                        if (!next.e()) {
                            wt4Var.i();
                            z = true;
                        }
                    }
                }
            }
            if (z && !this.e.get()) {
                this.d.f(mt4.Y);
                this.e.compareAndSet(false, true);
                synchronized (this.e) {
                    this.e.notify();
                }
            }
        }
    }

    public final void K(mt4 mt4Var) {
        int[] h2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, mt4Var) == null) {
            for (int i2 : mt4Var.h()) {
                List<mt4> list = this.b.get(i2);
                if (list == null) {
                    LinkedList linkedList = new LinkedList();
                    linkedList.add(mt4Var);
                    this.b.put(i2, linkedList);
                } else {
                    list.add(mt4Var);
                }
            }
        }
    }

    public void m(mt4 mt4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048597, this, mt4Var) != null) || mt4Var == null) {
            return;
        }
        if (mt4Var.x() == 9) {
            au4.c().f(mt4Var);
        } else if (!this.f) {
            this.c.add(mt4Var);
        } else if (B(mt4Var)) {
        } else {
            K(mt4Var);
            new g(this, null).execute(mt4Var);
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
        List<mt4> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && A() && this.f && (list = this.b.get((i2 = mt4.Y))) != null && !list.isEmpty()) {
            boolean z = false;
            for (mt4 mt4Var : list) {
                if (mt4Var.x() == 8) {
                    Iterator<st4> it = mt4Var.n().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        st4 next = it.next();
                        mt4 c2 = next.c();
                        if (c2 != null && (next instanceof wt4) && c2.d() == mt4Var.d() && c2.q() == mt4Var.q()) {
                            ((wt4) next).i();
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        wt4 wt4Var = new wt4(mt4Var);
                        wt4Var.g(0L);
                        wt4Var.f(false);
                        mt4Var.a(wt4Var);
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
            List<mt4> list = this.b.get(i2);
            if (list != null && !list.isEmpty()) {
                boolean z = false;
                for (mt4 mt4Var : list) {
                    if (mt4Var.x() == 4) {
                        Iterator<st4> it = mt4Var.n().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            st4 next = it.next();
                            if ((next instanceof tt4) && next.c().d() == mt4Var.d() && next.c().q() == mt4Var.q()) {
                                z = true;
                                break;
                            }
                        }
                        if (!z) {
                            tt4 tt4Var = new tt4(mt4Var);
                            tt4Var.g(0L);
                            tt4Var.f(false);
                            mt4Var.a(tt4Var);
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

    public final void t(mt4 mt4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048604, this, mt4Var) != null) || mt4Var == null) {
            return;
        }
        Iterator<st4> it = mt4Var.n().iterator();
        while (it.hasNext()) {
            st4 next = it.next();
            if (next != null && next.c() != null) {
                mt4 c2 = next.c();
                if (c2.d() == mt4Var.d() && c2.q() == mt4Var.q()) {
                    it.remove();
                }
            }
        }
        for (int i2 = 0; i2 < this.b.size(); i2++) {
            List<mt4> valueAt = this.b.valueAt(i2);
            if (valueAt != null && !valueAt.isEmpty()) {
                Iterator<mt4> it2 = valueAt.iterator();
                while (it2.hasNext()) {
                    mt4 next2 = it2.next();
                    if (next2 != null && next2.d() == mt4Var.d() && next2.q() == mt4Var.q()) {
                        it2.remove();
                    }
                }
            }
        }
        lt4.a("deleteActivityMissionInfoDataInMemory-->activityId=" + mt4Var.d() + ",missionId=" + mt4Var.q());
    }

    public void P(int i2, long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) && A() && i2 != 0 && j2 != 0 && this.f) {
            this.k = i2;
            List<mt4> list = this.b.get(i2);
            if (list != null && !list.isEmpty()) {
                boolean z = false;
                for (mt4 mt4Var : list) {
                    if (mt4Var.x() == 2) {
                        Iterator<st4> it = mt4Var.n().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            st4 next = it.next();
                            if ((next instanceof ut4) && next.c().d() == mt4Var.d() && next.c().q() == mt4Var.q() && ((ut4) next).i() == j2) {
                                z = true;
                                break;
                            }
                        }
                        if (!z) {
                            ut4 ut4Var = new ut4(mt4Var, j2);
                            ut4Var.g(0L);
                            ut4Var.f(false);
                            ut4Var.h(mt4Var.w());
                            mt4Var.a(ut4Var);
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
            List<mt4> list = this.b.get(i2);
            if (list != null && !list.isEmpty()) {
                for (mt4 mt4Var : list) {
                    if (mt4Var.x() == 1) {
                        p(mt4Var, j2);
                    } else if (mt4Var.x() == 7 && !mt4Var.K(j2)) {
                        o(mt4Var, j2);
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
        List<mt4> list;
        vt4 vt4Var;
        mt4 c2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) && (list = this.b.get(i2)) != null && !list.isEmpty()) {
            for (mt4 mt4Var : list) {
                if (mt4Var.x() == 7) {
                    Iterator<st4> it = mt4Var.n().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            st4 next = it.next();
                            if ((next instanceof vt4) && (c2 = (vt4Var = (vt4) next).c()) != null && vt4Var.i() == j2 && c2.d() == mt4Var.d() && c2.q() == mt4Var.q()) {
                                next.f(true);
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public final void o(mt4 mt4Var, long j2) {
        boolean z;
        vt4 vt4Var;
        mt4 c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048599, this, mt4Var, j2) == null) {
            Iterator<st4> it = mt4Var.n().iterator();
            while (true) {
                if (it.hasNext()) {
                    st4 next = it.next();
                    if ((next instanceof vt4) && (c2 = (vt4Var = (vt4) next).c()) != null && vt4Var.i() == j2 && c2.d() == mt4Var.d() && c2.q() == mt4Var.q()) {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
            if (!z) {
                vt4 vt4Var2 = new vt4(mt4Var, j2);
                vt4Var2.g(0L);
                vt4Var2.f(false);
                vt4Var2.h(mt4Var.w());
                mt4Var.a(vt4Var2);
            }
        }
    }

    public final void p(mt4 mt4Var, long j2) {
        boolean z;
        xt4 xt4Var;
        mt4 c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048600, this, mt4Var, j2) == null) {
            Iterator<st4> it = mt4Var.n().iterator();
            while (true) {
                if (it.hasNext()) {
                    st4 next = it.next();
                    if ((next instanceof xt4) && (c2 = (xt4Var = (xt4) next).c()) != null && xt4Var.i() == j2 && c2.d() == mt4Var.d() && c2.q() == mt4Var.q()) {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
            if (!z) {
                xt4 xt4Var2 = new xt4(mt4Var, j2);
                xt4Var2.g(0L);
                xt4Var2.f(false);
                xt4Var2.h(mt4Var.w());
                mt4Var.a(xt4Var2);
            }
        }
    }

    public final void U(mt4 mt4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048596, this, mt4Var) != null) || mt4Var == null) {
            return;
        }
        int x = mt4Var.x();
        Iterator<st4> it = mt4Var.n().iterator();
        while (it.hasNext()) {
            st4 next = it.next();
            if (next != null && next.c() != null) {
                mt4 c2 = next.c();
                if (c2.d() == mt4Var.d() && c2.q() == mt4Var.q()) {
                    if (x == 7 && (next instanceof vt4)) {
                        ((vt4) next).f(true);
                    } else if (x == 1 && (next instanceof xt4)) {
                        ((xt4) next).f(true);
                    }
                }
            }
        }
        mt4Var.d0(false);
    }

    public void n(List<mt4> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048598, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (!this.f) {
            this.c.addAll(list);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (mt4 mt4Var : list) {
            if (mt4Var != null) {
                if (mt4Var.x() == 9) {
                    au4.c().f(mt4Var);
                } else if (!B(mt4Var)) {
                    K(mt4Var);
                    arrayList.add(mt4Var);
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
