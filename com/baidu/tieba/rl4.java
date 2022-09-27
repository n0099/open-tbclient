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
import com.baidu.tieba.xm4;
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
public class rl4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ScheduledExecutorService a;
    public final SparseArray<List<ql4>> b;
    public final LinkedList<ql4> c;
    public f d;
    public AtomicBoolean e;
    public boolean f;
    public boolean g;
    public BdUniqueId h;
    public xm4 i;
    public rm4 j;
    public int k;
    public long l;
    public int m;
    public long n;
    public boolean o;
    public CustomMessageListener p;
    public CustomMessageListener q;
    public CustomMessageListener r;
    public pm4<qm4> s;
    public lp4 t;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rl4 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(rl4 rl4Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rl4Var, Integer.valueOf(i)};
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
            this.a = rl4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.f = true;
                if (this.a.c.isEmpty()) {
                    return;
                }
                Iterator it = this.a.c.iterator();
                while (it.hasNext()) {
                    this.a.m((ql4) it.next());
                }
                this.a.c.clear();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rl4 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(rl4 rl4Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rl4Var, Integer.valueOf(i)};
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
            this.a = rl4Var;
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

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rl4 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(rl4 rl4Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rl4Var, Integer.valueOf(i)};
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
            this.a = rl4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371) {
                this.a.g = true;
                this.a.q();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements pm4<qm4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rl4 a;

        public d(rl4 rl4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rl4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rl4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.pm4
        /* renamed from: b */
        public void a(qm4 qm4Var) {
            ActiveCenterData activeCenterData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qm4Var) == null) || qm4Var == null || (activeCenterData = qm4Var.g) == null || activeCenterData.mission == null) {
                return;
            }
            ql4 ql4Var = new ql4();
            ql4Var.P(qm4Var.g.mission);
            ArrayList arrayList = new ArrayList();
            arrayList.add(ql4Var);
            this.a.n(arrayList);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.kp4
        /* renamed from: c */
        public void onSuccess(qm4 qm4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, qm4Var) == null) || qm4Var == null) {
                return;
            }
            this.a.n(qm4Var.b());
        }

        @Override // com.baidu.tieba.kp4
        public void onError(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements lp4<ql4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rl4 a;

        public e(rl4 rl4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rl4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rl4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lp4
        /* renamed from: b */
        public void a(ql4 ql4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ql4Var) == null) || ql4Var == null) {
                return;
            }
            ql4 u = this.a.u(ql4Var);
            if (u != null && u.z) {
                u.S();
                this.a.S(u);
                return;
            }
            cm4.b().h(u);
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
                this.a.G(ql4Var);
            } else {
                this.a.G(u);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g extends BdAsyncTask<ql4, Integer, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public g(rl4 rl4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rl4Var};
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
        public Void doInBackground(ql4... ql4VarArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ql4VarArr)) == null) {
                if (ql4VarArr == null || ql4VarArr.length <= 0 || ql4VarArr[0] == null) {
                    return null;
                }
                ol4.g().a(ql4VarArr[0]);
                return null;
            }
            return (Void) invokeL.objValue;
        }

        public /* synthetic */ g(rl4 rl4Var, a aVar) {
            this(rl4Var);
        }
    }

    /* loaded from: classes5.dex */
    public class h extends BdAsyncTask<List<ql4>, Integer, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public h(rl4 rl4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rl4Var};
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
        public Void doInBackground(List<ql4>... listArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, listArr)) == null) {
                if (listArr == null || listArr.length <= 0 || listArr[0] == null) {
                    return null;
                }
                ol4.g().b(listArr[0]);
                return null;
            }
            return (Void) invokeL.objValue;
        }

        public /* synthetic */ h(rl4 rl4Var, a aVar) {
            this(rl4Var);
        }
    }

    /* loaded from: classes5.dex */
    public class i extends BdAsyncTask<ql4, Integer, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public i(rl4 rl4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rl4Var};
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
        public Void doInBackground(ql4... ql4VarArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ql4VarArr)) == null) {
                if (ql4VarArr == null || ql4VarArr.length <= 0 || ql4VarArr[0] == null) {
                    return null;
                }
                ol4.g().e(ql4VarArr[0]);
                return null;
            }
            return (Void) invokeL.objValue;
        }

        public /* synthetic */ i(rl4 rl4Var, a aVar) {
            this(rl4Var);
        }
    }

    /* loaded from: classes5.dex */
    public class j extends BdAsyncTask<Pair<ql4, ql4>, Integer, Pair<ql4, ql4>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rl4 a;

        public j(rl4 rl4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rl4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rl4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Pair<ql4, ql4> doInBackground(Pair<ql4, ql4>... pairArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pairArr)) == null) {
                if (pairArr == null || pairArr.length <= 0 || pairArr[0] == null) {
                    return null;
                }
                Pair<ql4, ql4> pair = pairArr[0];
                ql4 ql4Var = (ql4) pair.first;
                ql4 ql4Var2 = (ql4) pair.second;
                if (ql4Var2 != null) {
                    ol4.g().e(ql4Var2);
                }
                if (ql4Var != null) {
                    ol4.g().a(ql4Var);
                    return pair;
                }
                return pair;
            }
            return (Pair) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(Pair<ql4, ql4> pair) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pair) == null) || pair == null) {
                return;
            }
            ql4 ql4Var = (ql4) pair.first;
            ql4 ql4Var2 = (ql4) pair.second;
            if (ql4Var2 != null) {
                this.a.t(ql4Var2);
            }
            if (ql4Var != null) {
                this.a.J(ql4Var);
            }
        }

        public /* synthetic */ j(rl4 rl4Var, a aVar) {
            this(rl4Var);
        }
    }

    /* loaded from: classes5.dex */
    public class k extends BdAsyncTask<Void, Integer, LinkedList<ql4>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rl4 a;

        public k(rl4 rl4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rl4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rl4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public LinkedList<ql4> doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                LinkedList<ql4> linkedList = new LinkedList<>();
                linkedList.addAll(ol4.g().f());
                Iterator<ql4> it = linkedList.iterator();
                while (it.hasNext()) {
                    ql4 next = it.next();
                    if (next != null && next.N()) {
                        ol4.g().e(next);
                        it.remove();
                    } else if (next != null && next.x() == 7) {
                        next.o0();
                        ol4.g().i(next);
                    }
                }
                return linkedList;
            }
            return (LinkedList) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(LinkedList<ql4> linkedList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, linkedList) == null) {
                super.onPostExecute(linkedList);
                if (linkedList == null) {
                    return;
                }
                if (!linkedList.isEmpty()) {
                    Iterator<ql4> it = linkedList.iterator();
                    while (it.hasNext()) {
                        ql4 next = it.next();
                        if (next.h() != null) {
                            this.a.J(next);
                        }
                    }
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921391));
            }
        }

        public /* synthetic */ k(rl4 rl4Var, a aVar) {
            this(rl4Var);
        }
    }

    /* loaded from: classes5.dex */
    public static class l {
        public static /* synthetic */ Interceptable $ic;
        public static final rl4 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-457197497, "Lcom/baidu/tieba/rl4$l;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-457197497, "Lcom/baidu/tieba/rl4$l;");
                    return;
                }
            }
            a = new rl4(null);
        }
    }

    /* loaded from: classes5.dex */
    public class m extends BdAsyncTask<ql4, Integer, ql4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rl4 a;

        public m(rl4 rl4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rl4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rl4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public ql4 doInBackground(ql4... ql4VarArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ql4VarArr)) == null) {
                if (ql4VarArr == null || ql4VarArr.length <= 0 || ql4VarArr[0] == null) {
                    return null;
                }
                ql4 ql4Var = ql4VarArr[0];
                ol4.g().i(ql4Var);
                return ql4Var;
            }
            return (ql4) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(ql4 ql4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ql4Var) == null) && ql4Var != null && ql4Var.z) {
                ql4Var.z = false;
                rl4 rl4Var = this.a;
                rl4Var.P(rl4Var.k, this.a.l);
            }
        }

        public /* synthetic */ m(rl4 rl4Var, a aVar) {
            this(rl4Var);
        }
    }

    public /* synthetic */ rl4(a aVar) {
        this();
    }

    public static final rl4 w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? l.a : (rl4) invokeV.objValue;
    }

    public final boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? TbadkCoreApplication.getInst().isMainProcess(true) : invokeV.booleanValue;
    }

    public final boolean B(ql4 ql4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ql4Var)) == null) {
            if (ql4Var == null) {
                return false;
            }
            int[] h2 = ql4Var.h();
            if (h2 == null) {
                return true;
            }
            for (int i2 : h2) {
                List<ql4> list = this.b.get(i2);
                if (list == null) {
                    return false;
                }
                for (ql4 ql4Var2 : list) {
                    if (ql4Var2 != null && ql4Var2.d() == ql4Var.d() && ql4Var2.q() == ql4Var.q()) {
                        if (ql4Var2.N()) {
                            H(ql4Var, ql4Var2);
                        }
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.o : invokeV.booleanValue;
    }

    public boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return !TbSingleton.getInstance().isNewUserRedPackageShowed() && ox4.k().l("app_restart_times", 0) > 1;
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
            xm4 xm4Var = this.i;
            if (xm4Var != null) {
                xm4Var.m();
            }
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            List<ql4> list = this.b.get(ql4.Y);
            if (ListUtils.isEmpty(list)) {
                return;
            }
            boolean z = false;
            for (ql4 ql4Var : list) {
                Iterator<wl4> it = ql4Var.n().iterator();
                while (it.hasNext()) {
                    wl4 next = it.next();
                    if (next instanceof am4) {
                        am4 am4Var = (am4) next;
                        if (!next.e()) {
                            am4Var.i();
                            z = true;
                        }
                    }
                }
            }
            if (!z || this.e.get()) {
                return;
            }
            this.d.f(ql4.Y);
            this.e.compareAndSet(false, true);
            synchronized (this.e) {
                this.e.notify();
            }
        }
    }

    public final void G(ql4 ql4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, ql4Var) == null) {
            t(ql4Var);
            new i(this, null).execute(ql4Var);
        }
    }

    public final void H(ql4 ql4Var, ql4 ql4Var2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, ql4Var, ql4Var2) == null) {
            t(ql4Var2);
            new j(this, null).execute(new Pair(ql4Var, ql4Var2));
        }
    }

    public boolean I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.j != null && A() && this.g) {
                this.j.f(z(), C(), 1);
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void J(ql4 ql4Var) {
        int[] h2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, ql4Var) == null) {
            for (int i2 : ql4Var.h()) {
                List<ql4> list = this.b.get(i2);
                if (list == null) {
                    LinkedList linkedList = new LinkedList();
                    linkedList.add(ql4Var);
                    this.b.put(i2, linkedList);
                } else {
                    list.add(ql4Var);
                }
            }
        }
    }

    public void K(int i2, long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) && A()) {
            this.m = i2;
            long j3 = this.l;
            if (j3 > 0 && this.k > 0 && (j2 == 0 || j2 != j3)) {
                R(this.k, this.l);
                this.l = 0L;
                this.k = 0;
            }
            M();
        }
    }

    public void L(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.o = z;
        }
    }

    public void M() {
        int i2;
        List<ql4> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && A() && this.f && (list = this.b.get((i2 = ql4.Y))) != null && !list.isEmpty()) {
            boolean z = false;
            for (ql4 ql4Var : list) {
                if (ql4Var.x() == 8) {
                    Iterator<wl4> it = ql4Var.n().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        wl4 next = it.next();
                        ql4 c2 = next.c();
                        if (c2 != null && (next instanceof am4) && c2.d() == ql4Var.d() && c2.q() == ql4Var.q()) {
                            ((am4) next).i();
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        am4 am4Var = new am4(ql4Var);
                        am4Var.g(0L);
                        am4Var.f(false);
                        ql4Var.a(am4Var);
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
            List<ql4> list = this.b.get(i2);
            if (list == null || list.isEmpty()) {
                return;
            }
            boolean z = false;
            for (ql4 ql4Var : list) {
                if (ql4Var.x() == 4) {
                    Iterator<wl4> it = ql4Var.n().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        wl4 next = it.next();
                        if ((next instanceof xl4) && next.c().d() == ql4Var.d() && next.c().q() == ql4Var.q()) {
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        xl4 xl4Var = new xl4(ql4Var);
                        xl4Var.g(0L);
                        xl4Var.f(false);
                        ql4Var.a(xl4Var);
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

    public void O(int i2, long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) && A() && i2 != 0 && j2 != 0 && this.f) {
            this.k = i2;
            List<ql4> list = this.b.get(i2);
            if (list == null || list.isEmpty()) {
                return;
            }
            boolean z = false;
            for (ql4 ql4Var : list) {
                if (ql4Var.x() == 2) {
                    Iterator<wl4> it = ql4Var.n().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        wl4 next = it.next();
                        if ((next instanceof yl4) && next.c().d() == ql4Var.d() && next.c().q() == ql4Var.q() && ((yl4) next).i() == j2) {
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        yl4 yl4Var = new yl4(ql4Var, j2);
                        yl4Var.g(0L);
                        yl4Var.f(false);
                        yl4Var.h(ql4Var.w());
                        ql4Var.a(yl4Var);
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

    public void P(int i2, long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) && A() && i2 != 0 && j2 != 0 && this.f) {
            this.k = i2;
            List<ql4> list = this.b.get(i2);
            if (list == null || list.isEmpty()) {
                return;
            }
            for (ql4 ql4Var : list) {
                if (ql4Var.x() == 1) {
                    p(ql4Var, j2);
                } else if (ql4Var.x() == 7 && !ql4Var.K(j2)) {
                    o(ql4Var, j2);
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

    public final void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.a.scheduleWithFixedDelay(this.d, 0L, 1L, TimeUnit.SECONDS);
        }
    }

    public void R(int i2, long j2) {
        List<ql4> list;
        zl4 zl4Var;
        ql4 c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) || (list = this.b.get(i2)) == null || list.isEmpty()) {
            return;
        }
        for (ql4 ql4Var : list) {
            if (ql4Var.x() == 7) {
                Iterator<wl4> it = ql4Var.n().iterator();
                while (true) {
                    if (it.hasNext()) {
                        wl4 next = it.next();
                        if ((next instanceof zl4) && (c2 = (zl4Var = (zl4) next).c()) != null && zl4Var.i() == j2 && c2.d() == ql4Var.d() && c2.q() == ql4Var.q()) {
                            next.f(true);
                            break;
                        }
                    }
                }
            }
        }
    }

    public final void S(ql4 ql4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, ql4Var) == null) {
            T(ql4Var);
            new m(this, null).execute(ql4Var);
        }
    }

    public final void T(ql4 ql4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, ql4Var) == null) || ql4Var == null) {
            return;
        }
        int x = ql4Var.x();
        Iterator<wl4> it = ql4Var.n().iterator();
        while (it.hasNext()) {
            wl4 next = it.next();
            if (next != null && next.c() != null) {
                ql4 c2 = next.c();
                if (c2.d() == ql4Var.d() && c2.q() == ql4Var.q()) {
                    if (x == 7 && (next instanceof zl4)) {
                        ((zl4) next).f(true);
                    } else if (x == 1 && (next instanceof bm4)) {
                        ((bm4) next).f(true);
                    }
                }
            }
        }
        ql4Var.d0(false);
    }

    public void m(ql4 ql4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, ql4Var) == null) || ql4Var == null) {
            return;
        }
        if (ql4Var.x() == 9) {
            em4.c().f(ql4Var);
        } else if (!this.f) {
            this.c.add(ql4Var);
        } else if (B(ql4Var)) {
        } else {
            J(ql4Var);
            new g(this, null).execute(ql4Var);
        }
    }

    public void n(List<ql4> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (!this.f) {
            this.c.addAll(list);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (ql4 ql4Var : list) {
            if (ql4Var != null) {
                if (ql4Var.x() == 9) {
                    em4.c().f(ql4Var);
                } else if (!B(ql4Var)) {
                    J(ql4Var);
                    arrayList.add(ql4Var);
                }
            }
        }
        new h(this, null).execute(arrayList);
    }

    public final void o(ql4 ql4Var, long j2) {
        boolean z;
        zl4 zl4Var;
        ql4 c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048598, this, ql4Var, j2) == null) {
            Iterator<wl4> it = ql4Var.n().iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                wl4 next = it.next();
                if ((next instanceof zl4) && (c2 = (zl4Var = (zl4) next).c()) != null && zl4Var.i() == j2 && c2.d() == ql4Var.d() && c2.q() == ql4Var.q()) {
                    z = true;
                    break;
                }
            }
            if (z) {
                return;
            }
            zl4 zl4Var2 = new zl4(ql4Var, j2);
            zl4Var2.g(0L);
            zl4Var2.f(false);
            zl4Var2.h(ql4Var.w());
            ql4Var.a(zl4Var2);
        }
    }

    public final void p(ql4 ql4Var, long j2) {
        boolean z;
        bm4 bm4Var;
        ql4 c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048599, this, ql4Var, j2) == null) {
            Iterator<wl4> it = ql4Var.n().iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                wl4 next = it.next();
                if ((next instanceof bm4) && (c2 = (bm4Var = (bm4) next).c()) != null && bm4Var.i() == j2 && c2.d() == ql4Var.d() && c2.q() == ql4Var.q()) {
                    z = true;
                    break;
                }
            }
            if (z) {
                return;
            }
            bm4 bm4Var2 = new bm4(ql4Var, j2);
            bm4Var2.g(0L);
            bm4Var2.f(false);
            bm4Var2.h(ql4Var.w());
            ql4Var.a(bm4Var2);
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && this.j != null && A() && this.g) {
            if (!s() || D()) {
                this.j.f(z(), C(), 0);
            }
        }
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? UtilHelper.isSameDay(ox4.k().m("pref_key_last_active_config", 0L), System.currentTimeMillis()) : invokeV.booleanValue;
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? UtilHelper.isSameDay(x(), System.currentTimeMillis()) : invokeV.booleanValue;
    }

    public final void t(ql4 ql4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048603, this, ql4Var) == null) || ql4Var == null) {
            return;
        }
        Iterator<wl4> it = ql4Var.n().iterator();
        while (it.hasNext()) {
            wl4 next = it.next();
            if (next != null && next.c() != null) {
                ql4 c2 = next.c();
                if (c2.d() == ql4Var.d() && c2.q() == ql4Var.q()) {
                    it.remove();
                }
            }
        }
        for (int i2 = 0; i2 < this.b.size(); i2++) {
            List<ql4> valueAt = this.b.valueAt(i2);
            if (valueAt != null && !valueAt.isEmpty()) {
                Iterator<ql4> it2 = valueAt.iterator();
                while (it2.hasNext()) {
                    ql4 next2 = it2.next();
                    if (next2 != null && next2.d() == ql4Var.d() && next2.q() == ql4Var.q()) {
                        it2.remove();
                    }
                }
            }
        }
        pl4.a("deleteActivityMissionInfoDataInMemory-->activityId=" + ql4Var.d() + ",missionId=" + ql4Var.q());
    }

    public final ql4 u(ql4 ql4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, ql4Var)) == null) {
            if (ql4Var == null) {
                return null;
            }
            for (int i2 = 0; i2 < this.b.size(); i2++) {
                List<ql4> valueAt = this.b.valueAt(i2);
                if (valueAt != null && !valueAt.isEmpty()) {
                    for (ql4 ql4Var2 : valueAt) {
                        if (ql4Var2 != null && ql4Var2.d() == ql4Var.d() && ql4Var2.q() == ql4Var.q()) {
                            return ql4Var2;
                        }
                    }
                    continue;
                }
            }
            return null;
        }
        return (ql4) invokeL.objValue;
    }

    public int v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.m : invokeV.intValue;
    }

    public final long x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            long m2 = ox4.k().m("pref_key_active_config_info", 0L);
            this.n = m2;
            return m2;
        }
        return invokeV.longValue;
    }

    public boolean y(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048607, this, i2)) == null) {
            List<ql4> list = this.b.get(i2);
            return (list == null || list.isEmpty()) ? false : true;
        }
        return invokeI.booleanValue;
    }

    public boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? !r() : invokeV.booleanValue;
    }

    /* loaded from: classes5.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile int a;
        public volatile long b;
        public volatile long c;
        public volatile boolean d;
        public final /* synthetic */ rl4 e;

        public f(rl4 rl4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rl4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = rl4Var;
            this.d = false;
        }

        public final void a(ql4 ql4Var, xm4.d dVar) {
            ArrayList<wl4> n;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, ql4Var, dVar) == null) || ql4Var == null || dVar == null || (n = ql4Var.n()) == null) {
                return;
            }
            Iterator<wl4> it = n.iterator();
            int i = 0;
            while (it.hasNext()) {
                wl4 next = it.next();
                if (next instanceof bm4) {
                    bm4 bm4Var = (bm4) next;
                    if (this.b != 0 && bm4Var.i() == this.b && !next.e()) {
                        this.d = false;
                        next.a(1);
                        if (next.b() >= next.c().f()) {
                            next.f(true);
                            if (next.c().J() >= next.c().A()) {
                                dVar.b(next);
                            }
                        }
                        dVar.c(ql4Var);
                    }
                } else if (next instanceof zl4) {
                    zl4 zl4Var = (zl4) next;
                    if (!ql4Var.M() && zl4Var.d() == ql4Var.w()) {
                        if (this.b != 0 && zl4Var.i() == this.b && !next.e()) {
                            this.d = false;
                            next.a(1);
                        }
                        i = (int) (i + next.b());
                        if (this.b != 0 && zl4Var.i() == this.b && !next.e()) {
                            if (next.b() >= ql4Var.f()) {
                                next.f(true);
                                ql4Var.J();
                            }
                            dVar.c(ql4Var);
                        }
                        int l = ql4Var.l();
                        int A = ql4Var.A();
                        long f = ql4Var.f() * ql4Var.A();
                        if (this.b != 0 && zl4Var.i() == this.b) {
                            next.e();
                        }
                        if (i >= f && l >= A) {
                            dVar.a(ql4Var);
                            ql4Var.d0(true);
                        }
                    }
                } else if (next instanceof yl4) {
                    if (this.c != 0 && ((yl4) next).i() == this.c && !next.e()) {
                        this.d = false;
                        next.a(1);
                        if (next.b() >= next.c().f()) {
                            next.f(true);
                            if (next.c().H() >= next.c().p()) {
                                dVar.b(next);
                            }
                        }
                    }
                } else if ((next instanceof xl4) && !next.e()) {
                    this.d = false;
                    next.a(1);
                    if (next.b() >= next.c().f()) {
                        next.f(true);
                        dVar.b(next);
                    }
                }
            }
        }

        public final void b(ql4 ql4Var, xm4.d dVar) {
            ArrayList<wl4> n;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ql4Var, dVar) == null) || ql4Var == null || dVar == null || (n = ql4Var.n()) == null) {
                return;
            }
            Iterator<wl4> it = n.iterator();
            while (it.hasNext()) {
                wl4 next = it.next();
                if ((next instanceof am4) && !((am4) next).j() && !next.e()) {
                    this.d = false;
                    next.a(1);
                    if (next.b() >= next.c().f()) {
                        next.f(true);
                        dVar.a(ql4Var);
                    }
                    dVar.c(ql4Var);
                }
            }
        }

        public final void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.d = true;
                List<ql4> list = (List) this.e.b.get(ql4.Y);
                List<ql4> list2 = (List) this.e.b.get(this.a);
                if (ListUtils.isEmpty(list) && ListUtils.isEmpty(list2)) {
                    this.e.e.compareAndSet(true, false);
                    return;
                }
                xm4.d dVar = new xm4.d();
                dVar.a = new LinkedList();
                dVar.b = new LinkedList();
                dVar.c = new LinkedList();
                d(list, dVar);
                e(list2, dVar);
                if (this.d) {
                    this.e.e.compareAndSet(true, false);
                }
                if (!ListUtils.isEmpty(dVar.c)) {
                    ol4.g().k(dVar.c);
                }
                if (ListUtils.isEmpty(dVar.a) && ListUtils.isEmpty(dVar.b)) {
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921379, dVar));
            }
        }

        public final void d(List<ql4> list, xm4.d dVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048579, this, list, dVar) == null) || ListUtils.isEmpty(list)) {
                return;
            }
            for (ql4 ql4Var : list) {
                b(ql4Var, dVar);
            }
        }

        public final void e(List<ql4> list, xm4.d dVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048580, this, list, dVar) == null) || ListUtils.isEmpty(list)) {
                return;
            }
            for (ql4 ql4Var : list) {
                a(ql4Var, dVar);
            }
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

        public /* synthetic */ f(rl4 rl4Var, a aVar) {
            this(rl4Var);
        }
    }

    public rl4() {
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
        xm4 xm4Var = new xm4(gen);
        this.i = xm4Var;
        xm4Var.w(this.t);
        rm4 rm4Var = new rm4(this.h);
        this.j = rm4Var;
        rm4Var.g(this.s);
        new tm4(this.h);
        this.r.setTag(this.h);
        MessageManager.getInstance().registerListener(this.r);
        this.q.setTag(this.h);
        MessageManager.getInstance().registerListener(this.q);
        this.p.setPriority(Integer.MIN_VALUE);
        this.p.setTag(this.h);
        MessageManager.getInstance().registerListener(this.p);
        mx4.e().f();
        em4.c().d(this.h);
        Q();
        if (A()) {
            new k(this, null).execute(new Void[0]);
        }
    }
}
