package com.baidu.tieba;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
/* loaded from: classes6.dex */
public class lo7 {
    public static /* synthetic */ Interceptable $ic;
    public static int e;
    public static lo7 f;
    public transient /* synthetic */ FieldHolder $fh;
    public CustomMessageListener a;
    public c b;
    public Handler c;
    public SparseArray<HashSet<String>> d;

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lo7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(lo7 lo7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lo7Var, Integer.valueOf(i)};
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
            this.a = lo7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.d != null) {
                this.a.d.clear();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(lo7 lo7Var, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lo7Var, looper};
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
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            c cVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 5) {
                Object obj = message.obj;
                if ((obj instanceof c) && (cVar = (c) obj) != null) {
                    cVar.d = false;
                    cVar.a = false;
                    cVar.b = 0;
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public int b;
        public long c;
        public boolean d;

        public c(lo7 lo7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lo7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = false;
            this.b = 0;
            this.d = false;
        }

        public /* synthetic */ c(lo7 lo7Var, a aVar) {
            this(lo7Var);
        }
    }

    public lo7() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new a(this, 2005016);
        this.c = new b(this, Looper.getMainLooper());
        e = l95.m().n("card_show_statistic_max_count", 200);
        MessageManager.getInstance().registerListener(this.a);
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.b == null) {
                this.b = new c(this, null);
            }
            long currentTimeMillis = System.currentTimeMillis();
            c cVar = this.b;
            if (cVar.d) {
                return true;
            }
            if (cVar.a) {
                int i = cVar.b + 1;
                cVar.b = i;
                if (currentTimeMillis - cVar.c < AppConfig.TIMESTAMP_AVAILABLE_DURATION) {
                    if (i >= e) {
                        cVar.d = true;
                        i(cVar);
                        return true;
                    }
                } else {
                    cVar.a = false;
                    cVar.b = 0;
                }
            } else {
                cVar.a = true;
                cVar.c = currentTimeMillis;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void i(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, cVar) == null) {
            Message obtainMessage = this.c.obtainMessage();
            obtainMessage.what = 5;
            obtainMessage.obj = cVar;
            this.c.removeMessages(5);
            this.c.sendMessageDelayed(obtainMessage, 300000L);
        }
    }

    public final String j(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, threadData)) == null) {
            if (threadData.isInsertThread) {
                return String.valueOf(threadData.getInsertFloor());
            }
            return String.valueOf(4);
        }
        return (String) invokeL.objValue;
    }

    public static lo7 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f == null) {
                synchronized (xn6.class) {
                    if (f == null) {
                        f = new lo7();
                    }
                }
            }
            return f;
        }
        return (lo7) invokeV.objValue;
    }

    public static void m(FrsViewData frsViewData, int i, int i2, Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{frsViewData, Integer.valueOf(i), Integer.valueOf(i2), context}) == null) && frsViewData != null && frsViewData.getForum() != null && frsViewData.needLog == 1) {
            StatisticItem param = new StatisticItem("c11440").param("fid", frsViewData.getForum().getId()).param("obj_locate", i).param("obj_type", i2);
            if (context != null) {
                pr5.b(context, param);
            }
            TiebaStatic.log(param);
        }
    }

    public void b(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, threadData) != null) || threadData == null || !threadData.isFloor5Video()) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c11717");
        statisticItem.param("fid", threadData.getFid());
        statisticItem.param("obj_source", threadData.mRecomSource);
        statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, threadData.mRecomWeight);
        statisticItem.param("obj_param1", threadData.mRecomReason);
        statisticItem.param("obj_locate", 1);
        statisticItem.param("tid", threadData.getTid());
        xn6.b().a(statisticItem);
    }

    public void f(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, threadData) != null) || threadData == null) {
            return;
        }
        xn6.b().a(new StatisticItem("c14381").param("tid", threadData.getId()).param("fid", threadData.getFid()).param("fname", threadData.getForum_name()).param("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public int l(ko7 ko7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, ko7Var)) == null) {
            if (ko7Var == null) {
                return 5;
            }
            int i = ko7Var.b;
            int i2 = ko7Var.h;
            if (i2 == 100) {
                return 20;
            }
            int i3 = ko7Var.g;
            if (i3 > 0) {
                if (ko7Var.e == 1120) {
                    return 15;
                }
                if (i2 == 3) {
                    return 13;
                }
                return i3;
            }
            if (i == 8) {
                i = 9;
            }
            if (ko7Var.e == 504) {
                i = 11;
            }
            if (ko7Var.e == 1120) {
                return 15;
            }
            return i;
        }
        return invokeL.intValue;
    }

    public void c(ko7 ko7Var, ThreadData threadData) {
        int i;
        boolean z;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ko7Var, threadData) == null) && ko7Var != null && ko7Var.a && threadData != null && threadData.getTid() != null) {
            if (this.d == null) {
                this.d = new SparseArray<>();
            }
            if (this.d.get(ko7Var.e) == null) {
                this.d.put(ko7Var.e, new HashSet<>());
            }
            HashSet<String> hashSet = this.d.get(ko7Var.e);
            String tid = threadData.getTid();
            if (ko7Var.f >= 0) {
                tid = tid + "_" + ko7Var.f;
            }
            if (hashSet.contains(tid) || g()) {
                return;
            }
            hashSet.add(tid);
            StatisticItem statisticItem = new StatisticItem("c11439");
            statisticItem.param("fid", ko7Var.c);
            statisticItem.param("obj_locate", l(ko7Var));
            statisticItem.param("obj_source", threadData.mRecomSource);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, threadData.mRecomWeight);
            statisticItem.param("obj_param1", threadData.mRecomAbTag);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, threadData.mRecomReason);
            statisticItem.param("tid", threadData.getTid());
            statisticItem.param("nid", threadData.getNid());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param(TiebaStatic.Params.EXPOSURE_TIME, System.currentTimeMillis());
            int i4 = ko7Var.e;
            if (i4 >= 0) {
                statisticItem.param("tab_id", i4);
            }
            int i5 = threadData.statFloor;
            if (i5 >= 0) {
                statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, i5);
            }
            if (threadData.getTopAgreePost() != null && (threadData.getTopAgreePost().a0() != null || threadData.getTopAgreePost().s0() != null)) {
                i = 1;
            } else {
                i = 0;
            }
            if (i != 0 && threadData.getTopAgreePost().a0() != null && threadData.getTopAgreePost().a0().W() != null && threadData.getTopAgreePost().a0().W().size() > 0) {
                if (threadData.getTopAgreePost().N) {
                    i3 = 3;
                } else {
                    i3 = 2;
                }
                statisticItem.param("obj_name", i3);
            } else {
                statisticItem.param("obj_name", i);
            }
            if (threadData.getType() == ThreadData.TYPE_FRS_HOTTOPIC) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                i2 = 2;
            } else {
                i2 = 1;
            }
            statisticItem.param("thread_type", i2);
            if (z && threadData.getAuthor() != null && !StringUtils.isNull(threadData.getAuthor().getName_show())) {
                statisticItem.param("obj_name", threadData.getAuthor().getName_show());
            }
            if (!threadData.isBJHVideoThreadType() && !threadData.isBJHVideoDynamicThreadType()) {
                if (threadData.isBJHArticleThreadType()) {
                    statisticItem.param("obj_type", 13);
                }
            } else {
                statisticItem.param("obj_type", 14);
            }
            xn6.b().a(statisticItem);
            if (threadData.isVideoThreadType()) {
                StatisticItem statisticItem2 = new StatisticItem("c12099");
                statisticItem2.param("fid", ko7Var.c);
                statisticItem2.param("obj_locate", l(ko7Var));
                statisticItem2.param("obj_source", threadData.mRecomSource);
                statisticItem2.param(TiebaStatic.Params.OBJ_PARAM2, threadData.mRecomWeight);
                statisticItem2.param("obj_param1", threadData.mRecomAbTag);
                statisticItem2.param(TiebaStatic.Params.OBJ_PARAM3, threadData.mRecomReason);
                statisticItem2.param("tid", threadData.getTid());
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                xn6.b().a(statisticItem2);
            }
            if (ko7Var.e == 501) {
                StatisticItem statisticItem3 = new StatisticItem("c13259");
                statisticItem3.param("fid", ko7Var.c);
                statisticItem3.param("tid", threadData.getTid());
                xn6.b().a(statisticItem3);
            }
        }
    }

    public void d(ThreadData threadData, HashSet<String> hashSet) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, threadData, hashSet) == null) && threadData != null && threadData.isTbReadDispatch()) {
            if (hashSet == null) {
                hashSet = new HashSet<>();
            }
            if (threadData.getTid() != null && !hashSet.contains(threadData.getTid())) {
                hashSet.add(threadData.getTid());
                xn6.b().a(new StatisticItem("c11662").param("obj_param1", 1).param("post_id", threadData.getTid()));
            }
        }
    }

    public void e(ThreadData threadData, boolean z) {
        int i;
        long j;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048579, this, threadData, z) != null) || threadData == null) {
            return;
        }
        StatisticItem param = new StatisticItem("c12125").param("tid", threadData.getId());
        if (z) {
            i = 2;
        } else {
            i = 1;
        }
        StatisticItem param2 = param.param("obj_locate", i);
        if (threadData.getThreadAlaInfo() != null) {
            j = threadData.getThreadAlaInfo().live_id;
        } else {
            j = -1;
        }
        xn6.b().a(param2.param("obj_id", j).param("obj_type", 1));
    }

    public void h(ko7 ko7Var, ThreadData threadData, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(1048582, this, ko7Var, threadData, i) == null) && threadData != null && threadData.getTid() != null && ko7Var != null) {
            if (ko7Var.a || threadData.isJumpToFrsVideoTabPlay) {
                xn6.b().e(true);
                StatisticItem statisticItem = new StatisticItem("c11438");
                statisticItem.param("fid", ko7Var.c);
                statisticItem.param("fname", ko7Var.d);
                statisticItem.param("obj_locate", l(ko7Var));
                statisticItem.param("obj_source", threadData.mRecomSource);
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, threadData.mRecomWeight);
                statisticItem.param("obj_param1", threadData.mRecomAbTag);
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, threadData.mRecomReason);
                statisticItem.param("tid", threadData.getTid());
                statisticItem.param("hid", qn7.c());
                if (!threadData.isBJHVideoThreadType() && !threadData.isBJHVideoDynamicThreadType()) {
                    if (threadData.isBJHArticleThreadType()) {
                        statisticItem.param("obj_type", 13);
                    } else {
                        statisticItem.param("obj_type", i);
                    }
                } else {
                    statisticItem.param("obj_type", 14);
                }
                if (i == 3) {
                    statisticItem.param(TiebaStatic.Params.OBJ_TO_PB, 2);
                }
                statisticItem.param(TiebaStatic.Params.OBJ_TO, j(threadData));
                int i3 = ko7Var.e;
                if (i3 >= 0) {
                    statisticItem.param("tab_id", i3);
                }
                int i4 = threadData.statFloor;
                if (i4 >= 0) {
                    statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, i4);
                }
                if (threadData.getType() == ThreadData.TYPE_FRS_HOTTOPIC) {
                    i2 = 2;
                } else {
                    i2 = 1;
                }
                statisticItem.param("thread_type", i2);
                TiebaStatic.log(statisticItem);
                if (threadData.isVideoThreadType()) {
                    StatisticItem statisticItem2 = new StatisticItem("c12098");
                    statisticItem2.param("fid", ko7Var.c);
                    statisticItem2.param("obj_locate", l(ko7Var));
                    statisticItem2.param("obj_source", threadData.mRecomSource);
                    statisticItem2.param(TiebaStatic.Params.OBJ_PARAM2, threadData.mRecomWeight);
                    statisticItem2.param("obj_param1", threadData.mRecomAbTag);
                    statisticItem2.param(TiebaStatic.Params.OBJ_PARAM3, threadData.mRecomReason);
                    statisticItem2.param("tid", threadData.getTid());
                    statisticItem2.param("obj_type", i);
                    statisticItem2.param(TiebaStatic.Params.OBJ_TO, j(threadData));
                    TiebaStatic.log(statisticItem2);
                }
                if (ko7Var.e == 501) {
                    StatisticItem statisticItem3 = new StatisticItem("c13260");
                    statisticItem3.param("fid", ko7Var.c);
                    statisticItem3.param("tid", threadData.getTid());
                    xn6.b().a(statisticItem3);
                }
                if (threadData.getAuthor() != null && threadData.getAuthor().getAlaUserData() != null) {
                    AlaUserInfoData alaUserData = threadData.getAuthor().getAlaUserData();
                    if (alaUserData.live_status == 1 && alaUserData.live_id > 0) {
                        StatisticItem statisticItem4 = new StatisticItem("c11850");
                        statisticItem4.param("uid", TbadkCoreApplication.getCurrentAccount());
                        TiebaStatic.log(statisticItem4);
                    }
                }
            }
        }
    }
}
