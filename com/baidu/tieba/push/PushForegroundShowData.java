package com.baidu.tieba.push;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class PushForegroundShowData implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PUSH_KEY_GAME_TYPE = "game_play";
    public static final String PUSH_KEY_LIVR_TYPE = "live";
    public transient /* synthetic */ FieldHolder $fh;
    public PushExtData extData;
    public String key;
    public PushRemindInfo remindInfo;

    public PushForegroundShowData() {
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

    public PushExtData getExtData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.extData : (PushExtData) invokeV.objValue;
    }

    public String getKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.key : (String) invokeV.objValue;
    }

    public PushRemindInfo getRemindInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.remindInfo : (PushRemindInfo) invokeV.objValue;
    }

    public boolean isGameData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? TextUtils.equals(PUSH_KEY_GAME_TYPE, this.key) : invokeV.booleanValue;
    }

    public boolean isLiveData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? TextUtils.equals("live", this.key) : invokeV.booleanValue;
    }

    public void parseShowData(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jSONObject) == null) {
            this.key = jSONObject.optString("key");
            if (jSONObject.optJSONObject("remind_info") != null) {
                PushRemindInfo pushRemindInfo = new PushRemindInfo();
                pushRemindInfo.parseInfo(jSONObject.optJSONObject("remind_info"));
                this.remindInfo = pushRemindInfo;
            }
            if (jSONObject.optJSONObject("ext_data") != null) {
                PushExtData pushExtData = new PushExtData();
                pushExtData.parseExtData(jSONObject.optJSONObject("ext_data"));
                this.extData = pushExtData;
            }
        }
    }

    public void setExtData(PushExtData pushExtData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, pushExtData) == null) {
            this.extData = pushExtData;
        }
    }

    public void setKey(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.key = str;
        }
    }

    public void setRemindInfo(PushRemindInfo pushRemindInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, pushRemindInfo) == null) {
            this.remindInfo = pushRemindInfo;
        }
    }
}
