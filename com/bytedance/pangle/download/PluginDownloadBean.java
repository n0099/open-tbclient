package com.bytedance.pangle.download;

import android.content.SharedPreferences;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.pangle.util.l;
import java.util.List;
/* loaded from: classes7.dex */
public class PluginDownloadBean {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int mApiVersionMax;
    public int mApiVersionMin;
    public List mBackupUrlList;
    public int mFlag;
    public long mFollowId;
    public String mMd5;
    public String mPackageName;
    public String mUrl;
    public int mVersionCode;

    public PluginDownloadBean() {
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
        this.mApiVersionMin = 0;
        this.mApiVersionMax = Integer.MAX_VALUE;
    }

    public boolean isRevert() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.mFlag == 3) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isUnInstall() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.mFlag == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean allowDownload() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            l a = l.a();
            String str = this.mPackageName;
            int i = this.mVersionCode;
            SharedPreferences sharedPreferences = a.a;
            return sharedPreferences.getBoolean("ALLOW_DOWNLOAD__" + str + "_" + i, true);
        }
        return invokeV.booleanValue;
    }
}
