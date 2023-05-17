package com.baidu.tieba.person;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.data.VirtualImageCustomState;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import tbclient.StateInfo;
import tbclient.VirtualImageInfo;
/* loaded from: classes7.dex */
public class ProfileVirtualImageInfo implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ProfileVirtualImageInfo instance;
    public transient /* synthetic */ FieldHolder $fh;
    public int allowCustomize;
    public String dynamicVirtualImageUrl;
    public int imageAgreeCount;
    public int isAllowAgree;
    public boolean isDisplayVirtual;
    public int isSetVirtualImage;
    public boolean netDataRespond;
    public VirtualImageCustomState personalState;
    public int recentIncrAgree;
    public int snapsHootId;
    public List<VirtualImageCustomState> stateList;
    public String virtualBackground;
    public int virtualBackgroundType;
    public String virtualImageUrl;

    public ProfileVirtualImageInfo() {
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

    public static ProfileVirtualImageInfo getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (instance == null) {
                synchronized (ProfileVirtualImageInfo.class) {
                    instance = new ProfileVirtualImageInfo();
                }
            }
            return instance;
        }
        return (ProfileVirtualImageInfo) invokeV.objValue;
    }

    public int getAllowCustomize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.allowCustomize;
        }
        return invokeV.intValue;
    }

    public String getDynamicVirtualImageUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.dynamicVirtualImageUrl;
        }
        return (String) invokeV.objValue;
    }

    public int getImageAgreeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.imageAgreeCount;
        }
        return invokeV.intValue;
    }

    public int getIsAllowAgree() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.isAllowAgree;
        }
        return invokeV.intValue;
    }

    public int getIsSetVirtualImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.isSetVirtualImage;
        }
        return invokeV.intValue;
    }

    public VirtualImageCustomState getPersonalState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.personalState;
        }
        return (VirtualImageCustomState) invokeV.objValue;
    }

    public int getRecentIncrAgree() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.recentIncrAgree;
        }
        return invokeV.intValue;
    }

    public int getSnapsHootId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.snapsHootId;
        }
        return invokeV.intValue;
    }

    public List<VirtualImageCustomState> getStateList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.stateList;
        }
        return (List) invokeV.objValue;
    }

    public String getVirtualBackground() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.virtualBackground;
        }
        return (String) invokeV.objValue;
    }

    public int getVirtualBackgroundType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.virtualBackgroundType;
        }
        return invokeV.intValue;
    }

    public String getVirtualImageUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.virtualImageUrl;
        }
        return (String) invokeV.objValue;
    }

    public boolean isDisplayVirtual() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.isDisplayVirtual;
        }
        return invokeV.booleanValue;
    }

    public boolean isNetDataRespond() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.netDataRespond;
        }
        return invokeV.booleanValue;
    }

    public void parseProto(VirtualImageInfo virtualImageInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, virtualImageInfo) == null) && virtualImageInfo != null) {
            this.isSetVirtualImage = virtualImageInfo.isset_virtual_image.intValue();
            this.virtualImageUrl = virtualImageInfo.virtual_image_url;
            this.dynamicVirtualImageUrl = virtualImageInfo.dynamic_virtual_image_url;
            this.imageAgreeCount = virtualImageInfo.image_agree_count.intValue();
            this.isAllowAgree = virtualImageInfo.is_allow_agree.intValue();
            this.virtualBackgroundType = virtualImageInfo.virtual_background_type.intValue();
            this.virtualBackground = virtualImageInfo.virtual_background;
            this.recentIncrAgree = virtualImageInfo.recent_incr_agree.intValue();
            this.snapsHootId = virtualImageInfo.snapshoot_id.intValue();
            if (virtualImageInfo.personal_state != null) {
                VirtualImageCustomState virtualImageCustomState = new VirtualImageCustomState();
                this.personalState = virtualImageCustomState;
                virtualImageCustomState.parseProto(virtualImageInfo.personal_state);
            } else {
                this.personalState = null;
            }
            boolean z = false;
            if (virtualImageInfo.state_list != null) {
                this.stateList = new ArrayList();
                for (int i = 0; i < virtualImageInfo.state_list.size(); i++) {
                    StateInfo stateInfo = virtualImageInfo.state_list.get(i);
                    if (stateInfo != null) {
                        VirtualImageCustomState virtualImageCustomState2 = new VirtualImageCustomState();
                        virtualImageCustomState2.parseProto(stateInfo);
                        this.stateList.add(virtualImageCustomState2);
                    }
                }
            }
            this.allowCustomize = virtualImageInfo.allow_customize.intValue();
            if (virtualImageInfo.is_display.intValue() == 1) {
                z = true;
            }
            this.isDisplayVirtual = z;
            this.netDataRespond = true;
        }
    }

    public void parseRemoteInfo(ProfileVirtualImageInfo profileVirtualImageInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, profileVirtualImageInfo) == null) {
            synchronized (ProfileVirtualImageInfo.class) {
                instance = profileVirtualImageInfo;
            }
        }
    }
}
