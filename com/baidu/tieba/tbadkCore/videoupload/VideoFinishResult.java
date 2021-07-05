package com.baidu.tieba.tbadkCore.videoupload;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class VideoFinishResult implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_ERROR = "error";
    public static final String KEY_ERROR_MSG = "errmsg";
    public static final String KEY_ERROR_NO = "errno";
    public static final String KEY_ERROR_USER_MSG = "usermsg";
    public static final String KEY_VIDEO_MD5 = "video_md5";
    public static final String KEY_VIDEO_URL = "video_url";
    public static final long serialVersionUID = 6275774083063164456L;
    public transient /* synthetic */ FieldHolder $fh;
    public String errorMessage;
    public int errorNo;
    public String userMessage;
    public String videoMd5;
    public String videoUrl;

    public VideoFinishResult() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public String getErrorMessage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.errorMessage : (String) invokeV.objValue;
    }

    public int getErrorNo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.errorNo : invokeV.intValue;
    }

    public String getUserMessage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.userMessage : (String) invokeV.objValue;
    }

    public String getVideoMd5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.videoMd5 : (String) invokeV.objValue;
    }

    public String getVideoUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.videoUrl : (String) invokeV.objValue;
    }

    public boolean isSuccess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (this.errorNo != 0 || StringUtils.isNull(this.videoMd5) || StringUtils.isNull(this.videoUrl)) ? false : true : invokeV.booleanValue;
    }

    public void parseJson(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject optJSONObject = jSONObject.optJSONObject("error");
            if (optJSONObject != null) {
                this.errorNo = optJSONObject.optInt("errno");
                this.errorMessage = optJSONObject.optString("errmsg");
                this.userMessage = optJSONObject.optString(KEY_ERROR_USER_MSG);
            }
            this.videoMd5 = jSONObject.optString(KEY_VIDEO_MD5);
            this.videoUrl = jSONObject.optString("video_url");
        } catch (JSONException unused) {
        }
        if ((StringUtils.isNull(this.videoMd5) || StringUtils.isNull(this.videoUrl)) && this.errorNo == 0) {
            this.errorNo = -3;
            this.errorMessage = TbErrInfo.getErrMsg(-3);
            this.userMessage = TbErrInfo.getErrMsg(-3);
        }
    }

    public void setErrorMessage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.errorMessage = str;
        }
    }

    public void setErrorNo(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.errorNo = i2;
        }
    }

    public void setUserMessage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.userMessage = str;
        }
    }

    public void setVideoMd5(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.videoMd5 = str;
        }
    }

    public void setVideoUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.videoUrl = str;
        }
    }
}
