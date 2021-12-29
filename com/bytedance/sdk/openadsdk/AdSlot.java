package com.bytedance.sdk.openadsdk;

import android.support.v4.media.session.MediaSessionCompat;
import com.bytedance.sdk.openadsdk.api.b.d;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AdSlot implements TTAdSlot {
    public TTAdLoadType A;
    public int B;
    public int C;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public int f55235b;

    /* renamed from: c  reason: collision with root package name */
    public int f55236c;

    /* renamed from: d  reason: collision with root package name */
    public float f55237d;

    /* renamed from: e  reason: collision with root package name */
    public float f55238e;

    /* renamed from: f  reason: collision with root package name */
    public int f55239f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f55240g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f55241h;

    /* renamed from: i  reason: collision with root package name */
    public String f55242i;

    /* renamed from: j  reason: collision with root package name */
    public int f55243j;

    /* renamed from: k  reason: collision with root package name */
    public String f55244k;
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

    /* loaded from: classes2.dex */
    public static class Builder {
        public String A;
        public String B;
        public String a;

        /* renamed from: i  reason: collision with root package name */
        public String f55252i;
        public int l;
        public String m;
        public int n;
        public float o;
        public float p;
        public int[] r;
        public int s;
        public String t;
        public String u;
        public String v;
        public String z;

        /* renamed from: b  reason: collision with root package name */
        public int f55245b = 640;

        /* renamed from: c  reason: collision with root package name */
        public int f55246c = MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP;

        /* renamed from: d  reason: collision with root package name */
        public boolean f55247d = true;

        /* renamed from: e  reason: collision with root package name */
        public boolean f55248e = false;

        /* renamed from: f  reason: collision with root package name */
        public int f55249f = 1;

        /* renamed from: g  reason: collision with root package name */
        public String f55250g = "";

        /* renamed from: h  reason: collision with root package name */
        public int f55251h = 0;

        /* renamed from: j  reason: collision with root package name */
        public String f55253j = "defaultUser";

        /* renamed from: k  reason: collision with root package name */
        public int f55254k = 2;
        public boolean q = true;
        public int w = 1;
        public int x = 0;
        public TTAdLoadType y = TTAdLoadType.UNKNOWN;

        public AdSlot build() {
            AdSlot adSlot = new AdSlot();
            adSlot.a = this.a;
            adSlot.f55239f = this.f55249f;
            adSlot.f55240g = this.f55247d;
            adSlot.f55241h = this.f55248e;
            adSlot.f55235b = this.f55245b;
            adSlot.f55236c = this.f55246c;
            float f2 = this.o;
            if (f2 <= 0.0f) {
                adSlot.f55237d = this.f55245b;
                adSlot.f55238e = this.f55246c;
            } else {
                adSlot.f55237d = f2;
                adSlot.f55238e = this.p;
            }
            adSlot.f55242i = this.f55250g;
            adSlot.f55243j = this.f55251h;
            adSlot.f55244k = this.f55252i;
            adSlot.l = this.f55253j;
            adSlot.m = this.f55254k;
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

        public Builder setAdCount(int i2) {
            if (i2 <= 0) {
                i2 = 1;
                d.b(TTAdConstant.TAG, "setAdCount: adCount must greater than 0 ");
            }
            if (i2 > 20) {
                d.b(TTAdConstant.TAG, "setAdCount: adCount must less than or equal to 20 ");
                i2 = 20;
            }
            this.f55249f = i2;
            return this;
        }

        public Builder setAdId(String str) {
            this.z = str;
            return this;
        }

        public Builder setAdLoadType(TTAdLoadType tTAdLoadType) {
            this.y = tTAdLoadType;
            return this;
        }

        public Builder setAdType(int i2) {
            this.n = i2;
            return this;
        }

        public Builder setAdloadSeq(int i2) {
            this.s = i2;
            return this;
        }

        public Builder setCodeId(String str) {
            this.a = str;
            return this;
        }

        public Builder setCreativeId(String str) {
            this.A = str;
            return this;
        }

        public Builder setDownloadType(int i2) {
            if (i2 != 1) {
                i2 = 0;
            }
            this.x = i2;
            return this;
        }

        public Builder setExpressViewAcceptedSize(float f2, float f3) {
            this.o = f2;
            this.p = f3;
            return this;
        }

        public Builder setExt(String str) {
            this.B = str;
            return this;
        }

        public Builder setExternalABVid(int... iArr) {
            this.r = iArr;
            return this;
        }

        public Builder setExtraParam(String str) {
            this.m = str;
            return this;
        }

        public Builder setImageAcceptedSize(int i2, int i3) {
            this.f55245b = i2;
            this.f55246c = i3;
            return this;
        }

        public Builder setIsAutoPlay(boolean z) {
            this.q = z;
            return this;
        }

        public Builder setMediaExtra(String str) {
            this.f55252i = str;
            return this;
        }

        public Builder setNativeAdType(int i2) {
            this.l = i2;
            return this;
        }

        public Builder setOrientation(int i2) {
            this.f55254k = i2;
            return this;
        }

        public Builder setPrimeRit(String str) {
            this.t = str;
            return this;
        }

        public Builder setRewardAmount(int i2) {
            this.f55251h = i2;
            return this;
        }

        public Builder setRewardName(String str) {
            this.f55250g = str;
            return this;
        }

        public Builder setSplashButtonType(int i2) {
            if (i2 != 2) {
                i2 = 1;
            }
            this.w = i2;
            return this;
        }

        public Builder setSupportDeepLink(boolean z) {
            this.f55247d = z;
            return this;
        }

        public Builder setUserData(String str) {
            this.v = str;
            return this;
        }

        public Builder setUserID(String str) {
            this.f55253j = str;
            return this;
        }

        public Builder supportRenderControl() {
            this.f55248e = true;
            return this;
        }

        public Builder withBid(String str) {
            if (str == null) {
                return this;
            }
            this.u = str;
            return this;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public int getAdCount() {
        return this.f55239f;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public String getAdId() {
        return this.w;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public TTAdLoadType getAdLoadType() {
        return this.A;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public int getAdType() {
        return this.n;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public int getAdloadSeq() {
        return this.t;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public String getBidAdm() {
        return this.v;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public String getCodeId() {
        return this.a;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public String getCreativeId() {
        return this.x;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public int getDownloadType() {
        return this.C;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public int getDurationSlotType() {
        return this.p;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public float getExpressViewAcceptedHeight() {
        return this.f55238e;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public float getExpressViewAcceptedWidth() {
        return this.f55237d;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public String getExt() {
        return this.y;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public int[] getExternalABVid() {
        return this.r;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public String getExtraSmartLookParam() {
        return this.s;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public int getImgAcceptedHeight() {
        return this.f55236c;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public int getImgAcceptedWidth() {
        return this.f55235b;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public String getMediaExtra() {
        return this.f55244k;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public int getNativeAdType() {
        return this.o;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public int getOrientation() {
        return this.m;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public String getPrimeRit() {
        String str = this.u;
        return str == null ? "" : str;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public int getRewardAmount() {
        return this.f55243j;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public String getRewardName() {
        return this.f55242i;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public int getSplashButtonType() {
        return this.B;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public String getUserData() {
        return this.z;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public String getUserID() {
        return this.l;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public boolean isAutoPlay() {
        return this.q;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public boolean isSupportDeepLink() {
        return this.f55240g;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public boolean isSupportRenderConrol() {
        return this.f55241h;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public void setAdCount(int i2) {
        this.f55239f = i2;
    }

    public void setAdLoadType(TTAdLoadType tTAdLoadType) {
        this.A = tTAdLoadType;
    }

    public void setDownloadType(int i2) {
        this.C = i2;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public void setDurationSlotType(int i2) {
        this.p = i2;
    }

    public void setExternalABVid(int... iArr) {
        this.r = iArr;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public void setNativeAdType(int i2) {
        this.o = i2;
    }

    public void setSplashButtonType(int i2) {
        this.B = i2;
    }

    public void setUserData(String str) {
        this.z = str;
    }

    public JSONObject toJsonObj() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mCodeId", this.a);
            jSONObject.put("mIsAutoPlay", this.q);
            jSONObject.put("mImgAcceptedWidth", this.f55235b);
            jSONObject.put("mImgAcceptedHeight", this.f55236c);
            jSONObject.put("mExpressViewAcceptedWidth", this.f55237d);
            jSONObject.put("mExpressViewAcceptedHeight", this.f55238e);
            jSONObject.put("mAdCount", this.f55239f);
            jSONObject.put("mSupportDeepLink", this.f55240g);
            jSONObject.put("mSupportRenderControl", this.f55241h);
            jSONObject.put("mRewardName", this.f55242i);
            jSONObject.put("mRewardAmount", this.f55243j);
            jSONObject.put("mMediaExtra", this.f55244k);
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

    public String toString() {
        return "AdSlot{mCodeId='" + this.a + ExtendedMessageFormat.QUOTE + ", mImgAcceptedWidth=" + this.f55235b + ", mImgAcceptedHeight=" + this.f55236c + ", mExpressViewAcceptedWidth=" + this.f55237d + ", mExpressViewAcceptedHeight=" + this.f55238e + ", mAdCount=" + this.f55239f + ", mSupportDeepLink=" + this.f55240g + ", mSupportRenderControl=" + this.f55241h + ", mRewardName='" + this.f55242i + ExtendedMessageFormat.QUOTE + ", mRewardAmount=" + this.f55243j + ", mMediaExtra='" + this.f55244k + ExtendedMessageFormat.QUOTE + ", mUserID='" + this.l + ExtendedMessageFormat.QUOTE + ", mOrientation=" + this.m + ", mNativeAdType=" + this.o + ", mIsAutoPlay=" + this.q + ", mPrimeRit" + this.u + ", mAdloadSeq" + this.t + ", mAdId" + this.w + ", mCreativeId" + this.x + ", mExt" + this.y + ", mUserData" + this.z + ", mAdLoadType" + this.A + ", mSplashButtonType=" + this.B + ", mDownloadType=" + this.C + ExtendedMessageFormat.END_FE;
    }

    public AdSlot() {
        this.m = 2;
        this.q = true;
        this.B = 1;
        this.C = 0;
    }
}
