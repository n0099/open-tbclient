package com.bytedance.sdk.openadsdk;

import android.content.Context;
import android.content.pm.PackageManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.adnet.face.IHttpStack;
import com.bytedance.sdk.openadsdk.core.o;
/* loaded from: classes9.dex */
public final class TTAdConfig {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f65370a;

    /* renamed from: b  reason: collision with root package name */
    public String f65371b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f65372c;

    /* renamed from: d  reason: collision with root package name */
    public String f65373d;

    /* renamed from: e  reason: collision with root package name */
    public String f65374e;

    /* renamed from: f  reason: collision with root package name */
    public int f65375f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f65376g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f65377h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f65378i;

    /* renamed from: j  reason: collision with root package name */
    public int[] f65379j;
    public boolean k;
    public boolean l;
    public IHttpStack m;
    public TTDownloadEventLogger n;
    public TTSecAbs o;
    public String[] p;
    public boolean q;
    public TTCustomController r;
    public int s;

    /* renamed from: com.bytedance.sdk.openadsdk.TTAdConfig$1  reason: invalid class name */
    /* loaded from: classes9.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes9.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f65380a;

        /* renamed from: b  reason: collision with root package name */
        public String f65381b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f65382c;

        /* renamed from: d  reason: collision with root package name */
        public String f65383d;

        /* renamed from: e  reason: collision with root package name */
        public String f65384e;

        /* renamed from: f  reason: collision with root package name */
        public int f65385f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f65386g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f65387h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f65388i;

        /* renamed from: j  reason: collision with root package name */
        public int[] f65389j;
        public boolean k;
        public boolean l;
        public IHttpStack m;
        public TTDownloadEventLogger n;
        public TTSecAbs o;
        public String[] p;
        public boolean q;
        public TTCustomController r;
        public int s;

        public Builder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f65382c = false;
            this.f65385f = 0;
            this.f65386g = true;
            this.f65387h = false;
            this.f65388i = false;
            this.k = false;
            this.l = false;
            this.q = false;
        }

        public Builder allowShowNotify(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
                this.f65386g = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        @Deprecated
        public Builder allowShowPageWhenScreenLock(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
                this.f65388i = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder appId(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                this.f65380a = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder appName(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                this.f65381b = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder asyncInit(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
                this.q = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public TTAdConfig build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                TTAdConfig tTAdConfig = new TTAdConfig(null);
                tTAdConfig.setAppId(this.f65380a);
                tTAdConfig.setAppName(this.f65381b);
                tTAdConfig.setPaid(this.f65382c);
                tTAdConfig.setKeywords(this.f65383d);
                tTAdConfig.setData(this.f65384e);
                tTAdConfig.setTitleBarTheme(this.f65385f);
                tTAdConfig.setAllowShowNotify(this.f65386g);
                tTAdConfig.setDebug(this.f65387h);
                tTAdConfig.setAllowShowPageWhenScreenLock(this.f65388i);
                tTAdConfig.setDirectDownloadNetworkType(this.f65389j);
                tTAdConfig.setUseTextureView(this.k);
                tTAdConfig.setSupportMultiProcess(this.l);
                tTAdConfig.setHttpStack(this.m);
                tTAdConfig.setTTDownloadEventLogger(this.n);
                tTAdConfig.setTTSecAbs(this.o);
                tTAdConfig.setNeedClearTaskReset(this.p);
                tTAdConfig.setAsyncInit(this.q);
                tTAdConfig.setCustomController(this.r);
                tTAdConfig.setThemeStatus(this.s);
                return tTAdConfig;
            }
            return (TTAdConfig) invokeV.objValue;
        }

        public Builder customController(TTCustomController tTCustomController) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, tTCustomController)) == null) {
                this.r = tTCustomController;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder data(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
                this.f65384e = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder debug(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z)) == null) {
                this.f65387h = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder directDownloadNetworkType(int... iArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, iArr)) == null) {
                this.f65389j = iArr;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @Deprecated
        public Builder globalDownloadListener(TTGlobalAppDownloadListener tTGlobalAppDownloadListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, tTGlobalAppDownloadListener)) == null) ? this : (Builder) invokeL.objValue;
        }

        public Builder httpStack(IHttpStack iHttpStack) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, iHttpStack)) == null) {
                this.m = iHttpStack;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder keywords(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
                this.f65383d = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder needClearTaskReset(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, strArr)) == null) {
                this.p = strArr;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder paid(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048590, this, z)) == null) {
                this.f65382c = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder supportMultiProcess(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048591, this, z)) == null) {
                this.l = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder themeStatus(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) {
                this.s = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder titleBarTheme(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i2)) == null) {
                this.f65385f = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder ttDownloadEventLogger(TTDownloadEventLogger tTDownloadEventLogger) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, tTDownloadEventLogger)) == null) {
                this.n = tTDownloadEventLogger;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder ttSecAbs(TTSecAbs tTSecAbs) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, tTSecAbs)) == null) {
                this.o = tTSecAbs;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder useTextureView(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048596, this, z)) == null) {
                this.k = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }
    }

    public /* synthetic */ TTAdConfig(AnonymousClass1 anonymousClass1) {
        this();
    }

    private String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, context)) == null) {
            try {
                PackageManager packageManager = context.getApplicationContext().getPackageManager();
                return (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 128));
            } catch (PackageManager.NameNotFoundException unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public String getAppId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f65370a : (String) invokeV.objValue;
    }

    public String getAppName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String str = this.f65371b;
            if (str == null || str.isEmpty()) {
                this.f65371b = a(o.a());
            }
            return this.f65371b;
        }
        return (String) invokeV.objValue;
    }

    public TTCustomController getCustomController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.r : (TTCustomController) invokeV.objValue;
    }

    public String getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f65374e : (String) invokeV.objValue;
    }

    public int[] getDirectDownloadNetworkType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f65379j : (int[]) invokeV.objValue;
    }

    public IHttpStack getHttpStack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.m : (IHttpStack) invokeV.objValue;
    }

    public String getKeywords() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f65373d : (String) invokeV.objValue;
    }

    public String[] getNeedClearTaskReset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.p : (String[]) invokeV.objValue;
    }

    public TTDownloadEventLogger getTTDownloadEventLogger() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.n : (TTDownloadEventLogger) invokeV.objValue;
    }

    public TTSecAbs getTTSecAbs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.o : (TTSecAbs) invokeV.objValue;
    }

    public int getThemeStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.s : invokeV.intValue;
    }

    public int getTitleBarTheme() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f65375f : invokeV.intValue;
    }

    public boolean isAllowShowNotify() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f65376g : invokeV.booleanValue;
    }

    public boolean isAllowShowPageWhenScreenLock() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f65378i : invokeV.booleanValue;
    }

    public boolean isAsyncInit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.q : invokeV.booleanValue;
    }

    public boolean isDebug() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f65377h : invokeV.booleanValue;
    }

    public boolean isPaid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f65372c : invokeV.booleanValue;
    }

    public boolean isSupportMultiProcess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.l : invokeV.booleanValue;
    }

    public boolean isUseTextureView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.k : invokeV.booleanValue;
    }

    public void setAllowShowNotify(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.f65376g = z;
        }
    }

    public void setAllowShowPageWhenScreenLock(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.f65378i = z;
        }
    }

    public void setAppId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            this.f65370a = str;
        }
    }

    public void setAppName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            this.f65371b = str;
        }
    }

    public void setAsyncInit(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.q = z;
        }
    }

    public void setCustomController(TTCustomController tTCustomController) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, tTCustomController) == null) {
            this.r = tTCustomController;
        }
    }

    public void setData(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            this.f65374e = str;
        }
    }

    public void setDebug(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            this.f65377h = z;
        }
    }

    public void setDirectDownloadNetworkType(int... iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, iArr) == null) {
            this.f65379j = iArr;
        }
    }

    public void setHttpStack(IHttpStack iHttpStack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, iHttpStack) == null) {
            this.m = iHttpStack;
        }
    }

    public void setKeywords(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, str) == null) {
            this.f65373d = str;
        }
    }

    public void setNeedClearTaskReset(String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, strArr) == null) {
            this.p = strArr;
        }
    }

    public void setPaid(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
            this.f65372c = z;
        }
    }

    public void setSupportMultiProcess(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048608, this, z) == null) {
            this.l = z;
        }
    }

    public void setTTDownloadEventLogger(TTDownloadEventLogger tTDownloadEventLogger) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, tTDownloadEventLogger) == null) {
            this.n = tTDownloadEventLogger;
        }
    }

    public void setTTSecAbs(TTSecAbs tTSecAbs) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, tTSecAbs) == null) {
            this.o = tTSecAbs;
        }
    }

    public void setThemeStatus(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048611, this, i2) == null) {
            this.s = i2;
        }
    }

    public void setTitleBarTheme(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048612, this, i2) == null) {
            this.f65375f = i2;
        }
    }

    public void setUseTextureView(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048613, this, z) == null) {
            this.k = z;
        }
    }

    public TTAdConfig() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f65372c = false;
        this.f65375f = 0;
        this.f65376g = true;
        this.f65377h = false;
        this.f65378i = false;
        this.k = false;
        this.l = false;
        this.q = false;
    }
}
