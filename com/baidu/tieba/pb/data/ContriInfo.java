package com.baidu.tieba.pb.data;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.wi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class ContriInfo implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String afterMsg;
    public String colorMsg;
    public String mPreColorMsg;
    public String mToastBackImage;

    public ContriInfo() {
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

    public String getAfterMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.afterMsg;
        }
        return (String) invokeV.objValue;
    }

    public String getColorMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.colorMsg;
        }
        return (String) invokeV.objValue;
    }

    public String getPreColorMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mPreColorMsg;
        }
        return (String) invokeV.objValue;
    }

    public String getToastBackImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mToastBackImage;
        }
        return (String) invokeV.objValue;
    }

    public boolean isShowToast() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (!wi.isEmpty(this.colorMsg) && !wi.isEmpty(this.afterMsg)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void parseJson(JSONObject jSONObject) {
        int indexOf;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        this.colorMsg = jSONObject.optString("color_msg");
        String optString = jSONObject.optString("after_msg");
        this.afterMsg = optString;
        if (!wi.isEmpty(optString) && (indexOf = this.afterMsg.indexOf("，")) >= 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.afterMsg.substring(0, indexOf));
            sb.append("\n");
            String str = this.afterMsg;
            sb.append(str.substring(indexOf + 1, str.length()));
            this.afterMsg = sb.toString();
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("toast_config");
        if (optJSONArray != null) {
            try {
                if (optJSONArray.getJSONObject(0) != null) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(0);
                    this.mPreColorMsg = jSONObject2.optString("pre_color_msg");
                    this.mToastBackImage = jSONObject2.optString("toast_back_image");
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void setAfterMsg(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.afterMsg = str;
        }
    }

    public void setColorMsg(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.colorMsg = str;
        }
    }
}
