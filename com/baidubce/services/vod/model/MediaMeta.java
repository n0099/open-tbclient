package com.baidubce.services.vod.model;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class MediaMeta {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Long durationInSeconds;
    public Long sizeInBytes;
    public Long sourceSizeInBytes;

    public MediaMeta() {
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

    public static MediaMeta formatFromJson(JSONObject jSONObject) throws JSONException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            MediaMeta mediaMeta = new MediaMeta();
            mediaMeta.setSourceSizeInBytes(Long.valueOf(jSONObject.optLong("sourceSizeInBytes")));
            mediaMeta.setSizeInBytes(Long.valueOf(jSONObject.optLong("sizeInBytes")));
            mediaMeta.setDurationInSeconds(Long.valueOf(jSONObject.optLong("durationInSeconds")));
            return mediaMeta;
        }
        return (MediaMeta) invokeL.objValue;
    }

    public Long getDurationInSeconds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.durationInSeconds : (Long) invokeV.objValue;
    }

    public Long getSizeInBytes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.sizeInBytes : (Long) invokeV.objValue;
    }

    public Long getSourceSizeInBytes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.sourceSizeInBytes : (Long) invokeV.objValue;
    }

    public void setDurationInSeconds(Long l) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, l) == null) {
            this.durationInSeconds = l;
        }
    }

    public void setSizeInBytes(Long l) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, l) == null) {
            this.sizeInBytes = l;
        }
    }

    public void setSourceSizeInBytes(Long l) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, l) == null) {
            this.sourceSizeInBytes = l;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return "MediaMeta { \n      sizeInBytes = " + this.sizeInBytes + "\n      durationInSeconds = " + this.durationInSeconds + "\n    }";
        }
        return (String) invokeV.objValue;
    }
}
