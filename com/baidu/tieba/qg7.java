package com.baidu.tieba;

import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.FrsSpriteNewUserGuide;
import com.baidu.tbadk.core.data.PrivateForumPopInfoData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.mvc.data.IResponseData;
import com.baidu.tieba.forum.databinding.ActivityForumBinding;
import com.baidu.tieba.forum.viewmodel.BottomViewModel;
import com.baidu.tieba.forum.viewmodel.ForumViewModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
import tbclient.AddBawuPopInfo;
import tbclient.FrsPage.ForumInfo;
import tbclient.FrsPage.FrsSpriteBubble;
import tbclient.FrsPage.PrivateForumTotalInfo;
import tbclient.PopInfo;
import tbclient.PrivatePopInfo;
import tbclient.User;
/* loaded from: classes7.dex */
public final class qg7 extends og7 implements b25 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final FragmentActivity b;

    @Override // com.baidu.tieba.b25
    public void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
        }
    }

    @Override // com.baidu.tieba.b25
    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.b25
    public boolean r1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public qg7(FragmentActivity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.b = activity;
    }

    @Override // com.baidu.tieba.b25
    public FrsSpriteNewUserGuide B0() {
        InterceptResult invokeV;
        FrsSpriteBubble frsSpriteBubble;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            eh7 value = ((BottomViewModel) new ViewModelProvider(this.b).get(BottomViewModel.class)).a().getValue();
            if (value != null) {
                frsSpriteBubble = value.l();
            } else {
                frsSpriteBubble = null;
            }
            return FrsSpriteNewUserGuide.parse(frsSpriteBubble);
        }
        return (FrsSpriteNewUserGuide) invokeV.objValue;
    }

    @Override // com.baidu.tieba.b25
    public UserData K1() {
        InterceptResult invokeV;
        User user;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            UserData userData = new UserData();
            eh7 value = ((BottomViewModel) new ViewModelProvider(this.b).get(BottomViewModel.class)).a().getValue();
            if (value != null) {
                user = value.m();
            } else {
                user = null;
            }
            userData.parserProtobuf(user);
            return userData;
        }
        return (UserData) invokeV.objValue;
    }

    @Override // com.baidu.tieba.b25
    public ForumData U0() {
        InterceptResult invokeV;
        ForumInfo forumInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ForumData forumData = new ForumData();
            eh7 value = ((BottomViewModel) new ViewModelProvider(this.b).get(BottomViewModel.class)).a().getValue();
            if (value != null) {
                forumInfo = value.e();
            } else {
                forumInfo = null;
            }
            forumData.parserProtobuf(forumInfo);
            return forumData;
        }
        return (ForumData) invokeV.objValue;
    }

    @Override // com.baidu.tieba.b25
    public ny4 g1() {
        InterceptResult invokeV;
        PrivateForumTotalInfo privateForumTotalInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            ny4 ny4Var = new ny4();
            eh7 value = ((BottomViewModel) new ViewModelProvider(this.b).get(BottomViewModel.class)).a().getValue();
            if (value != null) {
                privateForumTotalInfo = value.i();
            } else {
                privateForumTotalInfo = null;
            }
            ny4Var.d(privateForumTotalInfo);
            return ny4Var;
        }
        return (ny4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.b25
    public AddBawuPopInfo j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            eh7 value = ((BottomViewModel) new ViewModelProvider(this.b).get(BottomViewModel.class)).a().getValue();
            if (value != null) {
                return value.b();
            }
            return null;
        }
        return (AddBawuPopInfo) invokeV.objValue;
    }

    @Override // com.baidu.tieba.b25
    public PrivateForumPopInfoData j1() {
        InterceptResult invokeV;
        PrivatePopInfo privatePopInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            PrivateForumPopInfoData privateForumPopInfoData = new PrivateForumPopInfoData();
            eh7 value = ((BottomViewModel) new ViewModelProvider(this.b).get(BottomViewModel.class)).a().getValue();
            if (value != null) {
                privatePopInfo = value.j();
            } else {
                privatePopInfo = null;
            }
            privateForumPopInfoData.T(privatePopInfo);
            return privateForumPopInfoData;
        }
        return (PrivateForumPopInfoData) invokeV.objValue;
    }

    @Override // com.baidu.tieba.b25
    public PopInfo x1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            eh7 value = ((BottomViewModel) new ViewModelProvider(this.b).get(BottomViewModel.class)).a().getValue();
            if (value != null) {
                return value.g();
            }
            return null;
        }
        return (PopInfo) invokeV.objValue;
    }

    @Override // com.baidu.tieba.b25
    public void G1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            tg7.b(this.b).F(z);
        }
    }

    @Override // com.baidu.tieba.b25
    public boolean M0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return tg7.b(this.b).M0();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.b25
    public IResponseData U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return ((ForumViewModel) new ViewModelProvider(this.b).get(ForumViewModel.class)).a().getValue();
        }
        return (IResponseData) invokeV.objValue;
    }

    @Override // com.baidu.tieba.b25
    public long W1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return tg7.b(this.b).W1();
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.tieba.og7
    public void k(Bundle bundle, ActivityForumBinding binding) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, bundle, binding) == null) {
            Intrinsics.checkNotNullParameter(binding, "binding");
            super.k(bundle, binding);
        }
    }
}
