package com.baidu.tieba;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.core.data.YyExtData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes5.dex */
public class l46 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public m46 a;
    public n46 b;
    public r46 c;
    public q46 d;
    public o46 e;
    public p46 f;
    public List<um> g;

    /* loaded from: classes5.dex */
    public class a implements f56 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;
        public final /* synthetic */ String b;

        public a(l46 l46Var, TbPageContext tbPageContext, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l46Var, tbPageContext, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbPageContext;
            this.b = str;
        }

        @Override // com.baidu.tieba.f56
        public void a(t36 t36Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, t36Var) == null) && t36Var != null && t36Var.getThreadData() != null) {
                if (t36Var.getThreadData().getThreadAlaInfo() != null && t36Var.getThreadData().getThreadAlaInfo().mYyExtData != null) {
                    AlaInfoData threadAlaInfo = t36Var.getThreadData().getThreadAlaInfo();
                    TbPageContext tbPageContext = this.a;
                    YyExtData yyExtData = threadAlaInfo.mYyExtData;
                    String str = yyExtData.mSid;
                    String str2 = yyExtData.mSsid;
                    String str3 = yyExtData.mTemplateId;
                    YYLiveUtil.jumpToYYLiveRoom(tbPageContext, str, str2, str3, "" + threadAlaInfo.roomId, threadAlaInfo.mYyExtData.streamInfo, YYLiveUtil.SOURCE_HOME_LIVE_TAB_FOLLOW_CARD);
                    AlaUserInfoData alaUserInfoData = threadAlaInfo.user_info;
                    if (alaUserInfoData != null) {
                        StatisticItem.make("c14719").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_id", alaUserInfoData.ala_id).param("obj_locate", ah6.f(this.b)).eventStat();
                        return;
                    }
                    return;
                }
                x36.h(this.a.getPageActivity(), t36Var.getThreadData());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements f56 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;

        public b(l46 l46Var, TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l46Var, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbPageContext;
        }

        @Override // com.baidu.tieba.f56
        public void a(t36 t36Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, t36Var) == null) && t36Var != null && t36Var.getThreadData() != null && t36Var.getThreadData().getThreadAlaInfo() != null && t36Var.getThreadData().getThreadAlaInfo().mYyExtData != null) {
                AlaInfoData threadAlaInfo = t36Var.getThreadData().getThreadAlaInfo();
                TbPageContext tbPageContext = this.a;
                YyExtData yyExtData = threadAlaInfo.mYyExtData;
                String str = yyExtData.mSid;
                String str2 = yyExtData.mSsid;
                String str3 = yyExtData.mTemplateId;
                YYLiveUtil.jumpToYYLiveRoom(tbPageContext, str, str2, str3, "" + threadAlaInfo.roomId, YYLiveUtil.SOURCE_HOME_LIVE_TAB_FOLLOW_HEAD);
            }
        }
    }

    public l46(TbPageContext tbPageContext, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = new LinkedList();
        this.a = new m46(tbPageContext);
        this.b = new n46(tbPageContext, str);
        this.c = new r46(tbPageContext);
        this.d = new q46(tbPageContext);
        this.e = new o46(tbPageContext);
        this.f = new p46(tbPageContext);
        this.b.u(new a(this, tbPageContext, str));
        this.d.u(new b(this, tbPageContext));
        this.g.add(this.a);
        this.g.add(this.b);
        this.g.add(this.c);
        this.g.add(this.d);
        this.g.add(this.e);
        this.g.add(this.f);
    }

    public List<um> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.g;
        }
        return (List) invokeV.objValue;
    }
}
