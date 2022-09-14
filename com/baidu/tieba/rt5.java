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
public class rt5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public st5 a;
    public tt5 b;
    public xt5 c;
    public wt5 d;
    public ut5 e;
    public vt5 f;
    public List<qn> g;

    /* loaded from: classes5.dex */
    public class a implements lu5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;
        public final /* synthetic */ String b;

        public a(rt5 rt5Var, TbPageContext tbPageContext, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rt5Var, tbPageContext, str};
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

        @Override // com.baidu.tieba.lu5
        public void a(zs5 zs5Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, zs5Var) == null) || zs5Var == null || zs5Var.getThreadData() == null) {
                return;
            }
            if (zs5Var.getThreadData().getThreadAlaInfo() != null && zs5Var.getThreadData().getThreadAlaInfo().mYyExtData != null) {
                AlaInfoData threadAlaInfo = zs5Var.getThreadData().getThreadAlaInfo();
                TbPageContext tbPageContext = this.a;
                YyExtData yyExtData = threadAlaInfo.mYyExtData;
                String str = yyExtData.mSid;
                String str2 = yyExtData.mSsid;
                String str3 = yyExtData.mTemplateId;
                YYLiveUtil.jumpToYYLiveRoom(tbPageContext, str, str2, str3, "" + threadAlaInfo.roomId, threadAlaInfo.mYyExtData.streamInfo, YYLiveUtil.SOURCE_HOME_LIVE_TAB_FOLLOW_CARD);
                AlaUserInfoData alaUserInfoData = threadAlaInfo.user_info;
                if (alaUserInfoData != null) {
                    StatisticItem.make("c14719").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_id", alaUserInfoData.ala_id).param("obj_locate", y16.f(this.b)).eventStat();
                    return;
                }
                return;
            }
            dt5.h(this.a.getPageActivity(), zs5Var.getThreadData());
        }
    }

    /* loaded from: classes5.dex */
    public class b implements lu5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;

        public b(rt5 rt5Var, TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rt5Var, tbPageContext};
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

        @Override // com.baidu.tieba.lu5
        public void a(zs5 zs5Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, zs5Var) == null) || zs5Var == null || zs5Var.getThreadData() == null || zs5Var.getThreadData().getThreadAlaInfo() == null || zs5Var.getThreadData().getThreadAlaInfo().mYyExtData == null) {
                return;
            }
            AlaInfoData threadAlaInfo = zs5Var.getThreadData().getThreadAlaInfo();
            TbPageContext tbPageContext = this.a;
            YyExtData yyExtData = threadAlaInfo.mYyExtData;
            String str = yyExtData.mSid;
            String str2 = yyExtData.mSsid;
            String str3 = yyExtData.mTemplateId;
            YYLiveUtil.jumpToYYLiveRoom(tbPageContext, str, str2, str3, "" + threadAlaInfo.roomId, YYLiveUtil.SOURCE_HOME_LIVE_TAB_FOLLOW_HEAD);
        }
    }

    public rt5(TbPageContext tbPageContext, String str) {
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
        this.a = new st5(tbPageContext);
        this.b = new tt5(tbPageContext, str);
        this.c = new xt5(tbPageContext);
        this.d = new wt5(tbPageContext);
        this.e = new ut5(tbPageContext);
        this.f = new vt5(tbPageContext);
        this.b.u(new a(this, tbPageContext, str));
        this.d.u(new b(this, tbPageContext));
        this.g.add(this.a);
        this.g.add(this.b);
        this.g.add(this.c);
        this.g.add(this.d);
        this.g.add(this.e);
        this.g.add(this.f);
    }

    public List<qn> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.g : (List) invokeV.objValue;
    }
}
