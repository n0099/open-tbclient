package com.baidu.tieba.themeCenter.background;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import tbclient.ThemeBgProp;
/* loaded from: classes6.dex */
public class DressItemData extends OrmObject implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int activityFinish;
    public String activityUrl;
    public int dailyPrevilegeStatus;
    public String description;
    public String dynamicUrl;
    public String dynamicUrlSmall;
    public String exampleImgUrl;
    public int freeUserLevel;
    public int inUse;
    public String permissionImgUrl;
    public int propsId;
    public String propsStateImg;
    public String title;

    public DressItemData() {
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
        this.dailyPrevilegeStatus = 0;
        this.inUse = 0;
    }

    public int getActivityFinish() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.activityFinish : invokeV.intValue;
    }

    public String getActivityUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.activityUrl : (String) invokeV.objValue;
    }

    public int getDailyPrevilegeStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.dailyPrevilegeStatus : invokeV.intValue;
    }

    public String getDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.description : (String) invokeV.objValue;
    }

    public String getDynamicUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.dynamicUrl : (String) invokeV.objValue;
    }

    public String getDynamicUrlSmall() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "" : (String) invokeV.objValue;
    }

    public String getExampleImgUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.exampleImgUrl : (String) invokeV.objValue;
    }

    public int getFreeUserLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.freeUserLevel : invokeV.intValue;
    }

    public boolean getInUse() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.inUse == 1 : invokeV.booleanValue;
    }

    public boolean getIsActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? !StringUtils.isNull(this.activityUrl) : invokeV.booleanValue;
    }

    public String getPermissionImgUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.permissionImgUrl : (String) invokeV.objValue;
    }

    public int getPropsId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.propsId : invokeV.intValue;
    }

    public String getPropsStateImg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.propsStateImg : (String) invokeV.objValue;
    }

    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.title : (String) invokeV.objValue;
    }

    public boolean isDefault() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.propsId == 0 : invokeV.booleanValue;
    }

    public boolean isPropIdEven() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.propsId % 2 == 0 : invokeV.booleanValue;
    }

    public void setActivityFinish(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.activityFinish = i;
        }
    }

    public void setActivityUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.activityUrl = str;
        }
    }

    public void setDailyPrevilegeStatus(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            this.dailyPrevilegeStatus = i;
        }
    }

    public void setDescription(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.description = str;
        }
    }

    public void setDynamicUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.dynamicUrl = str;
        }
    }

    public void setDynamicUrlSmall(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
        }
    }

    public void setExampleImgUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            this.exampleImgUrl = str;
        }
    }

    public void setFreeUserLevel(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i) == null) {
            this.freeUserLevel = i;
        }
    }

    public void setInUse(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            this.inUse = z ? 1 : 0;
        }
    }

    public void setPermissionImgUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            this.permissionImgUrl = str;
        }
    }

    public void setPropsId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i) == null) {
            this.propsId = i;
        }
    }

    public void setPropsStateImg(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, str) == null) {
            this.propsStateImg = str;
        }
    }

    public void setTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, str) == null) {
            this.title = str;
        }
    }

    public DressItemData(ThemeBgProp themeBgProp) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {themeBgProp};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.dailyPrevilegeStatus = 0;
        if (themeBgProp == null) {
            return;
        }
        this.title = themeBgProp.title;
        this.description = themeBgProp.description;
        this.exampleImgUrl = themeBgProp.example_url;
        this.propsId = themeBgProp.props_id.intValue();
        this.inUse = themeBgProp.in_use.intValue();
        this.freeUserLevel = themeBgProp.free_user_level.intValue();
        this.permissionImgUrl = themeBgProp.permission;
        this.propsStateImg = themeBgProp.props_state_img;
        this.activityUrl = themeBgProp.activity_url;
        this.activityFinish = themeBgProp.is_finished.intValue();
        this.dynamicUrl = themeBgProp.dynamic_url;
        this.dynamicUrlSmall = themeBgProp.dynamic_url_small;
    }
}
