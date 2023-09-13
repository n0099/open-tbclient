package com.baidu.tieba.immessagecenter.chatgroup.data;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ChatNewMessage extends OrmObject implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEFAULT_TYPE = "";
    public static final String DEFAULT_TYPE_CONTENT = "";
    public static final String TYPE_ACTIVITY_MSG = "activity";
    public static final String TYPE_ACTIVITY_MSG_CONTENT = "[活动中]";
    public static final String TYPE_AT_ALL_MSG = "at_all";
    public static final String TYPE_AT_MSG = "at_single";
    public static final String TYPE_AT_MSG_CONTENT = "[有人@我]";
    public static final String TYPE_EMOJI_MSG = "reaction";
    public static final String TYPE_EMOJI_MSG_CONTENT = "[表情回复]";
    public static final String TYPE_NOTICE_MSG = "notice";
    public static final String TYPE_NOTICE_MSG_CONTENT = "[公告]";
    public static final long serialVersionUID = 8724349094898022318L;
    public transient /* synthetic */ FieldHolder $fh;
    public String content;
    public String fromName;
    public String fromUid;
    public long lastExitChatRoomTime;
    public String msgId;
    public String msgTime;
    public String specialMsg;
    public String specialType;

    public ChatNewMessage() {
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
        this.specialMsg = "";
        this.specialType = "";
    }

    public String getContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.content;
        }
        return (String) invokeV.objValue;
    }

    public String getFromName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.fromName;
        }
        return (String) invokeV.objValue;
    }

    public String getFromUid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.fromUid;
        }
        return (String) invokeV.objValue;
    }

    public long getLastExitChatRoomTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.lastExitChatRoomTime;
        }
        return invokeV.longValue;
    }

    public long getMsgId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (TextUtils.isEmpty(this.msgId)) {
                return 0L;
            }
            return Long.valueOf(this.msgId).longValue();
        }
        return invokeV.longValue;
    }

    public long getMsgTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return JavaTypesHelper.toLong(this.msgTime, 0L);
        }
        return invokeV.longValue;
    }

    public String getSpecialMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.specialMsg;
        }
        return (String) invokeV.objValue;
    }

    public String getSpecialType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.specialType;
        }
        return (String) invokeV.objValue;
    }

    public void resetSpecialMsg() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            setSpecialType("");
            setSpecialMsg("");
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int getSpecialMsgPriority(String str) {
        InterceptResult invokeL;
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            switch (str.hashCode()) {
                case -1655966961:
                    if (str.equals("activity")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case -1415649836:
                    if (str.equals(TYPE_AT_MSG)) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case -1407884395:
                    if (str.equals(TYPE_AT_ALL_MSG)) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case -1039690024:
                    if (str.equals("notice")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case -867509719:
                    if (str.equals(TYPE_EMOJI_MSG)) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            if (c != 0) {
                if (c != 1 && c != 2) {
                    if (c != 3) {
                        if (c != 4) {
                            return 0;
                        }
                        return 1;
                    }
                    return 2;
                }
                return 3;
            }
            return 4;
        }
        return invokeL.intValue;
    }

    public void parse(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        this.msgId = jSONObject.optString("msg_id");
        this.fromUid = jSONObject.optString("from_uid");
        this.fromName = jSONObject.optString("from_name");
        this.content = jSONObject.optString("content");
        this.msgTime = jSONObject.optString("msg_time");
        this.specialMsg = jSONObject.optString("special_msg");
        this.specialType = jSONObject.optString("special_msg_type");
    }

    public void setContent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.content = str;
        }
    }

    public void setFromName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.fromName = str;
        }
    }

    public void setFromUid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.fromUid = str;
        }
    }

    public void setLastExitChatRoomTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048589, this, j) == null) {
            this.lastExitChatRoomTime = j;
        }
    }

    public void setMsgId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.msgId = str;
        }
    }

    public void setMsgTime(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.msgTime = str;
        }
    }

    public void setSpecialMsg(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.specialMsg = str;
        }
    }

    public void setSpecialType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.specialType = str;
        }
    }
}
