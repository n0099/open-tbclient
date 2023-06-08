package com.baidu.tieba;

import android.content.Context;
import android.os.Handler;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
import com.baidu.tieba.frs.game.strategy.message.FrsGameStrategyHttpResponseMessage;
import com.baidu.tieba.frs.game.strategy.message.FrsGameStrategyRequestMessage;
import com.baidu.tieba.frs.game.strategy.message.FrsGameStrategySocketResponseMessage;
import com.baidu.tieba.kj7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes6.dex */
public class lj7 implements mj7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public BdUniqueId b;
    public nj7 c;
    public List<qj7> d;
    public final HashMap<String, ij7> e;
    public int f;
    public int g;
    public int h;
    public boolean i;
    public long j;
    public Handler k;
    public kj7 l;
    public kj7.c m;
    public jb n;

    /* loaded from: classes6.dex */
    public class a implements kj7.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lj7 a;

        public a(lj7 lj7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lj7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lj7Var;
        }

        @Override // com.baidu.tieba.kj7.c
        public void a(List<qj7> list, List<vn> list2, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLZ(1048576, this, list, list2, z) == null) && this.a.d != null && this.a.c != null) {
                this.a.c.a(0, 0, list2, list, z, true, -1);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends jb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lj7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(lj7 lj7Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lj7Var, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lj7Var;
        }

        /* JADX WARN: Removed duplicated region for block: B:54:0x0127  */
        /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
        @Override // com.baidu.tieba.jb
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            List<vn> threadList;
            boolean hasMore;
            int i;
            qj7 qj7Var;
            gj7 gj7Var;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, responsedMessage) != null) || responsedMessage == null) {
                return;
            }
            this.a.i = false;
            if (responsedMessage.hasError()) {
                if (this.a.c != null) {
                    this.a.c.b(this.a.f, this.a.g, responsedMessage.getErrorString());
                    return;
                }
                return;
            }
            if (responsedMessage instanceof FrsGameStrategySocketResponseMessage) {
                FrsGameStrategySocketResponseMessage frsGameStrategySocketResponseMessage = (FrsGameStrategySocketResponseMessage) responsedMessage;
                if (this.a.d == null) {
                    this.a.d = frsGameStrategySocketResponseMessage.getTabList();
                }
                threadList = frsGameStrategySocketResponseMessage.getThreadList();
                hasMore = frsGameStrategySocketResponseMessage.hasMore();
            } else if (responsedMessage instanceof FrsGameStrategyHttpResponseMessage) {
                FrsGameStrategyHttpResponseMessage frsGameStrategyHttpResponseMessage = (FrsGameStrategyHttpResponseMessage) responsedMessage;
                if (this.a.d == null) {
                    this.a.d = frsGameStrategyHttpResponseMessage.getTabList();
                }
                threadList = frsGameStrategyHttpResponseMessage.getThreadList();
                hasMore = frsGameStrategyHttpResponseMessage.hasMore();
            } else {
                return;
            }
            int i2 = this.a.f;
            int i3 = this.a.g;
            if (this.a.f == 0 && this.a.g == 0 && !ListUtils.isEmpty(this.a.d) && (qj7Var = (qj7) this.a.d.get(0)) != null) {
                i2 = qj7Var.a;
                Object obj = qj7Var.c;
                if (obj instanceof LabelDataList) {
                    LabelDataList labelDataList = (LabelDataList) obj;
                    if (!labelDataList.isEmpty() && (gj7Var = labelDataList.get(0)) != null) {
                        i3 = gj7Var.a;
                    }
                }
            }
            String o = this.a.o(i2, i3);
            ij7 ij7Var = (ij7) this.a.e.get(o);
            if (ij7Var == null) {
                ij7Var = new ij7();
                this.a.e.put(o, ij7Var);
                this.a.e.put(o, ij7Var);
            }
            ij7Var.e = hasMore;
            ij7Var.f = this.a.h;
            if (!ListUtils.isEmpty(threadList)) {
                if (this.a.h == 0) {
                    if (ListUtils.isEmpty(ij7Var.d)) {
                        ij7Var.d = threadList;
                    } else {
                        i = ij7Var.a(threadList);
                        if (this.a.c == null) {
                            this.a.c.a(this.a.f, this.a.g, ij7Var.d, this.a.d, ij7Var.e, false, i);
                            return;
                        }
                        return;
                    }
                } else {
                    ij7Var.d.addAll(threadList);
                }
            }
            i = -1;
            if (this.a.c == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ lj7 c;

        public c(lj7 lj7Var, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lj7Var, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = lj7Var;
            this.a = i;
            this.b = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.b(this.a, this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ lj7 c;

        public d(lj7 lj7Var, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lj7Var, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = lj7Var;
            this.a = i;
            this.b = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.c(this.a, this.b);
            }
        }
    }

    public lj7(Context context, BdUniqueId bdUniqueId, long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bdUniqueId, Long.valueOf(j), str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.i = false;
        this.j = 0L;
        this.k = new Handler();
        this.m = new a(this);
        this.n = new b(this, CmdConfigHttp.CMD_FRS_GAME_STRATEGY, 309478);
        this.a = context;
        this.b = bdUniqueId;
        this.j = j;
        this.e = new HashMap<>();
        kj7 kj7Var = new kj7();
        this.l = kj7Var;
        kj7Var.e(this.m);
        r();
        s();
    }

    public void t(nj7 nj7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, nj7Var) == null) {
            this.c = nj7Var;
        }
    }

    public final String o(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048581, this, i, i2)) == null) {
            return i + "_" + i2;
        }
        return (String) invokeII.objValue;
    }

    public ij7 p(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048582, this, i, i2)) == null) {
            return this.e.get(o(i, i2));
        }
        return (ij7) invokeII.objValue;
    }

    public static void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            rx9.h(309478, FrsGameStrategySocketResponseMessage.class, false, false);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_FRS_GAME_STRATEGY, rx9.a("c/f/game/gameForumGuideTab", 309478));
            tbHttpMessageTask.setIsNeedLogin(false);
            tbHttpMessageTask.setIsNeedTbs(false);
            tbHttpMessageTask.setIsNeedAddCommenParam(false);
            tbHttpMessageTask.setIsUseCurrentBDUSS(false);
            tbHttpMessageTask.setResponsedClass(FrsGameStrategyHttpResponseMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    @Override // com.baidu.tieba.mj7
    public qj7 a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            if (ListUtils.isEmpty(this.d)) {
                return null;
            }
            for (qj7 qj7Var : this.d) {
                if (qj7Var != null && qj7Var.a == i) {
                    return qj7Var;
                }
            }
            return null;
        }
        return (qj7) invokeI.objValue;
    }

    public final qj7 n(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            if (ListUtils.isEmpty(this.d)) {
                return null;
            }
            for (qj7 qj7Var : this.d) {
                if (qj7Var != null && qj7Var.a == i) {
                    return qj7Var;
                }
            }
            return null;
        }
        return (qj7) invokeI.objValue;
    }

    @Override // com.baidu.tieba.mj7
    public void b(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) {
            if (this.i) {
                this.k.postDelayed(new c(this, i, i2), 1000L);
                return;
            }
            this.f = i;
            this.g = i2;
            if (i == 0 && i2 == 0) {
                this.l.c(String.valueOf(this.j));
            } else {
                String o = o(i, i2);
                ij7 ij7Var = this.e.get(o);
                if (ij7Var == null) {
                    ij7Var = new ij7();
                    this.e.put(o, ij7Var);
                }
                ij7Var.a = o;
                ij7Var.b = this.f;
                ij7Var.c = this.g;
                ij7Var.f = 0;
                ij7Var.e = true;
            }
            this.h = 0;
            FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.j, 0, this.f, this.g);
            frsGameStrategyRequestMessage.setTag(this.b);
            MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
            this.i = true;
        }
    }

    @Override // com.baidu.tieba.mj7
    public void c(int i, int i2) {
        gj7 gj7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            if (this.i) {
                this.k.postDelayed(new d(this, i, i2), 1000L);
                return;
            }
            this.f = i;
            if (i == 0 && i2 == 0) {
                qj7 n = n(i);
                if (n != null) {
                    Object obj = n.c;
                    if (obj instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) obj;
                        if (!labelDataList.isEmpty() && (gj7Var = labelDataList.get(0)) != null) {
                            this.g = gj7Var.a;
                        }
                    }
                }
            } else {
                this.g = i2;
            }
            String o = o(i, i2);
            ij7 ij7Var = this.e.get(o);
            if (ij7Var == null) {
                ij7Var = new ij7();
                this.e.put(o, ij7Var);
                ij7Var.e = true;
                this.e.put(o, ij7Var);
            }
            int i3 = ij7Var.f + 1;
            this.h = i3;
            FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.j, i3, this.f, this.g);
            frsGameStrategyRequestMessage.setTag(this.b);
            MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
            this.i = true;
        }
    }

    @Override // com.baidu.tieba.mj7
    public boolean d(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048579, this, i, i2)) == null) {
            ij7 p = p(i, i2);
            if (p != null && !ListUtils.isEmpty(p.d)) {
                nj7 nj7Var = this.c;
                if (nj7Var != null) {
                    nj7Var.a(i, i2, p.d, this.d, p.e, false, -1);
                    return true;
                }
                return true;
            }
            return false;
        }
        return invokeII.booleanValue;
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.k.removeCallbacksAndMessages(null);
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.n.setTag(this.b);
            MessageManager.getInstance().registerListener(this.n);
        }
    }

    @Override // com.baidu.tieba.mj7
    public String w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return String.valueOf(this.j);
        }
        return (String) invokeV.objValue;
    }
}
