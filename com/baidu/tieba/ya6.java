package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import tbclient.GeneralResource;
import tbclient.HotUserRankEntry;
import tbclient.Tabfeedlist.DataRes;
import tbclient.ThreadInfo;
/* loaded from: classes6.dex */
public class ya6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<Cdo> a;
    public ArrayList<ut4> b;
    public ot4 c;
    public ab6 d;
    public boolean e;

    public ya6() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: a */
    public ya6 clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ya6 ya6Var = new ya6();
            ya6Var.a = this.a;
            ya6Var.b = this.b;
            ya6Var.c = this.c;
            ya6Var.d = this.d;
            ya6Var.e = this.e;
            return ya6Var;
        }
        return (ya6) invokeV.objValue;
    }

    public ab6 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.d : (ab6) invokeV.objValue;
    }

    public ot4 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.c : (ot4) invokeV.objValue;
    }

    public ArrayList<ut4> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.b : (ArrayList) invokeV.objValue;
    }

    public ArrayList<Cdo> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a : (ArrayList) invokeV.objValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.e : invokeV.booleanValue;
    }

    public void g(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, dataRes) == null) || dataRes == null) {
            return;
        }
        this.a = new ArrayList<>(ListUtils.getCount(dataRes.thread_list));
        for (ThreadInfo threadInfo : dataRes.thread_list) {
            ThreadData threadData = new ThreadData();
            threadData.parserProtobuf(threadInfo);
            threadData.insertItemToTitleOrAbstractText();
            this.a.add(threadData);
        }
        this.b = new ArrayList<>();
        if (!ListUtils.isEmpty(dataRes.resource_list)) {
            for (GeneralResource generalResource : dataRes.resource_list) {
                ut4 ut4Var = new ut4();
                ut4Var.c(generalResource);
                this.b.add(ut4Var);
            }
        }
        ot4 ot4Var = new ot4();
        this.c = ot4Var;
        ot4Var.j(dataRes.recommend_forum_info);
        if (dataRes.hot_userrank_entry != null) {
            ab6 ab6Var = new ab6();
            this.d = ab6Var;
            HotUserRankEntry hotUserRankEntry = dataRes.hot_userrank_entry;
            ab6Var.a = hotUserRankEntry.hot_user;
            ab6Var.b = hotUserRankEntry.module_name;
            ab6Var.c = hotUserRankEntry.module_icon;
        }
        this.e = dataRes.is_new_url.intValue() == 1;
    }
}
