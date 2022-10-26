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
import com.baidu.tieba.ym4;
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
/* loaded from: classes5.dex */
public class sl4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ScheduledExecutorService a;
    public final SparseArray b;
    public final LinkedList c;
    public f d;
    public AtomicBoolean e;
    public boolean f;
    public boolean g;
    public BdUniqueId h;
    public ym4 i;
    public sm4 j;
    public int k;
    public long l;
    public int m;
    public long n;
    public boolean o;
    public CustomMessageListener p;
    public CustomMessageListener q;
    public CustomMessageListener r;
    public qm4 s;
    public mp4 t;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sl4 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(sl4 sl4Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sl4Var, Integer.valueOf(i)};
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
            this.a = sl4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) {
                return;
            }
            this.a.f = true;
            if (!this.a.c.isEmpty()) {
                Iterator it = this.a.c.iterator();
                while (it.hasNext()) {
                    this.a.m((rl4) it.next());
                }
                this.a.c.clear();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sl4 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(sl4 sl4Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sl4Var, Integer.valueOf(i)};
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
            this.a = sl4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof BackgroundSwitchMessage)) {
                ((Boolean) ((BackgroundSwitchMessage) customResponsedMessage).getData()).booleanValue();
                this.a.q();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sl4 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(sl4 sl4Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sl4Var, Integer.valueOf(i)};
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
            this.a = sl4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2001371) {
                return;
            }
            this.a.g = true;
            this.a.q();
        }
    }

    /* loaded from: classes5.dex */
    public class d implements qm4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sl4 a;

        @Override // com.baidu.tieba.lp4
        public void onError(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) {
            }
        }

        public d(sl4 sl4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sl4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sl4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lp4
        /* renamed from: c */
        public void onSuccess(rm4 rm4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, rm4Var) == null) && rm4Var != null) {
                this.a.n(rm4Var.b());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qm4
        /* renamed from: b */
        public void a(rm4 rm4Var) {
            ActiveCenterData activeCenterData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rm4Var) == null) && rm4Var != null && (activeCenterData = rm4Var.g) != null && activeCenterData.mission != null) {
                rl4 rl4Var = new rl4();
                rl4Var.P(rm4Var.g.mission);
                ArrayList arrayList = new ArrayList();
                arrayList.add(rl4Var);
                this.a.n(arrayList);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements mp4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sl4 a;

        public e(sl4 sl4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sl4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sl4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mp4
        /* renamed from: b */
        public void a(rl4 rl4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rl4Var) != null) || rl4Var == null) {
                return;
            }
            rl4 u = this.a.u(rl4Var);
            if (u != null && u.z) {
                u.S();
                this.a.S(u);
                return;
            }
            dm4.b().h(u);
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
                this.a.G(rl4Var);
            } else {
                this.a.G(u);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile int a;
        public volatile long b;
        public volatile long c;
        public volatile boolean d;
        public final /* synthetic */ sl4 e;

        public f(sl4 sl4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sl4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = sl4Var;
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

        public /* synthetic */ f(sl4 sl4Var, a aVar) {
            this(sl4Var);
        }

        public final void d(List list, ym4.d dVar) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLL(1048579, this, list, dVar) != null) || ListUtils.isEmpty(list)) {
                return;
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                b((rl4) it.next(), dVar);
            }
        }

        public final void e(List list, ym4.d dVar) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLL(1048580, this, list, dVar) != null) || ListUtils.isEmpty(list)) {
                return;
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                a((rl4) it.next(), dVar);
            }
        }

        public final void a(rl4 rl4Var, ym4.d dVar) {
            ArrayList n;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLL(1048576, this, rl4Var, dVar) != null) || rl4Var == null || dVar == null || (n = rl4Var.n()) == null) {
                return;
            }
            Iterator it = n.iterator();
            int i = 0;
            while (it.hasNext()) {
                xl4 xl4Var = (xl4) it.next();
                if (xl4Var instanceof cm4) {
                    cm4 cm4Var = (cm4) xl4Var;
                    if (this.b != 0 && cm4Var.i() == this.b && !xl4Var.e()) {
                        this.d = false;
                        xl4Var.a(1);
                        if (xl4Var.b() >= xl4Var.c().f()) {
                            xl4Var.f(true);
                            if (xl4Var.c().J() >= xl4Var.c().A()) {
                                dVar.b(xl4Var);
                            }
                        }
                        dVar.c(rl4Var);
                    }
                } else if (xl4Var instanceof am4) {
                    am4 am4Var = (am4) xl4Var;
                    if (!rl4Var.M() && am4Var.d() == rl4Var.w()) {
                        if (this.b != 0 && am4Var.i() == this.b && !xl4Var.e()) {
                            this.d = false;
                            xl4Var.a(1);
                        }
                        i = (int) (i + xl4Var.b());
                        if (this.b != 0 && am4Var.i() == this.b && !xl4Var.e()) {
                            if (xl4Var.b() >= rl4Var.f()) {
                                xl4Var.f(true);
                                rl4Var.J();
                            }
                            dVar.c(rl4Var);
                        }
                        int l = rl4Var.l();
                        int A = rl4Var.A();
                        long f = rl4Var.f() * rl4Var.A();
                        if (this.b != 0 && am4Var.i() == this.b) {
                            xl4Var.e();
                        }
                        if (i >= f && l >= A) {
                            dVar.a(rl4Var);
                            rl4Var.d0(true);
                        }
                    }
                } else if (xl4Var instanceof zl4) {
                    if (this.c != 0 && ((zl4) xl4Var).i() == this.c && !xl4Var.e()) {
                        this.d = false;
                        xl4Var.a(1);
                        if (xl4Var.b() >= xl4Var.c().f()) {
                            xl4Var.f(true);
                            if (xl4Var.c().H() >= xl4Var.c().p()) {
                                dVar.b(xl4Var);
                            }
                        }
                    }
                } else if ((xl4Var instanceof yl4) && !xl4Var.e()) {
                    this.d = false;
                    xl4Var.a(1);
                    if (xl4Var.b() >= xl4Var.c().f()) {
                        xl4Var.f(true);
                        dVar.b(xl4Var);
                    }
                }
            }
        }

        public final void b(rl4 rl4Var, ym4.d dVar) {
            ArrayList n;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rl4Var, dVar) != null) || rl4Var == null || dVar == null || (n = rl4Var.n()) == null) {
                return;
            }
            Iterator it = n.iterator();
            while (it.hasNext()) {
                xl4 xl4Var = (xl4) it.next();
                if ((xl4Var instanceof bm4) && !((bm4) xl4Var).j() && !xl4Var.e()) {
                    this.d = false;
                    xl4Var.a(1);
                    if (xl4Var.b() >= xl4Var.c().f()) {
                        xl4Var.f(true);
                        dVar.a(rl4Var);
                    }
                    dVar.c(rl4Var);
                }
            }
        }

        public final void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.d = true;
                List list = (List) this.e.b.get(rl4.Y);
                List list2 = (List) this.e.b.get(this.a);
                if (ListUtils.isEmpty(list) && ListUtils.isEmpty(list2)) {
                    this.e.e.compareAndSet(true, false);
                    return;
                }
                ym4.d dVar = new ym4.d();
                dVar.a = new LinkedList();
                dVar.b = new LinkedList();
                dVar.c = new LinkedList();
                d(list, dVar);
                e(list2, dVar);
                if (this.d) {
                    this.e.e.compareAndSet(true, false);
                }
                if (!ListUtils.isEmpty(dVar.c)) {
                    pl4.g().k(dVar.c);
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

    /* loaded from: classes5.dex */
    public class g extends BdAsyncTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public g(sl4 sl4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sl4Var};
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
        public Void doInBackground(rl4... rl4VarArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, rl4VarArr)) == null) {
                if (rl4VarArr != null && rl4VarArr.length > 0 && rl4VarArr[0] != null) {
                    pl4.g().a(rl4VarArr[0]);
                    return null;
                }
                return null;
            }
            return (Void) invokeL.objValue;
        }

        public /* synthetic */ g(sl4 sl4Var, a aVar) {
            this(sl4Var);
        }
    }

    /* loaded from: classes5.dex */
    public class h extends BdAsyncTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public h(sl4 sl4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sl4Var};
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
        public Void doInBackground(List... listArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, listArr)) == null) {
                if (listArr != null && listArr.length > 0 && listArr[0] != null) {
                    pl4.g().b(listArr[0]);
                    return null;
                }
                return null;
            }
            return (Void) invokeL.objValue;
        }

        public /* synthetic */ h(sl4 sl4Var, a aVar) {
            this(sl4Var);
        }
    }

    /* loaded from: classes5.dex */
    public class i extends BdAsyncTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public i(sl4 sl4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sl4Var};
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
        public Void doInBackground(rl4... rl4VarArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, rl4VarArr)) == null) {
                if (rl4VarArr != null && rl4VarArr.length > 0 && rl4VarArr[0] != null) {
                    pl4.g().e(rl4VarArr[0]);
                    return null;
                }
                return null;
            }
            return (Void) invokeL.objValue;
        }

        public /* synthetic */ i(sl4 sl4Var, a aVar) {
            this(sl4Var);
        }
    }

    /* loaded from: classes5.dex */
    public class j extends BdAsyncTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sl4 a;

        public j(sl4 sl4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sl4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sl4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(Pair pair) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pair) == null) && pair != null) {
                rl4 rl4Var = (rl4) pair.first;
                rl4 rl4Var2 = (rl4) pair.second;
                if (rl4Var2 != null) {
                    this.a.t(rl4Var2);
                }
                if (rl4Var == null) {
                    return;
                }
                this.a.J(rl4Var);
            }
        }

        public /* synthetic */ j(sl4 sl4Var, a aVar) {
            this(sl4Var);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Pair doInBackground(Pair... pairArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pairArr)) == null) {
                if (pairArr != null && pairArr.length > 0 && pairArr[0] != null) {
                    Pair pair = pairArr[0];
                    rl4 rl4Var = (rl4) pair.first;
                    rl4 rl4Var2 = (rl4) pair.second;
                    if (rl4Var2 != null) {
                        pl4.g().e(rl4Var2);
                    }
                    if (rl4Var != null) {
                        pl4.g().a(rl4Var);
                        return pair;
                    }
                    return pair;
                }
                return null;
            }
            return (Pair) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class k extends BdAsyncTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sl4 a;

        public k(sl4 sl4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sl4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sl4Var;
        }

        public /* synthetic */ k(sl4 sl4Var, a aVar) {
            this(sl4Var);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public LinkedList doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                LinkedList linkedList = new LinkedList();
                linkedList.addAll(pl4.g().f());
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    rl4 rl4Var = (rl4) it.next();
                    if (rl4Var != null && rl4Var.N()) {
                        pl4.g().e(rl4Var);
                        it.remove();
                    } else if (rl4Var != null && rl4Var.x() == 7) {
                        rl4Var.o0();
                        pl4.g().i(rl4Var);
                    }
                }
                return linkedList;
            }
            return (LinkedList) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(LinkedList linkedList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, linkedList) == null) {
                super.onPostExecute(linkedList);
                if (linkedList == null) {
                    return;
                }
                if (!linkedList.isEmpty()) {
                    Iterator it = linkedList.iterator();
                    while (it.hasNext()) {
                        rl4 rl4Var = (rl4) it.next();
                        if (rl4Var.h() != null) {
                            this.a.J(rl4Var);
                        }
                    }
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921391));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l {
        public static /* synthetic */ Interceptable $ic;
        public static final sl4 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-428568346, "Lcom/baidu/tieba/sl4$l;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-428568346, "Lcom/baidu/tieba/sl4$l;");
                    return;
                }
            }
            a = new sl4(null);
        }
    }

    /* loaded from: classes5.dex */
    public class m extends BdAsyncTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sl4 a;

        public m(sl4 sl4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sl4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sl4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public rl4 doInBackground(rl4... rl4VarArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, rl4VarArr)) == null) {
                if (rl4VarArr != null && rl4VarArr.length > 0 && rl4VarArr[0] != null) {
                    rl4 rl4Var = rl4VarArr[0];
                    pl4.g().i(rl4Var);
                    return rl4Var;
                }
                return null;
            }
            return (rl4) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(rl4 rl4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rl4Var) == null) && rl4Var != null && rl4Var.z) {
                rl4Var.z = false;
                sl4 sl4Var = this.a;
                sl4Var.P(sl4Var.k, this.a.l);
            }
        }

        public /* synthetic */ m(sl4 sl4Var, a aVar) {
            this(sl4Var);
        }
    }

    public sl4() {
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
        this.b = new SparseArray();
        this.c = new LinkedList();
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
        ym4 ym4Var = new ym4(gen);
        this.i = ym4Var;
        ym4Var.w(this.t);
        sm4 sm4Var = new sm4(this.h);
        this.j = sm4Var;
        sm4Var.g(this.s);
        new um4(this.h);
        this.r.setTag(this.h);
        MessageManager.getInstance().registerListener(this.r);
        this.q.setTag(this.h);
        MessageManager.getInstance().registerListener(this.q);
        this.p.setPriority(Integer.MIN_VALUE);
        this.p.setTag(this.h);
        MessageManager.getInstance().registerListener(this.p);
        sx4.e().f();
        fm4.c().d(this.h);
        Q();
        if (A()) {
            new k(this, null).execute(new Void[0]);
        }
    }

    public /* synthetic */ sl4(a aVar) {
        this();
    }

    public final void G(rl4 rl4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, rl4Var) == null) {
            t(rl4Var);
            new i(this, null).execute(rl4Var);
        }
    }

    public void L(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.o = z;
        }
    }

    public final void S(rl4 rl4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, rl4Var) == null) {
            T(rl4Var);
            new m(this, null).execute(rl4Var);
        }
    }

    public boolean y(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048607, this, i2)) == null) {
            List list = (List) this.b.get(i2);
            if (list != null && !list.isEmpty()) {
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public final void H(rl4 rl4Var, rl4 rl4Var2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, rl4Var, rl4Var2) == null) {
            t(rl4Var2);
            new j(this, null).execute(new Pair(rl4Var, rl4Var2));
        }
    }

    public static final sl4 w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            return l.a;
        }
        return (sl4) invokeV.objValue;
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
            int l2 = ux4.k().l("app_restart_times", 0);
            if (TbSingleton.getInstance().isNewUserRedPackageShowed() || l2 <= 1) {
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
            ym4 ym4Var = this.i;
            if (ym4Var != null) {
                ym4Var.m();
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
            return UtilHelper.isSameDay(ux4.k().m("pref_key_last_active_config", 0L), System.currentTimeMillis());
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
            long m2 = ux4.k().m("pref_key_active_config_info", 0L);
            this.n = m2;
            return m2;
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

    public final boolean B(rl4 rl4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rl4Var)) == null) {
            if (rl4Var == null) {
                return false;
            }
            int[] h2 = rl4Var.h();
            if (h2 == null) {
                return true;
            }
            for (int i2 : h2) {
                List<rl4> list = (List) this.b.get(i2);
                if (list == null) {
                    return false;
                }
                for (rl4 rl4Var2 : list) {
                    if (rl4Var2 != null && rl4Var2.d() == rl4Var.d() && rl4Var2.q() == rl4Var.q()) {
                        if (rl4Var2.N()) {
                            H(rl4Var, rl4Var2);
                        }
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final rl4 u(rl4 rl4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, rl4Var)) == null) {
            if (rl4Var == null) {
                return null;
            }
            for (int i2 = 0; i2 < this.b.size(); i2++) {
                List<rl4> list = (List) this.b.valueAt(i2);
                if (list != null && !list.isEmpty()) {
                    for (rl4 rl4Var2 : list) {
                        if (rl4Var2 != null && rl4Var2.d() == rl4Var.d() && rl4Var2.q() == rl4Var.q()) {
                            return rl4Var2;
                        }
                    }
                    continue;
                }
            }
            return null;
        }
        return (rl4) invokeL.objValue;
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            List<rl4> list = (List) this.b.get(rl4.Y);
            if (ListUtils.isEmpty(list)) {
                return;
            }
            boolean z = false;
            for (rl4 rl4Var : list) {
                Iterator it = rl4Var.n().iterator();
                while (it.hasNext()) {
                    xl4 xl4Var = (xl4) it.next();
                    if (xl4Var instanceof bm4) {
                        bm4 bm4Var = (bm4) xl4Var;
                        if (!xl4Var.e()) {
                            bm4Var.i();
                            z = true;
                        }
                    }
                }
            }
            if (z && !this.e.get()) {
                this.d.f(rl4.Y);
                this.e.compareAndSet(false, true);
                synchronized (this.e) {
                    this.e.notify();
                }
            }
        }
    }

    public final void J(rl4 rl4Var) {
        int[] h2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, rl4Var) == null) {
            for (int i2 : rl4Var.h()) {
                List list = (List) this.b.get(i2);
                if (list == null) {
                    LinkedList linkedList = new LinkedList();
                    linkedList.add(rl4Var);
                    this.b.put(i2, linkedList);
                } else {
                    list.add(rl4Var);
                }
            }
        }
    }

    public void m(rl4 rl4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048596, this, rl4Var) != null) || rl4Var == null) {
            return;
        }
        if (rl4Var.x() == 9) {
            fm4.c().f(rl4Var);
        } else if (!this.f) {
            this.c.add(rl4Var);
        } else if (B(rl4Var)) {
        } else {
            J(rl4Var);
            new g(this, null).execute(rl4Var);
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
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048588, this) != null) || !A() || !this.f) {
            return;
        }
        int i2 = rl4.Y;
        List<rl4> list = (List) this.b.get(i2);
        if (list != null && !list.isEmpty()) {
            boolean z = false;
            for (rl4 rl4Var : list) {
                if (rl4Var.x() == 8) {
                    Iterator it = rl4Var.n().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        xl4 xl4Var = (xl4) it.next();
                        rl4 c2 = xl4Var.c();
                        if (c2 != null && (xl4Var instanceof bm4) && c2.d() == rl4Var.d() && c2.q() == rl4Var.q()) {
                            ((bm4) xl4Var).i();
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        bm4 bm4Var = new bm4(rl4Var);
                        bm4Var.g(0L);
                        bm4Var.f(false);
                        rl4Var.a(bm4Var);
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
            List<rl4> list = (List) this.b.get(i2);
            if (list != null && !list.isEmpty()) {
                boolean z = false;
                for (rl4 rl4Var : list) {
                    if (rl4Var.x() == 4) {
                        Iterator it = rl4Var.n().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            xl4 xl4Var = (xl4) it.next();
                            if ((xl4Var instanceof yl4) && xl4Var.c().d() == rl4Var.d() && xl4Var.c().q() == rl4Var.q()) {
                                z = true;
                                break;
                            }
                        }
                        if (!z) {
                            yl4 yl4Var = new yl4(rl4Var);
                            yl4Var.g(0L);
                            yl4Var.f(false);
                            rl4Var.a(yl4Var);
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

    public final void t(rl4 rl4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048603, this, rl4Var) != null) || rl4Var == null) {
            return;
        }
        Iterator it = rl4Var.n().iterator();
        while (it.hasNext()) {
            xl4 xl4Var = (xl4) it.next();
            if (xl4Var != null && xl4Var.c() != null) {
                rl4 c2 = xl4Var.c();
                if (c2.d() == rl4Var.d() && c2.q() == rl4Var.q()) {
                    it.remove();
                }
            }
        }
        for (int i2 = 0; i2 < this.b.size(); i2++) {
            List list = (List) this.b.valueAt(i2);
            if (list != null && !list.isEmpty()) {
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    rl4 rl4Var2 = (rl4) it2.next();
                    if (rl4Var2 != null && rl4Var2.d() == rl4Var.d() && rl4Var2.q() == rl4Var.q()) {
                        it2.remove();
                    }
                }
            }
        }
        ql4.a("deleteActivityMissionInfoDataInMemory-->activityId=" + rl4Var.d() + ",missionId=" + rl4Var.q());
    }

    public void O(int i2, long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) && A() && i2 != 0 && j2 != 0 && this.f) {
            this.k = i2;
            List<rl4> list = (List) this.b.get(i2);
            if (list != null && !list.isEmpty()) {
                boolean z = false;
                for (rl4 rl4Var : list) {
                    if (rl4Var.x() == 2) {
                        Iterator it = rl4Var.n().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            xl4 xl4Var = (xl4) it.next();
                            if ((xl4Var instanceof zl4) && xl4Var.c().d() == rl4Var.d() && xl4Var.c().q() == rl4Var.q() && ((zl4) xl4Var).i() == j2) {
                                z = true;
                                break;
                            }
                        }
                        if (!z) {
                            zl4 zl4Var = new zl4(rl4Var, j2);
                            zl4Var.g(0L);
                            zl4Var.f(false);
                            zl4Var.h(rl4Var.w());
                            rl4Var.a(zl4Var);
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
            List<rl4> list = (List) this.b.get(i2);
            if (list != null && !list.isEmpty()) {
                for (rl4 rl4Var : list) {
                    if (rl4Var.x() == 1) {
                        p(rl4Var, j2);
                    } else if (rl4Var.x() == 7 && !rl4Var.K(j2)) {
                        o(rl4Var, j2);
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
        List<rl4> list;
        am4 am4Var;
        rl4 c2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) && (list = (List) this.b.get(i2)) != null && !list.isEmpty()) {
            for (rl4 rl4Var : list) {
                if (rl4Var.x() == 7) {
                    Iterator it = rl4Var.n().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            xl4 xl4Var = (xl4) it.next();
                            if ((xl4Var instanceof am4) && (c2 = (am4Var = (am4) xl4Var).c()) != null && am4Var.i() == j2 && c2.d() == rl4Var.d() && c2.q() == rl4Var.q()) {
                                xl4Var.f(true);
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public final void o(rl4 rl4Var, long j2) {
        boolean z;
        am4 am4Var;
        rl4 c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048598, this, rl4Var, j2) == null) {
            Iterator it = rl4Var.n().iterator();
            while (true) {
                if (it.hasNext()) {
                    xl4 xl4Var = (xl4) it.next();
                    if ((xl4Var instanceof am4) && (c2 = (am4Var = (am4) xl4Var).c()) != null && am4Var.i() == j2 && c2.d() == rl4Var.d() && c2.q() == rl4Var.q()) {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
            if (!z) {
                am4 am4Var2 = new am4(rl4Var, j2);
                am4Var2.g(0L);
                am4Var2.f(false);
                am4Var2.h(rl4Var.w());
                rl4Var.a(am4Var2);
            }
        }
    }

    public final void p(rl4 rl4Var, long j2) {
        boolean z;
        cm4 cm4Var;
        rl4 c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048599, this, rl4Var, j2) == null) {
            Iterator it = rl4Var.n().iterator();
            while (true) {
                if (it.hasNext()) {
                    xl4 xl4Var = (xl4) it.next();
                    if ((xl4Var instanceof cm4) && (c2 = (cm4Var = (cm4) xl4Var).c()) != null && cm4Var.i() == j2 && c2.d() == rl4Var.d() && c2.q() == rl4Var.q()) {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
            if (!z) {
                cm4 cm4Var2 = new cm4(rl4Var, j2);
                cm4Var2.g(0L);
                cm4Var2.f(false);
                cm4Var2.h(rl4Var.w());
                rl4Var.a(cm4Var2);
            }
        }
    }

    public final void T(rl4 rl4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048595, this, rl4Var) != null) || rl4Var == null) {
            return;
        }
        int x = rl4Var.x();
        Iterator it = rl4Var.n().iterator();
        while (it.hasNext()) {
            xl4 xl4Var = (xl4) it.next();
            if (xl4Var != null && xl4Var.c() != null) {
                rl4 c2 = xl4Var.c();
                if (c2.d() == rl4Var.d() && c2.q() == rl4Var.q()) {
                    if (x == 7 && (xl4Var instanceof am4)) {
                        ((am4) xl4Var).f(true);
                    } else if (x == 1 && (xl4Var instanceof cm4)) {
                        ((cm4) xl4Var).f(true);
                    }
                }
            }
        }
        rl4Var.d0(false);
    }

    public void n(List list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048597, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (!this.f) {
            this.c.addAll(list);
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            rl4 rl4Var = (rl4) it.next();
            if (rl4Var != null) {
                if (rl4Var.x() == 9) {
                    fm4.c().f(rl4Var);
                } else if (!B(rl4Var)) {
                    J(rl4Var);
                    arrayList.add(rl4Var);
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
