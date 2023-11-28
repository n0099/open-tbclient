package com.baidu.tieba.push;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\u0002\u0010\u000bJ\t\u0010\u0011\u001a\u00020\u0003HÂ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\u0007HÆ\u0003J?\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\u0006\u0010\u0002\u001a\u00020\u0017J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001R\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0002\u001a\u00020\u00038\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u001c"}, d2 = {"Lcom/baidu/tieba/push/PushSceneConfig;", "Ljava/io/Serializable;", "isNewUser", "", "h5DialogUrl", "", "scenes", "", "Lcom/baidu/tieba/push/PushSceneItem;", "groups", "Lcom/baidu/tieba/push/PushSceneGroup;", "(ILjava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getGroups", "()Ljava/util/List;", "getH5DialogUrl", "()Ljava/lang/String;", "getScenes", "component1", "component2", "component3", "component4", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "equals", "", "other", "", "hashCode", "toString", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class PushSceneConfig implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @SerializedName("group_config")
    public final List<PushSceneGroup> groups;
    @SerializedName("pop_url")
    public final String h5DialogUrl;
    @SerializedName(MainTabActivityConfig.IS_NEW_USER)
    public final int isNewUser;
    @SerializedName("scene")
    public final List<PushSceneItem> scenes;

    private final int component1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) ? this.isNewUser : invokeV.intValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.push.PushSceneConfig */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PushSceneConfig copy$default(PushSceneConfig pushSceneConfig, int i, String str, List list, List list2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = pushSceneConfig.isNewUser;
        }
        if ((i2 & 2) != 0) {
            str = pushSceneConfig.h5DialogUrl;
        }
        if ((i2 & 4) != 0) {
            list = pushSceneConfig.scenes;
        }
        if ((i2 & 8) != 0) {
            list2 = pushSceneConfig.groups;
        }
        return pushSceneConfig.copy(i, str, list, list2);
    }

    public final String component2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.h5DialogUrl : (String) invokeV.objValue;
    }

    public final List<PushSceneItem> component3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.scenes : (List) invokeV.objValue;
    }

    public final List<PushSceneGroup> component4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.groups : (List) invokeV.objValue;
    }

    public final PushSceneConfig copy(int i, String str, List<PushSceneItem> scenes, List<PushSceneGroup> groups) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), str, scenes, groups})) == null) {
            Intrinsics.checkNotNullParameter(scenes, "scenes");
            Intrinsics.checkNotNullParameter(groups, "groups");
            return new PushSceneConfig(i, str, scenes, groups);
        }
        return (PushSceneConfig) invokeCommon.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof PushSceneConfig) {
                PushSceneConfig pushSceneConfig = (PushSceneConfig) obj;
                return this.isNewUser == pushSceneConfig.isNewUser && Intrinsics.areEqual(this.h5DialogUrl, pushSceneConfig.h5DialogUrl) && Intrinsics.areEqual(this.scenes, pushSceneConfig.scenes) && Intrinsics.areEqual(this.groups, pushSceneConfig.groups);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            int i = this.isNewUser * 31;
            String str = this.h5DialogUrl;
            return ((((i + (str == null ? 0 : str.hashCode())) * 31) + this.scenes.hashCode()) * 31) + this.groups.hashCode();
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return "PushSceneConfig(isNewUser=" + this.isNewUser + ", h5DialogUrl=" + this.h5DialogUrl + ", scenes=" + this.scenes + ", groups=" + this.groups + ')';
        }
        return (String) invokeV.objValue;
    }

    public PushSceneConfig(int i, String str, List<PushSceneItem> scenes, List<PushSceneGroup> groups) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), str, scenes, groups};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(scenes, "scenes");
        Intrinsics.checkNotNullParameter(groups, "groups");
        this.isNewUser = i;
        this.h5DialogUrl = str;
        this.scenes = scenes;
        this.groups = groups;
    }

    public final List<PushSceneGroup> getGroups() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.groups;
        }
        return (List) invokeV.objValue;
    }

    public final String getH5DialogUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.h5DialogUrl;
        }
        return (String) invokeV.objValue;
    }

    public final List<PushSceneItem> getScenes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.scenes;
        }
        return (List) invokeV.objValue;
    }

    public final boolean isNewUser() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.isNewUser == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
