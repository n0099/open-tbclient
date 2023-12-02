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
/* loaded from: classes7.dex */
public class p3a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<pi> a;
    public final RelateRecThreadListModel b;
    public n1a c;
    public PbModel d;
    public boolean e;
    public List<pi> f;
    public final uu4 g;

    /* loaded from: classes7.dex */
    public class a implements uu4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p3a a;

        public a(p3a p3aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p3aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p3aVar;
        }

        @Override // com.baidu.tieba.uu4
        public void onError(int i, String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) && this.a.c != null && this.a.c.g1() != null) {
                this.a.c.g1().Q();
            }
        }

        @Override // com.baidu.tieba.uu4
        public void onSuccess(Object obj) {
            String str;
            int intValue;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
                if (this.a.d != null && (obj instanceof DataRes)) {
                    DataRes dataRes = (DataRes) obj;
                    zv9 s1 = this.a.d.s1();
                    if (s1.n() != null) {
                        str = s1.n().getFirst_class();
                    } else {
                        str = "";
                    }
                    List<ThreadInfo> list = dataRes.recom_thread_info;
                    if (ListUtils.isEmpty(list)) {
                        if (this.a.c != null && this.a.c.g1() != null) {
                            this.a.c.g1().y(s1.v());
                            this.a.c.g1().Q();
                            if (s1.v()) {
                                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_SHOW);
                                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                                statisticItem.param("fid", s1.o());
                                statisticItem.param("fname", s1.p());
                                statisticItem.param("tid", s1.T());
                                TiebaStatic.log(statisticItem);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    List<pi> b = q3a.b(list, str, this.a.d.r1());
                    this.a.a.addAll(b);
                    s1.U0(this.a.a);
                    this.a.f.addAll(b);
                    Integer num = dataRes.rec_type;
                    if (num == null) {
                        intValue = 0;
                    } else {
                        intValue = num.intValue();
                    }
                    s1.Q0(intValue);
                }
                if (this.a.c != null && !ListUtils.isEmpty(this.a.a)) {
                    this.a.c.f4();
                }
                if (this.a.c != null && this.a.c.g1() != null && this.a.c.g1().q() && !ListUtils.isEmpty(this.a.a)) {
                    this.a.c.g1().n();
                }
            }
        }
    }

    public p3a(h6a h6aVar, BdUniqueId bdUniqueId, n1a n1aVar, PbModel pbModel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {h6aVar, bdUniqueId, n1aVar, pbModel};
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
        this.c = n1aVar;
        this.d = pbModel;
        RelateRecThreadListModel relateRecThreadListModel = new RelateRecThreadListModel(h6aVar.getPageContext(), bdUniqueId);
        this.b = relateRecThreadListModel;
        relateRecThreadListModel.V(this.g);
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
            if (this.d.s1().f0()) {
                return false;
            }
            String forumId = this.d.getForumId();
            if (TextUtils.isEmpty(forumId) && this.d.s1().n() != null) {
                forumId = this.d.s1().n().getId();
            }
            long j = JavaTypesHelper.toLong(forumId, 0L);
            long j2 = JavaTypesHelper.toLong(this.d.M1(), 0L);
            int I1 = this.d.I1();
            String H1 = this.d.H1();
            if (!this.e) {
                this.e = true;
            }
            return this.b.U(j, j2, 1, I1, H1);
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

    public void f(n1a n1aVar, PbModel pbModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, n1aVar, pbModel) == null) {
            this.c = n1aVar;
            this.d = pbModel;
        }
    }
}
