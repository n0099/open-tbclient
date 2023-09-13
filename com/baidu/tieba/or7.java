package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class or7 implements CustomMessageTask.CustomRunnable<ThreadData>, kp6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public vt7 a;
    public TbPageTag b;
    public BdUniqueId c;
    public int d;

    @Override // com.baidu.tieba.kp6
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
        }
    }

    @Override // com.baidu.tieba.kp6
    public void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
        }
    }

    public or7(vt7 vt7Var, TbPageTag tbPageTag, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vt7Var, tbPageTag, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
        this.a = vt7Var;
        this.b = tbPageTag;
        this.c = bdUniqueId;
    }

    public final void b(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, threadData) == null) && threadData != null && threadData.getAuthor() != null && threadData.getThreadAlaInfo() != null) {
            TiebaStatic.log(d(threadData, "c13615"));
        }
    }

    public final void c(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, threadData) == null) && threadData != null && threadData.getAuthor() != null && threadData.getThreadAlaInfo() != null) {
            ep6.b().a(d(threadData, "c13614"));
        }
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.d = i;
        }
    }

    @NonNull
    public final StatisticItem d(@NonNull ThreadData threadData, String str) {
        InterceptResult invokeLL;
        long j;
        int i;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, threadData, str)) == null) {
            if (threadData.getThreadAlaInfo().user_info != null) {
                j = threadData.getThreadAlaInfo().user_info.ala_id;
            } else {
                j = 0;
            }
            StatisticItem statisticItem = new StatisticItem(str);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("fid", threadData.getFid());
            statisticItem.param("ab_tag", threadData.mRecomAbTag);
            if (threadData.getThreadAlaInfo().isChushou) {
                i = 2;
            } else {
                i = 1;
            }
            statisticItem.param("obj_type", i);
            statisticItem.param("tid", threadData.getTid());
            statisticItem.param("liveid", threadData.getThreadAlaInfo().live_id);
            statisticItem.param(TiebaStatic.Params.STAR_ID, j);
            statisticItem.param("extra", threadData.mRecomExtra);
            statisticItem.param("source_from", threadData.mRecomSource);
            statisticItem.param("nid", threadData.getAuthor().getAlaInfo().mYyExtData.feedId);
            statisticItem.param("cuid", TbadkCoreApplication.getInst().getCuid());
            int i2 = this.d;
            if (i2 == 14) {
                statisticItem.param("obj_locate", 1);
            } else if (i2 == 13) {
                statisticItem.param("obj_locate", 2);
            }
            if (threadData.getAuthor() != null && threadData.getAuthor().getAlaInfo() != null) {
                statisticItem.param("obj_param1", YYLiveUtil.calculateLiveType(threadData.getAuthor().getAlaInfo()));
                if (threadData.getAuthor().getAlaInfo().mYyExtData != null) {
                    TiebaStaticHelper.addYYParam(statisticItem, threadData.getAuthor().getAlaInfo().mYyExtData);
                    str2 = TiebaStatic.YYValues.YY_LIVE;
                } else {
                    str2 = "";
                }
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, str2);
            }
            return statisticItem;
        }
        return (StatisticItem) invokeLL.objValue;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<ThreadData> customMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, customMessage)) == null) {
            if (customMessage != null && (customMessage.getData() instanceof ThreadData)) {
                ThreadData data = customMessage.getData();
                if (customMessage.getCmd() == 2921018) {
                    b(data);
                    wt7.k().h(this.a, data, 1);
                    ut7.e(data, 1, this.c, this.a, this.b);
                } else if (customMessage.getCmd() == 2921016) {
                    b(data);
                    wt7.k().h(this.a, data, 2);
                    ut7.e(data, 2, this.c, this.a, this.b);
                } else if (customMessage.getCmd() == 2921019) {
                    b(data);
                    wt7.k().h(this.a, data, 4);
                    ut7.e(data, 1, this.c, this.a, this.b);
                } else if (customMessage.getCmd() == 2921017) {
                    c(data);
                    wt7.k().c(this.a, data);
                    ut7.p(data, this.c, this.a, this.b);
                }
            }
            return null;
        }
        return (CustomResponsedMessage) invokeL.objValue;
    }
}
