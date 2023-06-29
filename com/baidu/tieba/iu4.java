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
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.ov4;
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
/* loaded from: classes6.dex */
public class iu4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ScheduledExecutorService a;
    public final SparseArray<List<hu4>> b;
    public final LinkedList<hu4> c;
    public f d;
    public AtomicBoolean e;
    public boolean f;
    public boolean g;
    public BdUniqueId h;
    public ov4 i;
    public iv4 j;
    public int k;
    public long l;
    public int m;
    public long n;
    public boolean o;
    public CustomMessageListener p;
    public CustomMessageListener q;
    public CustomMessageListener r;
    public gv4<hv4> s;
    public uz4 t;

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iu4 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(iu4 iu4Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iu4Var, Integer.valueOf(i)};
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
            this.a = iu4Var;
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
                    this.a.m((hu4) it.next());
                }
                this.a.c.clear();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iu4 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(iu4 iu4Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iu4Var, Integer.valueOf(i)};
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
            this.a = iu4Var;
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

    /* loaded from: classes6.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iu4 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(iu4 iu4Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iu4Var, Integer.valueOf(i)};
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
            this.a = iu4Var;
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

    /* loaded from: classes6.dex */
    public class d implements gv4<hv4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iu4 a;

        @Override // com.baidu.tieba.tz4
        public void onError(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) {
            }
        }

        public d(iu4 iu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iu4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iu4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.tz4
        /* renamed from: c */
        public void onSuccess(hv4 hv4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hv4Var) == null) && hv4Var != null) {
                this.a.n(hv4Var.b());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.gv4
        /* renamed from: b */
        public void a(hv4 hv4Var) {
            ActiveCenterData activeCenterData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hv4Var) == null) && hv4Var != null && (activeCenterData = hv4Var.g) != null && activeCenterData.mission != null) {
                hu4 hu4Var = new hu4();
                hu4Var.P(hv4Var.g.mission);
                ArrayList arrayList = new ArrayList();
                arrayList.add(hu4Var);
                this.a.n(arrayList);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements uz4<hu4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iu4 a;

        public e(iu4 iu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iu4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iu4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.uz4
        /* renamed from: b */
        public void a(hu4 hu4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hu4Var) != null) || hu4Var == null) {
                return;
            }
            hu4 u = this.a.u(hu4Var);
            if (u != null && u.z) {
                u.S();
                this.a.T(u);
                return;
            }
            tu4.b().h(u);
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
                this.a.G(hu4Var);
            } else {
                this.a.G(u);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile int a;
        public volatile long b;
        public volatile long c;
        public volatile boolean d;
        public final /* synthetic */ iu4 e;

        public f(iu4 iu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iu4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = iu4Var;
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

        public /* synthetic */ f(iu4 iu4Var, a aVar) {
            this(iu4Var);
        }

        public final void d(List<hu4> list, ov4.d dVar) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLL(1048579, this, list, dVar) != null) || ListUtils.isEmpty(list)) {
                return;
            }
            for (hu4 hu4Var : list) {
                b(hu4Var, dVar);
            }
        }

        public final void e(List<hu4> list, ov4.d dVar) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLL(1048580, this, list, dVar) != null) || ListUtils.isEmpty(list)) {
                return;
            }
            for (hu4 hu4Var : list) {
                a(hu4Var, dVar);
            }
        }

        public final void a(hu4 hu4Var, ov4.d dVar) {
            ArrayList<nu4> n;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLL(1048576, this, hu4Var, dVar) != null) || hu4Var == null || dVar == null || (n = hu4Var.n()) == null) {
                return;
            }
            Iterator<nu4> it = n.iterator();
            int i = 0;
            while (it.hasNext()) {
                nu4 next = it.next();
                if (next instanceof su4) {
                    su4 su4Var = (su4) next;
                    if (this.b != 0 && su4Var.i() == this.b && !next.e()) {
                        this.d = false;
                        next.a(1);
                        if (next.b() >= next.c().f()) {
                            next.f(true);
                            if (next.c().J() >= next.c().A()) {
                                dVar.b(next);
                            }
                        }
                        dVar.c(hu4Var);
                    }
                } else if (next instanceof qu4) {
                    qu4 qu4Var = (qu4) next;
                    if (!hu4Var.M() && qu4Var.d() == hu4Var.w()) {
                        if (this.b != 0 && qu4Var.i() == this.b && !next.e()) {
                            this.d = false;
                            next.a(1);
                        }
                        i = (int) (i + next.b());
                        if (this.b != 0 && qu4Var.i() == this.b && !next.e()) {
                            if (next.b() >= hu4Var.f()) {
                                next.f(true);
                                hu4Var.J();
                            }
                            dVar.c(hu4Var);
                        }
                        int l = hu4Var.l();
                        int A = hu4Var.A();
                        long f = hu4Var.f() * hu4Var.A();
                        if (this.b != 0 && qu4Var.i() == this.b) {
                            next.e();
                        }
                        if (i >= f && l >= A) {
                            dVar.a(hu4Var);
                            hu4Var.d0(true);
                        }
                    }
                } else if (next instanceof pu4) {
                    if (this.c != 0 && ((pu4) next).i() == this.c && !next.e()) {
                        this.d = false;
                        next.a(1);
                        if (next.b() >= next.c().f()) {
                            next.f(true);
                            if (next.c().H() >= next.c().p()) {
                                dVar.b(next);
                            }
                        }
                    }
                } else if ((next instanceof ou4) && !next.e()) {
                    this.d = false;
                    next.a(1);
                    if (next.b() >= next.c().f()) {
                        next.f(true);
                        dVar.b(next);
                    }
                }
            }
        }

        public final void b(hu4 hu4Var, ov4.d dVar) {
            ArrayList<nu4> n;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hu4Var, dVar) != null) || hu4Var == null || dVar == null || (n = hu4Var.n()) == null) {
                return;
            }
            Iterator<nu4> it = n.iterator();
            while (it.hasNext()) {
                nu4 next = it.next();
                if ((next instanceof ru4) && !((ru4) next).j() && !next.e()) {
                    this.d = false;
                    next.a(1);
                    if (next.b() >= next.c().f()) {
                        next.f(true);
                        dVar.a(hu4Var);
                    }
                    dVar.c(hu4Var);
                }
            }
        }

        public final void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.d = true;
                List<hu4> list = (List) this.e.b.get(hu4.Y);
                List<hu4> list2 = (List) this.e.b.get(this.a);
                if (ListUtils.isEmpty(list) && ListUtils.isEmpty(list2)) {
                    this.e.e.compareAndSet(true, false);
                    return;
                }
                ov4.d dVar = new ov4.d();
                dVar.a = new LinkedList();
                dVar.b = new LinkedList();
                dVar.c = new LinkedList();
                d(list, dVar);
                e(list2, dVar);
                if (this.d) {
                    this.e.e.compareAndSet(true, false);
                }
                if (!ListUtils.isEmpty(dVar.c)) {
                    fu4.g().k(dVar.c);
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

    /* loaded from: classes6.dex */
    public class g extends BdAsyncTask<hu4, Integer, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public g(iu4 iu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iu4Var};
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
        public Void doInBackground(hu4... hu4VarArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, hu4VarArr)) == null) {
                if (hu4VarArr != null && hu4VarArr.length > 0 && hu4VarArr[0] != null) {
                    fu4.g().a(hu4VarArr[0]);
                    return null;
                }
                return null;
            }
            return (Void) invokeL.objValue;
        }

        public /* synthetic */ g(iu4 iu4Var, a aVar) {
            this(iu4Var);
        }
    }

    /* loaded from: classes6.dex */
    public class h extends BdAsyncTask<List<hu4>, Integer, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public h(iu4 iu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iu4Var};
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
        public Void doInBackground(List<hu4>... listArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, listArr)) == null) {
                if (listArr != null && listArr.length > 0 && listArr[0] != null) {
                    fu4.g().b(listArr[0]);
                    return null;
                }
                return null;
            }
            return (Void) invokeL.objValue;
        }

        public /* synthetic */ h(iu4 iu4Var, a aVar) {
            this(iu4Var);
        }
    }

    /* loaded from: classes6.dex */
    public class i extends BdAsyncTask<hu4, Integer, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public i(iu4 iu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iu4Var};
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
        public Void doInBackground(hu4... hu4VarArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, hu4VarArr)) == null) {
                if (hu4VarArr != null && hu4VarArr.length > 0 && hu4VarArr[0] != null) {
                    fu4.g().e(hu4VarArr[0]);
                    return null;
                }
                return null;
            }
            return (Void) invokeL.objValue;
        }

        public /* synthetic */ i(iu4 iu4Var, a aVar) {
            this(iu4Var);
        }
    }

    /* loaded from: classes6.dex */
    public class j extends BdAsyncTask<Pair<hu4, hu4>, Integer, Pair<hu4, hu4>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iu4 a;

        public j(iu4 iu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iu4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iu4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(Pair<hu4, hu4> pair) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pair) == null) && pair != null) {
                hu4 hu4Var = (hu4) pair.first;
                hu4 hu4Var2 = (hu4) pair.second;
                if (hu4Var2 != null) {
                    this.a.t(hu4Var2);
                }
                if (hu4Var == null) {
                    return;
                }
                this.a.K(hu4Var);
            }
        }

        public /* synthetic */ j(iu4 iu4Var, a aVar) {
            this(iu4Var);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Pair<hu4, hu4> doInBackground(Pair<hu4, hu4>... pairArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pairArr)) == null) {
                if (pairArr != null && pairArr.length > 0 && pairArr[0] != null) {
                    Pair<hu4, hu4> pair = pairArr[0];
                    hu4 hu4Var = (hu4) pair.first;
                    hu4 hu4Var2 = (hu4) pair.second;
                    if (hu4Var2 != null) {
                        fu4.g().e(hu4Var2);
                    }
                    if (hu4Var != null) {
                        fu4.g().a(hu4Var);
                        return pair;
                    }
                    return pair;
                }
                return null;
            }
            return (Pair) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class k extends BdAsyncTask<Void, Integer, LinkedList<hu4>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iu4 a;

        public k(iu4 iu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iu4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iu4Var;
        }

        public /* synthetic */ k(iu4 iu4Var, a aVar) {
            this(iu4Var);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public LinkedList<hu4> doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                LinkedList<hu4> linkedList = new LinkedList<>();
                linkedList.addAll(fu4.g().f());
                Iterator<hu4> it = linkedList.iterator();
                while (it.hasNext()) {
                    hu4 next = it.next();
                    if (next != null && next.N()) {
                        fu4.g().e(next);
                        it.remove();
                    } else if (next != null && next.x() == 7) {
                        next.o0();
                        fu4.g().i(next);
                    }
                }
                return linkedList;
            }
            return (LinkedList) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(LinkedList<hu4> linkedList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, linkedList) == null) {
                super.onPostExecute(linkedList);
                if (linkedList == null) {
                    return;
                }
                if (!linkedList.isEmpty()) {
                    Iterator<hu4> it = linkedList.iterator();
                    while (it.hasNext()) {
                        hu4 next = it.next();
                        if (next.h() != null) {
                            this.a.K(next);
                        }
                    }
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921391));
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class l {
        public static /* synthetic */ Interceptable $ic;
        public static final iu4 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-706548167, "Lcom/baidu/tieba/iu4$l;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-706548167, "Lcom/baidu/tieba/iu4$l;");
                    return;
                }
            }
            a = new iu4(null);
        }
    }

    /* loaded from: classes6.dex */
    public class m extends BdAsyncTask<hu4, Integer, hu4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iu4 a;

        public m(iu4 iu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iu4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iu4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public hu4 doInBackground(hu4... hu4VarArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, hu4VarArr)) == null) {
                if (hu4VarArr != null && hu4VarArr.length > 0 && hu4VarArr[0] != null) {
                    hu4 hu4Var = hu4VarArr[0];
                    fu4.g().i(hu4Var);
                    return hu4Var;
                }
                return null;
            }
            return (hu4) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(hu4 hu4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hu4Var) == null) && hu4Var != null && hu4Var.z) {
                hu4Var.z = false;
                iu4 iu4Var = this.a;
                iu4Var.Q(iu4Var.k, this.a.l);
            }
        }

        public /* synthetic */ m(iu4 iu4Var, a aVar) {
            this(iu4Var);
        }
    }

    public iu4() {
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
        ov4 ov4Var = new ov4(gen);
        this.i = ov4Var;
        ov4Var.w(this.t);
        iv4 iv4Var = new iv4(this.h);
        this.j = iv4Var;
        iv4Var.g(this.s);
        new kv4(this.h);
        this.r.setTag(this.h);
        MessageManager.getInstance().registerListener(this.r);
        this.q.setTag(this.h);
        MessageManager.getInstance().registerListener(this.q);
        this.p.setPriority(Integer.MIN_VALUE);
        this.p.setTag(this.h);
        MessageManager.getInstance().registerListener(this.p);
        p95.e().f();
        vu4.c().d(this.h);
        R();
        if (A()) {
            new k(this, null).execute(new Void[0]);
        }
    }

    public /* synthetic */ iu4(a aVar) {
        this();
    }

    public final void G(hu4 hu4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, hu4Var) == null) {
            t(hu4Var);
            new i(this, null).execute(hu4Var);
        }
    }

    public void M(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.o = z;
        }
    }

    public final void T(hu4 hu4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, hu4Var) == null) {
            U(hu4Var);
            new m(this, null).execute(hu4Var);
        }
    }

    public boolean y(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048608, this, i2)) == null) {
            List<hu4> list = this.b.get(i2);
            if (list != null && !list.isEmpty()) {
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public final void H(hu4 hu4Var, hu4 hu4Var2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, hu4Var, hu4Var2) == null) {
            t(hu4Var2);
            new j(this, null).execute(new Pair(hu4Var, hu4Var2));
        }
    }

    public static final iu4 w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            return l.a;
        }
        return (iu4) invokeV.objValue;
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
            int q = r95.p().q("app_restart_times", 0);
            if (TbSingleton.getInstance().isNewUserRedPackageShowed() || q <= 1) {
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
            ov4 ov4Var = this.i;
            if (ov4Var != null) {
                ov4Var.m();
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
            return UtilHelper.isSameDay(r95.p().r("pref_key_last_active_config", 0L), System.currentTimeMillis());
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
            long r = r95.p().r("pref_key_active_config_info", 0L);
            this.n = r;
            return r;
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

    public final boolean B(hu4 hu4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hu4Var)) == null) {
            if (hu4Var == null) {
                return false;
            }
            int[] h2 = hu4Var.h();
            if (h2 == null) {
                return true;
            }
            for (int i2 : h2) {
                List<hu4> list = this.b.get(i2);
                if (list == null) {
                    return false;
                }
                for (hu4 hu4Var2 : list) {
                    if (hu4Var2 != null && hu4Var2.d() == hu4Var.d() && hu4Var2.q() == hu4Var.q()) {
                        if (hu4Var2.N()) {
                            H(hu4Var, hu4Var2);
                        }
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final hu4 u(hu4 hu4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, hu4Var)) == null) {
            if (hu4Var == null) {
                return null;
            }
            for (int i2 = 0; i2 < this.b.size(); i2++) {
                List<hu4> valueAt = this.b.valueAt(i2);
                if (valueAt != null && !valueAt.isEmpty()) {
                    for (hu4 hu4Var2 : valueAt) {
                        if (hu4Var2 != null && hu4Var2.d() == hu4Var.d() && hu4Var2.q() == hu4Var.q()) {
                            return hu4Var2;
                        }
                    }
                    continue;
                }
            }
            return null;
        }
        return (hu4) invokeL.objValue;
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            List<hu4> list = this.b.get(hu4.Y);
            if (ListUtils.isEmpty(list)) {
                return;
            }
            boolean z = false;
            for (hu4 hu4Var : list) {
                Iterator<nu4> it = hu4Var.n().iterator();
                while (it.hasNext()) {
                    nu4 next = it.next();
                    if (next instanceof ru4) {
                        ru4 ru4Var = (ru4) next;
                        if (!next.e()) {
                            ru4Var.i();
                            z = true;
                        }
                    }
                }
            }
            if (z && !this.e.get()) {
                this.d.f(hu4.Y);
                this.e.compareAndSet(false, true);
                synchronized (this.e) {
                    this.e.notify();
                }
            }
        }
    }

    public final void K(hu4 hu4Var) {
        int[] h2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, hu4Var) == null) {
            for (int i2 : hu4Var.h()) {
                List<hu4> list = this.b.get(i2);
                if (list == null) {
                    LinkedList linkedList = new LinkedList();
                    linkedList.add(hu4Var);
                    this.b.put(i2, linkedList);
                } else {
                    list.add(hu4Var);
                }
            }
        }
    }

    public void m(hu4 hu4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048597, this, hu4Var) != null) || hu4Var == null) {
            return;
        }
        if (hu4Var.x() == 9) {
            vu4.c().f(hu4Var);
        } else if (!this.f) {
            this.c.add(hu4Var);
        } else if (B(hu4Var)) {
        } else {
            K(hu4Var);
            new g(this, null).execute(hu4Var);
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
        List<hu4> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && A() && this.f && (list = this.b.get((i2 = hu4.Y))) != null && !list.isEmpty()) {
            boolean z = false;
            for (hu4 hu4Var : list) {
                if (hu4Var.x() == 8) {
                    Iterator<nu4> it = hu4Var.n().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        nu4 next = it.next();
                        hu4 c2 = next.c();
                        if (c2 != null && (next instanceof ru4) && c2.d() == hu4Var.d() && c2.q() == hu4Var.q()) {
                            ((ru4) next).i();
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        ru4 ru4Var = new ru4(hu4Var);
                        ru4Var.g(0L);
                        ru4Var.f(false);
                        hu4Var.a(ru4Var);
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
            List<hu4> list = this.b.get(i2);
            if (list != null && !list.isEmpty()) {
                boolean z = false;
                for (hu4 hu4Var : list) {
                    if (hu4Var.x() == 4) {
                        Iterator<nu4> it = hu4Var.n().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            nu4 next = it.next();
                            if ((next instanceof ou4) && next.c().d() == hu4Var.d() && next.c().q() == hu4Var.q()) {
                                z = true;
                                break;
                            }
                        }
                        if (!z) {
                            ou4 ou4Var = new ou4(hu4Var);
                            ou4Var.g(0L);
                            ou4Var.f(false);
                            hu4Var.a(ou4Var);
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

    public final void t(hu4 hu4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048604, this, hu4Var) != null) || hu4Var == null) {
            return;
        }
        Iterator<nu4> it = hu4Var.n().iterator();
        while (it.hasNext()) {
            nu4 next = it.next();
            if (next != null && next.c() != null) {
                hu4 c2 = next.c();
                if (c2.d() == hu4Var.d() && c2.q() == hu4Var.q()) {
                    it.remove();
                }
            }
        }
        for (int i2 = 0; i2 < this.b.size(); i2++) {
            List<hu4> valueAt = this.b.valueAt(i2);
            if (valueAt != null && !valueAt.isEmpty()) {
                Iterator<hu4> it2 = valueAt.iterator();
                while (it2.hasNext()) {
                    hu4 next2 = it2.next();
                    if (next2 != null && next2.d() == hu4Var.d() && next2.q() == hu4Var.q()) {
                        it2.remove();
                    }
                }
            }
        }
        gu4.a("deleteActivityMissionInfoDataInMemory-->activityId=" + hu4Var.d() + ",missionId=" + hu4Var.q());
    }

    public void P(int i2, long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) && A() && i2 != 0 && j2 != 0 && this.f) {
            this.k = i2;
            List<hu4> list = this.b.get(i2);
            if (list != null && !list.isEmpty()) {
                boolean z = false;
                for (hu4 hu4Var : list) {
                    if (hu4Var.x() == 2) {
                        Iterator<nu4> it = hu4Var.n().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            nu4 next = it.next();
                            if ((next instanceof pu4) && next.c().d() == hu4Var.d() && next.c().q() == hu4Var.q() && ((pu4) next).i() == j2) {
                                z = true;
                                break;
                            }
                        }
                        if (!z) {
                            pu4 pu4Var = new pu4(hu4Var, j2);
                            pu4Var.g(0L);
                            pu4Var.f(false);
                            pu4Var.h(hu4Var.w());
                            hu4Var.a(pu4Var);
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
            List<hu4> list = this.b.get(i2);
            if (list != null && !list.isEmpty()) {
                for (hu4 hu4Var : list) {
                    if (hu4Var.x() == 1) {
                        p(hu4Var, j2);
                    } else if (hu4Var.x() == 7 && !hu4Var.K(j2)) {
                        o(hu4Var, j2);
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
        List<hu4> list;
        qu4 qu4Var;
        hu4 c2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) && (list = this.b.get(i2)) != null && !list.isEmpty()) {
            for (hu4 hu4Var : list) {
                if (hu4Var.x() == 7) {
                    Iterator<nu4> it = hu4Var.n().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            nu4 next = it.next();
                            if ((next instanceof qu4) && (c2 = (qu4Var = (qu4) next).c()) != null && qu4Var.i() == j2 && c2.d() == hu4Var.d() && c2.q() == hu4Var.q()) {
                                next.f(true);
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public final void o(hu4 hu4Var, long j2) {
        boolean z;
        qu4 qu4Var;
        hu4 c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048599, this, hu4Var, j2) == null) {
            Iterator<nu4> it = hu4Var.n().iterator();
            while (true) {
                if (it.hasNext()) {
                    nu4 next = it.next();
                    if ((next instanceof qu4) && (c2 = (qu4Var = (qu4) next).c()) != null && qu4Var.i() == j2 && c2.d() == hu4Var.d() && c2.q() == hu4Var.q()) {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
            if (!z) {
                qu4 qu4Var2 = new qu4(hu4Var, j2);
                qu4Var2.g(0L);
                qu4Var2.f(false);
                qu4Var2.h(hu4Var.w());
                hu4Var.a(qu4Var2);
            }
        }
    }

    public final void p(hu4 hu4Var, long j2) {
        boolean z;
        su4 su4Var;
        hu4 c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048600, this, hu4Var, j2) == null) {
            Iterator<nu4> it = hu4Var.n().iterator();
            while (true) {
                if (it.hasNext()) {
                    nu4 next = it.next();
                    if ((next instanceof su4) && (c2 = (su4Var = (su4) next).c()) != null && su4Var.i() == j2 && c2.d() == hu4Var.d() && c2.q() == hu4Var.q()) {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
            if (!z) {
                su4 su4Var2 = new su4(hu4Var, j2);
                su4Var2.g(0L);
                su4Var2.f(false);
                su4Var2.h(hu4Var.w());
                hu4Var.a(su4Var2);
            }
        }
    }

    public final void U(hu4 hu4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048596, this, hu4Var) != null) || hu4Var == null) {
            return;
        }
        int x = hu4Var.x();
        Iterator<nu4> it = hu4Var.n().iterator();
        while (it.hasNext()) {
            nu4 next = it.next();
            if (next != null && next.c() != null) {
                hu4 c2 = next.c();
                if (c2.d() == hu4Var.d() && c2.q() == hu4Var.q()) {
                    if (x == 7 && (next instanceof qu4)) {
                        ((qu4) next).f(true);
                    } else if (x == 1 && (next instanceof su4)) {
                        ((su4) next).f(true);
                    }
                }
            }
        }
        hu4Var.d0(false);
    }

    public void n(List<hu4> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048598, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (!this.f) {
            this.c.addAll(list);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (hu4 hu4Var : list) {
            if (hu4Var != null) {
                if (hu4Var.x() == 9) {
                    vu4.c().f(hu4Var);
                } else if (!B(hu4Var)) {
                    K(hu4Var);
                    arrayList.add(hu4Var);
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
