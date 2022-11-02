package com.baidu.tieba.tbadkCore.data;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.annotations.SerializedName;
import org.json.JSONObject;
import tbclient.ThemeBubble;
@Keep
/* loaded from: classes6.dex */
public class ThemeBubbleData {
    public static /* synthetic */ Interceptable $ic;
    public static final ThemeBubbleData DEFAULT;
    public transient /* synthetic */ FieldHolder $fh;
    @SerializedName(BigdayActivityConfig.JUMP_URL)
    public String jumpUrl;
    @SerializedName("package_id")
    public int packageId;
    @SerializedName("props_id")
    public int propsId;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1026612253, "Lcom/baidu/tieba/tbadkCore/data/ThemeBubbleData;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1026612253, "Lcom/baidu/tieba/tbadkCore/data/ThemeBubbleData;");
                return;
            }
        }
        DEFAULT = new ThemeBubbleData();
    }

    public ThemeBubbleData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.propsId = 0;
        this.packageId = 0;
    }

    public String getJumpUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.jumpUrl;
        }
        return (String) invokeV.objValue;
    }

    public int getPackageId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.packageId;
        }
        return invokeV.intValue;
    }

    public int getPropsId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.propsId;
        }
        return invokeV.intValue;
    }

    public ThemeBubbleData(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.propsId = 0;
        this.packageId = 0;
        this.propsId = jSONObject.optInt("props_id");
        this.packageId = jSONObject.optInt("package_id");
        this.jumpUrl = jSONObject.optString(BigdayActivityConfig.JUMP_URL);
    }

    public ThemeBubbleData(@NonNull ThemeBubble themeBubble) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {themeBubble};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.propsId = 0;
        this.packageId = 0;
        this.propsId = themeBubble.props_id.intValue();
        this.packageId = themeBubble.package_id.intValue();
        this.jumpUrl = themeBubble.jump_url;
    }

    public void setJumpUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.jumpUrl = str;
        }
    }

    public void setPackageId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.packageId = i;
        }
    }

    public void setPropsId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.propsId = i;
        }
    }
}
