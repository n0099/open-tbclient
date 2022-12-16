package com.baidu.tieba.imMessageCenter.chatgroup.data;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.xg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ChatNewMessage extends OrmObject implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 8724349094898022318L;
    public transient /* synthetic */ FieldHolder $fh;
    public String content;
    public String fromName;
    public String fromUid;
    public String msgId;
    public String msgTime;

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
            }
        }
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

    public long getMsgId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return xg.g(this.msgTime, 0L);
        }
        return invokeV.longValue;
    }

    public void parse(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        this.msgId = jSONObject.optString("msg_id");
        this.fromUid = jSONObject.optString("from_uid");
        this.fromName = jSONObject.optString("from_name");
        this.content = jSONObject.optString("content");
        this.msgTime = jSONObject.optString("msg_time");
    }

    public void setContent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.content = str;
        }
    }

    public void setFromName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.fromName = str;
        }
    }

    public void setFromUid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.fromUid = str;
        }
    }

    public void setMsgId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.msgId = str;
        }
    }

    public void setMsgTime(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.msgTime = str;
        }
    }
}
