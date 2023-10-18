package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.PrivateForumPopInfoData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.enterForum.data.ForumCreateInfoData;
import com.baidu.tieba.enterForum.data.HotSearchInfoData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.ForumGuide.DataRes;
/* loaded from: classes6.dex */
public class kv6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ov6 a;
    public ay4 b;
    public ForumCreateInfoData c;
    public PrivateForumPopInfoData d;
    public sv6 e;
    public tv6 f;
    public boolean g;
    public int h;
    public HotSearchInfoData i;
    public int j;

    public kv6() {
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
        this.g = true;
        this.h = 0;
        this.a = new ov6();
        this.b = new ay4();
        this.c = new ForumCreateInfoData();
        this.d = new PrivateForumPopInfoData();
        this.e = new sv6();
        this.f = new tv6();
        this.g = false;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (System.currentTimeMillis() / rb5.a.longValue() == (this.h * 1000) / rb5.a.longValue()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public ForumCreateInfoData b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.c;
        }
        return (ForumCreateInfoData) invokeV.objValue;
    }

    public tv6 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.f;
        }
        return (tv6) invokeV.objValue;
    }

    public HotSearchInfoData d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.i;
        }
        return (HotSearchInfoData) invokeV.objValue;
    }

    public ov6 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.a;
        }
        return (ov6) invokeV.objValue;
    }

    public ay4 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.b;
        }
        return (ay4) invokeV.objValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.j;
        }
        return invokeV.intValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.g;
        }
        return invokeV.booleanValue;
    }

    public void i(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dataRes) != null) || dataRes == null) {
            return;
        }
        try {
            if (dataRes.like_forum != null) {
                this.a.c(dataRes.like_forum);
            }
            if (dataRes.forum_create_info != null) {
                this.c.R(dataRes.forum_create_info);
            }
            if (!ListUtils.isEmpty(dataRes.hot_search)) {
                this.i = new HotSearchInfoData();
                this.i.P(dataRes.hot_search.get(0).search_title);
            }
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }

    public void j(tbclient.ForumRecommend.DataRes dataRes) {
        int intValue;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048585, this, dataRes) != null) || dataRes == null) {
            return;
        }
        try {
            if (dataRes.forum_popup_info != null) {
                this.f.f(dataRes.forum_popup_info);
            }
            p(dataRes.time.intValue());
            if (dataRes.sort_type.intValue() == 0) {
                intValue = 1;
            } else {
                intValue = dataRes.sort_type.intValue();
            }
            this.j = intValue;
            if (dataRes.like_forum != null) {
                this.a.c(dataRes.like_forum);
            }
            if (dataRes.recommend_forum_info != null) {
                this.b.f(dataRes.recommend_forum_info);
            }
            if (dataRes.forum_create_info != null) {
                this.c.R(dataRes.forum_create_info);
            }
            if (dataRes.private_forum_popinfo != null) {
                this.d.S(dataRes.private_forum_popinfo);
            }
            if (dataRes.hot_search != null) {
                HotSearchInfoData hotSearchInfoData = new HotSearchInfoData();
                this.i = hotSearchInfoData;
                hotSearchInfoData.O(dataRes.hot_search);
            }
            if (dataRes.nav_tab_info != null) {
                this.e.a(dataRes.nav_tab_info);
            }
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }

    public void k(ForumCreateInfoData forumCreateInfoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, forumCreateInfoData) == null) {
            this.c = forumCreateInfoData;
        }
    }

    public void l(HotSearchInfoData hotSearchInfoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, hotSearchInfoData) == null) {
            this.i = hotSearchInfoData;
        }
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.g = z;
        }
    }

    public void n(ov6 ov6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, ov6Var) == null) {
            this.a = ov6Var;
        }
    }

    public void o(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.j = i;
        }
    }

    public void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.h = i;
        }
    }
}
