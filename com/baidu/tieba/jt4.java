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
import com.baidu.tieba.lu4;
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
public class jt4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ScheduledExecutorService a;
    public final SparseArray<List<it4>> b;
    public final LinkedList<it4> c;
    public f d;
    public AtomicBoolean e;
    public boolean f;
    public boolean g;
    public BdUniqueId h;
    public lu4 i;
    public fu4 j;
    public int k;
    public long l;
    public int m;
    public long n;
    public boolean o;
    public CustomMessageListener p;
    public CustomMessageListener q;
    public CustomMessageListener r;
    public du4<eu4> s;
    public mz4 t;

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jt4 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(jt4 jt4Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jt4Var, Integer.valueOf(i)};
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
            this.a = jt4Var;
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
                    this.a.m((it4) it.next());
                }
                this.a.c.clear();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jt4 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(jt4 jt4Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jt4Var, Integer.valueOf(i)};
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
            this.a = jt4Var;
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
        public final /* synthetic */ jt4 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(jt4 jt4Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jt4Var, Integer.valueOf(i)};
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
            this.a = jt4Var;
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
    public class d implements du4<eu4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jt4 a;

        @Override // com.baidu.tieba.lz4
        public void onError(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) {
            }
        }

        public d(jt4 jt4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jt4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jt4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lz4
        /* renamed from: c */
        public void onSuccess(eu4 eu4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eu4Var) == null) && eu4Var != null) {
                this.a.n(eu4Var.b());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.du4
        /* renamed from: b */
        public void a(eu4 eu4Var) {
            ActiveCenterData activeCenterData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eu4Var) == null) && eu4Var != null && (activeCenterData = eu4Var.g) != null && activeCenterData.mission != null) {
                it4 it4Var = new it4();
                it4Var.P(eu4Var.g.mission);
                ArrayList arrayList = new ArrayList();
                arrayList.add(it4Var);
                this.a.n(arrayList);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements mz4<it4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jt4 a;

        public e(jt4 jt4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jt4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jt4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mz4
        /* renamed from: b */
        public void a(it4 it4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, it4Var) != null) || it4Var == null) {
                return;
            }
            it4 u = this.a.u(it4Var);
            if (u != null && u.z) {
                u.S();
                this.a.T(u);
                return;
            }
            ut4.b().h(u);
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
                this.a.G(it4Var);
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
        public final /* synthetic */ jt4 e;

        public f(jt4 jt4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jt4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = jt4Var;
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

        public /* synthetic */ f(jt4 jt4Var, a aVar) {
            this(jt4Var);
        }

        public final void d(List<it4> list, lu4.d dVar) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLL(1048579, this, list, dVar) != null) || ListUtils.isEmpty(list)) {
                return;
            }
            for (it4 it4Var : list) {
                b(it4Var, dVar);
            }
        }

        public final void e(List<it4> list, lu4.d dVar) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLL(1048580, this, list, dVar) != null) || ListUtils.isEmpty(list)) {
                return;
            }
            for (it4 it4Var : list) {
                a(it4Var, dVar);
            }
        }

        public final void a(it4 it4Var, lu4.d dVar) {
            ArrayList<ot4> n;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLL(1048576, this, it4Var, dVar) != null) || it4Var == null || dVar == null || (n = it4Var.n()) == null) {
                return;
            }
            Iterator<ot4> it = n.iterator();
            int i = 0;
            while (it.hasNext()) {
                ot4 next = it.next();
                if (next instanceof tt4) {
                    tt4 tt4Var = (tt4) next;
                    if (this.b != 0 && tt4Var.i() == this.b && !next.e()) {
                        this.d = false;
                        next.a(1);
                        if (next.b() >= next.c().f()) {
                            next.f(true);
                            if (next.c().J() >= next.c().A()) {
                                dVar.b(next);
                            }
                        }
                        dVar.c(it4Var);
                    }
                } else if (next instanceof rt4) {
                    rt4 rt4Var = (rt4) next;
                    if (!it4Var.M() && rt4Var.d() == it4Var.w()) {
                        if (this.b != 0 && rt4Var.i() == this.b && !next.e()) {
                            this.d = false;
                            next.a(1);
                        }
                        i = (int) (i + next.b());
                        if (this.b != 0 && rt4Var.i() == this.b && !next.e()) {
                            if (next.b() >= it4Var.f()) {
                                next.f(true);
                                it4Var.J();
                            }
                            dVar.c(it4Var);
                        }
                        int l = it4Var.l();
                        int A = it4Var.A();
                        long f = it4Var.f() * it4Var.A();
                        if (this.b != 0 && rt4Var.i() == this.b) {
                            next.e();
                        }
                        if (i >= f && l >= A) {
                            dVar.a(it4Var);
                            it4Var.d0(true);
                        }
                    }
                } else if (next instanceof qt4) {
                    if (this.c != 0 && ((qt4) next).i() == this.c && !next.e()) {
                        this.d = false;
                        next.a(1);
                        if (next.b() >= next.c().f()) {
                            next.f(true);
                            if (next.c().H() >= next.c().p()) {
                                dVar.b(next);
                            }
                        }
                    }
                } else if ((next instanceof pt4) && !next.e()) {
                    this.d = false;
                    next.a(1);
                    if (next.b() >= next.c().f()) {
                        next.f(true);
                        dVar.b(next);
                    }
                }
            }
        }

        public final void b(it4 it4Var, lu4.d dVar) {
            ArrayList<ot4> n;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, it4Var, dVar) != null) || it4Var == null || dVar == null || (n = it4Var.n()) == null) {
                return;
            }
            Iterator<ot4> it = n.iterator();
            while (it.hasNext()) {
                ot4 next = it.next();
                if ((next instanceof st4) && !((st4) next).j() && !next.e()) {
                    this.d = false;
                    next.a(1);
                    if (next.b() >= next.c().f()) {
                        next.f(true);
                        dVar.a(it4Var);
                    }
                    dVar.c(it4Var);
                }
            }
        }

        public final void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.d = true;
                List<it4> list = (List) this.e.b.get(it4.Y);
                List<it4> list2 = (List) this.e.b.get(this.a);
                if (ListUtils.isEmpty(list) && ListUtils.isEmpty(list2)) {
                    this.e.e.compareAndSet(true, false);
                    return;
                }
                lu4.d dVar = new lu4.d();
                dVar.a = new LinkedList();
                dVar.b = new LinkedList();
                dVar.c = new LinkedList();
                d(list, dVar);
                e(list2, dVar);
                if (this.d) {
                    this.e.e.compareAndSet(true, false);
                }
                if (!ListUtils.isEmpty(dVar.c)) {
                    gt4.g().k(dVar.c);
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
    public class g extends BdAsyncTask<it4, Integer, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public g(jt4 jt4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jt4Var};
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
        public Void doInBackground(it4... it4VarArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, it4VarArr)) == null) {
                if (it4VarArr != null && it4VarArr.length > 0 && it4VarArr[0] != null) {
                    gt4.g().a(it4VarArr[0]);
                    return null;
                }
                return null;
            }
            return (Void) invokeL.objValue;
        }

        public /* synthetic */ g(jt4 jt4Var, a aVar) {
            this(jt4Var);
        }
    }

    /* loaded from: classes6.dex */
    public class h extends BdAsyncTask<List<it4>, Integer, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public h(jt4 jt4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jt4Var};
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
        public Void doInBackground(List<it4>... listArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, listArr)) == null) {
                if (listArr != null && listArr.length > 0 && listArr[0] != null) {
                    gt4.g().b(listArr[0]);
                    return null;
                }
                return null;
            }
            return (Void) invokeL.objValue;
        }

        public /* synthetic */ h(jt4 jt4Var, a aVar) {
            this(jt4Var);
        }
    }

    /* loaded from: classes6.dex */
    public class i extends BdAsyncTask<it4, Integer, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public i(jt4 jt4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jt4Var};
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
        public Void doInBackground(it4... it4VarArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, it4VarArr)) == null) {
                if (it4VarArr != null && it4VarArr.length > 0 && it4VarArr[0] != null) {
                    gt4.g().e(it4VarArr[0]);
                    return null;
                }
                return null;
            }
            return (Void) invokeL.objValue;
        }

        public /* synthetic */ i(jt4 jt4Var, a aVar) {
            this(jt4Var);
        }
    }

    /* loaded from: classes6.dex */
    public class j extends BdAsyncTask<Pair<it4, it4>, Integer, Pair<it4, it4>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jt4 a;

        public j(jt4 jt4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jt4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jt4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(Pair<it4, it4> pair) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pair) == null) && pair != null) {
                it4 it4Var = (it4) pair.first;
                it4 it4Var2 = (it4) pair.second;
                if (it4Var2 != null) {
                    this.a.t(it4Var2);
                }
                if (it4Var == null) {
                    return;
                }
                this.a.K(it4Var);
            }
        }

        public /* synthetic */ j(jt4 jt4Var, a aVar) {
            this(jt4Var);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Pair<it4, it4> doInBackground(Pair<it4, it4>... pairArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pairArr)) == null) {
                if (pairArr != null && pairArr.length > 0 && pairArr[0] != null) {
                    Pair<it4, it4> pair = pairArr[0];
                    it4 it4Var = (it4) pair.first;
                    it4 it4Var2 = (it4) pair.second;
                    if (it4Var2 != null) {
                        gt4.g().e(it4Var2);
                    }
                    if (it4Var != null) {
                        gt4.g().a(it4Var);
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
    public class k extends BdAsyncTask<Void, Integer, LinkedList<it4>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jt4 a;

        public k(jt4 jt4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jt4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jt4Var;
        }

        public /* synthetic */ k(jt4 jt4Var, a aVar) {
            this(jt4Var);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public LinkedList<it4> doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                LinkedList<it4> linkedList = new LinkedList<>();
                linkedList.addAll(gt4.g().f());
                Iterator<it4> it = linkedList.iterator();
                while (it.hasNext()) {
                    it4 next = it.next();
                    if (next != null && next.N()) {
                        gt4.g().e(next);
                        it.remove();
                    } else if (next != null && next.x() == 7) {
                        next.o0();
                        gt4.g().i(next);
                    }
                }
                return linkedList;
            }
            return (LinkedList) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(LinkedList<it4> linkedList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, linkedList) == null) {
                super.onPostExecute(linkedList);
                if (linkedList == null) {
                    return;
                }
                if (!linkedList.isEmpty()) {
                    Iterator<it4> it = linkedList.iterator();
                    while (it.hasNext()) {
                        it4 next = it.next();
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
        public static final jt4 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-678842537, "Lcom/baidu/tieba/jt4$l;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-678842537, "Lcom/baidu/tieba/jt4$l;");
                    return;
                }
            }
            a = new jt4(null);
        }
    }

    /* loaded from: classes6.dex */
    public class m extends BdAsyncTask<it4, Integer, it4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jt4 a;

        public m(jt4 jt4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jt4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jt4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public it4 doInBackground(it4... it4VarArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, it4VarArr)) == null) {
                if (it4VarArr != null && it4VarArr.length > 0 && it4VarArr[0] != null) {
                    it4 it4Var = it4VarArr[0];
                    gt4.g().i(it4Var);
                    return it4Var;
                }
                return null;
            }
            return (it4) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(it4 it4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, it4Var) == null) && it4Var != null && it4Var.z) {
                it4Var.z = false;
                jt4 jt4Var = this.a;
                jt4Var.Q(jt4Var.k, this.a.l);
            }
        }

        public /* synthetic */ m(jt4 jt4Var, a aVar) {
            this(jt4Var);
        }
    }

    public jt4() {
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
        lu4 lu4Var = new lu4(gen);
        this.i = lu4Var;
        lu4Var.w(this.t);
        fu4 fu4Var = new fu4(this.h);
        this.j = fu4Var;
        fu4Var.g(this.s);
        new hu4(this.h);
        this.r.setTag(this.h);
        MessageManager.getInstance().registerListener(this.r);
        this.q.setTag(this.h);
        MessageManager.getInstance().registerListener(this.q);
        this.p.setPriority(Integer.MIN_VALUE);
        this.p.setTag(this.h);
        MessageManager.getInstance().registerListener(this.p);
        a95.e().f();
        wt4.c().d(this.h);
        R();
        if (A()) {
            new k(this, null).execute(new Void[0]);
        }
    }

    public /* synthetic */ jt4(a aVar) {
        this();
    }

    public final void G(it4 it4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, it4Var) == null) {
            t(it4Var);
            new i(this, null).execute(it4Var);
        }
    }

    public void M(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.o = z;
        }
    }

    public final void T(it4 it4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, it4Var) == null) {
            U(it4Var);
            new m(this, null).execute(it4Var);
        }
    }

    public boolean y(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048608, this, i2)) == null) {
            List<it4> list = this.b.get(i2);
            if (list != null && !list.isEmpty()) {
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public final void H(it4 it4Var, it4 it4Var2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, it4Var, it4Var2) == null) {
            t(it4Var2);
            new j(this, null).execute(new Pair(it4Var, it4Var2));
        }
    }

    public static final jt4 w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            return l.a;
        }
        return (jt4) invokeV.objValue;
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
            lu4 lu4Var = this.i;
            if (lu4Var != null) {
                lu4Var.m();
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

    public final boolean B(it4 it4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, it4Var)) == null) {
            if (it4Var == null) {
                return false;
            }
            int[] h2 = it4Var.h();
            if (h2 == null) {
                return true;
            }
            for (int i2 : h2) {
                List<it4> list = this.b.get(i2);
                if (list == null) {
                    return false;
                }
                for (it4 it4Var2 : list) {
                    if (it4Var2 != null && it4Var2.d() == it4Var.d() && it4Var2.q() == it4Var.q()) {
                        if (it4Var2.N()) {
                            H(it4Var, it4Var2);
                        }
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final it4 u(it4 it4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, it4Var)) == null) {
            if (it4Var == null) {
                return null;
            }
            for (int i2 = 0; i2 < this.b.size(); i2++) {
                List<it4> valueAt = this.b.valueAt(i2);
                if (valueAt != null && !valueAt.isEmpty()) {
                    for (it4 it4Var2 : valueAt) {
                        if (it4Var2 != null && it4Var2.d() == it4Var.d() && it4Var2.q() == it4Var.q()) {
                            return it4Var2;
                        }
                    }
                    continue;
                }
            }
            return null;
        }
        return (it4) invokeL.objValue;
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            List<it4> list = this.b.get(it4.Y);
            if (ListUtils.isEmpty(list)) {
                return;
            }
            boolean z = false;
            for (it4 it4Var : list) {
                Iterator<ot4> it = it4Var.n().iterator();
                while (it.hasNext()) {
                    ot4 next = it.next();
                    if (next instanceof st4) {
                        st4 st4Var = (st4) next;
                        if (!next.e()) {
                            st4Var.i();
                            z = true;
                        }
                    }
                }
            }
            if (z && !this.e.get()) {
                this.d.f(it4.Y);
                this.e.compareAndSet(false, true);
                synchronized (this.e) {
                    this.e.notify();
                }
            }
        }
    }

    public final void K(it4 it4Var) {
        int[] h2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, it4Var) == null) {
            for (int i2 : it4Var.h()) {
                List<it4> list = this.b.get(i2);
                if (list == null) {
                    LinkedList linkedList = new LinkedList();
                    linkedList.add(it4Var);
                    this.b.put(i2, linkedList);
                } else {
                    list.add(it4Var);
                }
            }
        }
    }

    public void m(it4 it4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048597, this, it4Var) != null) || it4Var == null) {
            return;
        }
        if (it4Var.x() == 9) {
            wt4.c().f(it4Var);
        } else if (!this.f) {
            this.c.add(it4Var);
        } else if (B(it4Var)) {
        } else {
            K(it4Var);
            new g(this, null).execute(it4Var);
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
        List<it4> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && A() && this.f && (list = this.b.get((i2 = it4.Y))) != null && !list.isEmpty()) {
            boolean z = false;
            for (it4 it4Var : list) {
                if (it4Var.x() == 8) {
                    Iterator<ot4> it = it4Var.n().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        ot4 next = it.next();
                        it4 c2 = next.c();
                        if (c2 != null && (next instanceof st4) && c2.d() == it4Var.d() && c2.q() == it4Var.q()) {
                            ((st4) next).i();
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        st4 st4Var = new st4(it4Var);
                        st4Var.g(0L);
                        st4Var.f(false);
                        it4Var.a(st4Var);
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
            List<it4> list = this.b.get(i2);
            if (list != null && !list.isEmpty()) {
                boolean z = false;
                for (it4 it4Var : list) {
                    if (it4Var.x() == 4) {
                        Iterator<ot4> it = it4Var.n().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            ot4 next = it.next();
                            if ((next instanceof pt4) && next.c().d() == it4Var.d() && next.c().q() == it4Var.q()) {
                                z = true;
                                break;
                            }
                        }
                        if (!z) {
                            pt4 pt4Var = new pt4(it4Var);
                            pt4Var.g(0L);
                            pt4Var.f(false);
                            it4Var.a(pt4Var);
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

    public final void t(it4 it4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048604, this, it4Var) != null) || it4Var == null) {
            return;
        }
        Iterator<ot4> it = it4Var.n().iterator();
        while (it.hasNext()) {
            ot4 next = it.next();
            if (next != null && next.c() != null) {
                it4 c2 = next.c();
                if (c2.d() == it4Var.d() && c2.q() == it4Var.q()) {
                    it.remove();
                }
            }
        }
        for (int i2 = 0; i2 < this.b.size(); i2++) {
            List<it4> valueAt = this.b.valueAt(i2);
            if (valueAt != null && !valueAt.isEmpty()) {
                Iterator<it4> it2 = valueAt.iterator();
                while (it2.hasNext()) {
                    it4 next2 = it2.next();
                    if (next2 != null && next2.d() == it4Var.d() && next2.q() == it4Var.q()) {
                        it2.remove();
                    }
                }
            }
        }
        ht4.a("deleteActivityMissionInfoDataInMemory-->activityId=" + it4Var.d() + ",missionId=" + it4Var.q());
    }

    public void P(int i2, long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) && A() && i2 != 0 && j2 != 0 && this.f) {
            this.k = i2;
            List<it4> list = this.b.get(i2);
            if (list != null && !list.isEmpty()) {
                boolean z = false;
                for (it4 it4Var : list) {
                    if (it4Var.x() == 2) {
                        Iterator<ot4> it = it4Var.n().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            ot4 next = it.next();
                            if ((next instanceof qt4) && next.c().d() == it4Var.d() && next.c().q() == it4Var.q() && ((qt4) next).i() == j2) {
                                z = true;
                                break;
                            }
                        }
                        if (!z) {
                            qt4 qt4Var = new qt4(it4Var, j2);
                            qt4Var.g(0L);
                            qt4Var.f(false);
                            qt4Var.h(it4Var.w());
                            it4Var.a(qt4Var);
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
            List<it4> list = this.b.get(i2);
            if (list != null && !list.isEmpty()) {
                for (it4 it4Var : list) {
                    if (it4Var.x() == 1) {
                        p(it4Var, j2);
                    } else if (it4Var.x() == 7 && !it4Var.K(j2)) {
                        o(it4Var, j2);
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
        List<it4> list;
        rt4 rt4Var;
        it4 c2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) && (list = this.b.get(i2)) != null && !list.isEmpty()) {
            for (it4 it4Var : list) {
                if (it4Var.x() == 7) {
                    Iterator<ot4> it = it4Var.n().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            ot4 next = it.next();
                            if ((next instanceof rt4) && (c2 = (rt4Var = (rt4) next).c()) != null && rt4Var.i() == j2 && c2.d() == it4Var.d() && c2.q() == it4Var.q()) {
                                next.f(true);
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public final void o(it4 it4Var, long j2) {
        boolean z;
        rt4 rt4Var;
        it4 c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048599, this, it4Var, j2) == null) {
            Iterator<ot4> it = it4Var.n().iterator();
            while (true) {
                if (it.hasNext()) {
                    ot4 next = it.next();
                    if ((next instanceof rt4) && (c2 = (rt4Var = (rt4) next).c()) != null && rt4Var.i() == j2 && c2.d() == it4Var.d() && c2.q() == it4Var.q()) {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
            if (!z) {
                rt4 rt4Var2 = new rt4(it4Var, j2);
                rt4Var2.g(0L);
                rt4Var2.f(false);
                rt4Var2.h(it4Var.w());
                it4Var.a(rt4Var2);
            }
        }
    }

    public final void p(it4 it4Var, long j2) {
        boolean z;
        tt4 tt4Var;
        it4 c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048600, this, it4Var, j2) == null) {
            Iterator<ot4> it = it4Var.n().iterator();
            while (true) {
                if (it.hasNext()) {
                    ot4 next = it.next();
                    if ((next instanceof tt4) && (c2 = (tt4Var = (tt4) next).c()) != null && tt4Var.i() == j2 && c2.d() == it4Var.d() && c2.q() == it4Var.q()) {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
            if (!z) {
                tt4 tt4Var2 = new tt4(it4Var, j2);
                tt4Var2.g(0L);
                tt4Var2.f(false);
                tt4Var2.h(it4Var.w());
                it4Var.a(tt4Var2);
            }
        }
    }

    public final void U(it4 it4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048596, this, it4Var) != null) || it4Var == null) {
            return;
        }
        int x = it4Var.x();
        Iterator<ot4> it = it4Var.n().iterator();
        while (it.hasNext()) {
            ot4 next = it.next();
            if (next != null && next.c() != null) {
                it4 c2 = next.c();
                if (c2.d() == it4Var.d() && c2.q() == it4Var.q()) {
                    if (x == 7 && (next instanceof rt4)) {
                        ((rt4) next).f(true);
                    } else if (x == 1 && (next instanceof tt4)) {
                        ((tt4) next).f(true);
                    }
                }
            }
        }
        it4Var.d0(false);
    }

    public void n(List<it4> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048598, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (!this.f) {
            this.c.addAll(list);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (it4 it4Var : list) {
            if (it4Var != null) {
                if (it4Var.x() == 9) {
                    wt4.c().f(it4Var);
                } else if (!B(it4Var)) {
                    K(it4Var);
                    arrayList.add(it4Var);
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
