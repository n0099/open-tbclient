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
import com.baidu.tieba.ij7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes6.dex */
public class jj7 implements kj7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public BdUniqueId b;
    public lj7 c;
    public List<oj7> d;
    public final HashMap<String, gj7> e;
    public int f;
    public int g;
    public int h;
    public boolean i;
    public long j;
    public Handler k;
    public ij7 l;
    public ij7.c m;
    public jb n;

    /* loaded from: classes6.dex */
    public class a implements ij7.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jj7 a;

        public a(jj7 jj7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jj7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jj7Var;
        }

        @Override // com.baidu.tieba.ij7.c
        public void a(List<oj7> list, List<vn> list2, boolean z) {
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
        public final /* synthetic */ jj7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(jj7 jj7Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jj7Var, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = jj7Var;
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
            oj7 oj7Var;
            ej7 ej7Var;
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
            if (this.a.f == 0 && this.a.g == 0 && !ListUtils.isEmpty(this.a.d) && (oj7Var = (oj7) this.a.d.get(0)) != null) {
                i2 = oj7Var.a;
                Object obj = oj7Var.c;
                if (obj instanceof LabelDataList) {
                    LabelDataList labelDataList = (LabelDataList) obj;
                    if (!labelDataList.isEmpty() && (ej7Var = labelDataList.get(0)) != null) {
                        i3 = ej7Var.a;
                    }
                }
            }
            String o = this.a.o(i2, i3);
            gj7 gj7Var = (gj7) this.a.e.get(o);
            if (gj7Var == null) {
                gj7Var = new gj7();
                this.a.e.put(o, gj7Var);
                this.a.e.put(o, gj7Var);
            }
            gj7Var.e = hasMore;
            gj7Var.f = this.a.h;
            if (!ListUtils.isEmpty(threadList)) {
                if (this.a.h == 0) {
                    if (ListUtils.isEmpty(gj7Var.d)) {
                        gj7Var.d = threadList;
                    } else {
                        i = gj7Var.a(threadList);
                        if (this.a.c == null) {
                            this.a.c.a(this.a.f, this.a.g, gj7Var.d, this.a.d, gj7Var.e, false, i);
                            return;
                        }
                        return;
                    }
                } else {
                    gj7Var.d.addAll(threadList);
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
        public final /* synthetic */ jj7 c;

        public c(jj7 jj7Var, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jj7Var, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = jj7Var;
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
        public final /* synthetic */ jj7 c;

        public d(jj7 jj7Var, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jj7Var, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = jj7Var;
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

    public jj7(Context context, BdUniqueId bdUniqueId, long j, String str) {
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
        ij7 ij7Var = new ij7();
        this.l = ij7Var;
        ij7Var.e(this.m);
        r();
        s();
    }

    public void t(lj7 lj7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, lj7Var) == null) {
            this.c = lj7Var;
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

    public gj7 p(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048582, this, i, i2)) == null) {
            return this.e.get(o(i, i2));
        }
        return (gj7) invokeII.objValue;
    }

    public static void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            mx9.h(309478, FrsGameStrategySocketResponseMessage.class, false, false);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_FRS_GAME_STRATEGY, mx9.a("c/f/game/gameForumGuideTab", 309478));
            tbHttpMessageTask.setIsNeedLogin(false);
            tbHttpMessageTask.setIsNeedTbs(false);
            tbHttpMessageTask.setIsNeedAddCommenParam(false);
            tbHttpMessageTask.setIsUseCurrentBDUSS(false);
            tbHttpMessageTask.setResponsedClass(FrsGameStrategyHttpResponseMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    @Override // com.baidu.tieba.kj7
    public oj7 a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            if (ListUtils.isEmpty(this.d)) {
                return null;
            }
            for (oj7 oj7Var : this.d) {
                if (oj7Var != null && oj7Var.a == i) {
                    return oj7Var;
                }
            }
            return null;
        }
        return (oj7) invokeI.objValue;
    }

    public final oj7 n(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            if (ListUtils.isEmpty(this.d)) {
                return null;
            }
            for (oj7 oj7Var : this.d) {
                if (oj7Var != null && oj7Var.a == i) {
                    return oj7Var;
                }
            }
            return null;
        }
        return (oj7) invokeI.objValue;
    }

    @Override // com.baidu.tieba.kj7
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
                gj7 gj7Var = this.e.get(o);
                if (gj7Var == null) {
                    gj7Var = new gj7();
                    this.e.put(o, gj7Var);
                }
                gj7Var.a = o;
                gj7Var.b = this.f;
                gj7Var.c = this.g;
                gj7Var.f = 0;
                gj7Var.e = true;
            }
            this.h = 0;
            FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.j, 0, this.f, this.g);
            frsGameStrategyRequestMessage.setTag(this.b);
            MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
            this.i = true;
        }
    }

    @Override // com.baidu.tieba.kj7
    public void c(int i, int i2) {
        ej7 ej7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            if (this.i) {
                this.k.postDelayed(new d(this, i, i2), 1000L);
                return;
            }
            this.f = i;
            if (i == 0 && i2 == 0) {
                oj7 n = n(i);
                if (n != null) {
                    Object obj = n.c;
                    if (obj instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) obj;
                        if (!labelDataList.isEmpty() && (ej7Var = labelDataList.get(0)) != null) {
                            this.g = ej7Var.a;
                        }
                    }
                }
            } else {
                this.g = i2;
            }
            String o = o(i, i2);
            gj7 gj7Var = this.e.get(o);
            if (gj7Var == null) {
                gj7Var = new gj7();
                this.e.put(o, gj7Var);
                gj7Var.e = true;
                this.e.put(o, gj7Var);
            }
            int i3 = gj7Var.f + 1;
            this.h = i3;
            FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.j, i3, this.f, this.g);
            frsGameStrategyRequestMessage.setTag(this.b);
            MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
            this.i = true;
        }
    }

    @Override // com.baidu.tieba.kj7
    public boolean d(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048579, this, i, i2)) == null) {
            gj7 p = p(i, i2);
            if (p != null && !ListUtils.isEmpty(p.d)) {
                lj7 lj7Var = this.c;
                if (lj7Var != null) {
                    lj7Var.a(i, i2, p.d, this.d, p.e, false, -1);
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

    @Override // com.baidu.tieba.kj7
    public String w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return String.valueOf(this.j);
        }
        return (String) invokeV.objValue;
    }
}
