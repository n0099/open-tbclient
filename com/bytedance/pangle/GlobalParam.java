package com.bytedance.pangle;

import androidx.annotation.Keep;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.pangle.download.IDownloaderProvider;
import com.bytedance.pangle.log.IZeusLogger;
import com.bytedance.pangle.log.IZeusReporter;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
@Keep
/* loaded from: classes7.dex */
public class GlobalParam {
    public static /* synthetic */ Interceptable $ic;
    public static GlobalParam mInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean hasInit;
    public boolean mCheckMatchHostAbi;
    public boolean mCheckPermission;
    public boolean mCloseDefaultReport;
    public boolean mDebug;
    public File mDownloadDir;
    public IDownloaderProvider mDownloaderProvider;
    public boolean mFastDex2oat;
    public String mHostUrl;
    public int mInstallThreads;
    public IZeusLogger mLogger;
    public IZeusReporter mReporter;
    public Map<String, String> mRequestHeader;

    public GlobalParam() {
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
        this.hasInit = false;
        this.mDebug = true;
        this.mCloseDefaultReport = true;
        this.mInstallThreads = 4;
        this.mCheckMatchHostAbi = true;
        this.mRequestHeader = new HashMap();
    }

    private void ensureInit() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65537, this) != null) || !this.hasInit) {
            return;
        }
        throw new RuntimeException();
    }

    public static GlobalParam getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (mInstance == null) {
                synchronized (GlobalParam.class) {
                    if (mInstance == null) {
                        mInstance = new GlobalParam();
                    }
                }
            }
            return mInstance;
        }
        return (GlobalParam) invokeV.objValue;
    }

    public boolean checkMatchHostAbi() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mCheckMatchHostAbi;
        }
        return invokeV.booleanValue;
    }

    public boolean checkPermission() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mCheckPermission;
        }
        return invokeV.booleanValue;
    }

    public File getDownloadDir() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mDownloadDir;
        }
        return (File) invokeV.objValue;
    }

    public IDownloaderProvider getDownloaderProvider() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mDownloaderProvider;
        }
        return (IDownloaderProvider) invokeV.objValue;
    }

    public String getHostUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mHostUrl;
        }
        return (String) invokeV.objValue;
    }

    public int getInstallThreads() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.mInstallThreads;
        }
        return invokeV.intValue;
    }

    public IZeusLogger getLogger() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.mLogger;
        }
        return (IZeusLogger) invokeV.objValue;
    }

    public IZeusReporter getReporter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.mReporter;
        }
        return (IZeusReporter) invokeV.objValue;
    }

    public Map<String, String> getRequestHeader() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.mRequestHeader;
        }
        return (Map) invokeV.objValue;
    }

    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.hasInit = true;
        }
    }

    public boolean isCloseDefaultReport() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.mCloseDefaultReport;
        }
        return invokeV.booleanValue;
    }

    public boolean isDebug() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.mDebug;
        }
        return invokeV.booleanValue;
    }

    public boolean isFastDex2oat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.mFastDex2oat;
        }
        return invokeV.booleanValue;
    }

    public void addRequestHeader(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            ensureInit();
            this.mRequestHeader.put(str, str2);
        }
    }

    public void setCheckMatchHostAbi(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.mCheckMatchHostAbi = z;
        }
    }

    public void setCheckPermission(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.mCheckPermission = z;
        }
    }

    public void setCloseDefaultReport(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            ensureInit();
            this.mCloseDefaultReport = z;
        }
    }

    public void setDebug(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            ensureInit();
            this.mDebug = z;
        }
    }

    public void setDownloadDir(File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, file) == null) {
            ensureInit();
            this.mDownloadDir = file;
        }
    }

    public void setDownloaderProvider(IDownloaderProvider iDownloaderProvider) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, iDownloaderProvider) == null) {
            ensureInit();
            this.mDownloaderProvider = iDownloaderProvider;
        }
    }

    public void setFastDex2oat(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.mFastDex2oat = z;
        }
    }

    public void setHostUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            ensureInit();
            this.mHostUrl = str;
        }
    }

    public void setInstallThreads(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i) == null) {
            ensureInit();
            this.mInstallThreads = i;
        }
    }

    public void setLogger(IZeusLogger iZeusLogger) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, iZeusLogger) == null) {
            ensureInit();
            this.mLogger = iZeusLogger;
        }
    }

    public void setReporter(IZeusReporter iZeusReporter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, iZeusReporter) == null) {
            ensureInit();
            this.mReporter = iZeusReporter;
        }
    }
}
