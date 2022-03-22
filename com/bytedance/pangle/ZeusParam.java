package com.bytedance.pangle;

import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.pangle.log.IZeusLogger;
import com.bytedance.pangle.log.IZeusReporter;
import com.bytedance.pangle.plugin.PluginProvider;
import com.bytedance.pangle.util.Lazy;
@Keep
/* loaded from: classes6.dex */
public class ZeusParam {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int mAppId;
    public String mAppKey;
    public String mAppName;
    public String mAppSecretKey;
    public boolean mAutoFetch;
    public String mChannel;
    public boolean mCheckMatchHostAbi;
    public boolean mCheckPermission;
    public boolean mCloseDefaultReport;
    public boolean mDebug;
    public boolean mEnable;
    public boolean mFastDex2Oat;
    public String mHost;
    public long mHostVersionCode;
    public String mHostVersionName;
    public int mInstallThreads;
    public Lazy<String> mLazyDid;
    public IZeusLogger mLogger;
    public PluginProvider mPluginProvider;
    public IZeusReporter mReporter;
    public ApkVerifier mVerifier;

    /* renamed from: com.bytedance.pangle.ZeusParam$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    @Keep
    /* loaded from: classes6.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int mAppId;
        public String mAppKey;
        public String mAppSecretKey;
        public boolean mAutoFetch;
        public String mChannel;
        public boolean mCheckMatchHostAbi;
        public boolean mCheckPermission;
        public boolean mCloseDefaultReport;
        public boolean mDebug;
        public boolean mEnable;
        public boolean mFastDex2Oat;
        public String mHost;
        public int mInstallThreads;
        public Lazy<String> mLazyDid;
        public IZeusLogger mLogger;
        public PluginProvider mPluginProvider;
        public IZeusReporter mReporter;
        public ApkVerifier mVerifier;

        public Builder() {
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
            this.mEnable = true;
            this.mDebug = true;
            this.mAutoFetch = true;
            this.mCheckMatchHostAbi = true;
            this.mCheckPermission = true;
            this.mInstallThreads = 4;
        }

        public Builder appId(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                this.mAppId = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder appKey(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                this.mAppKey = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder appSecretKey(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                this.mAppSecretKey = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder autoFetch(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
                this.mAutoFetch = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public ZeusParam build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                ZeusParam zeusParam = new ZeusParam(null);
                zeusParam.mEnable = this.mEnable;
                zeusParam.mDebug = this.mDebug;
                zeusParam.mAutoFetch = this.mAutoFetch;
                zeusParam.mFastDex2Oat = this.mFastDex2Oat;
                zeusParam.mCheckMatchHostAbi = this.mCheckMatchHostAbi;
                zeusParam.mCheckPermission = this.mCheckPermission;
                zeusParam.mInstallThreads = this.mInstallThreads;
                zeusParam.mChannel = this.mChannel;
                zeusParam.mAppId = this.mAppId;
                zeusParam.mHost = this.mHost;
                zeusParam.mAppKey = this.mAppKey;
                zeusParam.mAppSecretKey = this.mAppSecretKey;
                zeusParam.mLazyDid = this.mLazyDid;
                zeusParam.mLogger = this.mLogger;
                zeusParam.mReporter = this.mReporter;
                zeusParam.mVerifier = this.mVerifier;
                zeusParam.mPluginProvider = this.mPluginProvider;
                zeusParam.mCloseDefaultReport = this.mCloseDefaultReport;
                return zeusParam;
            }
            return (ZeusParam) invokeV.objValue;
        }

        public Builder channel(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                this.mChannel = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder closeDefaultReport(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
                this.mCloseDefaultReport = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder did(Lazy<String> lazy) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, lazy)) == null) {
                this.mLazyDid = lazy;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder host(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                this.mHost = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder logger(IZeusLogger iZeusLogger) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, iZeusLogger)) == null) {
                this.mLogger = iZeusLogger;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder pluginProvider(PluginProvider pluginProvider) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, pluginProvider)) == null) {
                this.mPluginProvider = pluginProvider;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder reporter(IZeusReporter iZeusReporter) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, iZeusReporter)) == null) {
                this.mReporter = iZeusReporter;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder verifyWith(ApkVerifier apkVerifier) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, apkVerifier)) == null) {
                this.mVerifier = apkVerifier;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder withCheckMatchHostAbiByInstall(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048589, this, z)) == null) {
                this.mCheckMatchHostAbi = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder withCheckPermission(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048590, this, z)) == null) {
                this.mCheckPermission = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        @Deprecated
        public Builder withCustomHook(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeZ = interceptable.invokeZ(1048591, this, z)) == null) ? this : (Builder) invokeZ.objValue;
        }

        public Builder withDebug(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048592, this, z)) == null) {
                this.mDebug = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder withEnable(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048593, this, z)) == null) {
                this.mEnable = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder withFastDex2Oat(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048594, this, z)) == null) {
                this.mFastDex2Oat = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder withInstallThreads(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i)) == null) {
                this.mInstallThreads = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        @Deprecated
        public Builder withSupportStandalonePlugin(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeZ = interceptable.invokeZ(1048596, this, z)) == null) ? this : (Builder) invokeZ.objValue;
        }
    }

    public /* synthetic */ ZeusParam(AnonymousClass1 anonymousClass1) {
        this();
    }

    public boolean autoFetch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mAutoFetch : invokeV.booleanValue;
    }

    public boolean checkMatchHostAbi() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mCheckMatchHostAbi : invokeV.booleanValue;
    }

    public boolean checkPermission() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mCheckPermission : invokeV.booleanValue;
    }

    public boolean fastDex2Oat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mFastDex2Oat : invokeV.booleanValue;
    }

    public int getAppId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mAppId : invokeV.intValue;
    }

    public String getAppKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mAppKey : (String) invokeV.objValue;
    }

    public String getAppName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (TextUtils.isEmpty(this.mAppName)) {
                try {
                    this.mAppName = (String) Zeus.getAppApplication().getPackageManager().getApplicationLabel(Zeus.getAppApplication().getApplicationInfo());
                } catch (Throwable unused) {
                }
            }
            return this.mAppName;
        }
        return (String) invokeV.objValue;
    }

    public String getAppSecretKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mAppSecretKey : (String) invokeV.objValue;
    }

    public String getChannel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mChannel : (String) invokeV.objValue;
    }

    public Lazy<String> getDid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mLazyDid : (Lazy) invokeV.objValue;
    }

    public String getHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mHost : (String) invokeV.objValue;
    }

    public long getHostVersionCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.mHostVersionCode == -1) {
                try {
                    PackageInfo packageInfo = Zeus.getAppApplication().getPackageManager().getPackageInfo(Zeus.getAppApplication().getPackageName(), 0);
                    if (Build.VERSION.SDK_INT >= 28) {
                        this.mHostVersionCode = packageInfo.getLongVersionCode();
                    } else {
                        this.mHostVersionCode = packageInfo.versionCode;
                    }
                } catch (Throwable unused) {
                }
            }
            return this.mHostVersionCode;
        }
        return invokeV.longValue;
    }

    public String getHostVersionName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (TextUtils.isEmpty(this.mHostVersionName)) {
                try {
                    this.mHostVersionName = Zeus.getAppApplication().getPackageManager().getPackageInfo(Zeus.getAppApplication().getPackageName(), 0).versionName;
                } catch (Throwable unused) {
                }
            }
            return this.mHostVersionName;
        }
        return (String) invokeV.objValue;
    }

    public int getInstallThreads() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mInstallThreads : invokeV.intValue;
    }

    public IZeusLogger getLogger() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.mLogger : (IZeusLogger) invokeV.objValue;
    }

    public PluginProvider getPluginProvider() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.mPluginProvider : (PluginProvider) invokeV.objValue;
    }

    public IZeusReporter getReporter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.mReporter : (IZeusReporter) invokeV.objValue;
    }

    public ApkVerifier getVerifier() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.mVerifier : (ApkVerifier) invokeV.objValue;
    }

    public boolean isCloseDefaultReport() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.mCloseDefaultReport : invokeV.booleanValue;
    }

    public boolean isDebug() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.mDebug : invokeV.booleanValue;
    }

    public boolean isEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.mEnable : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return "ZeusParam{mEnable=" + this.mEnable + ", mDebug=" + this.mDebug + ", mFastDex2Oat=" + this.mFastDex2Oat + ", mInstallThreads=" + this.mInstallThreads + ", mCheckMatchHostAbi=" + this.mCheckMatchHostAbi + '}';
        }
        return (String) invokeV.objValue;
    }

    public ZeusParam() {
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
        this.mHostVersionCode = -1L;
        this.mInstallThreads = 4;
    }
}
