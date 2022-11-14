package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.relatelist.RelateRecThreadListModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.RelateRecThread.DataRes;
import tbclient.ThreadInfo;
/* loaded from: classes4.dex */
public class k38 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<xn> a;
    public final RelateRecThreadListModel b;
    public s18 c;
    public PbModel d;
    public boolean e;
    public List<xn> f;
    public final dq4 g;

    /* loaded from: classes4.dex */
    public class a implements dq4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k38 a;

        public a(k38 k38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k38Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k38Var;
        }

        @Override // com.baidu.tieba.dq4
        public void onError(int i, String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) && this.a.c != null && this.a.c.Z0() != null) {
                this.a.c.Z0().O();
            }
        }

        @Override // com.baidu.tieba.dq4
        public void onSuccess(Object obj) {
            String str;
            int intValue;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
                if (this.a.d != null && (obj instanceof DataRes)) {
                    DataRes dataRes = (DataRes) obj;
                    ox7 S1 = this.a.d.S1();
                    if (S1.l() != null) {
                        str = S1.l().getFirst_class();
                    } else {
                        str = "";
                    }
                    List<ThreadInfo> list = dataRes.recom_thread_info;
                    if (ListUtils.isEmpty(list)) {
                        if (this.a.c != null && this.a.c.Z0() != null) {
                            this.a.c.Z0().w(S1.t());
                            this.a.c.Z0().O();
                            if (S1.t()) {
                                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_SHOW);
                                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                                statisticItem.param("fid", S1.m());
                                statisticItem.param("fname", S1.n());
                                statisticItem.param("tid", S1.S());
                                TiebaStatic.log(statisticItem);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    List<xn> b = l38.b(list, str, this.a.d.R1());
                    this.a.a.addAll(b);
                    S1.S0(this.a.a);
                    this.a.f.addAll(b);
                    Integer num = dataRes.rec_type;
                    if (num == null) {
                        intValue = 0;
                    } else {
                        intValue = num.intValue();
                    }
                    S1.P0(intValue);
                }
                if (this.a.c != null && !ListUtils.isEmpty(this.a.a)) {
                    this.a.c.P3();
                }
                if (this.a.c.Z0() != null && this.a.c.Z0().o() && !ListUtils.isEmpty(this.a.a)) {
                    this.a.c.Z0().l();
                }
            }
        }
    }

    public k38(z48 z48Var, BdUniqueId bdUniqueId, s18 s18Var, PbModel pbModel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {z48Var, bdUniqueId, s18Var, pbModel};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ArrayList();
        this.f = new ArrayList();
        this.g = new a(this);
        this.c = s18Var;
        this.d = pbModel;
        RelateRecThreadListModel relateRecThreadListModel = new RelateRecThreadListModel(z48Var.getPageContext(), bdUniqueId);
        this.b = relateRecThreadListModel;
        relateRecThreadListModel.G(this.g);
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            PbModel pbModel = this.d;
            if (pbModel == null || TextUtils.isEmpty(pbModel.m2()) || this.d.S1() == null) {
                return false;
            }
            if (this.e) {
                return true;
            }
            if (this.d.S1().e0()) {
                return false;
            }
            String forumId = this.d.getForumId();
            if (TextUtils.isEmpty(forumId) && this.d.S1().l() != null) {
                forumId = this.d.S1().l().getId();
            }
            long g = xg.g(forumId, 0L);
            long g2 = xg.g(this.d.m2(), 0L);
            int h2 = this.d.h2();
            String g22 = this.d.g2();
            if (!this.e) {
                this.e = true;
            }
            return this.b.F(g, g2, 1, h2, g22);
        }
        return invokeV.booleanValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a.clear();
            this.b.onDestroy();
        }
    }

    public void f(s18 s18Var, PbModel pbModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, s18Var, pbModel) == null) {
            this.c = s18Var;
            this.d = pbModel;
        }
    }
}
