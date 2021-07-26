package com.bytedance.sdk.openadsdk;

import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.openadsdk.n.g.b;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class AdSlot {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int TYPE_BANNER = 1;
    public static final int TYPE_CACHED_SPLASH = 4;
    public static final int TYPE_DRAW_FEED = 9;
    public static final int TYPE_FEED = 5;
    public static final int TYPE_FULL_SCREEN_VIDEO = 8;
    public static final int TYPE_INTERACTION_AD = 2;
    public static final int TYPE_REWARD_VIDEO = 7;
    public static final int TYPE_SPLASH = 3;
    public static final int TYPE_STREAM = 6;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f29076a;

    /* renamed from: b  reason: collision with root package name */
    public int f29077b;

    /* renamed from: c  reason: collision with root package name */
    public int f29078c;

    /* renamed from: d  reason: collision with root package name */
    public float f29079d;

    /* renamed from: e  reason: collision with root package name */
    public float f29080e;

    /* renamed from: f  reason: collision with root package name */
    public int f29081f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f29082g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f29083h;

    /* renamed from: i  reason: collision with root package name */
    public String f29084i;
    public int j;
    public String k;
    public String l;
    public int m;
    public int n;
    public int o;
    public int p;
    public boolean q;
    public int[] r;
    public int s;
    public String t;
    public String u;
    public String v;
    public String w;
    public String x;
    public String y;

    /* renamed from: com.bytedance.sdk.openadsdk.AdSlot$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f29085a;

        /* renamed from: b  reason: collision with root package name */
        public int f29086b;

        /* renamed from: c  reason: collision with root package name */
        public int f29087c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f29088d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f29089e;

        /* renamed from: f  reason: collision with root package name */
        public int f29090f;

        /* renamed from: g  reason: collision with root package name */
        public String f29091g;

        /* renamed from: h  reason: collision with root package name */
        public int f29092h;

        /* renamed from: i  reason: collision with root package name */
        public String f29093i;
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
        public String w;
        public String x;
        public String y;

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
            this.f29086b = 640;
            this.f29087c = MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP;
            this.f29088d = true;
            this.f29089e = false;
            this.f29090f = 1;
            this.f29091g = "";
            this.f29092h = 0;
            this.j = "defaultUser";
            this.k = 2;
            this.q = true;
        }

        public AdSlot build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                AdSlot adSlot = new AdSlot(null);
                adSlot.f29076a = this.f29085a;
                adSlot.f29081f = this.f29090f;
                adSlot.f29082g = this.f29088d;
                adSlot.f29083h = this.f29089e;
                adSlot.f29077b = this.f29086b;
                adSlot.f29078c = this.f29087c;
                float f2 = this.o;
                if (f2 <= 0.0f) {
                    adSlot.f29079d = this.f29086b;
                    adSlot.f29080e = this.f29087c;
                } else {
                    adSlot.f29079d = f2;
                    adSlot.f29080e = this.p;
                }
                adSlot.f29084i = this.f29091g;
                adSlot.j = this.f29092h;
                adSlot.k = this.f29093i;
                adSlot.l = this.j;
                adSlot.m = this.k;
                adSlot.o = this.l;
                adSlot.q = this.q;
                adSlot.r = this.r;
                adSlot.s = this.s;
                adSlot.t = this.t;
                adSlot.v = this.w;
                adSlot.w = this.x;
                adSlot.x = this.y;
                adSlot.n = this.n;
                adSlot.u = this.u;
                adSlot.y = this.v;
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
                    k.c(TTAdConstant.TAG, "setAdCount: adCount must greater than 0 ");
                }
                if (i2 > 20) {
                    k.c(TTAdConstant.TAG, "setAdCount: adCount must less than or equal to 20 ");
                    i2 = 20;
                }
                this.f29090f = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setAdId(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                this.w = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setAdType(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
                this.n = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setAdloadSeq(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
                this.s = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setCodeId(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                this.f29085a = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setCreativeId(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
                this.x = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setExpressViewAcceptedSize(float f2, float f3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
                this.o = f2;
                this.p = f3;
                return this;
            }
            return (Builder) invokeCommon.objValue;
        }

        public Builder setExt(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                this.y = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setExternalABVid(int... iArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, iArr)) == null) {
                this.r = iArr;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setExtraParam(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
                this.m = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setImageAcceptedSize(int i2, int i3) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeII = interceptable.invokeII(1048587, this, i2, i3)) == null) {
                this.f29086b = i2;
                this.f29087c = i3;
                return this;
            }
            return (Builder) invokeII.objValue;
        }

        public Builder setIsAutoPlay(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048588, this, z)) == null) {
                this.q = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setMediaExtra(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
                this.f29093i = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setNativeAdType(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i2)) == null) {
                this.l = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setOrientation(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) {
                this.k = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setPrimeRit(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
                this.t = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setRewardAmount(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i2)) == null) {
                this.f29092h = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setRewardName(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) {
                this.f29091g = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setSupportDeepLink(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048595, this, z)) == null) {
                this.f29088d = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setUserData(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, str)) == null) {
                this.v = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setUserID(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, str)) == null) {
                this.j = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder supportRenderControl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
                this.f29089e = true;
                return this;
            }
            return (Builder) invokeV.objValue;
        }

        public Builder withBid(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, str)) == null) {
                if (TextUtils.isEmpty(str)) {
                    return this;
                }
                k.c("bidding", "AdSlot -> bidAdm=" + b.a(str));
                this.u = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }
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
    }

    public /* synthetic */ AdSlot(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static int getPosition(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65558, null, i2)) == null) {
            if (i2 != 1) {
                if (i2 != 2) {
                    return (i2 == 3 || i2 == 4 || i2 == 7 || i2 == 8) ? 5 : 3;
                }
                return 4;
            }
            return 2;
        }
        return invokeI.intValue;
    }

    public int getAdCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f29081f : invokeV.intValue;
    }

    public String getAdId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.v : (String) invokeV.objValue;
    }

    public int getAdType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.n : invokeV.intValue;
    }

    public int getAdloadSeq() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.s : invokeV.intValue;
    }

    public String getBidAdm() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.u : (String) invokeV.objValue;
    }

    public String getCodeId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f29076a : (String) invokeV.objValue;
    }

    public String getCreativeId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.w : (String) invokeV.objValue;
    }

    public int getDurationSlotType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.p : invokeV.intValue;
    }

    public float getExpressViewAcceptedHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f29080e : invokeV.floatValue;
    }

    public float getExpressViewAcceptedWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f29079d : invokeV.floatValue;
    }

    public String getExt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.x : (String) invokeV.objValue;
    }

    public int[] getExternalABVid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.r : (int[]) invokeV.objValue;
    }

    public int getImgAcceptedHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f29078c : invokeV.intValue;
    }

    public int getImgAcceptedWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f29077b : invokeV.intValue;
    }

    public String getMediaExtra() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.k : (String) invokeV.objValue;
    }

    public int getNativeAdType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.o : invokeV.intValue;
    }

    public int getOrientation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.m : invokeV.intValue;
    }

    public String getPrimeRit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            String str = this.t;
            return str == null ? "" : str;
        }
        return (String) invokeV.objValue;
    }

    public int getRewardAmount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.j : invokeV.intValue;
    }

    public String getRewardName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f29084i : (String) invokeV.objValue;
    }

    public String getUserData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.y : (String) invokeV.objValue;
    }

    public String getUserID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.l : (String) invokeV.objValue;
    }

    public boolean isAutoPlay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.q : invokeV.booleanValue;
    }

    public boolean isSupportDeepLink() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f29082g : invokeV.booleanValue;
    }

    public boolean isSupportRenderConrol() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f29083h : invokeV.booleanValue;
    }

    public void setAdCount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
            this.f29081f = i2;
        }
    }

    public void setDurationSlotType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
            this.p = i2;
        }
    }

    public void setExternalABVid(int... iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, iArr) == null) {
            this.r = iArr;
        }
    }

    public void setNativeAdType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i2) == null) {
            this.o = i2;
        }
    }

    public void setUserData(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, str) == null) {
            this.y = str;
        }
    }

    public JSONObject toJsonObj() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("mCodeId", this.f29076a);
                jSONObject.put("mIsAutoPlay", this.q);
                jSONObject.put("mImgAcceptedWidth", this.f29077b);
                jSONObject.put("mImgAcceptedHeight", this.f29078c);
                jSONObject.put("mExpressViewAcceptedWidth", this.f29079d);
                jSONObject.put("mExpressViewAcceptedHeight", this.f29080e);
                jSONObject.put("mAdCount", this.f29081f);
                jSONObject.put("mSupportDeepLink", this.f29082g);
                jSONObject.put("mSupportRenderControl", this.f29083h);
                jSONObject.put("mRewardName", this.f29084i);
                jSONObject.put("mRewardAmount", this.j);
                jSONObject.put("mMediaExtra", this.k);
                jSONObject.put("mUserID", this.l);
                jSONObject.put("mOrientation", this.m);
                jSONObject.put("mNativeAdType", this.o);
                jSONObject.put("mAdloadSeq", this.s);
                jSONObject.put("mPrimeRit", this.t);
                jSONObject.put("mAdId", this.v);
                jSONObject.put("mCreativeId", this.w);
                jSONObject.put("mExt", this.x);
                jSONObject.put("mBidAdm", this.u);
                jSONObject.put("mUserData", this.y);
            } catch (Exception unused) {
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return "AdSlot{mCodeId='" + this.f29076a + "', mImgAcceptedWidth=" + this.f29077b + ", mImgAcceptedHeight=" + this.f29078c + ", mExpressViewAcceptedWidth=" + this.f29079d + ", mExpressViewAcceptedHeight=" + this.f29080e + ", mAdCount=" + this.f29081f + ", mSupportDeepLink=" + this.f29082g + ", mSupportRenderControl=" + this.f29083h + ", mRewardName='" + this.f29084i + "', mRewardAmount=" + this.j + ", mMediaExtra='" + this.k + "', mUserID='" + this.l + "', mOrientation=" + this.m + ", mNativeAdType=" + this.o + ", mIsAutoPlay=" + this.q + ", mPrimeRit" + this.t + ", mAdloadSeq" + this.s + ", mAdId" + this.v + ", mCreativeId" + this.w + ", mExt" + this.x + ", mUserData" + this.y + '}';
        }
        return (String) invokeV.objValue;
    }
}
