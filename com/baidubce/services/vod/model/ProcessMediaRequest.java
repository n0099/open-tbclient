package com.baidubce.services.vod.model;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.auth.BceCredentials;
import com.baidubce.model.AbstractBceRequest;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class ProcessMediaRequest extends VodBceRequest {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String description;
    public String mediaId;
    public String sourceExtension;
    public String title;
    public String transcodingPresetGroupName;

    public ProcessMediaRequest() {
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

    public String getDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.description;
        }
        return (String) invokeV.objValue;
    }

    public String getMediaId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mediaId;
        }
        return (String) invokeV.objValue;
    }

    public String getSourceExtension() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.sourceExtension;
        }
        return (String) invokeV.objValue;
    }

    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.title;
        }
        return (String) invokeV.objValue;
    }

    public String getTranscodingPresetGroupName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.transcodingPresetGroupName;
        }
        return (String) invokeV.objValue;
    }

    public void setDescription(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.description = str;
        }
    }

    public void setMediaId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.mediaId = str;
        }
    }

    public void setSourceExtension(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.sourceExtension = str;
        }
    }

    public void setTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.title = str;
        }
    }

    public void setTranscodingPresetGroupName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.transcodingPresetGroupName = str;
        }
    }

    public ProcessMediaRequest withDescription(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            this.description = str;
            return this;
        }
        return (ProcessMediaRequest) invokeL.objValue;
    }

    public ProcessMediaRequest withMediaId(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            this.mediaId = str;
            return this;
        }
        return (ProcessMediaRequest) invokeL.objValue;
    }

    @Override // com.baidubce.model.AbstractBceRequest
    public AbstractBceRequest withRequestCredentials(BceCredentials bceCredentials) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, bceCredentials)) == null) {
            setRequestCredentials(bceCredentials);
            return this;
        }
        return (AbstractBceRequest) invokeL.objValue;
    }

    public ProcessMediaRequest withSourceExtension(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            this.sourceExtension = str;
            return this;
        }
        return (ProcessMediaRequest) invokeL.objValue;
    }

    public ProcessMediaRequest withTitle(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            this.title = str;
            return this;
        }
        return (ProcessMediaRequest) invokeL.objValue;
    }

    public ProcessMediaRequest withTranscodingPresetGroupName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
            this.transcodingPresetGroupName = str;
            return this;
        }
        return (ProcessMediaRequest) invokeL.objValue;
    }

    @Override // com.baidubce.services.vod.model.VodBceRequest
    public String toJsonString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("mediaId", this.mediaId);
                jSONObject.put("title", this.title);
                jSONObject.put("description", this.description);
                jSONObject.put("sourceExtension", this.sourceExtension);
                jSONObject.put("transcodingPresetGroupName", this.transcodingPresetGroupName);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return "ProcessMediaRequest { \n  mediaId = " + this.mediaId + "\n  title = " + this.title + "\n  description = " + this.description + "\n  sourceExtension = " + this.sourceExtension + "\n}\n";
        }
        return (String) invokeV.objValue;
    }
}
