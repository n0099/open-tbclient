package com.bytedance.embedapplog;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.embedapplog.util.UriConfig;
/* loaded from: classes9.dex */
public class InitConfig {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public ISensitiveInfoProvider B;

    /* renamed from: a  reason: collision with root package name */
    public String f63869a;

    /* renamed from: b  reason: collision with root package name */
    public String f63870b;

    /* renamed from: c  reason: collision with root package name */
    public String f63871c;

    /* renamed from: d  reason: collision with root package name */
    public String f63872d;

    /* renamed from: e  reason: collision with root package name */
    public String f63873e;

    /* renamed from: f  reason: collision with root package name */
    public String f63874f;

    /* renamed from: g  reason: collision with root package name */
    public IPicker f63875g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f63876h;

    /* renamed from: i  reason: collision with root package name */
    public int f63877i;

    /* renamed from: j  reason: collision with root package name */
    public String f63878j;
    public String k;
    public UriConfig l;
    public String m;
    public String n;
    public int o;
    public int p;
    public int q;
    public String r;
    public String s;
    public String t;
    public String u;
    public String v;
    public String w;
    public String x;
    public boolean y;
    public boolean z;

    public InitConfig(@NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f63877i = 0;
        this.y = true;
        this.z = true;
        this.f63869a = str;
        this.f63870b = str2;
    }

    public String getAbClient() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.s : (String) invokeV.objValue;
    }

    public String getAbFeature() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.v : (String) invokeV.objValue;
    }

    public String getAbGroup() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.u : (String) invokeV.objValue;
    }

    public String getAbVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.t : (String) invokeV.objValue;
    }

    public String getAid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f63869a : (String) invokeV.objValue;
    }

    public String getAliyunUdid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f63874f : (String) invokeV.objValue;
    }

    public String getAppImei() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.A : (String) invokeV.objValue;
    }

    public String getAppName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.k : (String) invokeV.objValue;
    }

    public String getChannel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f63870b : (String) invokeV.objValue;
    }

    public String getGoogleAid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f63871c : (String) invokeV.objValue;
    }

    public String getLanguage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f63872d : (String) invokeV.objValue;
    }

    public String getManifestVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.r : (String) invokeV.objValue;
    }

    public int getManifestVersionCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.q : invokeV.intValue;
    }

    public IPicker getPicker() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f63875g : (IPicker) invokeV.objValue;
    }

    public int getProcess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f63877i : invokeV.intValue;
    }

    public String getRegion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f63873e : (String) invokeV.objValue;
    }

    public String getReleaseBuild() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f63878j : (String) invokeV.objValue;
    }

    public ISensitiveInfoProvider getSensitiveInfoProvider() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.B : (ISensitiveInfoProvider) invokeV.objValue;
    }

    public String getTweakedChannel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.n : (String) invokeV.objValue;
    }

    public int getUpdateVersionCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.p : invokeV.intValue;
    }

    public UriConfig getUriConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.l : (UriConfig) invokeV.objValue;
    }

    public String getVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.m : (String) invokeV.objValue;
    }

    public int getVersionCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.o : invokeV.intValue;
    }

    public String getVersionMinor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.w : (String) invokeV.objValue;
    }

    public String getZiJieCloudPkg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.x : (String) invokeV.objValue;
    }

    public boolean isImeiEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.z : invokeV.booleanValue;
    }

    public boolean isMacEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.y : invokeV.booleanValue;
    }

    public boolean isPlayEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.f63876h : invokeV.booleanValue;
    }

    public InitConfig setAbClient(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, str)) == null) {
            this.s = str;
            return this;
        }
        return (InitConfig) invokeL.objValue;
    }

    public InitConfig setAbFeature(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, str)) == null) {
            this.v = str;
            return this;
        }
        return (InitConfig) invokeL.objValue;
    }

    public InitConfig setAbGroup(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, str)) == null) {
            this.u = str;
            return this;
        }
        return (InitConfig) invokeL.objValue;
    }

    public InitConfig setAbVersion(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, str)) == null) {
            this.t = str;
            return this;
        }
        return (InitConfig) invokeL.objValue;
    }

    public InitConfig setAliyunUdid(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, str)) == null) {
            this.f63874f = str;
            return this;
        }
        return (InitConfig) invokeL.objValue;
    }

    public void setAppImei(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, str) == null) {
            this.A = str;
        }
    }

    public InitConfig setAppName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, str)) == null) {
            this.k = str;
            return this;
        }
        return (InitConfig) invokeL.objValue;
    }

    @NonNull
    public InitConfig setEnablePlay(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048611, this, z)) == null) {
            this.f63876h = z;
            return this;
        }
        return (InitConfig) invokeZ.objValue;
    }

    @NonNull
    public InitConfig setGoogleAid(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, str)) == null) {
            this.f63871c = str;
            return this;
        }
        return (InitConfig) invokeL.objValue;
    }

    public void setImeiEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048613, this, z) == null) {
            this.z = z;
        }
    }

    @NonNull
    public InitConfig setLanguage(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, str)) == null) {
            this.f63872d = str;
            return this;
        }
        return (InitConfig) invokeL.objValue;
    }

    public void setMacEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z) == null) {
            this.y = z;
        }
    }

    public InitConfig setManifestVersion(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048616, this, str)) == null) {
            this.r = str;
            return this;
        }
        return (InitConfig) invokeL.objValue;
    }

    public InitConfig setManifestVersionCode(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048617, this, i2)) == null) {
            this.q = i2;
            return this;
        }
        return (InitConfig) invokeI.objValue;
    }

    @NonNull
    public InitConfig setPicker(IPicker iPicker) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048618, this, iPicker)) == null) {
            this.f63875g = iPicker;
            return this;
        }
        return (InitConfig) invokeL.objValue;
    }

    @NonNull
    public InitConfig setProcess(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048619, this, z)) == null) {
            this.f63877i = z ? 1 : 2;
            return this;
        }
        return (InitConfig) invokeZ.objValue;
    }

    @NonNull
    public InitConfig setRegion(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048620, this, str)) == null) {
            this.f63873e = str;
            return this;
        }
        return (InitConfig) invokeL.objValue;
    }

    @NonNull
    public InitConfig setReleaseBuild(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048621, this, str)) == null) {
            this.f63878j = str;
            return this;
        }
        return (InitConfig) invokeL.objValue;
    }

    public void setSensitiveInfoProvider(ISensitiveInfoProvider iSensitiveInfoProvider) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, iSensitiveInfoProvider) == null) {
            this.B = iSensitiveInfoProvider;
        }
    }

    public InitConfig setTweakedChannel(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048623, this, str)) == null) {
            this.n = str;
            return this;
        }
        return (InitConfig) invokeL.objValue;
    }

    public InitConfig setUpdateVersionCode(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048624, this, i2)) == null) {
            this.p = i2;
            return this;
        }
        return (InitConfig) invokeI.objValue;
    }

    public InitConfig setUriConfig(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048625, this, i2)) == null) {
            this.l = UriConfig.createUriConfig(i2);
            return this;
        }
        return (InitConfig) invokeI.objValue;
    }

    public InitConfig setVersion(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048627, this, str)) == null) {
            this.m = str;
            return this;
        }
        return (InitConfig) invokeL.objValue;
    }

    public InitConfig setVersionCode(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048628, this, i2)) == null) {
            this.o = i2;
            return this;
        }
        return (InitConfig) invokeI.objValue;
    }

    public InitConfig setVersionMinor(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048629, this, str)) == null) {
            this.w = str;
            return this;
        }
        return (InitConfig) invokeL.objValue;
    }

    public InitConfig setZiJieCloudPkg(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048630, this, str)) == null) {
            this.x = str;
            return this;
        }
        return (InitConfig) invokeL.objValue;
    }

    public InitConfig setUriConfig(UriConfig uriConfig) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048626, this, uriConfig)) == null) {
            this.l = uriConfig;
            return this;
        }
        return (InitConfig) invokeL.objValue;
    }
}
