package com.baidu.tieba.immessagecenter.chatgroup.data;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ChatRoomInfo extends OrmObject implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -1620134728531709405L;
    public transient /* synthetic */ FieldHolder $fh;
    public AtInfo atInfo;
    public String avatar;
    public long deleteTime;
    public String forumId;
    public String forumName;
    public int groupId;
    public boolean isLocationScrolled;
    public int isShow;
    public int isSubscribe;
    public String jumpUrl;
    public ChatNewMessage mNewMessage;
    public String name;
    public int noDisturb;
    public long roomId;
    public String singleListHotText;
    public long topTime;
    public int unreadNum;

    public ChatRoomInfo() {
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

    public AtInfo getAtInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.atInfo;
        }
        return (AtInfo) invokeV.objValue;
    }

    public String getAvatar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.avatar;
        }
        return (String) invokeV.objValue;
    }

    public long getDeleteTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.deleteTime;
        }
        return invokeV.longValue;
    }

    public String getForumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.forumId;
        }
        return (String) invokeV.objValue;
    }

    public String getForumName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (TextUtils.isEmpty(this.forumName)) {
                return "";
            }
            return this.forumName;
        }
        return (String) invokeV.objValue;
    }

    public int getGroupId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.groupId;
        }
        return invokeV.intValue;
    }

    public int getIsShow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.isShow;
        }
        return invokeV.intValue;
    }

    public String getJumpUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.jumpUrl;
        }
        return (String) invokeV.objValue;
    }

    public long getLatestMsgId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            ChatNewMessage chatNewMessage = this.mNewMessage;
            if (chatNewMessage != null) {
                return chatNewMessage.getMsgId();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.name;
        }
        return (String) invokeV.objValue;
    }

    public ChatNewMessage getNewMessage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.mNewMessage;
        }
        return (ChatNewMessage) invokeV.objValue;
    }

    public long getRoomId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.roomId;
        }
        return invokeV.longValue;
    }

    public String getSingleListHotText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.singleListHotText;
        }
        return (String) invokeV.objValue;
    }

    public long getTimestamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            ChatNewMessage chatNewMessage = this.mNewMessage;
            if (chatNewMessage != null) {
                return chatNewMessage.getMsgTime();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public long getTopTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.topTime;
        }
        return invokeV.longValue;
    }

    public int getUnreadNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.unreadNum;
        }
        return invokeV.intValue;
    }

    public boolean isLocationScrolled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.isLocationScrolled;
        }
        return invokeV.booleanValue;
    }

    public boolean isNoDisturb() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.noDisturb == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isSubscribe() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.isSubscribe == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void parse(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048595, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        this.roomId = jSONObject.optLong("room_id");
        this.isShow = jSONObject.optInt("is_show");
        this.jumpUrl = jSONObject.optString(BigdayActivityConfig.JUMP_URL);
        JSONObject optJSONObject = jSONObject.optJSONObject("room_info");
        if (optJSONObject != null) {
            this.forumId = optJSONObject.optString("forum_id");
            this.forumName = optJSONObject.optString("forum_name");
            this.groupId = optJSONObject.optInt("group_id");
            this.name = optJSONObject.optString("name");
            this.avatar = optJSONObject.optString("avatar");
            this.unreadNum = optJSONObject.optInt("unread_num");
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("msg_info");
        if (optJSONObject2 != null) {
            ChatNewMessage chatNewMessage = new ChatNewMessage();
            this.mNewMessage = chatNewMessage;
            chatNewMessage.parse(optJSONObject2);
        }
        this.atInfo = AtInfo.parse(jSONObject.optJSONObject("at_info"));
    }

    public void setAtInfo(AtInfo atInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, atInfo) == null) {
            this.atInfo = atInfo;
        }
    }

    public void setAvatar(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            this.avatar = str;
        }
    }

    public void setDeleteTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048598, this, j) == null) {
            this.deleteTime = j;
        }
    }

    public void setForumId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            this.forumId = str;
        }
    }

    public void setForumName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            this.forumName = str;
        }
    }

    public void setIsShow(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i) == null) {
            this.isShow = i;
        }
    }

    public void setIsSubscribe(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i) == null) {
            this.isSubscribe = i;
        }
    }

    public void setJumpUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, str) == null) {
            this.jumpUrl = str;
        }
    }

    public void setLocationScrolled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            this.isLocationScrolled = z;
        }
    }

    public void setName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, str) == null) {
            this.name = str;
        }
    }

    public void setNewMessage(ChatNewMessage chatNewMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, chatNewMessage) == null) {
            this.mNewMessage = chatNewMessage;
        }
    }

    public void setNoDisturb(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i) == null) {
            this.noDisturb = i;
        }
    }

    public void setRoomId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048608, this, j) == null) {
            this.roomId = j;
        }
    }

    public void setSingleListHotText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, str) == null) {
            this.singleListHotText = str;
        }
    }

    public void setTopTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048610, this, j) == null) {
            this.topTime = j;
        }
    }

    public void setUnreadNum(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048611, this, i) == null) {
            this.unreadNum = i;
        }
    }

    public JSONObject toJSONObject() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("room_id", this.roomId);
                jSONObject.put("is_show", this.isShow);
                jSONObject.put(BigdayActivityConfig.JUMP_URL, this.jumpUrl);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("forum_id", this.forumId);
                jSONObject2.put("forum_name", this.forumName);
                jSONObject2.put("group_id", this.groupId);
                jSONObject2.put("name", this.name);
                jSONObject2.put("avatar", this.avatar);
                jSONObject2.put("unread_num", this.unreadNum);
                jSONObject.put("room_info", jSONObject2);
                if (this.mNewMessage != null) {
                    jSONObject.put("msg_info", this.mNewMessage.toJSONObject());
                }
                if (this.atInfo != null) {
                    jSONObject.put("at_info", this.atInfo.toJSONObject());
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
