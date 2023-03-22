package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.nd7;
import com.baidu.tieba.s39;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.DiscoverHotForum;
import tbclient.DiscoverTabCard;
import tbclient.RecommendForumInfo;
/* loaded from: classes5.dex */
public class kd7 extends hw4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public List<gn> b;

    @Override // com.baidu.tieba.hw4
    public fy4 getNegFeedBackData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (fy4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hw4
    public ThreadData getThreadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (ThreadData) invokeV.objValue;
    }

    public kd7() {
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
        this.a = false;
    }

    public List<gn> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b;
        }
        return (List) invokeV.objValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.tieba.gn
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return ag6.z0;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public static kd7 c(s39 s39Var) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, s39Var)) == null) {
            if (s39Var != null && !ListUtils.isEmpty(s39Var.b)) {
                kd7 kd7Var = new kd7();
                ArrayList arrayList = new ArrayList();
                kd7Var.i(arrayList);
                for (s39.b bVar : s39Var.b) {
                    if (!ListUtils.isEmpty(bVar.b)) {
                        nd7 nd7Var = new nd7();
                        if (!StringUtils.isNull(bVar.a) && !kd7Var.a) {
                            z = false;
                        } else {
                            z = true;
                        }
                        kd7Var.a = z;
                        nd7Var.a = bVar.a;
                        for (int i = 0; i < bVar.b.size() && i < 3; i++) {
                            nd7Var.d[i] = new nd7.a();
                            nd7.a aVar = nd7Var.d[i];
                            aVar.p(bVar.b.get(i).b);
                            aVar.o(bVar.b.get(i).e);
                            aVar.v(bVar.b.get(i).f);
                            aVar.n(bVar.b.get(i).c);
                            aVar.r(bVar.b.get(i).d);
                            aVar.s(Long.valueOf(bVar.b.get(i).a));
                        }
                        arrayList.add(nd7Var);
                        if (arrayList.size() >= 6) {
                            break;
                        }
                    }
                }
                return kd7Var;
            }
            return null;
        }
        return (kd7) invokeL.objValue;
    }

    public boolean h(List<DiscoverTabCard> list) {
        InterceptResult invokeL;
        boolean z;
        boolean booleanValue;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return false;
            }
            List<gn> arrayList = new ArrayList<>();
            i(arrayList);
            for (int i = 0; i < list.size(); i++) {
                DiscoverTabCard discoverTabCard = list.get(i);
                List<RecommendForumInfo> list2 = discoverTabCard.forum_list;
                if (list2 != null && list2.size() >= 3) {
                    nd7 nd7Var = new nd7();
                    if (!StringUtils.isNull(discoverTabCard.name) && !this.a) {
                        z = false;
                    } else {
                        z = true;
                    }
                    this.a = z;
                    nd7Var.a = discoverTabCard.name;
                    Boolean bool = discoverTabCard.is_show_order_number;
                    if (bool == null) {
                        booleanValue = false;
                    } else {
                        booleanValue = bool.booleanValue();
                    }
                    nd7Var.b = booleanValue;
                    nd7Var.c = discoverTabCard.jump_name;
                    for (int i2 = 0; i2 < discoverTabCard.forum_list.size() && i2 < 3; i2++) {
                        nd7Var.d[i2] = new nd7.a();
                        nd7.a aVar = nd7Var.d[i2];
                        aVar.p(discoverTabCard.forum_list.get(i2).forum_name);
                        aVar.o(discoverTabCard.forum_list.get(i2).avatar);
                        aVar.t(discoverTabCard.forum_list.get(i2).hot_text);
                        aVar.v(discoverTabCard.forum_list.get(i2).slogan);
                        aVar.n(discoverTabCard.forum_list.get(i2).member_count.intValue());
                        aVar.r(discoverTabCard.forum_list.get(i2).thread_count.intValue());
                        if (discoverTabCard.forum_list.get(i2).is_like.intValue() == 1) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        aVar.m(z2);
                        aVar.s(discoverTabCard.forum_list.get(i2).forum_id);
                        aVar.u(discoverTabCard.forum_list.get(i2).hot_thread_id.longValue());
                    }
                    arrayList.add(nd7Var);
                    if (arrayList.size() >= 6) {
                        break;
                    }
                }
            }
            if (arrayList.size() <= 0) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean k(DiscoverHotForum discoverHotForum, int i) {
        InterceptResult invokeLI;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, discoverHotForum, i)) == null) {
            if (TbadkCoreApplication.isLogin() && UbsABTestHelper.needShowRecommendBarCard() && discoverHotForum != null && (num = discoverHotForum.floor) != null && ((i < 0 || i == num.intValue() - 1) && !ListUtils.isEmpty(discoverHotForum.tab_list))) {
                return true;
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    public void i(List<gn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            this.b = list;
        }
    }
}
