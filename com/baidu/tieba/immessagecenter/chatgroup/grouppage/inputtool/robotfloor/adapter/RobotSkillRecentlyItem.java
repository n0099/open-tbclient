package com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.robotfloor.adapter;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.vc8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
/* loaded from: classes6.dex */
public class RobotSkillRecentlyItem extends vc8 implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 5531600590149259914L;
    public transient /* synthetic */ FieldHolder $fh;
    public String avatar;
    public String botName;
    public int funcType;
    public long mForumId;
    public long mRoomId;
    public String skillDesc;
    public int skillId;
    public String skillName;
    public String uk;

    @Override // com.baidu.tieba.vc8
    public int getViewType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return 6;
        }
        return invokeV.intValue;
    }

    public RobotSkillRecentlyItem(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4, @NonNull String str5, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3, str4, str5, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.skillName = str;
        this.skillDesc = str2;
        this.botName = str3;
        this.avatar = str4;
        this.uk = str5;
        this.skillId = i;
        this.funcType = i2;
    }

    @NonNull
    public String getAvatar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (TextUtils.isEmpty(this.avatar)) {
                return "";
            }
            return this.avatar;
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public String getBotName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (TextUtils.isEmpty(this.botName)) {
                return "";
            }
            return this.botName;
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public String getSkillDesc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (TextUtils.isEmpty(this.skillDesc)) {
                return "";
            }
            return this.skillDesc;
        }
        return (String) invokeV.objValue;
    }

    public int getSkillId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.skillId;
        }
        return invokeV.intValue;
    }

    @NonNull
    public String getSkillName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (TextUtils.isEmpty(this.skillName)) {
                return "";
            }
            return this.skillName;
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public String getUk() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (TextUtils.isEmpty(this.uk)) {
                return "";
            }
            return this.uk;
        }
        return (String) invokeV.objValue;
    }

    public long getmForumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.mForumId;
        }
        return invokeV.longValue;
    }

    public long getmRoomId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.mRoomId;
        }
        return invokeV.longValue;
    }

    public boolean isFuncJump() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.funcType == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void setRoomDetailInfo(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            this.mRoomId = j;
            this.mForumId = j2;
        }
    }
}
