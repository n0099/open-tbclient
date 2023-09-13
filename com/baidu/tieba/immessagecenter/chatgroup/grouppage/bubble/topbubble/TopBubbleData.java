package com.baidu.tieba.immessagecenter.chatgroup.grouppage.bubble.topbubble;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
/* loaded from: classes6.dex */
public class TopBubbleData extends OrmObject implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ACTIVITY = "activity";
    public static final int ACTIVITY_OVER = 2;
    public static final int ACTIVITY_UNDERWAY = 1;
    public static final int ACTIVITY_UNPLAYED = 0;
    public static final int ARROW_STATUS = 2;
    public static final int DEFAULT_STATUS = 0;
    public static final String EXCELLENT = "excellent_msg";
    public static final String NOTICE = "notice";
    public static final int OVERLAY_STATUS = 3;
    public static final int UNREAD_STATUS = 1;
    public static final long serialVersionUID = 1710946903693581029L;
    public transient /* synthetic */ FieldHolder $fh;
    public long activityID;
    public int activityStatus;
    @SerializedName("content")
    public String content;
    public int excellentMsgOperation;
    @SerializedName("icon")
    public String icon;
    @SerializedName("jump_to")
    public String jumpTo;
    @SerializedName("msg_id")
    public String msgId;
    @SerializedName("msg_key")
    public String msgKey;
    @SerializedName("msg_min_version")
    public String msgMinVersion;
    @SerializedName("msg_type")
    public String msgType;
    @SerializedName("top_bubble_type")
    public String pinnedType;
    public int statusType;
    @SerializedName("sub_content")
    public String subContent;
    @SerializedName("username")
    public String userName;
    @SerializedName("version_key")
    public String versionKey;

    public TopBubbleData() {
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
        this.activityStatus = 0;
        this.statusType = 0;
    }

    public long getActivityID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.activityID;
        }
        return invokeV.longValue;
    }

    public int getActivityStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.activityStatus;
        }
        return invokeV.intValue;
    }

    public String getContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.content;
        }
        return (String) invokeV.objValue;
    }

    public String getIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.icon;
        }
        return (String) invokeV.objValue;
    }

    public String getJumpTo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.jumpTo;
        }
        return (String) invokeV.objValue;
    }

    public long getMsgId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return JavaTypesHelper.toLong(this.msgId, 0L);
        }
        return invokeV.longValue;
    }

    public String getMsgKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.msgKey;
        }
        return (String) invokeV.objValue;
    }

    public String getMsgMinVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.msgMinVersion;
        }
        return (String) invokeV.objValue;
    }

    public String getMsgType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.msgType;
        }
        return (String) invokeV.objValue;
    }

    public String getPinnedType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.pinnedType;
        }
        return (String) invokeV.objValue;
    }

    public int getStatusType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.statusType;
        }
        return invokeV.intValue;
    }

    public String getSubContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.subContent;
        }
        return (String) invokeV.objValue;
    }

    public String getUserName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.userName;
        }
        return (String) invokeV.objValue;
    }

    public String getVersionKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.versionKey;
        }
        return (String) invokeV.objValue;
    }

    public boolean isActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return "activity".equals(this.pinnedType);
        }
        return invokeV.booleanValue;
    }

    public boolean isExcellent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return EXCELLENT.equals(this.pinnedType);
        }
        return invokeV.booleanValue;
    }

    public boolean isNotice() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return "notice".equals(this.pinnedType);
        }
        return invokeV.booleanValue;
    }

    public boolean isSetExcellent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.excellentMsgOperation == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void setActivityID(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048594, this, j) == null) {
            this.activityID = j;
        }
    }

    public void setActivityStatus(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            this.activityStatus = i;
        }
    }

    public void setContent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.content = str;
        }
    }

    public void setExcellentMsgOperation(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
            this.excellentMsgOperation = i;
        }
    }

    public void setIcon(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            this.icon = str;
        }
    }

    public void setJumpTo(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            this.jumpTo = str;
        }
    }

    public void setMsgKey(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            this.msgKey = str;
        }
    }

    public void setMsgMinVersion(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            this.msgMinVersion = str;
        }
    }

    public void setMsgType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
            this.msgType = str;
        }
    }

    public void setPinnedType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, str) == null) {
            this.pinnedType = str;
        }
    }

    public void setStatusType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i) == null) {
            this.statusType = i;
        }
    }

    public void setUserName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, str) == null) {
            this.userName = str;
        }
    }

    public void setVersionKey(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, str) == null) {
            this.versionKey = str;
        }
    }
}
