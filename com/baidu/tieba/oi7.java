package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.AddBawuPopInfo;
import tbclient.FrsPage.ActivityHead;
import tbclient.FrsPage.BusinessPromot;
import tbclient.FrsPage.DataRes;
import tbclient.FrsPage.ForumInfo;
import tbclient.FrsPage.FrsBannerHeader;
import tbclient.FrsPage.FrsBottom;
import tbclient.FrsPage.FrsSpriteBubble;
import tbclient.FrsPage.LiveFuseForumData;
import tbclient.FrsPage.PrivateForumTotalInfo;
import tbclient.FrsPage.RecreationRankInfo;
import tbclient.HotUserRankEntry;
import tbclient.PopInfo;
import tbclient.PrivatePopInfo;
import tbclient.ServiceArea;
import tbclient.SignActivityInfo;
import tbclient.User;
/* loaded from: classes7.dex */
public final class oi7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DataRes a;
    public ForumInfo b;
    public BusinessPromot c;
    public FrsBottom d;
    public PrivateForumTotalInfo e;
    public PrivatePopInfo f;
    public User g;
    public PopInfo h;
    public AddBawuPopInfo i;
    public FrsSpriteBubble j;

    public final void k(ActivityHead activityHead) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, activityHead) == null) {
        }
    }

    public final void q(FrsBannerHeader frsBannerHeader) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, frsBannerHeader) == null) {
        }
    }

    public final void s(HotUserRankEntry hotUserRankEntry) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, hotUserRankEntry) == null) {
        }
    }

    public final void t(List<LiveFuseForumData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, list) == null) {
        }
    }

    public final void w(RecreationRankInfo recreationRankInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, recreationRankInfo) == null) {
        }
    }

    public final void x(List<ServiceArea> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, list) == null) {
        }
    }

    public final void y(SignActivityInfo signActivityInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, signActivityInfo) == null) {
        }
    }

    public oi7() {
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

    public final AddBawuPopInfo a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.i;
        }
        return (AddBawuPopInfo) invokeV.objValue;
    }

    public final BusinessPromot b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.c;
        }
        return (BusinessPromot) invokeV.objValue;
    }

    public final DataRes c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.a;
        }
        return (DataRes) invokeV.objValue;
    }

    public final ForumInfo d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.b;
        }
        return (ForumInfo) invokeV.objValue;
    }

    public final FrsBottom e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.d;
        }
        return (FrsBottom) invokeV.objValue;
    }

    public final PopInfo f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.h;
        }
        return (PopInfo) invokeV.objValue;
    }

    public final PrivateForumTotalInfo g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.e;
        }
        return (PrivateForumTotalInfo) invokeV.objValue;
    }

    public final PrivatePopInfo h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.f;
        }
        return (PrivatePopInfo) invokeV.objValue;
    }

    public final FrsSpriteBubble i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.j;
        }
        return (FrsSpriteBubble) invokeV.objValue;
    }

    public final User j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.g;
        }
        return (User) invokeV.objValue;
    }

    public final void A(User user) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, user) == null) {
            this.g = user;
        }
    }

    public final void l(AddBawuPopInfo addBawuPopInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, addBawuPopInfo) == null) {
            this.i = addBawuPopInfo;
        }
    }

    public final void m(BusinessPromot businessPromot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, businessPromot) == null) {
            this.c = businessPromot;
        }
    }

    public final void n(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, dataRes) == null) {
            this.a = dataRes;
        }
    }

    public final void o(ForumInfo forumInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, forumInfo) == null) {
            this.b = forumInfo;
        }
    }

    public final void p(FrsBottom frsBottom) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, frsBottom) == null) {
            this.d = frsBottom;
        }
    }

    public final void r(PopInfo popInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, popInfo) == null) {
            this.h = popInfo;
        }
    }

    public final void u(PrivateForumTotalInfo privateForumTotalInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, privateForumTotalInfo) == null) {
            this.e = privateForumTotalInfo;
        }
    }

    public final void v(PrivatePopInfo privatePopInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, privatePopInfo) == null) {
            this.f = privatePopInfo;
        }
    }

    public final void z(FrsSpriteBubble frsSpriteBubble) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, frsSpriteBubble) == null) {
            this.j = frsSpriteBubble;
        }
    }
}
