package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.Personalized.CardForum;
import tbclient.Personalized.PersonalForum;
/* loaded from: classes4.dex */
public class l27 extends v26 implements d36 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CardForum e;

    public l27() {
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

    public static boolean n(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) ? i == 1 : invokeI.booleanValue;
    }

    @Override // com.baidu.tieba.d36
    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.showTopDivider = z;
        }
    }

    @Override // com.baidu.tieba.d36
    public int getPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            CardForum cardForum = this.e;
            if (cardForum != null) {
                return cardForum.position.intValue();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.d36
    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? ListUtils.getCount(getDataList()) > 0 : invokeV.booleanValue;
    }

    public void s(CardForum cardForum) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, cardForum) == null) || cardForum == null) {
            return;
        }
        this.e = cardForum;
        this.mGroupTitle = cardForum.card_title;
        if (cardForum.position != null) {
            l(h() + cardForum.position.intValue());
        } else {
            l(h() + 0);
        }
        if (ListUtils.getCount(cardForum.forum_list) > 0) {
            for (PersonalForum personalForum : cardForum.forum_list) {
                if (personalForum != null && !TextUtils.isEmpty(personalForum.forum_name) && personalForum.forum_id.longValue() > 0) {
                    u26 u26Var = new u26();
                    u26Var.b = personalForum.avatar;
                    u26Var.c = personalForum.forum_name;
                    u26Var.d = dh.e("" + personalForum.forum_id, -1);
                    u26Var.e = personalForum.is_like.intValue() == 1;
                    c(u26Var);
                }
            }
        }
    }

    @Override // com.baidu.tieba.d36
    public void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.showBottomDivider = z;
        }
    }
}
