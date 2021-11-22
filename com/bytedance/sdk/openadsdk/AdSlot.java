package com.bytedance.sdk.openadsdk;

import android.support.v4.media.session.MediaSessionCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.api.b.d;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class AdSlot implements TTAdSlot {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TTAdLoadType A;
    public int B;
    public int C;

    /* renamed from: a  reason: collision with root package name */
    public String f62432a;

    /* renamed from: b  reason: collision with root package name */
    public int f62433b;

    /* renamed from: c  reason: collision with root package name */
    public int f62434c;

    /* renamed from: d  reason: collision with root package name */
    public float f62435d;

    /* renamed from: e  reason: collision with root package name */
    public float f62436e;

    /* renamed from: f  reason: collision with root package name */
    public int f62437f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f62438g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f62439h;

    /* renamed from: i  reason: collision with root package name */
    public String f62440i;
    public int j;
    public String k;
    public String l;
    public int m;
    public int n;
    public int o;
    public int p;
    public boolean q;
    public int[] r;
    public String s;
    public int t;
    public String u;
    public String v;
    public String w;
    public String x;
    public String y;
    public String z;

    /* renamed from: com.bytedance.sdk.openadsdk.AdSlot$1  reason: invalid class name */
    /* loaded from: classes11.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes11.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String A;
        public String B;

        /* renamed from: a  reason: collision with root package name */
        public String f62441a;

        /* renamed from: b  reason: collision with root package name */
        public int f62442b;

        /* renamed from: c  reason: collision with root package name */
        public int f62443c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f62444d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f62445e;

        /* renamed from: f  reason: collision with root package name */
        public int f62446f;

        /* renamed from: g  reason: collision with root package name */
        public String f62447g;

        /* renamed from: h  reason: collision with root package name */
        public int f62448h;

        /* renamed from: i  reason: collision with root package name */
        public String f62449i;
        public String j;
        public int k;
        public int l;
        public String m;
        public int n;
        public float o;
        public float p;
        public boolean q;
        public int[] r;
        public int s;
        public String t;
        public String u;
        public String v;
        public int w;
        public int x;
        public TTAdLoadType y;
        public String z;

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
            this.f62442b = 640;
            this.f62443c = MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP;
            this.f62444d = true;
            this.f62445e = false;
            this.f62446f = 1;
            this.f62447g = "";
            this.f62448h = 0;
            this.j = "defaultUser";
            this.k = 2;
            this.q = true;
            this.w = 1;
            this.x = 0;
            this.y = TTAdLoadType.UNKNOWN;
        }

        public AdSlot build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                AdSlot adSlot = new AdSlot(null);
                adSlot.f62432a = this.f62441a;
                adSlot.f62437f = this.f62446f;
                adSlot.f62438g = this.f62444d;
                adSlot.f62439h = this.f62445e;
                adSlot.f62433b = this.f62442b;
                adSlot.f62434c = this.f62443c;
                float f2 = this.o;
                if (f2 <= 0.0f) {
                    adSlot.f62435d = this.f62442b;
                    adSlot.f62436e = this.f62443c;
                } else {
                    adSlot.f62435d = f2;
                    adSlot.f62436e = this.p;
                }
                adSlot.f62440i = this.f62447g;
                adSlot.j = this.f62448h;
                adSlot.k = this.f62449i;
                adSlot.l = this.j;
                adSlot.m = this.k;
                adSlot.o = this.l;
                adSlot.q = this.q;
                adSlot.r = this.r;
                adSlot.t = this.s;
                adSlot.u = this.t;
                adSlot.s = this.m;
                adSlot.w = this.z;
                adSlot.x = this.A;
                adSlot.y = this.B;
                adSlot.n = this.n;
                adSlot.v = this.u;
                adSlot.z = this.v;
                adSlot.A = this.y;
                adSlot.B = this.w;
                adSlot.C = this.x;
                return adSlot;
            }
            return (AdSlot) invokeV.objValue;
        }

        public Builder setAdCount(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
                if (i2 <= 0) {
                    i2 = 1;
                    d.b(TTAdConstant.TAG, "setAdCount: adCount must greater than 0 ");
                }
                if (i2 > 20) {
                    d.b(TTAdConstant.TAG, "setAdCount: adCount must less than or equal to 20 ");
                    i2 = 20;
                }
                this.f62446f = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setAdId(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                this.z = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setAdLoadType(TTAdLoadType tTAdLoadType) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, tTAdLoadType)) == null) {
                this.y = tTAdLoadType;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setAdType(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
                this.n = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setAdloadSeq(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
                this.s = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setCodeId(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
                this.f62441a = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setCreativeId(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
                this.A = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setDownloadType(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
                if (i2 != 1) {
                    i2 = 0;
                }
                this.x = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setExpressViewAcceptedSize(float f2, float f3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
                this.o = f2;
                this.p = f3;
                return this;
            }
            return (Builder) invokeCommon.objValue;
        }

        public Builder setExt(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
                this.B = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setExternalABVid(int... iArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, iArr)) == null) {
                this.r = iArr;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setExtraParam(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
                this.m = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setImageAcceptedSize(int i2, int i3) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeII = interceptable.invokeII(1048589, this, i2, i3)) == null) {
                this.f62442b = i2;
                this.f62443c = i3;
                return this;
            }
            return (Builder) invokeII.objValue;
        }

        public Builder setIsAutoPlay(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048590, this, z)) == null) {
                this.q = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setMediaExtra(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
                this.f62449i = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setNativeAdType(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) {
                this.l = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setOrientation(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i2)) == null) {
                this.k = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setPrimeRit(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) {
                this.t = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setRewardAmount(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i2)) == null) {
                this.f62448h = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setRewardName(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, str)) == null) {
                this.f62447g = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setSplashButtonType(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048597, this, i2)) == null) {
                if (i2 != 2) {
                    i2 = 1;
                }
                this.w = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setSupportDeepLink(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048598, this, z)) == null) {
                this.f62444d = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setUserData(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, str)) == null) {
                this.v = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setUserID(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, str)) == null) {
                this.j = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder supportRenderControl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
                this.f62445e = true;
                return this;
            }
            return (Builder) invokeV.objValue;
        }

        public Builder withBid(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, str)) == null) {
                if (str == null) {
                    return this;
                }
                this.u = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }
    }

    public /* synthetic */ AdSlot(AnonymousClass1 anonymousClass1) {
        this();
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public int getAdCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f62437f : invokeV.intValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public String getAdId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.w : (String) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public TTAdLoadType getAdLoadType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.A : (TTAdLoadType) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public int getAdType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.n : invokeV.intValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public int getAdloadSeq() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.t : invokeV.intValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public String getBidAdm() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.v : (String) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public String getCodeId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f62432a : (String) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public String getCreativeId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.x : (String) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public int getDownloadType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.C : invokeV.intValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public int getDurationSlotType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.p : invokeV.intValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public float getExpressViewAcceptedHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f62436e : invokeV.floatValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public float getExpressViewAcceptedWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f62435d : invokeV.floatValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public String getExt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.y : (String) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public int[] getExternalABVid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.r : (int[]) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public String getExtraSmartLookParam() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.s : (String) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public int getImgAcceptedHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f62434c : invokeV.intValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public int getImgAcceptedWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f62433b : invokeV.intValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public String getMediaExtra() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.k : (String) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public int getNativeAdType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.o : invokeV.intValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public int getOrientation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.m : invokeV.intValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public String getPrimeRit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            String str = this.u;
            return str == null ? "" : str;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public int getRewardAmount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.j : invokeV.intValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public String getRewardName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f62440i : (String) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public int getSplashButtonType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.B : invokeV.intValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public String getUserData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.z : (String) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public String getUserID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.l : (String) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public boolean isAutoPlay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.q : invokeV.booleanValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public boolean isSupportDeepLink() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.f62438g : invokeV.booleanValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public boolean isSupportRenderConrol() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.f62439h : invokeV.booleanValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public void setAdCount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i2) == null) {
            this.f62437f = i2;
        }
    }

    public void setAdLoadType(TTAdLoadType tTAdLoadType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, tTAdLoadType) == null) {
            this.A = tTAdLoadType;
        }
    }

    public void setDownloadType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i2) == null) {
            this.C = i2;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public void setDurationSlotType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i2) == null) {
            this.p = i2;
        }
    }

    public void setExternalABVid(int... iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, iArr) == null) {
            this.r = iArr;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public void setNativeAdType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i2) == null) {
            this.o = i2;
        }
    }

    public void setSplashButtonType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048611, this, i2) == null) {
            this.B = i2;
        }
    }

    public void setUserData(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, str) == null) {
            this.z = str;
        }
    }

    public JSONObject toJsonObj() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("mCodeId", this.f62432a);
                jSONObject.put("mIsAutoPlay", this.q);
                jSONObject.put("mImgAcceptedWidth", this.f62433b);
                jSONObject.put("mImgAcceptedHeight", this.f62434c);
                jSONObject.put("mExpressViewAcceptedWidth", this.f62435d);
                jSONObject.put("mExpressViewAcceptedHeight", this.f62436e);
                jSONObject.put("mAdCount", this.f62437f);
                jSONObject.put("mSupportDeepLink", this.f62438g);
                jSONObject.put("mSupportRenderControl", this.f62439h);
                jSONObject.put("mRewardName", this.f62440i);
                jSONObject.put("mRewardAmount", this.j);
                jSONObject.put("mMediaExtra", this.k);
                jSONObject.put("mUserID", this.l);
                jSONObject.put("mOrientation", this.m);
                jSONObject.put("mNativeAdType", this.o);
                jSONObject.put("mAdloadSeq", this.t);
                jSONObject.put("mPrimeRit", this.u);
                jSONObject.put("mExtraSmartLookParam", this.s);
                jSONObject.put("mAdId", this.w);
                jSONObject.put("mCreativeId", this.x);
                jSONObject.put("mExt", this.y);
                jSONObject.put("mBidAdm", this.v);
                jSONObject.put("mUserData", this.z);
                jSONObject.put("mAdLoadType", this.A);
                jSONObject.put("mSplashButtonType", this.B);
                jSONObject.put("mDownloadType", this.C);
            } catch (Exception unused) {
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return "AdSlot{mCodeId='" + this.f62432a + ExtendedMessageFormat.QUOTE + ", mImgAcceptedWidth=" + this.f62433b + ", mImgAcceptedHeight=" + this.f62434c + ", mExpressViewAcceptedWidth=" + this.f62435d + ", mExpressViewAcceptedHeight=" + this.f62436e + ", mAdCount=" + this.f62437f + ", mSupportDeepLink=" + this.f62438g + ", mSupportRenderControl=" + this.f62439h + ", mRewardName='" + this.f62440i + ExtendedMessageFormat.QUOTE + ", mRewardAmount=" + this.j + ", mMediaExtra='" + this.k + ExtendedMessageFormat.QUOTE + ", mUserID='" + this.l + ExtendedMessageFormat.QUOTE + ", mOrientation=" + this.m + ", mNativeAdType=" + this.o + ", mIsAutoPlay=" + this.q + ", mPrimeRit" + this.u + ", mAdloadSeq" + this.t + ", mAdId" + this.w + ", mCreativeId" + this.x + ", mExt" + this.y + ", mUserData" + this.z + ", mAdLoadType" + this.A + ", mSplashButtonType=" + this.B + ", mDownloadType=" + this.C + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }

    public AdSlot() {
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
        this.m = 2;
        this.q = true;
        this.B = 1;
        this.C = 0;
    }
}
