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
import com.baidu.tieba.er4;
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
public class zp4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ScheduledExecutorService a;
    public final SparseArray<List<yp4>> b;
    public final LinkedList<yp4> c;
    public f d;
    public AtomicBoolean e;
    public boolean f;
    public boolean g;
    public BdUniqueId h;
    public er4 i;
    public yq4 j;
    public int k;
    public long l;
    public int m;
    public long n;
    public boolean o;
    public CustomMessageListener p;
    public CustomMessageListener q;
    public CustomMessageListener r;
    public wq4<xq4> s;
    public su4 t;

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zp4 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(zp4 zp4Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zp4Var, Integer.valueOf(i)};
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
            this.a = zp4Var;
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
                    this.a.m((yp4) it.next());
                }
                this.a.c.clear();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zp4 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(zp4 zp4Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zp4Var, Integer.valueOf(i)};
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
            this.a = zp4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof BackgroundSwitchMessage)) {
                ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue();
                this.a.q();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zp4 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(zp4 zp4Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zp4Var, Integer.valueOf(i)};
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
            this.a = zp4Var;
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
    public class d implements wq4<xq4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zp4 a;

        @Override // com.baidu.tieba.ru4
        public void onError(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) {
            }
        }

        public d(zp4 zp4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zp4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zp4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ru4
        /* renamed from: c */
        public void onSuccess(xq4 xq4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, xq4Var) == null) && xq4Var != null) {
                this.a.n(xq4Var.b());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wq4
        /* renamed from: b */
        public void a(xq4 xq4Var) {
            ActiveCenterData activeCenterData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xq4Var) == null) && xq4Var != null && (activeCenterData = xq4Var.g) != null && activeCenterData.mission != null) {
                yp4 yp4Var = new yp4();
                yp4Var.P(xq4Var.g.mission);
                ArrayList arrayList = new ArrayList();
                arrayList.add(yp4Var);
                this.a.n(arrayList);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements su4<yp4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zp4 a;

        public e(zp4 zp4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zp4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zp4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.su4
        /* renamed from: b */
        public void a(yp4 yp4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yp4Var) != null) || yp4Var == null) {
                return;
            }
            yp4 u = this.a.u(yp4Var);
            if (u != null && u.z) {
                u.S();
                this.a.S(u);
                return;
            }
            jq4.b().h(u);
            if (u != null && u.x() == 7) {
                u.I();
                int F = u.F();
                int w = u.w();
                if (F <= 1 || F <= w) {
                    this.a.G(u);
                } else {
                    this.a.S(u);
                }
            } else if (u == null || u.x() != 8) {
                this.a.G(yp4Var);
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
        public final /* synthetic */ zp4 e;

        public f(zp4 zp4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zp4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = zp4Var;
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

        public /* synthetic */ f(zp4 zp4Var, a aVar) {
            this(zp4Var);
        }

        public final void d(List<yp4> list, er4.d dVar) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLL(1048579, this, list, dVar) != null) || ListUtils.isEmpty(list)) {
                return;
            }
            for (yp4 yp4Var : list) {
                b(yp4Var, dVar);
            }
        }

        public final void e(List<yp4> list, er4.d dVar) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLL(1048580, this, list, dVar) != null) || ListUtils.isEmpty(list)) {
                return;
            }
            for (yp4 yp4Var : list) {
                a(yp4Var, dVar);
            }
        }

        public final void a(yp4 yp4Var, er4.d dVar) {
            ArrayList<dq4> n;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLL(1048576, this, yp4Var, dVar) != null) || yp4Var == null || dVar == null || (n = yp4Var.n()) == null) {
                return;
            }
            Iterator<dq4> it = n.iterator();
            int i = 0;
            while (it.hasNext()) {
                dq4 next = it.next();
                if (next instanceof iq4) {
                    iq4 iq4Var = (iq4) next;
                    if (this.b != 0 && iq4Var.i() == this.b && !next.e()) {
                        this.d = false;
                        next.a(1);
                        if (next.b() >= next.c().f()) {
                            next.f(true);
                            if (next.c().J() >= next.c().A()) {
                                dVar.b(next);
                            }
                        }
                        dVar.c(yp4Var);
                    }
                } else if (next instanceof gq4) {
                    gq4 gq4Var = (gq4) next;
                    if (!yp4Var.M() && gq4Var.d() == yp4Var.w()) {
                        if (this.b != 0 && gq4Var.i() == this.b && !next.e()) {
                            this.d = false;
                            next.a(1);
                        }
                        i = (int) (i + next.b());
                        if (this.b != 0 && gq4Var.i() == this.b && !next.e()) {
                            if (next.b() >= yp4Var.f()) {
                                next.f(true);
                                yp4Var.J();
                            }
                            dVar.c(yp4Var);
                        }
                        int l = yp4Var.l();
                        int A = yp4Var.A();
                        long f = yp4Var.f() * yp4Var.A();
                        if (this.b != 0 && gq4Var.i() == this.b) {
                            next.e();
                        }
                        if (i >= f && l >= A) {
                            dVar.a(yp4Var);
                            yp4Var.d0(true);
                        }
                    }
                } else if (next instanceof fq4) {
                    if (this.c != 0 && ((fq4) next).i() == this.c && !next.e()) {
                        this.d = false;
                        next.a(1);
                        if (next.b() >= next.c().f()) {
                            next.f(true);
                            if (next.c().H() >= next.c().p()) {
                                dVar.b(next);
                            }
                        }
                    }
                } else if ((next instanceof eq4) && !next.e()) {
                    this.d = false;
                    next.a(1);
                    if (next.b() >= next.c().f()) {
                        next.f(true);
                        dVar.b(next);
                    }
                }
            }
        }

        public final void b(yp4 yp4Var, er4.d dVar) {
            ArrayList<dq4> n;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yp4Var, dVar) != null) || yp4Var == null || dVar == null || (n = yp4Var.n()) == null) {
                return;
            }
            Iterator<dq4> it = n.iterator();
            while (it.hasNext()) {
                dq4 next = it.next();
                if ((next instanceof hq4) && !((hq4) next).j() && !next.e()) {
                    this.d = false;
                    next.a(1);
                    if (next.b() >= next.c().f()) {
                        next.f(true);
                        dVar.a(yp4Var);
                    }
                    dVar.c(yp4Var);
                }
            }
        }

        public final void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.d = true;
                List<yp4> list = (List) this.e.b.get(yp4.Y);
                List<yp4> list2 = (List) this.e.b.get(this.a);
                if (ListUtils.isEmpty(list) && ListUtils.isEmpty(list2)) {
                    this.e.e.compareAndSet(true, false);
                    return;
                }
                er4.d dVar = new er4.d();
                dVar.a = new LinkedList();
                dVar.b = new LinkedList();
                dVar.c = new LinkedList();
                d(list, dVar);
                e(list2, dVar);
                if (this.d) {
                    this.e.e.compareAndSet(true, false);
                }
                if (!ListUtils.isEmpty(dVar.c)) {
                    wp4.g().k(dVar.c);
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
    public class g extends BdAsyncTask<yp4, Integer, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public g(zp4 zp4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zp4Var};
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
        public Void doInBackground(yp4... yp4VarArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, yp4VarArr)) == null) {
                if (yp4VarArr != null && yp4VarArr.length > 0 && yp4VarArr[0] != null) {
                    wp4.g().a(yp4VarArr[0]);
                    return null;
                }
                return null;
            }
            return (Void) invokeL.objValue;
        }

        public /* synthetic */ g(zp4 zp4Var, a aVar) {
            this(zp4Var);
        }
    }

    /* loaded from: classes7.dex */
    public class h extends BdAsyncTask<List<yp4>, Integer, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public h(zp4 zp4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zp4Var};
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
        public Void doInBackground(List<yp4>... listArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, listArr)) == null) {
                if (listArr != null && listArr.length > 0 && listArr[0] != null) {
                    wp4.g().b(listArr[0]);
                    return null;
                }
                return null;
            }
            return (Void) invokeL.objValue;
        }

        public /* synthetic */ h(zp4 zp4Var, a aVar) {
            this(zp4Var);
        }
    }

    /* loaded from: classes7.dex */
    public class i extends BdAsyncTask<yp4, Integer, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public i(zp4 zp4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zp4Var};
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
        public Void doInBackground(yp4... yp4VarArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, yp4VarArr)) == null) {
                if (yp4VarArr != null && yp4VarArr.length > 0 && yp4VarArr[0] != null) {
                    wp4.g().e(yp4VarArr[0]);
                    return null;
                }
                return null;
            }
            return (Void) invokeL.objValue;
        }

        public /* synthetic */ i(zp4 zp4Var, a aVar) {
            this(zp4Var);
        }
    }

    /* loaded from: classes7.dex */
    public class j extends BdAsyncTask<Pair<yp4, yp4>, Integer, Pair<yp4, yp4>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zp4 a;

        public j(zp4 zp4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zp4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zp4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(Pair<yp4, yp4> pair) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pair) == null) && pair != null) {
                yp4 yp4Var = (yp4) pair.first;
                yp4 yp4Var2 = (yp4) pair.second;
                if (yp4Var2 != null) {
                    this.a.t(yp4Var2);
                }
                if (yp4Var == null) {
                    return;
                }
                this.a.J(yp4Var);
            }
        }

        public /* synthetic */ j(zp4 zp4Var, a aVar) {
            this(zp4Var);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Pair<yp4, yp4> doInBackground(Pair<yp4, yp4>... pairArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pairArr)) == null) {
                if (pairArr != null && pairArr.length > 0 && pairArr[0] != null) {
                    Pair<yp4, yp4> pair = pairArr[0];
                    yp4 yp4Var = (yp4) pair.first;
                    yp4 yp4Var2 = (yp4) pair.second;
                    if (yp4Var2 != null) {
                        wp4.g().e(yp4Var2);
                    }
                    if (yp4Var != null) {
                        wp4.g().a(yp4Var);
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
    public class k extends BdAsyncTask<Void, Integer, LinkedList<yp4>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zp4 a;

        public k(zp4 zp4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zp4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zp4Var;
        }

        public /* synthetic */ k(zp4 zp4Var, a aVar) {
            this(zp4Var);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public LinkedList<yp4> doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                LinkedList<yp4> linkedList = new LinkedList<>();
                linkedList.addAll(wp4.g().f());
                Iterator<yp4> it = linkedList.iterator();
                while (it.hasNext()) {
                    yp4 next = it.next();
                    if (next != null && next.N()) {
                        wp4.g().e(next);
                        it.remove();
                    } else if (next != null && next.x() == 7) {
                        next.o0();
                        wp4.g().i(next);
                    }
                }
                return linkedList;
            }
            return (LinkedList) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(LinkedList<yp4> linkedList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, linkedList) == null) {
                super.onPostExecute(linkedList);
                if (linkedList == null) {
                    return;
                }
                if (!linkedList.isEmpty()) {
                    Iterator<yp4> it = linkedList.iterator();
                    while (it.hasNext()) {
                        yp4 next = it.next();
                        if (next.h() != null) {
                            this.a.J(next);
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
        public static final zp4 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-224470205, "Lcom/baidu/tieba/zp4$l;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-224470205, "Lcom/baidu/tieba/zp4$l;");
                    return;
                }
            }
            a = new zp4(null);
        }
    }

    /* loaded from: classes7.dex */
    public class m extends BdAsyncTask<yp4, Integer, yp4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zp4 a;

        public m(zp4 zp4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zp4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zp4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public yp4 doInBackground(yp4... yp4VarArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, yp4VarArr)) == null) {
                if (yp4VarArr != null && yp4VarArr.length > 0 && yp4VarArr[0] != null) {
                    yp4 yp4Var = yp4VarArr[0];
                    wp4.g().i(yp4Var);
                    return yp4Var;
                }
                return null;
            }
            return (yp4) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(yp4 yp4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yp4Var) == null) && yp4Var != null && yp4Var.z) {
                yp4Var.z = false;
                zp4 zp4Var = this.a;
                zp4Var.P(zp4Var.k, this.a.l);
            }
        }

        public /* synthetic */ m(zp4 zp4Var, a aVar) {
            this(zp4Var);
        }
    }

    public zp4() {
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
        er4 er4Var = new er4(gen);
        this.i = er4Var;
        er4Var.w(this.t);
        yq4 yq4Var = new yq4(this.h);
        this.j = yq4Var;
        yq4Var.g(this.s);
        new ar4(this.h);
        this.r.setTag(this.h);
        MessageManager.getInstance().registerListener(this.r);
        this.q.setTag(this.h);
        MessageManager.getInstance().registerListener(this.q);
        this.p.setPriority(Integer.MIN_VALUE);
        this.p.setTag(this.h);
        MessageManager.getInstance().registerListener(this.p);
        k35.e().f();
        lq4.c().d(this.h);
        Q();
        if (A()) {
            new k(this, null).execute(new Void[0]);
        }
    }

    public /* synthetic */ zp4(a aVar) {
        this();
    }

    public final void G(yp4 yp4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, yp4Var) == null) {
            t(yp4Var);
            new i(this, null).execute(yp4Var);
        }
    }

    public void L(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.o = z;
        }
    }

    public final void S(yp4 yp4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, yp4Var) == null) {
            T(yp4Var);
            new m(this, null).execute(yp4Var);
        }
    }

    public boolean y(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048607, this, i2)) == null) {
            List<yp4> list = this.b.get(i2);
            if (list != null && !list.isEmpty()) {
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public final void H(yp4 yp4Var, yp4 yp4Var2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, yp4Var, yp4Var2) == null) {
            t(yp4Var2);
            new j(this, null).execute(new Pair(yp4Var, yp4Var2));
        }
    }

    public static final zp4 w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            return l.a;
        }
        return (zp4) invokeV.objValue;
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
            int n = m35.m().n("app_restart_times", 0);
            if (TbSingleton.getInstance().isNewUserRedPackageShowed() || n <= 1) {
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
            er4 er4Var = this.i;
            if (er4Var != null) {
                er4Var.m();
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

    public final void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.a.scheduleWithFixedDelay(this.d, 0L, 1L, TimeUnit.SECONDS);
        }
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return UtilHelper.isSameDay(m35.m().o("pref_key_last_active_config", 0L), System.currentTimeMillis());
        }
        return invokeV.booleanValue;
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return UtilHelper.isSameDay(x(), System.currentTimeMillis());
        }
        return invokeV.booleanValue;
    }

    public int v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.m;
        }
        return invokeV.intValue;
    }

    public final long x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            long o = m35.m().o("pref_key_active_config_info", 0L);
            this.n = o;
            return o;
        }
        return invokeV.longValue;
    }

    public boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return !r();
        }
        return invokeV.booleanValue;
    }

    public final boolean B(yp4 yp4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yp4Var)) == null) {
            if (yp4Var == null) {
                return false;
            }
            int[] h2 = yp4Var.h();
            if (h2 == null) {
                return true;
            }
            for (int i2 : h2) {
                List<yp4> list = this.b.get(i2);
                if (list == null) {
                    return false;
                }
                for (yp4 yp4Var2 : list) {
                    if (yp4Var2 != null && yp4Var2.d() == yp4Var.d() && yp4Var2.q() == yp4Var.q()) {
                        if (yp4Var2.N()) {
                            H(yp4Var, yp4Var2);
                        }
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final yp4 u(yp4 yp4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, yp4Var)) == null) {
            if (yp4Var == null) {
                return null;
            }
            for (int i2 = 0; i2 < this.b.size(); i2++) {
                List<yp4> valueAt = this.b.valueAt(i2);
                if (valueAt != null && !valueAt.isEmpty()) {
                    for (yp4 yp4Var2 : valueAt) {
                        if (yp4Var2 != null && yp4Var2.d() == yp4Var.d() && yp4Var2.q() == yp4Var.q()) {
                            return yp4Var2;
                        }
                    }
                    continue;
                }
            }
            return null;
        }
        return (yp4) invokeL.objValue;
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            List<yp4> list = this.b.get(yp4.Y);
            if (ListUtils.isEmpty(list)) {
                return;
            }
            boolean z = false;
            for (yp4 yp4Var : list) {
                Iterator<dq4> it = yp4Var.n().iterator();
                while (it.hasNext()) {
                    dq4 next = it.next();
                    if (next instanceof hq4) {
                        hq4 hq4Var = (hq4) next;
                        if (!next.e()) {
                            hq4Var.i();
                            z = true;
                        }
                    }
                }
            }
            if (z && !this.e.get()) {
                this.d.f(yp4.Y);
                this.e.compareAndSet(false, true);
                synchronized (this.e) {
                    this.e.notify();
                }
            }
        }
    }

    public final void J(yp4 yp4Var) {
        int[] h2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, yp4Var) == null) {
            for (int i2 : yp4Var.h()) {
                List<yp4> list = this.b.get(i2);
                if (list == null) {
                    LinkedList linkedList = new LinkedList();
                    linkedList.add(yp4Var);
                    this.b.put(i2, linkedList);
                } else {
                    list.add(yp4Var);
                }
            }
        }
    }

    public void m(yp4 yp4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048596, this, yp4Var) != null) || yp4Var == null) {
            return;
        }
        if (yp4Var.x() == 9) {
            lq4.c().f(yp4Var);
        } else if (!this.f) {
            this.c.add(yp4Var);
        } else if (B(yp4Var)) {
        } else {
            J(yp4Var);
            new g(this, null).execute(yp4Var);
        }
    }

    public void K(int i2, long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) != null) || !A()) {
            return;
        }
        this.m = i2;
        long j3 = this.l;
        if (j3 > 0 && this.k > 0 && (j2 == 0 || j2 != j3)) {
            R(this.k, this.l);
            this.l = 0L;
            this.k = 0;
        }
        M();
    }

    public void M() {
        int i2;
        List<yp4> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && A() && this.f && (list = this.b.get((i2 = yp4.Y))) != null && !list.isEmpty()) {
            boolean z = false;
            for (yp4 yp4Var : list) {
                if (yp4Var.x() == 8) {
                    Iterator<dq4> it = yp4Var.n().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        dq4 next = it.next();
                        yp4 c2 = next.c();
                        if (c2 != null && (next instanceof hq4) && c2.d() == yp4Var.d() && c2.q() == yp4Var.q()) {
                            ((hq4) next).i();
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        hq4 hq4Var = new hq4(yp4Var);
                        hq4Var.g(0L);
                        hq4Var.f(false);
                        yp4Var.a(hq4Var);
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

    public void N(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048589, this, i2) == null) && A() && i2 != 0 && this.f) {
            this.k = i2;
            List<yp4> list = this.b.get(i2);
            if (list != null && !list.isEmpty()) {
                boolean z = false;
                for (yp4 yp4Var : list) {
                    if (yp4Var.x() == 4) {
                        Iterator<dq4> it = yp4Var.n().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            dq4 next = it.next();
                            if ((next instanceof eq4) && next.c().d() == yp4Var.d() && next.c().q() == yp4Var.q()) {
                                z = true;
                                break;
                            }
                        }
                        if (!z) {
                            eq4 eq4Var = new eq4(yp4Var);
                            eq4Var.g(0L);
                            eq4Var.f(false);
                            yp4Var.a(eq4Var);
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

    public final void t(yp4 yp4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048603, this, yp4Var) != null) || yp4Var == null) {
            return;
        }
        Iterator<dq4> it = yp4Var.n().iterator();
        while (it.hasNext()) {
            dq4 next = it.next();
            if (next != null && next.c() != null) {
                yp4 c2 = next.c();
                if (c2.d() == yp4Var.d() && c2.q() == yp4Var.q()) {
                    it.remove();
                }
            }
        }
        for (int i2 = 0; i2 < this.b.size(); i2++) {
            List<yp4> valueAt = this.b.valueAt(i2);
            if (valueAt != null && !valueAt.isEmpty()) {
                Iterator<yp4> it2 = valueAt.iterator();
                while (it2.hasNext()) {
                    yp4 next2 = it2.next();
                    if (next2 != null && next2.d() == yp4Var.d() && next2.q() == yp4Var.q()) {
                        it2.remove();
                    }
                }
            }
        }
        xp4.a("deleteActivityMissionInfoDataInMemory-->activityId=" + yp4Var.d() + ",missionId=" + yp4Var.q());
    }

    public void O(int i2, long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) && A() && i2 != 0 && j2 != 0 && this.f) {
            this.k = i2;
            List<yp4> list = this.b.get(i2);
            if (list != null && !list.isEmpty()) {
                boolean z = false;
                for (yp4 yp4Var : list) {
                    if (yp4Var.x() == 2) {
                        Iterator<dq4> it = yp4Var.n().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            dq4 next = it.next();
                            if ((next instanceof fq4) && next.c().d() == yp4Var.d() && next.c().q() == yp4Var.q() && ((fq4) next).i() == j2) {
                                z = true;
                                break;
                            }
                        }
                        if (!z) {
                            fq4 fq4Var = new fq4(yp4Var, j2);
                            fq4Var.g(0L);
                            fq4Var.f(false);
                            fq4Var.h(yp4Var.w());
                            yp4Var.a(fq4Var);
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

    public void P(int i2, long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) && A() && i2 != 0 && j2 != 0 && this.f) {
            this.k = i2;
            List<yp4> list = this.b.get(i2);
            if (list != null && !list.isEmpty()) {
                for (yp4 yp4Var : list) {
                    if (yp4Var.x() == 1) {
                        p(yp4Var, j2);
                    } else if (yp4Var.x() == 7 && !yp4Var.K(j2)) {
                        o(yp4Var, j2);
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

    public void R(int i2, long j2) {
        List<yp4> list;
        gq4 gq4Var;
        yp4 c2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) && (list = this.b.get(i2)) != null && !list.isEmpty()) {
            for (yp4 yp4Var : list) {
                if (yp4Var.x() == 7) {
                    Iterator<dq4> it = yp4Var.n().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            dq4 next = it.next();
                            if ((next instanceof gq4) && (c2 = (gq4Var = (gq4) next).c()) != null && gq4Var.i() == j2 && c2.d() == yp4Var.d() && c2.q() == yp4Var.q()) {
                                next.f(true);
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public final void o(yp4 yp4Var, long j2) {
        boolean z;
        gq4 gq4Var;
        yp4 c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048598, this, yp4Var, j2) == null) {
            Iterator<dq4> it = yp4Var.n().iterator();
            while (true) {
                if (it.hasNext()) {
                    dq4 next = it.next();
                    if ((next instanceof gq4) && (c2 = (gq4Var = (gq4) next).c()) != null && gq4Var.i() == j2 && c2.d() == yp4Var.d() && c2.q() == yp4Var.q()) {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
            if (!z) {
                gq4 gq4Var2 = new gq4(yp4Var, j2);
                gq4Var2.g(0L);
                gq4Var2.f(false);
                gq4Var2.h(yp4Var.w());
                yp4Var.a(gq4Var2);
            }
        }
    }

    public final void p(yp4 yp4Var, long j2) {
        boolean z;
        iq4 iq4Var;
        yp4 c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048599, this, yp4Var, j2) == null) {
            Iterator<dq4> it = yp4Var.n().iterator();
            while (true) {
                if (it.hasNext()) {
                    dq4 next = it.next();
                    if ((next instanceof iq4) && (c2 = (iq4Var = (iq4) next).c()) != null && iq4Var.i() == j2 && c2.d() == yp4Var.d() && c2.q() == yp4Var.q()) {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
            if (!z) {
                iq4 iq4Var2 = new iq4(yp4Var, j2);
                iq4Var2.g(0L);
                iq4Var2.f(false);
                iq4Var2.h(yp4Var.w());
                yp4Var.a(iq4Var2);
            }
        }
    }

    public final void T(yp4 yp4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048595, this, yp4Var) != null) || yp4Var == null) {
            return;
        }
        int x = yp4Var.x();
        Iterator<dq4> it = yp4Var.n().iterator();
        while (it.hasNext()) {
            dq4 next = it.next();
            if (next != null && next.c() != null) {
                yp4 c2 = next.c();
                if (c2.d() == yp4Var.d() && c2.q() == yp4Var.q()) {
                    if (x == 7 && (next instanceof gq4)) {
                        ((gq4) next).f(true);
                    } else if (x == 1 && (next instanceof iq4)) {
                        ((iq4) next).f(true);
                    }
                }
            }
        }
        yp4Var.d0(false);
    }

    public void n(List<yp4> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048597, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (!this.f) {
            this.c.addAll(list);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (yp4 yp4Var : list) {
            if (yp4Var != null) {
                if (yp4Var.x() == 9) {
                    lq4.c().f(yp4Var);
                } else if (!B(yp4Var)) {
                    J(yp4Var);
                    arrayList.add(yp4Var);
                }
            }
        }
        new h(this, null).execute(arrayList);
    }

    public void q() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048600, this) != null) || this.j == null || !A() || !this.g) {
            return;
        }
        if (!s() || D()) {
            this.j.f(z(), C(), 0);
        }
    }
}
