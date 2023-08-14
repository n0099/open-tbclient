package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.safe.JavaTypesHelper;
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
/* loaded from: classes8.dex */
public class xj9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<ym> a;
    public final RelateRecThreadListModel b;
    public ci9 c;
    public PbModel d;
    public boolean e;
    public List<ym> f;
    public final gz4 g;

    /* loaded from: classes8.dex */
    public class a implements gz4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xj9 a;

        public a(xj9 xj9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xj9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xj9Var;
        }

        @Override // com.baidu.tieba.gz4
        public void onError(int i, String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) && this.a.c != null && this.a.c.s1() != null) {
                this.a.c.s1().Q();
            }
        }

        @Override // com.baidu.tieba.gz4
        public void onSuccess(Object obj) {
            String str;
            int intValue;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
                if (this.a.d != null && (obj instanceof DataRes)) {
                    DataRes dataRes = (DataRes) obj;
                    td9 s1 = this.a.d.s1();
                    if (s1.k() != null) {
                        str = s1.k().getFirst_class();
                    } else {
                        str = "";
                    }
                    List<ThreadInfo> list = dataRes.recom_thread_info;
                    if (ListUtils.isEmpty(list)) {
                        if (this.a.c != null && this.a.c.s1() != null) {
                            this.a.c.s1().y(s1.s());
                            this.a.c.s1().Q();
                            if (s1.s()) {
                                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_SHOW);
                                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                                statisticItem.param("fid", s1.l());
                                statisticItem.param("fname", s1.m());
                                statisticItem.param("tid", s1.Q());
                                TiebaStatic.log(statisticItem);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    List<ym> b = yj9.b(list, str, this.a.d.r1());
                    this.a.a.addAll(b);
                    s1.S0(this.a.a);
                    this.a.f.addAll(b);
                    Integer num = dataRes.rec_type;
                    if (num == null) {
                        intValue = 0;
                    } else {
                        intValue = num.intValue();
                    }
                    s1.O0(intValue);
                }
                if (this.a.c != null && !ListUtils.isEmpty(this.a.a)) {
                    this.a.c.m4();
                }
                if (this.a.c != null && this.a.c.s1() != null && this.a.c.s1().q() && !ListUtils.isEmpty(this.a.a)) {
                    this.a.c.s1().n();
                }
            }
        }
    }

    public xj9(vl9 vl9Var, BdUniqueId bdUniqueId, ci9 ci9Var, PbModel pbModel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vl9Var, bdUniqueId, ci9Var, pbModel};
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
        this.c = ci9Var;
        this.d = pbModel;
        RelateRecThreadListModel relateRecThreadListModel = new RelateRecThreadListModel(vl9Var.getPageContext(), bdUniqueId);
        this.b = relateRecThreadListModel;
        relateRecThreadListModel.U(this.g);
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            PbModel pbModel = this.d;
            if (pbModel == null || TextUtils.isEmpty(pbModel.M1()) || this.d.s1() == null) {
                return false;
            }
            if (this.e) {
                return true;
            }
            if (this.d.s1().c0()) {
                return false;
            }
            String forumId = this.d.getForumId();
            if (TextUtils.isEmpty(forumId) && this.d.s1().k() != null) {
                forumId = this.d.s1().k().getId();
            }
            long j = JavaTypesHelper.toLong(forumId, 0L);
            long j2 = JavaTypesHelper.toLong(this.d.M1(), 0L);
            int I1 = this.d.I1();
            String H1 = this.d.H1();
            if (!this.e) {
                this.e = true;
            }
            return this.b.T(j, j2, 1, I1, H1);
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

    public void f(ci9 ci9Var, PbModel pbModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, ci9Var, pbModel) == null) {
            this.c = ci9Var;
            this.d = pbModel;
        }
    }
}
