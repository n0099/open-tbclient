package com.baidu.wallet.base.widget.banner;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.NoProguard;
import java.io.Serializable;
/* loaded from: classes11.dex */
public abstract class BannerBaseItemInfo implements NoProguard, Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TIMESTAMP_TYPE_COPY = "3";
    public static final String TIMESTAMP_TYPE_RED_DOT = "2";
    public static final String TIMESTAMP_TYPE_WHITE_DOT = "1";
    public static final String TYPE_H5_INNER = "1";
    public static final String TYPE_H5_OUTER = "2";
    public static final String TYPE_LOGIN = "5";
    public static final String TYPE_SCHEME = "6";
    public static final String TYPE_SDK = "3";
    public static final String TYPE_SDK_OUT = "4";
    public static final long serialVersionUID = -6186522237816791458L;
    public transient /* synthetic */ FieldHolder $fh;

    public BannerBaseItemInfo() {
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

    public abstract String getLinkAddr();

    public abstract String getName();

    public abstract String getPicAddr();

    public abstract boolean getPrevlogin();

    public String getStat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    public abstract String getType();
}
