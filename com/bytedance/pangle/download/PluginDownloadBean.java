package com.bytedance.pangle.download;

import androidx.annotation.Keep;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
@Keep
/* loaded from: classes4.dex */
public class PluginDownloadBean {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isOffline;
    public boolean isRevert;
    public boolean isWifiOnly;
    public int mApiVersionMax;
    public int mApiVersionMin;
    public List<String> mBackupUrlList;
    public int mClientVersionMax;
    public int mClientVersionMin;
    public int mDownloadType;
    public String mMd5;
    public int mOrder;
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
            }
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "PluginDownloadBean{mPackageName='" + this.mPackageName + "', mVersionCode=" + this.mVersionCode + ", mUrl='" + this.mUrl + "', mMd5='" + this.mMd5 + "', mOrder=" + this.mOrder + ", isOffline=" + this.isOffline + ", isRevert=" + this.isRevert + ", isWifiOnly=" + this.isWifiOnly + ", mClientVersionMin=" + this.mClientVersionMin + ", mClientVersionMax=" + this.mClientVersionMax + ", mApiVersionMin=" + this.mApiVersionMin + ", mApiVersionMax=" + this.mApiVersionMax + ", mDownloadType=" + this.mDownloadType + ", mBackupUrlList=" + this.mBackupUrlList + '}';
        }
        return (String) invokeV.objValue;
    }
}
