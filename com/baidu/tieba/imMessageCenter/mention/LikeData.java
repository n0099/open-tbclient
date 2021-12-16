package com.baidu.tieba.imMessageCenter.mention;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.data.GodUserData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import org.json.JSONObject;
import tbclient.User;
/* loaded from: classes12.dex */
public class LikeData implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 1250162253971653314L;
    public transient /* synthetic */ FieldHolder $fh;
    public GodUserData mGodData;
    public String mId;
    public int mIsMyFriend;
    public int mIsVerify;
    public String mName;
    public String mNameShow;
    public String mPortrait;
    public int mUserType;

    public LikeData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mId = "";
        this.mName = "";
        this.mNameShow = "";
        this.mPortrait = "";
        this.mUserType = 0;
        this.mIsVerify = 0;
    }

    public String getId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mId : (String) invokeV.objValue;
    }

    public int getIsMyFriend() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mIsMyFriend : invokeV.intValue;
    }

    public int getIsVerify() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mIsVerify : invokeV.intValue;
    }

    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mName : (String) invokeV.objValue;
    }

    public String getNameShow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mNameShow : (String) invokeV.objValue;
    }

    public String getPortrait() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mPortrait : (String) invokeV.objValue;
    }

    public int getUserType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mUserType : invokeV.intValue;
    }

    public boolean isBigV() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            GodUserData godUserData = this.mGodData;
            return godUserData != null && godUserData.isBigV();
        }
        return invokeV.booleanValue;
    }

    public void parserJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        try {
            this.mId = jSONObject.optString("id");
            this.mUserType = jSONObject.optInt("user_type");
            this.mIsVerify = jSONObject.optInt("is_verify");
            this.mName = jSONObject.optString("name");
            this.mNameShow = jSONObject.optString("name_show");
            this.mPortrait = jSONObject.optString("portrait");
            this.mIsMyFriend = jSONObject.optInt("is_friend");
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }

    public void parserProtoBuf(User user) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, user) == null) || user == null) {
            return;
        }
        try {
            this.mId = String.valueOf(user.id);
            this.mUserType = user.user_type.intValue();
            this.mIsVerify = user.is_verify.intValue();
            this.mName = user.name;
            this.mNameShow = user.name_show;
            this.mPortrait = user.portrait;
            this.mIsMyFriend = user.is_friend.intValue();
            if (user.god_data != null) {
                GodUserData godUserData = new GodUserData();
                this.mGodData = godUserData;
                godUserData.parserProtobuf(user.god_data);
            }
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }
}
