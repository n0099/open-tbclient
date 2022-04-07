package com.bytedance.sdk.openadsdk;

import android.support.v4.media.session.MediaSessionCompat;
import com.bytedance.sdk.openadsdk.api.b.d;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AdSlot implements TTAdSlot {
    public TTAdLoadType A;
    public int B;
    public int C;
    public String a;
    public int b;
    public int c;
    public float d;
    public float e;
    public int f;
    public boolean g;
    public boolean h;
    public String i;
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

    /* loaded from: classes4.dex */
    public static class Builder {
        public String A;
        public String B;
        public String a;
        public String i;
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
        public int b = 640;
        public int c = MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP;
        public boolean d = true;
        public boolean e = false;
        public int f = 1;
        public String g = "";
        public int h = 0;
        public String j = "defaultUser";
        public int k = 2;
        public boolean q = true;
        public int w = 1;
        public int x = 0;
        public TTAdLoadType y = TTAdLoadType.UNKNOWN;

        public AdSlot build() {
            AdSlot adSlot = new AdSlot();
            adSlot.a = this.a;
            adSlot.f = this.f;
            adSlot.g = this.d;
            adSlot.h = this.e;
            adSlot.b = this.b;
            adSlot.c = this.c;
            float f = this.o;
            if (f <= 0.0f) {
                adSlot.d = this.b;
                adSlot.e = this.c;
            } else {
                adSlot.d = f;
                adSlot.e = this.p;
            }
            adSlot.i = this.g;
            adSlot.j = this.h;
            adSlot.k = this.i;
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

        public Builder setAdCount(int i) {
            if (i <= 0) {
                i = 1;
                d.b(TTAdConstant.TAG, "setAdCount: adCount must greater than 0 ");
            }
            if (i > 20) {
                d.b(TTAdConstant.TAG, "setAdCount: adCount must less than or equal to 20 ");
                i = 20;
            }
            this.f = i;
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

        public Builder setAdType(int i) {
            this.n = i;
            return this;
        }

        public Builder setAdloadSeq(int i) {
            this.s = i;
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

        public Builder setDownloadType(int i) {
            if (i != 1) {
                i = 0;
            }
            this.x = i;
            return this;
        }

        public Builder setExpressViewAcceptedSize(float f, float f2) {
            this.o = f;
            this.p = f2;
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

        public Builder setImageAcceptedSize(int i, int i2) {
            this.b = i;
            this.c = i2;
            return this;
        }

        public Builder setIsAutoPlay(boolean z) {
            this.q = z;
            return this;
        }

        public Builder setMediaExtra(String str) {
            this.i = str;
            return this;
        }

        public Builder setNativeAdType(int i) {
            this.l = i;
            return this;
        }

        public Builder setOrientation(int i) {
            this.k = i;
            return this;
        }

        public Builder setPrimeRit(String str) {
            this.t = str;
            return this;
        }

        public Builder setRewardAmount(int i) {
            this.h = i;
            return this;
        }

        public Builder setRewardName(String str) {
            this.g = str;
            return this;
        }

        public Builder setSplashButtonType(int i) {
            if (i != 2) {
                i = 1;
            }
            this.w = i;
            return this;
        }

        public Builder setSupportDeepLink(boolean z) {
            this.d = z;
            return this;
        }

        public Builder setUserData(String str) {
            this.v = str;
            return this;
        }

        public Builder setUserID(String str) {
            this.j = str;
            return this;
        }

        public Builder supportRenderControl() {
            this.e = true;
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
        return this.f;
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
        return this.e;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public float getExpressViewAcceptedWidth() {
        return this.d;
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
        return this.c;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public int getImgAcceptedWidth() {
        return this.b;
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
        return this.j;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public String getRewardName() {
        return this.i;
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
        return this.g;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public boolean isSupportRenderConrol() {
        return this.h;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public void setAdCount(int i) {
        this.f = i;
    }

    public void setAdLoadType(TTAdLoadType tTAdLoadType) {
        this.A = tTAdLoadType;
    }

    public void setDownloadType(int i) {
        this.C = i;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public void setDurationSlotType(int i) {
        this.p = i;
    }

    public void setExternalABVid(int... iArr) {
        this.r = iArr;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public void setNativeAdType(int i) {
        this.o = i;
    }

    public void setSplashButtonType(int i) {
        this.B = i;
    }

    public void setUserData(String str) {
        this.z = str;
    }

    public JSONObject toJsonObj() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mCodeId", this.a);
            jSONObject.put("mIsAutoPlay", this.q);
            jSONObject.put("mImgAcceptedWidth", this.b);
            jSONObject.put("mImgAcceptedHeight", this.c);
            jSONObject.put("mExpressViewAcceptedWidth", this.d);
            jSONObject.put("mExpressViewAcceptedHeight", this.e);
            jSONObject.put("mAdCount", this.f);
            jSONObject.put("mSupportDeepLink", this.g);
            jSONObject.put("mSupportRenderControl", this.h);
            jSONObject.put("mRewardName", this.i);
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

    public String toString() {
        return "AdSlot{mCodeId='" + this.a + "', mImgAcceptedWidth=" + this.b + ", mImgAcceptedHeight=" + this.c + ", mExpressViewAcceptedWidth=" + this.d + ", mExpressViewAcceptedHeight=" + this.e + ", mAdCount=" + this.f + ", mSupportDeepLink=" + this.g + ", mSupportRenderControl=" + this.h + ", mRewardName='" + this.i + "', mRewardAmount=" + this.j + ", mMediaExtra='" + this.k + "', mUserID='" + this.l + "', mOrientation=" + this.m + ", mNativeAdType=" + this.o + ", mIsAutoPlay=" + this.q + ", mPrimeRit" + this.u + ", mAdloadSeq" + this.t + ", mAdId" + this.w + ", mCreativeId" + this.x + ", mExt" + this.y + ", mUserData" + this.z + ", mAdLoadType" + this.A + ", mSplashButtonType=" + this.B + ", mDownloadType=" + this.C + '}';
    }

    public AdSlot() {
        this.m = 2;
        this.q = true;
        this.B = 1;
        this.C = 0;
    }
}
