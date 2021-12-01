package com.baidu.tieba.person.data;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.List;
import tbclient.Profile.ForumGodDetailInfo;
import tbclient.Profile.GodDetailInfo;
import tbclient.Profile.UserGodInfo;
/* loaded from: classes11.dex */
public class PersonUserGodInfo implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int USER_GOD_TYPE_MULTI = 1;
    public static final int USER_GOD_TYPE_SINGLE = 2;
    public static final long serialVersionUID = -1538103146882985197L;
    public transient /* synthetic */ FieldHolder $fh;
    public List<ForumGodDetailInfo> forumGodList;
    public GodDetailInfo godDetailInfo;
    public int godType;
    public int sex;

    public PersonUserGodInfo() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public List<ForumGodDetailInfo> getForumGodList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.forumGodList : (List) invokeV.objValue;
    }

    public int getGodType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.godType : invokeV.intValue;
    }

    public int getSex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.sex : invokeV.intValue;
    }

    public GodDetailInfo getgodDetailInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.godDetailInfo : (GodDetailInfo) invokeV.objValue;
    }

    public void parserProtobuf(UserGodInfo userGodInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, userGodInfo) == null) || userGodInfo == null) {
            return;
        }
        this.godType = userGodInfo.god_type.intValue();
        this.godDetailInfo = userGodInfo.god_info;
        this.forumGodList = userGodInfo.forum_god_list;
        this.sex = userGodInfo.sex.intValue();
    }

    public void setSex(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.sex = i2;
        }
    }
}
