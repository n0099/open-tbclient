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
    public int f53138b;

    /* renamed from: c  reason: collision with root package name */
    public int f53139c;

    /* renamed from: d  reason: collision with root package name */
    public float f53140d;

    /* renamed from: e  reason: collision with root package name */
    public float f53141e;

    /* renamed from: f  reason: collision with root package name */
    public int f53142f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f53143g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f53144h;

    /* renamed from: i  reason: collision with root package name */
    public String f53145i;

    /* renamed from: j  reason: collision with root package name */
    public int f53146j;
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

    /* loaded from: classes2.dex */
    public static class Builder {
        public String A;
        public String B;
        public String a;

        /* renamed from: i  reason: collision with root package name */
        public String f53154i;
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
        public int f53147b = 640;

        /* renamed from: c  reason: collision with root package name */
        public int f53148c = MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP;

        /* renamed from: d  reason: collision with root package name */
        public boolean f53149d = true;

        /* renamed from: e  reason: collision with root package name */
        public boolean f53150e = false;

        /* renamed from: f  reason: collision with root package name */
        public int f53151f = 1;

        /* renamed from: g  reason: collision with root package name */
        public String f53152g = "";

        /* renamed from: h  reason: collision with root package name */
        public int f53153h = 0;

        /* renamed from: j  reason: collision with root package name */
        public String f53155j = "defaultUser";
        public int k = 2;
        public boolean q = true;
        public int w = 1;
        public int x = 0;
        public TTAdLoadType y = TTAdLoadType.UNKNOWN;

        public AdSlot build() {
            AdSlot adSlot = new AdSlot();
            adSlot.a = this.a;
            adSlot.f53142f = this.f53151f;
            adSlot.f53143g = this.f53149d;
            adSlot.f53144h = this.f53150e;
            adSlot.f53138b = this.f53147b;
            adSlot.f53139c = this.f53148c;
            float f2 = this.o;
            if (f2 <= 0.0f) {
                adSlot.f53140d = this.f53147b;
                adSlot.f53141e = this.f53148c;
            } else {
                adSlot.f53140d = f2;
                adSlot.f53141e = this.p;
            }
            adSlot.f53145i = this.f53152g;
            adSlot.f53146j = this.f53153h;
            adSlot.k = this.f53154i;
            adSlot.l = this.f53155j;
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

        public Builder setAdCount(int i2) {
            if (i2 <= 0) {
                i2 = 1;
                d.b(TTAdConstant.TAG, "setAdCount: adCount must greater than 0 ");
            }
            if (i2 > 20) {
                d.b(TTAdConstant.TAG, "setAdCount: adCount must less than or equal to 20 ");
                i2 = 20;
            }
            this.f53151f = i2;
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
            this.f53147b = i2;
            this.f53148c = i3;
            return this;
        }

        public Builder setIsAutoPlay(boolean z) {
            this.q = z;
            return this;
        }

        public Builder setMediaExtra(String str) {
            this.f53154i = str;
            return this;
        }

        public Builder setNativeAdType(int i2) {
            this.l = i2;
            return this;
        }

        public Builder setOrientation(int i2) {
            this.k = i2;
            return this;
        }

        public Builder setPrimeRit(String str) {
            this.t = str;
            return this;
        }

        public Builder setRewardAmount(int i2) {
            this.f53153h = i2;
            return this;
        }

        public Builder setRewardName(String str) {
            this.f53152g = str;
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
            this.f53149d = z;
            return this;
        }

        public Builder setUserData(String str) {
            this.v = str;
            return this;
        }

        public Builder setUserID(String str) {
            this.f53155j = str;
            return this;
        }

        public Builder supportRenderControl() {
            this.f53150e = true;
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
        return this.f53142f;
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
        return this.f53141e;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public float getExpressViewAcceptedWidth() {
        return this.f53140d;
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
        return this.f53139c;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public int getImgAcceptedWidth() {
        return this.f53138b;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public String getMediaExtra() {
        return this.k;
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
        return this.f53146j;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public String getRewardName() {
        return this.f53145i;
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
        return this.f53143g;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public boolean isSupportRenderConrol() {
        return this.f53144h;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public void setAdCount(int i2) {
        this.f53142f = i2;
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
            jSONObject.put("mImgAcceptedWidth", this.f53138b);
            jSONObject.put("mImgAcceptedHeight", this.f53139c);
            jSONObject.put("mExpressViewAcceptedWidth", this.f53140d);
            jSONObject.put("mExpressViewAcceptedHeight", this.f53141e);
            jSONObject.put("mAdCount", this.f53142f);
            jSONObject.put("mSupportDeepLink", this.f53143g);
            jSONObject.put("mSupportRenderControl", this.f53144h);
            jSONObject.put("mRewardName", this.f53145i);
            jSONObject.put("mRewardAmount", this.f53146j);
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

    public String toString() {
        return "AdSlot{mCodeId='" + this.a + ExtendedMessageFormat.QUOTE + ", mImgAcceptedWidth=" + this.f53138b + ", mImgAcceptedHeight=" + this.f53139c + ", mExpressViewAcceptedWidth=" + this.f53140d + ", mExpressViewAcceptedHeight=" + this.f53141e + ", mAdCount=" + this.f53142f + ", mSupportDeepLink=" + this.f53143g + ", mSupportRenderControl=" + this.f53144h + ", mRewardName='" + this.f53145i + ExtendedMessageFormat.QUOTE + ", mRewardAmount=" + this.f53146j + ", mMediaExtra='" + this.k + ExtendedMessageFormat.QUOTE + ", mUserID='" + this.l + ExtendedMessageFormat.QUOTE + ", mOrientation=" + this.m + ", mNativeAdType=" + this.o + ", mIsAutoPlay=" + this.q + ", mPrimeRit" + this.u + ", mAdloadSeq" + this.t + ", mAdId" + this.w + ", mCreativeId" + this.x + ", mExt" + this.y + ", mUserData" + this.z + ", mAdLoadType" + this.A + ", mSplashButtonType=" + this.B + ", mDownloadType=" + this.C + ExtendedMessageFormat.END_FE;
    }

    public AdSlot() {
        this.m = 2;
        this.q = true;
        this.B = 1;
        this.C = 0;
    }
}
