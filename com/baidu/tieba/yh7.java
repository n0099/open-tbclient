package com.baidu.tieba;

import android.app.Activity;
import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.FrsSpriteNewUserGuide;
import com.baidu.tbadk.core.data.PrivateForumPopInfoData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.mvc.data.IResponseData;
import com.baidu.tieba.forum.ForumActivity;
import com.baidu.tieba.forum.controller.ForumBackFloatTipController;
import com.baidu.tieba.forum.databinding.ActivityForumBinding;
import com.baidu.tieba.forum.viewmodel.BottomViewModel;
import com.baidu.tieba.forum.viewmodel.ForumViewModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import tbclient.AddBawuPopInfo;
import tbclient.FrsPage.ForumInfo;
import tbclient.FrsPage.FrsSpriteBubble;
import tbclient.FrsPage.PrivateForumTotalInfo;
import tbclient.PopInfo;
import tbclient.PrivatePopInfo;
import tbclient.User;
/* loaded from: classes9.dex */
public final class yh7 extends wh7 implements h25 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final FragmentActivity b;
    public boolean c;
    public boolean d;

    @Override // com.baidu.tieba.h25
    public boolean B1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.h25
    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public yh7(FragmentActivity activity) {
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
        this.c = true;
        this.d = true;
    }

    @Override // com.baidu.tieba.h25
    public FrsSpriteNewUserGuide F0() {
        InterceptResult invokeV;
        FrsSpriteBubble frsSpriteBubble;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            oi7 value = ((BottomViewModel) new ViewModelProvider(this.b).get(BottomViewModel.class)).a().getValue();
            if (value != null) {
                frsSpriteBubble = value.i();
            } else {
                frsSpriteBubble = null;
            }
            return FrsSpriteNewUserGuide.parse(frsSpriteBubble);
        }
        return (FrsSpriteNewUserGuide) invokeV.objValue;
    }

    @Override // com.baidu.tieba.h25
    public PopInfo H1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            oi7 value = ((BottomViewModel) new ViewModelProvider(this.b).get(BottomViewModel.class)).a().getValue();
            if (value != null) {
                return value.f();
            }
            return null;
        }
        return (PopInfo) invokeV.objValue;
    }

    @Override // com.baidu.tieba.h25
    public UserData W1() {
        InterceptResult invokeV;
        User user;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            UserData userData = new UserData();
            oi7 value = ((BottomViewModel) new ViewModelProvider(this.b).get(BottomViewModel.class)).a().getValue();
            if (value != null) {
                user = value.j();
            } else {
                user = null;
            }
            userData.parserProtobuf(user);
            return userData;
        }
        return (UserData) invokeV.objValue;
    }

    @Override // com.baidu.tieba.h25
    public ForumData a1() {
        InterceptResult invokeV;
        ForumInfo forumInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            ForumData forumData = new ForumData();
            oi7 value = ((BottomViewModel) new ViewModelProvider(this.b).get(BottomViewModel.class)).a().getValue();
            if (value != null) {
                forumInfo = value.d();
            } else {
                forumInfo = null;
            }
            forumData.parserProtobuf(forumInfo);
            return forumData;
        }
        return (ForumData) invokeV.objValue;
    }

    @Override // com.baidu.tieba.wh7
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.m();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921825, Boolean.TRUE));
            if (this.b.isFinishing()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921827, Boolean.TRUE));
            }
        }
    }

    @Override // com.baidu.tieba.h25
    public AddBawuPopInfo m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            oi7 value = ((BottomViewModel) new ViewModelProvider(this.b).get(BottomViewModel.class)).a().getValue();
            if (value != null) {
                return value.a();
            }
            return null;
        }
        return (AddBawuPopInfo) invokeV.objValue;
    }

    @Override // com.baidu.tieba.h25
    public sy4 n1() {
        InterceptResult invokeV;
        PrivateForumTotalInfo privateForumTotalInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            sy4 sy4Var = new sy4();
            oi7 value = ((BottomViewModel) new ViewModelProvider(this.b).get(BottomViewModel.class)).a().getValue();
            if (value != null) {
                privateForumTotalInfo = value.g();
            } else {
                privateForumTotalInfo = null;
            }
            sy4Var.d(privateForumTotalInfo);
            return sy4Var;
        }
        return (sy4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.h25
    public PrivateForumPopInfoData r1() {
        InterceptResult invokeV;
        PrivatePopInfo privatePopInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            PrivateForumPopInfoData privateForumPopInfoData = new PrivateForumPopInfoData();
            oi7 value = ((BottomViewModel) new ViewModelProvider(this.b).get(BottomViewModel.class)).a().getValue();
            if (value != null) {
                privatePopInfo = value.h();
            } else {
                privatePopInfo = null;
            }
            privateForumPopInfoData.T(privatePopInfo);
            return privateForumPopInfoData;
        }
        return (PrivateForumPopInfoData) invokeV.objValue;
    }

    @Override // com.baidu.tieba.h25
    public boolean I0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return bi7.d(this.b).s();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.h25
    public boolean R0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return bi7.b(this.b).R0();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.h25
    public IResponseData W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return ((ForumViewModel) new ViewModelProvider(this.b).get(ForumViewModel.class)).a().getValue();
        }
        return (IResponseData) invokeV.objValue;
    }

    @Override // com.baidu.tieba.h25
    public boolean g1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.d;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.h25
    public long i2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return bi7.b(this.b).i2();
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.tieba.h25
    public void s0() {
        ForumActivity forumActivity;
        ForumBackFloatTipController forumBackFloatTipController;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            FragmentActivity fragmentActivity = this.b;
            if (fragmentActivity instanceof ForumActivity) {
                forumActivity = (ForumActivity) fragmentActivity;
            } else {
                forumActivity = null;
            }
            if (forumActivity != null && (forumBackFloatTipController = (ForumBackFloatTipController) forumActivity.j2(Reflection.getOrCreateKotlinClass(ForumBackFloatTipController.class))) != null) {
                forumBackFloatTipController.s0();
            }
        }
    }

    @Override // com.baidu.tieba.h25
    public boolean y1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.c;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.h25
    public void I1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.c = z;
        }
    }

    @Override // com.baidu.tieba.h25
    public void S1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            bi7.b(this.b).I(z);
        }
    }

    @Override // com.baidu.tieba.h25
    public boolean g0(Activity activity) {
        InterceptResult invokeL;
        ForumActivity forumActivity;
        ForumBackFloatTipController e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, activity)) == null) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            if (activity instanceof ForumActivity) {
                forumActivity = (ForumActivity) activity;
            } else {
                forumActivity = null;
            }
            if (forumActivity != null && (e = bi7.e(forumActivity)) != null) {
                return e.w(activity);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.h25
    public void q1(Activity activity) {
        ForumActivity forumActivity;
        ForumBackFloatTipController e;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, activity) == null) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            if (activity instanceof ForumActivity) {
                forumActivity = (ForumActivity) activity;
            } else {
                forumActivity = null;
            }
            if (forumActivity != null && (e = bi7.e(forumActivity)) != null) {
                e.q1(activity);
            }
        }
    }

    @Override // com.baidu.tieba.h25
    public void u1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.d = z;
        }
    }

    @Override // com.baidu.tieba.wh7
    public void k(Bundle bundle, ActivityForumBinding binding) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, bundle, binding) == null) {
            Intrinsics.checkNotNullParameter(binding, "binding");
            super.k(bundle, binding);
        }
    }
}
